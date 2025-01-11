package br.com.alura.adopet.api.validacao;

import br.com.alura.adopet.api.dto.SolicitarAdocaoDTO;

public interface ValidacaoSolicitacaoAdocao {

    void validar(SolicitarAdocaoDTO dto);
}
