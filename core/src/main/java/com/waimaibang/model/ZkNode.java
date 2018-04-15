package com.waimaibang.model;

import lombok.Data;

/**
 * @Author zhouguanya
 * @Date 2018/4/14
 * @Description
 */
@Data
public class ZkNode<T> {
    private Integer id;

    private T data;

    private String path;
}
