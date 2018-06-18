package com.waimaibang.model.message;

import lombok.Data;

/**
 * @Author zhouguanya
 * @Date 2018/6/9
 * @Description
 */
@Data
public class ByteMessage extends AbstractMessage {
    /**
     * 校验
     *
     * @return
     */
    @Override
    public Boolean validate() {
        return null;
    }
}
