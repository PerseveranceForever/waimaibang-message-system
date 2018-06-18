package com.waimaibang.model.message;

import java.io.Serializable;

/**
 * @Author zhouguanya
 * @Date 2018/6/9
 * @Description
 */
public interface Message extends Serializable {
    /**
     * 来源
     * @return
     */
    Object getFrom();

    /**
     * 目的地
     * @return
     */
    Object getTo();

    /**
     * 消息体
     * @return
     */
    Object getData();

    /**
     * 校验
     * @return
     */
    Boolean validate();
}
