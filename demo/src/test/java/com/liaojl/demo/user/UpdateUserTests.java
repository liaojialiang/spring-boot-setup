package com.liaojl.demo.user;

import com.liaojl.demo.RestfulApiTest;
import com.liaojl.demo.entity.User;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liaojl
 */
@Transactional
@Sql("/sql/user/update_user_tests.sql")
public class UpdateUserTests extends RestfulApiTest {
    @Test
    public void updateUserSuccess() throws Exception {
        User user = new User();
        user.setName("Jerry");
        user.setAge(10);
        String responseBody = doPut("/api/demo/users/{id}", user, 1L);
        String expected = "{\"id\":1,\"name\":\"Jerry\",\"age\":10}";
        JSONAssert.assertEquals(expected, responseBody, true);
    }
}
