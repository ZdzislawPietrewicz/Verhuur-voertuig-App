package nl.zdzislaw.verhuur_voertuig.controllers;

import com.mysql.cj.Session;
import nl.zdzislaw.verhuur_voertuig.model.Assortment.Auto;
import nl.zdzislaw.verhuur_voertuig.model.Assortment.Bus;
import nl.zdzislaw.verhuur_voertuig.model.Assortment.Scooter;
import nl.zdzislaw.verhuur_voertuig.model.Assortment.Vehicle;
import nl.zdzislaw.verhuur_voertuig.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping("/admin/addVehicle")
    public ModelAndView addVehicle() {
        Vehicle auto = new Auto();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auto", auto);
        modelAndView.setViewName("admin/addAuto");
        System.out.println("add " + auto.toString());
        return modelAndView;
    }

    @GetMapping("/admin/addBus")
    public ModelAndView addBus(Model model) {
        Vehicle bus = new Bus();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bus", bus);
        modelAndView.setViewName("admin/addBus");
        return modelAndView;
    }

    @GetMapping("/admin/addScooter")
    public String addScooter(Model model) {
        Scooter scooter = new Scooter();
        model.addAttribute("scooter", scooter);
        return "admin/addScooter";
    }

      @GetMapping("/registerAuto")
      public String addAuto( @ModelAttribute @Valid Auto auto,
                               BindingResult bindResult) {
          if (bindResult.hasErrors()) {
              System.out.println(bindResult.toString());
              return "admin/addVehicle";
          } else {
              System.out.println("register auto" + auto.toString());
              vehicleService.addVehicle(auto);
              return "home";
          }
      }
    @GetMapping("/registerBus")
    public String addBus(  @Valid Bus bus,
                               BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            System.out.println(bindResult.toString());
            return "admin/addVehicle";
        } else {
            vehicleService.addVehicle(bus);
            return "home";
        }
    }
    @GetMapping("/registerScooter")
    public String addScooter(  @Valid Scooter scooter,
                           BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            System.out.println(bindResult.toString());
            return "admin/addVehicle";
        } else {
            vehicleService.addVehicle(scooter);
            return "home";
        }
    }


    @GetMapping("/showAllVehicles")
    public String showAllVehicles(Model model) {
        List<Vehicle> allVehicles = vehicleService.showAllVehicles();
        model.addAttribute("allVehicles", allVehicles);
        return "allVehicles";
    }
}



