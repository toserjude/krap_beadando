package uni.eszterhazy.krap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uni.eszterhazy.krap.exceptions.AutoAlreadyAdded;
import uni.eszterhazy.krap.exceptions.AutoNotFound;
import uni.eszterhazy.krap.model.Auto;
import uni.eszterhazy.krap.model.Uzemanyag;
import uni.eszterhazy.krap.service.AutoService;

import java.util.Collection;


@RestController
@RequestMapping(value = "/rest/")
public class RestAutoController {

    @Autowired
    AutoService autoService;

    @GetMapping(value = "auto/{rendszam:[A-Za-z]{3}-[0-9]{3}}")
    public Auto getAutoByRendszam(@PathVariable(name = "rendszam") String rendszam) throws AutoNotFound {
        return autoService.getAutoByRendszam(rendszam);
    }

    @GetMapping(value = "autok")
    public Collection<Auto> getAutoByParam(@RequestParam(value = "uzemanyag", required = false) Uzemanyag uzemanyag) {
        if (uzemanyag != null) {
            return autoService.readAllAutoOfUzemanyag(uzemanyag);
        }
        return autoService.getAllAutos();
    }

    @PostMapping(value = "autok", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=utf-8")
    public String addAuto(@RequestBody Auto auto) throws AutoAlreadyAdded {
        autoService.addAuto(auto);
        return "Új autó : " + auto.getRendszam();
    }

    @PostMapping(value = "autok/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=utf-8")
    public String updateAuto(@RequestBody Auto auto) throws AutoNotFound {
        autoService.updateAuto(auto);
        return "Updated autó : " + auto.getRendszam();
    }

    @DeleteMapping(value = "auto/{rendszam:[A-Za-z]{3}-[0-9]{3}}")
    public void deleteAutoByRendszam(@PathVariable(name = "rendszam") String rendszam) throws AutoNotFound {
        System.out.println("Törölt autó: " + rendszam);
        autoService.removeAuto(rendszam);
    }

    @ExceptionHandler(AutoAlreadyAdded.class)
    @ResponseStatus(HttpStatus.IM_USED)
    public String alreadyAddedRendszam(AutoAlreadyAdded e) {
        return "Autó az adott azonosítóval már létezik" + e.getMessage();
    }
}
