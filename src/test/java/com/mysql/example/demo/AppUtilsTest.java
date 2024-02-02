package com.mysql.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.project.sbws.backend.utilities.AppUtils;

@SpringBootTest(classes=AppUtils.class)
public class AppUtilsTest {
    

    @Test
    void testIsStringNullOrEmpty_NUll_True() {
        AppUtils utils = new AppUtils();
        String a = null;

        boolean isStringNullOrEmpty = utils.isNullOrEmpty(a);

        Assert.isTrue(isStringNullOrEmpty, "");
    } 

    @Test
    void testIsStringNullOrEmpty_Empty_True() {
        AppUtils utils = new AppUtils();
        String a = " ";

        boolean isStringNullOrEmpty = utils.isNullOrEmpty(a);

        Assert.isTrue(isStringNullOrEmpty, "");
    } 
}
