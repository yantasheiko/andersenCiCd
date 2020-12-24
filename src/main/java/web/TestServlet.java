package web;

import org.apache.logging.log4j.LogManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import web.actions.Action;

import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static web.invoker.Invoker.getActionMap;

public class TestServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(TestServlet.class.getName());
    private static final String CONTENT_TYPE = "text/html; charset = utf-8";
    private static final String UTF = "UTF-8";

    private static String getUrl(HttpServletRequest req) {
        return req.getRequestURI().substring(req.getContextPath().length());
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType(CONTENT_TYPE);
        req.setCharacterEncoding(UTF);

        try {
            if (getActionMap().get(getUrl(req)) != null) {
                executeCommand(req, resp, getUrl(req));
            } else {
                resourceError(req, resp);
            }
        } catch (IOException ioe) {
            logger.error(ioe);
            resp.setStatus(SC_INTERNAL_SERVER_ERROR);
        }
    }

    private void executeCommand(HttpServletRequest req, HttpServletResponse resp, String actionKey)
            throws ServletException, IOException {
        Action action = getActionMap().get(actionKey);
        action.execute(req, resp, getServletContext());
    }

    private void resourceError(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("resourceError", "Resource not found");
        getServletContext().getRequestDispatcher("/jsp/resourceError.jsp").forward(req, resp);
    }
}
