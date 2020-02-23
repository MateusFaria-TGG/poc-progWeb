package com.spring.jablog.controller;

import com.spring.jablog.service.JablogService;
import com.spring.jablog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

@Controller
public class JablogController {

    @Autowired
    JablogService jService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mView = new ModelAndView("posts");
        List<Post> posts = jService.findAll();
        System.out.println(posts);
        mView.addObject("posts", posts);
        return mView;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView mView = new ModelAndView("postDetails");
        Post post = jService.findById(id);
        mView.addObject("post", post);
        return mView;
    }

    
    @Transactional
    @RequestMapping(value = "/posts/search", method = RequestMethod.GET)
    public ModelAndView searchPost(@RequestParam String titulo) {
        ModelAndView mView = new ModelAndView("search");
        List<Post> posts = jService.findByTitulo(titulo);
        mView.addObject("posts", posts);
        return mView;
    }    

    @RequestMapping(value = "/posts/new", method = RequestMethod.GET)
    public String getPostForm() {
        return "postForm";
    }

    @RequestMapping(value = "/posts/new", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "redirect:/posts/new";
        }
        post.setData(LocalDate.now());
        jService.save(post);
        
        return "redirect:/posts";
    }
}