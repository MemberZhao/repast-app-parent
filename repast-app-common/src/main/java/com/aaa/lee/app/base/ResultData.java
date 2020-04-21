package com.aaa.lee.app.base;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Company 
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:08
 * @Description
 *      
 *      定义统一的返回值类型
 *      code:返回状态码
 *      msg:返回消息("保存错误")
 *      detail:返回消息的详细内容
 *      data:所要返回的数据
 **/
@Data
@Component
public class ResultData<T> implements Serializable {

    private String code;
    private String msg;
    private String detail;
    private T data;
}
