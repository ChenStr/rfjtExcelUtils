package com.rfjttest.entity;

import lombok.Data;

/**
 * @author Chen Zhenyang
 * @Data 2024/6/8
 * @apiNote
 */
@Data
public class Result {

    private String code;

    private Object data;

    public Result(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result() {
    }

}
