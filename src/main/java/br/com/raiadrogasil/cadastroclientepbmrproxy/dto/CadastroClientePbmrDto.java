package br.com.raiadrogasil.cadastroclientepbmrproxy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CadastroClientePbmrDto {

    private String acao;

    @Min(value = 1, message = "Favor informar o campo idCliente.")
    @NotNull(message = "Favor informar o campo idCliente.")
    @ApiModelProperty(notes="ID do cliente.", required = true)
    private Long idCliente;

    @Size(min = 1, message = "Favor informar o campo nome.")
    @NotNull(message = "Favor informar o campo nome.")
    @ApiModelProperty(notes="Nome do cliente.", required = true)
    private String nome;

    @Digits(integer = 11, fraction = 0, message = "Favor digitar apenas numeros no campo CPF com no maximo 11 posicoes.")
    @NotNull(message = "Favor informar o campo CPF.")
    @ApiModelProperty(notes="CPF do cliente.", required = true)
    private String cpf;

    @NotNull(message = "Favor informar o campo dataNascimento.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @ApiModelProperty(notes="Data de nascimento do cliente.", required = true)
    private LocalDate dataNascimento;

    @Size(min = 1, message = "Favor informar o campo sexo.")
    @NotNull(message = "Favor informar o campo sexo.")
    @ApiModelProperty(notes="Sexo do cliente.", required = true)
    private String sexo;

    @ApiModelProperty(notes="Logradouro do cliente.", required = false)
    private String tipoLogradouro; // VERIFICAR

    @Size(min = 1, message = "Favor informar o campo endereco.")
    @NotNull(message = "Favor informar o campo endereco.")
    @ApiModelProperty(notes="Endereco do cliente.", required = true)
    private String endereco;

    @Min(value = 1, message = "Favor informar o campo numero.")
    @NotNull(message = "Favor informar o campo numero.")
    @ApiModelProperty(notes="Numero do cliente.", required = true)
    private Integer numero;

    @ApiModelProperty(notes="Complemento do cliente.", required = false)
    private String complemento;

    @Digits(integer = 8, fraction = 0, message = "Favor digitar apenas numeros no campo cep, com no maximo 8 posicoes.")
//    @Size(min = 1, message = "Favor informar o campo cep.")
    @NotNull(message = "Favor informar o campo cep.")
    @ApiModelProperty(notes="Cep do cliente.", required = true)
    private String cep;

    @Size(min = 1, message = "Favor informar o campo bairro.")
    @NotNull(message = "Favor informar o campo bairro.")
    @ApiModelProperty(notes="Bairro do cliente.", required = true)
    private String bairro;

    @Size(min = 1, message = "Favor informar o campo cidade.")
    @NotNull(message = "Favor informar o campo cidade.")
    @ApiModelProperty(notes="Cidade do cliente.", required = true)
    private String cidade;

    @Size(min = 1, message = "Favor informar o campo UF.")
    @NotNull(message = "Favor informar o campo UF.")
    @ApiModelProperty(notes="UF do cliente.", required = true)
    private String uf;

//    @Digits(integer = 2, fraction = 0, message = "Favor digitar apenas numeros no campo dddTelefone com no maximo 2 posicoes.")
//    @Min(value = 1, message = "Favor informar o DDD do telefone residencial.")
    @ApiModelProperty(notes="DDD do telefone fixo do cliente.", required = false)
    private String dddTelefone;

//    @Digits(integer = 9, fraction = 0, message = "Favor digitar apenas numeros no campo telefone com no maximo 9 posicoes.")
//    @Min(value = 1, message = "Favor informar o telefone residencial.")
    @ApiModelProperty(notes="Telefone fixo do cliente.", required = false)
    private String telefone;

    @Digits(integer = 2, fraction = 0, message = "Favor digitar apenas numeros no campo dddCelular com no maximo 2 posicoes.")
    @NotNull(message = "Favor informar o campo dddCelular.")
    @ApiModelProperty(notes="DDD do celular do cliente.", required = true)
    private String dddCelular;

    @Digits(integer = 9, fraction = 0, message = "Favor digitar apenas numeros no campo celular com no maximo 9 posicoes.")
    @NotNull(message = "Favor informar o campo celular.")
    @ApiModelProperty(notes="Telefone celular do cliente.", required = true)
    private String celular;

    @Size(min = 1, message = "Favor informar o campo e-mail.")
    @NotNull(message = "Favor informar o campo e-mail.")
    @Email(message = "Favor digitar um e-mail valido.")
    @ApiModelProperty(notes="E-mail do cliente.", required = true)
    private String email;

    @Min(value = 1, message = "Favor informar o campo medicoCrm.")
    @NotNull(message = "Favor informar o campo medicoCrm.")
    @ApiModelProperty(notes="CRM do medico.", required = true)
    private Long medicoCrm;

    @Size(min = 1, message = "Favor informar o campo medicoNome.")
    @NotNull(message = "Favor informar o campo medicoNome.")
    @ApiModelProperty(notes="Nome do medico.", required = true)
    private String medicoNome;

    @Size(min = 1, message = "Favor informar o campo medicoUf.")
    @NotNull(message = "Favor informar o campo medicoUf.")
    @ApiModelProperty(notes="UF do medico.", required = true)
    private String medicoUf;

    @ApiModelProperty(notes="Contato e-mail.", required = false)
    private String contatoEmail;

    @ApiModelProperty(notes="Contato celular.", required = false)
    private String contatoCelular;

    @ApiModelProperty(notes="Contato correio.", required = false)
    private String contatoCorreio;

    @ApiModelProperty(notes="Contato permissao.", required = false)
    private String contatoPermissao;

    @ApiModelProperty(notes="Codigo do produto.", required = false)
    private Long cdProduto;

    @ApiModelProperty(notes="Preco bruto.", required = false)
    private String precoBruto;

    @ApiModelProperty(notes="Preco liquido.", required = false)
    private String precoLiquido;

    @ApiModelProperty(notes="isContatos.", required = false)
    private String isContatos;

    @ApiModelProperty(notes="Nr sequencia endereco.", required = false)
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
