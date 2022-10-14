package rog.sid.ebank_s.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import rog.sid.ebank_s.entities.BankAccount;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
