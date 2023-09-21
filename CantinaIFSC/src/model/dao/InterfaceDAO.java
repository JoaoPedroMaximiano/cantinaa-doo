package model.dao;

import java.util.List;

public interface InterfaceDAO<T> {

    void create(T objeto);
    List<T> retrive();
    T retrive(int id);
    List<T> retrive(T objeto);
    void update(T objeto);
    void delete(T objeto);
}
