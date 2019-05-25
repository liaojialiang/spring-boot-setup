package com.liaojl.demo.user;

import com.liaojl.demo.RestfulApiTest;
import com.liaojl.demo.repository.UserRepostiory;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liaojl
 */
@Transactional
@Sql("/sql/user/delete_user_tests.sql")
public class DeleteUserTests extends RestfulApiTest {
    @Autowired
    private UserRepostiory userRepostiory;

    @Test
    public void deleteUserSuccess() throws Exception {
        doDelete("/api/demo/users/{id}/", null, 1L);
        Assertions.assertThat(userRepostiory.findById(1L)).isNotPresent();
    }
}
