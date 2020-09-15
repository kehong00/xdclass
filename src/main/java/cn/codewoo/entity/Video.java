package cn.codewoo.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 视频实体类
 * @author kehong
 */
@Data
@Builder
public class Video implements Serializable {
    private Integer id;

    private String title;

    private String summary;

    private String coverImg;

    private Integer viewNum;

    private Integer price;

    private Date createTime;

    private Integer online;

    private Double point;

    private static final long serialVersionUID = 1L;

}