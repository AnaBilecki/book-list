package com.ana.book_list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ana.book_list.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
