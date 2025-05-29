package com.manga.volume.service;

import com.manga.volume.entity.Manga;
import com.manga.volume.repo.MangaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MangaService {
    @Autowired
    private MangaRepo mangaRepo;

    public Manga createManga(Manga manga) {
        return mangaRepo.save(manga);
    }

    public List<Manga> getAllManga() {
        return mangaRepo.findAll();
    }

    public Manga getById(Long id) {
        return mangaRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Manga not found with ID: " + id));
    }

    public Manga updateManga(Long id, Manga manga) {
        return mangaRepo.findById(id)
                .map(existingManga -> {
                    existingManga.setName(manga.getName());
                    existingManga.setChapters(manga.getChapters());
                    return mangaRepo.save(existingManga);
                })
                .orElseThrow(() -> new NoSuchElementException("Manga not found with ID: " + id));
    }

    public String deleteManga(Long id) {
        Manga manga = mangaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Manga not found with ID:" + id));
        mangaRepo.delete(manga);
        return "Manga with ID " + id + " is deleted";
    }
}