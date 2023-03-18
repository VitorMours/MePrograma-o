package com.mycompany.meprogamacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                               6 - Todos os médicos
                               7 - todos os pacientes
                               """);
            System.out.print("Escolha uma das opções á cima: ");
            opcao = entrada.next();

            if(opcao.equals("1")){
                    CadastrarMedico();
            }

            if(opcao.equals("2")){
                    CadastrarPaciente();
            }

            if (opcao.equals("3")){
                    CadastroConsulta();
                
        }
            
            if(opcao.equals("4")){
                
            }
            
            
            if(opcao.equals("6")){
                relatorioMedicos();
            }
            
            if(opcao.equals("7")){
                relatorioPacientes();
            }
            
        System.out.println("Deseja Continuar?? [S/N]: ");
        
        resp = entrada.next();

            
        }while(!resp.equalsIgnoreCase("N"));
        
        //Progama Principal AQUI.
        
        
        
    }
    
    ///Métodos estáticos
    
    
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
            }else{
                if(validacaoCrm(crm)){
                    System.out.println("Crm já existente");
                }else{
                    medico.setCrm(crm);
                    System.out.println("Data de nascimento do médico[dd/MM/yyyy]: ");
                    medico.setDatanascimento(formato.parse(entrada.next()));
                    System.out.println("Data de cadastro do médico no sistema[dd/MM/yyyy]: ");
                    medico.setDatacadastro(formato.parse(entrada.next()));
                    listaMedicos.add(medico);
                    System.out.println("Medico: " + medico.getNome() + ", de Crm: " + medico.getCrm() + ",Cadastrado no sistema");
                }
                
            }

//            medico.setCrm(crm);
//            System.out.println("Data de nascimento do médico[dd/MM/yyyy]: ");
//            medico.setDatanascimento(formato.parse(entrada.next()));
//            System.out.println("Data de cadastro do médico no sistema[dd/MM/yyyy]: ");
//            medico.setDatacadastro(formato.parse(entrada.next()));
//            listaMedicos.add(medico);
//            System.out.println("Medico: " + medico.getNome() + ", de Crm: " + medico.getCrm() + ",Cadastrado no sistema");

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
                    if(cpf.length() < 2){
                        System.out.println("CPF INVÁLIDO");
                    }else{
                        if(validacaoCpf(cpf)){
                            System.out.println("Cpf já existe, por favor informe cpf válido e cadastre novamente");

                        }else{
                            paciente.setCpf(cpf);
                            System.out.println("Data de nascimento[dd/MM/yyyy]: ");
                            paciente.setNascimento(formato.parse(entrada.next()));
                            System.out.println("Data da consulta[dd/MM//yyyy]: ");
                            paciente.setDatacadastro(formato.parse(entrada.next()));
                            System.out.println("Endereço: ");
                            paciente.setEndereco(entrada.next());
                            listaPaciente.add(paciente);
                            System.out.println("Paciente: " + paciente.getNome() + ", de cpf: " + paciente.getCpf() + ", que nasceu " + paciente.getNascimento() + ", Cadastrado no sistema");
                        }
                    }
                        
    }
    
    public static void CadastroConsulta() throws ParseException{
        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Consulta consulta = new Consulta();
        System.out.println("Informe o crm do médico para a procura: ");
        String crm = entrada.next();
        if(crm.length() < 4){
                System.out.println("CRM INVÁLIDO");
        }else{
            System.out.println("Informe o cpf do paciente: ");
            String cpf = entrada.next();
            if(validacaoCrm(crm) & validacaoCpf(cpf)){
               consultarCrmRetornoNome(crm);
                
                System.out.println("Qual a data da consulta[dd/MM/yyyy]: ");
                consulta.setConsulta(formato.parse(entrada.next()));
                System.out.println("Horario da consulta[HH:mm:ss]:");
                consulta.setValorconsulta(350);
                consulta.setHoraconsulta(formatoHora.parse(entrada.next()));

                if (VerificarSeJafui(crm, cpf)) consulta.setValorconsulta(300);

                listaConsultas.add(consulta);
                System.out.println("Consulta do médico: " + consultarCrmRetornoNome(crm) + ", do paciente " + consultarCpfRetornoNome(cpf) + " , na data de " + consulta.getConsulta() + ", no horario" + consulta.getHoraconsulta() + ",  no valor de " + consulta.getValorconsulta());
            }
              
            }
            
        }
    
    
    public static void CancelarConsulta() throws ParseException{
        for(Consulta consultas : listaConsultas){
            SimpleDateFormat formato = new SimpleDateFormat("[dd/MM/yyyy]");
            Scanner entrada = new Scanner(System.in);
            System.out.println("Informe o cpf da pessoa para cancelamento da consulta: ");
            String cpf = entrada.next();
            if(cpf.length() < 4){
                System.out.println("Cpf inválido.");
            }else{
                System.out.println("Informe o crm do médico: ");
                String crm = entrada.next();
                if(validacaoCpf(cpf) & validacaoCrm(crm)){
                    System.out.println("Nome médico: " + consultarCrmRetornoNome(crm));
                    System.out.println("Nome do paciente: " + consultarCpfRetornoNome(cpf));
                    System.out.println("Informe a data da consulta:[dd/MM/yyyy]: ");
                    Date data = formato.parse(entrada.next());
                    if(Search_Cpf_Crm_Date(cpf, crm, data)){
                        System.out.println("Consulta cancelada com sucesso");
                    }else{
                        System.out.println("Houve um erro em remover tal consulta.");
                    }
                        
                }
                
            }
            
    }
        
        
        
    }
    
    
    public static boolean Search_Cpf_Crm_Date(String cpf, String crm, Date date){
        for(Consulta consultas : listaConsultas){
            if(consultas.getCpf().equals(cpf) & consultas.getCrm().equals(crm) & consultas.getConsulta().equals(date)){
                listaConsultas.remove(consultas);
                return true;
            }
            
        }
        return false;
    }
    
       
        
        
        
        
    
    
    public static boolean VerificarSeJafui(String crm, String cpf){
        for(Consulta consulta : listaConsultas){
            if(consulta.getCrm().equals(crm) & consulta.getCpf().equals(cpf)){
                return true;
                
            }
            
        }
        return false;
    }
    
    public static boolean validacaoCrm(String crm){
        for(Medicos medico : listaMedicos){
            if(medico.getCrm().equals(crm)){
                return true;
            }
            
        }
        return false;
        
        
    }
    
    public static boolean validacaoCpf(String cpf){
        for(Paciente paciente : listaPaciente){
            if(paciente.getCpf().equals(cpf) ){
                return true;
            }
        }
        
        return false;
        
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
   
   
   public static Object relatorioMedicos(){
       for(Medicos medico: listaMedicos){
           System.out.println(medico.getNome());
           
       }
        return null;
   }
   
   public static Object relatorioPacientes(){
       for(Paciente pacientes : listaPaciente){
           System.out.println(pacientes.getNome());
       }
        return null;
   }
}
