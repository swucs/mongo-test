package com.example.mongotest.service;

import com.example.mongotest.data.Event;
import com.example.mongotest.data.EventRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRespository eventRespository;

    public Event getEvent(String _id) {
        return eventRespository.findById(_id).orElseThrow(() -> new RestClientException(HttpStatus.NOT_FOUND + " : Not found Event"));
    }

    public List<Event> getEventList(String title) {
        return eventRespository.findByTitle(title);
    }

    public Event insertEvent(Event event) {
        return eventRespository.insert(event);
    }

    public void insert100Events(Event event) {
        for (int i = 0; i < 100; i++) {
            Event eventNew = new Event();
            event.setId("id_"+ i);
            event.setImage("Image_" + i);
            event.setTitle("Title_" + i);
            eventRespository.insert(event);
        }
    }
}
