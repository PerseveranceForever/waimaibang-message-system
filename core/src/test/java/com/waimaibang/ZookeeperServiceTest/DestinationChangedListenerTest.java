package com.waimaibang.ZookeeperServiceTest;

import com.waimaibang.model.ZkNode;
import com.waimaibang.service.ZookeeperService;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author zhouguanya
 * @Date 2018/3/4
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DestinationChangedListenerTest {
    @Value("${spring.zk.url}")
    private String zookeeperUrl;

    @Value("${spring.zk.destination.path}")
    private String destinationPath;

    @Autowired
    private ZookeeperService zookeeperService;

    /**
     * 测试新增zk节点
     * @throws Exception
     */
    @Test
    public void testSaveZkNode() throws Exception {
        ZkNode zkNode = new ZkNode();
        zkNode.setPath("/treeCache");
        zkNode.setData("123");
        zookeeperService.save(zkNode);
    }
}
