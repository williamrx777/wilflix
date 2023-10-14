package br.com.wiflix.repositories;

import br.com.wiflix.entity.Shurato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShuratoRepository extends JpaRepository<Shurato, Long> {
}
