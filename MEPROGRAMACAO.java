/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package meprogramacaopropria;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 *
 * @author anton
 */
public class MeProgramacaoPropria {
        
    static ArrayList<Medico> listaMedicos = new ArrayList<>(); 
    static ArrayList<Paciente> listaPacientes = new ArrayList<>(); 
    static ArrayList<Consulta> listaConsultas = new ArrayList<>(); 
    static ArrayList<Date> listaDataConsultas = new ArrayList<>();
    // TODO: Corigir os loops para que em vez de buscar os elementos e dar como errado por n ser o primeiro, usar contains() para ver se eles contem em si a pessoa ou não
    public static void main(String[] args) throws ParseException {
        // Variáveis de Código e Estrutura de dados
        String escolha;
        

        Scanner input = new Scanner(System.in);
        
        // Laço do Menu
        while(true){
            System.out.println("\nEscolha uma das seguintes opcoes:");
            System.out.print("""
                             [1] Cadastro Medico 
                             [2] Cadastro Paciente
                             [3] Cadastro Consulta
                             [4] Cancelamento Consulta
                             [5] Relatorio Financeiro
                             """);
        
            System.out.print("\nEscolha: ");
            escolha = input.next();
            switch(escolha){
            
                case "1" -> cadastroMedico();
                case "2" -> cadastroPaciente();
                case "3" -> cadastroConsulta();
                case "4" -> cancelamentoConsulta();
                case "5" -> relatorioFinanceiro();
                case "6" -> {
                }
            }
        }
    }    
    
    
   
    public static void cadastroMedico() throws ParseException{
        // Variáveis de Cadastro
        Scanner input = new Scanner(System.in);
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Medico cadastroMedico = new Medico();


        System.out.print("\nDigite por favor o CRM do medico: ");
        do{
            String crm = input.next();
            if (crm.length() < 2){
                System.out.println("CRM Inválido, por favor coloque um correto."); 
                
            }else if(ChecagemCadastrado(crm,"1")){
                System.out.println("Esse CRM já foi cadastro, por favor aloque outro.");
            
            }else{
                cadastroMedico.setCRM(crm);
                break;
            }
        }while(true);

        System.out.print("Digite por favor o nome do medico: ");
        cadastroMedico.setNome(input.next());

        System.out.print("Digite por favor a data de nascimento do medico[dd/MM/yyyy]: ");
        cadastroMedico.setNascimento(formatoData.parse(input.next()));

        System.out.print("Digite por favor a data de cadastro do medico[dd/MM/yyyy]: ");
        cadastroMedico.setCadastro(formatoData.parse(input.next()));

        listaMedicos.add(cadastroMedico);
        System.out.println("\nInformacoes Medicas:");
        System.out.println("CRM:"+cadastroMedico.getCRM()+ "\nNome:"+cadastroMedico.getNome()+ " \nData de Nascimento:"+cadastroMedico.getNascimento()+ " \nData de Cadastro: "+cadastroMedico.getCadastro());

    }
    
    public static void cadastroPaciente() throws ParseException{
        // Variáveis de Cadastro
        Scanner input = new Scanner(System.in);
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Paciente cadastroPaciente = new Paciente();
        String nome;


        System.out.print("\nDigite por favor o CPF do paciente: ");
        do{
            String cpf = input.next();
            if (cpf.length() < 2){
                System.out.println("CPF Inválido, por favor coloque um correto."); 
                
            }else if(ChecagemCadastrado(cpf,"2")){
                System.out.println("Esse CPF já foi cadastro, por favor aloque outro.");
            
            }else{
                cadastroPaciente.setCPF(cpf);
                break;
            }
        }while(true);

        System.out.print("Digite por favor o nome do paciente: ");
        nome = input.next();
        cadastroPaciente.setNome(nome);

        System.out.print("Digite por favor a data de nascimento do paciente[dd/MM/yyyy]: ");
        cadastroPaciente.setNascimento(formatoData.parse(input.next()));

        System.out.print("Digite por favor a data de cadastro do paciente[dd/MM/yyyy]: ");
        cadastroPaciente.setCadastro(formatoData.parse(input.next()));

        listaPacientes.add(cadastroPaciente);
        System.out.println("\nInformacoes do Paciente:");
        System.out.println("CPF:"+cadastroPaciente.getCPF()+ "\nNome:"+cadastroPaciente.getNome()+ " \nData de Nascimento:"+cadastroPaciente.getNascimento()+ " \nData de Cadastro: "+cadastroPaciente.getCadastro());

    }
    
