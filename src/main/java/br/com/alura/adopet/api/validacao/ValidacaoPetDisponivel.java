package br.com.alura.adopet.api.validacao;

import br.com.alura.adopet.api.dto.SolicitarAdocaoDTO;
import br.com.alura.adopet.api.excpetion.ValidacaoExcpetion;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private PetRepository petRepository;

    public void validar(SolicitarAdocaoDTO dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());

        if (pet.getAdotado() == true) {
            throw new ValidacaoExcpetion("Pet já foi adotado!");
        }
    }
}
