
import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hunglv
 */

@ServerEndpoint("/chat_room")
public class Server_WebSocket {
    
    //    save user connection to server
    Set<Session> users = Collections.synchronizedSet(new HashSet<>());
    HashMap<String, Session> list_user = new HashMap<>();
    
    @OnOpen
    public void handleOpen(Session session) {
        System.out.println(session);
        users.add(session);
    }
    
    @OnMessage
    public void handleMessage(String message, Session usr_session) throws IOException {
        String username = (String) usr_session.getUserProperties().get("username");
        if (username==null) {
            JsonObject json = Json.createReader(new StringReader(message)).readObject();
            String user = json.getString("username");
            String pass = json.getString("password");
            System.out.println("username: " + user);
            System.out.println("password: " + pass);
            usr_session.getUserProperties().put("username", user);
        }
//        } else {
//            String object_send = message.split("@")[0];
//            String mess = message.split("@")[1];
//            if (object_send.compareTo("all")==0) {
//                for (Session session: users) {
//                    session.getBasicRemote().sendText(username + ": " + mess);
//                }
//            } else {
//                if (list_user.get(object_send)!=null) {
//                    Session session = list_user.get(object_send);
//                    session.getBasicRemote().sendText(username + ": " + mess);
//                    usr_session.getBasicRemote().sendText(username + ": " + mess);
//                    
//                }
//            }
//        }
    }
    
    @OnClose
    public void handleClose(Session session) {
            users.remove(session);
    }

    @OnError
    public void handleError(Throwable t) {
            t.printStackTrace();
    }
}
