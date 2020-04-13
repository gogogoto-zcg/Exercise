##SpringCloud config 

参考https://blog.csdn.net/qazwsxpcm/article/details/88578076
* springboot 2.2.6
* springCloud Hoxton.SR3

### git 寻找配置文件 需要拼接以下规则文件路径
* /{application}/{profile}[/{label}]
* /{application}-{profile}.yml
* /{label}/{application}-{profile}.yml
* /{application}-{profile}.properties
* /{label}/{application}-{profile}.properties

label存在的话，/{label}/不可忽略，如果客户端找不到配置参数，就会启动报错


### 动态配置：
#### actuator方式
 1、引入actuator健康检测场景启动器
 2、放开actuator/refresh服务
 3、在引入参数的类中加入@RefreshCode注解
 4、修改参数
 5、访问actuator/refresh 更新参数信息
#### config bus 待使用测试。。 
 

