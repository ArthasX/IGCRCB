/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowLogSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowLogDAO;
import com.deliverik.infogovernor.kgm.model.entity.KnowLogTB;

/**
  * 概述: knowLog业务逻辑实现
  * 功能描述: knowLog业务逻辑实现
  * 创建记录: 2011/05/30
  * 修改记录: 
  */
public class KnowLogBLImpl extends BaseBLImpl implements
		KnowLogBL {

	/** knowLogDAO接口 */
	protected KnowLogDAO knowLogDAO;
	
	/**
	 * knowLogDAO接口设定
	 *
	 * @param knowLogDAO knowLogDAO接口
	 */
	public void setKnowLogDAO(KnowLogDAO knowLogDAO) {
		this.knowLogDAO = knowLogDAO;
	}

	/**
	 * knowLog实例取得
	 *
	 * @return knowLog实例
	 */
	public KnowLogTB getKnowLogTBInstance() {
		return new KnowLogTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<KnowLogInfo> searchKnowLog() {
		return knowLogDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public KnowLogInfo searchKnowLogByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(KnowLogSearchCond cond) {
		return knowLogDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<KnowLogInfo> searchKnowLog(
			KnowLogSearchCond cond) {
		return knowLogDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowLogInfo> searchKnowLog(
			KnowLogSearchCond cond, int start,
			int count) {
		return knowLogDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public KnowLogInfo registKnowLog(KnowLogInfo instance)
		throws BLException {
		return knowLogDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public KnowLogInfo updateKnowLog(KnowLogInfo instance)
		throws BLException {
		checkExistInstance(instance.getKlid());
		return knowLogDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteKnowLogByPK(Integer pk)
		throws BLException {
		knowLogDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteKnowLog(KnowLogInfo instance)
		throws BLException {
		knowLogDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public KnowLogInfo checkExistInstance(Integer pk)
		throws BLException {
		KnowLogInfo instance = knowLogDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 添加日志信息
	 *
	 * @param instance  添加日志信息
	 */
	public KnowLogInfo addKnowLog(Integer klkid,String userId,String userName,String time,String desc) throws BLException{
		//添加日志信息开始
		KnowLogTB kltb = new KnowLogTB();
		kltb.setKlkid(klkid);
		kltb.setKluserid(userId);
		kltb.setKlusername(userName);
		kltb.setKltime(time);
		kltb.setKldesc(desc);
		return this.registKnowLog(kltb);
		//添加日志信息结束
	}

}