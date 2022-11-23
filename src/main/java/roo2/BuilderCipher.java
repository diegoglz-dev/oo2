package roo2;

public class BuilderCipher {
	String param1 = null;
    String param2 = null;
    String param3 = null;
    
    public BuilderCipher(String params) {
        String[] parts = params.split(",");
        param1 = parts[0]; // Tipo de cifrador
        param2 = parts[1]; // Numero de saltos o rieles o palabra clave
        
    	try {
    		param3 = parts[2];
    	} catch ( IndexOutOfBoundsException e ) {
    	    param3 = null;
    	}
    }
    
    public Cipher buildCesarCipher() {
        if (param1.equals("Cesar") && param3 == null) {
            return new CesarCipher(Integer.parseInt(param2));
        } else {
            return new CesarCipher(Integer.parseInt(param2), param3);
        }
    }
    
    public Cipher buildRailFenceCipher() {
        if (param1.equals("RailFence")) {
            return new RailFenceCipher(Integer.parseInt(param2));
        }
        return null;
    }
    
    public Cipher buildVigenereCipher() {
        if (param1.equals("Vigenere") && param2 == null && param3 == null) {
            return new VigenereCipher();
        } else {
            return new VigenereCipher(param2, param3);
        }
    }
    
    public Cipher buildSimpleColumnCipher() {
    	if (param1.equals("SimpleColumn")) {
    		return new SimpleColumnCipher(param2);
    	}
    	return null;
    }
}
