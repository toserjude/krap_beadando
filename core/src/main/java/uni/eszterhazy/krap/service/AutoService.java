package uni.eszterhazy.krap.service;

import uni.eszterhazy.krap.exceptions.AutoAlreadyAdded;
import uni.eszterhazy.krap.exceptions.AutoNotFound;
import uni.eszterhazy.krap.model.Auto;
import uni.eszterhazy.krap.model.Uzemanyag;

import java.util.Collection;

public interface AutoService {
    void addAuto(Auto auto) throws AutoAlreadyAdded;
    Collection<Auto> getAllAutos();
    Auto getAutoByRendszam(String rendszam) throws AutoNotFound;
    void updateAuto(Auto auto) throws AutoNotFound;
    void removeAuto(String rendszam) throws AutoNotFound;
    Collection<Auto> readAllAutoOfUzemanyag(Uzemanyag uzemanyag);
}
