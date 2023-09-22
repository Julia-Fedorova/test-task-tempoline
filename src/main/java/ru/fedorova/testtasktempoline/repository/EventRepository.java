package ru.fedorova.tempolinetest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.fedorova.tempolinetest.model.Classifier;
import ru.fedorova.tempolinetest.model.Event;

public interface EventRepository  extends JpaRepository<Event, Long> {

    Page<Event> findByClassifierId(Classifier classifierId, Pageable requiredPage);
}
