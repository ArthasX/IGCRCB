/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;

/**
 * <p>
 * 资产属性取值范围数据业务逻辑
 * </p>
 */
public interface SOC0151BL extends BaseBL{
	
	/**
	 * <p>
	 * 资产属性取值范围数据信息对象实例取得
	 * <p>
	 * 
	 * @return 资产属性取值范围数据信息对象实例
	 */

	public SOC0151TB getConfigurationCodeDetailTBInstance();

	/**
	 * 根据资产属性取值范围信息主键取得资产属性取值范围信息
	 * 
	 * @param ccdid 资产属性取值范围信息主键
	 * @return 资产属性取值范围信息
	 */
	public SOC0151Info searchConfigurationCodeDetailByKey(Integer ccdid) throws BLException;

	/**
	 * 根据资产属性取值范围信息数据标识取得资产属性取值范围信息
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围信息
	 */
	public SOC0151Info searchConfigurationCodeDetailByKey(String ccdcategory);
	
	/**
	 * 根据检索条件取得资产属性取值范围信息列表(分页查询用)
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性取值范围信息列表
	 */
	public List<SOC0151Info> searchConfigurationCodeDetail(SOC0151SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得资产属性取值范围标识名称列表
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围标识名称检索结果列表
	 */
	public List<ConfigurationCodeDetailBean> searchConfigurationCodeDetailBean(SOC0151SearchCond cond);
	
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
	public SOC0151Info registConfigurationCodeDetail(SOC0151Info configurationcodedetail) throws BLException;
	
	/**
	 * 根据检索条件取得资产属性取值范围信息条数
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围信息条数
	 */
	public int getConfigurationCodeDetailSearchCount(SOC0151SearchCond cond);
	
	/**
	 * 根据检索条件取得资产属性取值范围信息列表
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围信息列表
	 */
	public List<SOC0151Info> searchConfigurationCodeDetail(SOC0151SearchCond cond);
	
	/**
	 * 删除资产属性取值范围信息处理
	 * 
	 * @param configurationCodeDetail 资产属性取值范围信息
	 * @return
	 * @throws BLException
	 */
	public void deleteConfigurationCodeDetail(SOC0151Info configurationCodeDetail) throws BLException;//必须有

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
	public SOC0151Info updateConfigurationCodeDetail(SOC0151Info configurationCodeDetail) throws BLException;//必须有
}
