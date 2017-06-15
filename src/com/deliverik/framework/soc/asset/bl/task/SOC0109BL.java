package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;

/**
 * <p>
 * 资产模型属性业务逻辑
 * </p>
 */
public interface SOC0109BL extends BaseBL{
	
	/**
	 * <p>
	 * 资产模型属性信息对象实例取得
	 * <p>
	 * 
	 * @return 资产模型属性信息对象实例
	 */

	public SOC0109TB getConfigurationTBInstance();

	/**
	 * 根据资产模型属性主键取得资产模型属性信息
	 * 
	 * @param cid 资产模型属性主键
	 * @return 资产模型属性信息
	 */
	public SOC0109Info searchConfigurationByKey(String cid) throws BLException;
	
	/**
	 * 根据检索条件取得资产模型属性信息条数
	 * 
	 * @param cond 资产模型属性信息检索条件
	 * @return 资产模型属性信息条数
	 */
	public int getConfigurationSearchCount(SOC0109SearchCond cond);

	/**
	 * 根据检索条件取得资产模型属性信息列表
	 * 
	 * @param cond 资产模型属性信息检索条件
	 * @return 资产模型属性信息列表
	 */
	public List<SOC0109Info> searchConfiguration(SOC0109SearchCond cond);

	/**
	 * 根据检索条件取得资产模型属性信息列表(分页查询用)
	 * 
	 * @param cond 资产模型属性信息检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 资产模型属性信息列表
	 */
	public List<SOC0109Info> searchConfiguration(SOC0109SearchCond cond, int start, int count);

	/**
	 * 根据资产模型ID取得其包括继承属性的所有信息列表
	 * 
	 * @param eid 模型属性ID
	 * @return 资产模型属性信息列表
	 */
	public List<SOC0109Info> searchConfigurationByEid(String eid) throws BLException;
	
	/**
	 * 新建资产模型属性信息处理
	 * 
	 * @param configuration 资产模型属性信息
	 * @return 资产模型属性信息
	 * @throws BLException
	 */
	public SOC0109Info registConfiguration(SOC0109Info configuration) throws BLException;

	/**
	 * 删除资产模型属性信息处理
	 * 
	 * @param configuration 资产模型属性信息
	 * @return
	 * @throws BLException
	 */
	public void deleteConfiguration(SOC0109Info configuration) throws BLException;

	/**
	 * 根据资产模型属性主键删除资产模型属性信息处理
	 * 
	 * @param cid 资产模型属性信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteConfigurationByKey(String cid) throws BLException;

	/**
	 * 变更资产模型属性信息处理
	 * 
	 * @param configuration 资产模型属性信息
	 * @return 资产模型属性信息
	 * @throws BLException
	 */
	public SOC0109Info updateConfiguration(SOC0109Info configuration) throws BLException;

	/**
	 * 取得各资产模型的模型属性信息（平台保留）
	 * 
	 * @param list 资产模型集合
	 * @param cseq 资产模型属性是否显示标识
	 *            1:显示属性
	 *            0:不可显示属性
	 *            null:全部属性
	 * @return 各资产模型的模型属性信息
	 */
	public Map<String,List<SOC0109Info>> searchConfiguration(List<SOC0117Info> list,Integer cseq);
	
}
