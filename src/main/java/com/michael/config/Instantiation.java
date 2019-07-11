package com.michael.config;

import com.michael.domain.Post;
import com.michael.domain.User;
import com.michael.dto.AuthDTO;
import com.michael.repository.PostRepository;
import com.michael.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Beown", "maria@gmail.com");
        User alex = new User(null, "Alex Beown", "alex@gmail.com");
        User bob = new User(null, "Bob Beown", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex, bob));


        Post post = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços.", new AuthDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz.", new AuthDTO(maria));

        postRepository.saveAll(Arrays.asList(post, post2));

        maria.getPost().addAll(Arrays.asList(post,post2));
        userRepository.save(maria);

    }
}
