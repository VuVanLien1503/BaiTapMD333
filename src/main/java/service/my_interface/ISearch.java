package service.my_interface;

import java.util.List;

public interface ISearch<E> {
    public E findById(int id);
    public List<E> findByName(String name);
}
