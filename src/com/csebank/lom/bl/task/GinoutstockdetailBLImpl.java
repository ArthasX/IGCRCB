/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Ginoutstockdetail;
import com.csebank.lom.model.GoutDetailInfo;
import com.csebank.lom.model.condition.GinoutstockdetailSearchCond;
import com.csebank.lom.model.condition.GoutDetailSearchCond;
import com.csebank.lom.model.dao.GinoutStockDetailVWDAO;
import com.csebank.lom.model.dao.GinoutstockdetailDAO;
import com.csebank.lom.model.dao.GoutDetailInfoDAO;
import com.csebank.lom.model.entity.GinoutStockDetailVW;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 物品信息业务逻辑接口实现
 */
public class GinoutstockdetailBLImpl extends BaseBLImpl implements GinoutstockdetailBL {
	
	/**  DAO */
	protected GinoutstockdetailDAO ginoutstockdetailDAO;
	
	protected GinoutStockDetailVWDAO ginoutStockDetailVWDAO;
	//食堂物品消耗明细
	protected GoutDetailInfoDAO goutDetailInfoDAO;

	/**
	 * @param ginoutstockdetailDAO the ginoutstockdetailDAO to set
	 */
	public void setGinoutstockdetailDAO(GinoutstockdetailDAO ginoutstockdetailDAO) {
		this.ginoutstockdetailDAO = ginoutstockdetailDAO;
	}
	
	public void setGinoutStockDetailVWDAO(GinoutStockDetailVWDAO ginoutStockDetailVWDAO) {
		this.ginoutStockDetailVWDAO = ginoutStockDetailVWDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(GinoutstockdetailSearchCond cond){
		
		return ginoutstockdetailDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param giodid 物品入出库明细信息ID
	 * @return 物品入出库明细信息ID
	 */
	public Ginoutstockdetail searchGinoutstockdetailByKey(Integer giodid) throws BLException{
		
		return checkExistGinoutstockdetail(giodid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部物品入出库明细信息
	 */
	public List<Ginoutstockdetail> searchGinoutstockdetailAll(){
		
		return ginoutstockdetailDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Ginoutstockdetail> searchGinoutstockdetail(GinoutstockdetailSearchCond cond, int start, int count){
		
		return ginoutstockdetailDAO.findByCond(cond,start,count);
	}
	
	public List<GinoutStockDetailVW> searchGinoutstockdetail(GinoutstockdetailSearchCond cond, int start, int count, String temp){
		
		return ginoutStockDetailVWDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param Ginoutstockdetail 登录数据
	 * @return 物品入出库明细信息
	 */
	public Ginoutstockdetail registGinoutstockdetail(Ginoutstockdetail Ginoutstockdetail) throws BLException{
		
		return ginoutstockdetailDAO.save(Ginoutstockdetail);
	}

	/**
	 * 删除处理
	 * 
	 * @param giodid 物品入出库明细信息ID
	 * @return
	 */
	public void deleteGinoutstockdetail(Integer giodid) throws BLException{
		
		Ginoutstockdetail Ginoutstockdetail = checkExistGinoutstockdetail(giodid);
		
		ginoutstockdetailDAO.delete(Ginoutstockdetail);
	}

	/**
	 * 变更处理
	 * 
	 * @param Ginoutstockdetail 变更数据
	 * @return 物品入出库明细信息
	 */
	public Ginoutstockdetail updateGinoutstockdetail(Ginoutstockdetail Ginoutstockdetail) throws BLException{
		
		checkExistGinoutstockdetail(Ginoutstockdetail.getGiodid());
		return ginoutstockdetailDAO.save(Ginoutstockdetail);
	}

	/**
	 * 物品入出库明细信息存在检查
	 * 
	 * @param rid 值班检查项ID
	 * @return 值班检查项信息
	 * @throws BLException 
	 */
	protected Ginoutstockdetail checkExistGinoutstockdetail(Integer giodid) throws BLException{
		Ginoutstockdetail info = ginoutstockdetailDAO.findByPK(giodid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","物品入出库明细信息基本");
		}
		return info;
	}
	public List<GoutDetailInfo> getGoutDetailInfo(GoutDetailSearchCond cond,
			int start, int count) {
		
		return goutDetailInfoDAO.findByCond(cond, start, count);
	}

	public GoutDetailInfoDAO getGoutDetailInfoDAO() {
		return goutDetailInfoDAO;
	}

	public void setGoutDetailInfoDAO(GoutDetailInfoDAO goutDetailInfoDAO) {
		this.goutDetailInfoDAO = goutDetailInfoDAO;
	}

}
