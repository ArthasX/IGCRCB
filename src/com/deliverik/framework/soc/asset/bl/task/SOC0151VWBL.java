/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0151VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0151VWSearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0151VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0151VWPK;

/**
  * 概述: SOC0151VW业务逻辑接口
  * 功能描述: SOC0151VW业务逻辑接口
  * 创建记录: 2016/06/23
  * 修改记录: 
  */
public interface SOC0151VWBL extends BaseBL {

	/**
	 * SOC0151VW实例取得
	 *
	 * @return SOC0151VW实例
	 */
	public SOC0151VW getSOC0151VWInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0151VWInfo> searchSOC0151VW();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0151VWInfo searchSOC0151VWByPK(SOC0151VWPK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0151VWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0151VWInfo> searchSOC0151VW(
			SOC0151VWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0151VWInfo> searchSOC0151VW(
			SOC0151VWSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0151VWInfo registSOC0151VW(SOC0151VWInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0151VWInfo updateSOC0151VW(SOC0151VWInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0151VWByPK(SOC0151VWPK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0151VW(SOC0151VWInfo instance)
		throws BLException;
	/**
	 * <p>
	 * 资产属性取值范围数据信息对象实例取得
	 * <p>
	 * 
	 * @return 资产属性取值范围数据信息对象实例
	 */

	public SOC0151VW getConfigurationCodeDetailTBInstance();

	/**
	 * 根据资产属性取值范围信息主键取得资产属性取值范围信息
	 * 
	 * @param ccdid 资产属性取值范围信息主键
	 * @return 资产属性取值范围信息
	 */
//	public SOC0151VWInfo searchConfigurationCodeDetailByKey(Integer ccdid) throws BLException;

	/**
	 * 根据资产属性取值范围信息数据标识取得资产属性取值范围信息
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围信息
	 */
//	public SOC0151VWInfo searchConfigurationCodeDetailByKey(String ccdcategory);
	
	/**
	 * 根据检索条件取得资产属性取值范围信息列表(分页查询用)
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性取值范围信息列表
	 */
	public List<SOC0151VWInfo> searchConfigurationCodeDetail(SOC0151VWSearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得资产属性取值范围标识名称列表
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围标识名称检索结果列表
	 */
	public List<ConfigurationCodeDetailBean> searchConfigurationCodeDetailBean(SOC0151VWSearchCond cond);
	
	/**
	 * 根据数据标识取得资产属性取值范围标签对象
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围标签对象列表
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ccdcategory, Integer id);

	/**
	 * 保存资产属性取值范围信息处理
	 * 
	 * @param configurationcodedetail 保存的资产属性取值范围信息
	 * @return 资产属性取值范围信息
	 * @throws BLException
	 */
	public SOC0151VWInfo registConfigurationCodeDetail(SOC0151VWInfo configurationcodedetail) throws BLException;
	
	/**
	 * 根据检索条件取得资产属性取值范围信息条数
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围信息条数
	 */
	public int getConfigurationCodeDetailSearchCount(SOC0151VWSearchCond cond);
	
	/**
	 * 根据检索条件取得资产属性取值范围信息列表
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围信息列表
	 */
	public List<SOC0151VWInfo> searchConfigurationCodeDetail(SOC0151VWSearchCond cond);
	
	/**
	 * 删除资产属性取值范围信息处理
	 * 
	 * @param configurationCodeDetail 资产属性取值范围信息
	 * @return
	 * @throws BLException
	 */
	public void deleteConfigurationCodeDetail(SOC0151VWInfo configurationCodeDetail) throws BLException;//必须有

}