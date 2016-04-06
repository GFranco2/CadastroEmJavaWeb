/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Matheus Barriolo
 */
public class CallOfTaxi {
    
    private String nome, login, senha, confSenha, email, complemento, estado, cidade, bairro, logradouro;
    private int dddTelefone, telefone, dddCelular, celular;
   

    public CallOfTaxi() {
    }

    public CallOfTaxi(String nome, String login, String senha, String confSenha, String email, String complemento, String estado, String cidade, String bairro, String logradouro, int dddTelefone, int telefone, int dddCelular, int celular) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.confSenha = confSenha;
        this.email = email;
        this.complemento = complemento;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.dddTelefone = dddTelefone;
        this.telefone = telefone;
        this.dddCelular = dddCelular;
        this.celular = celular;
    }
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfSenha() {
        return confSenha;
    }

    public void setConfSenha(String confSenha) {
        this.confSenha = confSenha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(int dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int Telefone) {
        this.telefone = telefone;
    }

    public int getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(int dddCelular) {
        this.dddCelular = dddCelular;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int Celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Dados cadastrados: " + "\n nome=" + nome + "\n login=" + login + " \n senha=\n" + senha + "\n confSenha=" + confSenha + "\n email=" + email + "\n complemento=" + complemento + "\n estado=" + estado + "\n cidade=" + cidade + "\n bairro=" + bairro + "\n logradouro=" + logradouro + "\n dddTelefone=" + dddTelefone + "\n Telefone=" + telefone + "\n dddCelular=" + dddCelular + "\n Celular=" + celular;
    }
    
    
    
    
        
    
}
