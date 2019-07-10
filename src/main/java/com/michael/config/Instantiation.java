package com.michael.config;

import com.michael.domain.User;
import com.michael.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Beown", "maria@gmail.com");
        User alex = new User(null, "Alex Beown", "alex@gmail.com");
        User bob = new User(null, "Bob Beown", "bob@gmail.com");


        userRepository.saveAll(Arrays.asList(maria,alex, bob));

    }
}
