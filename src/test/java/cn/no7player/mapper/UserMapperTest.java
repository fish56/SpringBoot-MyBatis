package cn.no7player.mapper;

import cn.no7player.ApplicationTest;
import cn.no7player.model.User;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public class UserMapperTest extends ApplicationTest {
    @Autowired
    private UserMapper userMapper;

    // 看看环境是否ok
    @Test
    public void isEnvOk(){}

    // 记得先初始化数据库
    @Test
    public void getUser(){
        User admin = userMapper.selectUserById(1);
        System.out.println(JSONObject.toJSONString(admin));
        // {"id":1,"name":"admin","password":"123456"}
        Assert.assertNotNull(admin);
    }
}
