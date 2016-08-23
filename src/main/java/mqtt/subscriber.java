package mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class subscriber {

	public static void main(String[] args) throws MqttException {

		String topic = " bench/%i";
		String content = "Message from MqttPublishSample";
		int qos = 2;
		String broker = "tcp://10.252.0.247:1883";
		String clientId = "JavaSample";
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			// for (int i = 0; i < 20 * 10000; i++) {
			MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			// connOpts.setConnectionTimeout(30000);
			SimpleCallbackHandler simpleCallbackHandler = new SimpleCallbackHandler();
			sampleClient.setCallback(simpleCallbackHandler);// 注册接收消息方法
			// System.out.println("Connecting to broker: " + broker);
			sampleClient.connect(connOpts);
			// System.out.println("Connected");
			// System.out.println("Publishing message"+ i +": " + content);
			// MqttMessage message = new MqttMessage(content.getBytes());
			// message.setQos(qos);
			// sampleClient.publish(topic, message);
			sampleClient.subscribe(topic, 0);// 订阅接主题

			// }
			// sampleClient.disconnect();
			// System.out.println("Disconnected");
			// System.exit(0);
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

	static class SimpleCallbackHandler implements MqttCallback {

		public void connectionLost(Throwable cause) {
			System.out.println("客户机和broker已经断开" + cause.getMessage());

		}

		public void messageArrived(String topic, MqttMessage message) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("订阅主题: " + topic);
			System.out.println("消息数据: " + message);

		}

		public void deliveryComplete(IMqttDeliveryToken token) {

		}

	}

}
