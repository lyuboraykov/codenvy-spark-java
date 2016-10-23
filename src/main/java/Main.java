import static spark.Spark.*;
import org.sql2o.Sql2o;

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
        String DB_URL = "node3.codenvy.io:36357";
        String USER = "www";
        String PASS = "password";

        Sql2o sql2o = new Sql2o(DB_URL, USER, PASS);

        get("/hello", ((request, response) -> {
            return "Hello world!";
        }));
    }
}
