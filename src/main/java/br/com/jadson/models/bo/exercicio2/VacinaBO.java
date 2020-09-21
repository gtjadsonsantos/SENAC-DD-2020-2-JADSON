package br.com.jadson.models.bo.exercicio2;

import java.util.ArrayList;

import br.com.jadson.models.dao.exercicio2.VacinaDAO;
import br.com.jadson.models.vo.exercicio2.VacinaVO;

public class VacinaBO {
    public int cadastrar(VacinaVO VacinaVO) {
        VacinaDAO vacinaDAO = new VacinaDAO();

        return vacinaDAO.criar(VacinaVO);

    }

	public void atualizar(VacinaVO vacinaVO) {
        VacinaDAO vacinaDAO = new VacinaDAO();

        vacinaDAO.atualizar(vacinaVO);
	}

	public void deletar(VacinaVO vacinaVO) {
        VacinaDAO vacinaDAO = new VacinaDAO();

        vacinaDAO.deletar(vacinaVO);
	}

	public ArrayList<VacinaVO> buscar() {
        VacinaDAO vacinaDAO = new VacinaDAO();

		return vacinaDAO.buscar();
	}
}
