package br.com.jadson.views.exercicio2;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.jadson.models.vo.exercicio2.PessoaVO;
import br.com.jadson.controllers.exercicio2.ControllerPessoa;

public class MenuPessoa {
    public static final int MENU_PESSOA_CRIAR = 1;
    public static final int MENU_PESSOA_DELETAR = 2;
    public static final int MENU_PESSOA_ATUALIZAR = 3;
    public static final int MENU_PESSOA_BUSCAR = 4;

    public void exibirMenu() {

        int option = this.exibirOpcoes();

        switch (option) {
            case MENU_PESSOA_CRIAR:
                this.criar();
                break;
            case MENU_PESSOA_DELETAR:
                this.deletar();
                break;
            case MENU_PESSOA_ATUALIZAR:
                this.atualizar();
                break;
            case MENU_PESSOA_BUSCAR:
                this.buscar();
                break;
            default:
                System.out.println("Opção errada");
                this.exibirOpcoes();
                break;
        }

    }

    public int exibirOpcoes() {
        Scanner teclado = new Scanner(System.in);
        int option = 0;
        System.out.println("CADASTRO DE PESSOA\n\n");
        System.out.println("Options:");

        System.out.println(MENU_PESSOA_CRIAR + " - CRIAR");
        System.out.println(MENU_PESSOA_DELETAR + " - DELETAR");
        System.out.println(MENU_PESSOA_ATUALIZAR + " - ATUALIZAR");
        System.out.println(MENU_PESSOA_BUSCAR + " - BUSCAR");

        try {
            option = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("Digite somente números");
        }
        

        return option;
    }

    public void criar() {
        PessoaVO pessoa = new PessoaVO();
        ControllerPessoa controllerPessoa = new ControllerPessoa();
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite nome: ");
        String nome = teclado.nextLine();
        System.out.print("Digite sexo (M|F): ");
        char sexo = teclado.nextLine().charAt(0);
        System.out.print("Digite o cpf: ");
        String cpf = teclado.nextLine();
        System.out.print("Digite tipo (1|0): ");
        String tipo = teclado.nextLine();

        pessoa.setNome(nome);
        pessoa.setSexo(sexo);
        pessoa.setTipo(tipo);
        pessoa.setCpf(cpf);

        controllerPessoa.cadastrar(pessoa);
        


    };

    public void atualizar() {

        PessoaVO pessoa = new PessoaVO();
        ControllerPessoa controllerPessoa = new ControllerPessoa();
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite id: ");
        int id = Integer.parseInt(teclado.nextLine());

        System.out.print("Digite nome: ");
        String nome = teclado.nextLine();
        System.out.print("Digite sexo (M|F): ");
        char sexo = teclado.nextLine().charAt(0);
        System.out.print("Digite o cpf: ");
        String cpf = teclado.nextLine();
        System.out.print("Digite tipo (1|0): ");
        String tipo = teclado.nextLine();

        pessoa.setId(id);
        pessoa.setNome(nome);
        pessoa.setSexo(sexo);
        pessoa.setTipo(tipo);
        pessoa.setCpf(cpf);

        controllerPessoa.atualizar(pessoa);
        


    };

    public void buscar() {
        PessoaVO pessoa = new PessoaVO();
        Scanner teclado = new Scanner(System.in);
        ControllerPessoa controllerPessoa = new ControllerPessoa();

        System.out.print("Digite id: ");
        int id = teclado.nextInt();

        pessoa.setId(id);

        ArrayList<PessoaVO> listPessoas = controllerPessoa.buscar(pessoa);
        for (int i = 0; i < listPessoas.size(); i++) {
            System.out.println(" ID: " + listPessoas.get(i).getId() + " NOME: " + listPessoas.get(i).getNome()
                    + " SEXO: " + listPessoas.get(i).getSexo() + " CPF: " + listPessoas.get(i).getCpf() + " TIPO: "
                    + listPessoas.get(i).getTipo());

        }
        


    };

    public void deletar() {

        PessoaVO pessoa = new PessoaVO();
        ControllerPessoa controllerPessoa = new ControllerPessoa();

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite id: ");
        int id = teclado.nextInt();

        pessoa.setId(id);
        controllerPessoa.deletar(pessoa);
        

    };
}