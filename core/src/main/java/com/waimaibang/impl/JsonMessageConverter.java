package com.waimaibang.impl;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-13 23:04
 * @Description: JsonMessageConverter
 */
public class JsonMessageConverter implements MessageConverter {

    /**
     * Convert the payload of a {@link Message} from a serialized form to a typed Object
     * of the specified target class. The {@link MessageHeaders#CONTENT_TYPE} header
     * should indicate the MIME type to convert from.
     * <p>If the converter does not support the specified media type or cannot perform
     * the conversion, it should return {@code null}.
     *
     * @param message     the input message
     * @param targetClass the target class for the conversion
     * @return the result of the conversion, or {@code null} if the converter cannot
     * perform the conversion
     */
    @Override
    public Object fromMessage(org.springframework.messaging.Message<?> message, Class<?> targetClass) {
        return null;
    }

    /**
     * Create a {@link Message} whose payload is the result of converting the given
     * payload Object to serialized form. The optional {@link MessageHeaders} parameter
     * may contain a {@link MessageHeaders#CONTENT_TYPE} header to specify the target
     * media type for the conversion and it may contain additional headers to be added
     * to the message.
     * <p>If the converter does not support the specified media type or cannot perform
     * the conversion, it should return {@code null}.
     *
     * @param payload the Object to convert
     * @param headers optional headers for the message (may be {@code null})
     * @return the new message, or {@code null} if the converter does not support the
     * Object type or the target media type
     */
    @Override
    public org.springframework.messaging.Message<?> toMessage(Object payload, MessageHeaders headers) {
        return null;
    }
}
