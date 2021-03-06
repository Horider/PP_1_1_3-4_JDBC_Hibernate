package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String creteUsersTable = ("CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(64), " +
                "last_name VARCHAR(64), " +
                "age INT)");;

        try (Statement statement = Util.connection.createStatement()) {
            statement.execute(creteUsersTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String dropUsersTable = ("DROP TABLE IF EXISTS users;");

        try (Statement statement = Util.connection.createStatement()) {
            statement.execute(dropUsersTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String saveUser = ("INSERT INTO users" +
                "(`name`, `last_name`, `age`) " +
                "VALUES (?, ?, ?);");

        try (PreparedStatement preparedStatement = Util.connection.prepareStatement(saveUser)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String removeUserById = ("DELETE FROM users " +
                "WHERE id=?;");
        try (PreparedStatement preparedStatement = Util.connection.prepareStatement(removeUserById))
        {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List <User> userList = new ArrayList<>();
        String getAllUsers = ("SELECT * FROM users");

        try (Statement statement = Util.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getAllUsers))
        {
            while (resultSet.next()) {
                User user = new User(resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age"));
                user.setId(resultSet.getLong("id"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        String cleanUsersTable = "TRUNCATE TABLE users";
        try (Statement statement = Util.connection.createStatement()) {
            statement.execute(cleanUsersTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
