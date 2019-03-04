/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aesexample;


import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
 
/**
 *
 * @author shaheer ali
 */
public class AESExample
{

    private static final String ALGO ="AES";
    private final byte[] keyValue;
    
    public AESExample(String key)
    { 
    keyValue = key.getBytes();
    }
    /**
     *
     * @param Data
     * @return
     * @throws Exception
     */
    public String encrypt (String Data) throws Exception
    {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE,key);
        byte[] encVal =c.doFinal(Data.getBytes());
        String encryptedValue=  new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }
    public String decrypt (String encryptedData) throws Exception
    {
       Key key = generateKey();
       Cipher ciph = Cipher.getInstance(ALGO);
        ciph.init(Cipher.DECRYPT_MODE,key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = ciph.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    private Key generateKey() throws Exception
    {
        Key key = new SecretKeySpec(keyValue,ALGO);
        return key;      
    }
        public static void main(String[] args)// throws Exception 
{ 
      try   {
    AESExample aes= new AESExample("this stupid key ");
    String encdata = aes.encrypt("HELLO WORLDzzzzzzzzzzzzzzzzzzzzzz");
    System.out.println("encrypted data " + encdata);
    String decdata = aes.decrypt(encdata);
    System.out.println("decrypted data " + decdata);
 }
      catch(Exception ex){
    Logger.getLogger(AESExample.class.getName()).log(Level.SEVERE ,null,ex);
      }
}

    
} 





     
