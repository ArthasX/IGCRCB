/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0206SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0206TB;

/**
  * 概述: 模板映射表业务逻辑接口
  * 功能描述: 模板映射表业务逻辑接口
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/10 将ReportTemplateMappingBL表名修改为SOC0206BL
  */
public interface SOC0206BL extends BaseBL {

	/**
	 * 模板映射表实例取得
	 *
	 * @return 模板映射表实例
	 */
	public SOC0206TB getSOC0206Instance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0206Info> searchSOC0206();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0206Info searchSOC0206ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0206SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0206Info> searchSOC0206(
			SOC0206SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0206Info> searchSOC0206(
			SOC0206SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0206Info registSOC0206(SOC0206Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0206Info updateSOC0206(SOC0206Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0206ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0206(SOC0206Info instance)
		throws BLException;
	/**根据ID删除*/
	public Integer deleteByRtId(Integer rtId);
}