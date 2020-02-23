package com.spring.jablog.repository;

import java.util.List;

import com.spring.jablog.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JablogRepository extends JpaRepository<Post, Long>{
    public List<Post> findByTitulo(String titulo);
}