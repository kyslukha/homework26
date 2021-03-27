package ua.com.alevel.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import ua.com.alevel.util.MongoDbUtils;
import ua.com.alevel.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {
    private final MongoCollection<User> collection = MongoDbUtils.getCollection("users", User.class);

    @Override
    public User get(ObjectId id) {
        return collection.find(Filters.eq(id)).first();
    }

    public List<User> findAllByTitle(String title) {
        List<User> users = new ArrayList<>();
        for (User user: collection.find(Filters.eq("title", title))) {
            users.add(user);
        }
        return users;
    }

    public List<User> findAllByFilter(Bson bson) {
        List<User> users = new ArrayList<>();
        for (User user: collection.find(bson)) {
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for (User user : collection.find()) {
            users.add(user);
        }
        return users;
    }

    @Override
    public void delete(ObjectId id) {
        collection.deleteOne(Filters.eq(id));
    }

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            collection.insertOne(user);
        } else {
            collection.replaceOne(Filters.eq(user.getId()), user);
        }
    }
}
