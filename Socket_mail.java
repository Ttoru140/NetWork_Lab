import java.io.*;
// import java.time.LocalDateTime;
import javax.net.ssl.*;
import java.util.*;

class SendMail {

  private static DataOutputStream dos;
  public static BufferedReader br;

  @SuppressWarnings("resource")
public static void main(String argv[]) throws Exception {
    String user = "s2111076140@ru.ac.bd";  //email address
    String pass = "xyz"; //pass	
    
    String username =new String(Base64.getEncoder().encode(user.getBytes()));
    String password = new String(Base64.getEncoder().encode(pass.getBytes()));
    SSLSocket s = (SSLSocket) SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465);
    dos = new DataOutputStream(s.getOutputStream());
    br = new BufferedReader(new InputStreamReader(s.getInputStream()));



    send("EHLO smtp.gmail.com\r\n");
              for(int i=0 ; i<9 ;i++){
                System.out.println("SERVER: "+ br.readLine());
                }


    
    send("AUTH LOGIN\r\n");
              System.out.println("SERVER: "+ br.readLine());


    send(username + "\r\n");
              System.out.println("SERVER: "+ br.readLine());



    send(password + "\r\n");
              System.out.println("SERVER: "+ br.readLine());


    send("MAIL FROM:<s2111076140@ru.ac.bd>\r\n");
              System.out.println("SERVER: "+ br.readLine());


    send("RCPT TO:<asifzaman3180@yahoo.com>\r\n");
              System.out.println("SERVER: "+ br.readLine());



    send("DATA\r\n");
            System.out.println("SERVER: "+ br.readLine());


    send("FROM: s2111076140@ru.ac.bd\r\n");//change
    send("TO: asifzaman3180@yahoo.com\r\n");//change
    send("Subject: 3Y2S2023-E1" + "\r\n");
    send("2111076140 \r\n");
    send(".\r\n");
          System.out.println("SERVER: "+ br.readLine());


          
    send("QUIT\r\n");
    System.out.println("SERVER: "+ br.readLine());
  }

  private static void send(String s) throws Exception {
    dos.writeBytes(s);
    Thread.sleep(1000);
    System.out.println("CLIENT: " + s);
     }
}
