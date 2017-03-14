/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetail;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.condition.ConfigurationCodeDetailSearchCond;
import com.deliverik.framework.soc.asset.model.entity.ConfigurationCodeDetailTB;

/**
 * <p>
 * 资产属性取值范围数据业务逻辑
 * </p>
 */
public interface ConfigurationCodeDetailBL extends BaseBL{
	
	/**
	 * <p>
	 * 资产属性取值范围数据信息对象实例取得
	 * <p>
	 * 
	 * @return 资产属性取值范围数据信息对象实例
	 */

	public ConfigurationCodeDetailTB getConfigurationCodeDetailTBInstance();

	/**
	 * 根据资产属性取值范围信息主键取得资产属性取值范围信息
	 * 
	 * @param ccdid 资产属性取值范围信息主键
	 * @return 资产属性取值范围信息
	 */
	public ConfigurationCodeDetail searchConfigurationCodeDetailByKey(Integer ccdid) throws BLException;

	/**
	 * 根据资产属性取值范围信息数据标识取得资产属性取值范围信息
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围信息
	 */
	public ConfigurationCodeDetail searchConfigurationCodeDetailByKey(String ccdcategory);
	
	/**
	 * 根据检索条件取得资产属性取值范围信息列表(分页查询用)
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性取值范围信息列表
	 */
	public List<ConfigurationCodeDetail> searchConfigurationCodeDetail(ConfigurationCodeDetailSearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得资产属性取值范围标识名称列表
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围标识名称检索结果列表
	 */
	public List<ConfigurationCodeDetailBean> searchConfigurationCodeDetailBean(ConfigurationCodeDetailSearchCond cond);
	
	/**
	 * 根据数据标识取得资产属性取值范围标签对象
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围标签对象列表
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ccdcategory);

	/**
	 * 保存资产属性取值范围信息处理
	 * 
	 * @param configurationcodedetail 保存的资产属性取值范围信息
	 * @return 资产属性取值范围信息
	 * @throws BLException
	 */
	public ConfigurationCodeDetail registConfigurationCodeDetail(ConfigurationCodeDetail configurationcodedetail) throws BLException;
	
	/**
	 * 根据检索条件取得资产属性取值范围信息条数
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围信息条数
	 */
	public int getConfigurationCodeDetailSearchCount(ConfigurationCodeDetailSearchCond cond);
	
	/**
	 * 根据检索条件取得资产属性取值范围信息列表
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围信息列表
	 */
	public List<ConfigurationCodeDetail> searchConfigurationCodeDetail(ConfigurationCodeDetailSearchCond cond);
	
	/**
	 * 删除资产属性取值范围信息处理
	 * 
	 * @param configurationCodeDetail 资产属性取值范围信息
	 * @return
	 * @throws BLException
	 */
	public void deleteConfigurationCodeDetail(ConfigurationCodeDetail configurationCodeDetail) throws BLException;//必须有

	/**
	 * 根据资产属性取值范围信息主键删除资产属性取值范围信息处理
	 * 
	 * @param ccdid 资产属性取值范围信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteConfigurationCodeDetailByKey(Integer ccdid) throws BLException;//必须有

	/**
	 * 变更资产属性取值范围信息处理
	 * 
	 * @param configurationCodeDetail 资产属性取值范围信息
	 * @return 资产属性取值范围信息
	 * @throws BLException
	 */
	public ConfigurationCodeDetail updateConfigurationCodeDetail(ConfigurationCodeDetail configurationCodeDetail) throws BLException;//必须有
}
