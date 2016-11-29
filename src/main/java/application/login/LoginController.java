package application.login;

import application.user.UserController;
import application.util.Path;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;


public class LoginController {
    public static ModelAndView getLoginPage(Request req, Response res) {
        Map<String, String> model = new HashMap<>();
        model.put("redirect", req.queryParams("redirect"));
        String authenticationFailed = req.queryParams("authenticationFailed");
        if (authenticationFailed != null) {
            model.put("authenticationFailed", "true");
        }
        return new ModelAndView(model, "login.hbs");
    }

    public static Route handleLogin(Request req, Response res) {
        String username = req.queryParams("username");
        String password = req.queryParams("password");
        if (!UserController.authenticate(username, password)) {
            res.redirect(Path.AUTHENTICATION_FAILED);
        } else {
            String redirectUrl = req.queryParams("redirect");
            req.session().attribute("currentUser", username);
            res.redirect(redirectUrl);
        }
        return null;
    }

    public static Route logout(Request req, Response res) {
        req.session().removeAttribute("currentUser");
        res.redirect(Path.LOGIN);
        return null;
    }


    public static void ensureUserIsLoggedIn(Request req, Response res) {
        if (req.session().attribute("currentUser") == null) {
            res.redirect(Path.LOGIN);
        }
    };
}
