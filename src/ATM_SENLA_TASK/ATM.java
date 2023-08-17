package ATM_SENLA_TASK;


import java.io.*;

public class ATM {
    public double balance = Read_File.balanceFound();
    private double depositAmount;
    private double withdrawAmount;
    
    public ATM(){
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;

        String filePath = "C:\\Users\\justs\\eclipse-workspace\\ATM_SENLA_TASK\\src\\ATM_SENLA_TASK\\UserInfo.txt"; // Указывайте полный путь к файлу
        double newValue = balance;
        try {
            // Чтение данных из файла
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            reader.close();

            // Разбиваем строку на элементы
            String[] parts = line.split(" ");

            // Проверка на наличие достаточного количества элементов
            if (parts.length >= 3) {
                // Изменяем третий элемент
                parts[2] = Double.toString(newValue);

                // Формируем новую строку
                String newLine = String.join(" ", parts);

                // Запись измененных данных обратно в файл
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                writer.write(newLine);
                writer.close();
            } else {
                System.out.println("Недостаточно элементов для изменения.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
		

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}