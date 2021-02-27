package br.com.cwi.reset.exemploreset;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nome")
public class NomeController {

    private static String nome = "Lucas Bavaresco";

    @GetMapping
    public String getNome() {
        return nome;
    }

    @PutMapping("/{novoNome}")
    public String putNome(@PathVariable String novoNome) {
        this.nome = novoNome;
        return nome;
    }

    @DeleteMapping
    public void deletarNome() {
        this.nome = null;
    }

}
