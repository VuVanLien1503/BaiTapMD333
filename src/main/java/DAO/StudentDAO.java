package DAO;

import model.Student;
import service.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection;

    private final String SELECT_ALL = "select * from student;";
    private final String SELECT_STUDENT_BY_ID = "select * from student where id = ? and status = true";


    public StudentDAO() {
        connection = MyConnection.getConnection();
    }

    public List<Student> selectAllStudent() {
        List<Student> listStudent = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                listStudent.add(new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listStudent;
    }

    public Student findById(int id) {
        Student student = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}