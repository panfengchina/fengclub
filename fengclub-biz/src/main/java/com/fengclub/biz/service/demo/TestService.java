package com.fengclub.biz.service.demo;

import java.util.List;
import java.util.Map;

import org.fengclub.core.dao.Page;

import com.fengclub.biz.entity.demo.Test;

public interface TestService {

	/**
	 * 添加Test类
	 * @author Art.pan
	 * @param test
	 * @return test
	 */
	public abstract Test addTest(Test test);
	
	/**
	 * 根据id查询
	 * @author Art.pan
	 * @param id
	 * @return test
	 */
	public abstract Test findTestById(String id);
	
	/**
	 * 修改test类
	 * @author Art.pan
	 * @param map 需要修改的字段值
	 * @return test
	 */
	public abstract Boolean updateTestByCustom(Map<String, Object> map);
	
	/**
	 * 修改test类
	 * @author Art.pan
	 * @param Test 全部覆盖更新
	 * @return test
	 */
	public abstract Boolean updateTest(Test Test);
	
	/**
	 * 根据id删除test
	 * @author Art.pan
	 * @param id
	 * @return true
	 */
	public abstract Boolean deleteTestById(String id);
	
	/**
	 * 根据id删除test，物理删除
	 * @author Art.pan
	 * @param id
	 * @return true
	 */
	public abstract Boolean deleteTestByIdDeep(String id);
	/**
	 * 查询所有test
	 * @author Art.pan
	 * @return List<Test>
	 */
	public abstract List<Test> findTestByAll();
	
	/**
	 * 分页显示
	 * @author Art.pan
	 * @param currentPage 当前页
	 * @param pageSize 页面条数
	 * @return Page<Test>
	 */
	public abstract Page<Test> findTestByPage(int currentPage, int pageSize);
}
