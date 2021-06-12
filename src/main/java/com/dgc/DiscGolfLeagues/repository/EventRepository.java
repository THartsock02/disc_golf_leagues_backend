package com.dgc.DiscGolfLeagues.repository;

import com.dgc.DiscGolfLeagues.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByPublished(boolean published);
    List<Event> findByTitleContaining(String title);
}
