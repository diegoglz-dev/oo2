import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import roo2.CreatorCipher;

public class ciphercmd {
    public static void main(String[] args)
        throws IOException
    {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
        // Reading data using readLine
        String name = reader.readLine();
        
        CreatorCipher complex = new CreatorCipher("ComplexCipher");
        complex.addCipher(new CreatorCipher("CesarCipher,3").getCipher());
        complex.addCipher(new CreatorCipher("RailFenceCipher,3").getCipher());
        // Printing the read line
        System.out.println("Complex: " + complex.encryptMessage(name));
        
        CreatorCipher transposition = new CreatorCipher("TranspositionCipher,hola");
        // Printing the read line
        System.out.println("Transposition: " + transposition.encryptMessage(name));
    }
}



