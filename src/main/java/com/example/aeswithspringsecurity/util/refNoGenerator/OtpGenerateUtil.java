package com.example.aeswithspringsecurity.util.refNoGenerator;




import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class OtpGenerateUtil {
    private OtpGenerateUtil() {
        super();
        // TODO Auto-generated constructor stub
    }

    static final int NUMBITS = 130;
    static final int RADIX = 32;
    static final String SHA1PRNG = "SHA1PRNG";
    static final String ALPHA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String NUMBER = "1234567890";
    static final String ALPHANUM = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String generateCode(int otpLength, String valueSelector){
        SecureRandom secureBaseRandomNumber;
        String generatedRandomVal = "";
        String codeValue = "";

        if (valueSelector.contentEquals("NUMBER")) {codeValue = NUMBER;}
        if (valueSelector.contentEquals("ALPHA")) {codeValue = ALPHA;}
        if (valueSelector.contentEquals("ALPHANUM")) {codeValue = ALPHANUM;}

        try {
            secureBaseRandomNumber = SecureRandom.getInstance(SHA1PRNG);

            for (int i=0; i<otpLength; i++)
            {
                int index = (int)(Math.abs(secureBaseRandomNumber.nextDouble()*codeValue.length()));
                generatedRandomVal += codeValue.substring(index, index+1);
            }

        } catch (NoSuchAlgorithmException ex) {
            throw new UtilException(new StringBuilder()
                    .append("Unable to generate OTP Number Code'")
                    .append("' using security '").append(SHA1PRNG)
                    .append("'.").toString(),
                    ex);
        }

        return generatedRandomVal.toUpperCase();
    }

}