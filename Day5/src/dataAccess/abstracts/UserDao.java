package dataAccess.abstracts;

import entities.concretes.User;

public interface UserDao {

	void register(User user);
    void login(User user);
    void delete(User user);
    User getByMail(String mail);
}
