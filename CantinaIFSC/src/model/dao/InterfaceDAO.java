package model.dao;

import java.util.List;

public interface InterfaceDAO<T> {

    void create(T objeto);
    List<T> retrieve();
    T retrieve(int id);
    List<T> retrieve(T objeto);
    void update(T objeto);
    void delete(T objeto);
}
