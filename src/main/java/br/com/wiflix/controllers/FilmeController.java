package br.com.wiflix.controllers;

import br.com.wiflix.dtos.FilmeDTO;
import br.com.wiflix.entities.Filme;
import br.com.wiflix.repositories.FilmeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private FilmeRepository filmeRepository;

    @Operation(summary = "Buscar todos os filmes")
    @GetMapping
    public ResponseEntity findAll(){
        var filme = filmeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(filme);
    }
    @Operation(summary = "Publicar filme")
    @PostMapping
    public ResponseEntity post(@RequestBody @Valid FilmeDTO filmeDTO){
        var filme = new Filme();
        BeanUtils.copyProperties(filmeDTO,filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeRepository.save(filme));
    }
    @Operation(summary = "Buscar filme")
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable String id){
        Optional<Filme> filme = filmeRepository.findById(id);
        if (filme.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(filme);
        }
    }
    @Operation(summary = "Atualizar filme")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody @Valid FilmeDTO filmeDTO){
        Optional<Filme> filme0 = filmeRepository.findById(id);
        if (filme0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado");
        }else{
            var filme = filme0.get();
            BeanUtils.copyProperties(filmeDTO, filme);
            return ResponseEntity.status(HttpStatus.OK).body(filmeRepository.save(filme));
        }
    }
    @Operation(summary = "Deletar filme")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        Optional<Filme> filme = filmeRepository.findById(id);
        if (filme.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("filme não encontrado");
        }else{
            filmeRepository.delete(filme.get());
            return ResponseEntity.status(HttpStatus.OK).body("deletado com sucesso");
        }
    }

}
