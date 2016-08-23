package mqtt;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.security.SecureRandom;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class connectionTester {
	public static final int getProcessID() {
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		// System.out.println(runtimeMXBean.getName());
		return Integer.valueOf(runtimeMXBean.getName().split("@")[0]).intValue();
	}

	public static void main(final String[] args) throws MqttException {

		final String topic = args[0];
		// final String content = "";
		final String content = "\fP1K622048000\u0012\b\b\u0010\u0018\u01A7*\"\u0011\b\u0001\u0010\b(60\u000183@H\u0003\"\u0011\b\u0001\u0010\u0007(70\u000183@H\u0003\"\u0011\b\u0001\u0010\b(40\u000180@H\u04FB\u0003\"\u0011\b\u0001\u0010\u0001(70\u000282@H\u00F8\u0003\"\u0011\b\u0001\u0010\u000B(40\u000180@H\u036B\u0003\"\u0011\b\u0001\u0010\u0006(:0\u000285@H\u0003\"\u0010\b\u0001\u0010I(40\t8)@H\u0003\"\u0011\b\u0001\u0010\u0004(50\u000182@H\u0003\"\u0011\b\u0001\u0010\r\n(90\u000185@H\u0003\"\u0011\b\u0001\u0010\u0001(4082@H\u0003\"\u0011\b\u0001\u0010\u0006(40\u000180@H\u0003\"\u0011\b\u0001\u0010\u0007(50\u000181@H\u0002\"\u0011\b\u0001\u0010\b(60\u000282@H\u0002\"\u0010\b\u0001\u0010w(7085@H\u0002\"\u0011\b\u0001\u0010\t(90\u000186@H\u0002\"\u0011\b\u0001\u0010\u0002(B0\u000689@H\u0002\"\u0011\b\u0001\u0010\u000B(;0\u000286@H\u0002\"\u0010\b\u0001\u0010K(20\u00028.@H\u0002\"\u0011\b\u0001\u0010\u0005(30\u000180@H\u0002\"\u0011\b\u0001\u0010\t(40\u000180@H\u0002\"\u0011\b\u0001\u0010\u0002(20\u00018-@H\u0002\"\u0011\b\u0001\u0010\f(50\u000282@H\u0002\"\u0011\b\u0001\u0010\b(50\u000181@H\u0002\"\u0010\b\u0001\u0010K(8087@H\u0002\"\u0011\b\u0001\u0010\u0004(50\u000182@H\u0002\"\u0011\b\u0001\u0010\u0003(60\u000182@H\u028E\u0002\"\u0011\b\u0001\u0010\u000B(/0\u00018,@H\u0002\"\u0011\b\u0001\u0010\u0004(20\u000180@H\u0001\"\u0011\b\u0001\u0010\u0001(3081@H\u0001\"\u0011\b\u0001\u0010\t(40\u000180@H\u0001\"\u0011\b\u0001\u0010\t(50\u000181@H\u0001\"\u0011\b\u0001\u0010\u0007(50\u000182@H\u0001\"\u0010\b\u0001\u0010L(9086@H\u0001\"\u0011\b\u0001\u0010\b(40\u000181@H\u0001\"\u0011\b\u0001\u0010\u0004(40\u000180@H\u0001\"\u0011\b\u0001\u0010\u0001(50\u000182@H\u0001\"\u0011\b\u0001\u0010\f(10\u00018-@H\u0001\"\u0010\b\u0001\u0010X(<0\u000286@H\u0001\"\u0011\b\u0001\u0010\u0005(40\u00028/@H\u0001\"\u0011\b\u0001\u0010\t(:0\u000186@H\u0001\"\u0011\b\u0001\u0010\u0006(40\u000180@H\u0001\"\u0011\b\u0001\u0010\u0003(60\u000182@H\u0001\"\u0011\b\u0001\u0010\u0004(80\u000184@H\u0001\"\u0010\b\u0001\u0010\t(70\u000183@H~\"\u0010\b\u0001\u0010\u0002(<0\u000385@Hz\"\u0010\b\u0001\u0010\u0006(50\u00038/@Hr\"\u0010\b\u0001\u0010\r\n(60\u000182@Hc\"\u0010\b\u0001\u0010\u0004(40\u000180@H]\"\u000F\b\u0001\u0010K(4081@HZ\"\u0010\b\u0001\u0010\t(10\u00018-@HO\"\u0010\b\u0001\u0010\u0006(50\u000181@HG\"\u0010\b\u0001\u0010\u0006(10\u00018.@H>\"\u0010\b\u0001\u0010\u0001(80\u000186@H<\"\u0010\b\u0001\u0010\u0006(80\u000383@H4\"\u0010\b\u0001\u0010\t(80\u000184@H(\"\u0010\b\u0001\u0010\u0002(00\u00018,@H$\"\u0010\b\u0001\u0010\u000B(60\u000182@H\u0017\"\u000F\b\u0001\u0010J(008-@H\u0014\"\u0010\b\u0001\u0010\u0005(10\u00018.@H\r\n\"\u0010\b\u0001\u0010\t(30\u00028/@H\u0001\u0012\b\b\u0001\u0010\u0018\u01A7*\"\u0011\b(\u0010\b(\u000408\u0004@H\u0003\"\u0011\b(\u0010\u0006(\u000408\u0003@H\u0003\"\u0011\b(\u0010\u0001(\u000308\u0003@H\u0003\"\u0011\b(\u0010\u0006(\u000408\u0004@H\u0677\u0003\"\u0011\b(\u0010\u0004(\u000408\u0004@H\u0530\u0003\"\u0011\b(\u0010\u0005(\u000408\u0004@H\u0003\"\u0011\b(\u0010\u0006(\u000408\u0004@H\u0003\"\u0011\b(\u0010\u0003(\u000308\u0003@H\u0003\"\u0011\b(\u0010\u0003(\u000408\u0004@H\u0003\"\u0011\b(\u0010\u0007(\u000408\u0003@H\u0003\"\u0011\b(\u0010\u0007(\u000508\u0005@H\u0003\"\u0011\b(\u0010\u0005(\u000408\u0004@H\u0002\"\u0011\b(\u0010\u0001(\u000408\u0004@H\u0002\"\u0011\b(\u0010\u0006(\u000508\u0004@H\u0002\"\u0011\b(\u0010\u0003(\u000408\u0004@H\u0002\"\u0011\b(\u0010\t(\u000308\u0003@H\u0002\"\u0011\b(\u0010\u0003(\u000408\u0003@H\u0002\"\u0011\b(\u0010\u0006(\u000308\u0003@H\u0002\"\u0011\b(\u0010\u0005(\u000408\u0004@H\u0002\"\u0011\b(\u0010\u0003(\u000308\u0003@H\u0002\"\u0011\b(\u0010\u000F(\u000308\u0003@H\u0002\"\u0011\b(\u0010\u0004(\u000408\u0004@H\u07A5\u0002\"\u0011\b(\u0010\u0001(\u000508\u0004@H\u0002\"\u0011\b(\u0010\u0006(\u000508\u0004@H\u0002\"\u0011\b(\u0010\u0003(\u000408\u0004@H\u0413\u0002\"\u0011\b(\u0010\u0005(\u000508\u0004@H\u0002\"\u0011\b(\u0010\u0003(\u000508\u0005@H\u0002\"\u0011\b(\u0010\u0003(\u000608\u0005@H\u0001\"\u0011\b(\u0010\u0007(\u000608\u0005@H\u0001\"\u0011\b(\u0010\u0003(\u000408\u0004@H\u0001\"\u0011\b(\u0010\b(\u000408\u0003@H\u0001\"\u0011\b(\u0010\u0007(\u000308\u0003@H\u0001\"\u0011\b(\u0010\u0005(\u000408\u0004@H\u0001\"\u0011\b(\u0010\u0001(\u000408\u0003@H\u0001\"\u0011\b(\u0010\u0003(\u000308\u0002@H\u0001\"\u0011\b(\u0010\u0006(\u000408\u0003@H\u05BF\u0001\"\u0011\b(\u0010\u0004(\u000408\u0004@H\u04F8\u0001\"\u0011\b(\u0010\u0007(\u000508\u0004@H\u0001\"\u0011\b(\u0010\u0004(\u000608\u0006@H\u0001\"\u0011\b(\u0010\u0003(\u000408\u0004@H\u0001\"\u0011\b(\u0010\u0005(\u000408\u0003@H\u0001\"\u0011\b(\u0010\t(\u000408\u0004@H\u0001\"\u0011\b(\u0010\u0003(\u000408\u0003@H\u0348\u0001\"\u0011\b(\u0010\u0002(\u000408\u0004@H\u00C3\u0001\"\u0010\b(\u0010\u0007(\u000408\u0003@Hy\"\u0010\b(\u0010\u0005(\u000408\u0004@Hq\"\u0010\b(\u0010\u0006(\u000408\u0004@Hh\"\u0010\b(\u0010\u0003(\u000408\u0004@Hb\"\u0010\b(\u0010\u0006(\u000408\u0004@HY\"\u0010\b(\u0010\u0002(\u000408\u0004@HT\"\u0010\b(\u0010\u0005(\u000408\u0004@HL\"\u0010\b(\u0010\u0006(\u000408\u0004@HC\"\u0010\b(\u0010\u0006(\u000408\u0004@H:\"\u0010\b(\u0010\u0005(\u000408\u0004@H3\"\u0010\b(\u0010\u0003(\u000408\u0004@H-\"\u0010\b(\u0010\u0007(\u000408\u0004@H#\"\u0010\b(\u0010\u0004(\u000408\u0004@H\u001C\"\u0010\b(\u0010\u0006(\u000408\u0004@H\u0013\"\u0010\b(\u0010\u0005(\u000408\u0004@H\u000B\"\u0010\b(\u0010\u0003(\u000408\u0004@H\u0006:\u0010\b\u0010\u0018\u01A7*\"'\r\n\u001138:3B:C8:CC:07:5A\u0012\r\n1021 Divis\u0018\u0016 (\u00010\u0001\"#\r\n\u001194:CC:B9:90:76:90\u0012\u0006ATT728\u0018\f (\u00010\u0001\"&\r\n\u0011CC:35:40:D4:C1:8F\u0012\tHOME-C18F\u0018\u0016 (\u00010\u0001\"\"\r\n\u001114:22:DB:08:78:E6\u0012\u0005willy\u0018\u0013 (\u00030\u0001\"\u001D\r\n\u001114:22:DB:08:78:E4\u0012\u0018\u0013 (\u00030\u0001\"*\r\n\u001198:FC:11:CF:31:E9\u0012\r\nPato En Fuego\u0018\r\n (\u00010\u0001\"&\r\n\u001198:6B:3D:9C:4C:D0\u0012\tHOME-4CD2\u0018\u001A (\u00010\u0001\"\u001D\r\n\u001192:6B:3D:9C:4C:D0\u0012\u0018\u0019 (\u00010\u0001\"\u001D\r\n\u0011CE:35:40:D4:C1:80\u0012\u0018\u0017 (\u00010\u0001\"*\r\n\u001116:0D:7F:49:E7:FF\u0012\r\nNETGEAR76_EXT\u0018\r\n (\u00010\u0001\"&\r\n\u0011C4:04:15:4C:D9:0F\u0012\tNETGEAR76\u0018\u0013 (\u00010\u0001\"\u001D\r\n\u001142:05:2A:3F:F4:BB\u0012\u0018\" (\u00010\u0001\"+\r\n\u0011B0:7F:B9:3B:46:81\u0012\u000E1021 Divis_EXT\u0018\r\n (\u00010\u0001\")\r\n\u001152:05:2A:3F:F4:BB\u0012\f\uD83C\uDF46\uD83C\uDF46\uD83C\uDF46\u0018# (\u00010\u0001\"\u001D\r\n\u001142:05:2A:3F:F3:07\u0012\u0018/ (\u00010\u0001\"\u001D\r\n\u001146:32:C8:28:21:33\u0012\u0018\u0007 (\u00010\u0001\"\u001D\r\n\u001142:05:2A:3F:F5:53\u0012\u0018  (\u00010\u0001\"\u001D\r\n\u001142:05:2A:50:88:C1\u0012\u0018( (\u00010\u0001\"\u001D\r\n\u001142:05:2A:3F:F4:D3\u0012\u0018! (\u00010\u0001\"\u001D\r\n\u001192:C7:92:27:2A:50\u0012\u0018\r\n (\u00010\u0001\"\u001D\r\n\u001112:86:8C:49:BD:D2\u0012\u0018\u0006 (\u00010\u0001\"\u001D\r\n\u0011D8:97:BA:CF:87:49\u0012\u0018\u0007 (\u00010\u0001\"&\r\n\u0011F8:ED:A5:C1:6D:F0\u0012\tHOME-6DF2\u0018\u000B (\u00010\u0001\"\u001D\r\n\u001132:86:8C:73:BC:22\u0012\u0018\b (\u00010\u0001\"&\r\n\u001144:32:C8:28:21:32\u0012\tHOME-2132\u0018\u0007 (\u00010\u0001\"&\r\n\u001110:86:8C:49:BD:D2\u0012\tEvenYears\u0018\u0007 (\u00010\u0001\"-\r\n\u001110:86:8C:73:BC:22\u0012\u0010Haus_of_Whitmore\u0018\u0007 (\u00010\u0001\"&\r\n\u001190:C7:92:27:2A:50\u0012\tHOME-2A52\u0018\r\n (\u00010\u0001\"\u001D\r\n\u001132:86:8C:49:BD:D2\u0012\u0018\u0007 (\u00010\u0001\"$\r\n\u0011D8:97:BA:CF:87:48\u0012\u0007JOHNBAR\u0018\u0005 (\u00010\u0001\")\r\n\u001152:05:2A:3F:F3:07\u0012\f\uD83C\uDF46\uD83C\uDF46\uD83C\uDF46\u0018- (\u00010\u0001\")\r\n\u001152:05:2A:3F:F5:53\u0012\f\uD83C\uDF46\uD83C\uDF46\uD83C\uDF46\u0018! (\u00010\u0001\")\r\n\u001152:05:2A:3F:F4:D3\u0012\f\uD83C\uDF46\uD83C\uDF46\uD83C\uDF46\u0018! (\u00010\u0001\")\r\n\u001152:05:2A:50:88:C1\u0012\f\uD83C\uDF46\uD83C\uDF46\uD83C\uDF46\u0018) (\u00010\u0001\"\u001D\r\n\u001112:86:8C:73:BC:22\u0012\u0018\b (\u00010\u0001\"\u001D\r\n\u0011F2:ED:A5:C1:6D:F0\u0012\u0018\r\n (\u00010\u0001\"&\r\n\u001144:32:C8:89:4D:8C\u0012\tHOME-4D8C\u0018\u0006 (\u00010\u0001\"&\r\n\u0011FC:51:A4:15:53:CF\u0012\tMaccio-IM\u0018\u0007 (\u00010\u0001\",\r\n\u00112C:30:33:E5:0C:59\u0012\u000FNETGEAR76_2GEXT\u0018\r\n (\u00010\u0001\"\u001D\r\n\u0011FE:51:A4:15:53:CF\u0012\u0018\u0007 (\u00010\u0001\"\u001D\r\n\u00111E:51:A4:15:53:CF\u0012\u0018\u0006 (\u00010\u0001\"(\r\n\u0011CE:35:40:D4:C1:81\u0012\u000Bxfinitywifi\u0018\u0017 (\u00010\u0001\"(\r\n\u001196:6B:3D:9C:4C:D0\u0012\u000Bxfinitywifi\u0018\u0019 (\u00010\u0001\"(\r\n\u001146:32:C8:28:21:34\u0012\u000Bxfinitywifi\u0018\u0007 (\u00010\u0001\"(\r\n\u0011D8:97:BA:CF:87:4A\u0012\u000Bxfinitywifi\u0018\u0006 (\u00010\u0001\"(\r\n\u001122:86:8C:49:BD:D2\u0012\u000Bxfinitywifi\u0018\u0007 (\u00010\u0001\"\u001D\r\n\u001114:22:DB:08:78:E8\u0012\u0018\u0012 (\u00030\u0001\"(\r\n\u0011F6:ED:A5:C1:6D:F0\u0012\u000Bxfinitywifi\u0018\b (\u00010\u0001\",\r\n\u001100:18:0A:50:1A:02\u0012\u000Fmeraki-scanning\u0018\u000E (\u00010\u0001\"(\r\n\u001122:86:8C:73:BC:22\u0012\u000Bxfinitywifi\u0018\b (\u00010\u0001\"\u001D\r\n\u001146:32:C8:89:4D:8D\u0012\u0018\b (\u00010\u0001\"\u001D\r\n\u00115E:8F:E0:4C:AB:FC\u0012\u0018\t (\u00010\u0001\"\u001D\r\n\u00117E:8F:E0:4C:AB:FC\u0012\u0018\u000B (\u00010\u0001\"(\r\n\u001146:32:C8:89:4D:8E\u0012\u000Bxfinitywifi\u0018\u0007 (\u00010\u0001\"(\r\n\u001100:71:C2:AD:C5:62\u0012\u000Bxfinitywifi\u0018\u0005 (\u00010\u0001:\u0003\b\u0001\u0010\u0018\u01A7*\"/\r\n\u001142:05:2A:3F:F4:BC\u0012\u0012we.piranha.dogfood\u0018( (\u00050(\")\r\n\u001152:05:2A:3F:F4:BC\u0012\f\uD83C\uDF46\uD83C\uDF46\uD83C\uDF46\u0018( (\u00050(\"\u001D\r\n\u001142:05:2A:3F:F3:08\u0012\u00183 (\u00050(\"\u001D\r\n\u001142:05:2A:3F:F4:D4\u0012\u0018\u001D (\u00050(\"\u001D\r\n\u001142:05:2A:50:88:C2\u0012\u00181 (\u00050(\"\u001D\r\n\u001142:05:2A:3F:F5:54\u0012\u0018) (\u00050(\")\r\n\u001152:05:2A:3F:F3:08\u0012\f\uD83C\uDF46\uD83C\uDF46\uD83C\uDF46\u00183 (\u00050(\")\r\n\u001152:05:2A:3F:F4:D4\u0012\f\uD83C\uDF46\uD83C\uDF46\uD83C\uDF46\u0018\u001D (\u00050(\")\r\n\u001152:05:2A:50:88:C2\u0012\f\uD83C\uDF46\uD83C\uDF46\uD83C\uDF46\u00181 (\u00050(\")\r\n\u001152:05:2A:3F:F5:54\u0012\f\uD83C\uDF46\uD83C\uDF46\uD83C\uDF46\u0018) (\u00050(B\t\b\u0010\u01A7*B\t\b\u0001\u0010\u01A7*";

		int qos = 0;
		final String broker = "ssl://" + args[1];
		final String clientId = "client";
		final MemoryPersistence persistence = new MemoryPersistence();
		final SecureRandom secureRandom = new SecureRandom();
		final int threads = Integer.parseInt(args[2]);
		for (int i = 0; i < threads; i++) {
			new Thread() {
				int pid = getProcessID();

				public void run() {
					try {
						MqttClient sampleClient = new MqttClient(broker, "" + secureRandom.nextInt(1000000), persistence);
						MqttConnectOptions connOpts = new MqttConnectOptions();
						connOpts.setCleanSession(false);
						connOpts.setConnectionTimeout(300000);
						// SimpleCallbackHandler simpleCallbackHandler = new
						// SimpleCallbackHandler();
						// sampleClient.setCallback(simpleCallbackHandler);//
						// 注册接收消息方法
						sampleClient.connect(connOpts);
						// System.out.println("Connected");
						MqttMessage message = new MqttMessage(content.getBytes());
						message.setQos(2);
						message.setRetained(true);
						double count = 0;
						long start = System.currentTimeMillis();
						while (true) {
							sampleClient.publish(topic, message.getPayload(), 2, true);
							// System.out.println(message.getPayload().length);
							// sampleClient.subscribe(topic, 0);// 订阅接主题
							// try {
							count++;
							// Thread.sleep(1);
							// } catch (InterruptedException e) {
							// // TODO Auto-generated catch block
							// e.printStackTrace();
							// }
							if (args.length > 4) {
								int limit = Integer.parseInt(args[4]);
								while (((count * 1000) / (System.currentTimeMillis() - start + 1)) * threads > limit) {
									// System.err.println(((count * 1000) /
									// (System.currentTimeMillis() - start + 1))
									// * threads);
									Thread.currentThread().sleep(7);

								}
							}

							if (count % (Integer.parseInt(args[3])) == 0)
								System.out.println("Pid:" + pid + " Publishing message length:" + sampleClient + " speed: "
										+ (count * 1000) / (System.currentTimeMillis() - start + 1) + "/s payload length:"
										+ content.getBytes().length);
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}.start();
			// sampleClient.disconnect();
			// System.out.println("Disconnected");
			// System.exit(0);

		}

		// static class SimpleCallbackHandler implements MqttCallback {
		//
		// public void connectionLost(Throwable cause) {
		// System.out.println("客户机和broker已经断开" + cause.getMessage());
		//
		// }
		//
		// public void messageArrived(String topic, MqttMessage message) throws
		// Exception {
		// // TODO Auto-generated method stub
		// System.out.println("订阅主题: " + topic);
		// System.out.println("消息数据: " + message);
		//
		// }
		//
		// public void deliveryComplete(IMqttDeliveryToken token) {
		//
		// }
		//
		// }
	}
}
