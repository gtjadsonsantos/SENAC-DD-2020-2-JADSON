package br.com.jadson.models.bo.exercicio2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.jadson.models.vo.exercicio2.PessoaVO;
import br.com.jadson.models.dao.exercicio2.PessoaDAO;

public class PessoaBO {
    public boolean cadastrar(PessoaVO pessoa) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        boolean response = false;

        if (this.validaSexo(pessoa) && this.validarCpf(pessoa)) {
            if (pessoaDAO.criar(pessoa) == 1) {
                response = true;
            }

        } else {
            JOptionPane.showMessageDialog(null,"Dados invalidos, por favor preencha os campos novamente");

        }

        return response;

    }

    private boolean validarCpf(PessoaVO pessoa) {

        boolean retorno;

        if (pessoa.getCpf().length() == 11) {
            retorno = true;

        } else {

            retorno = false;
        }

        return retorno;
    }

    public void deletar(PessoaVO pessoa) {
        PessoaDAO pessoaDAO = new PessoaDAO();

        if (this.validaId(pessoa)) {
            pessoaDAO.deletar(pessoa);

        } else {
            System.out.println("Dados invalidos, por favor preencha os campos novamente");
        }

    }

    public void atualizar(PessoaVO pessoa) {
        PessoaDAO pessoaDAO = new PessoaDAO();

        if (this.validaSexo(pessoa) && this.validaTipo(pessoa) && this.validaId(pessoa)) {
            pessoaDAO.atualizar(pessoa);
        } else {
            System.out.println("Dados invalidos, por favor preencha os campos novamente");
        }

    }

    public ArrayList<PessoaVO> buscar(PessoaVO pessoa) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        ArrayList<PessoaVO> resultado = null;

        if (this.validaId(pessoa)) {
            resultado = pessoaDAO.buscar(pessoa);
        } else {
            System.out.println("Dados inválidos, por favor preencha os campos novamente");
        }

        return resultado;
    }

    private boolean validaSexo(PessoaVO pessoa) {
        boolean retorno;

        if (pessoa.getSexo() == 'M' || pessoa.getSexo() == 'F') {
            retorno = true;
        } else {
            retorno = false;
        }

        return retorno;
    }

    private boolean validaTipo(PessoaVO pessoa) {
        boolean retorno;

        if (pessoa.getTipo() == "pesquisador" || pessoa.getTipo() == "voluntario") {
            retorno = true;

        } else {

            retorno = false;
        }

        return retorno;
    }

    private boolean validaId(PessoaVO pessoa) {
        boolean retorno;

        if (pessoa.getId() >= 1) {
            retorno = true;
        } else {
            retorno = false;
        }

        return retorno;
    }

}