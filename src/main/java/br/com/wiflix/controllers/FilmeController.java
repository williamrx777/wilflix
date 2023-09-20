package br.com.wiflix.controllers;

import br.com.wiflix.dtos.FilmeDTO;
import br.com.wiflix.entity.Filme;
import br.com.wiflix.service.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/filmes")
@Tag(name = "filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @Operation(summary = "Buscar todos os filmes")
    @GetMapping
    public ResponseEntity<List<FilmeDTO>> findAll(){
        var filme = filmeService.findAll();
        return ResponseEntity.ok(filme);
    }
    @Operation(summary = "Publicar filme")
    @PostMapping
    public ResponseEntity<FilmeDTO> post(@RequestBody @Valid FilmeDTO filmeDTO){
        filmeService.post(filmeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeDTO);
    }
    @Operation(summary = "Buscar filme")
    @GetMapping("/{id}")
    public ResponseEntity<FilmeDTO> getOne(@PathVariable String id){
        return ResponseEntity.ok(filmeService.getOne(id));
    }
    @Operation(summary = "Atualizar filme")
    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTO> update(@PathVariable String id, @RequestBody @Valid FilmeDTO filmeDTO){
       return ResponseEntity.ok(filmeService.update(id, filmeDTO));
    }
    @Operation(summary = "Deletar filme")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        filmeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
