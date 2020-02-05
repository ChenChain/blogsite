package com.chain.blog.service.type;

import com.chain.blog.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TypeService {

    int saveType(Type type);
    Type getType(int id);
    List<Type>  getTypes(int page,int size);//页数 大小
    int updateType(int id,Type type);
    List<Type> getTypes();
    void deleteType(int id);

}
