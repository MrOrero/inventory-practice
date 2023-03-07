package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GlobalSuperstore {

    List<Inventory> inventory = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        int index = geInventoryIndex(id);
        model.addAttribute("inventory", index == Constants.NOT_FOUND ? new Inventory() : inventory.get(index));
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("inventory", inventory);
        return "inventory";
    }

    @PostMapping("/inventory")
    public String submitInventory(Inventory RecievedInventory, RedirectAttributes redirAttrs) {
        String id = RecievedInventory.getId();
        if (RecievedInventory.getId() != null) {
            int index = geInventoryIndex(id);

            if (index == Constants.NOT_FOUND) {
                this.inventory.add(RecievedInventory);
            } else {
                this.inventory.set(index, RecievedInventory);
            }
        }
        redirAttrs.addFlashAttribute("message", "You have successfully added a new item to the inventory.");
        return "redirect:/inventory";
    }

    public Integer geInventoryIndex(String id) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getId().equals(id)) {
                return i;
            }
        }

        return Constants.NOT_FOUND;
    }
}
