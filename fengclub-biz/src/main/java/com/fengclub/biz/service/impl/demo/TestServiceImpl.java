package com.fengclub.biz.service.impl.demo;

import java.util.Date;
import java.util.List;

import org.fengclub.core.dao.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.fengclub.biz.dao.demo.TestDAO;
import com.fengclub.biz.entity.demo.Test;
import com.fengclub.biz.service.demo.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDAO testDao;
	
	public Test addTest(Test test) {
		return testDao.save(test);
	}

	public Test findTestById(String id) {
		return testDao.findById(id, Test.class);
	}

	public Test updateTest(Test test) {
		Query query=new Query();
		Update update=new Update();
		// TODO 根据条件修改
		return testDao.updateOne(query, update, Test.class);
	}

	public Boolean deleteTestById(String id) {
		return testDao.remove(id, Test.class);
	}

	public List<Test> findTestByAll() {
		return testDao.findAll(Test.class);
	}

	public Page<Test> findTestByPage(int currentPage, int pageSize) {
		Query query=new Query();
		query.addCriteria(Criteria.where("createDate").lte(new Date()));	//小于当前时间
		return testDao.findPage(new Page<Test>(currentPage, pageSize), query, Test.class);
	}

}
