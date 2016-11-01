package app.elective;

import java.util.HashMap;
import java.util.Map;



public class Elective {
    private String title;
    private String description;
    private String lecturer;
    private int id;

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

    public Map<String, String> toMap() {
        Map<String, String> mapRepresentation = new HashMap<>();
        mapRepresentation.put("title", this.title);
        mapRepresentation.put("description", this.description);
        mapRepresentation.put("lecturer", this.lecturer);
        return mapRepresentation;
    }
}