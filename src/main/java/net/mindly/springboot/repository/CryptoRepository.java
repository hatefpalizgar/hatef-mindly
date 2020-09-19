package net.mindly.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.mindly.springboot.model.Crypto;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, Long> {

}
