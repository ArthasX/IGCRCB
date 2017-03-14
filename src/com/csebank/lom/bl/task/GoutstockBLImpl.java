/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Goutstock;
import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.csebank.lom.model.dao.GoutstockDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 物品出库信息业务逻辑接口实现
 */
public class GoutstockBLImpl extends BaseBLImpl implements GoutstockBL {
	
	/**  DAO */
	protected GoutstockDAO goutstockDAO;

	/**
	 * @param goutstockDAO the goutstockDAO to set
	 */
	public void setGoutstockDAO(GoutstockDAO goutstockDAO) {
		this.goutstockDAO = goutstockDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(GoutstockSearchCond cond){
		
		return goutstockDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param goid 物品出库信息ID
	 * @return 物品出库信息ID
	 */
	public Goutstock searchGoutstockByKey(Integer goid) throws BLException{
		
		return checkExistGoutstock(goid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部物品入出库明细信息
	 */
	public List<Goutstock> searchGoodsAll(){
		
		return goutstockDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Goutstock> searchGoutstock(GoutstockSearchCond cond, int start, int count){
		
		return goutstockDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param Goutstock 登录数据
	 * @return 物品出库信息
	 */
	public Goutstock registGoutstock(Goutstock Goutstock) throws BLException{
		
		return goutstockDAO.save(Goutstock);
	}

	/**
	 * 删除处理
	 * 
	 * @param goid 物品出库信息ID
	 * @return
	 */
	public void deleteGoutstock(Integer giodid) throws BLException{
		
		Goutstock Goutstock = checkExistGoutstock(giodid);
		
		goutstockDAO.delete(Goutstock);
	}

	/**
	 * 变更处理
	 * 
	 * @param Goutstock 变更数据
	 * @return 物品出库信息
	 */
	public Goutstock updateGoods(Goutstock Goutstock) throws BLException{
		
		checkExistGoutstock(Goutstock.getGoid());
		return goutstockDAO.save(Goutstock);
	}

	/**
	 * 物品出库信息存在检查
	 * 
	 * @param goid 物品出库信息ID
	 * @return 物品出库信息
	 * @throws BLException 
	 */
	protected Goutstock checkExistGoutstock(Integer goid) throws BLException{
		Goutstock info = goutstockDAO.findByPK(goid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","物品出库信息基本");
		}
		return info;
	}

}
