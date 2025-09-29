public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        rotorValues = rotorValues.substring(1) + rotorValues.charAt(0);
               
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
    
