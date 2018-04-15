package com.waimaibang.console.service;

import com.waimaibang.console.dto.ProducerDTO;

/**
 * @Author zhouguanya
 * @Date 2018/4/14
 * @Description
 */
public interface ProducerService {
    /**
     * 注册生产者
     * @param producerDTO
     * @return
     */
    Long registerProducer(ProducerDTO producerDTO);
}
