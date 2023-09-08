package br.com.wiflix.controllers;

import br.com.wiflix.dtos.CdzDTO;
import br.com.wiflix.entities.Cdz;
import br.com.wiflix.repositories.CdzRepository;
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
@RequestMapping("/cdz")
@Tag(name = "cdz_episodios")
public class CdzController {

    @Autowired
    private CdzRepository repository;
    @Operation(summary = "Buscar todos os episodios")
    @GetMapping
    public ResponseEntity findAll(){
        var listar = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listar);
    }
    @Operation(summary = "publicar  episodio")
    @PostMapping
    public ResponseEntity post(@RequestBody @Valid CdzDTO cdzDTO){
        var postar = new Cdz();
        BeanUtils.copyProperties(cdzDTO, postar);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postar));
    }
    @Operation(summary = "Buscar episodio")
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Cdz> getOne = repository.findById(id);
        if (getOne.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Episodio não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(getOne);
        }
    }
    @Operation(summary = "Atualiza episodio")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid CdzDTO cdzDTO){
        Optional<Cdz> update = repository.findById(id);
        if (update.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Episodio não encontrado");
        }else{
            var episodio = update.get();
            BeanUtils.copyProperties(cdzDTO, episodio);
            return ResponseEntity.status(HttpStatus.OK).body(repository.save(episodio));
        }
    }
    @Operation(summary = "Deletar episodio")
    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Long id){
        Optional<Cdz> delete = repository.findById(id);
        if (delete.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Episodio não encontrado");
        }else {
            repository.delete(delete.get());
            return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
        }
    }
}
