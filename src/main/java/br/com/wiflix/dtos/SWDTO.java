package br.com.wiflix.dtos;

import jakarta.validation.constraints.NotBlank;

public record SWDTO(@NotBlank String url) {
}
