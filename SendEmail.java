import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class SendEmail extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String s="1234567890";
		Random random=new Random();
		char[] otp=new char[6];
		    for(int i=0;i<6;i++){
			otp[i]=s.charAt(random.nextInt(s.length()));
			}
			
			String strArray[]=new String[otp.length];
			for(int i=0;i<otp.length;i++){
				strArray[i]=String.valueOf(otp[i]);
			}
			String s1=Arrays.toString(strArray);
			
			String res1="";
			for(String num:strArray){
				res1+=num;
			}
			String to=(String)req.getAttribute("email");
			String from="mail.simran1104@gmail.com";
			String host = "localhost";
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
			Session session = Session.getDefaultInstance(properties);
			try {
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(session);

                 // Set From: header field of the header.
                 message.setFrom(new InternetAddress(from));

                 // Set To: header field of the header.
                 message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                  // Set Subject: header field
                  message.setSubject("Sbi otp");

                  // Now set the actual message
                 message.setText("your one time password is:" +res1);

                 // Send message
                 Transport.send(message);
			}
                 
            catch (MessagingException mex) {
             mex.printStackTrace();
			}
			req.setAttribute("otp",res1);
			RequestDispatcher disp=req.getRequestDispatcher("Verify");
			disp.include(req,res);



	}
}