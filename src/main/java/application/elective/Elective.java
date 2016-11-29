package application.elective;

import java.util.HashMap;
import java.util.Map;

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

    public Map<String, String> toMap() {
        Map<String, String> repr = new HashMap<>();
        repr.put("title", this.title);
        repr.put("lecturer", this.lecturer);
        repr.put("description", this.description);
        return repr;
    }
}