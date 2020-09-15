package cn.codewoo.service.impl;

import cn.codewoo.entity.Video;
import cn.codewoo.mapper.VideoMapper;
import cn.codewoo.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author kehong
 */
public class VideoServiceImpl implements IVideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return videoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Video record) {
        return videoMapper.insert(record);
    }

    @Override
    public int insertSelective(Video record) {
        return videoMapper.insertSelective(record);
    }

    @Override
    public Video selectByPrimaryKey(Integer id) {
        return videoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Video record) {
        return videoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Video record) {
        return videoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Video> selectAll() {
        return videoMapper.selectAll();
    }
}
