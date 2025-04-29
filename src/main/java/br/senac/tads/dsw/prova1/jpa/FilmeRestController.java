package br.senac.tads.dsw.prova1.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/filmes")
public class FilmeRestController {
    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<FilmeDto> findAll() {
        return filmeService.findAll();
    }
// *** QUESTÃO 5-III ****
    @GetMapping("/{idFilme}")
    public FilmeDto findById(@PathVariable("ïdFilme") Integer id) {
        Optional<FilmeDto> optFilme = filmeService.findById(id);
        if(!optFilme.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optFilme.get();
    }
}
