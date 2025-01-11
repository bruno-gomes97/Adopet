package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotNull;

public record AprovacaoAdocaoDTO(@NotNull long idAdocao) {
}
