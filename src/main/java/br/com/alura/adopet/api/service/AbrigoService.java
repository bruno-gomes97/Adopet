package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.excpetion.ValidacaoExcpetion;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    public void listar() {
        repository.findAll();
    }

    public void cadastrar(Abrigo abrigo) {
        boolean nomeJaCadastrado = repository.existsByNome(abrigo.getNome());
        boolean telefoneJaCadastrado = repository.existsByTelefone(abrigo.getTelefone());
        boolean emailJaCadastrado = repository.existsByEmail(abrigo.getEmail());

        if (nomeJaCadastrado || telefoneJaCadastrado || emailJaCadastrado) {
            throw new ValidacaoExcpetion("Dados já cadastrados para outro abrigo!");
        } else {
            repository.save(abrigo);
        }
    }

//    public void listarPets(String idOuNome) {
//        try {
//            Long id = Long.parseLong(idOuNome);
//            List<Pet> pets = repository.getReferenceById(id).getPets();
//            return pets;
//        } catch (EntityNotFoundException enfe) {
//            return ResponseEntity.notFound().build();
//        } catch (NumberFormatException e) {
//            try {
//                List<Pet> pets = repository.findByNome(idOuNome).getPets();
//                return ResponseEntity.ok(pets);
//            } catch (EntityNotFoundException enfe) {
//                return ResponseEntity.notFound().build();
//            }
//        }
//    }

//    public void cadastrarPet(String idOuNome) {
//        try {
//            Long id = Long.parseLong(idOuNome);
//            Abrigo abrigo = repository.getReferenceById(id);
//            pet.setAbrigo(abrigo);
//            pet.setAdotado(false);
//            abrigo.getPets().add(pet);
//            repository.save(abrigo);
//            return ResponseEntity.ok().build();
//        } catch (EntityNotFoundException enfe) {
//            return ResponseEntity.notFound().build();
//        } catch (NumberFormatException nfe) {
//            try {
//                Abrigo abrigo = repository.findByNome(idOuNome);
//                pet.setAbrigo(abrigo);
//                pet.setAdotado(false);
//                abrigo.getPets().add(pet);
//                repository.save(abrigo);
//                return ResponseEntity.ok().build();
//            } catch (EntityNotFoundException enfe) {
//                return ResponseEntity.notFound().build();
//            }
//        }
//    }

}
