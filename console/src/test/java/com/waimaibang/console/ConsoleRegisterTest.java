package com.waimaibang.console;

import com.waimaibang.console.dao.ConsumerDao;
import com.waimaibang.console.dao.DestinationDao;
import com.waimaibang.console.dao.ProducerDao;
import com.waimaibang.console.model.Consumer;
import com.waimaibang.console.model.Destination;
import com.waimaibang.console.model.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhouguanya
 * @Date 2018/4/14
 * @Description 注册相关服务测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsoleRegisterTest {

    @Autowired
    private ProducerDao producerDao;
    @Autowired
    private ConsumerDao consumerDao;
    @Autowired
    private DestinationDao destinationDao;

    /**
     * 模拟控制台producer/consumer/destination注册服务
     * @Transactional 不提交修改
     */
    @Test
    @Transactional
    public void loginTest() {
        Long producerId = registerProducer();
        Long consumerId = registerConsumser();
        Long destinationId = registerDestination();
        //绑定producerId、destinationId
        int producerDestinationInsertResult = destinationDao.bindProducerDestination(producerId, destinationId);
        //绑定consumerId、destinationId
        int consumerDestinationInsertResult = destinationDao.bindConsumerDestination(consumerId, destinationId);
        System.out.printf("register a new producer, id = %s%n", producerId);
        System.out.printf("register a new consumer, id = %s%n", consumerId);
        System.out.printf("register a new destination, id = %s%n", destinationId);
        System.out.printf("register a new producerDestination, result = %s%n", producerDestinationInsertResult > 0);
        System.out.printf("register a new consumerDestination, result = %s%n", consumerDestinationInsertResult > 0);

    }

    /**
     * 模拟注册producer
     * @return
     */
    public Long registerProducer() {
        Producer producer = new Producer();
        producer.setName("test_producer");
        producerDao.insertSelective(producer);
        return producer.getId();
    }

    /**
     * 模拟注册consumer
     * @return
     */
    public Long registerConsumser() {
        Consumer consumer = new Consumer();
        consumer.setName("test_producer");
        consumerDao.insertSelective(consumer);
        return consumer.getId();
    }

    /**
     * 模拟注册destination
     * @return
     */
    public Long registerDestination() {
        Destination destination = new Destination();
        destination.setName("test_destination");
        destinationDao.insertSelective(destination);
        return destination.getId();
    }

 }
