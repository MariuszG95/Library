package mvc.interceptors;

import core.services.UserService;
import dto.LoggedUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor extends HandlerInterceptorAdapter {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            LoggedUserDTO loggedUserDTO = new LoggedUserDTO(userService.getUser(request.getUserPrincipal().getName()));
            request.getSession().setAttribute("user", loggedUserDTO);
        } catch (NullPointerException npe) {
            return false;
        }

        return super.preHandle(request, response, handler);
    }
}
