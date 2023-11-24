package br.com.wiflix.repositories;

import br.com.wiflix.entity.Yuyuhakusho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YuyuhakushoRepository extends JpaRepository<Yuyuhakusho, Long> {
}
