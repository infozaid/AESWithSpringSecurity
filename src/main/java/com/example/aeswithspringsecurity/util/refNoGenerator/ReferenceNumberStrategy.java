package com.example.aeswithspringsecurity.util.refNoGenerator;
public interface ReferenceNumberStrategy {

    void initialize(String prefix, String suffix);
    String generateReferenceNumber();
    String generateReferenceNumber(int noOfDigits);
}

