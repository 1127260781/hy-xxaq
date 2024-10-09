package org.example.service;


import org.example.pojo.User;

public interface UserService {
    User findByUserName(String username);//查询用户

    void register(String username, String password);//注册

    void update(User user);//更新

    void updateAvatar(String avatarUrl);

    void updatePwd(String newPwd);
}
