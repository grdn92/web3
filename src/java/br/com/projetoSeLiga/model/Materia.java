package br.com.projetoSeLiga.model;

import java.util.Date;

public class Materia {
        
    private String titulo;
    private String texto;
    private Date data;
    private int id;
    private String loginColaborador;
    private String nomeArea;
    
    public Materia(){
        
    }
    
    public Materia(String titulo, String texto){
        this.titulo = titulo;
        this.texto = texto;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    public String getTexto(){
        return texto;
    }
    
    public Date getData(){
        return data;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setLoginColaborador(String loginColaborador){
        this.loginColaborador = loginColaborador;
    }
    public String getLoginColaborador(){
        return loginColaborador;
    }
    
    public void setNomeArea(String nomeArea){
        this.nomeArea = nomeArea;
    }
    public String getNomeArea(){
        return nomeArea;
    }
}