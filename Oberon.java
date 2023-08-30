
import java.util.Scanner;
import java.util.TreeMap;

public class Oberon {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите выражение");
        String ss = s.nextLine();
        System.out.println(calc(ss));
        /*
         * int result = 0;
         * S1tring[] actions = { "+", "-", "/", "*" };
         * String[] regexActions = { "\\+", "-", "/", "\\*" };
         * Converter convert = new Converter();
         * 
         * System.out.println("Введите выражение");
         * String ss = s.nextLine();
         * 
         * int actionIndex = -1;
         * for (int i = 0; i < actions.length; i++) {
         * if (ss.contains(actions[i])) {
         * actionIndex = i;
         * break;
         * }
         * }
         * if (actionIndex == -1) {
         * System.out.println("Введено некорректное значение");
         * return;
         * }
         * String[] forMath = ss.split(regexActions[actionIndex]);
         * if (forMath.length != 2)
         * throw new Exception("Неверное значение");
         * if ((convert.isRoman(forMath[0])) == (convert.isRoman(forMath[1]))) {
         * int a = 0;
         * int b = 0;
         * if (convert.isRoman(forMath[0]) == true) {
         * FromRomanToArabic rome2Arab = new FromRomanToArabic();
         * a = rome2Arab.RometoArab(forMath[0]);
         * b = rome2Arab.RometoArab(forMath[1]);
         * } else if (convert.isRoman(forMath[0]) == false) {
         * a = Integer.parseInt(forMath[0]);
         * b = Integer.parseInt(forMath[1]);
         * }
         * 
         * 
         * 
         * switch (actions[actionIndex]) {
         * case "+":
         * result = a + b;
         * break;
         * case "-":
         * result = a - b;
         * break;
         * case "*":
         * result = a * b;
         * break;
         * case "/":
         * result = a / b;
         * break;
         * 
         * }
         * 
         * if (convert.isRoman(forMath[0])) {
         * if (result < 1)
         * throw new Exception("Неверное значение");
         * if (result > 10)
         * throw new Exception("Неверное значение");
         * System.out.println(convert.intToRoman(result));
         * 
         * } else {
         * System.out.println(result);
         * }
         * // }
         * } else {
         * System.out.println("Введено неверное значение");
         * }
         * }
         */

    }

    public static String calc(String input) throws Exception {
        Scanner s = new Scanner(System.in);
        int result = 0;
        String[] actions = { "+", "-", "/", "*" };
        String[] regexActions = { "\\+", "-", "/", "\\*" };
        Converter convert = new Converter();

        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (input.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            throw new Exception("Неверное значение");
        }
        String[] forMath = input.split(regexActions[actionIndex]);
        if (forMath.length != 2)
            throw new Exception("Неверное значение");
        if ((convert.isRoman(forMath[0])) == (convert.isRoman(forMath[1]))) {
            int a = 0;
            int b = 0;
            if (convert.isRoman(forMath[0]) == true) {
                FromRomanToArabic rome2Arab = new FromRomanToArabic();
                a = rome2Arab.RometoArab(forMath[0]);
                b = rome2Arab.RometoArab(forMath[1]);
            } else if (convert.isRoman(forMath[0]) == false) {
                a = Integer.parseInt(forMath[0]);
                b = Integer.parseInt(forMath[1]);
            }
            if (a > 10)
                throw new Exception("Неверное значение");

            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;

            }

            // if (result > 10)
            // throw new Exception("Неверное значение");
            if (convert.isRoman(forMath[0])) {
                if (result < 1)
                    throw new Exception("Неверное значение");
                else
                    return (convert.intToRoman(result));

            } else {
                String result1 = String.valueOf(result);
                return result1;
            }
            // }
        } else {
            throw new Exception("Неверное значение");
        }
    }
}

class FromRomanToArabic {
    static String[] Rome = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
            "IX", "V", "IV", "I" };
    static int[] Arab = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    public int RometoArab(String rome) {

        StringBuffer romeNumber = new StringBuffer(rome);
        int arabNumber = 0, i = 0;
        if (romeNumber.length() > 0) {
            while (true) {
                do {

                    if (Rome[i].length() <= romeNumber.length()) {

                        if (Rome[i].equals(romeNumber.substring(0,
                                Rome[i].length()))) {
                            arabNumber += Arab[i];
                            romeNumber.delete(0, Rome[i].length());
                            if (romeNumber.length() == 0)
                                return arabNumber;
                        } else
                            break;
                    } else
                        break;
                } while (true && romeNumber.length() != 0);
                i++;
            }
        }
        return 0;

    }

}

class FromArabicToRoman {
    /*
     * public static String ArabToRoman(int arab) {
     * String result;
     * if (arab == 1) {
     * result = "I";
     * } else if (arab == 2) {
     * result = "II";
     * } else if (arab == 3) {
     * result = "III";
     * } else if (arab == 4) {
     * result = "IV";
     * } else if (arab == 5){
     * result = "V";
     * } else if (arab == 6){
     * result = "VI";
     * } else if (arab = 7){
     * result = "VII";
     * } else if (arab == 8) {
     * result = "VIII";
     * } else if (arab == 9){
     * result = "IX";
     * }else if (arab == 10){
     * result = "X";
     * } else if (arab == 0){
     * result = "Неприемлемое значение";
     * } else if (arab > 10){
     * result = "Результат превышает допустимые параметры";
     * }
     * 
     * }return result
     */
}

class IsSymbolRome {
    public int NumberValue(String x) {
        int result = 0;
        switch (x) {
            case ("I"):
                result = 1;
            case ("II"):
                result = 2;
            case ("III"):
                result = 3;
            case ("IV"):
                result = 4;
            case ("V"):
                result = 5;
            case ("VI"):
                result = 6;
            case ("VII"):
                result = 7;
            case ("VIII"):
                result = 8;
            case ("IX"):
                result = 9;
            case ("X"):
                result = 10;

        }
        return result;
    }

}

class Converter {
    TreeMap<Character, Integer> romanKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

    public Converter() {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);

        arabianKeyMap.put(1000, "M");
        arabianKeyMap.put(900, "CM");
        arabianKeyMap.put(500, "D");
        arabianKeyMap.put(400, "CD");
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");

    }

    public boolean isRoman(String number) {

        return romanKeyMap.containsKey(number.charAt(0));
    }

    public String intToRoman(int number) {
        String roman = "";
        int arabianKey = 0;
        do {
            arabianKey = arabianKeyMap.floorKey(number);
            roman += arabianKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return roman;
    }
}