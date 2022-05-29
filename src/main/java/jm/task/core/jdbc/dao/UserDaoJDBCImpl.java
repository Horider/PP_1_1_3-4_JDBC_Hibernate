package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Statement statement = Util.getStatement();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String creteUsersTable = ("CREATE TABLE `mydbtest`.`new_table` " +
                "(`id` INT NOT NULL AUTO_INCREMENT," +
                "`name` VARCHAR(45) NOT NULL," +
                "`lastName` VARCHAR(45) NULL," +
                "`age` INT(3) NOT NULL, " +
                "PRIMARY KEY (`id`));");
        try {
            statement.execute(creteUsersTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String dropUsersTable =	("DROP TABLE `mydbtest`.`new_table`");

        try {
            statement.execute(dropUsersTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String saveUser = "INSERT INTO `mydbtest`.`new_table` " +
                "(`id`, `name`, `lastName`, `age`) " +
                "VALUES ('2', " +  name + ", " + lastName + ", " + age + ");";

//        String saveUser = "INSERT INTO `mydbtest`.`new_table` " +
//                "(`id`, `name`, `lastName`, `age`) " +
//                "VALUES ('1', 'Alex', 'Minashkin', '27');";

        try {
            statement.execute(saveUser);
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
