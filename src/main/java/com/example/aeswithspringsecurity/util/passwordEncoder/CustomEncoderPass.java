package com.example.aeswithspringsecurity.util.passwordEncoder;

import com.example.aeswithspringsecurity.util.Hash;
import com.example.aeswithspringsecurity.util.Password;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomEncoderPass implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
       Hash hash = Password.hash(rawPassword)
                .addPepper()
                .withScrypt();
        return hash.getResult();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        boolean verification = Password.check(rawPassword, encodedPassword)
                .addPepper()
                .withScrypt();
        return verification;
    }
}
