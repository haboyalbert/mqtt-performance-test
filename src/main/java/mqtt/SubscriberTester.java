package mqtt;

import java.security.SecureRandom;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SubscriberTester {

	public static void main(String[] args) throws MqttException {

		final String topic = args[0];
		int qos = 0;
		final String broker = "ssl://" + args[1];
		// final MemoryPersistence persistence = new MemoryPersistence();
		final SecureRandom secureRandom = new SecureRandom();
		int threads = Integer.parseInt(args[2]);
		for (int i = 0; i < threads; i++) {
			new Thread() {
				public void run() {
					try {
						MqttClient sampleClient = new MqttClient(broker, "" + secureRandom.nextInt(1000000));
						MqttConnectOptions connOpts = new MqttConnectOptions();
						connOpts.setCleanSession(false);

						connOpts.setConnectionTimeout(300000);
						SimpleCallbackHandler simpleCallbackHandler = new SimpleCallbackHandler();
						sampleClient.setCallback(simpleCallbackHandler);
						sampleClient.connect(connOpts);
						sampleClient.subscribe(topic, 2);
						//
						// 注册接收消息方法
						// System.out.println("Connecting to broker: " +
						// broker);
						// sampleClient.connect(connOpts);
						// System.out.println("Connected");
						// MqttMessage message = new
						// MqttMessage(content.getBytes());
						// message.setQos(2);
						// double count = 0;
						// long start = System.currentTimeMillis();
						// while (true) {
						// sampleClient.publish(topic, message);
						// // sampleClient.subscribe(topic, 0);// 订阅接主题
						// try {
						// count++;
						// Thread.sleep(1);
						// } catch (InterruptedException e) {
						// // TODO Auto-generated catch block
						// e.printStackTrace();
						// }
						// System.out.println("Publishing message" +
						// sampleClient + " speed: "
						// + (count * 1000) / (System.currentTimeMillis() -
						// start) + " payload length:" +
						// content.getBytes().length);
						// }
					} catch (

					MqttException me) {
						System.out.println("reason " + me.getReasonCode());
						System.out.println("msg " + me.getMessage());
						System.out.println("loc " + me.getLocalizedMessage());
						System.out.println("cause " + me.getCause());
						System.out.println("excep " + me);
						me.printStackTrace();
					}
				}

			}.start();
			// sampleClient.disconnect();
			// System.out.println("Disconnected");
			// System.exit(0);

		}
	}

	final static class SimpleCallbackHandler implements MqttCallback {

		public void connectionLost(Throwable cause) {
			System.out.println("客户机和broker已经断开" + cause.getMessage());

		}

		public void messageArrived(String topic, MqttMessage message) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("消息数据: " + Thread.currentThread() + message);

		}

		public void deliveryComplete(IMqttDeliveryToken token) {

		}

	}
}
