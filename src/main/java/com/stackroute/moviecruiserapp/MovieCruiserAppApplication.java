package com.stackroute.moviecruiserapp;

import com.stackroute.moviecruiserapp.domain.Movie;
import com.stackroute.moviecruiserapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MovieCruiserAppApplication implements ApplicationListener<ContextRefreshedEvent>,CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieCruiserAppApplication.class, args);
	}
	@Autowired
	private MovieRepository movieRepository;


	@Override
	public void run(String... args) throws Exception {
		movieRepository.save(new Movie(3,"command","english","save"));
		movieRepository.save(new Movie(4,"title2","hindi","save"));
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		movieRepository.save(new Movie(1,"title","english","save"));
		movieRepository.save(new Movie(2,"title2","hindi","save"));

	}
}