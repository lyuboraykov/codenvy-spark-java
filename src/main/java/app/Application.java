package app;

import app.elective.*;
import app.util.*;
import spark.template.handlebars.HandlebarsTemplateEngine;


import static spark.Spark.*;

public class Application {

    public static ElectiveDao electiveDao;

    public static void main(String[] args) {
        electiveDao = new ElectiveDao();

        port(4567);
        staticFiles.location("/public");

        exception(Exception.class, (e, req, res) -> e.printStackTrace());

        get(Path.Web.INDEX,          ElectiveController::getAllElectives, new HandlebarsTemplateEngine());
        get(Path.Web.ELECTIVE_BY_ID, ElectiveController::getElectiveById, new HandlebarsTemplateEngine());
    }

}