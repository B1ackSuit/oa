package cn.ean.oaemp.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @FileName ResponseBO
 * @Author ean
 * @Date 2023/3/10 23:51
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBO {

    private long code;

    private String message;

    private Object object;

    /**
     * 成功并写入返回信息，默认code为200，返回对象为null
     * @param message
     * @return 默认code为200，返回对象为null
     */
    public static ResponseBO success(String message) {
        return new ResponseBO(200, message, null);
    }

    /**
     * 成功并写入返回信息和返回对象，默认code为200
     * @param message
     * @param obj
     * @return 默认code为200
     */
    public static ResponseBO success(String message, Object obj) {
        return new ResponseBO(200, message, obj);
    }

    /**
     * 同成功
     * @param message
     * @return 默认code为500
     */
    public static ResponseBO error(String message) {
        return new ResponseBO(500, message, null);
    }

    /**
     * 同成功
     * @param message
     * @param obj
     * @return 默认code为500
     */
    public static ResponseBO error(String message, Object obj) {
        return new ResponseBO(500, message, obj);
    }
}
