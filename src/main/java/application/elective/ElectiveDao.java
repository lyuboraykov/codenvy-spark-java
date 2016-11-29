package application.elective;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class ElectiveDao {
    Sql2o sql2o;

    public ElectiveDao() {
        String DB_URL = "jdbc:mysql://node3.codenvy.io:40256/www";
        String USER = "www";
        String PASS = "password";

//        sql2o = new Sql2o(DB_URL, USER, PASS);
    }

    public Elective getElectiveById(int id) {
        String sql = "SELECT title, description, lecturer " +
                     "FROM electives " +
                     "WHERE id = :id;";
        Connection con = sql2o.open();
        return con.createQuery(sql)
                  .addParameter("id", id)
                  .executeAndFetchFirst(Elective.class);
    }

    public void updateElective(int id, Elective elective) {
        String sql = "UPDATE electives " +
                     "SET title=:title, description=:description, lecturer=:lecturer " +
                     "WHERE id=:id";
        Connection con = sql2o.open();
        con.createQuery(sql)
           .addParameter("title", elective.getTitle())
           .addParameter("description", elective.getDescription())
           .addParameter("lecturer", elective.getLecturer())
           .addParameter("id", id)
           .executeUpdate();
    }
}
