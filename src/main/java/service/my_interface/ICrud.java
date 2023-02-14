package service.my_interface;
import java.util.List;

public interface ICrud<E> {
    public List<E> selectAll();
    public void create(E e);
    public void delete(int id) ;
    public void update(E e);
}
