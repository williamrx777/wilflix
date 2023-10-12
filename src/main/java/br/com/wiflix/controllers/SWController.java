package br.com.wiflix.controllers;

import br.com.wiflix.dtos.SWDTO;
import br.com.wiflix.service.SWService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SW")
@Tag(name = "sw_episodios")
public class SWController {

    private final SWService swService;

    public SWController(SWService swService) {
        this.swService = swService;
    }
    @Operation(summary = "Buscar todos os episodios")
    @GetMapping
    public ResponseEntity<List<SWDTO>> findAll(){
        return ResponseEntity.ok(swService.findAll());
    }
    @Operation(summary = "publicar  episodio")
    @PostMapping
    public ResponseEntity<SWDTO> post(@RequestBody @Valid SWDTO swdto){
        swService.post(swdto);
        return ResponseEntity.status(HttpStatus.CREATED).body(swdto);
    }
    @Operation(summary = "Buscar episodio")
    @GetMapping("/{id}")
    public ResponseEntity<SWDTO> getOne(@PathVariable Long id){
        return ResponseEntity.ok(swService.getOne(id));
    }
    @Operation(summary = "Atualiza episodio")
    @PutMapping("/{id}")
    public ResponseEntity<SWDTO> update(@PathVariable Long id, @RequestBody @Valid SWDTO swdto){
        return ResponseEntity.ok(swService.atualizar(id, swdto));
    }
    @Operation(summary = "Deletar episodio")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        swService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
