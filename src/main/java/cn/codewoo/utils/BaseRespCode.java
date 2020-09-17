package cn.codewoo.utils;

/**
 * @author kehong
 * 响应码枚举
 */

public enum BaseRespCode implements IBaseRespCode{
    SUCCESS("20000","操作成功"),
    ERROR("40000","操作失败"),
    ;

    private String code;
    private String msg;

    BaseRespCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
