# springboot_activemq_demo

# ActiveMQ安装启动
* 下载：http://activemq.apache.org/activemq-5153-release.html
* 启动：切换到bin目录，执行./activemq start

# ZooKeeper安装和启动
1.下载： http://zookeeper.apache.org/releases.html 
2. 在conf目录下新建zoo.cfg文件，写入以下内容保存：
* tickTime=2000
* dataDir=/usr/myapp/zookeeper-3.4.5/data
* dataLogDir=/usr/myapp/zookeeper-3.4.5/logs
* clientPort=2181
3. zk服务启动和停止命令
* ./zkServer.sh start
* ./zkServer.sh stop
* ./zkServer.sh restart
* ./zkServer.sh status

# Redis安装和启动
1.下载：https://redis.io/
2.启动：redis-server */redis.conf
