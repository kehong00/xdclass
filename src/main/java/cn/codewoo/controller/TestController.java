package cn.codewoo.controller;

import cn.codewoo.config.WeChatConfig;
import cn.codewoo.entity.Video;
import cn.codewoo.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kehong
 * 测试控制器
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private WeChatConfig weChatConfig;
    @Autowired
    private VideoMapper videoMapper;
    @GetMapping("/weChatConfiig")
    public String we_chat_config_test(){
        return weChatConfig.getAppId() + "\t" + weChatConfig.getAppSecret();
    }

    @GetMapping("/getVideo")
    public List<Video> getVideoAll(){
        List<Video> videos = videoMapper.selectAll();
        return videos;
    }

}
