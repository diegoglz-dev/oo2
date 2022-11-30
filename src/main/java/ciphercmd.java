import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import roo2.CesarCipher;
import roo2.CreatorCipher;
import roo2.VigenereCipher;
import roo2.RailFenceCipher;
import roo2.TranspositionCipher;

public class ciphercmd {
    public static void main(String[] args)
        throws IOException
    {
        final CesarCipher cesar = new CesarCipher(3);
        final VigenereCipher vigenere = new VigenereCipher();
        final RailFenceCipher railFence = new RailFenceCipher(3);
        final TranspositionCipher transposition = new TranspositionCipher("hola");

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
        System.out.println("Transposition Cipher:" + transposition.cipher(name));
        
        /*
         * Builder
		*/
        System.out.println("---- · ----");
        System.out.println("---- Builder ----");
        CreatorCipher cesar1 = new CreatorCipher("CesarCipher,3");
        System.out.println("Cesar: " + cesar1.encryptMessage(name));
        CreatorCipher vigenere1 = new CreatorCipher("VigenereCipher,abcdefghijklmnopqrstuvwxyz");
        System.out.println("Vigenere: " + vigenere1.encryptMessage(name));
        CreatorCipher railFence1 = new CreatorCipher("RailFenceCipher,3");
        System.out.println("RailFence: " + railFence1.encryptMessage(name));
        CreatorCipher transposition1 = new CreatorCipher("TranspositionCipher,hola");
        System.out.println("Transposition: " + transposition1.encryptMessage(name));
    }
}



