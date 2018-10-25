package org.python.pydev.debug.swarm;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SwarmConnection {

    public static final String URL_ROOT = "http://localhost:8080";

    private static final String USER_AGENT = "Mozilla/5.0";
    private static SwarmConnection instance;

    private final Map<String, String> parameters = new HashMap<>();
    private String url;
    private int responseCode;
    private String response;

    private SwarmConnection() {
        this.setURL(SwarmConnection.URL_ROOT);
    }

    public static SwarmConnection getInstance() {
        if (SwarmConnection.instance == null) {
            SwarmConnection.instance = new SwarmConnection();
        }
        return SwarmConnection.instance;
    }

    public void setURL(String string) {
        this.url = string;
    }

    public void addParameter(String key, String value) {
        this.parameters.put(key, value);
    }

    public void clearParameters() {
        this.parameters.clear();
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponse() {
        return this.response;
    }

    public void sendGet() throws Exception {
        this.responseCode = -1;
        this.response = null;

        String urlParameters = "";
        if (this.parameters.size() > 0) {
            urlParameters += "?";
            for (String key : this.parameters.keySet()) {
                urlParameters += key + "=" + this.parameters.get(key) + "&";
            }
        }
        this.parameters.clear();

        URL obj = new URL(this.url + urlParameters);

        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);

        this.responseCode = connection.getResponseCode();
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer responseBuffer = new StringBuffer();
        while ((inputLine = input.readLine()) != null) {
            responseBuffer.append(inputLine);
        }
        input.close();
        this.response = responseBuffer.toString();
    }

    public void sendPost(String json) throws Exception {
        this.responseCode = -1;
        this.response = null;

        //No parameters in POST
        this.parameters.clear();

        URL obj = new URL(this.url);

        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(json);
        wr.flush();
        wr.close();

        this.responseCode = connection.getResponseCode();
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer responseBuffer = new StringBuffer();
        while ((inputLine = input.readLine()) != null) {
            responseBuffer.append(inputLine);
        }
        input.close();
        this.response = responseBuffer.toString();
    }

    public void sendPut(String json) throws Exception {
        this.responseCode = -1;
        this.response = null;

        //No parameters in POST
        this.parameters.clear();

        URL obj = new URL(this.url);

        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(json);
        wr.flush();
        wr.close();

        this.responseCode = connection.getResponseCode();
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer responseBuffer = new StringBuffer();
        while ((inputLine = input.readLine()) != null) {
            responseBuffer.append(inputLine);
        }
        input.close();
        this.response = responseBuffer.toString();

    }

    public void sendDelete() {

    }
}
