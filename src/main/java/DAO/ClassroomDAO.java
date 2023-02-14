package DAO;

import model.Classroom;
import model.Student;
import service.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDAO {
    private Connection connection;

    private final String SELECT_ALL = "select * from classroom;";


    public ClassroomDAO() {
        connection = MyConnection.getConnection();
    }



    public List<Classroom> selectAllClassroom() {
        List<Classroom> listClassroom = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                listClassroom.add(new Classroom(
                        resultSet.getInt(1),
                        resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listClassroom;
    }

}