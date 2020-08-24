package br.com.jadson.models.vo.exercicio2;

import java.time.LocalDate;

public class VacinaVO {
    private int id;
    private String nomeVacina;
    private String nomePesquisador;
    private String paisOrigem;
    private String est_pesquisa;
    private LocalDate dtInicioPesquisa;

    public VacinaVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getNomePesquisador() {
        return nomePesquisador;
    }

    public void setNomePesquisador(String nomePesquisador) {
        this.nomePesquisador = nomePesquisador;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getEst_pesquisa() {
        return est_pesquisa;
    }

    public void setEst_pesquisa(String est_pesquisa) {
        this.est_pesquisa = est_pesquisa;
    }

    public LocalDate getDtInicioPesquisa() {
        return dtInicioPesquisa;
    }

    public void setDtInicioPesquisa(LocalDate dtInicioPesquisa) {
        this.dtInicioPesquisa = dtInicioPesquisa;
    };

}
