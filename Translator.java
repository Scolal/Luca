public class Translator {

    public static void main(String[] args){

        String string="3d6+8-13d17";
        String[] result=Add(string);

        System.out.println(""+string);
        System.out.println(result[0]+"\n"+result[1]);


    }


    public static int Translate(String s){
        String[] numbers = s.split("[^0-9]"); // split string using as separator everything that is not a digit
        
        for(int f=0;f<numbers.length;f++)System.out.println("numbers["+f+"]="+numbers[f]);       //debug
        
        int num1=Integer.parseInt(numbers[0]);
        int length1 = String.valueOf(num1).length();

        final char d = 'd';
        char toCheck = s.charAt(num1);

        Dice dice = new Dice(); //Class for randomly generated numbers

        if(s.length()==length1){
            return num1;
        }
        else if(toCheck==d);{
            int num2=Integer.parseInt(numbers[1]);
            int result=0;
            for(int rolls=0; rolls< num1; rolls++){         //"rolls" a die num1 times
                result= result + dice.tiraDn(num2);         //"rolls" a die with num2 faces
            }
            return result;
            }

    }

    public static String[] Add(String s){
        String[] result =new String[2];        // split string using as separator "+" or "-"
        result[0]="";
        result[1]="";
        String[] Rolls = s.split("[+-]");
        
        for(int f=0;f<Rolls.length;f++)System.out.println("Rolls["+f+"]="+Rolls[f]);       //debug
        
        int arrayPointer=0;
        int stringPointer=0;
        int numResult=0;
        int current=0;

        for(arrayPointer=0;arrayPointer<Rolls.length;arrayPointer++) {
            if (s.charAt(stringPointer)=='+'||arrayPointer==0) {

                current=Translate(numResult+Rolls[arrayPointer]);

                numResult=numResult+current;

                if (arrayPointer!=0){
                    result[0].concat("+");
                }
                result[0].concat(current+"");


            } else if (s.charAt(stringPointer)=='-') {
                current=Translate(numResult+Rolls[arrayPointer]);

                numResult=numResult-current;

                result[0].concat("-");

                result[0].concat(current+"");
            }
            stringPointer = stringPointer + Rolls[arrayPointer].length() +1;
        }
        result[1]=numResult+"";
        return result;
    }
}
