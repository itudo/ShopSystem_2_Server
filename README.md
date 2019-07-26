项目名称：淘宝贝电子商务平台(2018.8-2018.9)
(1)开发技术：Spring，SpringMVC，Mybatis，Spring Cloud相关组件，
            Mysql，Redis，Jquery，Ajax，Jstl/EL，lombok
(2)项目描述：基于SpringCloud微服务架构的B2C电子商务系统，主要分为用户服务

(service-user),管理员服务(service-admin),通信服务(service-   
            message) 以及注册中心(Eureka-Server)
   1)用户服务：a.用户管理：用户认证，信息修改，手机及邮箱绑定，找回密码
              b.商品模块：商品检索，分页展示，详情及评论明细，购物车明细
              c.订单模块：加入购物车及结算，订单确认及状态查询，订单明细
              d.其他：商品收藏列表，浏览及搜索历史，我的评价
   2)管理员服务:用户列表，商品管理，订单管理，分类及属性管理
(3)责任描述：1).利用Spring-Session+Redis缓存实现各服务间登录用户信息共享
            2).利用Rest WebService客户端(Feign)实现服务间调用
            3).利用断路器(Hystrix)处理服务调用超时和失败，防止故障扩散
            4).利用服务网关(Zuul)实现动态路由，利用ZuulFilter进行权限控制
            5).完成商品分类表，商品表，订单表等相关数据库表结构设计
            6)部署solr搜索引擎，录入数据整合到项目中进行全文搜索
            7).完成用户认证模块，密码加密，手机短信、邮箱验证码(Freemarker)        

   