package org.python.pydev.debug.swarm;

import java.net.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

public class SwarmProduct {

    private static final String URL = SwarmConnection.URL_ROOT + "/products";
    private static SwarmProduct instance;

    private int id;
    private String name;

    private SwarmProduct() {
    }

    private SwarmProduct(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getURI() {
        return SwarmProduct.URL + "/" + this.id;
    }

    public static SwarmProduct getLast() {
        return SwarmProduct.instance;
    }

    public static SwarmProduct getById(int id) {
        SwarmProduct.instance = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmProduct.URL + "/" + id);
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmProduct.instance = gson.fromJson(sc.getResponse(), SwarmProduct.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmProduct.instance;
    }

    public static SwarmProduct create(String name) {
        SwarmProduct.instance = null;
        try {
            Gson gson = new Gson();
            SwarmProduct product = new SwarmProduct(name);
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmProduct.URL);
            sc.sendPost(gson.toJson(product));
            if (sc.getResponseCode() == HttpsURLConnection.HTTP_CREATED) {
                SwarmProduct.instance = gson.fromJson(sc.getResponse(), SwarmProduct.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmProduct.instance;
    }

}
