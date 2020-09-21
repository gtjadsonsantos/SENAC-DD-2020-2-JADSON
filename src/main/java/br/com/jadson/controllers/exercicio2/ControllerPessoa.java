package br.com.jadson.controllers.exercicio2;

import java.util.ArrayList;

import br.com.jadson.models.vo.exercicio2.PessoaVO;
import br.com.jadson.models.bo.exercicio2.PessoaBO;

public class ControllerPessoa {
    public boolean cadastrar(PessoaVO pessoaVO) {
        PessoaBO pessoa = new PessoaBO();
        return pessoa.cadastrar(pessoaVO);
    }

    public void deletar(PessoaVO pessoaVO) {
        PessoaBO pessoa = new PessoaBO();
        pessoa.deletar(pessoaVO);
    }

    public void atualizar(PessoaVO pessoaVO) {
        PessoaBO pessoa = new PessoaBO();
        pessoa.atualizar(pessoaVO);
    }

    public ArrayList<PessoaVO> buscar(PessoaVO pessoaVO) {
        PessoaBO pessoa = new PessoaBO();

        return pessoa.buscar(pessoaVO);
    }
}