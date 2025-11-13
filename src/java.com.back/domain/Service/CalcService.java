package domain.Service;

import java.util.Scanner;
import standard.util.Calc;

public class CalcService {

    public int calculate(String expression) {
        return Calc.run(expression);
    }

    public int calculateFromScanner() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return calculate(input);
    }
}
