/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionSession;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author chalman
 */
public class SessionObject {
    private String sessionId;
    private HashMap<String, Object> value = new HashMap<>();
    private Timestamp timeStart;

///Constructors
    public SessionObject() {
    }

    public SessionObject(String sessionId, Timestamp timeStart) {
        this.sessionId = sessionId;
        this.timeStart = timeStart;
    }

    public SessionObject(String sessionId) {
        this.sessionId = sessionId;
    }
    
///Getters et settes
    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public HashMap<String, Object> getValue() {
        return value;
    }
    public void setValue(HashMap<String, Object> value) {
        this.value = value;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }
    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }
    
///Fonctions
    //Convertir un objet en Json
    public String convertObjectIntoJson(Object object) throws Exception {
        Gson json = new Gson();
        
        return json.toJson(object);
    }
    
    //Convertir json en object
    public Object convertJsonIntoObject(String json, Object object) throws Exception {
        Gson gson = new Gson();
        object = gson.fromJson(json, object.getClass());
        
        return object;
    }
}

