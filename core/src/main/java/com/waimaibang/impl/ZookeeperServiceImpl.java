package com.waimaibang.impl;

import com.alibaba.fastjson.JSON;
import com.waimaibang.model.ZkNode;
import com.waimaibang.service.ZookeeperService;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newCachedThreadPool;

/**
 * @Author zhouguanya
 * @Date 2018/3/5
 * @Description
 */
@Service("zookeeperService")
public class ZookeeperServiceImpl implements ZookeeperService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperServiceImpl.class);
    @Value("${spring.zk.url}")
    private String zookeeperUrl;

    @Value("${spring.zk.destination.path}")
    private String destinationPath;

    private static final int SESSION_TIMEOUT = 5000;

    @Autowired
    private TreeCacheListener treeCacheListener;

    private CuratorFramework curatorFramework;

    /**
     * Spring执行顺序：
     * Constructor > @PostConstruct > InitializingBean > init-method
     */
    @PostConstruct
    public void init() {
        RetryPolicy policy = new ExponentialBackoffRetry(1000, 10);
        curatorFramework = CuratorFrameworkFactory.builder().connectString(zookeeperUrl).sessionTimeoutMs(SESSION_TIMEOUT)
                .retryPolicy(policy).build();
        curatorFramework.start();
    }

    @PreDestroy
    public void destroy() {
        curatorFramework.close();
    }

    @Override
    public void save(ZkNode zkNode) {
        try {
            curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).
                    forPath(zkNode.getPath(), JSON.toJSONString(zkNode).getBytes());
        } catch (Exception e) {
            LOGGER.error("创建节点失败! 失败节点信息:{}, 异常信息:{}", zkNode, e);
        }
    }

    @Override
    public void update(ZkNode zkNode) {
        String path = zkNode.getPath();
        try {
            //获取节点数据
            ZkNode zkVersion = find(path);
            TreeCache treeCache = new TreeCache(curatorFramework, path);
            treeCache.start();
            ExecutorService executor = newCachedThreadPool();
            treeCache.getListenable().addListener(treeCacheListener, executor);
        } catch (Exception e) {
            LOGGER.error("创建节点失败! 失败节点信息:{}, 异常信息:{}", zkNode, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(ZkNode param) {

    }

    @Override
    public ZkNode find(String path) {
        try {
            //获取节点数据
            String data = new String(curatorFramework.getData().forPath(path));
            return JSON.parseObject(data, ZkNode.class);
        } catch (Exception e) {
            LOGGER.error("查询节点失败! 失败节点信息:{}, 异常信息:{}", path, e);
        }
        return null;
    }

}
