package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.excpetion.ValidacaoExcpetion;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class TutorService {

    @Autowired
    private TutorRepository repository;

    public void cadastrar(Tutor tutor) {
        boolean telefoneJaCadastrado = repository.existsByTelefone(tutor.getTelefone());
        boolean emailJaCadastrado = repository.existsByEmail(tutor.getEmail());

        if (telefoneJaCadastrado || emailJaCadastrado) {
            throw new ValidacaoExcpetion("Dados já cadastrados para outro tutor!");
        } else {
            repository.save(tutor);
        }
    }

    public void atualizar(Tutor tutor) {
        repository.save(tutor);
    }
}
