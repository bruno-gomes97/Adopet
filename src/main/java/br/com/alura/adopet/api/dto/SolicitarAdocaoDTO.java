package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SolicitarAdocaoDTO(@NotNull long idPet, @NotNull long idTutor, @NotBlank String motivo) {
}
