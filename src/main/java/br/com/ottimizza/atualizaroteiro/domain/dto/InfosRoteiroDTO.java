package br.com.ottimizza.atualizaroteiro.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class InfosRoteiroDTO {

    private String idRoteiro;
    
    private String cnpjEmpresa;

    private String nomeResumido;

    private String codErp;

    private String tipoLancamento;
}
