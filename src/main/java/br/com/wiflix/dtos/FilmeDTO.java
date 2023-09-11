package br.com.wiflix.dtos;

import br.com.wiflix.entities.Filme;
import jakarta.validation.constraints.NotBlank;

public record FilmeDTO(@NotBlank String nome,@NotBlank String url) {





}
