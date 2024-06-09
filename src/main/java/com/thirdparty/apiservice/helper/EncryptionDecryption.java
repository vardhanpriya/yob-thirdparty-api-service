package com.thirdparty.apiservice.helper;

import com.thirdparty.apiservice.config.PropertyConfig;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class EncryptionDecryption {

    @Autowired
    PropertyConfig propertyConfig;
    public String encryptAadharData(String data){
        String secretKey = propertyConfig.getEncryptionDecryptionKey();
        String encrypted = null;
        try{
            SecretKey key = new SecretKeySpec(secretKey.getBytes(),"AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            encrypted = Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));

        }catch (Exception ex){
            ex.getStackTrace();
        }
        return encrypted;

    }

    public String decryptAadharData(String data){
        String secretKey = propertyConfig.getEncryptionDecryptionKey();
        String decrypted = null;
        try{
            SecretKey key = new SecretKeySpec(secretKey.getBytes(),"AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,key);
            decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(data)));

        }catch (Exception ex){
            ex.getStackTrace();
        }
        return decrypted;

    }
}
