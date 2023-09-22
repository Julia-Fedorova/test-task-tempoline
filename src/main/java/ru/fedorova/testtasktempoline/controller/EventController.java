package ru.fedorova.tempolinetest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fedorova.tempolinetest.model.Classifier;
import ru.fedorova.tempolinetest.model.Event;
import ru.fedorova.tempolinetest.service.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EventController {
    private final EventService eventService;

    @PostMapping("/event")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {

        if (event.getId() != null && event.getId() != 0) {
            return new ResponseEntity("Id не должно быть при добавлении события", HttpStatus.NOT_ACCEPTABLE);
        }
        if (event.getClassifierId() == null){
            return new ResponseEntity("Id классификатора не должно быть пустым", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(eventService.add(event));
    }

    @GetMapping("/event")
    public ResponseEntity<List<Event>> getEvents(@RequestParam(required = false) Classifier classifier,
                                 @RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "10") int size) {

        return ResponseEntity.ok(eventService.getEvents(classifier, page, size));
    }
}
