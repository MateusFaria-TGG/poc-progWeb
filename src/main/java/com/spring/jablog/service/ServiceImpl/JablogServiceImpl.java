package com.spring.jablog.service.ServiceImpl;

import java.util.List;

import com.spring.jablog.model.Post;
import com.spring.jablog.repository.JablogRepository;
import com.spring.jablog.service.JablogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JablogServiceImpl implements JablogService {

    @Autowired
    JablogRepository jablogRepository;

    @Override
    public List<Post> findAll() {
        return jablogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return jablogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return jablogRepository.save(post);
    }

    @Override
    public List<Post> findByTitulo(String titulo) {
        return jablogRepository.findByTitulo(titulo);
    }
    /***
     * Méthod to delete a post
     * @param post Instancied post
     */
    public void delete(Post post) {
    	jablogRepository.delete(post);
    }
    
    
}