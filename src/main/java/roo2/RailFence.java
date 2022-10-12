package roo2;

import roo2.BouncingIndex;

public class  RailFence implements Cipher {
    String[] rails;
    BouncingIndex bIndex;

    public  RailFence(int railsCount){
        rails = new String[railsCount];
        bIndex = new BouncingIndex(railsCount);

    };

    public String cipher(String inputText){
        String result = "";
        for(int idx =0; idx < inputText.length(); idx++){
            int rIndex= bIndex.next();
            rails[rIndex]+=  inputText.indexOf(idx); 

        }
        for(int idx=0; idx < rails.length; idx++)
            result += rails[idx];    
        return result; 
    }; 

    public String decipher(String inputText){
        
        return inputText; 
    }; 


}