package ATM_SENLA_TASK;

public class Atm_Operations implements Atm_Interface{
    ATM atm = new ATM();

    
    //Обзор баланса
    @Override
    public void viewBalance() {
    	System.out.println("\nLoading accout balance.......");
        System.out.println("Your current balance is : "+atm.getBalance());
        System.out.println();
    }

    //Метод для снятия суммы денег
    @Override
    public void withdrawAmount(double withdrawAmount) {
            if (withdrawAmount <= atm.getBalance()) {
                System.out.println("\nCollect the cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            	
            } else {
                System.out.println("Insufficient Balance !!");
            }
    }

    //Метод для пополнения баланса
    @Override 
    public void depositAmount(double depositAmount) {
        System.out.println("\n"+depositAmount+" deposited successfully!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
    }

}