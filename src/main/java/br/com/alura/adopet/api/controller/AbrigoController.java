package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.excpetion.ValidacaoExcpetion;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.service.AbrigoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @GetMapping
    public ResponseEntity<List<Abrigo>> listar() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid Abrigo abrigo) {
        try {
            abrigoService.cadastrar(abrigo);
            return ResponseEntity.ok("Adoção solicitada com sucesso!");
        } catch (ValidacaoExcpetion err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }

    @GetMapping("/{idOuNome}/pets")
    public ResponseEntity<List<Pet>> listarPets(@PathVariable String idOuNome) {

    }

//    @PostMapping("/{idOuNome}/pets")
//    @Transactional
//    public ResponseEntity<String> cadastrarPet(@PathVariable String idOuNome, @RequestBody @Valid Pet pet) {
//
//
//    }

}
