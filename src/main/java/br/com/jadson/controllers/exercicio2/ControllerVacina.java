package br.com.jadson.controllers.exercicio2;

import br.com.jadson.models.vo.exercicio2.VacinaVO;

import java.util.ArrayList;

import br.com.jadson.models.bo.exercicio2.VacinaBO;

public class ControllerVacina {
    public int cadastrar(VacinaVO vacinaVO) {
        VacinaBO vacinaBO = new VacinaBO();

       return  vacinaBO.cadastrar(vacinaVO);
    }

    public void deletar(VacinaVO vacinaVO) {
        VacinaBO vacinaBO = new VacinaBO();

        vacinaBO.deletar(vacinaVO);
    }

    public void atualizar(VacinaVO vacinaVO) {
        VacinaBO vacinaBO = new VacinaBO();

        vacinaBO.atualizar(vacinaVO);
    }

    public ArrayList<VacinaVO> buscar() {
        VacinaBO vacinaBO = new VacinaBO();

        return vacinaBO.buscar();
        
    }
}