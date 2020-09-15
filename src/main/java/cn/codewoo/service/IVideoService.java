package cn.codewoo.service;

import cn.codewoo.entity.Video;

import java.util.List;

/**
 * @author kehong
 * 视频表服务层接口
 */
public interface IVideoService {
    /**
     * 根据主键删除
     * @param id 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     * @param record 实体对象
     * @return 影响行数
     */
    int insert(Video record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(Video record);

    /**
     * 根据主键查询
     * @param id 主键
     * @return 查询的实体
     */
    Video selectByPrimaryKey(Integer id);

    /**
     * 更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Video record);

    /**
     * 更新数据
     * @param record 实体对象
     * @return 影响行数
     */
    int updateByPrimaryKey(Video record);

    /**
     * 查询所有记录
     * @return 所有记录
     */
    List<Video> selectAll();
}
