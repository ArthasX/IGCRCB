/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Gstock;
import com.csebank.lom.model.condition.GstockSearchCond;
import com.csebank.lom.model.dao.GstockDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 物品信息业务逻辑接口实现
 */
public class GstockBLImpl extends BaseBLImpl implements GstockBL {

	/** DAO */
	protected GstockDAO gstockDAO;
	

	public void setGstockDAO(GstockDAO gstockDAO) {
		this.gstockDAO = gstockDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(GstockSearchCond cond){
		
		return gstockDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param gid 物品信息ID
	 * @return 物品信息ID
	 */
	public Gstock searchGstockByKey(Integer gsid) throws BLException{
		
		return checkExistGstock(gsid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部物品信息ID
	 */
	public List<Gstock> searchGstockAll(){
		
		return gstockDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Gstock> searchGstock(GstockSearchCond cond, int start, int count){
		
		return gstockDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param Gstock 登录数据
	 * @return 物品信息
	 */
	public Gstock registGstock(Gstock Gstock) throws BLException{
		
		return gstockDAO.save(Gstock);
	}

	/**
	 * 删除处理
	 * 
	 * @param gid 物品信息ID
	 * @return
	 */
	public void deleteGstock(Integer gid) throws BLException{
		
		Gstock Gstock = checkExistGstock(gid);
		
		gstockDAO.delete(Gstock);
	}

	/**
	 * 变更处理
	 * 
	 * @param Gstock 变更数据
	 * @return 物品信息ID
	 */
	public Gstock updateGstock(Gstock Gstock) throws BLException{
		
		checkExistGstock(Gstock.getGsid());
		return gstockDAO.save(Gstock);
	}

	/**
	 * 值班检查项信息存在检查
	 * 
	 * @param gid 物品信息ID
	 * @return 物品信息
	 * @throws BLException 
	 */
	protected Gstock checkExistGstock(Integer gsid) throws BLException{
		Gstock info = gstockDAO.findByPK(gsid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","物品基本");
		}
		return info;
	}

}
