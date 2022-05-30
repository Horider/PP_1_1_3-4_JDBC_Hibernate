package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    private final static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        Util.getConnection();
        userService.createUsersTable();

        userService.saveUser("Александр", "Пушкин", (byte) 37);
        userService.saveUser("Максим", "Горький", (byte) 68);
        userService.saveUser("Фёдор", "Достоевский", (byte) 59);
        userService.saveUser("Иван", "Бунин", (byte) 83);

        userService.removeUserById(1L);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();

        try {
            Util.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
