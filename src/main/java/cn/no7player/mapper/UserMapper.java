package cn.no7player.mapper;

import cn.no7player.model.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserMapper {
    public User selectById(Integer id);
}
