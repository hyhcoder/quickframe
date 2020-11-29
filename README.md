## quickframe 快速搭建框架底层

### 简介
1.主要利用springboot, mybatis-plus搭建的整体项目;

2.利用分层, 把业务模块实现层, 数据库操作层, 以及通用的一些错误处理, util工具类分开, 避免代码重复;

3.主要是总结springboot一些项目分层的最佳实践和一些通用实现类的积累;

4.在一些如果需要快速搭建原型框架使用的项目, 可以快速构建使用;

5.微信/支付宝支付封装;

6.docker镜像进行部署;

### 分层介绍

#### 总体结构

``` lua
quickframe
├── quickframe-common -- 工具类及通用代码
├── quickframe-mbg -- MyBatisGenerator生成的数据库操作代码
├── quickframe-security -- SpringSecurity封装公用模块
├── quickframe-admin -- 后台业务逻辑实现接口
├── quickframe-portal -- 前台业务逻辑实现接口;(多套前端代码可以扩展这块)
├── quickframe-pay -- 支付相关的封装
└── quickframe-demo -- 框架搭建时的测试代码
```

#### common层
1.通用异常处理;(done)

2.api接口版本控制处理;

3.常用的工具类:
  * 二维码生成类;
  * 阿里云oss操作类;
  * http请求工具类(done)
  * 日期和json工具类
  * id生成类;
  * ip地址获取类;
  * springcontext获取类;

#### mbg层(数据库层) (done)
1.这里主要是提供了数据库层的单表映射和sql;

2.提供给其他层使用, 避免了冗余编写xml等操作; 引进mybatis-plus也是如此;

3.里面的CommonGenerator可以自动生成mapper, xml, model等;

#### security层 (权限认证封装层)
1.提供了对于SpringSecurity封装;

2.提供了Jwt token的封装实现;

#### admin层 (后台管理层)
> 后台管理, 查看订单, 配置产品等

1.提供了常用的用户-角色模块;

2.提供了菜单模块;

#### protal层 (前端接口层)
> 主要的业务逻辑实现, 这个要具体业务来

1.区域地址模块;

2.产品模块;

3.优惠券模块;

4.秒杀模块;

#### pay层 (支付封装层)
1.封装支付宝sdk;

2.封装微信支付sdk;

### 涉及的环境和技术

#### 技术选型
| 技术                 |    说明              | 官网                                                 |
| -------------------- |-------------------- | ---------------------------------------------------- |
| SpringBoot           |   容器+MVC框架        | https://spring.io/projects/spring-boot               |
| SpringSecurity       |   认证和授权框架      | https://spring.io/projects/spring-security           |
| MyBatis              |   ORM框架             | http://www.mybatis.org/mybatis-3/zh/index.html       |
| MyBatisGenerator     |   数据层代码生成      | http://www.mybatis.org/generator/index.html          |
| PageHelper           |   MyBatis物理分页插件 | http://git.oschina.net/free/Mybatis_PageHelper       |
| Swagger-UI           |   文档生产工具        | https://github.com/swagger-api/swagger-ui            |
| Hibernator-Validator |   验证框架            | http://hibernate.org/validator                       |
| RabbitMq             |   消息队列            | https://www.rabbitmq.com/                            |
| Redis                |   分布式缓存          | https://redis.io/                                    |
| Docker               |   应用容器引擎        | https://www.docker.com                               |
| Druid                |   数据库连接池         | https://github.com/alibaba/druid                     |
| OSS                  |   对象存储            | https://github.com/aliyun/aliyun-oss-java-sdk        |
| JWT                  |  JWT登录支持         | https://github.com/jwtk/jjwt                         |
| Lombok               |  简化对象封装工具    | https://github.com/rzwitserloot/lombok               |
| Jenkins              |  自动化部署工具      | https://github.com/jenkinsci/jenkins                 |

#### 主要开发环境和版本

| 工具          | 版本号 | 下载                                                         |
| ------------- | ------ | ------------------------------------------------------------ |
| IDEA          | 2019.2    | https://www.jetbrains.com/idea/download/other.html       |
| JDK           | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql         | 5.7    | https://www.mysql.com/                                       |
| Redis         | 3.2    | https://redis.io/download                                    |
| RabbitMq      | 3.7.14 | http://www.rabbitmq.com/download.html                        |
| Nginx         | 1.10   | http://nginx.org/en/download.html                            |

### 辅助脚本

1.https证书自动续签申请(letsencrypt)

2.部署脚本;

### 启动流程

todo

### 包含的最佳实践
// 测试master分支
todo
