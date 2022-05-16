package com.example.mongotest.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("event")
public class Event {

    @Id
    private String id;

    private String title;

    private String image;
}
