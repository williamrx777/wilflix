package br.com.wiflix.repositories;

import br.com.wiflix.entity.SW;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SWRepository extends JpaRepository<SW, Long> {
}
