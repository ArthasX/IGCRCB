/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;
import com.deliverik.infogovernor.sym.model.condition.MSGFILTERSearchCond;
import com.deliverik.infogovernor.sym.model.dao.MSGFILTERDAO;
import com.deliverik.infogovernor.sym.model.entity.MSGFILTERTB;

/**
 * 概述: MSGFILTER业务逻辑实现 功能描述: MSGFILTER业务逻辑实现 创建记录: 2013/08/21 修改记录:
 */
public class MSGFILTERBLImpl extends BaseBLImpl implements MSGFILTERBL {

	/** MSGFILTERDAO接口 */
	public MSGFILTERDAO mSGFILTERDAO;

	public void setmSGFILTERDAO(MSGFILTERDAO mSGFILTERDAO) {
		this.mSGFILTERDAO = mSGFILTERDAO;
	}

	/**
	 * MSGFILTERDAO接口设定
	 * 
	 * @param mSGFILTERDAO
	 *            MSGFILTERDAO接口
	 */

	/**
	 * MSGFILTER实例取得
	 * 
	 * @return MSGFILTER实例
	 */
	public MSGFILTERTB getMSGFILTERTBInstance() {
		return new MSGFILTERTB();
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<MSGFILTERInfo> searchMSGFILTER() {
		return mSGFILTERDAO.findAll();
	}

	/**
	 * 主键检索处理
	 * 
	 * @param pk
	 *            主键
	 * @return 检索结果
	 */
	public MSGFILTERInfo searchMSGFILTERByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(MSGFILTERSearchCond cond) {
		return mSGFILTERDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果列表
	 */
	public List<MSGFILTERInfo> searchMSGFILTER(MSGFILTERSearchCond cond) {
		return mSGFILTERDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @param start
	 *            检索记录起始行号
	 * @param count
	 *            检索记录件数
	 * @return 检索结果列表
	 */
	public List<MSGFILTERInfo> searchMSGFILTER(MSGFILTERSearchCond cond,
			int start, int count) {
		return mSGFILTERDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 * 
	 * @param instance
	 *            新增实例
	 * @return 新增实例
	 */
	public MSGFILTERInfo registMSGFILTER(MSGFILTERInfo instance)
			throws BLException {
		return mSGFILTERDAO.save(instance);
	}

	/**
	 * 修改处理
	 * 
	 * @param instance
	 *            修改实例
	 * @return 修改实例
	 */
	public MSGFILTERInfo updateMSGFILTER(MSGFILTERInfo instance)
			throws BLException {
		checkExistInstance(instance.getId());
		return mSGFILTERDAO.save(instance);
	}

	/**
	 * 删除处理
	 * 
	 * @param pk
	 *            主键
	 */
	public void deleteMSGFILTERByPK(Integer pk) throws BLException {
		mSGFILTERDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 * 
	 * @param instance
	 *            删除实例
	 */
	public void deleteMSGFILTER(MSGFILTERInfo instance) throws BLException {
		mSGFILTERDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 * 
	 * @param pk
	 *            主键
	 * @return 实例
	 */
	public MSGFILTERInfo checkExistInstance(Integer pk) throws BLException {
		MSGFILTERInfo instance = mSGFILTERDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}