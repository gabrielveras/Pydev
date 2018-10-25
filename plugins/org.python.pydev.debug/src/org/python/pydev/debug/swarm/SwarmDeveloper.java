package org.python.pydev.debug.swarm;

import java.net.HttpURLConnection;

import com.google.gson.Gson;

public class SwarmDeveloper {

    private static final String URL = SwarmConnection.URL_ROOT + "/developers";
    private static final String URL_BY_FULLNAME = SwarmDeveloper.URL + "/search/findByNameAllIgnoringCase";
    private static SwarmDeveloper instance;

    private Integer id;
    private String color;
    private String name;
    private boolean logged;

    private SwarmDeveloper() {
    }

    private SwarmDeveloper(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public boolean isLogged() {
        return this.logged;
    }

    public String getURI() {
        return SwarmDeveloper.URL + "/" + this.id;
    }

    public static SwarmDeveloper getLast() {
        return SwarmDeveloper.instance;
    }

    public static SwarmDeveloper getById(int id) {
        SwarmDeveloper.instance = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmDeveloper.URL + "/" + id);
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmDeveloper.instance = gson.fromJson(sc.getResponse(), SwarmDeveloper.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmDeveloper.instance;
    }

    public static SwarmDeveloper getByFullName(String name) {
        SwarmDeveloper.instance = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmDeveloper.URL_BY_FULLNAME);
            sc.addParameter("name", name);
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmDeveloper.instance = gson.fromJson(sc.getResponse(), SwarmDeveloper.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmDeveloper.instance;
    }

    public static SwarmDeveloper create(String color, String name) {
        SwarmDeveloper.instance = null;
        try {
            Gson gson = new Gson();
            SwarmDeveloper developer = new SwarmDeveloper(color, name);
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmDeveloper.URL);
            sc.sendPost(gson.toJson(developer));
            if (sc.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
                SwarmDeveloper.instance = gson.fromJson(sc.getResponse(), SwarmDeveloper.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmDeveloper.instance;
    }

}
