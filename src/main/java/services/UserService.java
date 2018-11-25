package services;

import dao.UserDao;
import model.UserModel;

import java.util.List;

public class UserService {

    static UserDao userDao = new UserDao();

    public void createUser(UserModel user) {

        userDao.createUser(user);
    }

    public UserModel getUser(UserModel user) {

        user = userDao.getUser(user);

        return user;
    }



    public UserModel getUserById(int id) {
        UserModel user = userDao.getUserById(id);
        return user;

    }



    public  void updateProduct(UserModel user) {
        userDao.updateUser(user);

    }

    public List<UserModel> getUsers() {
        return userDao.getUsers();
    }

}
