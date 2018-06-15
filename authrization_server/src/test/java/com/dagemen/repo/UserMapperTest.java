package com.dagemen.repo;

import com.dagemen.entity.PointUserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void insert() {

        PointUserDO user = new PointUserDO();
        user.setId(new Random().nextLong());
        user.setRealName("张三");
        user.setPhone("15757125055");
        userMapper.insert(user);
        System.out.println(user);
    }
}