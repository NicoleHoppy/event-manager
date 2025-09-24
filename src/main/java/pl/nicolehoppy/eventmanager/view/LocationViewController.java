package pl.nicolehoppy.eventmanager.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.nicolehoppy.eventmanager.model.Location;
import pl.nicolehoppy.eventmanager.service.LocationService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LocationViewController {

    private final LocationService locationService;

    @GetMapping("/locations")
    public String listLocations(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "locations/list";
    }

    @GetMapping("/locations/new")
    public String showNewLocationForm(Model model) {
        model.addAttribute("location", new Location());
        return "locations/new";
    }

    @PostMapping("/locations")
    public String createLocation(@ModelAttribute Location location) {
        Location savedLocation = locationService.save(location);
        return "redirect:/locations";
    }

    @GetMapping("/locations/{id}")
    public String showLocation(@PathVariable Long id, Model model) {
        Optional<Location> optionalLocation = locationService.findById(id);

        if (optionalLocation.isEmpty()) return "redirect:/locations";

        Location location = optionalLocation.get();
        model.addAttribute("location", location);
        return "locations/show";
    }

    @GetMapping("/locations/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Location> optionalLocation = locationService.findById(id);

        if (optionalLocation.isEmpty()) return "redirect:/locations";

        model.addAttribute("location", optionalLocation.get());
        return "locations/edit";
    }

    @PostMapping("/locations/{id}")
    public String updateLocation(@PathVariable Long id, @ModelAttribute Location location) {
        location.setId(id);
        locationService.save(location);
        return "redirect:/locations";
    }

    @PostMapping("/locations/{id}/delete")
    public String deleteLocation(@PathVariable Long id) {
        locationService.deleteById(id);
        return "redirect:/locations";
    }

}
