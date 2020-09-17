package cn.codewoo.vo.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author kehong
 * 分页查询数据封装响应VO
 */
@Data
public class PageRespVO<T> {
    @ApiModelProperty("当前页码")
    private Integer pageNum;
    @ApiModelProperty("每页显示数据条数")
    private Integer pageSize;
    @ApiModelProperty("当前页有的数据条数")
    private Integer size;
    @ApiModelProperty("总页数")
    private Integer pages;
    @ApiModelProperty("数据")
    private List<T> data;

}
