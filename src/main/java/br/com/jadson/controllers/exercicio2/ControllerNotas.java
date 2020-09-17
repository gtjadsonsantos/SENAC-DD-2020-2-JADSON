package br.com.jadson.controllers.exercicio2;

import java.util.ArrayList;

import br.com.jadson.models.vo.exercicio2.NotasVO;
import br.com.jadson.models.bo.exercicio2.NotasBO;

public class ControllerNotas {
    public void cadastrar(NotasVO notasVO) {
        NotasBO notasBO = new NotasBO();

        notasBO.cadastrar(notasVO);

    }

	public void atualizar(NotasVO notasVO) {
        NotasBO notasBO = new NotasBO();

        notasBO.atualizar(notasVO);

	}

	public void deletar(NotasVO notasVO) {
        NotasBO notasBO = new NotasBO();

        notasBO.deletar(notasVO);

	}

	public ArrayList<NotasVO> buscar() {
        NotasBO notasBO = new NotasBO();

		return notasBO.buscar();
	}
}
