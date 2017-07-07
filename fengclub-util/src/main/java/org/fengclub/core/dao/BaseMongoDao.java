package org.fengclub.core.dao;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
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
    	 ObjectId objid=new ObjectId(id);
        return mongoTemplate.findById(objid, clazz);  
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
    	if(query==null){
    		query=new Query();
    		query.addCriteria(Criteria.where("_id").exists(true));
    	}
		query.addCriteria(Criteria.where("available").is(true));  
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
  
    public boolean updateByCustom(Map<String, Object> map,Class<T> clazz) {  
    	Field[] fields = clazz.getDeclaredFields();
    	Query query=new Query();
		
    	for (Field field : fields) {
    		for (Entry<String, Object> entry : map.entrySet()) {
    			if(field.getName().equals(entry.getKey())){
    				if("id".equals(field.getName())){
    					query.addCriteria(Criteria.where("_id").is(entry.getValue()));
    				}else if(entry.getValue() instanceof Collection ||entry.getValue() instanceof Map){
    					System.out.println(entry.getValue());
    				}else{
    					query.addCriteria(Criteria.where(field.getName()).is(entry.getValue()));
    				}
    			}
    		}
    	}
    	
    	/*WriteResult wr=mongoTemplate.findAndModify(query, update, clazz);
        if (null != wr) {
            if (wr.getN() > 0) {
                return true;
            }
        }*/
    	return false;
    }  
  
    public T updateOne(Query query, Update update,Class<T> clazz) {  
        if (update==null) {  
            return null;  
        }  
        return mongoTemplate.findAndModify(query, update, clazz);  
    }  
  
    public boolean update(T entity,Class<T> clazz) {  
        Field[] fields = clazz.getDeclaredFields();  
        if (fields == null || fields.length <= 0) {  
            return false;  
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
            return false;  
        }  
        idField.setAccessible(true);  
        String id=null;  
        try {  
            id = idField.get(entity).toString();  
        } catch (IllegalArgumentException e) {  
            e.printStackTrace();  
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
        }  
        if (id == null || "".equals(id.trim()))  
            return false;  
        // 根据ID更新  
        Query query = new Query(Criteria.where("_id").is(id));   
        Update update = ReflectionUtils.getUpdateObj(entity);  
        if (update == null) {  
            return false;  
        }  
        WriteResult wr=mongoTemplate.updateFirst(query, update, clazz);
        if (null != wr) {
            if (wr.getN() > 0) {
                return true;
            }
        }
    	return false;
    }  
  
    /**
     * 物理删除，注意此方法操作记录不可撤销不可恢复 ，慎用
     * @author Art.pan
     * @param id 要删除的记录 id
     * @param clazz 类类型
     * @return true删除成功，false 删除失败
     */
    public boolean deepRemove(String id,Class<T> clazz) {  
    	WriteResult wr=mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), clazz);
    	if (null != wr) {
            if (wr.getN() > 0) {
                return true;
            }
        }
    	return false;
    }
    
    /**
     * 逻辑删除
     * @author Art.pan
     * @param id 要删除的记录 id
     * @param clazz 类类型
     * @return true删除成功，false 删除失败
     */
    public boolean remove(String id,Class<T> clazz) {  
    	T wr=mongoTemplate.findAndModify(new Query(Criteria.where("_id").is(id)), new Update().set("available", false), clazz);
    	if (null != wr) {
           return true;
        }
    	return false;
    }
}
