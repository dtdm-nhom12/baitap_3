package org.next;

import java.io.IOException;
import javax.servlet.http.*;
import com.google.appengine.api.xmpp.*;
//Other imports
public class KkkServlet extends HttpServlet {
public void doPost(HttpServletRequest req, HttpServletResponse resp)
throws IOException
{
//get the incoming message from the Request object i.e. req
//interpret it and compose a response
//send the response message back
	XMPPService xmpp = XMPPServiceFactory.getXMPPService();
	Message msg = xmpp.parseMessage(req);
	JID fromJid = msg.getFromJid();
	String body = msg.getBody();
	Message replyMessage = new MessageBuilder()
			.withRecipientJids("JABBER_ID_OF_RECIPIENT")
			.withBody("TEXT_TO_SEND_TO_RECIPIENT")
			.build();
	XMPPService xmpp = XMPPServiceFactory.getXMPPService();
	//Compose the Message Object i.e. replyMessage
	if (xmpp.getPresence("JABBER_ID_OF_RECIPIENT").isAvailable()) {
	SendResponse status = xmpp.sendMessage(replyMessage);
	//Take appropriate action based on status SUCCESS or FAIL i.e. log an
	error, update database, etc
	}
}
}

/*@SuppressWarnings("serial")
public class KkkServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}*/
