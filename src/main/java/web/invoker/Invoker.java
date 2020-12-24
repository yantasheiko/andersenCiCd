package web.invoker;

import web.actions.*;

import java.util.HashMap;
import java.util.Map;

public class Invoker {

    private static Map<String, Action> actionMap = new HashMap<>();

    private static final String SHOW_USERS = "/test";
    private static final String SHOW_REGISTRATION = "/registration";
    private static final String SHOW_DELETED_USER = "/deleteUser";

    static {
        actionMap.put(SHOW_USERS, new UserAction());
        actionMap.put(SHOW_REGISTRATION, new AddUserAction());
        actionMap.put(SHOW_DELETED_USER, new DeleteUserAction());
    }

    public static Map<String, Action> getActionMap() {
        return actionMap;
    }
}
