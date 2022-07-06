import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
       double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
       return random(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return random(amount + amount * yearRate * depositPeriod, 2);
    }
//random - не имеет формы глагола, а это метод. В названии лучше указать глагол) (напишу в лс)
    double random(double value, int places) { 
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();  //эта переменная выделяется. Лучше отправить ее к остальным на строку 22. Либо переменные на строках 20-21 привести к такому же виду. 
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt(); //Кажется, что после строки 29 не хватает пробела, чтобы выделить кусок кода с другой логикой. И после строки 37.
        double outDoubleVar = 0; //DoubleVar - лишнее в названии, т.к. из мы это можем понять из типа переменной, что это переменная и она типа дабл. Но лучше указать, что это сумма.
        if (action == 1) {
            outDoubleVar = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outDoubleVar = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }
    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
