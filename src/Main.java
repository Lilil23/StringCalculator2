import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x] " +
                "где a и b - строки а x - число  от 1 до 10 включительно  + Enter ");
        String input = scanner.nextLine();
        String[] str;
        char operator;
        if (input.contains(" + ")) {
            str = input.split(" \\+ ");
            operator = '+';
        } else if (input.contains(" - ")) {
            str = input.split(" - ");
            operator = '-';
        } else if (input.contains(" * ")) {
            str = input.split(" \\* ");
            operator = '*';
        } else if (input.contains(" / ")) {
            str = input.split(" / ");
            operator = '/';
        } else {
            throw new Exception("Некорректный знак действия!");
        }


        if (operator == '*' || operator == '/') {
            if (str[1].contains("\"")) throw new Exception("Строчку можно делить" +
                    " или умножать только на число");
        }
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].replace("\"", "");
        }


        if (operator == '+') {
            printResult(str[0] + str[1]);
        } else if (operator == '*') {
            String result = str[0].repeat(Integer.parseInt(str[1]));
            if (result.length() > 40) {
                String res = result.substring(0, 40);
               printResult(res + "...");
            } else {
                printResult(result);
            }
        } else if (operator == '-') {
            int index = str[0].indexOf(str[1]);
            if (index == -1) {
                printResult(str[0]);
            } else {
                String result = str[0].substring(0, index);
                result += str[0].substring(index + str[1].length());
                printResult(result);
            }
        } else {
            int newStr = str[0].length() / Integer.parseInt(str[1]);
            String result = str[0].substring(0, newStr);
            printResult(result);
        }


        if (str[0].length() > 10 || (str[1]).length() > 10 && Integer.parseInt(str[1]) > 10) {
            throw new Exception("Длина строки должна быть не более 10 символов, а число не должно превышать 10!");
        }
    }


        static void printResult (String text){
            System.out.println("\"" + text + "\"");
        }
    }
