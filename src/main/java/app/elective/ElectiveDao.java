package app.elective;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.*;

public class ElectiveDao {

    private Sql2o sql2o;

    public ElectiveDao() {
        String DB_URL = "jdbc:mysql://node4.codenvy.io:36115/www";
        String USER = "www";
        String PASS = "password";

        sql2o = new Sql2o(DB_URL, USER, PASS);
    }

    public List<Elective> getAllElectives() {
        String query = "SELECT * FROM electives;";
        Connection con = sql2o.open();
        List<Elective> electives = con.createQuery(query)
                                      .executeAndFetch(Elective.class);
        return electives;
    }

    public Elective getElectiveById(int id) {
        String sql = "SELECT title, description, lecturer " + "FROM electives " + "WHERE id = :id;";
        Connection con = sql2o.open();
        Elective elective = con.createQuery(sql)
                               .addParameter("id", id)
                               .executeAndFetchFirst(Elective.class);
        return elective;
    }

    public void updateElective(int id, Elective elective) {
        String sql = "UPDATE electives SET title=:title, " +
                     "lecturer=:lecturer, description=:description " +
                     "WHERE id=:id";

        Connection con = sql2o.beginTransaction();
        con.createQuery(sql).addParameter("title", elective.getTitle())
                            .addParameter("description", elective.getDescription())
                            .addParameter("lecturer", elective.getLecturer())
                            .addParameter("id", id)
                            .executeUpdate();
        con.commit();
    }

    public void deleteElective(int id) {
        String sql = "DELETE from electives where id = :id;";
        Connection con = sql2o.open();
        con.createQuery(sql).addParameter("id", id).executeUpdate();
    }

    public void addElective(Elective elective) {
        String query = "INSERT INTO electives (title, description, lecturer) VALUES " +
                        "(:title, :description, :lecturer);";

        Connection con = sql2o.beginTransaction();
        con.createQuery(query).addParameter("title", elective.getTitle())
                              .addParameter("description", elective.getDescription())
                              .addParameter("lecturer", elective.getLecturer())
                              .executeUpdate();
        con.commit();
    }
}