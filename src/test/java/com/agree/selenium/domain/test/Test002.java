package com.agree.selenium.domain.test;


import org.testng.annotations.*;
import org.testng.annotations.Test;

/**
 * Created by 86183 on 2021/6/5.
 */
public class Test002 {

    @Test
    private static void a(){
        System.out.println("111111");
        d();
    }

    @Test
    private static void d(){
        System.out.println("3333");
    }

   @org.testng.annotations.Test(dependsOnMethods = {"a","d"})
   private static void b(){
        System.out.println("2222");
    }
}
