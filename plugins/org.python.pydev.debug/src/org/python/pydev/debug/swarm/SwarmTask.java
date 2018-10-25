package org.python.pydev.debug.swarm;

import java.net.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

public class SwarmTask {

    private static final String URL = SwarmConnection.URL_ROOT + "/tasks";
    private static SwarmTask instance;

    private int id;
    private String color;
    private String title;
    private String url;
    private String product;

    public SwarmTask() {

    }

    public SwarmTask(String color, String title, String url, String product) {
        this.color = color;
        this.title = title;
        this.url = url;
        this.product = product;
    }

    public int getId() {
        return this.id;
    }

    public String getColor() {
        return this.color;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String getProduct() {
        return this.product;
    }

    public String getURI() {
        return SwarmTask.URL + "/" + this.id;
    }

    public static SwarmTask getLast() {
        return SwarmTask.instance;
    }

    public static SwarmTask getById(int id) {
        SwarmTask.instance = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmTask.URL + "/" + id);
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmTask.instance = gson.fromJson(sc.getResponse(), SwarmTask.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmTask.instance;
    }

    public static SwarmTask create(String color, String title, String url, SwarmProduct product) {
        SwarmTask.instance = null;
        try {
            Gson gson = new Gson();
            SwarmTask task = new SwarmTask(color, title, url, product.getURI());
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmTask.URL);
            sc.sendPost(gson.toJson(task));
            if (sc.getResponseCode() == HttpsURLConnection.HTTP_CREATED) {
                SwarmTask.instance = task;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmTask.instance;
    }

}
