package cn.codewoo.controller.admin;

import cn.codewoo.entity.Video;
import cn.codewoo.mapper.VideoMapper;
import cn.codewoo.utils.DataResult;
import cn.codewoo.vo.req.VideoInsertReqVO;
import cn.codewoo.vo.req.VideoUpdateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kehong
 * 视频表管理操作接口
 */
@Api(tags = "视频表管理操作")
@RequestMapping("/admin/api/video")
@RestController
public class VideoAdminController {
    private VideoMapper videoMapper;
    @Autowired(required = false)
    public void setVideoMapper(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }

    @ApiOperation(value = "根据id删除记录")
    @DeleteMapping("/del")
    public DataResult deleteById(@RequestParam Integer id){
        int result = videoMapper.deleteByPrimaryKey(id);
        if (result == 1){
            return DataResult.success();
        }
        return DataResult.error();
    }

    @ApiOperation("更新记录")
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

    @ApiOperation(value = "添加记录")
    @PostMapping("/add")
    public Integer insert(@RequestBody VideoInsertReqVO vo){
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
