import org.jetbrains.annotations.NotNull;

class Main{
    public static String calc(@NotNull String input) throws Exception {
        boolean romanOrArab = false;
        Main romanExamination = new Main();
        Main arabToRoman = new Main();
        int result = 0;
        String[] inputSplit = input.split(" ");
        if (inputSplit.length != 3){
            throw new Exception ();
        }
        Integer firstNumber = 0;
        Integer secondNumber = 0;
        try {
            firstNumber = Integer.valueOf(inputSplit[0]);
            secondNumber = Integer.valueOf(inputSplit[2]);
        } catch (NumberFormatException e) {
            try {
                firstNumber = romanExamination.romanToArab(inputSplit[0]);
                secondNumber = romanExamination.romanToArab(inputSplit[2]);
                romanOrArab = true;
            } catch (NumberFormatException ex) {

            }
        }

        if ((firstNumber < 1) || (firstNumber > 10) || (secondNumber < 1) || (secondNumber > 10)){
            throw new Exception ();
        }

        String sign = inputSplit[1];
        switch (sign) {
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "*" -> result = firstNumber * secondNumber;
            case "/" -> result = firstNumber / secondNumber;
            default -> {

            }
        }

        String output;

        if (romanOrArab){
            if(result < 1){
                throw new Exception ();
            } else {
                output = arabToRoman.arabToRome(result);
            }
        } else {
            output = Integer.toString(result);
        }

        return output;
    }

    Integer romanToArab(String romanInput){
        int result = 0;
        int[] arab = {10, 9, 5, 4, 1};
        String[] roman = {"X", "IX", "V", "IV", "I"};
        for (int i = 0; i < arab.length; i++ ) {
            while (romanInput.indexOf(roman[i]) == 0) {
                result += arab[i];
                romanInput = romanInput.substring(roman[i].length());
            }
        }

        return result;
    }

    String arabToRome(int arabInput){
        String result = "";
        int value = 0;
        int[] arab = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < arab.length; i++){
            value = arabInput / arab[i];
            for (int j = 0; j < value; j++){
                result = result.concat(roman[i]);
            }
            arabInput = arabInput % arab[i];
        }
        return result;
    }
}