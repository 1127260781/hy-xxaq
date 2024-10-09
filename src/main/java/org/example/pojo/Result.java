package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应结果
 * code 0 成果 1失败
 * data 响应数据
 */
@NoArgsConstructor //无参构造
@AllArgsConstructor //有参构造
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    //带数据
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "成功", data);
    }
    public static Result success() {
        return new Result(0, "成功", null);
    }
    //粗哦呜
    public static Result error(String message) {
        return new Result(1, message, null);
    }
}
