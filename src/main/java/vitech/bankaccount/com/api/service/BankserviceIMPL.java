package vitech.bankaccount.com.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vitech.bankaccount.com.api.model.Bankmodel;
import vitech.bankaccount.com.api.repository.Bankrepository;

@Service
public class BankserviceIMPL implements Bankservice{
	
	@Autowired
	
	
	public Bankrepository bankrepo;

	@Override
	public String createBankaccount(Bankmodel bank) {
		System.out.println("save bankdata:Start");
		Optional<Bankmodel>existingBank=bankrepo.findByAccountNumAndBank(bank.getAccountNum(),bank.getBank());
		if(existingBank.isPresent()) {
			return "Account"+bank.getAccountNum() + " already exists in the bank " + bank.getBank();
	    }
		bankrepo.save(bank);
		return "Customer details saved successfully. Account number: " + bank.getAccountNum();
		}

	@Override
	public String depositBankaccount(Bankmodel bankmodel) {
		System.out.println("depositToAccount: start");

        // Validate input account number and bank
        if (bankmodel.getAccountNum() == null || bankmodel.getBank() == null) {
            return "Account Number and Bank are required fields.";
        }

        // Find the account by account number and bank
        Optional<Bankmodel> existingBank = bankrepo.findByAccountNumAndBank(bankmodel.getAccountNum(), bankmodel.getBank());
        if (existingBank.isEmpty()) {
            return "Account " + bankmodel.getAccountNum() + " does not exist in the bank " + bankmodel.getBank();
        }

        // Update deposit amount if provided
        Bankmodel account = existingBank.get();
        if (Float.compare(bankmodel.getDepositAmount(), 0.0f) != 0) {
            float updatedAmount = (account.getDepositAmount()!=0.0f ? account.getDepositAmount() : 0) + bankmodel.getDepositAmount();
            account.setDepositAmount(updatedAmount);
        }

        // Save the updated account details
        bankrepo.save(account);

        return "Amount deposit successfully done for the Account Number " + bankmodel.getAccountNum();
    }

	@Override
	public String checkBankaccount(Bankmodel bankmodel) {
		if(bankmodel.getBank()==null || bankmodel.getAcctype()==null ||bankmodel.getAccountNum()==null||bankmodel.getAtmPin()==null) {
			return "Invalid input parameters";
		}
		// Find the account by account number and bank
		Optional<Bankmodel> existingBank = bankrepo.findByAccountNumAndBank(bankmodel.getAccountNum(), bankmodel.getBank());
		if (existingBank.isEmpty()) {
            return "Account not found";
        }
		//Check the ATM PIN
        Bankmodel account = existingBank.get();
        if (!account.getAtmPin().equals(bankmodel.getAtmPin())) {
            return "Invalid ATM PIN Please try with correct pin";
        } else {
        	// Return the balance
            return "Your total balance is " + account.getDepositAmount() + " as on " + java.time.LocalDate.now();
        }
     
    }
	

	@Override
	public String withdrawAmount(Bankmodel bankmodel) {
		// Find the account by account number and bank
        Bankmodel existingBank = bankrepo.findByAccountNumAndBank(bankmodel.getAccountNum(), bankmodel.getBank()).get();

        // Check the ATM PIN
        if (!existingBank.getAtmPin().equals(bankmodel.getAtmPin())) {
            return "Invalid ATM PIN";
        }
        float withdrawAmount = bankmodel.getDepositAmount();

        // Check if the account balance is sufficient
        if (existingBank.getDepositAmount() < withdrawAmount ) {
            return "Insufficient balance";
        } else {
        	float wAmount = existingBank.getDepositAmount()  - withdrawAmount;
             existingBank.setDepositAmount(wAmount);
             bankrepo.save(existingBank);
        }

        // Withdraw the amount
               return "Amount " + withdrawAmount + " is debited. Your total balance is " + existingBank.getDepositAmount();
    }


		
	}
		
		
	
	