package web.actions;

import entities.User;
import services.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class DeleteUserAction implements Action {
    private static UserService userService = UserService.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        String userId = request.getParameter("deleteUserId");
        User user = userService.findById(parseInt(userId));
        userService.delete(user);

        request.setAttribute("userDel", user.getName());
        servletContext.getRequestDispatcher("/jsp/delete.jsp").forward(request, response);
    }
}
