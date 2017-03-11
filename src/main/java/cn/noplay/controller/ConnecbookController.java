package cn.noplay.controller;

import cn.noplay.model.Connectbook;
import cn.noplay.model.User;
import cn.noplay.service.ConnectbookService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 通讯录页面相关的
 * */

@Controller
public class ConnecbookController {
    private Logger logger = Logger.getLogger(ConnecbookController.class);
    @Autowired
    public ConnectbookService connectbookService;
    /**
     * 查看单个用户信息
     * @param find
     * @return
     */
    @RequestMapping("/FindCurrentConn")
    public String FindCurrentConn(Integer find,Model model){
        logger.info("welcome"+find);

        Connectbook connectbook = connectbookService.selectByPrimaryKey(find);
        model.addAttribute("connectbook",connectbook);
        return "updateconnect";
    }
    /**
     * 查看用户信息
     * @param session
     * @return
     */
    @RequestMapping("/getConnectbooInfo")
    @ResponseBody
    public  List<Connectbook> getConnectbooInfo(HttpSession session) {

        User currentuser = (User) (session.getAttribute("currentuser"));
        List<Connectbook> connectbookList = connectbookService.selectByUserId(currentuser.getUserid());

        return connectbookList;
    }
    /**
     *  插入联系人
     */
    @RequestMapping("/InsertConn")
    @ResponseBody
    public String InsertConn( Connectbook connectbook, HttpSession session){
        logger.info("_____*****"+connectbook.getContacts());
        User currentuser = (User) (session.getAttribute("currentuser"));
        connectbook.setUserid(currentuser.getUserid());
        int insert=0;
        insert = connectbookService.insert(connectbook);
        if(insert!=0){

        return "添加成功";}
        else {
            //插入失败
            logger.info("插入失败");
            return"插入失败";
        }

    }

    /**
     * 修改联系人
     * 此处注意页面传来的值中应该包含联系人id
     * @param connectbook
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/UpdateConn")
    public String UpdateConn(Connectbook connectbook, HttpSession session, Model model){
        logger.info("电话发动机回家" + "");
        User user=(User)session.getAttribute("currentuser");
        logger.info("%%%%%%%%%%%%"+user.getUserid());
        connectbook.setUserid(user.getUserid());

        int i = connectbookService.updateByPrimaryKey(connectbook);
        if(i!=0){
            List<Connectbook> list = connectbookService.selectByUserId(connectbook.getUserid());
            model.addAttribute("list",list);
            return "main";}
        else {
            //插入失败
            logger.info("修改失败");
            return"";
        }

    }
    @RequestMapping("/DeleteConn")
    @ResponseBody
    public String DeleteConn(Integer id,HttpSession session){
      String s="";
        int i =0;
        i=connectbookService.deleteByPrimaryKey(id);
        logger.info("已进入删除"+id+"删后"+i);
        if(i!=0){
       s= "删除成功";}
        else {
           s="删除失败";
        }
return s;
    }

}
