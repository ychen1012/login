package com.imtoocai.diary.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CodeUtilTest {
    @Test
    public void getCode() {
        for (int i = 0; i < 100; i++) {

            System.out.println(CodeUtil.getCode());
        }
    }
}