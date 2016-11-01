package app.elective;

import java.util.*;
import java.util.stream.*;

import spark.*;

import app.util.Path;

import static app.Application.electiveDao;

public class ElectiveController {

    public static ModelAndView getAllElectives(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        List<Elective> electives = electiveDao.getAllElectives();
        model.put("electives", electives.stream()
                                        .map(el -> el.toMap())
                                        .collect(Collectors.toList()));
        return new ModelAndView(model, Path.Template.INDEX);
    }

    public static ModelAndView getElectiveById(Request req, Response res) {
        Elective elective = electiveDao.getElectiveById(Integer.parseInt(req.params(":id")));
        Map<String, Object> model = new HashMap<>();
        List<Elective> electives = new ArrayList<>();
        electives.add(elective);
        model.put("electives", electives);
        return new ModelAndView(model, Path.Template.INDEX);
    }

}