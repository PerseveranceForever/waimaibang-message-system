package com.waimaibang.model.message;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.jms.support.converter.SimpleMessageConverter;

/**
 * @Author zhouguanya
 * @Date 2018/6/9
 * @Description
 */
@Data
public class JsonMessage extends AbstractMessage {
    /**
     * 校验
     *
     * @return
     */
    @Override
    public Boolean validate() {
        if (messageConverter == null) {
            messageConverter = new SimpleMessageConverter();
        }

        //TODO 假设有些校验操作
        try {
            //解析JSON
            JSON.toJSONString(this);
        } catch (Exception e) {
            return false;
        }
        return null;
    }
}
