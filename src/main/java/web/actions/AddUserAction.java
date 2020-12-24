package web.actions;

import entities.User;
import services.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserAction implements Action {

    private static UserService userService = UserService.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        userService.add(user);

        servletContext.getRequestDispatcher("/jsp/creatingResult.jsp").forward(request, response);
    }
}
