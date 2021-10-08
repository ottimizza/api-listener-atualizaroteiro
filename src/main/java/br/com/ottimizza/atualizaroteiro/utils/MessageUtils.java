package br.com.ottimizza.atualizaroteiro.utils;

import org.json.JSONObject;

import br.com.ottimizza.atualizaroteiro.domain.dto.ObjetoInfosRoteiro;
import br.com.ottimizza.atualizaroteiro.domain.mappers.AtualizaRoteirosMapper;

public class MessageUtils {
    
    public static String CleanMessage(String message) {
		return message.replaceAll("\\\\", "").replace("\"{","{").replace("}\"","}").trim();
	}

    public static ObjetoInfosRoteiro entityFromMessage(String message) {
		ObjetoInfosRoteiro roteiros = new ObjetoInfosRoteiro();
        String objRoteiro = "";
		message = CleanMessage(message);
		System.out.println(message);
		if(message.contains("message")) {
			String s = message.substring(message.indexOf("message"));
            if(s.contains("{") && s.contains("}")) {
                objRoteiro = s.substring(s.indexOf("{"), s.lastIndexOf("}")).trim();
            }
			System.out.println(objRoteiro);
            roteiros = AtualizaRoteirosMapper.objFromJson(new JSONObject(objRoteiro.trim()));//er.objFromJson(new JSONObject(objArquivo.trim()));
		}
		return roteiros;
	}

}
