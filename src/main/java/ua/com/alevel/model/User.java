package ua.com.alevel.model;

import org.bson.types.ObjectId;

import java.util.List;

public class User {
    private ObjectId id;
    private String fullName;
    private int age;
    private String title;
    private List<ua.com.alevel.model.Job> jobs;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ua.com.alevel.model.Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<ua.com.alevel.model.Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", title='" + title + '\'' +
                ", jobs=" + jobs +
                '}';
    }
}
