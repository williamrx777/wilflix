package br.com.wiflix.controllers;

import br.com.wiflix.dtos.YuyuhakushoDTO;
import br.com.wiflix.service.YuyuhakushoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/yuyuhakusho")
@Tag(name = "yuyuhakusho_episodios")
public class YuyuhakushoController {

    private final YuyuhakushoService yuyuhakushoService;

    public YuyuhakushoController(YuyuhakushoService yuyuhakushoService) {
        this.yuyuhakushoService = yuyuhakushoService;
    }
    @Operation(summary = "Buscar todos os episodios")
    @GetMapping
    public ResponseEntity<List<YuyuhakushoDTO>> findAll(){
        return ResponseEntity.ok(yuyuhakushoService.findAll());
    }
    @Operation(summary = "publicar  episodio")
    @PostMapping
    public ResponseEntity<YuyuhakushoDTO> post(@RequestBody YuyuhakushoDTO yuyuhakushoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(yuyuhakushoService.post(yuyuhakushoDTO));
    }
    @Operation(summary = "Buscar episodio")
    @GetMapping("/{id}")
    public ResponseEntity<YuyuhakushoDTO> getOne(@PathVariable Long id){
        return ResponseEntity.ok(yuyuhakushoService.getOne(id));
    }
    @Operation(summary = "Atualiza episodio")
    @PutMapping("/{id}")
    public ResponseEntity<YuyuhakushoDTO> update(@PathVariable Long id, @RequestBody YuyuhakushoDTO yuyuhakushoDTO){
        return ResponseEntity.ok(yuyuhakushoService.update(id, yuyuhakushoDTO));
    }
    @Operation(summary = "Deletar episodio")
    @DeleteMapping("/{id}")
    public ResponseEntity<YuyuhakushoDTO> delete(@PathVariable Long id){
        yuyuhakushoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
