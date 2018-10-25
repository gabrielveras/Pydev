package org.python.pydev.debug.swarm;

import java.net.HttpURLConnection;

import com.google.gson.Gson;

public class SwarmMethod {

    private static final String URL = SwarmConnection.URL_ROOT + "/methods";
    private static SwarmMethod instance;

    private int id;
    private String key;
    private String name;
    private String signature;
    private String type;

    private SwarmMethod() {

    }

    private SwarmMethod(String key, String name, String signature, String type) {
        this.key = key;
        this.name = name;
        this.signature = signature;
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getType() {
        return this.type;
    }

    public String getURI() {
        return SwarmMethod.URL + "/" + this.id;
    }

    public static SwarmMethod getLast() {
        return SwarmMethod.instance;
    }

    public static SwarmMethod getById(int id) {
        SwarmMethod.instance = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmMethod.URL + "/" + id);
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmMethod.instance = gson.fromJson(sc.getResponse(), SwarmMethod.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmMethod.instance;
    }

    public static SwarmMethod create(String key, String name, String signature, SwarmType type) {
        SwarmMethod.instance = null;
        try {
            Gson gson = new Gson();
            SwarmMethod method = new SwarmMethod(key, name, signature, type.getURI());
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmMethod.URL);
            sc.sendPost(gson.toJson(method));
            if (sc.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
                SwarmMethod.instance = gson.fromJson(sc.getResponse(), SwarmMethod.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmMethod.instance;
    }

}
