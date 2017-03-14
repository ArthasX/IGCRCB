/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EentertainmentSearchCond;
import com.csebank.lom.model.dao.EentertainmentDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 食堂接待信息业务逻辑接口实现
 */
public class EentertainmentBLImpl extends BaseBLImpl implements EentertainmentBL {
	
	/** Eentertainment DAO */
	protected EentertainmentDAO eentertainmentDAO;
	
	public void setEentertainmentDAO(
			EentertainmentDAO eentertainmentDAO) {
		this.eentertainmentDAO = eentertainmentDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(EentertainmentSearchCond cond){
		
		return eentertainmentDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param eeid 食堂接待ID
	 * @return 食堂接待ID
	 */
	public Eentertainment searchEentertainmentByKey(Integer eeid) throws BLException{
		Eentertainment ret = eentertainmentDAO.findByPK(eeid);
		return ret;
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部食堂接待信息
	 */
	public List<Eentertainment> searchEentertainmentAll(){
		
		return eentertainmentDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Eentertainment> searchEentertainment(EentertainmentSearchCond cond, int start, int count){
		
		return eentertainmentDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param eentertainment 登录数据
	 * @return 食堂接待信息
	 */
	public Eentertainment registEentertainment(Eentertainment eentertainment) throws BLException{
		
		return eentertainmentDAO.save(eentertainment);
	}

	/**
	 * 变更处理
	 * 
	 * @param eentertainment 变更数据
	 * @return 食堂接待信息
	 */
	public Eentertainment updateEentertainment(Eentertainment eentertainment) throws BLException{
		
		checkExistEentertainment(eentertainment.getEeid());
		return eentertainmentDAO.save(eentertainment);
	}

	/**
	 * 食堂接待信息存在检查
	 * 
	 * @param eeid 食堂接待ID
	 * @return 食堂接待信息
	 * @throws BLException 
	 */
	protected Eentertainment checkExistEentertainment(Integer eeid) throws BLException{
		Eentertainment info = eentertainmentDAO.findByPK(eeid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","食堂接待");
		}
		return info;
	}
	
	/**
	 * 食堂接待信息删除
	 * 
	 * @param eeid 食堂接待ID
	 * @return 食堂接待信息
	 * @throws BLException 
	 */
	
	public void deleteEentertainment(Integer eeid) throws BLException {
		Eentertainment eentertainment = checkExistEentertainment(eeid);
		eentertainmentDAO.delete(eentertainment);
	}

}
