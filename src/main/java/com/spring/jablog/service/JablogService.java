package com.spring.jablog.service;

import com.spring.jablog.model.Post;
import java.util.List;

public interface JablogService {

    public List<Post> findAll();
    public Post findById(long id);
    public Post save(Post post);
    public List<Post> findByTitulo(String titulo);
    public void delete(Post post);
}