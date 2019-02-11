package br.com.raiadrogasil.cadastroclientepbmrproxy.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class CadastroClientePbmrDto {

    private String acao;

    private Long idCliente;

    @Size(min = 1, message = "Favor informar o nome.")
    @NotNull(message = "Favor informar o nome.")
    private String nome;

    @Min(value = 1, message = "Favor informar o CPF.")
    @NotNull(message = "Favor informar o CPF.")
    private Long cpf;

    @Size(min = 1, message = "Favor informar o CPF.")
    @NotNull(message = "Favor informar o CPF.")
    private String dataNascimento;

    @Size(min = 1, message = "Favor informar o sexo.")
    @NotNull(message = "Favor informar o sexo.")
    private String sexo;

//    @Size(min = 1, message = "Favor informar o tipo do logradouro..")
//    @NotNull(message = "Favor informar o tipo do logradouro..")
    private String tipoLogradouro; // VERIFICAR

    @Size(min = 1, message = "Favor informar o endereco.")
    @NotNull(message = "Favor informar o endereco.")
    private String endereco;

    @Min(value = 1, message = "Favor informar o numero.")
    @NotNull(message = "Favor informar o numero.")
    private Integer numero;

    private String complemento;

    @Size(min = 1, message = "Favor informar o cep.")
    @NotNull(message = "Favor informar o cep.")
    private String cep;

    @Size(min = 1, message = "Favor informar o bairro.")
    @NotNull(message = "Favor informar o bairro.")
    private String bairro;

    @Size(min = 1, message = "Favor informar o cidade.")
    @NotNull(message = "Favor informar o cidade.")
    private String cidade;

    @Size(min = 1, message = "Favor informar UF.")
    @NotNull(message = "Favor informar o UF.")
    private String uf;

    @Min(value = 1, message = "Favor informar o DDD do telefone residencial.")
    @NotNull(message = "Favor informar o o DDD do telefone residencial.")
    private Integer dddTelefone;

    @Min(value = 1, message = "Favor informar o telefone residencial.")
    @NotNull(message = "Favor informar o telefone residencial.")
    private Long telefone;

    @Min(value = 1, message = "Favor informar o DDD do celular.")
    @NotNull(message = "Favor informar o DDD do celular.")
    private Integer dddCelular;

    @Min(value = 1, message = "Favor informar o telefone celular.")
    @NotNull(message = "Favor informar o telefone celular.")
    private Long celular;

    @Size(min = 1, message = "Favor informar o e-mail.")
    @NotNull(message = "Favor informar o e-mail.")
    private String email;

    @Min(value = 1, message = "Favor informar o CRM do medico.")
    @NotNull(message = "Favor informar o CRM do medico.")
    private Long medicoCrm;

    @Size(min = 1, message = "Favor informar o nome do medico.")
    @NotNull(message = "Favor informar o nome do medico.")
    private String medicoNome;

    @Size(min = 1, message = "Favor informar o UF do medico.")
    @NotNull(message = "Favor informar o UF do medico.")
    private String medicoUf;

    private String contatoEmail;

    private String contatoCelular;

    private String contatoCorreio;

    private String contatoPermissao;

    private Long cdProduto;

    private String precoBruto;

    private String precoLiquido;

    private String isContatos;

    private Long nrSequenciaEndereco;

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(Integer dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Integer getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(Integer dddCelular) {
        this.dddCelular = dddCelular;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMedicoCrm() {
        return medicoCrm;
    }

    public void setMedicoCrm(Long medicoCrm) {
        this.medicoCrm = medicoCrm;
    }

    public String getMedicoNome() {
        return medicoNome;
    }

    public void setMedicoNome(String medicoNome) {
        this.medicoNome = medicoNome;
    }

    public String getMedicoUf() {
        return medicoUf;
    }

    public void setMedicoUf(String medicoUf) {
        this.medicoUf = medicoUf;
    }

    public String getContatoEmail() {
        return contatoEmail;
    }

    public void setContatoEmail(String contatoEmail) {
        this.contatoEmail = contatoEmail;
    }

    public String getContatoCelular() {
        return contatoCelular;
    }

    public void setContatoCelular(String contatoCelular) {
        this.contatoCelular = contatoCelular;
    }

    public String getContatoCorreio() {
        return contatoCorreio;
    }

    public void setContatoCorreio(String contatoCorreio) {
        this.contatoCorreio = contatoCorreio;
    }

    public String getContatoPermissao() {
        return contatoPermissao;
    }

    public void setContatoPermissao(String contatoPermissao) {
        this.contatoPermissao = contatoPermissao;
    }

    public Long getCdProduto() {
        return cdProduto;
    }

    public void setCdProduto(Long cdProduto) {
        this.cdProduto = cdProduto;
    }

    public String getPrecoBruto() {
        return precoBruto;
    }

    public void setPrecoBruto(String precoBruto) {
        this.precoBruto = precoBruto;
    }

    public String getPrecoLiquido() {
        return precoLiquido;
    }

    public void setPrecoLiquido(String precoLiquido) {
        this.precoLiquido = precoLiquido;
    }

    public String getIsContatos() {
        return isContatos;
    }

    public void setIsContatos(String isContatos) {
        this.isContatos = isContatos;
    }

    public Long getNrSequenciaEndereco() {
        return nrSequenciaEndereco;
    }

    public void setNrSequenciaEndereco(Long nrSequenciaEndereco) {
        this.nrSequenciaEndereco = nrSequenciaEndereco;
    }

}
