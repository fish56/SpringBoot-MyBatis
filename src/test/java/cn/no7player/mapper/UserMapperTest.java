package cn.no7player.mapper;

import cn.no7player.ApplicationTest;
import cn.no7player.model.User;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperTest extends ApplicationTest {
    @Autowired
    private UserMapper userMapper;

    // 看看环境是否ok
    @Test
    public void isEnvOk(){
        Assert.assertNotNull(userMapper);
    }

    @Test
    public void getUser(){
        User admin = userMapper.selectById(1);
        System.out.println(JSONObject.toJSONString(admin));
        // {"id":1,"name":"admin","password":"123456"}
        Assert.assertNotNull(admin);
    }
}
