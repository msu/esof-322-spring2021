package edu.montana.esof322.model;

import edu.montana.esof322.util.DB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class User extends Model {

    public Long u_id;
    public String f_n;
    public String l_n;
    public String em;
    public String t;
    public Long adv;
    public Long rt;

    public User() {
        // new employee for insert
    }

    public User(ResultSet results) throws SQLException {
        u_id = results.getLong("UserId");
        f_n = results.getString("FirstName");
        l_n = results.getString("LastName");
        em = results.getString("Email");
        adv = results.getLong("AdvisorId");
        rt = results.getLong("ReportsTo");
        t = results.getString("Type");
    }

    public static User findRandomProf() {
        try (Connection conn = DB.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE Type='Instructor' ORDER BY RANDOM() LIMIT 1")) {
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                return new User(results);
            } else {
                return null;
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static List<User> forClass(MSUClass msuClass) {
        try (Connection conn = DB.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM users JOIN user_msu_classes ON users.UserId=user_msu_classes.UserId WHERE MSUClassId=?"
             )) {
            stmt.setLong(1, msuClass.getMSUClassId());
            ResultSet results = stmt.executeQuery();
            List<User> resultList = new LinkedList<>();
            while (results.next()) {
                resultList.add(new User(results));
            }
            return resultList;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public boolean verify() {
        _errors.clear(); // clear any existing errors
        if (f_n == null || "".equals(f_n)) {
            addError("FirstName can't be null or blank!");
        }
        if (l_n == null || "".equals(l_n)) {
            addError("LastName can't be null!");
        }
        return !hasErrors();
    }

    @Override
    public boolean update() {
        if (verify()) {
            try (Connection conn = DB.connect();
                 PreparedStatement stmt = conn.prepareStatement(
                         "UPDATE users SET FirstName=?, LastName=?, Email=?, Type=?, ReportsTo=?, AdvisorId=? WHERE UserId=?")) {
                stmt.setString(1, f_n);
                stmt.setString(2, l_n);
                stmt.setString(3, em);
                stmt.setString(4, t);
                stmt.setLong(5, rt);
                stmt.setLong(6, adv);
                stmt.setLong(7, u_id);
                stmt.executeUpdate();
                return true;
            } catch (SQLException sqlException) {
                throw new RuntimeException(sqlException);
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean create() {
        if (verify()) {
            try (Connection conn = DB.connect();
                 PreparedStatement stmt = conn.prepareStatement(
                         "INSERT INTO users (FirstName, LastName, Email, Type, ReportsTo, AdvisorId) VALUES (?, ?, ?, ?, ?, ?)")) {
                stmt.setString(1, f_n);
                stmt.setString(2, l_n);
                stmt.setString(3, em);
                stmt.setString(4, t);
                stmt.setLong(5, rt);
                stmt.setLong(6, adv);
                stmt.executeUpdate();
                u_id = DB.getLastID(conn);
                return true;
            } catch (SQLException sqlException) {
                throw new RuntimeException(sqlException);
            }
        } else {
            return false;
        }
    }

    @Override
    public void delete() {
        try (Connection conn = DB.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "DELETE FROM users WHERE UserID=?")) {
            stmt.setLong(1, u_id);
            stmt.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static List<User> all() {
        return all(0, Integer.MAX_VALUE);
    }

    public static List<User> all(int page, int count) {
        try (Connection conn = DB.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM users LIMIT ? OFFSET ?"
             )) {
            stmt.setInt(1, count);
            stmt.setInt(2, count * (page - 1));
            ResultSet results = stmt.executeQuery();
            List<User> resultList = new LinkedList<>();
            while (results.next()) {
                resultList.add(new User(results));
            }
            return resultList;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static List<User> getInstructors() {
        try (Connection conn = DB.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM users WHERE Type='Instructor'"
             )) {
            ResultSet results = stmt.executeQuery();
            List<User> resultList = new LinkedList<>();
            while (results.next()) {
                resultList.add(new User(results));
            }
            return resultList;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static User find(long employeeId) {
        try (Connection conn = DB.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE UserId=?")) {
            stmt.setLong(1, employeeId);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                return new User(results);
            } else {
                return null;
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public void addClass(MSUClass randomClass) {
        try (Connection conn = DB.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO user_msu_classes (UserID, MSUClassId) VALUES (?, ?)")) {
            stmt.setLong(1, u_id);
            stmt.setLong(2, randomClass.getMSUClassId());
            stmt.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
