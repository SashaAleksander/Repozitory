package calculator1;

import java.util.Scanner;

public class Main {

    // Создаю сканер
    static String scan() {
        System.out.println("Input: " );
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    //Создаю вычислятор
    static int calculation(int variable1, int variable2, char operationSign) {
        int intResult = 0;
        switch (operationSign) {
            case '+':
                intResult = variable1 + variable2;
                break;
            case '-':
                intResult = variable1 - variable2;
                break;
            case '*':
                intResult = variable1 * variable2;
                break;
            case '/':
                intResult = variable1 / variable2;
                break;
        }
        return intResult;
    }

    //Создаю конвертер с римских в арабские
    static int convertRomanToArabian (String roman) {
        int arabian = 0;
        if (roman.equals("I")) {
            arabian = 1;
        }
        else if (roman.equals("II")) {
            arabian = 2;
        }
        else if (roman.equals("III")) {
            arabian = 3;
        }
        else if (roman.equals("IV")) {
            arabian = 4;
        }
        else if (roman.equals("V")) {
            arabian = 5;
        }
        else if (roman.equals("VI")) {
            arabian = 6;
        }
        else if (roman.equals("VII")) {
            arabian = 7;
        }
        else if (roman.equals("VIII")) {
            arabian = 8;
        }
        else if (roman.equals("IX")) {
            arabian = 9;
        }
        else if (roman.equals("X")) {
            arabian = 10;
        }
        return arabian;
    }

    //Создаю конвертер со стринга на инт
    static int convertStringToInt(String stringOperand) {
        int operandReturn = 0;
        if (stringOperand.equals("1") || stringOperand.equals("2") || stringOperand.equals("3")
                || stringOperand.equals("4") || stringOperand.equals("5") || stringOperand.equals("6")
                || stringOperand.equals("7") || stringOperand.equals("8") || stringOperand.equals("9")
                || stringOperand.equals("10")) {
            operandReturn = Integer.parseInt(stringOperand);
        }
        else {
            operandReturn = convertRomanToArabian(stringOperand);
        }
        return operandReturn;
    }

    //Создаю конвертер с арабских в римские
    static String convertArabianToRoman (int arabian) {
        String[] datasOfRomanNumerals = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII",
                "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII",
                "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII",
                "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII",
                "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
                "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV",
                "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV",
                "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String roman = datasOfRomanNumerals[arabian];
        return roman;
    }

    //Создаю конвертер с инта на стринг
    static String convertIntToString(int intResult, String stringOperand) {
        String result = null;
        if (stringOperand.equals("1") || stringOperand.equals("2") || stringOperand.equals("3")
                || stringOperand.equals("4") || stringOperand.equals("5") || stringOperand.equals("6")
                || stringOperand.equals("7") || stringOperand.equals("8") || stringOperand.equals("9")
                || stringOperand.equals("10")) {
            result = Integer.toString(intResult);
        }
        else if (intResult < 1) {
            System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
            System.exit(0);
        }
        else {
            result = convertArabianToRoman(intResult);
        }
        return result;
    }

    //Создаю метод calc
    public static String calc(String input) {

        //Избавляюсь от пробелов
        System.out.println("Вы ввели: " + input);
        String inputRemoveSpace = input.replaceAll(" ", "");
        System.out.println("Без пробелов: " + inputRemoveSpace);

        //Разделяю строку по указанным знакам и заполняю массив
        String[] datas = inputRemoveSpace.split("/|\\+|\\-|\\*");

        //Прописываю исключение для случая если введен один операнд
        if (datas.length < 2) {
            System.out.println("throws Exception //т.к. строка не является математической операцией");
            System.exit(0);
        }

        //Прописываю исключение для случая если введено более двух операндов
        if (datas.length > 2) {
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет " +
                    "заданию - два операнда и один оператор (+, -, /, *)");
            System.exit(0);
        }

        //Вывожу на экран содержимое массива
        System.out.print("Содержимое массива: ");
        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + "; ");
        }
        System.out.println();

        //Создаю стринговые операнды
        String stringOperand1 = datas[0];
        String stringOperand2 = datas[1];

        //Прописываю исключение для случая если введено что-либо кроме чисел от 1 до 10
        if ((stringOperand1.equals("1") || stringOperand1.equals("2")
                || stringOperand1.equals("3") || stringOperand1.equals("4")
                || stringOperand1.equals("5") || stringOperand1.equals("6")
                || stringOperand1.equals("7") || stringOperand1.equals("8")
                || stringOperand1.equals("9") || stringOperand1.equals("10")
                || stringOperand1.equals("I") || stringOperand1.equals("II")
                || stringOperand1.equals("III") || stringOperand1.equals("IV")
                || stringOperand1.equals("V") || stringOperand1.equals("VI")
                || stringOperand1.equals("VII") || stringOperand1.equals("VIII")
                || stringOperand1.equals("IX") || stringOperand1.equals("X"))
                && (stringOperand2.equals("1") || stringOperand2.equals("2")
                || stringOperand2.equals("3") || stringOperand2.equals("4")
                || stringOperand2.equals("5") || stringOperand2.equals("6")
                || stringOperand2.equals("7") || stringOperand2.equals("8")
                || stringOperand2.equals("9") || stringOperand2.equals("10")
                || stringOperand2.equals("I") || stringOperand2.equals("II")
                || stringOperand2.equals("III") || stringOperand2.equals("IV")
                || stringOperand2.equals("V") || stringOperand2.equals("VI")
                || stringOperand2.equals("VII") || stringOperand2.equals("VIII")
                || stringOperand2.equals("IX") || stringOperand2.equals("X"))) {}
        else {
            System.out.println("throws Exception //т.к. переменными могут быть числа от 1 до 10 " +
                    "включительно, не более. Арабские или римские.");
            System.exit(0);
        }

        //Прописываю исключение для случая если используются одновременно разные системы счисления
        if (((stringOperand1.equals("1") || stringOperand1.equals("2")
                || stringOperand1.equals("3") || stringOperand1.equals("4")
                || stringOperand1.equals("5") || stringOperand1.equals("6")
                || stringOperand1.equals("7") || stringOperand1.equals("8")
                || stringOperand1.equals("9") || stringOperand1.equals("10"))
                && (stringOperand2.equals("I") || stringOperand2.equals("II")
                || stringOperand2.equals("III") || stringOperand2.equals("IV")
                || stringOperand2.equals("V") || stringOperand2.equals("VI")
                || stringOperand2.equals("VII") || stringOperand2.equals("VIII")
                || stringOperand2.equals("IX") || stringOperand2.equals("X")))

                || ((stringOperand2.equals("1") || stringOperand2.equals("2")
                || stringOperand2.equals("3") || stringOperand2.equals("4")
                || stringOperand2.equals("5") || stringOperand2.equals("6")
                || stringOperand2.equals("7") || stringOperand2.equals("8")
                || stringOperand2.equals("9") || stringOperand2.equals("10"))
                && (stringOperand1.equals("I") || stringOperand1.equals("II")
                || stringOperand1.equals("III") || stringOperand1.equals("IV")
                || stringOperand1.equals("V") || stringOperand1.equals("VI")
                || stringOperand1.equals("VII") || stringOperand1.equals("VIII")
                || stringOperand1.equals("IX") || stringOperand1.equals("X")))) {
            System.out.println("throws Exception //т.к. используются одновременно разные системы " +
                    "счисления");
            System.exit(0);
        }

        //Меняю стринг на инт значения
        int operand1 = convertStringToInt(stringOperand1);
        int operand2 = convertStringToInt(stringOperand2);
        System.out.println("Первый операнд: " + operand1);
        System.out.println("Второй операнд: " + operand2);

        //Присваиваю переменной operation знак операции
        char operation = inputRemoveSpace.charAt(datas[0].length());
        System.out.println("Математическая операция: " + operation);

        //Применяю вычислятор
        int intResult = calculation(operand1, operand2, operation);
        System.out.println("Результат операции int: " + intResult);

        //Конвертирую результат обратно в стринг
        String result = convertIntToString(intResult, stringOperand1);
        System.out.println();
        System.out.println("Output: ");
        System.out.println();
        return result;
    }
    public static void main(String[] args) {
        System.out.println(calc(scan()));
    }
}
