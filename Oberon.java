/*Присылаю калькулятор. К сожалению, реализовать фнкционал в полной мере не удалось.
  Поиск в Сети результатов не дал, так как все примеры кода оказались нерабочими банально на стадии компиляции.
  С другой стороны, когда вы вешаете на входе вывеску "Курс имярек с нуля", как-то странно ожидать, что к вам придут люди с научной степенью в Computer science.
 */

import java.util.Scanner;
import java.util.TreeMap;

public class Oberon {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int result = 0;
        String[] actions = { "+", "-", "/", "*" };
        String[] regexActions = { "\\+", "-", "/", "\\*" };
        Converter convert = new Converter();
        // System.out.println("Желаете использовать римские, или арабские числа? В
        // первом случае введите I во втором - 1");
        // String cebteul = s.nextLine();
        System.out.println("Введите выражение");
        String ss = s.nextLine();

        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (ss.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            System.out.println("Введено некорректное значение");
            return;
        }
        String[] forMath = ss.split(regexActions[actionIndex]);
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

            // FromRomanToArabic rome2Arab = new FromRomanToArabic();

            // if (cebteul.equals("I")) {

            // forMath1[i] = rome2Arab.RometoArab(forMath[i]);
            // } else if (cebteul.equals("1")) {
            // for (int i = 0; i < forMath.length; i++) {
            // forMath1[i] = Integer.parseInt(forMath[i]);
            // }
            // }
            // System.out.println("Введите операнд");

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
            // if (cebteul.equals("I")) {
            // FromArabicToRoman arab2Rome = new FromArabicToRoman();
            // String romanResult = arab2Rome.ArabToRoman(result);

            // }
            // if (cebteul.equals("1")) {
            System.out.println(result);
            // }
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

    public Converter() {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);

    }

    public boolean isRoman(String number) {

        return romanKeyMap.containsKey(number.charAt(0));
    }

}