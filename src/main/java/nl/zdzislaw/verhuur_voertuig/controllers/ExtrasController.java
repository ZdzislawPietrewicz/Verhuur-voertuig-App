package nl.zdzislaw.verhuur_voertuig.controllers;

import nl.zdzislaw.verhuur_voertuig.model.Assortment.Extras;
import nl.zdzislaw.verhuur_voertuig.service.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ExtrasController {
    @Autowired
    ExtraService extraService;

    @GetMapping("/admin/addExtras")
    public ModelAndView addExtras() {
        Extras extras = new Extras();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("extras", extras);
        modelAndView.setViewName("/admin/addExtras");
        return modelAndView;
    }

    @GetMapping("registerExtra")
    public String addExtras(Extras extras) {
        System.out.println(extras.toString());
        extraService.addExtras(extras);
        return "home";
    }
    @GetMapping("/showAllExtras")
    public ModelAndView showAllExtras(){
        List<Extras> allExtras=extraService.showAllExtras();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allExtras",allExtras);
        modelAndView.setViewName("/admin/allExtras");
        return modelAndView;
    }
}

