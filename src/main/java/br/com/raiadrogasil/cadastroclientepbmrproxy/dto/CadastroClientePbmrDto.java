package br.com.raiadrogasil.cadastroclientepbmrproxy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class CadastroClientePbmrDto {

    private String acao;

    @Min(value = 1, message = "Favor informar o campo idCliente.")
    @NotNull(message = "Favor informar o campo idCliente.")
    private Long idCliente;

    @Size(min = 1, message = "Favor informar o campo nome.")
    @NotNull(message = "Favor informar o campo nome.")
    private String nome;

    @Digits(integer = 11, fraction = 0, message = "Favor digitar apenas numeros no campo CPF com no maximo 11 posicoes.")
//    @Min(value = 1, message = "Favor informar o campo CPF.")
    @NotNull(message = "Favor informar o campo CPF.")
    private String cpf;

    @NotNull(message = "Favor informar o campo dataNascimento.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDate dataNascimento;

    @Size(min = 1, message = "Favor informar o campo sexo.")
    @NotNull(message = "Favor informar o campo sexo.")
    private String sexo;

//    @Size(min = 1, message = "Favor informar o tipo do logradouro..")
    private String tipoLogradouro; // VERIFICAR

    @Size(min = 1, message = "Favor informar o campo endereco.")
    @NotNull(message = "Favor informar o campo endereco.")
    private String endereco;

    @Min(value = 1, message = "Favor informar o campo numero.")
    @NotNull(message = "Favor informar o campo numero.")
    private Integer numero;

    private String complemento;

    @Digits(integer = 8, fraction = 0, message = "Favor digitar apenas numeros no campo cep, com no maximo 8 posicoes.")
//    @Size(min = 1, message = "Favor informar o campo cep.")
    @NotNull(message = "Favor informar o campo cep.")
    private String cep;

    @Size(min = 1, message = "Favor informar o campo bairro.")
    @NotNull(message = "Favor informar o campo bairro.")
    private String bairro;

    @Size(min = 1, message = "Favor informar o campo cidade.")
    @NotNull(message = "Favor informar o campo cidade.")
    private String cidade;

    @Size(min = 1, message = "Favor informar o campo UF.")
    @NotNull(message = "Favor informar o campo UF.")
    private String uf;

//    @Digits(integer = 2, fraction = 0, message = "Favor digitar apenas numeros no campo dddTelefone com no maximo 2 posicoes.")
//    @Min(value = 1, message = "Favor informar o DDD do telefone residencial.")
    private String dddTelefone;

//    @Digits(integer = 9, fraction = 0, message = "Favor digitar apenas numeros no campo telefone com no maximo 9 posicoes.")
//    @Min(value = 1, message = "Favor informar o telefone residencial.")
    private String telefone;

    @Digits(integer = 2, fraction = 0, message = "Favor digitar apenas numeros no campo dddCelular com no maximo 2 posicoes.")
    @NotNull(message = "Favor informar o campo dddCelular.")
    private String dddCelular;

    @Digits(integer = 9, fraction = 0, message = "Favor digitar apenas numeros no campo celular com no maximo 9 posicoes.")
    @NotNull(message = "Favor informar o campo celular.")
    private String celular;

    @Size(min = 1, message = "Favor informar o campo e-mail.")
    @NotNull(message = "Favor informar o campo e-mail.")
    @Email(message = "Favor digitar um e-mail valido.")
    private String email;

    @Min(value = 1, message = "Favor informar o campo medicoCrm.")
    @NotNull(message = "Favor informar o campo medicoCrm.")
    private Long medicoCrm;

    @Size(min = 1, message = "Favor informar o campo medicoNome.")
    @NotNull(message = "Favor informar o campo medicoNome.")
    private String medicoNome;

    @Size(min = 1, message = "Favor informar o campo medicoUf.")
    @NotNull(message = "Favor informar o campo medicoUf.")
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(String dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(String dddCelular) {
        this.dddCelular = dddCelular;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
