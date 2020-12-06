package uni.eszterhazy.krap.dao;

import uni.eszterhazy.krap.model.Auto;
import uni.eszterhazy.krap.exceptions.AutoAlreadyAdded;
import uni.eszterhazy.krap.exceptions.AutoNotFound;
import uni.eszterhazy.krap.model.Uzemanyag;

import java.util.Collection;

public interface AutoDAO {
    void createAuto(Auto auto) throws AutoAlreadyAdded;
    Collection<Auto> readAllAuto();
    Auto readAuto(String rendszam) throws AutoNotFound;
    void updateAuto(Auto auto) throws AutoNotFound;
    void deleteAuto(String rendszam) throws AutoNotFound;
    Collection<Auto> readAllAutoOfUzemanyag(Uzemanyag uzemanyag) throws AutoNotFound;
}
