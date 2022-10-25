package roo2;

//import roo2.Cipher;

public class  BouncingIndex {
    int maxSize;
    int idx;
    int maxSizeAux;
    
    public  BouncingIndex(int size){
        maxSize = size;
        idx = 0;
        maxSizeAux = maxSize;
    };

    public int next() {
        int result;
        
        if (maxSizeAux == 0) {
        	maxSizeAux = maxSize;
        	idx = 1;
        }
        
        if ((idx == maxSize) && (maxSize != 1)) {
        	maxSizeAux--;
        	idx--;
        }
        
        if (idx < maxSizeAux) {
        	result = idx++;
        } else {
        	maxSizeAux--;
        	result = --idx;
        }
        
        return result;
    };

}