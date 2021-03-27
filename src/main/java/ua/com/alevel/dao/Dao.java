package ua.com.alevel.dao;

import org.bson.types.ObjectId;
import ua.com.alevel.model.User;

import java.util.List;

public interface Dao<T> {
    T get(ObjectId id);

    List<T> findAll();

    void delete(ObjectId id);

    void save(User user);
}
