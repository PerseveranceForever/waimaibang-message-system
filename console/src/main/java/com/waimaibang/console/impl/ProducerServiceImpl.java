package com.waimaibang.console.impl;

import com.waimaibang.console.dao.ProducerDao;
import com.waimaibang.console.dto.ProducerDTO;
import com.waimaibang.console.model.Producer;
import com.waimaibang.console.service.ProducerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhouguanya
 * @Date 2018/4/14
 * @Description
 */
@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private ProducerDao producerDao;

    @Override
    public Long registerProducer(ProducerDTO producerDTO) {
        Producer producer = new Producer();
        BeanUtils.copyProperties(producerDTO, producer);
        producerDao.insertSelective(producer);
        return producer.getId();
    }
}
