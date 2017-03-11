package cn.noplay.mapper;

import cn.noplay.model.Connectbook;

import java.util.List;

public interface ConnectbookMapper {
    /**
     * 根据id删除某一联系人
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 增加联系人
     * @param record
     * @return
     */
    int insert(Connectbook record);
    /**
     * 根据主键查询联系人
     * @param id
     * @return
     */
    Connectbook selectByPrimaryKey(Integer id);
    /**
     * 根据用户id查询相关联系人
     * @param userid
     * @return
     */
   List<Connectbook> selectByUserId(Integer userid);

    /**
     * 修改联系人
     * @param record
     * @return
     */
    int updateByPrimaryKey(Connectbook record);
}