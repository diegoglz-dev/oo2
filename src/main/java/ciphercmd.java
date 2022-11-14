import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import roo2.CesarCipher;
import roo2.Encrypter;
import roo2.VigenereCipher;
import roo2.RailFenceCipher;

public class ciphercmd {
    public static void main(String[] args)
        throws IOException
    {
        final CesarCipher cesar = new CesarCipher(3);
        final VigenereCipher vigenere = new VigenereCipher();
        final RailFenceCipher railFence = new RailFenceCipher(3);

        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
        // Reading data using readLine
        String name = reader.readLine();
 
        // Printing the read line
        System.out.println("Cesar Cipher:"+cesar.cipher(name));
        vigenere.setKeyword("abcdefghijklmnopqrstuvwxyz");
        System.out.println("Vigener Cipher:"+vigenere.cipher(name));
        System.out.println("RailFence Cipher:"+railFence.cipher(name));
        
        System.out.println("---- · ----");
        
        /*
         * Con Factory
         */
        Encrypter encrypter = new Encrypter(); 
        
        final CesarCipher cesar1 = (CesarCipher) encrypter.getCipher("cesarcipher",3);
        final VigenereCipher vigenere1 = (VigenereCipher) encrypter.getCipher("VigenereCipher");
        vigenere1.setKeyword("abcdefghijklmnopqrstuvwxyz");
        final RailFenceCipher rail1 = (RailFenceCipher) encrypter.getCipher("RailFenceCipher",3);
        
        String name1 = "qwerty";
        
        System.out.println("Cesar Cipher con factory:"+cesar1.cipher(name1));
        System.out.println("Vigener Cipher con factory:"+vigenere1.cipher(name1));
        System.out.println("RailFence Cipher con factory:"+rail1.cipher(name1));
    }
}



