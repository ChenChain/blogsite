package com.chain.blog.service.type;

import com.chain.blog.dao.TypeDao;
import com.chain.blog.entity.Type;
import com.chain.blog.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/21
 **/
@Service
public class TypeServiceImpl implements TypeService {


    @Autowired
    private TypeDao typeDao;

    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Override
    public Type getType(int id) {
        return typeDao.getType(id);
    }

    @Override
    public List<Type> getTypes(int page, int size) {
        return typeDao.getTypes(page * (size - 1) + 1, size);
    }

    @Override
    public int updateType(int id, Type type) {

        Type typez = typeDao.getType(id);
        if (typez == null) {
            throw new NotFoundException("不存在该类型");
        }
        return typeDao.updateType(id, type);
    }

    @Override
    public List<Type> getTypes() {
        return typeDao.getTypes();
    }

    @Override
    public void deleteType(int id) {
        typeDao.deleteType(id);
    }


}
