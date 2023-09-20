package br.com.wiflix.dtos;

import jakarta.validation.constraints.NotBlank;

public record FilmeDTO(String id,@NotBlank String nome,@NotBlank String url) {





}
