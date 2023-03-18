/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.meprogamacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ian
 */
public class MEPROGAMACAO {
    
    static ArrayList<Medicos> listaMedicos = new ArrayList<>();
    static ArrayList<Paciente> listaPaciente = new ArrayList<>();
    static ArrayList<Consulta> listaConsultas = new ArrayList<>();

    public static void main(String[] args) throws ParseException {
        //PROGAMA PRINCIPAL
        
        Scanner entrada = new Scanner(System.in);
        String opcao = "" ;
        String resp = "";

        do{
            System.out.println("""
                               1- Cadastro Medico
                               2- Cadastro Paciente
                               3 - Cadastro de consultas
                               4 - Cancelamento de consultas
                               5 - Relatorio financeiro
                               """);
            System.out.println("Escolha uma das opções á cima: ");
            opcao = entrada.next();

            if(opcao.equals("1")){
                    CadastrarMedico();
            }

            if(opcao.equals("2")){
                   CadastrarPaciente();
            }

            if (opcao.equals("3")){
        }
            
        System.out.println("Deseja Continuar?? [S/N]: ");
        resp = entrada.next();

            
        }while(!resp.equalsIgnoreCase("N"));
        
        
        
    }
    
    
    public static void CadastrarMedico() throws ParseException{
            Scanner entrada = new Scanner(System.in);
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Medicos medico = new Medicos();
            System.out.println("Nome do Médico: ");
            String nome = entrada.next();
            medico.setNome(nome);
            System.out.println("CRM médico: ");
            String crm = entrada.next();
            if(crm.length() < 4){
                System.out.println("Crm Inválido");
            }
            if(validacaoCrm(crm) == false){
                System.out.println("Crm já existente");
            }

            medico.setCrm(crm);
            System.out.println("Data de nascimento do médico[dd/MM/yyyy]: ");
            medico.setDatanascimento(formato.parse(entrada.next()));
            System.out.println("Data de cadastro do médico no sistema[dd/MM/yyyy]: ");
            medico.setDatacadastro(formato.parse(entrada.next()));
            listaMedicos.add(medico);
            System.out.println("Medico: " + medico.getNome() + ", de Crm: " + medico.getCrm() + ",Cadastrado no sistema");

    }
    
    public static void CadastrarPaciente() throws ParseException{
        
                    Paciente paciente = new Paciente();
                    Scanner entrada = new Scanner(System.in);
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("Nome do Paciente: ");
                    String nome = entrada.next();
                    paciente.setNome(nome);
                    System.out.println("CPF do paciente: ");
                    String cpf = entrada.next();
                    paciente.setCpf(cpf);
                    
                    if(paciente.getCpf().length() < 2){
                        System.out.println("CPF INVÁLIDO");
                    }
                    if(validacaoCpf(cpf) == false){
                        System.out.println("Cpf já existe, por favor informe cpf válido e cadastre novamente");
                    }
                    System.out.println("Data de nascimento[dd/MM/yyyy]: ");
                    paciente.setNascimento(formato.parse(entrada.next()));
                    System.out.println("Data da consulta[dd/MM//yyyy]: ");
                    paciente.setDatacadastro(formato.parse(entrada.next()));
                    System.out.println("Endereço: ");
                    paciente.setEndereco(entrada.next());
                    listaPaciente.add(paciente);
                    System.out.println("Paciente: " + paciente.getNome() + ", de cpf: " + paciente.getCpf() + ", que nasceu " + paciente.getNascimento() + ", Cadastrado no sistema");
        
    }
    
    public static void CadastroConsulta() throws ParseException{
        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Consulta consulta = new Consulta();
        Medicos medico = new Medicos();
        Paciente pacientes = new Paciente();
        System.out.println("Informe o crm do médico para a procura: ");
        String crm = entrada.next();
        if(validacaoCrm(crm) == false){
            System.out.println("Crm já existente");
            
        }else{
            if(crm.length() < 4){
                System.out.println("CRM INVÁLIDO");
            }
        }
        consultarCrmRetornoNome(crm);
        
        System.out.println("Informe o cpf do paciente: ");
        String cpf = entrada.next();
        if(cpf.length()< 2){
            System.out.println("CPF inválido");
        }
        if(validacaoCpf(cpf) == false){
            System.out.println("CPF já existe");
        }
        consultarCpfRetornoNome(cpf);
        System.out.println("Qual a data da consulta[dd/MM/yyyy]: ");
        consulta.setConsulta(formato.parse(entrada.next()));
        System.out.println("Horario da consulta[HH:mm:ss]:");
        consulta.setHoraconsulta(formatoHora.parse(entrada.next()));
        
        
        
        
    }
    
    public static boolean validacaoCrm(String crm){
        for(Medicos medico : listaMedicos){
            if(medico.getCrm().equals(crm)){
                return false;
            }
            
        }
        return true;
        
        
    }
    
    public static boolean validacaoCpf(String cpf){
        for(Paciente paciente : listaPaciente){
            if(paciente.getCpf().equals(cpf) ){
                return false;
            }
        }
        
        return true;
        
    }
    
    public static String consultarCpfRetornoNome(String cpf){
        for(Paciente paciente: listaPaciente){
            if(paciente.getCpf().equals(cpf)){
                return paciente.getNome();
            }
            
        }
        return null;
    }
    
   public static String consultarCrmRetornoNome(String crm){
       for(Medicos medico: listaMedicos){
           if(medico.getCrm().equals(crm)){
               return medico.getNome();
           }
       }
        return null;
   }
}





