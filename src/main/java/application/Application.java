package application;

import static spark.Spark.*;

import application.elective.ElectiveController;
import application.elective.ElectiveDao;
import application.login.LoginController;
import application.user.UserDao;
import application.util.Path;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Application {

    public static ElectiveDao electiveDao = new ElectiveDao();
    public static UserDao userDao = new UserDao();

    public static void main(String[] args) {
        get(Path.ELECTIVE_BY_ID, ElectiveController::getElectiveById, new HandlebarsTemplateEngine());
        put(Path.ELECTIVE_BY_ID, ElectiveController::updateElective);

        get(Path.UPDATE_ELECTIVE, ElectiveController::updateElectiveForm, new HandlebarsTemplateEngine());

        get(Path.LOGIN, LoginController::getLoginPage, new HandlebarsTemplateEngine());
        post(Path.LOGIN, LoginController::handleLogin);
    }
}
