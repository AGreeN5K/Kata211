
import java.util.Scanner;

public class Main {
    public void main() {
    }

    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] arithmeticOperationIn = new String[]{"+", "-", "/", "*"};
        String[] arithmeticOperationOut = new String[]{"\\+", "-", "/", "\\*"};
        Scanner scr = new Scanner(System.in);
        System.out.print("Input: ");
        String exp = scr.nextLine();
        int aopIndex = -1;

        for (int i = 0; i < arithmeticOperationIn.length; ++i) {
            if (exp.contains(arithmeticOperationIn[i])) {
                aopIndex = i;
                break;
            }
        }

        if (aopIndex == -1) {
            System.out.println("throws Exception //т.к. строка не является математической операцией");
        } else if (aopIndex > 3) {
            System.out.print("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            String[] data = exp.split(arithmeticOperationOut[aopIndex]);
            if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                boolean isRoman = converter.isRoman(data[0]);
                int a;
                int b;
                if (isRoman) {
                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);
                } else {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                    if (data.length > 2) {
                        System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                        return;
                    }
                }

                int x;
                switch (arithmeticOperationIn[aopIndex]) {
                    case "+" -> x = a + b;
                    case "/" -> x = a / b;
                    case "-" -> x = a - b;
                    case "*" -> x = a * b;
                    default -> x = a = b;
                }

                int result = x;
                if (isRoman) {
                    System.out.println(converter.intToRoman(result));
                } else {
                    System.out.println(result);
                }
            } else {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            }

        }

    }
}
