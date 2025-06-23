package com.example.tests;

import org.testng.annotations.Test;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

public class GroupsExamples {

    @Test(groups = "Duman")
    public void test10(){
        System.out.println("Yalnızca duman testi için çalışır.");
    }

    @Test(groups = "Regresyon")
    public void test11(){
        System.out.println("Yalnızca regresyon testi için kullanılır.");
    }

    @Test(groups = "Entegrasyon")
    public void test12(){
        System.out.println("Yalnızca entegrasyon testi için kullanılır.");
    }

}
