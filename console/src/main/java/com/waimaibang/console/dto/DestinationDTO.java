package com.waimaibang.console.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author zhouguanya
 * @Date 2018/4/14
 * @Description
 */
@Data
public class DestinationDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
