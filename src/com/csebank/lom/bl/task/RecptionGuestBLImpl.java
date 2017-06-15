/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.RecptionGuest;
import com.csebank.lom.model.RecptionGuestInfo;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.condition.RecptionGuestSearchCond;
import com.csebank.lom.model.dao.RecptionGuestDAO;
import com.csebank.lom.model.dao.RecptionGuestInfoDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 接待客人业务逻辑接口实现
 */
public class RecptionGuestBLImpl extends BaseBLImpl implements RecptionGuestBL {
	
	/** RecptionGuest DAO */
	protected RecptionGuestDAO recptionGuestDAO;
	protected RecptionGuestInfoDAO recptionguestInfoDAO;
	
	
	
	
	public RecptionGuestDAO getRecptionGuestDAO() {
		return recptionGuestDAO;
	}

	public void setRecptionGuestDAO(RecptionGuestDAO recptionGuestDAO) {
		this.recptionGuestDAO = recptionGuestDAO;
	}

	public RecptionGuestInfoDAO getRecptionguestInfoDAO() {
		return recptionguestInfoDAO;
	}

	public void setRecptionguestInfoDAO(RecptionGuestInfoDAO recptionguestInfoDAO) {
		this.recptionguestInfoDAO = recptionguestInfoDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RecptionGuestSearchCond cond){
		
		return recptionGuestDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param rgid 接待客人ID
	 * @return 接待客人ID
	 */
	public RecptionGuest searchRecptionGuestByKey(Integer rgid) throws BLException{
		
		return checkExistRecptionGuest(rgid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部接待信息
	 */
	public List<RecptionGuest> searchRecptionGuestAll(){
		
		return recptionGuestDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RecptionGuest> searchRecptionGuest(RecptionGuestSearchCond cond, int start, int count){
		
		return recptionGuestDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param recptionGuest 登录数据
	 * @return 接待信息
	 */
	public RecptionGuest registRecptionGuest(RecptionGuest recptionGuest) throws BLException{
		
		return recptionGuestDAO.save(recptionGuest);
	}

	/**
	 * 删除处理
	 * 
	 * @param rgid 接待ID
	 * @return
	 */
	public void deleteRecptionGuest(Integer rgid) throws BLException{
		
		RecptionGuest recptionGuest = checkExistRecptionGuest(rgid);
		
		recptionGuestDAO.delete(recptionGuest);
	}

	/**
	 * 变更处理
	 * 
	 * @param recptionGuest 变更数据
	 * @return 接待信息
	 */
	public RecptionGuest updateRecptionGuest(RecptionGuest recptionGuest) throws BLException{
		
		checkExistRecptionGuest(recptionGuest.getRgid());
		return recptionGuestDAO.save(recptionGuest);
	}

	/**
	 * 接待信息存在检查
	 * 
	 * @param rgid 接待ID
	 * @return 接待信息
	 * @throws BLException 
	 */
	protected RecptionGuest checkExistRecptionGuest(Integer rgid) throws BLException{
		RecptionGuest info = recptionGuestDAO.findByPK(rgid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","接待客人基本");
		}
		return info;
	}

	public int getSearchCount(RecptionGuestInfoCond cond) {
		// TODO Auto-generated method stub
		return recptionguestInfoDAO.getSearchCount(cond);
	}

	public List<RecptionGuestInfo> searchRecptionGuestInfo(
			RecptionGuestInfoCond cond, int start, int count) {
		// TODO Auto-generated method stub
		return recptionguestInfoDAO.findByCond(cond,start,count);
	}

}
