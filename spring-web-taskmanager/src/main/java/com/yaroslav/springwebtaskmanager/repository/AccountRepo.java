package com.yaroslav.springwebtaskmanager.repository;

import com.yaroslav.springwebtaskmanager.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    Account findByName(String name);

}
