package cn.noplay.controller;

import cn.noplay.model.Connectbook;
import cn.noplay.model.User;
import cn.noplay.service.ConnectbookService;
import cn.noplay.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    public UserService userService;
 @Autowired
    public ConnectbookService connectbookService;
    @RequestMapping("/Login")
    public String greeting() {
        return "Login";
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public java.util.List<User> getUserInfo() {
        java.util.List <User> users = userService.getUserInfo();
        for (User user:users ) {
            if(user!=null){
                System.out.println("user.getName():"+user.getName());
                logger.info("user.getAge():"+user.getAge());
            }
        }

        return users;
    }
    @RequestMapping(value = "/Register",method = RequestMethod.POST)
    public ModelAndView UserRegister(User user,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        //查当前用户是否已存在
        User user1 = userService.selectByAccount(user.getAccount());
        if (user1==null){
            userService.insert(user);
            modelAndView.addObject("flag","注册成功");
            modelAndView.setViewName("Login");
            return modelAndView;
        }
        else{
            modelAndView.addObject("flag","用户已存在！");
            modelAndView.setViewName("Login");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/LoginCheck",method = RequestMethod.POST)
    public ModelAndView UserLogin(User user,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if (user==null){
            modelAndView.addObject("flag","请填写登录信息");
            modelAndView.setViewName("Login");
            return modelAndView;
        }
        User user1 = userService.selectByAccount(user.getAccount());
        if (user1==null){
            modelAndView.addObject("flag","用户名不存在");
            modelAndView.setViewName("Login");
            return modelAndView;
        }
        else if (user.getUserpassword().equals(user1.getUserpassword()))
        { //密码正确进入通讯录
            session.setAttribute("currentuser", user1);
           List<Connectbook> connectbookList = connectbookService.selectByUserId(user1.getUserid());
     modelAndView.addObject("ConnectbookList",connectbookList);
            modelAndView.setViewName("main4");
            return modelAndView;
        }
        else{
            modelAndView.addObject("flag","用户名或密码不正确");
            modelAndView.setViewName("Login");
            return modelAndView;
        }
    }
}
