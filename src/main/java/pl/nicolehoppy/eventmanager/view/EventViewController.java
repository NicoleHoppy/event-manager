package pl.nicolehoppy.eventmanager.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.nicolehoppy.eventmanager.model.Event;
import pl.nicolehoppy.eventmanager.service.EventService;
import pl.nicolehoppy.eventmanager.service.LocationService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class EventViewController {

    private final EventService eventService;
    private final LocationService locationService;

    @GetMapping("/events")
    public String listEvents(Model model){
        model.addAttribute("events", eventService.findAll());
        return "events/list";
    }

    @GetMapping("/events/new")
    public String showNewForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("locations", locationService.findAll());
        return "events/new";
    }

    @GetMapping("/events/{id}")
    public String showEvent(@PathVariable Long id, Model model) {
        Optional<Event> optionalEvent = eventService.findById(id);

        if (optionalEvent.isEmpty()) return "redirect:/events";

        Event event = optionalEvent.get();
        model.addAttribute("event", event);
        return "events/show";
    }

    @PostMapping("/events")
    public String createEvent(@ModelAttribute Event event) {
        Event savedEvent = eventService.save(event);
        return "redirect:/events";
    }
}
