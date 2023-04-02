package com.example.aeswithspringsecurity.util.refNoGenerator;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DefaultReferenceNumberStrategy implements ReferenceNumberStrategy {

    private MessageDigest digester;

    private String _prefix = "";
    private String _suffix ="";

    @Override
    public void initialize(String prefix, String suffix) {
        if (digester == null) {
            try {
                digester = MessageDigest.getInstance("SHA1");
            } catch (NoSuchAlgorithmException ex) {
                throw new RefNoGenerationException("Digest instantiation error. ", ex);
            }
        }
        if (prefix != null && !_prefix.equals(prefix)) {
            this._prefix = prefix;
        }
        if (suffix != null && !_suffix.equals(suffix)) {
            this._suffix = suffix;
        }
    }

    @Override
    public String generateReferenceNumber() {
        if (digester == null) {
            initialize(null, null);
        }

        String refNo = OtpGenerateUtil.generateCode(16, "NUMBER");
        refNo = _prefix + refNo + _suffix;

        return refNo;
    }

    @Override
    public String generateReferenceNumber(int noOfDigits) {
        if (digester == null) {
            initialize(null, null);
        }

        String refNo = OtpGenerateUtil.generateCode(noOfDigits, "NUMBER");
        refNo = _prefix + refNo + _suffix;

        return refNo;
    }

}