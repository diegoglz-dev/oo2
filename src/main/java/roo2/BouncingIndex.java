package roo2;

public class BouncingIndex {
    int maxSize;
    int index;
    int aux;
    
    public BouncingIndex(int size) {
        maxSize = size;
        index = 0;
        aux = maxSize;
    };

    public int next() {
    	int result;
        
    	if (aux == 0) {
    		aux = maxSize;
    		index = 1;
    	}
    	
    	if ((index == maxSize) && (maxSize != 1)) {
    		aux--;
    		index--;
    	}
        
        if (index < aux) {
        	result = index++;
        } else {
        	aux--;
        	result = --index;
        }
        
        return result;
    };
}