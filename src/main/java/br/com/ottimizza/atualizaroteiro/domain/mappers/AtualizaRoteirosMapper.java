package br.com.ottimizza.atualizaroteiro.domain.mappers;

import org.json.JSONObject;

import br.com.ottimizza.atualizaroteiro.domain.dto.InfosRoteiroDTO;
import br.com.ottimizza.atualizaroteiro.domain.dto.ObjetoInfosRoteiro;

public class AtualizaRoteirosMapper {
    
    public static InfosRoteiroDTO fromJson(JSONObject message) {
        InfosRoteiroDTO dto = new InfosRoteiroDTO();
        if(message.has("cnpjEmpresa"))     dto.setCnpjEmpresa(message.optString("cnpjEmpresa"));
        if(message.has("codErp"))          dto.setCodErp(message.optString("codErp"));
        if(message.has("idRoteiro"))       dto.setCodErp(message.optString("idRoteiro"));
        if(message.has("nomeResumido"))    dto.setCodErp(message.optString("nomeResumido"));
        if(message.has("tipoLancamento"))  dto.setCodErp(message.optString("tipoLancamento"));
        return dto;
    }

    public static ObjetoInfosRoteiro objFromJson(JSONObject message) {
        ObjetoInfosRoteiro dto = new ObjetoInfosRoteiro();
        if(message.has("cnpjEmpresa"))     dto.setCnpjEmpresa(message.optString("cnpjEmpresa"));
        if(message.has("codErp"))          dto.setCodErp(message.optString("codErp"));
        if(message.has("idRoteiro"))       dto.setCodErp(message.optString("idRoteiro"));
        if(message.has("nomeResumido"))    dto.setCodErp(message.optString("nomeResumido"));
        if(message.has("tipoLancamento"))  dto.setCodErp(message.optString("tipoLancamento"));
        return dto;
    }

}
