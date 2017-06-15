/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.model.Mss00012Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00012SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00012TB;

/**
  * 概述: MSS00012业务逻辑接口
  * 功能描述: MSS00012业务逻辑接口
  * 创建记录: 2013/04/25
  * 修改记录: 
  */
public interface Mss00012BL extends BaseBL {

	/**
	 * MSS00012实例取得
	 *
	 * @return MSS00012实例
	 */
	public Mss00012TB getMSS00012TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00012Info> searchMSS00012();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00012Info searchMSS00012ByPK( Integer id)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Mss00012SearchCond cond) throws Exception;

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Mss00012Info> searchMSS00012(
			Mss00012SearchCond cond) throws Exception;

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00012Info> searchMSS00012(
			Mss00012SearchCond cond, int start,
			int count) throws Exception;

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00012Info registMSS00012(Mss00012Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00012Info updateMSS00012(Mss00012Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMSS00012ByPK( Integer id)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMSS00012(Mss00012Info instance)
		throws BLException;

}