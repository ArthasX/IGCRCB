/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;
import com.deliverik.infogovernor.iam.model.condition.AUDITPROJECTSearchCond;
import com.deliverik.infogovernor.iam.model.dao.AUDITPROJECTDAO;
import com.deliverik.infogovernor.iam.model.entity.AUDITPROJECTTB;

/**
  * 概述: 审计报告表业务逻辑实现
  * 功能描述: 审计报告表业务逻辑实现
  * 创建记录: 2012/08/08
  * 修改记录: 
  */
public class AUDITPROJECTBLImpl extends BaseBLImpl implements
		AUDITPROJECTBL {

	/** 审计报告表DAO接口 */
	protected AUDITPROJECTDAO auditProjectDAO;
	
	/**
	 * 审计报告表DAO接口设定
	 *
	 * @param auditProjectDAO 审计报告表DAO接口
	 */

	public void setauditProjectDAO(AUDITPROJECTDAO auditProjectDAO) {
		this.auditProjectDAO = auditProjectDAO;
	}


	/**
	 * 审计报告表实例取得
	 *
	 * @return 审计报告表实例
	 */
	public AUDITPROJECTDAO getauditProjectDAO() {
		return auditProjectDAO;
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AUDITPROJECTInfo> searchAUDITPROJECT() {
		return auditProjectDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AUDITPROJECTInfo searchAUDITPROJECTByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AUDITPROJECTSearchCond cond) {
		return auditProjectDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AUDITPROJECTInfo> searchAUDITPROJECT(
			AUDITPROJECTSearchCond cond) {
		return auditProjectDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AUDITPROJECTInfo> searchAUDITPROJECT(
			AUDITPROJECTSearchCond cond, int start,
			int count) {
		return auditProjectDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AUDITPROJECTInfo registAUDITPROJECT(AUDITPROJECTInfo instance)
		throws BLException {
		return auditProjectDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AUDITPROJECTInfo updateAUDITPROJECT(AUDITPROJECTInfo instance)
		throws BLException {
		checkExistInstance(instance.getApid());
		return auditProjectDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAUDITPROJECTByPK(Integer pk)
		throws BLException {
		auditProjectDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAUDITPROJECT(AUDITPROJECTInfo instance)
		throws BLException {
		auditProjectDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public AUDITPROJECTInfo checkExistInstance(Integer pk)
		throws BLException {
		AUDITPROJECTInfo instance = auditProjectDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	public AUDITPROJECTTB getAUDITPROJECTTBInstance() {
		// TODO Auto-generated method stub
		return new AUDITPROJECTTB();
	}

}