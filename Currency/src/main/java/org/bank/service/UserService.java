package org.bank.service;

import org.bank.dao.UserDao;
import org.bank.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }
    public void addUser(User user){
        dao.save(user);
    }
    public List<User> findAll(){
        return dao.findAll();
    }
    public User findById(Integer integer) {
        return dao.findById(integer);
    }
    public void remove(Integer integer) {
        dao.delete(integer);

    }
    public User update(User user) {
        return dao.update(user);
    }
}
