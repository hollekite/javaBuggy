package com.lgs;

import org.junit.jupiter.api.*;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


/**
 * 说明：${Description}
 * 作者：${AUTHER}
 * 创建日期：2018-05-29
 * 版本：${Version}
 */


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Console1 {

    @BeforeAll
    public void BeforeMethod()
    {
        System.out.println("---------BeforeMethod-------");
        //前置条件只会影响  @Test 测试代码执行，而不会影响@BeforeAll    @AfterAll 等代码的执行
        assumeTrue(true);
    }
    @Test
    @DisplayName("---just a  test---")

    public void test()
    {
        System.out.println("---------test-------");
        //所有的lambada表达式中有一个错误则该断言就会报错。从而终止后面测试代码执行
        assertAll(
                () -> { System.out.println("---------assertAll-------");
                        },
                () -> {
                    //该lambda表达式错误后，后面的lambdahi还是会执行
                            assertEquals(1,2);
                    System.out.println("1 != 2");
                    },
                () -> {
                    assertEquals(1, 1);
                    System.out.println("1 == 1");

                },
                () -> assertTrue(false),
                () -> assertTrue(true)
        );
		//该断言只会影响@Test代码的执行，不会影响@BeforeAll   @AfterAll 等代码的执行
		assert();
        System.out.println("---after all assertALL---");
    }
    @AfterAll
    public void AfterMethod()
    {
        System.out.println("---------AfterMethod-------");
    }

}
