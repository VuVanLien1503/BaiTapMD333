package service.my_class;

import DAO.StudentDAO;
import model.Student;
import service.my_interface.ICrud;
import service.my_interface.ISearch;

import java.util.List;

public class StudentService implements ICrud<Student>, ISearch<Student> {
    StudentDAO studentDAO = new StudentDAO();

    @Override
    public List<Student> selectAll() {
        return studentDAO.selectAllStudent();
    }

    @Override
    public void create(Student student) {
            studentDAO.create(student);
    }

    @Override
    public void delete(int id) {
        studentDAO.delete(id);
    }

    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }


    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findByName(String name) {
      return   studentDAO.findByName(name);
    }


}
