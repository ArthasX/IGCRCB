/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Goods;
import com.csebank.lom.model.condition.GoodsSearchCond;
import com.csebank.lom.model.dao.GoodsDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 物品信息业务逻辑接口实现
 */
public class GoodsBLImpl extends BaseBLImpl implements GoodsBL {
	
	/**  DAO */
	protected GoodsDAO goodsDAO;
	
	

	/**
	 * @param goodsDAO the goodsDAO to set
	 */
	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(GoodsSearchCond cond){
		
		return goodsDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param gid 物品信息ID
	 * @return 物品信息ID
	 */
	public Goods searchGoodsByKey(Integer gid) throws BLException{
		
		return checkExistGoods(gid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部物品信息ID
	 */
	public List<Goods> searchGoodsAll(){
		
		return goodsDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Goods> searchGoods(GoodsSearchCond cond, int start, int count){
		
		return goodsDAO.findByCond(cond,start,count);
	}
	
	public List<Goods> searchGoods(String gcategory){
		
		return goodsDAO.findByCond(gcategory);
	}

	/**
	 * 登录处理
	 * 
	 * @param Goods 登录数据
	 * @return 物品信息
	 */
	public Goods registGoods(Goods Goods) throws BLException{
		
		return goodsDAO.save(Goods);
	}

	/**
	 * 删除处理
	 * 
	 * @param gid 物品信息ID
	 * @return
	 */
	public void deleteGoods(Integer gid) throws BLException{
		
		Goods Goods = checkExistGoods(gid);
		
		goodsDAO.delete(Goods);
	}

	/**
	 * 变更处理
	 * 
	 * @param Goods 变更数据
	 * @return 物品信息ID
	 */
	public Goods updateGoods(Goods Goods) throws BLException{
		
		checkExistGoods(Goods.getGid());
		return goodsDAO.save(Goods);
	}

	/**
	 * 值班检查项信息存在检查
	 * 
	 * @param gid 物品信息ID
	 * @return 物品信息
	 * @throws BLException 
	 */
	protected Goods checkExistGoods(Integer gid) throws BLException{
		Goods info = goodsDAO.findByPK(gid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","物品信息基本");
		}
		return info;
	}

}
