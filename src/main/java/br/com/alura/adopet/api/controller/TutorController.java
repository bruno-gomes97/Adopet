package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.excpetion.ValidacaoExcpetion;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid Tutor tutor) {
        try {
            tutorService.cadastrar(tutor);
            return ResponseEntity.ok().build();
        } catch (ValidacaoExcpetion err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid Tutor tutor) {
        tutorService.atualizar(tutor);
        return ResponseEntity.ok().build();
    }
}
