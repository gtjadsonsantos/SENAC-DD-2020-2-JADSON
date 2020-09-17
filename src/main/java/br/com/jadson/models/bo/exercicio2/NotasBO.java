package br.com.jadson.models.bo.exercicio2;

import java.util.ArrayList;

import br.com.jadson.models.vo.exercicio2.NotasVO;
import br.com.jadson.models.dao.exercicio2.NotasDAO;


public class NotasBO {
    public void cadastrar(NotasVO notasVO) {
        NotasDAO notasDAO = new NotasDAO();

        notasDAO.criar(notasVO);

    }

	public void atualizar(NotasVO notasVO) {
        NotasDAO notasDAO = new NotasDAO();

        notasDAO.atualizar(notasVO);

	}

	public void deletar(NotasVO notasVO) {
        NotasDAO notasDAO = new NotasDAO();

        notasDAO.deletar(notasVO);

	}

	public ArrayList<NotasVO> buscar() {
        NotasDAO notasDAO = new NotasDAO();

		return notasDAO.buscar();
	}
}
