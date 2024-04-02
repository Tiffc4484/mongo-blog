package com.example.mongoBlog.repository;

import com.example.mongoBlog.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class PostRepositoryImp implements PostsRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Posts createPost(Posts post) {
        mongoTemplate.save(post);

        return post;
    }
}
