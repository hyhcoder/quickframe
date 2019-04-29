## quickframe 快速搭建框架底层

### 简介
1. 主要利用springboot, mybatis-plus搭建的整体项目;
2. 利用分层, 把业务模块实现层, 数据库操作层, 以及通用的一些错误处理, util工具类分开;
3. 主要是总结springboot一些项目分层的最佳实践和一些通用类的积累;
4. 在一些如果需要快速搭建原型框架使用的项目, 可以快速构建使用;

### 分层介绍

#### common层
1. 通用异常处理;
2. api接口版本控制处理;
3. 常用的工具类:
   * 二维码生成类;
   * 阿里云oss操作类;
   * http请求工具类
   * 日期和json工具类

#### mbg层(数据库层)
1. 这里主要是提供了数据库层的单表映射和sql;
2. 提供给其他层使用, 避免了冗余编写xml等操作; 引进mybatis-plus也是如此;
3. 里面的CommonGenerator可以自动生成mapper, xml, model等;

#### protal层

todo

#### 以及其他业务平行层

todo

### 使用说明

todo

### 包含的最佳实践

todo

### 参考项目
1. https://github.com/looly/hutool
2. https://github.com/macrozheng/mall
https://github.com/neatlife/jframework