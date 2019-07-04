package com.example.sb_redis_demo1.dao;


import com.example.sb_redis_demo1.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from sb_redis_1 where id=#{id}")
    User findUserById(int id);
}

