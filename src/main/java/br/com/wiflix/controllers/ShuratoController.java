package br.com.wiflix.controllers;

import br.com.wiflix.dtos.ShuratoDTO;
import br.com.wiflix.service.ShuratoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/shurato")
@Tag(name = "shurato_episodios")
public class ShuratoController {

    private final ShuratoService shuratoService;


    public ShuratoController(ShuratoService shuratoService) {
        this.shuratoService = shuratoService;
    }
    @Operation(summary = "Buscar todos os episodios")
    @GetMapping
    public ResponseEntity<List<ShuratoDTO>> findAll(){
        return ResponseEntity.ok(shuratoService.findAll());
    }
    @Operation(summary = "publicar  episodio")
    @PostMapping
    public ResponseEntity<ShuratoDTO> post(@RequestBody ShuratoDTO shuratoDTO){
        shuratoService.post(shuratoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(shuratoDTO);
    }
    @Operation(summary = "Buscar episodio")
    @GetMapping("/{id}")
    public ResponseEntity<ShuratoDTO> getOne(@PathVariable Long id){
        return ResponseEntity.ok(shuratoService.getOne(id));
    }
    @Operation(summary = "Atualiza episodio")
    @PutMapping("/{id}")
    public ResponseEntity<ShuratoDTO> update(@PathVariable Long id, @RequestBody ShuratoDTO shuratoDTO){
        return ResponseEntity.ok(shuratoService.update(id, shuratoDTO));
    }
    @Operation(summary = "Deletar episodio")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        shuratoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
