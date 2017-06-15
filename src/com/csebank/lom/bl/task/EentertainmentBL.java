/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EentertainmentSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 食堂接待信息业务逻辑接口
 */
public interface EentertainmentBL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(EentertainmentSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param eeid 食堂接待ID
	 * @return 食堂接待ID
	 */
	public Eentertainment searchEentertainmentByKey(Integer eeid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部食堂接待信息
	 */
	public List<Eentertainment> searchEentertainmentAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Eentertainment> searchEentertainment(EentertainmentSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param Eentertainment 登录数据
	 * @return 食堂接待信息
	 */
	public Eentertainment registEentertainment(Eentertainment eentertainment) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param Eentertainment 变更数据
	 * @return 食堂成本信息
	 */
	public Eentertainment updateEentertainment(Eentertainment eentertainment) throws BLException;
	
	/**
	 * 删除处理
	 * 
	 * @param Eentertainment 删除数据
	 * @return 食堂接待信息
	 */
	
	public void deleteEentertainment(Integer eeid) throws BLException;

}
