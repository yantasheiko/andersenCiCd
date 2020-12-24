package web.actions;

import services.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAction implements Action {
    private static UserService userService = UserService.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        request.setAttribute("users", userService.findAll());
        servletContext.getRequestDispatcher("/jsp/showUsers.jsp").forward(request, response);
    }
}
