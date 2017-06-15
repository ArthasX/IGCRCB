/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.asset.model.IG545Bean;
import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.asset.model.entity.IG545TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * 资产属性取值范围数据业务逻辑
 * </p>
 */
public interface IG545BL extends BaseBL{
	
	/**
	 * <p>
	 * 资产属性取值范围数据信息对象实例取得
	 * <p>
	 * 
	 * @return 资产属性取值范围数据信息对象实例
	 */

	public IG545TB getIG545TBInstance();

	/**
	 * 根据资产属性取值范围信息主键取得资产属性取值范围信息
	 * 
	 * @param ccdid 资产属性取值范围信息主键
	 * @return 资产属性取值范围信息
	 */
	public IG545Info searchIG545InfoByKey(Integer ccdid) throws BLException;

	/**
	 * 根据资产属性取值范围信息数据标识取得资产属性取值范围信息
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围信息
	 */
	public IG545Info searchIG545InfoByKey(String ccdcategory);
	
	/**
	 * 根据检索条件取得资产属性取值范围信息列表(分页查询用)
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性取值范围信息列表
	 */
	public List<IG545Info> searchIG545Info(IG545SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得资产属性取值范围标识名称列表
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围标识名称检索结果列表
	 */
	public List<IG545Bean> searchIG545Bean(IG545SearchCond cond);
	
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
	 * @param ig545Info 保存的资产属性取值范围信息
	 * @return 资产属性取值范围信息
	 * @throws BLException
	 */
	public IG545Info registIG545Info(IG545Info ig545Info) throws BLException;
	
	/**
	 * 根据检索条件取得资产属性取值范围信息条数
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围信息条数
	 */
	public int getIG545InfoSearchCount(IG545SearchCond cond);
	
	/**
	 * 根据检索条件取得资产属性取值范围信息列表
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围信息列表
	 */
	public List<IG545Info> searchIG545Info(IG545SearchCond cond);
	
	/**
	 * 删除资产属性取值范围信息处理
	 * 
	 * @param ig545Info 资产属性取值范围信息
	 * @return
	 * @throws BLException
	 */
	public void deleteIG545Info(IG545Info ig545Info) throws BLException;//必须有

	/**
	 * 根据资产属性取值范围信息主键删除资产属性取值范围信息处理
	 * 
	 * @param ccdid 资产属性取值范围信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG545InfoByKey(Integer ccdid) throws BLException;//必须有

	/**
	 * 变更资产属性取值范围信息处理
	 * 
	 * @param ig545Info 资产属性取值范围信息
	 * @return 资产属性取值范围信息
	 * @throws BLException
	 */
	public IG545Info updateIG545Info(IG545Info ig545Info) throws BLException;//必须有
}
