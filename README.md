## Springboot整合Redis(一)——实现简单缓存
### 新建Springboot项目
### 添加所需Maven依赖
- spring-boot-starter-data-redis
- mysql-connector-java
- mybatis-spring-boot-starter
### 具体实现
Service层
```java
@Service
public class UserService {
    
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserDao userDao;
    
    public User findUserById(int id) {
        String key = "user_" + id;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        User user;
        if (hasKey) {
            //读取redis缓存
            user = operations.get(key);
        } else {
            //查询数据库
            user = userDao.findUserById(id);
            //写入redis
            operations.set(key, user, 5, TimeUnit.HOURS);
        }
        return user;
    }
}
```