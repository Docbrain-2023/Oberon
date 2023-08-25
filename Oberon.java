/*Присылаю калькулятор. К сожалению, реализовать фнкционал в полной мере не удалось.
  Поиск в Сети результатов не дал, так как все примеры кода оказались нерабочими банально на стадии компиляции.
  С другой стороны, когда вы вешаете на входе вывеску "Курс имярек с нуля", как-то странно ожидать, что к вам придут люди с научной степенью в Computer science.
 */

import java.util.Scanner;
/*Присылаю калькулятор. К сожалению, реализовать фнкционал в полной мере не удалось.
  Поиск в Сети результатов не дал, так как все примеры кода оказались нерабочими банально на стадии компиляции.
  С другой стороны, когда вы вешаете на входе вывеску "Курс имярек с нуля", как-то странно ожидать, что к вам придут люди с научной степенью в Computer science.
 */

public class Oberon {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int result = 0;
        System.out.println("Желаете использовать римские, или арабские числа? В первом случае введите I во втором - 1");
        String cebteul = s.nextLine();
        System.out.println("Введите два числа");
        String ss = s.nextLine();
        String[] forMath = ss.split(" ");
        FromRomanToArabic rome2Arab = new FromRomanToArabic();
        int[] forMath1 = new int[2];
        if (cebteul.equals("I")) {
            for (int i = 0; i < forMath.length; i++) {
                forMath1[i] = rome2Arab.RometoArab(forMath[i]);
            }
        } else if (cebteul.equals("1")) {
            for (int i = 0; i < forMath.length; i++) {
                forMath1[i] = Integer.parseInt(forMath[i]);
            }
        }
        System.out.println("Введите операнд");

        String operand = s.nextLine();

        switch (operand) {
            case "+":
                result = forMath1[0] + forMath1[1];
                break;
            case "-":
                result = forMath1[0] - forMath1[1];
                break;
            case "*":
                result = forMath1[0] * forMath1[1];
                break;
            case "/":
                result = forMath1[0] / forMath1[1];
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