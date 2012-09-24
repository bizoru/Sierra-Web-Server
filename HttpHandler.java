/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sierrawebserver;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author Steven
 */
public class HttpHandler {



    public PrintWriter sendHeaders(Socket client){


        String ipaddress = client.getLocalSocketAddress().toString();
        String ipaddress2 = client.getInetAddress().getHostAddress().toString();

        PrintWriter output= null;
        try {

            output = new PrintWriter(client.getOutputStream());

                  // Send the response
        // Send the headers
        output.println("HTTP/1.0 200 OK");
        output.println("Content-Type: text/html");
        output.println("Server: Bot");
        // this blank line signals the end of the headers
        output.println("");
        // Send the HTML page
        String property = System.getProperty("os.name");
        output.println("<h1>Welcome to Sierra Server</h1>");
        output.println("<p> Native OS:"+property+"</p>");
        output.println("<p> Your current IP Address is:<bold>"+ipaddress+"</bold></p>");
        
        output.println("<hr>");
        output.println("<i>Sierra Web Server - GNU/GPL Licence</i>");
        output.flush();
        output.flush();
        }
        catch (Exception e) {

       
        }
    
    return output;

    }

    public void sendHtml(String html, Socket client){

    PrintWriter output= null;
        try {

            output = new PrintWriter(client.getOutputStream());
        }
        catch (Exception e) {

            String property = System.getProperty("os.name");

        
        output.println("<h1>Welcome to Sierra Server</h1>");
        
        output.println("<hr>");
        output.println("Sierra Web Server - GNU/GPL Licence");
        output.flush();
        }


    }


}
