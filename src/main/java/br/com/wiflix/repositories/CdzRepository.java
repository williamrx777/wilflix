package br.com.wiflix.repositories;

import br.com.wiflix.entity.Cdz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdzRepository extends JpaRepository<Cdz,Long> {
}
