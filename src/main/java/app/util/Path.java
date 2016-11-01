package app.util;
public class Path {

    public static class Web {
        public static final String INDEX = "/index/";
        public static final String ELECTIVE_BY_ID = "/electives/:id/";
        public static final String ELECTIVES = "/electives/";
    }

    public static class Template {
        public final static String INDEX = "index.hbs";
        public final static String UPDATE_ELECTIVE = "update-elective.hbs";
        public final static String ADD_ELECTIVE = "add-elective.hbs";
    }

}