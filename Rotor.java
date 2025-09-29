public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    //last char followed by the rest of the stringt w/o last char
    public boolean rotate(){
        rotorValues = rotorValues.charAt(rotorValues.length() - 1) + rotorValues.substring(0, rotorValues.length() - 1);
        if(rotorValues.charAt(0) == startChar){
            return true;
        }
        return false;
        
    }
    

    public int indexOf(char c){
        char[] rotorValuesChar = new char[28];
        rotorValuesChar = rotorValues.toCharArray();
        int indexChar = 0; 

        for (int i = 0; i < rotorValuesChar.length; i++){
            if(rotorValuesChar[i] == c){
                indexChar = i;
                break;
            }
        }

        return indexChar;
    }

    public char charAt(int idx){
        char[] rotorValuesChar = new char[28];
        rotorValuesChar = rotorValues.toCharArray();
        
        return rotorValuesChar[idx];
    }
}
    
