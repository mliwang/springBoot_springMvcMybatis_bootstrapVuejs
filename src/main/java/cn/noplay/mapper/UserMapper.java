package cn.noplay.mapper;

import cn.noplay.model.User;

import java.util.List;
public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    public List<User> findUserInfo();

    /**
     * 根据主键查询用户
     * @param userid
     * @return
     */
    User selectByPrimaryKey(int userid);

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    User selectByAccount(String account);

    /**
     * 增添用户
     * @param user
     */
    int insert(User user);

    /**
     * 修改联系人
     * @param user
     * @return
     */
    int updateByPrimaryKey(User user);

}
