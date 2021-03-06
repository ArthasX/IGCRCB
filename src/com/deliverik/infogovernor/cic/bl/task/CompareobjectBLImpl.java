/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.CompareobjectInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectSearchCond;
import com.deliverik.infogovernor.cic.model.dao.CompareobjectDAO;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectTB;

/**
  * 概述: 对比对象业务逻辑实现
  * 功能描述: 对比对象业务逻辑实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public class CompareobjectBLImpl extends BaseBLImpl implements
		CompareobjectBL {

	/** 对比对象DAO接口 */
	protected CompareobjectDAO compareobjectDAO;
	
	/**
	 * 对比对象DAO接口设定
	 *
	 * @param compareobjectDAO 对比对象DAO接口
	 */
	public void setCompareobjectDAO(CompareobjectDAO compareobjectDAO) {
		this.compareobjectDAO = compareobjectDAO;
	}

	/**
	 * 对比对象实例取得
	 *
	 * @return 对比对象实例
	 */
	public CompareobjectTB getCompareobjectTBInstance() {
		return new CompareobjectTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareobjectInfo> searchCompareobject() {
		return compareobjectDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareobjectInfo searchCompareobjectByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CompareobjectSearchCond cond) {
		return compareobjectDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CompareobjectInfo> searchCompareobject(
			CompareobjectSearchCond cond) {
		return compareobjectDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareobjectInfo> searchCompareobject(
			CompareobjectSearchCond cond, int start,
			int count) {
		return compareobjectDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CompareobjectInfo registCompareobject(CompareobjectInfo instance)
		throws BLException {
		return compareobjectDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CompareobjectInfo updateCompareobject(CompareobjectInfo instance)
		throws BLException {
		checkExistInstance(instance.getCoid());
		return compareobjectDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCompareobjectByPK(Integer pk)
		throws BLException {
		compareobjectDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCompareobject(CompareobjectInfo instance)
		throws BLException {
		compareobjectDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CompareobjectInfo checkExistInstance(Integer pk)
		throws BLException {
		CompareobjectInfo instance = compareobjectDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 集合保存
	 * @param instantce
	 * @throws BLException
	 */
	public void save(List<CompareobjectInfo> instantce)throws BLException{
		compareobjectDAO.delByCrid(instantce.get(0).getFkCrid());
		compareobjectDAO.saveOrUpdateAll(instantce);
		
	}
	
	/**
	 * 转移对比对象到 历史表中
	 * @param crid
	 * @return
	 */
	public boolean toHistory(Integer crid)throws BLException{
		return compareobjectDAO.toHistory(crid);
	}
	
	/**
	 * 根据规则删除对比对象
	 * @param crid
	 * @return
	 */
	public boolean delByCrid(Integer crid)throws BLException{
		return compareobjectDAO.delByCrid(crid);
	}
}