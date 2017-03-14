package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * <p>
 * 资产模型业务逻辑
 * </p>
 */
public interface SOC0117BL extends BaseBL{
	
	/**
	 * <p>
	 * 资产模型信息对象实例取得
	 * <p>
	 * 
	 * @return 资产模型信息对象实例
	 */

	public SOC0117TB getEntityTBInstance();

	/**
	 * 根据检索条件取得资产模型信息条数
	 * 
	 * @param cond 资产模型信息检索条件
	 * @return 资产模型信息条数
	 */
	public int getEntitySearchCount(SOC0117SearchCond cond);

	/**
	 * 根据资产模型信息主键取得资产模型信息
	 * 
	 * @param eid 资产模型信息主键
	 * @return 资产模型信息
	 */
	public SOC0117Info searchEntityByKey(String eid) throws BLException;
	
	/**
	 * 根据检索条件取得资产模型信息列表
	 * 
	 * @param cond 资产模型信息检索条件
	 * @return 资产模型信息列表
	 */
	public List<SOC0117Info> searchEntity(SOC0117SearchCond cond);

	/**
	 * 根据检索条件取得资产模型信息列表(分页查询用)
	 * 
	 * @param cond 资产模型信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产模型信息列表
	 */
	public List<SOC0117Info> searchEntity(SOC0117SearchCond cond, int start, int count);

	/**
	 * 新增资产模型信息处理
	 * 
	 * @param entity 资产模型信息
	 * @param pareid 上级资产模型ID（"0":代表上级资产模型为根结点）
	 * @return 资产模型信息
	 * @throws BLException
	 */
	public SOC0117Info registEntity(SOC0117Info entity,String pareid) throws BLException;

	/**
	 * 删除资产模型信息处理
	 * 
	 * @param entity 资产模型信息
	 * @return
	 * @throws BLException
	 */
	public void deleteEntity(SOC0117Info entity) throws BLException;

	/**
	 * 根据资产模型信息主键删除资产模型信息处理
	 * 
	 * @param eid 删除资产模型信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityByKey(String eid) throws BLException;

	/**
	 * 变更资产模型信息处理
	 * 
	 * @param entity 资产模型信息
	 * @return 资产模型信息
	 * @throws BLException
	 */
	public SOC0117Info updateEntity(SOC0117Info entity) throws BLException;
	
	/**
	 * 根据资产模型ID获取其全部的上级资产模型信息
	 * 
	 * @param eid 资产模型ID
	 * @return 上级资产模型信息列表
	 * @throws BLException
	 */
	public List<SOC0117Info> getParentNodes(String eid) throws BLException;
	
	/**
	 * 根据资产模型信息层次码获取其全部的上级资产模型信息（平台保留）
	 * 
	 * @param esyscoding 资产模型信息层次码
	 * @return 上级资产模型信息列表
	 */
	public List<SOC0117Info> getParentNodesByEsyscoding(String esyscoding);

	/**
	 * 根据检索条件取得资产信息列表
	 *  (按照资产信息层次码排序)
	 * 
	 * @param cond 资产信息检索条件
	 * @param orderType 检索结果列表排序方式
	 * 		  "assetdomain" : 按照资产信息层次码升序排序
	 * 
	 * @return 资产信息列表
	 */
	public List<SOC0117Info> searchEntity(SOC0117SearchCond cond, String orderType);
	/**
	 * 查询模型下资产数量
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNum(String rootEsyscoding);

	/**
	 *  获取可导出一级资产列表
	 *
	 * @param cond 查询条件
	 */
	public List<SOC0117Info> searchEntityForExport(SOC0117SearchCond socEntitySearchCond);
	/**
	 * 查询模型下资产数量（新版应急资源专用）
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNumNEW(String rootErcode);
}
