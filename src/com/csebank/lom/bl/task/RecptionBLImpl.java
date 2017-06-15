/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.GuestRecption;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionAmount;
import com.csebank.lom.model.RecptionCost;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.condition.RecptionSearchCond;
import com.csebank.lom.model.dao.RecptionAmountDAO;
import com.csebank.lom.model.dao.RecptionCostVWDAO;
import com.csebank.lom.model.dao.RecptionDAO;
import com.csebank.lom.model.dao.RecptionGuestInfoDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 接待管理业务逻辑接口实现
 */
public class RecptionBLImpl extends BaseBLImpl implements RecptionBL {
	
	/** Recption DAO */
	protected RecptionDAO recptionDAO;
	protected RecptionGuestInfoDAO recptionguestinfoDAO;
	protected RecptionCostVWDAO recptionCostVWDAO;
	protected RecptionAmountDAO recptionAmountDAO;

	public void setRecptionCostVWDAO(RecptionCostVWDAO recptionCostVWDAO) {
		this.recptionCostVWDAO = recptionCostVWDAO;
	}

	public void setRecptionDAO(
			RecptionDAO recptionDAO) {
		this.recptionDAO = recptionDAO;
	}
    
	
	public void setRecptionGuestInfoDAO(
			RecptionGuestInfoDAO recptionguestinfoDAO) {
		this.recptionguestinfoDAO = recptionguestinfoDAO;
	}
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RecptionSearchCond cond){
		return recptionDAO.getSearchCount(cond);
	}
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getRecptionCostCount(RecptionSearchCond cond){
		return recptionCostVWDAO.getSearchCount(cond);
		//return recptionDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param rid 接待ID
	 * @return 接待ID
	 */
	public Recption searchRecptionByKey(Integer rid) throws BLException{
		
		return checkExistRecption(rid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部接待信息
	 */
	public List<Recption> searchRecptionAll(){
		
		return recptionDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Recption> searchRecption(RecptionSearchCond cond, int start, int count){
		return recptionDAO.findByCond(cond,start,count);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RecptionAmount> searchRecptionAmount(RecptionSearchCond cond, int start, int count){
		return recptionAmountDAO.findByCond(cond,start,count);
	}
	
	/**
	 * 根据接待开始结束日期查询接待工作信息和费用信息
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 接待工作信息和费用信息
	 */
	public List<RecptionCost> searchRecptionCost(RecptionSearchCond cond, int start, int count){
		return recptionCostVWDAO.findByCond(cond, start, count);
	
	}


	/**
	 * 登录处理
	 * 这个登录save处理方法也封装好了
	 * @param recption 登录数据
	 * @return 接待信息
	 */
	public Recption registRecption(Recption recption) throws BLException{
		
		return recptionDAO.save(recption);
	}

	/**
	 * 删除处理
	 * 
	 * @param rid 接待ID
	 * @return
	 */
	public void deleteRecption(Integer rid) throws BLException{
		
		Recption recption = checkExistRecption(rid);
		
		recptionDAO.delete(recption);
	}

	/**
	 * 变更处理
	 * 
	 * @param recption 变更数据
	 * @return 接待信息
	 */
	public Recption updateRecption(Recption recption) throws BLException{
		
		checkExistRecption(recption.getRid());
		return recptionDAO.save(recption);
	}

	/**
	 * 接待信息存在检查
	 * 
	 * @param rid 接待ID
	 * @return 接待信息
	 * @throws BLException 
	 */
	protected Recption checkExistRecption(Integer rid) throws BLException{
		Recption info = recptionDAO.findByPK(rid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","接待基本");
		}
		return info;
	}

	
	
     public int getSearchGuestInfoCount(RecptionGuestInfoCond cond){
		
		return recptionguestinfoDAO.getSearchCount(cond);
	}

     /**
 	 * 根据客户姓名，客户单位查询接待工作信息
 	 *
 	 * @param cond 检索条件
 	 * @param start 检索记录起始行号
 	 * @param count 检索记录件数
 	 * @return 接待工作信息
 	 */
 	public List<GuestRecption> searchRecptionByGuset(RecptionGuestInfoCond cond, int start, int count){
 		
 		return recptionDAO.findByGuestInfoCond(cond,start,count);
 	}

 	/**
	 * 根据客户姓名，客户单位查询结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getRecptionSearchCount(RecptionGuestInfoCond cond){
		
		return recptionDAO.getRecptionSearchCount(cond);
	}

	public void setRecptionAmountDAO(RecptionAmountDAO recptionAmountDAO) {
		this.recptionAmountDAO = recptionAmountDAO;
	}

}
