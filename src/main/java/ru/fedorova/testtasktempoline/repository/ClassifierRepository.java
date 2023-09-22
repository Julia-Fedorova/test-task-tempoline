package ru.fedorova.tempolinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fedorova.tempolinetest.model.Classifier;

public interface ClassifierRepository extends JpaRepository<Classifier,Long> {
}
