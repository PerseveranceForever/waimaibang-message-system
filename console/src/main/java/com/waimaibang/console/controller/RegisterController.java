package com.waimaibang.console.controller;

import com.waimaibang.console.dto.ProducerDTO;
import com.waimaibang.console.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhouguanya
 * @Date 2018/4/14
 * @Description
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/producer")
    @Transactional(rollbackFor = Exception.class)
    public Long registerProducer(@RequestBody ProducerDTO producerDTO) {
        return producerService.registerProducer(producerDTO);
    }
}
