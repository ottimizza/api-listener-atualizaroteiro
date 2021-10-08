package br.com.ottimizza.atualizaroteiro.domain.models;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import br.com.ottimizza.atualizaroteiro.domain.dto.ObjetoInfosRoteiro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor @AllArgsConstructor
@Table(name = "atualiza_roteiros")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class AtualizaRoteiros {
    
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "atualiza_roteiros_sequence", sequenceName = "atualiza_roteiros_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atualiza_roteiros_sequence")
    private BigInteger id;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private ObjetoInfosRoteiro infoRoteiro;

    @Column(name = "exportado")
    private boolean exportado;
    
}
