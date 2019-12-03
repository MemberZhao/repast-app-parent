package com.aaa.lee.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author Whc
 * @Date 2019/11/29 16:00
 * @Description
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CommentProVo implements Serializable {

    private Long orderId;
    private Long productId;
    private String productName;
    private String name;


}
