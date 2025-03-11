package vitech.bankaccount.com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vitech.bankaccount.com.api.model.Bankmodel;

@Repository
public interface Bankrepository extends JpaRepository<Bankmodel, Integer>{

	Optional<Bankmodel> findByAccountNumAndBank(Long accountNum, String bank);

}
