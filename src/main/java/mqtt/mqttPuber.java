package mqtt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base64;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class mqttPuber {

	public static String read(String filePath) throws FileNotFoundException, IOException {
		StringBuffer txtContent;
		byte b[];
		InputStream in;
		txtContent = new StringBuffer();
		b = new byte[8192];
		in = null;
		for (in = new FileInputStream(filePath); in.read(b) != -1; txtContent.append(new String(b)))
			;
		in.close();
		return txtContent.toString();
	}

	public static byte[] decoderBase64File(String file) throws Exception {
		byte decoded[] = Base64.decodeBase64(read(file));
		return decoded;
	}

	public static void main(final String[] args) throws Exception {

		final String topic = args[0];
		// decode using apache command codec base64
		final byte[] content = decoderBase64File(args[5]);
		// broker url
		final String broker = args[1];
		// final String clientId = "client";
		final MemoryPersistence persistence = new MemoryPersistence();
		// random clientId
		final SecureRandom secureRandom = new SecureRandom();
		// thread number
		final int threads = Integer.parseInt(args[2]);

		for (int i = 0; i < threads; i++) {
			new Thread() {

				public void run() {
					try {
						// MqttClient sampleClient = new MqttClient(broker, "" +
						// secureRandom.nextInt(1000000), persistence);
						MqttClient sampleClient = new MqttClient(broker, "" + secureRandom.nextInt(1000000));
						MqttConnectOptions connOpts = new MqttConnectOptions();
						connOpts.setCleanSession(false);

						// wait until work
						connOpts.setConnectionTimeout(0);

						// 注册接收消息方法
						sampleClient.connect(connOpts);
						MqttMessage message = new MqttMessage(content);
						// most low efficient and reliable
						message.setQos(2);
						// persistent msg
						message.setRetained(true);
						double count = 0;
						long start = System.currentTimeMillis();
						while (true) {
							sampleClient.publish(topic, message.getPayload(), 2, true);
							count++;
							if (args.length > 4) {
								int limit = Integer.parseInt(args[4]);
								while (((count * 1000) / (System.currentTimeMillis() - start + 1)) * threads > limit) {
									Thread.currentThread().sleep(7);
								}
							}

							if (count % (Integer.parseInt(args[3])) == 0)
								System.out.println(" Publishing message length:" + sampleClient + " speed: "
										+ (count * 1000) / (System.currentTimeMillis() - start + 1) + "/s payload length:" + content.length);
						}
					} catch (

					MqttException me) {
						System.out.println("TID " + Thread.currentThread());
						System.out.println("reason " + me.getReasonCode());
						System.out.println("msg " + me.getMessage());
						System.out.println("loc " + me.getLocalizedMessage());
						System.out.println("cause " + me.getCause());
						System.out.println("excep " + me);
						me.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}.start();

		}

	}
}
