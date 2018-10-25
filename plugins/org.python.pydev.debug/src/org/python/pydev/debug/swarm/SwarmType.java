package org.python.pydev.debug.swarm;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class SwarmType {

    private static final String URL = SwarmConnection.URL_ROOT + "/types";
    private static SwarmType instance;

    private int id;
    private String fullName;
    private String fullPath;
    private String name;
    private String source;
    private String namespace;
    private String session;

    private SwarmType() {

    }

    private SwarmType(String fullName, String fullPath, String name, String source, String namespace, String session) {
        this.fullName = fullName;
        this.fullPath = fullPath;
        this.name = name;
        this.source = source;
        this.namespace = namespace;
        this.session = session;
    }

    public int getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getFullPath() {
        return this.fullPath;
    }

    public String getName() {
        return this.name;
    }

    public String getSource() {
        return this.source;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getSession() {
        return this.session;
    }

    public String getURI() {
        return SwarmType.URL + "/" + this.id;
    }

    public static SwarmType getLast() {
        return SwarmType.instance;
    }

    public static SwarmType getById(int id) {
        SwarmType.instance = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmType.URL + "/" + id);
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmType.instance = gson.fromJson(sc.getResponse(), SwarmType.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmType.instance;
    }

    public static List<SwarmType> getAll() {
        List<SwarmType> list = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmType.URL);
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmTypeJson json = gson.fromJson(sc.getResponse(), SwarmTypeJson.class);
                list = new ArrayList<>();
                for (SwarmType type : json.getList()) {
                    list.add(type);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static SwarmType searchByName(String name) {
        List<SwarmType> list = SwarmType.getAll();
        if (list != null) {
            for (SwarmType type : list) {
                if (type.getName().equals(name)) {
                    return type;
                }
            }
        }
        return null;
    }

    public static SwarmType create(String fullName, String fullPath, String name, String source,
            SwarmNamespace namespace, SwarmSession session) {
        SwarmType.instance = null;
        try {
            Gson gson = new Gson();
            SwarmType type = new SwarmType(fullName, fullPath, name, source, namespace.getURI(), session.getURI());
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmType.URL);
            sc.sendPost(gson.toJson(type));
            if (sc.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
                SwarmType.instance = gson.fromJson(sc.getResponse(), SwarmType.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmType.instance;
    }

    private class SwarmTypeJson {
        private InnerElement _embedded;

        public SwarmType[] getList() {
            return _embedded.getList();
        }

        private class InnerElement {
            private SwarmType[] types;

            public SwarmType[] getList() {
                return types;
            }
        }
    }
}
