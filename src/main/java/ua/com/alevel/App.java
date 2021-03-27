package ua.com.alevel;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.model.Job;
import ua.com.alevel.model.User;
import java.util.List;

public class App {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        Bson filterTitleAndAge = Filters.and(Filters.elemMatch("jobs", Filters.eq("title","Junior PHP")), Filters.gte("age", 36));
        List<User> titleAndAge = userDao.findAllByFilter(filterTitleAndAge);
        System.out.println(titleAndAge);

        Bson filterTitleJunior = Filters.elemMatch("jobs", Filters.regex("title", "Junior"));
        List<User> junior = userDao.findAllByFilter(filterTitleJunior);
        System.out.println(junior);

        Bson filterAmazon = Filters.elemMatch("jobs", Filters.in("organization", "Amazon"));
        List<User> amazonWorkers = userDao.findAllByFilter(filterAmazon);
        System.out.println(amazonWorkers);

        Bson filterJobsNumber = Filters.exists("jobs.3");
        List<User> jobsNumber = userDao.findAllByFilter(filterJobsNumber);
        System.out.println(jobsNumber);

    }

    private static User createUser(int age, String fullName, String title, List<Job> jobs) {
        User user = new User();
        user.setAge(age);
        user.setFullName(fullName);
        user.setTitle(title);
        user.setJobs(jobs);
        return user;
    }
}
