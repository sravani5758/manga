package com.manga.volume.repo;

import com.manga.volume.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BookRepo extends JpaRepository<Book,Long>{
}
