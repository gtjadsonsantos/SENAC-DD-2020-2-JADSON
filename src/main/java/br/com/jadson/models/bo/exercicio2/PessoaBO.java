package br.com.jadson.models.bo.exercicio2;

import java.util.ArrayList;

import br.com.jadson.models.vo.exercicio2.PessoaVO;
import br.com.jadson.models.dao.exercicio2.PessoaDAO;

public class PessoaBO {
    public void cadastrar(PessoaVO pessoa) {
        PessoaDAO pessoaDAO = new PessoaDAO();

        if (this.validaSexo(pessoa) && this.validaTipo(pessoa)) {
            pessoaDAO.criar(pessoa);

        } else {
            System.out.println("Dados invalidos, por favor preencha os campos novamente");
        }

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

        if (pessoa.getTipo() == '1' || pessoa.getTipo() == '0') {
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