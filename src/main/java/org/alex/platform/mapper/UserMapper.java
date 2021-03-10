package org.alex.platform.mapper;

import org.alex.platform.pojo.UserDO;
import org.alex.platform.pojo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<UserVO> selectUserList(UserDO userDO);

    List<UserDO> checkUser(UserDO userDO);

    void updateUser(UserDO userDO);

    void insertUser(UserDO userDO);

    void deleteUser(Integer userId);

    UserDO selectUserToLogin(UserDO userDO);

    UserVO selectUserById(Integer userId);

    UserDO selectUserByName(String username);

}
