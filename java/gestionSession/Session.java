/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionSession;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author chalman
 */
public class Session {
    private SessionObject sessionObject;
    private Connection connection;
    
///Constructors
    public Session() {
    }

    public Session(SessionObject sessionObject, Connection connection) {
        this.sessionObject = sessionObject;
        this.connection = connection;
    }

///Getters et setters
    public SessionObject getSessionObject() {
        return sessionObject;
    }
    public void setSessionObject(SessionObject sessionObject) {
        this.sessionObject = sessionObject;
    }

    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
///Fonctions
    //Recuperer les donnees du session
    public Object getAttribute(String name) throws Exception {
       
        SessionObject so = Session.getById(this.getConnection(), this.getSessionObject().getSessionId());
        //Object object = so.convertJsonIntoObject(so.getValue(), new Object());
        System.out.println(so.getValue().get(name));
          
        return so.getValue().get(name);
    }
    
    //Mettre la session
    public void setAttribute(String name, Object data) throws Exception {
        this.getSessionObject().getValue().put(name, data);
       if(!isSessionExist()) {
           this.create();
       }
       else {
           this.update();
       }
    }
    
    //Verifier si la session existe deja
    public boolean isSessionExist() throws Exception {
        Statement work = this.getConnection().createStatement();
        String req = "SELECT data FROM session_client WHERE id='"+this.getSessionObject().getSessionId()+"'";
        ResultSet result = work.executeQuery(req);

        if(result.next()) {
            return true;
        }
      
        return false;
    }
    
    //creer une session
    public void create() throws Exception {
        SessionObject so = new SessionObject();
        String data = so.convertObjectIntoJson(this.getSessionObject().getValue());
        Statement work = this.getConnection().createStatement();
        String req = "INSERT INTO session_client (id, data, time_start) values ('"+this.getSessionObject().getSessionId()+"', '"+data+"', '"+this.getSessionObject().getTimeStart()+"')";
        work.execute(req);
        this.getConnection().setAutoCommit(true);
    }
    
    //Modifier une session
    public void update()  throws Exception { 
        SessionObject so = new SessionObject();
        String data = so.convertObjectIntoJson(this.getSessionObject().getValue());
        Statement work = this.getConnection().createStatement();
        String req = "UPDATE session_client SET data='"+data+"' WHERE id='"+this.getSessionObject().getSessionId()+"'";
        work.execute(req);
        this.getConnection().setAutoCommit(true);
    }
    
    //Recuperer une session par son id
    public static SessionObject getById(Connection conn, String id) throws Exception {
        Statement work = conn.createStatement();
        String req = "select * from session_client where id = '"+id+"'";
        ResultSet result = work.executeQuery(req);
        SessionObject so = new SessionObject();
        HashMap<String, Object> datas = new HashMap<>();
        int i = 1;
        while(result.next()) {
            so.setSessionId(result.getString(1));
            String dataJson = result.getString(2);
            datas = (HashMap<String, Object>)so.convertJsonIntoObject(dataJson, datas);
            so.setValue(datas);
            so.setTimeStart(result.getTimestamp(3));
        }
        
        return so;
    }
}
