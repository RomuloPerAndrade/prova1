package br.senac.tads.dsw.prova1.jpa;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public class FilmeService {
    
    private Map<Integer, FilmeDto> filmes;

    
    public FilmeService() {
        filmes = new HashMap<>();
        filmes.put(1, new FilmeDto(1, "Matrix", "Ação", 1999));
        filmes.put(2, new FilmeDto (2, "Vingadores: Ultimato", "Ação", 2019));
    }

    public List<FilmeDto> findAll() {
        return new ArrayList<>(filmes.values());
    }

    public Optional<FilmeDto> findById(Integer id) {
        return Optional.ofNullable(filmes.get(id));
    }
}
