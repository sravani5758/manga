package com.manga.volume.controller;


import com.manga.volume.entity.Manga;
import com.manga.volume.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manga")
public class MangaController {
    @Autowired
    private MangaService mangaService;

    @PostMapping
    public Manga createManga(@RequestBody Manga manga){
        return mangaService.createManga(manga);
    }
    @GetMapping("/{id}")
    public Manga getManga(@PathVariable Long id){
        return mangaService.getById(id);
    }
    @GetMapping
    public List<Manga> getAllManga(){
        return mangaService.getAllManga();
    }
    @PutMapping("/{id}")
    public Manga updateManga(@PathVariable Long id , @RequestBody Manga manga){
        return mangaService.updateManga(id,manga);
    }
    @DeleteMapping("/{id}")
    public String deleteManga(@PathVariable Long id) {
        return mangaService.deleteManga(id);
    }
}
