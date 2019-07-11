package com.michael.service;

import com.michael.domain.Post;
import com.michael.repository.PostRepository;
import com.michael.service.exception.ObjectNotFoundExcept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExcept("Objeto não encontrado"));
    }

}
