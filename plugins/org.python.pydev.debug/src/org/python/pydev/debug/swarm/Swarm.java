package org.python.pydev.debug.swarm;

import org.python.pydev.debug.model.PyBreakpoint;
import org.python.pydev.debug.model.PyStackFrame;

public class Swarm {

    private static SwarmDeveloper developer;
    private static SwarmProduct product;
    private static SwarmSession session;
    private static SwarmTask task;

    public static SwarmDeveloper getDeveloper() {
        return Swarm.developer;
    }

    public static SwarmProduct getProduct() {
        return Swarm.product;
    }

    public static SwarmSession getSession() {
        return Swarm.session;
    }

    public static SwarmTask getTask() {
        return Swarm.task;
    }

    public static void init() {
        Swarm.product = SwarmProduct.getById(SwarmMock.productId);
        if (Swarm.product == null) {
            Swarm.product = SwarmProduct.create("TODO");
        }
        Swarm.developer = SwarmDeveloper.getByFullName(SwarmMock.developerFullName);
        if (Swarm.developer == null) {
            String color = "000000";
            String name = "gabrielveras";
            Swarm.developer = SwarmDeveloper.create(color, name);
        }
        Swarm.task = SwarmTask.getById(SwarmMock.taskId);
        if (Swarm.task == null) {
            String color = "FF0000";
            String title = "TODO";
            String url = "TODO";
            Swarm.task = SwarmTask.create(color, title, url, Swarm.product);
        }
        //TODO SWARM DEBUGGER - Maybe I didn't need to get the session...
        //Swarm.session = SwarmSession.getByTaskAndDeveloper(Swarm.task, Swarm.developer);
        if (Swarm.session == null) {
            String description = "TODO";
            String label = "TODO";
            String project = "TODO";
            String purpose = "TODO";
            SwarmDeveloper developer = Swarm.developer;
            SwarmTask task = Swarm.task;
            Swarm.session = SwarmSession.createSession(description, label, project, purpose, developer, task);
        }
    }

    public static void start() {
        if (Swarm.session != null) {
            SwarmSession.start(Swarm.session);
        }
    }

    public static void stop() {
        if (Swarm.session != null) {
            SwarmSession.stop(Swarm.session);
        }
    }

    public static void createBreakpoint(PyBreakpoint breakpoint) throws Exception {
        if (Swarm.session != null && breakpoint != null) {
            int breakpointCharEnd = breakpoint.getCharEnd();
            int breakpointCharStart = breakpoint.getCharStart();
            int breakpointLineNumber = breakpoint.getLineNumber();
            String typeFullName = breakpoint.getMarker().getResource().getName();
            SwarmType type = SwarmType.searchByName(typeFullName);
            if (type == null) {
                String typeName = typeFullName;
                String typeFullPath = breakpoint.getMarker().getResource().getFullPath().toString();
                String typeSource = breakpoint.getMarker().getResource().getFullPath().toString();
                SwarmNamespace namespace = SwarmNamespace.getByFullPath(typeFullPath);
                if (namespace == null) {
                    String namespaceFullPath = typeFullPath;
                    String namespaceName = typeFullPath;
                    namespace = SwarmNamespace.create(namespaceFullPath, namespaceName);
                }
                type = SwarmType.create(typeFullName, typeFullPath, typeName, typeSource, namespace, Swarm.session);
            }
            SwarmBreakpoint.create(breakpointCharEnd, breakpointCharStart, breakpointLineNumber, type);
        }
    }

    public static void stepInto(PyStackFrame invoked, PyStackFrame invoking)
            throws Exception {
        if (Swarm.session != null && invoked != null && invoking != null) {
            //INVOKING
            String invokingName = invoking.getPath().lastSegment();
            String invokingPath = invoking.getPath().toPortableString();
            SwarmNamespace invokingNamespace = SwarmNamespace.getByFullPath(invokingPath);
            if (invokingNamespace == null) {
                invokingNamespace = SwarmNamespace.create(invokingPath, invokingName);
            }
            SwarmType invokingType = SwarmType.create(invokingName, invokingPath, invokingName, invokingPath,
                    invokingNamespace, Swarm.session);
            String invokingMethodName = invoked.getName().split("\\s")[0];
            if (invokingMethodName.equals("<module>")) {
                invokingMethodName = "Global";
            }
            SwarmMethod invokingMethod = SwarmMethod.create("TODO", invokingMethodName, "TODO", invokingType);
            //INVOKED
            String invokedName = invoked.getPath().lastSegment();
            String invokedPath = invoked.getPath().toPortableString();
            SwarmNamespace invokedNamespace = SwarmNamespace.getByFullPath(invokedPath);
            if (invokedNamespace == null) {
                invokedNamespace = SwarmNamespace.create(invokedPath, invokedPath);
            }
            SwarmType invokedType = SwarmType.create(invokedName, invokedPath, invokedName, invokedPath,
                    invokedNamespace, Swarm.session);
            String invokedMethodName = invoked.getName().split("\\s")[0];
            if (invokedMethodName.equals("<module>")) {
                invokedMethodName = "Global";
            }
            SwarmMethod invokedMethod = SwarmMethod.create("TODO", invokedMethodName, "TODO", invokedType);
            //INVOCATION
            SwarmInvocation.create(invokedMethod, invokingMethod, Swarm.session);
        }
    }
}