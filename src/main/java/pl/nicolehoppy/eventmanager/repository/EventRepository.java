package pl.nicolehoppy.eventmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nicolehoppy.eventmanager.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {}
