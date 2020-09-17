package cn.codewoo.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author kehong
 * 基本返回数据包装类
 */
@ApiModel("基本返回数据包装类")
public class DataResult<T> {
    @ApiModelProperty("返回代码")
    private String code;
    @ApiModelProperty("返回信息")
    private String msg;
    @ApiModelProperty("返回数据")
    private T data;

    /**
     * 不含数据的返回集
     * @param code
     * @param msg
     */
    public DataResult(String code,String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    /**
     * 含有返回数据的返回集
     * @param code
     * @param msg
     * @param data
     */
    public DataResult(String code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 获取不含数据的返回集
     * @param respCode
     * @return
     */
    public static <T>DataResult getResult(IBaseRespCode respCode){
        return new DataResult<T>(respCode.getCode(),respCode.getMsg());
    }

    /**
     * 获取不含数据的返回集
     * @param code
     * @param msg
     * @return
     */
    public static <T>DataResult getResult(String code, String msg){
        return new DataResult<T>(code,msg);
    }

    /**
     * 获取含有返回数据的返回集
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static <T>DataResult getResult(String code,String msg,T data){
        return new DataResult<>(code,msg,data);
    }

    /**
     * 获取含数据的返回集
     * @param respCode
     * @return
     */
    public static <T>DataResult getResult(IBaseRespCode respCode,T data){
        return new DataResult<T>(respCode.getCode(),respCode.getMsg(),data);
    }

    /**
     * 默认不含返回数据的操作成功返回集
     * @return
     */
    public static <T>DataResult success(){
        return new DataResult<>(BaseRespCode.SUCCESS.getCode(),BaseRespCode.SUCCESS.getMsg());
    }

    /**
     * 默认含有返回数据的操作成功返回集
     * @param data
     * @return
     */
    public static <T>DataResult success(T data){
        return new DataResult<>(BaseRespCode.SUCCESS.getCode(),BaseRespCode.SUCCESS.getMsg(),data);
    }

    /**
     * 默认不含返回数据的操作失败返回集
     * @return
     */
    public static <T>DataResult error(){
        return new DataResult<>(BaseRespCode.ERROR.getCode(),BaseRespCode.ERROR.getMsg());
    }

    /**
     * 默认含有返回数据的操作失败返回集
     * @param data
     * @return
     */
    public static <T>DataResult error(T data){
        return new DataResult<>(BaseRespCode.ERROR.getCode(),BaseRespCode.ERROR.getMsg(),data);
    }
}
