package pl.nicolehoppy.eventmanager.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.nicolehoppy.eventmanager.model.Event;
import pl.nicolehoppy.eventmanager.service.EventService;

@Controller
@RequiredArgsConstructor
public class EventViewController {

    private final EventService eventService;

    @GetMapping("/events")
    public String listEvents(Model model){
        model.addAttribute("events", eventService.findAll());
        return "events/list";
    }

    @GetMapping("/events/new")
    public String showNewForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/new";
    }

    @PostMapping("/events")
    public String createEvent(@ModelAttribute Event event) {
        Event savedEvent = eventService.save(event);
        return "redirect:/events";
    }
}
