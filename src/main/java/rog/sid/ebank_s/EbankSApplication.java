package rog.sid.ebank_s;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rog.sid.ebank_s.entities.BankAccount;
import rog.sid.ebank_s.enums.AccountType;
import rog.sid.ebank_s.repository.BankAccountRepository;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class EbankSApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankSApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){
        return args -> {
            for (int i = 0; i < 10; i++){
                BankAccount bk = new BankAccount();
                bk.setId(UUID.randomUUID().toString());
                bk.setCreatedAt(new Date());
                bk.setBalance(Math.random()*90000);
                bk.setType(Math.random() > .5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT);
                bk.setCurrency("MAD");
                bankAccountRepository.save(bk);
            }
            bankAccountRepository.findAll().forEach(acc->{
                System.out.println(acc.toString());
            });
        };
    }
}
