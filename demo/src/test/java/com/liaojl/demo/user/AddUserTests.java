package com.liaojl.demo.user;

import com.liaojl.demo.RestfulApiTest;
import com.liaojl.demo.entity.User;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liaojl
 */
@Transactional
public class AddUserTests extends RestfulApiTest {

    @Test
    public void addUserSuccess() throws Exception {
        User user = new User();
        user.setName("Jerry");
        user.setAge(12);
        String responseBody = doPost("/api/demo/users/", user);
        String expected = "{\"id\":1,\"name\":\"Jerry\",\"age\":12}";
        JSONAssert.assertEquals(expected, responseBody, true);
    }
}