    public static void cadastroConsulta()throws ParseException{
        // Variáveis e formatos de dados da Consulta
        Scanner input = new Scanner(System.in);
        String nomePaciente;
        String nomeMedico;
        Consulta cadastroConsulta = new Consulta();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        // Buscando se o Paciente existe
        buscaPaciente: do{
            System.out.print("Digite o nome do paciente: ");
            nomePaciente = input.next();
            for(Paciente pacientes: listaPacientes){
                if(!pacientes.getNome().equals(nomePaciente)){
                    System.out.println("Esse paciente nao existe / nao foi cadastrado");
                    
                }else{
                    cadastroConsulta.setPaciente(pacientes);
                    break buscaPaciente;
                }
            }
        }while(true);
        
        
        // Buscando se o Medico existe
        buscaMedico: do{
            System.out.print("Digite o nome do Medico: ");
            nomeMedico = input.next();    
            for(Medico medicos: listaMedicos){
                if(!medicos.getNome().equals(nomeMedico)){
                    System.out.println("Esse medico nao existe / nao foi cadastrado");
                }else{
                    cadastroConsulta.setMedico(medicos);
                    break buscaMedico;
                }    
            }
        }while(true);
    
        
        // Data e Hora da Consulta
        System.out.print("Digite a data da consulta[dd/MM/yyyy]: ");
        String data = input.next();
        Date dataConsulta = formatoData.parse(data);
        cadastroConsulta.setdataConsulta(dataConsulta);
        
        System.out.print("Digite a hora  da consulta[HH:mm]: ");
        String hora = input.next();
        Date dataHora = formatoHora.parse(data+" "+hora);
        cadastroConsulta.sethoraConsulta(dataHora);
        
        
        // Verificando se é a primeira consulta e Settando o valor conforme flag
        for(Consulta consultas: listaConsultas){
            if(consultas.getPaciente().getNome().equals(nomePaciente) && consultas.getMedico().getNome().equals(nomeMedico)){
                cadastroConsulta.setflagConsulta();
            }
        }
        
        // Settando valor da consulta e adicionando na lista de consultas
        cadastroConsulta.setvalorConsulta();
        listaConsultas.add(cadastroConsulta);
    
        // Mostrando informações da Consulta
        cadastroConsulta.mostrarConsulta();
    }
    
    public static void cancelamentoConsulta() throws ParseException{
        // Variáveis de Cancelamento de Consulta
        String CPF;
        String CRM;
        Date dataConsulta;
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        // Checando existencia de consulta
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o CPF da pessoa que quer cancelar a consulta: ");
        
        
        
        buscaPaciente:
        do{ 
            CPF = input.next();
            for(Paciente pacientes:listaPacientes){
                if(CPF.equals(pacientes.getCPF())){
                    break buscaPaciente;
                }else{
                    System.out.println("Nao existe paciente com esse cpf, por favor insira um correto: ");
                }
            }
        }while(true);
    
        for(Consulta consultas: listaConsultas){
            if(consultas.getPaciente().getCPF().equals(CPF)){
                consultas.mostrarConsulta();
            }
        }
        
        System.out.print("Esse paciente possue essas consultas, digite a data da consulta a qual deseja cancelar[dd/MM/yyyy]: ");
        dataConsulta = formatoData.parse(input.next());
        for(Consulta consultas: listaConsultas){
            if(consultas.getdataConsulta().equals(dataConsulta)){
                consultas.mostrarConsulta();
            }
        }
        
        System.out.print("Esse paciente possue essas consultas nessa determinada data, escolha o CRM do medico o qual cancelara a consulta: ");
        CRM = input.next();
        for(Consulta consultas: listaConsultas){
            if(consultas.getMedico().getCRM().equals(CRM)){
                consultas.mostrarConsulta();
            }
        }
        System.out.println("Parabens, essa consulta foi cancelada com sucesso: ");
        
        for(var consultas:listaConsultas){
            if(consultas.getPaciente().getCPF().equals(CPF) && consultas.getMedico().getCRM().equals(CRM)){
                if (consultas.getdataConsulta().equals(dataConsulta)) {
                    listaConsultas.remove(consultas);
                }
            }
        }
    }
    
    public static void relatorioFinanceiro() throws ParseException{
        for(Consulta consultas: listaConsultas){
            if(!listaDataConsultas.contains(consultas.getdataConsulta())){
                listaDataConsultas.add(consultas.getdataConsulta());
            }
        }
        System.out.println("Lista de Datas antes de ordernar");
        System.out.println(listaDataConsultas);
        System.out.println("================================================");
        Collections.sort(listaDataConsultas);
        System.out.println("Depois de Ordernar");
        System.out.println("================================================");
        System.out.println(listaDataConsultas);





        //for(int i = 0; i < listaDataConsultas.size(); i++ ){
        //    for(int j = 0; j < i; j++){
        //        if(listaDataConsultas.get(i).compareTo(listaDataConsultas.get(j)) < 0){
        //            System.out.println(listaDataConsultas);
        //            Date swap = listaDataConsultas.get(j);
        //            listaDataConsultas.set(i, swap);
        //           
        //        }
        //    } 
        //}
    
    }
    
    public static boolean ChecagemCadastrado(String Credencial, String tipo){
        // 1 = CRM
        // 2 = CPF
        
        if(tipo.equals("1")){
            for(Medico medicos: listaMedicos){
                if(medicos.getCRM().equals(Credencial)){
                    return true;   
                }
            }
        }else if(tipo.equals("2")){
            for(Paciente pacientes: listaPacientes){
                if(pacientes.getCPF().equals(Credencial)){
                    return true;   
                }
            }
        }
        return false;}

















}
