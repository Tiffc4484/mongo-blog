package com.example.mongoBlog.repository;

import com.example.mongoBlog.model.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SimpleMongoRepository extends MongoRepository<Posts, String> {
    public Optional<Posts> findById(String id);

    public Posts save(Posts posts);

}
