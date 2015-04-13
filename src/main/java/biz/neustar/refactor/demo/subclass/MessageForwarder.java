package biz.neustar.refactor.demo.subclass;

public class MessageForwarder {
	private Message createForwardMessage(Session session, Message message) {
		MimeMessage forward = new MimeMessage(session);
		return forward;
	}

}
