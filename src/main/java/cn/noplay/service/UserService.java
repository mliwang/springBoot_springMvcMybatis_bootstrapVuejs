package cn.noplay.service;

import cn.noplay.mapper.UserMapper;
import cn.noplay.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;
    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> getUserInfo() {
        List<User> users = userMapper.findUserInfo();
        for (User user:users) {
            System.out.print("账号："+user.getAccount());
        }

        return users;
    }

    /**
     * 根据主键查询用户
     *
     * @param userid
     * @return
     */
    public User selectByuserid(int userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        return user;

    }
    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    public User selectByAccount(String account){
        User user = userMapper.selectByAccount(account);
        return user;
    }

    /**
     * 增添用户
     * @param user
     * @return
     */
   public int insert(User user){
       int insert = userMapper.insert(user);
       return  insert;
   }
    /**
     * 修改联系人
     * @param user
     * @return
     */
  public int updateByPrimaryKey(User user){
      int i = userMapper.updateByPrimaryKey(user);
      return i;
  }



}