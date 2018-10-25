package org.python.pydev.debug.swarm;

import java.net.HttpURLConnection;

import com.google.gson.Gson;

public class SwarmInvocation {

    private static final String URL = SwarmConnection.URL_ROOT + "/invocations";
    private static SwarmInvocation instance;

    private int id;
    private String invoked;
    private String invoking;
    private String session;

    private SwarmInvocation() {

    }

    private SwarmInvocation(String invoked, String invoking, String session) {
        this.invoked = invoked;
        this.invoking = invoking;
        this.session = session;
    }

    public int getId() {
        return this.id;
    }

    public String getInvokedId() {
        return this.invoked;
    }

    public String getInvokingId() {
        return this.invoking;
    }

    public String getSessionId() {
        return this.session;
    }

    public String getURI() {
        return SwarmInvocation.URL + "/" + this.id;
    }

    public static SwarmInvocation getLast() {
        return SwarmInvocation.instance;
    }

    public static SwarmInvocation getById(int id) {
        SwarmInvocation.instance = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmInvocation.URL + "/" + id);
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmInvocation.instance = gson.fromJson(sc.getResponse(), SwarmInvocation.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmInvocation.instance;
    }

    public static SwarmInvocation create(SwarmMethod invoked, SwarmMethod invoking, SwarmSession session) {
        SwarmInvocation.instance = null;
        try {
            Gson gson = new Gson();
            SwarmInvocation invocation = new SwarmInvocation(invoked.getURI(), invoking.getURI(), session.getURI());
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmInvocation.URL);
            sc.sendPost(gson.toJson(invocation));
            if (sc.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
                SwarmInvocation.instance = gson.fromJson(sc.getResponse(), SwarmInvocation.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmInvocation.instance;
    }

}
