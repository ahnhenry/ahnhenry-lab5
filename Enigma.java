public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        String results = new String();
        int length = message.length();
        char[] messageChar = message.toCharArray();

        for(int i = 0; i < length; i++){
            int outer1Int = rotors[2].indexOf(messageChar[i]);
            char charMiddle = rotors[1].charAt(outer1Int);
            int outer2Int = rotors[2].indexOf(charMiddle);
            char finalChar = rotors[0].charAt(outer2Int);

            results = results + finalChar;
            rotors[0].rotate();
        }
        return results;
    }


    
    public String encrypt(String message){
       String results = new String();
       int length = message.length();
       char[] messageChar = message.toCharArray();

       for(int i = 0; i < length; i++){
        // if(messageChar[i] == ' '){
        //     messageChar[i] = '#';
        // }
        int charInt = rotors[0].indexOf(messageChar[i]);
        char outer = rotors[2].charAt(charInt);
        int middle = rotors[1].indexOf(outer);
        char finalChar = rotors[2].charAt(middle);

        results = results + finalChar;
        rotors[0].rotate();
        
       }

       return results;

    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
