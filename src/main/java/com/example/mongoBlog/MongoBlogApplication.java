package com.example.mongoBlog;

import com.example.mongoBlog.model.Posts;
import com.example.mongoBlog.repository.PostRepositoryImp;
import com.example.mongoBlog.repository.PostsRepository;
import com.example.mongoBlog.repository.SimpleMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoBlogApplication implements CommandLineRunner {

	@Autowired
	PostsRepository postsRepository;

	@Autowired
	SimpleMongoRepository simpleMongoRepository;
	public static void main(String[] args) {
		SpringApplication.run(MongoBlogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		simpleMongoRepository.deleteAll();

		System.out.println("-------------CREATE A POST-------------------------------\n");
		createGroceryItems();

	}

	//CREATE
	void createGroceryItems() {
		System.out.println("Data creation started...");
//		simpleMongoRepository.save(new Posts("1", "title 1","content1"));
//		simpleMongoRepository.save(new Posts("2", "title 2", "content2"));

		postsRepository.createPost(new Posts("1", "title 1","content1"));
		postsRepository.createPost(new Posts("2", "title 2", "content2"));

		System.out.println("Data creation complete...");
	}
}
