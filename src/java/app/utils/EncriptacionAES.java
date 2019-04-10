/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Convert;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;
import static app.utils.EncriptacionAES.encriptar;
/**
 *
 * @author JAVIER
 */
public class EncriptacionAES {


        
    // Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
    private final static String algoritmo = "AES";
    // Definición del modo de cifrado a utilizar
    private final static String modoCifredo = "AES/CBC/PKCS5Padding";
 
    /**
     * Función de tipo String que recibe una llave (key) tipo String, 
	 * un vector de inicialización (iv) tipo String
     * y el texto que se desea cifrar
     * @param clavesecreta la llave en tipo String a utilizar
     * @param vectorInicio el vector de inicialización a utilizar
     * @param claveSinEncriptar el texto sin cifrar a encriptar
     * @return el texto cifrado en modo String
     * @throws Exception puede devolver excepciones de los siguientes tipos: NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException
     */
    public static String encriptar(String clavesecreta, String vectorInicio, String claveSinEncriptar) throws Exception {
            Cipher cipher = Cipher.getInstance(modoCifredo);
            SecretKeySpec skeySpec = new SecretKeySpec(clavesecreta.getBytes(), algoritmo);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(vectorInicio.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(claveSinEncriptar.getBytes());
            return new String(encodeBase64(encrypted));
    }
 
    /**
     * Función de tipo String que recibe una llave (key), un vector de inicialización (iv)
     * y el texto que se desea descifrar
     * @param clavesecreta la llave en tipo String a utilizar
     * @param vectorInicio el vector de inicialización a utilizar
     * @param claveEncriptada el texto cifrado en modo String
     * @return el texto desencriptado en modo String
     * @throws Exception puede devolver excepciones de los siguientes tipos: NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException
     */
    public static String desencriptar(String clavesecreta, String vectorInicio, String claveEncriptada) throws Exception {
            Cipher cipher = Cipher.getInstance(modoCifredo);
            SecretKeySpec skeySpec = new SecretKeySpec(clavesecreta.getBytes(), algoritmo);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(vectorInicio.getBytes());
            byte[] enc = decodeBase64(claveEncriptada);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            return new String(decrypted);
    }
    public static void main(String[] args) throws Exception {
 String key = "92AE31A79FEEB2A3"; //llave
 String iv = "0123456789ABCDEF"; // vector de inicialización
 String cleartext = "hola";
 System.out.println("Texto encriptado: "+encriptar(key, iv,cleartext));
 System.out.println("Texto desencriptado: "+desencriptar(key, iv,encriptar(key, iv,cleartext)));
 }
}
