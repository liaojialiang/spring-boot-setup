package com.liaojl.demo.user;

import com.liaojl.demo.RestfulApiTest;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liaojl
 */
@Transactional
@Sql("/sql/user/get_user_tests.sql")
public class GetUserTests extends RestfulApiTest {

    @Test
    public void getUserSuccess() throws Exception {
        String responseBody = doGet("/api/demo/users/{id}", null, 1L);
        String expected = "{\"id\":1,\"name\":\"Jimmy\",\"age\":11}";
        JSONAssert.assertEquals(expected, responseBody, true);
    }
}
