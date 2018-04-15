package com.waimaibang.console.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author zhouguanya
 * @Date 2018/4/14
 * @Description
 */
@Data
public class ProducerDTO {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
