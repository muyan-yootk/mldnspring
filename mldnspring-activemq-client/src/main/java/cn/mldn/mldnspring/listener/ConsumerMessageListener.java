package cn.mldn.mldnspring.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
 
import org.springframework.stereotype.Component;
@Component
public class ConsumerMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) { 
		if (message instanceof TextMessage) {	// 文本消息
			TextMessage textMsg = (TextMessage) message ;
			try {
				System.out.println(textMsg.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
