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

    private final String SELECT_ALL = "select * from student where status = true;";
    private final String SELECT_STUDENT_BY_ID = "select * from student where id = ? and status = true";

    private final String UPDATE_STUDENT = "update student set name=?, date=?, address = ?,phone=?,email=?,classroom_id=? where id = ?";
    private final String DELETE_STUDENT = "update student set status = false where id = ?";

    private final String SELECT_BY_NAME = "select * from student where student.name like ? and status = true ;";

    private final String INSERT_STUDENT = "insert into student(name,date,address,phone,email,classroom_id)values(?,?,?,?,?,?)";


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

    public void update(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {
            preparedStatement.setString(1, student.getName());

            java.sql.Date sqlDate = new java.sql.Date(student.getBirth().getTime());
            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getClassroom_id());
            preparedStatement.setInt(7, student.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException a) {
            a.printStackTrace();
        }
    }

    public List<Student> findByName(String value) {
        List<Student> listStudent = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME)) {
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
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

    public void create(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {
            preparedStatement.setString(1, student.getName());

            java.sql.Date sqlDate = new java.sql.Date(student.getBirth().getTime());

            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getClassroom_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}