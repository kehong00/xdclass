package cn.codewoo.vo.req;

import lombok.Builder;
import lombok.Data;

/**
 * @author kehong
 * 视频分页查询条件请求VO
 */
@Data
@Builder
public class VideoPageReqVO {
    private Integer page;
    private Integer size;
}
