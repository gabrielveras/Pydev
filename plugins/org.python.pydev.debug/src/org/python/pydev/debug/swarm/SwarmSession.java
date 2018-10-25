package org.python.pydev.debug.swarm;

import java.net.HttpURLConnection;
import java.sql.Timestamp;
import java.util.Date;

import com.google.gson.Gson;

public class SwarmSession {

    private static final String URL = SwarmConnection.URL_ROOT + "/sessions";
    private static final String URL_BY_TASK_AND_DEVELOPER = SwarmSession.URL + "/search/findByTaskAndDeveloper";
    private static SwarmSession instance;

    private int id;
    private String description;
    private String finished;
    private String label;
    private String project;
    private String purpose;
    private String started;
    private String developer;
    private String task;

    private SwarmSession() {

    }

    private SwarmSession(String description, String label, String project, String purpose, String developer,
            String task) {
        this.description = description;
        this.label = label;
        this.project = project;
        this.purpose = purpose;
        this.developer = developer;
        this.task = task;
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFinished() {
        return this.started;
    }

    public String getStarted() {
        return this.finished;
    }

    public String getLabel() {
        return this.label;
    }

    public String getProject() {
        return this.project;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public String getTask() {
        return this.task;
    }

    public String getURI() {
        return SwarmSession.URL + "/" + this.id;
    }

    public static SwarmSession getLast() {
        return SwarmSession.instance;
    }

    public static SwarmSession getByTaskAndDeveloper(SwarmTask task, SwarmDeveloper developer) {
        SwarmSession.instance = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmSession.URL_BY_TASK_AND_DEVELOPER);
            sc.addParameter("developerId", String.valueOf(developer.getId()));
            sc.addParameter("taskId", String.valueOf(task.getId()));
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmSessionJson sessionJson = gson.fromJson(sc.getResponse(), SwarmSessionJson.class);
                for (SwarmSession session : sessionJson.getList()) {
                    session.task = task.getURI();
                    session.developer = developer.getURI();
                    SwarmSession.instance = session;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmSession.instance;
    }

    public static SwarmSession createSession(String description, String label, String project, String purpose,
            SwarmDeveloper developer, SwarmTask task) {
        SwarmSession.instance = null;
        try {
            Gson gson = new Gson();
            SwarmSession session = new SwarmSession(description, label, project, purpose, developer.getURI(),
                    task.getURI());
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmSession.URL);
            sc.sendPost(gson.toJson(session));
            if (sc.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
                SwarmSession.instance = gson.fromJson(sc.getResponse(), SwarmSession.class);
                SwarmSession.instance.developer = SwarmSession.getDeveloper(SwarmSession.instance).getURI();
                SwarmSession.instance.task = SwarmSession.getTask(SwarmSession.instance).getURI();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SwarmSession.instance;
    }

    public static SwarmDeveloper getDeveloper(SwarmSession session) {
        SwarmDeveloper developer = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmSession.URL + "/" + session.getId() + "/developer");
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                developer = gson.fromJson(sc.getResponse(), SwarmDeveloper.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return developer;
    }

    public static SwarmTask getTask(SwarmSession session) {
        SwarmTask task = null;
        try {
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmSession.URL + "/" + session.getId() + "/task");
            sc.sendGet();
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                task = gson.fromJson(sc.getResponse(), SwarmTask.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return task;
    }

    public static void start(SwarmSession session) {
        try {
            session.started = (new Timestamp(new Date().getTime()).toString()).replace(" ", "T");
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmSession.URL + "/" + session.getId());
            sc.sendPut(gson.toJson(session));
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmSession.instance = gson.fromJson(sc.getResponse(), SwarmSession.class);
                SwarmSession.instance.developer = SwarmSession.getDeveloper(SwarmSession.instance).getURI();
                SwarmSession.instance.task = SwarmSession.getTask(SwarmSession.instance).getURI();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void stop(SwarmSession session) {
        try {
            session.finished = (new Timestamp(new Date().getTime()).toString()).replace(" ", "T");
            Gson gson = new Gson();
            SwarmConnection sc = SwarmConnection.getInstance();
            sc.setURL(SwarmSession.URL + "/" + session.getId());
            sc.sendPut(gson.toJson(session));
            if (sc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                SwarmSession.instance = gson.fromJson(sc.getResponse(), SwarmSession.class);
                SwarmSession.instance.developer = SwarmSession.getDeveloper(SwarmSession.instance).getURI();
                SwarmSession.instance.task = SwarmSession.getTask(SwarmSession.instance).getURI();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private class SwarmSessionJson {
        private InnerElement _embedded;

        public SwarmSession[] getList() {
            return _embedded.getList();
        }

        private class InnerElement {
            private SwarmSession[] sessions;

            public SwarmSession[] getList() {
                return sessions;
            }
        }
    }

}
