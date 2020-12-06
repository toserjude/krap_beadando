package uni.eszterhazy.krap.dao.mongo;

import com.mongodb.*;
import org.bson.types.ObjectId;
import uni.eszterhazy.krap.dao.AutoDAO;
import uni.eszterhazy.krap.exceptions.AutoAlreadyAdded;
import uni.eszterhazy.krap.exceptions.AutoNotFound;
import uni.eszterhazy.krap.model.Auto;
import uni.eszterhazy.krap.model.Uzemanyag;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;

public class AutoDAOMongo implements AutoDAO {
    private MongoClient client;
    private DB db;
    private DBCollection collection;


    public AutoDAOMongo(String uri, String database, String collection) throws UnknownHostException {
        this.client = new MongoClient(new MongoClientURI(uri));
        this.db = client.getDB(database);
        this.collection = db.getCollection(collection);
    }

    @Override
    public void createAuto(Auto auto) throws AutoAlreadyAdded {
        try {
            readAuto(auto.getRendszam());
        } catch (AutoNotFound autoNotFound) {
            collection.insert(AutoAdapter.autoToDBObject(auto));
            return;
        }
        throw new AutoAlreadyAdded(auto.getRendszam());
    }

    @Override
    public Collection<Auto> readAllAuto() {
        DBCursor cursor = collection.find(new BasicDBObject(), new BasicDBObject().append("_id",0));
        Collection<Auto> result = new ArrayList<>();
        cursor.forEach(o->{
            result.add(AutoAdapter.dbObjectToAuto(o));
        });
        return result ;
    }

    @Override
    public Auto readAuto(String rendszam) throws AutoNotFound {
        DBCursor cursor = collection.find(new BasicDBObject().append("rendszam", rendszam), new BasicDBObject().append("_id",0));
        if(cursor.length()==0){
            throw new AutoNotFound(rendszam);
        }
        return AutoAdapter.dbObjectToAuto(cursor.one());
    }

    @Override
    public void updateAuto(Auto auto) throws AutoNotFound {
        collection.update(AutoAdapter.autoToDBObject(readAuto(auto.getRendszam())),AutoAdapter.autoToDBObject(auto));
    }

    @Override
    public void deleteAuto(String rendszam) throws AutoNotFound {
        Auto auto = readAuto(rendszam);
        collection.remove(AutoAdapter.autoToDBObject(auto));
    }

    @Override
    public Collection<Auto> readAllAutoOfUzemanyag(Uzemanyag uzemanyag) throws AutoNotFound {
        DBCursor cursor = collection.find(new BasicDBObject().append("uzemanyag",uzemanyag.toString()), new BasicDBObject().append("_id",0));
        Collection<Auto> result = new ArrayList<>();
        cursor.forEach(auto->{
            result.add(AutoAdapter.dbObjectToAuto(auto));
        });
        return result ;
    }
}
