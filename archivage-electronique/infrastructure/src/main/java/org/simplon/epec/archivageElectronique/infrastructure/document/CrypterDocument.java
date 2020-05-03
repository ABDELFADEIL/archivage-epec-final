package org.simplon.epec.archivageElectronique.infrastructure.document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CrypterDocument {


    public static byte[] encrypt(byte[] data) {
        byte[] encryptData = new byte[data.length];
        for (int i = 0; i < data.length; i++){
            encryptData[i] = (byte)((i % 2 ==0 ) ? data[i] + 1 : data[i] - 1);
        }
        return encryptData;
    }

    public static byte[] decrypt(byte[] data) {
        byte[] decryptData = new byte[data.length];
        for (int i = 0; i < data.length; i++){
            decryptData[i] = (byte)((i % 2 ==0 ) ? data[i] - 1 : data[i] + 1);
        }
        return decryptData;
    }


    public static void main(String[] args) throws IOException {
        String data = "digitalDocument";
        String enc = new String(encrypt(data.getBytes()));
        String dec = new String(decrypt(enc.getBytes()));
        System.out.println("original "+ data);
        System.out.println("Encripted "+ enc);
        System.out.println("Decrypted "+ dec);

        byte[] file = Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Diagramme.png"));
        System.out.println("file length "+file);
        byte[] fileEnc = encrypt(file);
        System.out.println("file length en "+Paths.get(System.getProperty("user.home"))+"/fichier.txt");
        byte[] fileDec = decrypt(fileEnc);
        System.out.println("file length "+fileDec);
        Files.write(Paths.get(System.getProperty("user.home")+"/fichier.txt"), fileEnc);
        for (int i = 0; i < 1000000 ; i++){
            // System.out.println(i);
            Files.write(Paths.get(System.getProperty("user.home")+"/beel/Diagramme"+i+".png"), fileDec);
        }
        System.out.println("terminé ");
        System.out.println("original "+ file);
        System.out.println("Encripted "+ fileEnc);
        System.out.println("Decrypted "+ fileDec);

    }
}
