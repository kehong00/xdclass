package cn.codewoo.utils;

/**
 * @author kehong
 * 响应码基本接口,每一个响应码类必须提供code和msg的获取方法
 */
public interface IBaseRespCode {
    /**
     * 获取响应码
     * @return
     */
    public String getCode();

    /**
     * 获取响应消息
     * @return
     */
    public String getMsg();
}
