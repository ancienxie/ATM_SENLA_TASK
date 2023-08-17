package ATM_SENLA_TASK;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Приветственное сообщение и описание ввода номера карты
    	System.out.print("To enter your bank account you need to input your card number.\nYour card number has to look like this: : XXXX-XXXX-XXXX-XXXX.\nInput here: ");
        
        Atm_Interface operation = new Atm_Operations();  // Создание объекта для операций с банкоматом

        Read_File.main(args);  // Вызов метода для чтения файла с информацией о пользователях
        Scanner input = new Scanner(System.in);  // Создание объекта Scanner для ввода данных пользователем

        // Проверка наличия карты и PIN-кода в базе данных
        if (Read_File.cardFound() && Read_File.codeFound()) {
        	System.out.println("\n*****************************");
    		System.out.println("Account Authorized!\nWelcome To Your Bank Account!");
            System.out.println("\n1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.Exit");
            System.out.println("*****************************\n");
            System.out.print("Enter Choice : ");
            
            while (true) {
                String ch = input.nextLine();  // Ввод выбора операции
                
                if (ch.equals("1")) {
                    operation.viewBalance();  // Вызов метода для просмотра баланса
                } 
                else if (ch.equals("2")) {
                	System.out.print("\nEnter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    input.nextLine();
                    operation.withdrawAmount(withdrawAmount);  // Вызов метода для снятия денег
                } 
                else if (ch.equals("3")) {
                	System.out.print("\nEnter Amount to Deposit :");
                    double depositAmount = input.nextDouble();
                    input.nextLine();
                    if (depositAmount >= 1000000) {
                    	System.out.println("\nATM can't handle so much cash.\nPlease put lower quatity of cash.\n");
                        continue;
                    }
                    operation.depositAmount(depositAmount);  // Вызов метода для внесения денег
                } 
                else if (ch.equals("4")) {
                	System.out.println("\nCollect your ATM card!\nThank you for using ATM machine!");
                    System.exit(0);  // Завершение программы
                } 
                else {
                	System.out.println("\nPlease enter valid choice.\n");
                }
                System.out.print("Enter choice : ");
            }
        } 
        else {
        	System.out.print("\nIncorrect input. Card number doesn't match to database.");
        	System.exit(0);  // Завершение программы
        }
        input.close();  // Закрытие объекта Scanner
    }
}