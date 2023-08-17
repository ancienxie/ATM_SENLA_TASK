package ATM_SENLA_TASK;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Read_File {
    public static boolean foundCard = false;  // Флаг для определения найденной карты
    public static boolean foundPin = false;   // Флаг для определения найденного PIN-кода
    public static double amountOnBalance;     // Сумма на балансе
    public static String[] parts;             // Массив для хранения данных строки
    
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("C:\\Users\\justs\\eclipse-workspace\\ATM_SENLA_TASK\\src\\ATM_SENLA_TASK\\UserInfo.txt"); // Указывайте полный путь к файлу
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            Scanner scanner = new Scanner(System.in);
            String userCard = scanner.nextLine();  // Ввод номера карты пользователем

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                parts = line.split(" ");  // Разбиваем строку на части по пробелам

                if (parts.length == 3) {  // Если количество частей равно 3
                    String cardNumberFromFile = parts[0];  // Номер карты из файла
                    String pinFromFile = parts[1];  // PIN-код из файла

                    if (userCard.equals(cardNumberFromFile)) {  // Сравниваем введенный номер с номером из файла
                        foundCard = true;
                        System.out.print("\nCorrect card number. Please input your pin code.\nInput here: ");
                        String userPin = scanner.nextLine();  // Ввод PIN-кода пользователем
                        if (userPin.equals(pinFromFile)) {  // Сравниваем введенный PIN-код с кодом из файла
                            foundPin = true;
                        } else {
                        	System.out.println("\nIncorrect pin code.\nGet your card back.");
                            System.exit(0);  // Завершаем программу
                        }
                        break;  // Прерываем цикл
                    }
                }
            }
            
            if (!foundCard) {
            	System.out.println("Incorrect input. Card number doesn't match the database.");
                System.exit(0);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Метод для получения баланса
    public static double balanceFound() {
        try (FileReader fileReader = new FileReader("C:\\Users\\justs\\eclipse-workspace\\ATM_SENLA_TASK\\src\\ATM_SENLA_TASK\\UserInfo.txt"); // Указывайте полный путь к файлу
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                parts = line.split(" ");
                
                if (parts.length == 3) {
                    String balance = parts[2];  // Сумма на балансе из файла
                    amountOnBalance = Double.parseDouble(balance);
                }
                return amountOnBalance;  // Возвращаем сумму на балансе
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return amountOnBalance;
    }
    
    public static boolean cardFound() {
        return foundCard;  // Возвращаем статус найденной карты
    }
    
    public static boolean codeFound() {
        return foundPin;  // Возвращаем статус найденного PIN-кода
    }
}