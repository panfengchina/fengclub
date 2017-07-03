package org.fengclub.core.dao;

import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
/** 
 * spring mongodb　集成操作类　
 * @author Art.pan 
 */
@Repository
public class BaseMongoDao<T> {
	  
	@Resource
    protected MongoTemplate mongoTemplate;  
    
    public T save(T entity) {  
        mongoTemplate.insert(entity);  
        return entity;  
    }  
  
    public T findById(String id,Class<T> clazz) {  
        return mongoTemplate.findById(id, clazz);  
    }  
  
    public T findById(String id, String collectionName,Class<T> clazz) {  
        return mongoTemplate.findById(id, clazz, collectionName);  
    }  
  
    public List<T> findAll(Class<T> clazz) {  
        return mongoTemplate.findAll(clazz);  
    }  
  
    public List<T> findAll(String collectionName,Class<T> clazz) {  
        return mongoTemplate.findAll(clazz, collectionName);  
    }  
  
    public List<T> find(Query query,Class<T> clazz) {  
        return mongoTemplate.find(query, clazz);  
    }  
  
    public T findOne(Query query,Class<T> clazz) {  
        return mongoTemplate.findOne(query, clazz);  
    }  
  
    public Page<T> findPage(Page<T> page, Query query,Class<T> clazz) {  
        //如果没有条件 则所有全部  
        query=query==null?new Query(Criteria.where("_id").exists(true)):query;  
        long count = this.count(query,clazz);  
        // 总数  
        page.setTotalCount((int) count);  
        int currentPage = page.getCurrentPage();  
        int pageSize = page.getPageSize();  
        query.skip((currentPage - 1) * pageSize).limit(pageSize);  
        List<T> rows = this.find(query,clazz);  
        page.build(rows);  
        return page;  
    }  
  
    public long count(Query query,Class<T> clazz) {  
        return mongoTemplate.count(query, clazz);  
    }  
  
    public WriteResult update(Query query, Update update,Class<T> clazz) {  
        if (update==null) {  
            return null;  
        }  
        return mongoTemplate.updateMulti(query, update, clazz);  
    }  
  
    public T updateOne(Query query, Update update,Class<T> clazz) {  
        if (update==null) {  
            return null;  
        }  
        return mongoTemplate.findAndModify(query, update, clazz);  
    }  
  
    public WriteResult update(T entity,Class<T> clazz) {  
        Field[] fields = clazz.getDeclaredFields();  
        if (fields == null || fields.length <= 0) {  
            return null;  
        }  
        Field idField = null;  
        // 查找ID的field  
        for (Field field : fields) {  
            if (field.getName() != null  
                    && "id".equals(field.getName().toLowerCase())) {  
                idField = field;  
                break;  
            }  
        }  
        if (idField == null) {  
            return null;  
        }  
        idField.setAccessible(true);  
        String id=null;  
        try {  
            id = (String) idField.get(entity);  
        } catch (IllegalArgumentException e) {  
            e.printStackTrace();  
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
        }  
        if (id == null || "".equals(id.trim()))  
            return null;  
        // 根据ID更新  
        Query query = new Query(Criteria.where("_id").is(id));  
        // 更新  
        // Update update = new Update();  
        // for (Field field : fields) {  
        // // 不为空 不是主键 不是序列化号  
        // if (field != null  
        // && field != idField  
        // && !"serialversionuid"  
        // .equals(field.getName().toLowerCase())) {  
        // field.setAccessible(true);  
        // Object obj = field.get(entity);  
        // if (obj == null)  
        // continue;  
        // update.set(field.getName(), obj);  
        // }  
        // }  
        Update update = ReflectionUtils.getUpdateObj(entity);  
        if (update == null) {  
            return null;  
        }  
        return mongoTemplate.updateFirst(query, update, clazz);  
    }  
  
    public void remove(Query query,Class<T> clazz) {  
        mongoTemplate.remove(query, clazz);  
    }
    
}
