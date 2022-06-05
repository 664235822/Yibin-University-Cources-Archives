package zyd.myBatis.mapper;

import zyd.myBatis.po.User;

public interface UserMapper {
    // 通过id查询用户
    public User findUserByUsername(String username);

    // 添加客户
    public void addUser(User User);

}
