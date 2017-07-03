package org.fengclub.annotation;

public @interface DaoParams {

	/**
	 * 类class
	 * 
	 * @return
	 */
	public String clazz();

	/**
	 * 当前页
	 * 
	 * @return
	 */
	public int pageCur() default 1;

	/**
	 * 页面条数
	 * 
	 * @return
	 */
	public int pageNum() default 10;
}
