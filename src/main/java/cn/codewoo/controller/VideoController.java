package cn.codewoo.controller;

import cn.codewoo.entity.Video;
import cn.codewoo.mapper.VideoMapper;
import cn.codewoo.utils.DataResult;
import cn.codewoo.vo.req.VideoInsertReqVO;
import cn.codewoo.vo.req.VideoPageReqVO;
import cn.codewoo.vo.req.VideoUpdateReqVO;
import cn.codewoo.vo.resp.PageRespVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kehong
 * Video控制层
 */
@RestController
@RequestMapping("/api/video")
@Api(tags = "视频相关api")
public class VideoController {
    private VideoMapper videoMapper;
    @Autowired(required = false)
    public void setVideoMapper(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }


    @PostMapping("/page")
    @ApiOperation(value = "视频分页查询")
    public DataResult<Video> pageVideo(@RequestBody VideoPageReqVO vo){
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<Video> videos = videoMapper.selectAll();
        PageInfo<Video> pageInfo = new PageInfo<>(videos);
        PageRespVO<Video> respVO = new PageRespVO<>();
        respVO.setData(pageInfo.getList());
        respVO.setPageNum(pageInfo.getPageNum());
        respVO.setPages(pageInfo.getPages());
        respVO.setPageSize(pageInfo.getPageSize());
        respVO.setSize(pageInfo.getSize());
        return DataResult.success(respVO);
    }@ApiOperation(value = "根据id查询视频记录")
    @GetMapping("/get")
    public DataResult<Video> selectById(@RequestParam Integer id){
        Video video = videoMapper.selectByPrimaryKey(id);
        return DataResult.success(video);
    }

}
