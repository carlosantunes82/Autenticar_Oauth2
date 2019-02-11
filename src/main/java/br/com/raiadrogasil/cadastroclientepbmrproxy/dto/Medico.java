package br.com.raiadrogasil.cadastroclientepbmrproxy.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Medico {

    @JsonProperty("idProfissionalCr")
    private long id;

    @JsonProperty("nrCrm")
    private long crm;

    @JsonProperty("nmProfissional")
    private String nome;

    public Medico(long crm){
        this.crm = crm;
    }

    @JsonCreator
    public Medico(@JsonProperty("nrCrm") long crm,
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
        Medico medico = (Medico) o;
        return crm == medico.crm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(crm);
    }

}
