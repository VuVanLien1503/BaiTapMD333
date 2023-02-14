package service.my_class;

import DAO.ClassroomDAO;
import model.Classroom;
import service.my_interface.ICrud;

import java.util.List;

public class ClassroomService implements ICrud<Classroom> {
        ClassroomDAO classroomDAO=new ClassroomDAO();
    @Override
    public List<Classroom> selectAll() {
        return classroomDAO.selectAllClassroom();
    }

    @Override
    public void create(Classroom classroom) {

    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void update(Classroom classroom) {

    }
}
