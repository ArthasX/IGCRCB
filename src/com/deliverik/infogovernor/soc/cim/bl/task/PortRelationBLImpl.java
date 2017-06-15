/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.model.PortRelationInfo;
import com.deliverik.infogovernor.soc.model.condition.PortRelationSearchCond;
import com.deliverik.infogovernor.soc.model.dao.PortRelationDAO;
import com.deliverik.infogovernor.soc.model.entity.PortRelationPK;
import com.deliverik.infogovernor.soc.model.entity.PortRelationTB;


/**
  * 概述: 端到端关系表业务逻辑实现
  * 功能描述: 端到端关系表业务逻辑实现
  * 创建记录: 2013/01/17
  * 修改记录: 
  */
public class PortRelationBLImpl extends BaseBLImpl implements
		PortRelationBL {

	/** 端到端关系表DAO接口 */
	protected PortRelationDAO portRelationDao;
	
	/**  
	 * 端到端关系表DAO接口设定
	 *
	 * @param portRelationDAO 端到端关系表DAO接口
	 */
	public void setPortRelationDao(PortRelationDAO portRelationDao) {
		this.portRelationDao = portRelationDao;
	}

	/**
	 * 端到端关系表实例取得
	 *
	 * @return 端到端关系表实例
	 */
	public PortRelationTB getPortRelationTBInstance() {
		return new PortRelationTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PortRelationInfo> searchPortRelation() {
		return portRelationDao.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PortRelationInfo searchPortRelationByPK(PortRelationPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(PortRelationSearchCond cond) {
		return portRelationDao.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<PortRelationInfo> searchPortRelation(
			PortRelationSearchCond cond) {
		return portRelationDao.findByCond(cond, 0, 0);
	}
	/**
	 * 剩余hyper查询
	 */
	public List<String> searchPortRelationStr(
			PortRelationSearchCond cond) {
		return portRelationDao.findByCondStr(cond, 0, 0);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PortRelationInfo> searchPortRelation(
			PortRelationSearchCond cond, int start,
			int count) {
		return portRelationDao.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public PortRelationInfo registPortRelation(PortRelationInfo instance)
		throws BLException {
		return portRelationDao.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public PortRelationInfo updatePortRelation(PortRelationInfo instance)
		throws BLException {
		checkExistInstance(new PortRelationPK(instance.getHBAPort_WWN(), instance.getDevicesName(), instance.getSymmetrixID(), instance.getFAName(), instance.getFAPortName()));
		return portRelationDao.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deletePortRelationByPK(PortRelationPK pk)
		throws BLException {
		portRelationDao.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deletePortRelation(PortRelationInfo instance)
		throws BLException {
		portRelationDao.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public PortRelationInfo checkExistInstance(PortRelationPK pk)
		throws BLException {
		PortRelationInfo instance = portRelationDao.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	/**
	 * 业务系统查询
	 */
	public List<String> searchPortRelationBuss(PortRelationSearchCond cond) {

		return portRelationDao.findByCondBuss(cond, 0, 0);	
		}
	/**
	 * 主机&HBA关键字查询
	 */
	public List<String> searchPortRelationHost(PortRelationSearchCond cond) {
		
		return portRelationDao.findByCondHost(cond, 0, 0);
	}
	/**
	 * 交换机关键字查询
	 */
	public List<String> searchPortRelationSwitch(PortRelationSearchCond cond) {

		return portRelationDao.findByCondSwitch(cond, 0, 0);

	}
	/**
	 * FA
	 */
	public List<String> searchPortRelationFa(PortRelationSearchCond cond) {

		return portRelationDao.findByCondFa(cond, 0, 0);

	}
	/**
	 * 查询meta与geteKeeper
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationHyper(PortRelationSearchCond cond) {

		return portRelationDao.findByCondHyper(cond, 0, 0);

	}
	/**
	 * 线路查询Hyper得到FAeiid
	 * @param eiid
	 * @return
	 */
	public List<String> getHypeEiid(final String eiid,final String einame){
		
		return portRelationDao.getHypeEiid(eiid,einame);
		
		}
}