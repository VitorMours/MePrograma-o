/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meprogramacaopropria;

import java.util.Date;

/**
 *
 * @author anton
 */
public class Medico {
    private String CRM;
    private String nome;
    private Date dataNascimento;
    private Date dataCadastro;

    
    
    public String getCRM(){
        return CRM;
    }
    public void setCRM(String CRM){
        this.CRM = CRM;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public Date getNascimento(){
        return dataNascimento;
    }
    public void setNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public Date getCadastro(){
        return dataCadastro;
    }
    public void setCadastro(Date dataCadastro){
        this.dataCadastro = dataCadastro;
    }
    
    
}
