package br.com.ottimizza.atualizaroteiro.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class ObjetoInfosRoteiro {
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String idRoteiro;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cnpjEmpresa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeResumido;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String codErp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tipoLancamento;

}
