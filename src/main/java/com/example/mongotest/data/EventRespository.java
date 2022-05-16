package com.example.mongotest.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRespository extends MongoRepository<Event, String> {
    List<Event> findByTitle(String title);
}
