package cn.no7player.controller;

import cn.no7player.model.User;
import cn.no7player.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users/{userId}")
    @ResponseBody
    public User getUserInfo(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }
}
