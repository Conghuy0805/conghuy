package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showList(Model model) {
        List<Product> list = iProductService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        Product product = new Product();
        model.addAttribute("productCreate", product);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("productCreate") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        List<Product> list = iProductService.findAll();
        product.setId(list.size() + 1);
        iProductService.create(product);
        redirectAttributes.addFlashAttribute("success", "Create product success");
        redirectAttributes.addFlashAttribute("showSweetAlert", true);
        return "redirect:/product";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("productUpdate", product);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("productUpdate") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        iProductService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "Update product success");
        redirectAttributes.addFlashAttribute("showSweetAlert", true);
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        iProductService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Delete product success");
        redirectAttributes.addFlashAttribute("showSweetAlert", true);
        return "redirect:/product";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("productView", product);
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam("nameSearch") String nameSearch, Model model) {
        List<Product> list = iProductService.searchByName(nameSearch);
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("list", list);
        return "list";
    }
}
