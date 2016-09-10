package com.sof.service;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sof.service.dao.IUserDao;
import com.sof.service.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles(value="dev")  
public class ApplicationTests {

	@Autowired
    private IUserDao userMapper;

    @Test
    @Rollback
    public void findByName() throws Exception {
        List<User> u = userMapper.selectByState(1);
        //Assert.assertEquals(0, u.get(0).getName());
    }

}
