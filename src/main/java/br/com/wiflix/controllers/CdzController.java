package br.com.wiflix.controllers;

import br.com.wiflix.dtos.CdzDTO;
import br.com.wiflix.entity.Cdz;
import br.com.wiflix.service.CdzService;
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
@RequestMapping("/cdz")
@Tag(name = "cdz_episodios")
public class CdzController {


    private final CdzService cdzService;

    public CdzController(CdzService cdzService) {
        this.cdzService = cdzService;
    }

    @Operation(summary = "Buscar todos os episodios")
    @GetMapping
    public ResponseEntity<List<CdzDTO>> findAll(){
        var listar = cdzService.findAll();
        return ResponseEntity.ok(listar);
    }
    @Operation(summary = "publicar  episodio")
    @PostMapping
    public ResponseEntity<CdzDTO> post(@RequestBody @Valid CdzDTO cdzDTO){
       cdzService.post(cdzDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cdzDTO);
    }
    @Operation(summary = "Buscar episodio")
    @GetMapping("/{id}")
    public ResponseEntity<CdzDTO> getOne(@PathVariable Long id){
       return ResponseEntity.ok(cdzService.getOne(id));
    }
    @Operation(summary = "Atualiza episodio")
    @PutMapping("/{id}")
    public ResponseEntity<CdzDTO> update(@PathVariable Long id, @RequestBody @Valid CdzDTO cdzDTO){
        return ResponseEntity.ok(cdzService.update(id, cdzDTO));
    }
    @Operation(summary = "Deletar episodio")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        cdzService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
