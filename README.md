本项目配合使用dubbo-api接口使用

1，项目基础采用spring，spring-jdbc，dubbo（dubbox），mysql，并且对相关操作添加事务，主要是针对事务处理
注：本项目只是想你说明使用事务，而不是soa中的分布式事务
注册中心我们采用的是zookeeper，数据库mysql都是需要准备好

2.spring的配置我们采用注解的形式存在，dubbo服务的形式我们采用配置文件的形式，便于区分

3，spring中事务的处理我们是采用配置文件的形式，在dubbo中注解是用service，spring中服务层也是service，
而且也不需要再每个service层去添加，只需要一个配置文件就行