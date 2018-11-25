package services;

import dao.TypeDao;
import model.TypeModel;

import java.util.List;

public class TypeService {

    static TypeDao typeDao = new TypeDao();

    public List<TypeModel> getTypes() {
        List<TypeModel> types = typeDao.geTypes();
        return types;

    }


}
