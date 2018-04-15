package com.waimaibang.service;

import com.waimaibang.model.ZkNode;

/**
 * @Author zhouguanya
 * @Date 2018/3/5
 * @Description
 */
public interface ZookeeperService {
    /**
     * 保存节点
     * @param zkNode
     */
    void save(ZkNode zkNode);

    /**
     * 更新节点
     * @param zkNode
     */
    void update(ZkNode zkNode);

    /**
     * 删除节点
     * @param zkNode
     */
    void delete(ZkNode zkNode);

    /**
     * 查询节点
     * @param path
     * @return
     */
    ZkNode find(String path);
}
