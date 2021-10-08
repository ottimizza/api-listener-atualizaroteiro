package br.com.ottimizza.atualizaroteiro.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ottimizza.atualizaroteiro.domain.dto.InfosRoteiroDTO;
import br.com.ottimizza.atualizaroteiro.domain.dto.ObjetoInfosRoteiro;
import br.com.ottimizza.atualizaroteiro.domain.models.AtualizaRoteiros;
import br.com.ottimizza.atualizaroteiro.repository.AtualizaRoteirosRepository;
import br.com.ottimizza.atualizaroteiro.utils.MessageUtils;

@Service
public class AtualizaRoteirosService {

    @Autowired
    AtualizaRoteirosRepository repository;

    public void salvaAtualizaRoteiros(String message) throws Exception {
        try {
            ObjetoInfosRoteiro obj = MessageUtils.entityFromMessage(message);
            AtualizaRoteiros atualizaRoteiro = AtualizaRoteiros.builder()
                                        .infoRoteiro(obj)
                                        .exportado(false)
                                    .build();
            repository.save(atualizaRoteiro);
        }
        catch(Exception ex) {
            System.out.println("Error save arquivo --> " + ex.getMessage());
        }
    }

    public String updateExportados(List<BigInteger> ids) throws Exception {
		StringBuilder retorno = new StringBuilder();
        try {
			repository.updateExportados(ids);
            retorno.append("{\"status\":\"Success\",");
            retorno.append("\"message\":\"Item atualizado com sucesso!\"}");
		} catch (Exception e) {
            System.out.println(e.getMessage());
            retorno.append("{\"status\":\"Error\",");
            retorno.append("\"message\":\"Houve um problema ao atualizar!\"}");
			return retorno.toString();
		}
		return retorno.toString();
	}

}
