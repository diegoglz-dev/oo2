import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import roo2.CesarCipher;
import roo2.RailFenceCipher;
import roo2.SimpleColumnCipher;
import roo2.VigenereCipher;

public class deciphercmd {
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
        System.out.println("Cesar Cipher:"+cesar.decipher(name));
        vigenere.setKeyword("abcdefghijklmnopqrstuvwxyz");
        System.out.println("Vigener Cipher:"+vigenere.decipher(name));
        System.out.println("RailFence Cipher:"+railFence.decipher(name));
        
        final SimpleColumnCipher simpleColumn = new SimpleColumnCipher("hola");
        System.out.println("Simple Column Cipher:" + simpleColumn.decipher(name));
    }
}



