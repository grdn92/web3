package br.com.projetoSeLiga.model;

public class Area {
    private String nome;
    private int id;
    
    public Area(){
        nome = "";
    }
    
    public Area(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}
