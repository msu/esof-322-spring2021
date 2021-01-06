package edu.montana.esof322.model;

import edu.montana.esof322.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MSUClass extends Model {
    private Long msuClassId;
    private String title;
    private String name;

    public MSUClass() {
        // new class for insert
    }

    private MSUClass(ResultSet results) throws SQLException {
        msuClassId = results.getLong("MSUClassId");
        title = results.getString("Title");
        name = results.getString("Name");
    }

    public static MSUClass find(int msuClassId) {
        try (Connection conn = DB.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM msu_classes WHERE MSUClassId=?")) {
            stmt.setLong(1, msuClassId);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                return new MSUClass(results);
            } else {
                return null;
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public User getInstructor() {
        for (User user : getUsers()) {
            if (user.t.equals("Instructor")) {
                return user;
            }
        }
        return getUsers().get(0);
    }

    @Override
    public boolean verify() {
        return true;
    }

    public static List<MSUClass> forUser(User user) {
        try (Connection conn = DB.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM msu_classes JOIN user_msu_classes ON msu_classes.MSUClassId=user_msu_classes.MSUClassId WHERE UserId=?"
             )) {
            stmt.setLong(1, user.u_id);
            ResultSet results = stmt.executeQuery();
            List<MSUClass> resultList = new LinkedList<>();
            while (results.next()) {
                resultList.add(new MSUClass(results));
            }
            return resultList;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMSUClassId() {
        return msuClassId;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return User.forClass(this);
    }

    @Override
    public boolean create() {
        if (verify()) {
            try (Connection conn = DB.connect();
                 PreparedStatement stmt = conn.prepareStatement(
                         "INSERT INTO msu_classes (Title, Name) VALUES (?, ?)")) {
                stmt.setString(1, this.getTitle());
                stmt.setString(2, this.getName());
                stmt.executeUpdate();
                msuClassId = DB.getLastID(conn);
                return true;
            } catch (SQLException sqlException) {
                throw new RuntimeException(sqlException);
            }
        } else {
            return false;
        }
    }

    public static List<MSUClass> all() {
        return all(0, Integer.MAX_VALUE);
    }

    public static List<MSUClass> all(int page, int count) {
        try (Connection conn = DB.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM msu_classes LIMIT ?"
             )) {
            stmt.setInt(1, count);
            ResultSet results = stmt.executeQuery();
            List<MSUClass> resultList = new LinkedList<>();
            while (results.next()) {
                resultList.add(new MSUClass(results));
            }
            return resultList;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }


}
