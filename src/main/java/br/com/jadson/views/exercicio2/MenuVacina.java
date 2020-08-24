package br.com.jadson.views.exercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import java.time.format.DateTimeFormatter;
import br.com.jadson.controllers.exercicio2.ControllerVacina;
import br.com.jadson.models.vo.exercicio2.VacinaVO;

public class MenuVacina {
    public static final int MENU_VACINA_CRIAR = 1;
    public static final int MENU_VACINA_DELETAR = 2;
    public static final int MENU_VACINA_ATUALIZAR = 3;
    public static final int MENU_VACINA_BUSCAR = 4;
    DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void exibirMenu() {
        int option = this.exibirOpcoes();

        switch (option) {
            case MENU_VACINA_CRIAR:
                this.criar();
                break;
            case MENU_VACINA_DELETAR:
                this.deletar();
                break;
            case MENU_VACINA_ATUALIZAR:
                this.atualizar();
                break;
            case MENU_VACINA_BUSCAR:
                this.buscar();
                break;
            default:
                System.out.println("Opção errada");
                this.exibirOpcoes();
                break;
        }

    }

    public void criar() {
        VacinaVO vacina = new VacinaVO();
        Scanner teclado = new Scanner(System.in);
        ControllerVacina controllerVacina = new ControllerVacina();

        System.out.print("Digite nome da vacina: ");
        String nomeVacina = teclado.nextLine();
        System.out.print("Digite nome do pesquisador: ");
        String nomePesquisador = teclado.nextLine();
        System.out.print("Digite nome do pais de origem: ");
        String paisOrigem = teclado.nextLine();
        System.out.print("Digite a data de inicio da pesquiosa(DD/MM/AAAA): ");
        LocalDate dtInicioPesquisa = LocalDate.parse(teclado.nextLine(), dataFormatter);

        vacina.setNomeVacina(nomeVacina);
        vacina.setNomePesquisador(nomePesquisador);
        vacina.setPaisOrigem(paisOrigem);
        vacina.setDtInicioPesquisa(dtInicioPesquisa);

        controllerVacina.cadastrar(vacina);
    };

    public void atualizar() {

        VacinaVO vacina = new VacinaVO();
        Scanner teclado = new Scanner(System.in);
        ControllerVacina controllerVacina = new ControllerVacina();

        System.out.print("Digite o id: ");
        int id = Integer.parseInt(teclado.nextLine());
        System.out.print("Digite nome da vacina: ");
        String nomeVacina = teclado.nextLine();
        System.out.print("Digite nome do pesquisador: ");
        String nomePesquisador = teclado.nextLine();
        System.out.print("Digite nome do pais de origem: ");
        String paisOrigem = teclado.nextLine();
        System.out.print("Digite a data de inicio da pesquiosa: ");
        LocalDate dtInicioPesquisa = LocalDate.parse(teclado.nextLine(), dataFormatter);

        vacina.setId(id);
        vacina.setNomeVacina(nomeVacina);
        vacina.setNomePesquisador(nomePesquisador);
        vacina.setPaisOrigem(paisOrigem);
        vacina.setDtInicioPesquisa(dtInicioPesquisa);

        controllerVacina.atualizar(vacina);

    };

    public void buscar() {

        VacinaVO vacina = new VacinaVO();
        Scanner teclado = new Scanner(System.in);
        ControllerVacina controllerVacina = new ControllerVacina();

        System.out.print("Digite o id: ");
        int id = teclado.nextInt();

        vacina.setId(id);

        ArrayList<VacinaVO> listaVacinaVO = controllerVacina.buscar(vacina);

        for (int i = 0; i < listaVacinaVO.size(); i++) {
            System.out.println("VACINAID: " + listaVacinaVO.get(i).getId() + " NOME_VACINDA: "
                    + listaVacinaVO.get(i).getNomeVacina() + " NOME_PESQUISADOR_RESP: "
                    + listaVacinaVO.get(i).getNomePesquisador() + " PAIS_ORIGEM: "
                    + listaVacinaVO.get(i).getPaisOrigem() + " EST_PESQUISA: " + listaVacinaVO.get(i).getEst_pesquisa()
                    + " DT_INICIO_PESQUISA: " + listaVacinaVO.get(i).getDtInicioPesquisa());
        }

    };

    public void deletar() {

        VacinaVO vacina = new VacinaVO();
        Scanner teclado = new Scanner(System.in);
        ControllerVacina controllerVacina = new ControllerVacina();

        System.out.print("Digite o id: ");
        int id = teclado.nextInt();

        vacina.setId(id);

        controllerVacina.deletar(vacina);
    };

    public int exibirOpcoes() {
        Scanner teclado = new Scanner(System.in);
        int option = 0;
        System.out.print("BEM VINDO\n\n");
        System.out.println("Options:");

        System.out.println(MENU_VACINA_CRIAR + " - CRIAR");
        System.out.println(MENU_VACINA_DELETAR + " - DELETAR");
        System.out.println(MENU_VACINA_ATUALIZAR + " - ATUALIZAR");
        System.out.println(MENU_VACINA_BUSCAR + " - BUSCAR");

        try {
            option = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("Digite somente números");
        }

        return option;
    }
}