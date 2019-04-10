/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.utils;

/**
 *
 * @author JAVIER
 */

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
//De igual forma, hay que importar algunas clases que permitirán tratar las excepciones que ocurran durante el proceso. Estas excepciones deben ser controladas por las clases que consuman el servicio de cifrado simétrico.

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
//Para utilizar una instancia del algoritmo AES se debe utilizar el método estático getInstance de la clase Cipher especificando el nombre del algoritmo.


class CLI {
  public static void main(String args[])
    throws NoSuchAlgorithmException, NoSuchPaddingException,
      BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        String plainText = "This is just an example";
        String algorithm = "AES";
        Cipher cipher = Cipher.getInstance(algorithm);
//Para generar la clave secreta con la cual se va a cifrar y descifrar la información, se debe invocar el método estático getInstance de la clase KeyGenerator con el fin de obtener una referencia al objeto que implementa el servicio de generación de clave AES. Posteriormente, se establece el tamaño y se genera la clave. Por defecto, el tamaño es de 128 bits.

KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
keyGenerator.init(256);
SecretKey secretKey = keyGenerator.generateKey();

byte[] encoded = secretKey.getEncoded();
  System.out.println("Array de Bytes de la secretKet: "+ encoded+"\n\nhola\n\n");
//Para cifrar la información se debe establecer el modo de operación ENCRYPT_MODE y pasar como parámetro la clave secreta con la cual se va a cifrar la información.

cipher.init(Cipher.ENCRYPT_MODE, secretKey);
byte[] encrypText = cipher.doFinal(plainText.getBytes());
//Para descifrar la información se debe establecer el modo de operación DECRYPT_MODE y pasar como parámetro la misma clave secreta que se utilizó para cifrar el contenido.


cipher.init(Cipher.DECRYPT_MODE, secretKey);
byte[] decrypText = cipher.doFinal(encrypText);
//Finalmente se imprimen los resultados obtenidos tanto cuando se cifra como cuando se descifra el texto.

  String encodedEncText = javax.xml.bind.DatatypeConverter.printBase64Binary(encrypText);
  System.out.println("Encrypted text: " + new String(encrypText));
  System.out.println("Encrypted and encoded text: " + encodedEncText);
  System.out.println("Decrypted text: " + new String(decrypText));
  }
}