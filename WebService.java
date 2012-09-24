/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sierrawebserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Steven
 */
public class WebService {


    private ServerSocket server;
    private Socket client;


    /**
     *
     * Here is the main TCP Socket to listen clients
     * @param port
     */
    public WebService(int port) {

        try {

            server = new ServerSocket(port);
        } catch (Exception e) {

            Log.logStatus(Status.BIND_ERROR);
            System.exit(0);
        }


    }


    


    public void start(){


    Log.logStatus(Status.WAITING_CONECTION);
    
    
    for (;;) {
      try {
        
        client = server.accept();
        
        Log.logStatus(Status.SERVER_SENDING_HEAD);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream());


        System.out.println(in.readLine());
        // read the data sent. We basically ignore it,
        // stop reading once a blank line is hit. This
        // blank line signals the end of the client HTTP
        // headers.
        String str = ".";
        while (!str.equals(""))
          str = in.readLine();
        


       HttpHandler handler = new HttpHandler();

       handler.sendHeaders(client);
       

        client.close();

       } catch (Exception e) {

           System.out.println("Error: " + e);
       }
   }

    }


}
        
    






