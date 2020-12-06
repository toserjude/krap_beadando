package uni.eszterhazy.krap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uni.eszterhazy.krap.exceptions.AutoAlreadyAdded;
import uni.eszterhazy.krap.exceptions.AutoNotFound;
import uni.eszterhazy.krap.model.Auto;
import uni.eszterhazy.krap.model.Uzemanyag;
import uni.eszterhazy.krap.service.AutoService;

@Controller
public class AutoController {

    @Autowired
    @Qualifier("autoService")
    AutoService service;

    @GetMapping(value = "/autok")
    public String getAutok(Model model){
        model.addAttribute("autok", service.getAllAutos());
        return "autolist";
    }

    @GetMapping(value="/auto/{rendszam}")
    public String getAutoByRendszam(@PathVariable String rendszam, Model model) throws AutoNotFound {
        model.addAttribute("auto", service.getAutoByRendszam(rendszam));
        return "autodetails";
    }

    @GetMapping(value = "addAuto")
    public String addAutoForm(Model model) {
        model.addAttribute("uzemanyag", Uzemanyag.values());
        return "autoForm";
    }

    @ModelAttribute(value = "auto")
    public Auto create() {
        return new Auto();
    }

    @PostMapping(value = "addAuto")
    public String addAuto(@ModelAttribute("auto") Auto auto, Model model){
        System.out.println(auto);
        try {
            service.addAuto(auto);
        } catch (AutoAlreadyAdded autoAlreadyAdded) {
            autoAlreadyAdded.printStackTrace();
        }
        return "redirect:auto/" + auto.getRendszam();
    }

    @GetMapping(value = "updateAuto/{rendszam}")
    public String updateAutoForm(@PathVariable String rendszam, Model model) throws AutoNotFound {
        model.addAttribute("auto", service.getAutoByRendszam(rendszam));
        model.addAttribute("uzemanyag", Uzemanyag.values());
        return "autoUpdateForm";
    }

    @PostMapping(value = "updateAuto/{rendszam}")
    public String updateAuto(@ModelAttribute("auto") Auto auto, Model model){
        try {
            service.updateAuto(auto);
        } catch (AutoNotFound autoNotFound) {
            autoNotFound.printStackTrace();
        }
        return "redirect:/auto/" + auto.getRendszam();
    }

    @GetMapping(value = "deleteAuto/{rendszam}")
    public String deleteAutoForm(@PathVariable String rendszam, Model model) throws AutoNotFound {
        model.addAttribute("auto", service.getAutoByRendszam(rendszam));
        return "deleteAutoForm";
    }

    @PostMapping(value = "deleteAuto/{rendszam}")
    public String deleteAuto(@PathVariable String rendszam, Model model) throws AutoNotFound {
        System.out.println("Törölt autó: " + rendszam);
        service.removeAuto(rendszam);
        return "redirect:/autok/";
    }
}
