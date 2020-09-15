package cn.codewoo.controller;

import cn.codewoo.entity.Video;
import cn.codewoo.mapper.VideoMapper;
import cn.codewoo.vo.req.VideoInsertReqVO;
import cn.codewoo.vo.req.VideoUpdateReqVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kehong
 * Video控制层
 */
@RestController
@RequestMapping("/api/video")
public class VideoController {
    @Autowired(required = false)
    private VideoMapper videoMapper;
    @GetMapping("/page")
    public List<Video> pageVideo(){
        return videoMapper.selectAll();
    }
    @GetMapping("/get")
    public Video selectById(@RequestParam Integer id){
        return videoMapper.selectByPrimaryKey(id);
    }
    @DeleteMapping("/del")
    public Integer deleteById(@RequestParam Integer id){
        return videoMapper.deleteByPrimaryKey(id);
    }

    @PutMapping("/update")
    public Integer updateById(@RequestBody VideoUpdateReqVO vo){
        Video video = Video.builder()
                .id(vo.getId())
                .coverImg(vo.getCoverImg())
                .online(vo.getOnline())
                .point(vo.getPoint())
                .price(vo.getPrice())
                .summary(vo.getSummary())
                .title(vo.getTitle())
                .viewNum(vo.getViewNum()).build();
        return videoMapper.updateByPrimaryKeySelective(video);
    }

    @PostMapping("/add")
    public Integer insert(@RequestBody VideoInsertReqVO vo){
//        Video video = Video.builder().build();
//        BeanUtils.copyProperties(vo,video);
        Video video = Video.builder()
                .createTime(vo.getCreateTime())
                .viewNum(vo.getViewNum())
                .title(vo.getTitle())
                .summary(vo.getSummary())
                .price(vo.getPrice())
                .point(vo.getPoint())
                .online(vo.getOnline())
                .coverImg(vo.getCoverImg())
                .build();
        return videoMapper.insertSelective(video);
    }
}
