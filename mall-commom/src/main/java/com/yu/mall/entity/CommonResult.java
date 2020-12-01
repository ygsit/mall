package com.yu.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = -51426060427850421L;

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
       this(code, message, null);
    }
}
