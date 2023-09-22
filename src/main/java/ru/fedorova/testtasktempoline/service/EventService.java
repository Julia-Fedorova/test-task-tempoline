package ru.fedorova.tempolinetest.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.fedorova.tempolinetest.model.Classifier;
import ru.fedorova.tempolinetest.model.Event;
import ru.fedorova.tempolinetest.repository.EventRepository;

import java.util.List;


@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;

    public Event add(Event event) {
        return eventRepository.save(event);
    }

        public List<Event> getEvents(Classifier classifier, int page, int size) {
            Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());

            if (classifier != null) {
                return eventRepository.findByClassifierId(classifier, pageable).getContent();
            } else {
                return eventRepository.findAll(pageable).getContent();
            }

    }
}
