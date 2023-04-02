package com.example.aeswithspringsecurity.util.test;


import com.example.aeswithspringsecurity.util.Hash;
import com.example.aeswithspringsecurity.util.Password;
import com.example.aeswithspringsecurity.util.refNoGenerator.ReferenceNumberGenerator;

import java.util.LinkedHashSet;
import java.util.Set;

public class EncoderDecoder {

    public static void main(String[] args){
       /* Hash hash= Password.hash("123456789")
                .addRandomSalt()
                .addPepper("zaid-amin")
                .withArgon2();
        System.out.println("Here is hashing key:    "+ hash.getResult());*/
        /*hash.getResult().toString();
        hash.getSalt();*/
        for(int i =0;i<=100;i++) {
            String refNo = ReferenceNumberGenerator.getInstance().generateReferenceNo();

            System.out.println(refNo);
        }

    }
}
