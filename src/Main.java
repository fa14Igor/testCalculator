import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner textForAnaliz = new Scanner(System.in);
        System.out.println("Я умею складывать, вычитать, умножать и делить числа от 1 до 10" +
                "\nВведите математическое выражение: ");
        String allText = textForAnaliz.nextLine();

        if (!(allText.charAt(0) >= '0' && allText.charAt(0) <= '9')) {
            System.out.println("Начните ввод с цифры, два операнда и один оператор (+, -, /, *)");
            System.exit(1);
        }

        String[] elements = new String[allText.length()+1];
        int[] num = new int[allText.length()];
        int n = 1;
        String[] oper = new String[allText.length()];
        int nOper = 1;
        int pos = 0;
        while (pos< allText.length()) {
            switch (allText.charAt(pos)) {
                case '+':
                    elements[pos] = String.valueOf(allText.charAt(pos));
                    oper[nOper] = elements[pos];
                    nOper++;
                    pos++;
                    continue;
                case '-':
                    elements[pos] = String.valueOf(allText.charAt(pos));
                    oper[nOper] = elements[pos];
                    nOper++;
                    pos++;
                    continue;
                case '*':
                    elements[pos] = String.valueOf(allText.charAt(pos));
                    oper[nOper] = elements[pos];
                    nOper++;
                    pos++;
                    continue;
                case '/':
                    elements[pos] = String.valueOf(allText.charAt(pos));
                    oper[nOper] = elements[pos];
                    nOper++;
                    pos++;
                    continue;
                default:
                    if (allText.charAt(pos) >= '0' && allText.charAt(pos) <= '9') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(allText.charAt(pos));
                            pos++;
                            if (pos >= allText.length()) {
                                break;
                            }
                        }
                        while (allText.charAt(pos) >= '0' && allText.charAt(pos) <= '9');
                        elements[pos] = sb.toString();
                        num[n] = Integer.parseInt(elements[pos]);
                        n++;
                    }
                        else {
                        if (allText.charAt(pos) != ' ') {
                            throw new RuntimeException("Unexpected character: " + allText.charAt(pos));
                        }
                        pos++;
                    }

            }


        }
        nOper--;
        n--;
        //for (int i = 1; i <= nOper; i++) { System.out.print("Оператор "+i+": "+oper[i]+"\n"); }
        //for (int i = 1; i <= n; i++) { System.out.print("Цифра "+i+": "+num[i]+"\n"); }

        if (n != 2 || nOper !=1) {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            System.exit(0);
        }
        if (num[1] > 10 || num[1] < 1) {
            System.out.println("Не правильный набор данных: "+num[1]+" - Число должно быть в пределах от 1 до 10 включительно");
            System.exit(0);
        }
        if (num[2] > 10 || num[2] < 1) {
            System.out.println("Не правильный набор данных: "+num[2]+" - Число должно быть в пределах от 1 до 10 включительно");
            System.exit(0);
        }

        int rezult = 123;
        switch (oper[1]) {
            case "+":
                rezult  = num[1] + num[2];
                break;
            case "-":
                rezult  = num[1] - num[2];
                break;
            case "*":
                rezult  = num[1] * num[2];
                break;
            case "/":
                rezult  = num[1] / num[2];
                break;

        }
        System.out.println("Входные данные:\n"+num[1]+" "+oper[1]+" "+num[2]+"\nРезультат: "+rezult);

    }

}