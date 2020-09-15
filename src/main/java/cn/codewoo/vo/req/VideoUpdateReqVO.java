package cn.codewoo.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 视频更新VO
 * @author kehong
 */
@ApiModel("视频更新VO")
@Data
public class VideoUpdateReqVO {
    @ApiModelProperty(value = "视频id")
    private Integer id;
    @ApiModelProperty(value = "视频标题")
    private String title;
    @ApiModelProperty(value = "视频简介")
    private String summary;
    @ApiModelProperty(value = "封面图")
    private String coverImg;
    @ApiModelProperty("观看数")
    private Integer viewNum;
    @ApiModelProperty(value = "价格")
    private Integer price;
    @ApiModelProperty("是否上线")
    private Integer online;
    @ApiModelProperty(value = "分数")
    private Double point;
}
