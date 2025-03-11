package vitech.bankaccount.com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vitech.bankaccount.com.api.model.Bankmodel;
import vitech.bankaccount.com.api.service.Bankservice;

@RestController
@RequestMapping("/bankdetails")
public class Bankcontroller {
	
@Autowired
  private Bankservice Bankservice;

//save details
	@PostMapping("/createAccount")
	public ResponseEntity<String> insertBankaccountData(@RequestBody Bankmodel bankmodel) {
		System.out.println("inserBankData:: input received - " + bankmodel);
		try {
			String result = Bankservice.createBankaccount(bankmodel);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			 System.err.println("Error occurred: " + e.getMessage());
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("An error occurred while processing the request.");
}
		
}
	@PutMapping("/deposit")
    public ResponseEntity<String> depositAmount(@RequestBody Bankmodel bankmodel) {
        System.out.println("depositAmount:: input received - " + bankmodel);

        try {
            String result = Bankservice.depositBankaccount(bankmodel);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the deposit request.");
        }
	}
	@GetMapping("/checkBalance")
    public ResponseEntity<String> checkBankaccount(@RequestBody Bankmodel bankmodel) {
		System.out.println("checkBankaccount:: input received - " + bankmodel);
        try {
		String result = Bankservice.checkBankaccount(bankmodel);
        return ResponseEntity.ok(result);
        }catch(Exception e) {
        System.out.println("Error occurred: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while processing the deposit request.");
        
    }
	}
	@PutMapping("/withdrawAmount")
	public ResponseEntity<String> withdrawAmount(@RequestBody Bankmodel bankmodel){
		System.out.println("withdrawAmount:: input received - " + bankmodel);
		try {
		String response = Bankservice.withdrawAmount(bankmodel);
        return ResponseEntity.ok(response);
		}catch(Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the deposit request.");
        
	}
	
}
}
	
				

	



