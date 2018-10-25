package org.python.pydev.debug.swarm;

import java.net.HttpURLConnection;

import com.google.gson.Gson;

public class SwarmNamespace {

    private static final String URL = SwarmConnection.URL_ROOT + "/namespaces";
    private static final String URL_BY_FULLPATH = SwarmNamespace.URL + "/search/findByFullPath";
    private static SwarmNamespace instance;

    private int id;
    private String fullPath;
    private String name;

    private SwarmNamespace() {
    }

    private SwarmNamespace(String fullPath, String name) {
        this.fullPath = fullPath;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getFullPath() {
        return this.fullPath;
    }

    public String getName() {
        return this.name;
    }

    public String getURI() {
        return SwarmNamespace.URL + "/" + this.id;
    }

    public static SwarmNamespace getLast() {
        return SwarmNamespace.instance;
    }

    public static SwarmNamespace getById(int id) {
        SwarmNamespace.instance = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmNamespace.URL + "/" + id);
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmNamespace.instance = gson.fromJson(sc.getResponse(), SwarmNamespace.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmNamespace.instance;
    }

    public static SwarmNamespace getByFullPath(String fullPath) {
        SwarmNamespace.instance = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmNamespace.URL_BY_FULLPATH);
            sc.addParameter("fullPath", fullPath);
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmNamespace.instance = gson.fromJson(sc.getResponse(), SwarmNamespace.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmNamespace.instance;
    }

    public static SwarmNamespace create(String fullPath, String name) {
        SwarmNamespace.instance = null;
        try {
            Gson gson = new Gson();
            SwarmNamespace namespace = new SwarmNamespace(fullPath, name);
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmNamespace.URL);
            sc.sendPost(gson.toJson(namespace));
            if (sc.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
                SwarmNamespace.instance = gson.fromJson(sc.getResponse(), SwarmNamespace.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmNamespace.instance;
    }

}
