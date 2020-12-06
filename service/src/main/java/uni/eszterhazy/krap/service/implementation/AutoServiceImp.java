package uni.eszterhazy.krap.service.implementation;

import org.springframework.stereotype.Service;
import uni.eszterhazy.krap.dao.AutoDAO;
import uni.eszterhazy.krap.exceptions.AutoNotFound;
import uni.eszterhazy.krap.model.Auto;
import uni.eszterhazy.krap.model.Uzemanyag;
import uni.eszterhazy.krap.service.AutoService;
import uni.eszterhazy.krap.exceptions.AutoAlreadyAdded;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AutoServiceImp implements AutoService {
    private AutoDAO dao;

    public AutoServiceImp(AutoDAO dao) {
        this.dao = dao;
    }

    public void addAuto(Auto auto) throws AutoAlreadyAdded {
        dao.createAuto(auto);
    }

    @Override
    public Collection<Auto> getAllAutos() {
        Collection<Auto> result = dao.readAllAuto();
        return result;
    }

    @Override
    public Auto getAutoByRendszam(String rendszam) throws AutoNotFound {
        return dao.readAuto(rendszam);
    }

    @Override
    public void updateAuto(Auto auto) throws AutoNotFound {
        dao.updateAuto(auto);
    }

    @Override
    public void removeAuto(String rendszam) throws AutoNotFound {
        dao.deleteAuto(rendszam);
    }

    @Override
    public Collection<Auto> readAllAutoOfUzemanyag(Uzemanyag uzemanyag) {
        Collection<Auto> autok = getAllAutos();
        Collection<Auto> result = autok.stream().filter(a -> a.getUzemanyag() == uzemanyag).collect(Collectors.toList());
        return result;
    }
}
