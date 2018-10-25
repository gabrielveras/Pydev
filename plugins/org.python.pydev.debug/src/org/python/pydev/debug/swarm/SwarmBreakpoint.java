package org.python.pydev.debug.swarm;

import java.net.HttpURLConnection;

import com.google.gson.Gson;

public class SwarmBreakpoint {

    private static final String URL = SwarmConnection.URL_ROOT + "/breakpoints";
    private static SwarmBreakpoint instance;

    private int id;
    private int charEnd;
    private int charStart;
    private int lineNumber;
    private String type;

    private SwarmBreakpoint() {

    }

    private SwarmBreakpoint(int charEnd, int charStart, int lineNumber, String type) {
        this.charEnd = charEnd;
        this.charStart = charStart;
        this.lineNumber = lineNumber;
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public int getCharEnd() {
        return this.charEnd;
    }

    public int getCharStart() {
        return this.charStart;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public String getType() {
        return this.type;
    }

    public static SwarmBreakpoint getLast() {
        return SwarmBreakpoint.instance;
    }

    public static SwarmBreakpoint getById(int id) {
        SwarmBreakpoint.instance = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmBreakpoint.URL + "/" + id);
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmBreakpoint.instance = gson.fromJson(sc.getResponse(), SwarmBreakpoint.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmBreakpoint.instance;
    }

    public static SwarmBreakpoint create(int charEnd, int charStart, int lineNumber, SwarmType type) {
        SwarmBreakpoint.instance = null;
        try {
            Gson gson = new Gson();
            SwarmBreakpoint breakpoint = new SwarmBreakpoint(charEnd, charStart, lineNumber, type.getURI());
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmBreakpoint.URL);
            sc.sendPost(gson.toJson(breakpoint));
            if (sc.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
                SwarmBreakpoint.instance = gson.fromJson(sc.getResponse(), SwarmBreakpoint.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmBreakpoint.instance;
    }

}
