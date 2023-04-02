package com.example.aeswithspringsecurity.util.refNoGenerator;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ResourceBundle;

/**
 *
 * @author rodinpaul.sandrino
 */
public class ReferenceNumberGenerator {

    private static ReferenceNumberGenerator refNoGen;

    public static ReferenceNumberGenerator getInstance() {
        if (refNoGen == null) {
            refNoGen = new ReferenceNumberGenerator();
        }
        return refNoGen;
    }
    // -----------------------------------------------------------------------
    private ReferenceNumberStrategy refNoStrategyImpl;
    private ReferenceNumberStrategy refNoStrategyParamImpl;

    public String generateReferenceNo() {
        if (refNoStrategyImpl == null) {
            try {
                refNoStrategyImpl = (ReferenceNumberStrategy) Class.forName(ResourceBundle.getBundle("config.runtime")
                        .getString("refNoStrategyImpl")).newInstance();
            } catch (Exception ex) {
                throw new RefNoGenerationException("Reference number generation error.", ex);
            }
        }
        return refNoStrategyImpl.generateReferenceNumber();
    }

    public String generateReferenceNo(String prefix, String suffix) {
        if (refNoStrategyParamImpl == null) {
            try {
                refNoStrategyParamImpl = (ReferenceNumberStrategy) Class.forName(ResourceBundle.getBundle("config.runtime")
                        .getString("refNoStrategyImpl")).newInstance();
            } catch (Exception ex) {
                throw new RefNoGenerationException("Reference number generation error.", ex);
            }
        }
        refNoStrategyParamImpl.initialize(prefix, suffix);
        return refNoStrategyParamImpl.generateReferenceNumber();
    }

    public String generateReferenceNo(String prefix, String suffix, int noOfDigits) {
        if (refNoStrategyParamImpl == null) {
            try {
                refNoStrategyParamImpl = (ReferenceNumberStrategy) Class.forName(ResourceBundle.getBundle("config.runtime")
                        .getString("refNoStrategyImpl")).newInstance();
            } catch (Exception ex) {
                throw new RefNoGenerationException("Reference number generation error.", ex);
            }
        }
        refNoStrategyParamImpl.initialize(prefix, suffix);
        return refNoStrategyParamImpl.generateReferenceNumber(noOfDigits);
    }
}
