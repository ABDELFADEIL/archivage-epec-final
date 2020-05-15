package org.simplon.epec.archivage.infrastructure.document;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class CrypterDocument {

    private String encryptionKeyString =  "thisisa128bitkey";

    public  byte[] encrypt(byte[] data) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException,
            BadPaddingException, IllegalBlockSizeException {
        byte[] keyBytes = "thisisa128bitkey".getBytes();
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    public  byte[] decrypt(byte[] data) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException,
            BadPaddingException, IllegalBlockSizeException {
        byte[] keyBytes = "thisisa128bitkey".getBytes();
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }


    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException {

/*
        String encryptionKeyString =  "thisisa128bitkey";
        byte[] encryptionKeyBytes = encryptionKeyString.getBytes();

        String data = "digitalDocument";

        byte [] enc = encrypt(data.getBytes());
        byte [] dec = decrypt(enc);
        System.out.println("original "+ data);
        System.out.println("Encripted "+ enc);
        System.out.println("Decrypted "+ new String(dec));

        System.out.println("equals  "+ new String(dec).equals(data));

        byte[] file = Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Diagramme.png"));
        System.out.println("file length "+file);

        /*
        byte[] fileEnc = encrypt(file, encryptionKeyBytes);
        System.out.println("file length en "+Paths.get(System.getProperty("user.home"))+"/fichier.txt");
        byte[] fileDec = decrypt(fileEnc, encryptionKeyBytes);
        System.out.println("file length "+fileDec);
        Files.write(Paths.get(System.getProperty("user.home")+"/fichier.txt"), fileEnc);
        Files.write(Paths.get(System.getProperty("user.home")+"/test/Diagramme.png"), fileDec);

        for (int i = 0; i < 2 ; i++){
            // System.out.println(i);
            //Files.write(Paths.get("/media/fadeil/60cf352d-c946-4eb0-ab01-76d3f1bc3a57/fadeil/test/Diagramme"+i+".png"), fileDec);
        }

        */
    }
}
