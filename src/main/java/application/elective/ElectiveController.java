package application.elective;

import application.login.LoginController;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Map;

import static application.Application.electiveDao;

public class ElectiveController {

    public static ModelAndView getElectiveById(Request req, Response res) {
        LoginController.ensureUserIsLoggedIn(req, res);
        int id = Integer.parseInt(req.params(":id"));
        try {
            Elective elective = electiveDao.getElectiveById(id);
            Map<String, String> model = elective.toMap();
            model.put("id", String.valueOf(id));
            return new ModelAndView(model, "elective.hbs");
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public static String updateElective(Request req, Response res) {
        LoginController.ensureUserIsLoggedIn(req, res);
        int id = Integer.parseInt(req.params(":id"));
        String title = req.queryParams("title");
        String lecturer = req.queryParams("lecturer");
        String description = req.queryParams("description");
        Elective elective = new Elective(title, lecturer, description);
        try {
            electiveDao.updateElective(id, elective);
            return "Successfully updated!";
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return String.format("Failed updating elective with id %", id);
        }
    }

    public static ModelAndView updateElectiveForm(Request req, Response res) {
        LoginController.ensureUserIsLoggedIn(req, res);
        int id = Integer.parseInt(req.params(":id"));
        try {
            Elective elective = electiveDao.getElectiveById(id);
            Map<String, String> model = elective.toMap();
            model.put("id", String.valueOf(id));
            return new ModelAndView(model, "update-elective.hbs");
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
}