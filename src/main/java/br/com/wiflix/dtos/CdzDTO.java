package br.com.wiflix.dtos;

import jakarta.validation.constraints.NotBlank;

public record CdzDTO(@NotBlank String url) {



}
