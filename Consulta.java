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
public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private Date dataConsulta;
    private Date horaConsulta;
    private boolean flagConsulta = true;
    private String statusConsulta="Agendada"; 
    private int valorConsulta=350;

    
    
    public void setPaciente(Paciente inputPaciente){
        this.paciente = inputPaciente;
    }
    public Paciente getPaciente(){
        return paciente;
    }
    
    public void setMedico(Medico inputMedico){
        this.medico = inputMedico;
    }
    public Medico getMedico(){
        return medico;
    }
    
    public void setdataConsulta(Date data){
        this.dataConsulta = data;
    }public Date getdataConsulta(){
        return dataConsulta;
    }
    
    public void sethoraConsulta(Date hora){
        this.horaConsulta = hora;
    }
    public Date gethoraConsulta(){
        return horaConsulta;
    }
    
    public void setflagConsulta(){
        this.flagConsulta = false;
    }
    public boolean getflagConsulta(){
        return flagConsulta;
    }
    
    public void setstatusConsulta(String status){
        this.statusConsulta = "Agendada";
    }
    public String getstatusConsulta(){
        return statusConsulta;
    }
    
    public void setvalorConsulta(){
        if(this.getflagConsulta()){
            this.valorConsulta = 350;
        }else{
            this.valorConsulta = 300;
        }
    
    }
    public int getvalorConsulta(){
        return valorConsulta;
    }
    
    public void mostrarConsulta(){
    System.out.println("\nMostrando dados da consulta: ");
    System.out.println("Medico: " +this.getMedico().getNome()+" - "+this.getMedico().getCRM()+
                       "\nPaciente: "+this.getPaciente().getNome()+" - "+this.getPaciente().getCPF()+ 
                       "\nData e Hora: "+this.gethoraConsulta()+ 
                       "\nStatus: "+this.getstatusConsulta()+ 
                       "\nValor:  "+this.getvalorConsulta());
    }
}
