package br.com.raiadrogasil.cadastroclientepbmrproxy.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicoDto {

    @JsonProperty("idProfissionalCr")
    private long id;

    @JsonProperty("nrCrm")
    private long crm;

    @JsonProperty("nmProfissional")
    private String nome;

    public MedicoDto(long crm){
        this.crm = crm;
    }

    @JsonCreator
    public MedicoDto(@JsonProperty("nrCrm") long crm,
                     @JsonProperty("nmProfissional") String nome) {
        this(crm);
        this.nome = nome;
    }

    public long getCrm() {
        return crm;
    }

    public String getNome() {
        return nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicoDto medico = (MedicoDto) o;
        return crm == medico.crm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(crm);
    }

}
