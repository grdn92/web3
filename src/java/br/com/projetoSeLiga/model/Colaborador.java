package br.com.projetoSeLiga.model;

import java.sql.Date;
import java.util.ArrayList;

public class Colaborador {
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String rg;
    private String email;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String login;
    private String senha;
    private int id;
    private ArrayList<Area> areas;
    
    public Colaborador(){
    nome = ""; cpf = ""; rg = "";
    email = ""; rua = ""; numero = 0;
    complemento = ""; bairro = ""; cidade = "";
    uf = ""; cep = ""; login = ""; senha = "";
    areas = new ArrayList<Area>();
    };
    
    public Colaborador(String nome, Date dataNascimento, String cpf, String rg, 
            String email, String rua, int numero, String complemento, String bairro, 
            String cidade, String uf,String cep, String login, String senha) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.login = login;
        this.senha = senha;
        areas = new ArrayList<Area>();
    }
    
    public void setAreas(Area area){
        areas.add(area);
    }
    
    public ArrayList<Area> getAreas(){
        return areas;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Date getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public void setDataNascimento(int dia, int mes, int ano){
        dataNascimento = Date.valueOf("" + ano + "-" + mes + "-" + dia);
    }
    
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getRg(){
        return rg;
    }
    public void setRg(String rg){
        this.rg = rg;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getRua(){
        return rua;
    }
    public void setRua(String rua){
        this.rua = rua;
    }
    
    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public String getComplemento(){
        return complemento;
    }
    public void setComplemento(String complemento){
        this.complemento = complemento;
    }
    
    public String getBairro(){
        return bairro;
    }
    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    
    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    public String getUf(){
        return uf;
    }
    public void setUf(String uf){
        this.uf = uf;
    }
    
    public String getCep(){
        return cep;
    }
    public void setCep(String cep){
        this.cep = cep;
    }
    
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
}
