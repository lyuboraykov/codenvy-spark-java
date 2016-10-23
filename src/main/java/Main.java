import static spark.Spark.*;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.*;

class Elective {
    private String title;
    private String description;
    private String lecturer;

    Elective(String title, String description, String lecturer) {
        this.title = title;
        this.description = description;
        this.lecturer = lecturer;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLecturer() {
        return lecturer;
    }

    public String toHTML() {
        return String.format("<h1>%s</h1>", this.title);
    }
}

public class Main {
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://node5.codenvy.io:34189/www";
        String USER = "www";
        String PASS = "password";

        Sql2o sql2o = new Sql2o(DB_URL, USER, PASS);

        get("/electives/:id", (request, response) -> {
            int id = Integer.parseInt(request.params(":id"));
            String sql = "SELECT title, description, lecturer " +
                    "FROM electives " +
                    "WHERE id = :id;";
            try(Connection con = sql2o.open()) {
                Elective elective = con.createQuery(sql)
                        .addParameter("id", id)
                        .executeAndFetchFirst(Elective.class);
                return elective.toHTML();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return String.format("Couldn't retrieve elective with id %d", id);
            }
        });

        post("/electives", (request, response) -> {
            String title = request.queryParams("title");
            String description = request.queryParams("description");
            String lecturer = request.queryParams("lecturer");

            String query = "INSERT INTO electives (title, description, lecturer) VALUES " +
                    "(:title, :description, :lecturer)";

            try (Connection con = sql2o.beginTransaction()) {
                sql2o.createQuery(query).addParameter("title", title)
                        .addParameter("description", description)
                        .addParameter("lecturer", lecturer)
                        .executeUpdate();
                con.commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return "Couldn't insert new elective.";
            }

            return "Success!";
        });
    }
}
