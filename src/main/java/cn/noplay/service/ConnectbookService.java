package cn.noplay.service;

import cn.noplay.mapper.ConnectbookMapper;
import cn.noplay.model.Connectbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
@Service
public class ConnectbookService {
    @Autowired
    public ConnectbookMapper connectbookMapper;
    /**
     * 根据id删除某一联系人
     * @param id
     * @return
     */
   public int deleteByPrimaryKey(Integer id){
       int i = connectbookMapper.deleteByPrimaryKey(id);
       return i;
   }
    /**
     * 增加联系人
     * @param record
     * @return
     */
   public int insert(Connectbook record){
      return connectbookMapper.insert(record);
    }
    /**
     * 根据主键查询联系人
     * @param id
     * @return
     */
    public Connectbook selectByPrimaryKey(Integer id){
        return connectbookMapper.selectByPrimaryKey(id);
    }
    /**
     * 根据用户id查询相关联系人
     * @param userid
     * @return
     */
    public List<Connectbook> selectByUserId(Integer userid){
        return connectbookMapper.selectByUserId(userid);
    }

    /**
     * 根据联系人id修改联系人
     * @param record
     * @return
     */
    public int updateByPrimaryKey(Connectbook record){
        return connectbookMapper.updateByPrimaryKey(record);
    }

}
