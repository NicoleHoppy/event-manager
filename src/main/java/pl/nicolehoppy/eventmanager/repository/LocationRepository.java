package pl.nicolehoppy.eventmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nicolehoppy.eventmanager.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {}
