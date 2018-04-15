package com.waimaibang.impl;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author zhouguanya
 * @Date 2018/3/4
 * @Description 监听Destination改变
 */
@Service("TreeCacheListener")
public class DestinationChangedListener implements TreeCacheListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
        TreeCacheEvent.Type treeCacheEventType = treeCacheEvent.getType();
        switch (treeCacheEventType) {
            case NODE_ADDED:
                nodeAddedHandler(treeCacheEvent);
                break;
            case NODE_UPDATED:
                nodeUpdatedHandler(treeCacheEvent);
                break;
            case NODE_REMOVED:
                nodeRemovedHandler(treeCacheEvent);
                break;
            default:
                logger.error("未知类型：{}", treeCacheEventType);
                break;
        }
    }

    /**
     * 监听新增节点事件处理
     * @param treeCacheEvent
     */
    private void nodeAddedHandler(TreeCacheEvent treeCacheEvent) {
        logger.info("NODE_ADDED：路径：{}, ，数据：{}, 状态：{}",treeCacheEvent.getData().getPath(), new String(treeCacheEvent.getData().getData())
                , treeCacheEvent.getData().getStat());
    }

    /**
     * 监听更新节点事件处理
     * @param treeCacheEvent
     */
    private void nodeUpdatedHandler(TreeCacheEvent treeCacheEvent) {
        logger.info("NODE_UPDATED：路径：{}, ，数据：{}, 状态：{}",treeCacheEvent.getData().getPath(), new String(treeCacheEvent.getData().getData())
                , treeCacheEvent.getData().getStat());
    }

    /**
     * 监听删除节点事件处理
     * @param treeCacheEvent
     */
    private void nodeRemovedHandler(TreeCacheEvent treeCacheEvent) {
        logger.info("NODE_REMOVED：路径：{}, ，数据：{}, 状态：{}",treeCacheEvent.getData().getPath(), new String(treeCacheEvent.getData().getData())
                , treeCacheEvent.getData().getStat());
        //TODO 如果用redis存储节点状态，删除了节点后，要删除对应的缓存，然后再发起申请新节点

    }
}