package br.com.ottimizza.atualizaroteiro.repository;

import java.math.BigInteger;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ottimizza.atualizaroteiro.domain.models.AtualizaRoteiros;
import feign.Param;

@Repository
public interface AtualizaRoteirosRepository extends JpaRepository<AtualizaRoteiros, BigInteger> {
    
    @Modifying
	@Transactional
	@Query(value = "UPDATE atualiza_roteiros ap SET exportado = true WHERE ap.id IN :exportados ",nativeQuery = true)
	void updateExportados(@Param("exportados") List<BigInteger> exportados) throws Exception;

}
