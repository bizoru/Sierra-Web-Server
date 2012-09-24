/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sierrawebserver;

/**
 *
 * @author Steven
 */
public interface Status {


    final String INIT_SERVER = "[Starting Sierra Web Server]---------- v 1.0";
    final String BIND_ERROR = "* Bind Error";
    final String CONNECTION = "(!) Client is connected";
    final String WAITING_CONECTION = "** Waiting for clients";
    final String SERVER_SENDING_HEAD = "Sending Headers [][][]";
}
