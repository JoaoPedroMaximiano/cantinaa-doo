package model.dao;

import java.util.List;

public interface InterfaceDAO<T> {

    void create(T object);
    List<T> retrive();
    T retrive(int id);
    T retrive(String string);
    void update(T objeto);
    void delete(T objeto);
}
