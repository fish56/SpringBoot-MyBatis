# SpringBoot + MyBatis
一个可以正常运行的案例，代码非常简单，
主要是展示如何在SpringBoot中使用MyBatis。

使用MyBaits，无外乎下面的步骤
1. 配置数据源
2. 配置session工厂
3. 编写mapper文件以及dao层
4. 将mapper文件和dao层联系起来

然后我们来看下我们程序的入口文件 Application.java
```java
@Slf4j
@SpringBootApplication
@MapperScan("cn.no7player.mapper")
public class Application {
    // 1. 我们首先需要配置数据源
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

    // 2. 然后配置MyBatis session工厂
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    // 事务管理
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }


    /**
     * Start
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("SpringBoot Start Success");
    }
}
```
在这个文件中我们通过Java Config的方式配置了两个bean，正是我们
需要的数据源以及session工厂。

然后我们在创建session工厂的时候，告知MyBatis我们的mapper文件的位置
```java
sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
```
Mapper文件的具体内容大家自己看，很简单。

然后我们在创建数据库的接口`cn.no7player.mapper.UserMapper`

上面基本和在SpringMVC中使用MyBatis基本相同

**然后很关键的**：把Mapper文件和我们的dao层联系起来

```java
@MapperScan("cn.no7player.mapper")
```
把这个注解标注在我们的类上面，使得MyBatis-Starter能够正确的关联
两者！！！

一定不能没有！！！

## 如何确认我配置成功了？

1. 初始化数据库，这个我在database/initDB.sql这个文件中写好了，
   大家执行下就行了
   
2. 运行测试用例，如果测试通过，表明你配置成功了

3. 或者你直接启动SpringBoot程序，然后再访问/users/1这个路由，
   如果返回了一个JSON数据，那也证明你配置成功了


