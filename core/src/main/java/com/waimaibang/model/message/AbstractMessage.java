package com.waimaibang.model.message;

import com.waimaibang.model.Destination;
import org.springframework.jms.support.converter.MessageConverter;

import java.util.LinkedList;

/**
 * @Author zhouguanya
 * @Date 2018/6/9
 * @Description
 */
public abstract class AbstractMessage implements Message {
    /**
     * 生产者名
     */
    protected String producerName;
    /**
     * 消费者名
     */
    protected String consumerName;
    /**
     * 双向链表。消息经过的链路，每经过一个队列，就会在链表中新增一个节点。最后一个节点就是最终落地点
     */
    protected LinkedList<String> chain;
    /**
     * 消息队列
     */
    protected Destination destination;
    /**
     * 消息体
     */
    protected Object data;
    /**
     * 消息转换器
     */
    protected MessageConverter messageConverter;

    /**
     * 来源
     *
     * @return
     */
    @Override
    public Object getFrom() {
        return producerName;
    }

    /**
     * 目的地
     *
     * @return
     */
    @Override
    public Object getTo() {
        return consumerName;
    }

    /**
     * 消息体
     *
     * @return
     */
    @Override
    public Object getData() {
        return data;
    }
}
