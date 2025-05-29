package com.manga.volume.repo;


import com.manga.volume.entity.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MangaRepo extends JpaRepository<Manga,Long> {
}
