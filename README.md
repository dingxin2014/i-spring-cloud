# spring cloud example

## Gradle
- 鉴于BuildSrc中有自定义Gradle插件需要配置Gradle环境和GROOVY环境

## SpringCloud包含了多个子项目(针对分布式系统中涉及的多个不同开源产品，还可能
会新增)， 如下所述。
- SpringCloudConfig: 配置管理工具， 支持使用Git存储 配置内容， 可以使用它实现 应用配置的外部化存储， 并支持客户端配置信息刷新、 加密/解密配置内容 等。
- SpringCloudNetflix: 核心 组件， 对多个Netflix OSS开源套件进行整合。
提供强大 的容错能力。
- Ribbon: 客户端负载均衡的服务调用组件。
 续的处理， 比如用来动态刷新配置等。
- Spring Cloud Cluster: 针对 ZooKeeper、 Redis、 Hazelcast、 Consul 的选举算法和通用 状态模式的实现。
- Spring Cloud Cloudfoundry: 与 Pivotal Cloud undry 的整合支持。
- Spring Cloud Stream: 通过 Redis、 Rabbit 或者 Ka a 实现的消费微服务， 可以通过 简单的声明式模型来发送和接收消息。
- SpringCloudAWS: 用千简化整合AmazonWebService的组件。
- Spring Cloud Security: 安全工具包， 提供在 Zuul 代理中对 0Auth2 客户端请求的中
- Spring Cloud Sleuth: Spring Cloud 应用的分布式跟踪实现， 可以完美整合 Zipkin。
- SpringCloudZooKeeper: 基于ZooKeeper的服务发现与配置管理组件。
- Spring Cloud Starters: Spring Cloud 的基础组件， 它是基于 Spring Boot 风格项目的
基础依赖模块。
- Spring Cloud CLI: 用于在 Groovy 中快速创建 Spring Cloud 应用的 Spring Boot CLI 

## Docker
- 配置Docker环境
- 构建docker镜像 e.g 在 demo 目录下执行 
  ```docker build -t dingxin/demo:0.1 -f src/main/docker/Dockerfile --build-arg JAR=demo-service-0.0.1-SNAPSHOT .```
