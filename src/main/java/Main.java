import static spark.Spark.*;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.logging.SysOutLogger;

import java.util.List;

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
        String DB_URL = "jdbc:mysql://node4.codenvy.io:33178/www";
        String USER = "www";
        String PASS = "password";

        Sql2o sql2o = new Sql2o(DB_URL, USER, PASS);

        get("/hello", ((request, response) -> {
            return "Hello world!";
        }));

        get("/view-electives", (request, response) -> {
            String sql =
                    "SELECT title, description, lecturer " +
                            "FROM electives " +
                            "WHERE id = :id;";
            try(Connection con = sql2o.open()) {
                Elective elective = con.createQuery(sql)
                        .addParameter("id", 1)
                        .executeAndFetchFirst(Elective.class);
                return elective.toHTML();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return e.getMessage();
            }
        });
    }
}
