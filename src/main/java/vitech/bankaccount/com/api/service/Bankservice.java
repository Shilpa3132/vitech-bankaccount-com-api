package vitech.bankaccount.com.api.service;

import org.springframework.stereotype.Service;

import vitech.bankaccount.com.api.model.Bankmodel;

@Service
public interface Bankservice {
	String createBankaccount(Bankmodel bankmodel);
	String depositBankaccount(Bankmodel bankmodel);
	String checkBankaccount(Bankmodel bankmodel);
	String withdrawAmount(Bankmodel bankmodel);

}
