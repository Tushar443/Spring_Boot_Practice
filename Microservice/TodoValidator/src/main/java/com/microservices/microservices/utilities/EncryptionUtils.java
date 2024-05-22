package com.microservices.microservices.utilities;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.stereotype.Component;

@Component
public class EncryptionUtils
{
    private BasicTextEncryptor textEncryptor;

    public EncryptionUtils() {
        this.textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("mySecreteEncryptionKey");
    }

    public String encrypt(String data){
        return textEncryptor.encrypt(data);
    }

    public String decrypt(String encryptData){
        return textEncryptor.decrypt(encryptData);
    }
}
