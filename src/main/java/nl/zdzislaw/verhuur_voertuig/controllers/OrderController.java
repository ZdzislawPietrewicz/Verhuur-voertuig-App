package nl.zdzislaw.verhuur_voertuig.controllers;

import nl.zdzislaw.verhuur_voertuig.model.Orders.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @GetMapping("/composeOrder")
    public String composeOrder(Model model){
        Order order = new Order();
        model.addAttribute("order",order);
        return "/composeOrder";
    }
}
