package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.asset.model.entity.IG117TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * 资产模型业务逻辑
 * </p>
 */
public interface IG117BL extends BaseBL{
	
	/**
	 * <p>
	 * 资产模型信息对象实例取得
	 * <p>
	 * 
	 * @return 资产模型信息对象实例
	 */

	public IG117TB getIG117TBInstance();

	/**
	 * 根据检索条件取得资产模型信息条数
	 * 
	 * @param cond 资产模型信息检索条件
	 * @return 资产模型信息条数
	 */
	public int getIG117InfoSearchCount(IG117SearchCond cond);

	/**
	 * 根据资产模型信息主键取得资产模型信息
	 * 
	 * @param eid 资产模型信息主键
	 * @return 资产模型信息
	 */
	public IG117Info searchIG117InfoByKey(Integer eid) throws BLException;
	
	/**
	 * 根据检索条件取得资产模型信息列表
	 * 
	 * @param cond 资产模型信息检索条件
	 * @return 资产模型信息列表
	 */
	public List<IG117Info> searchIG117Info(IG117SearchCond cond);

	/**
	 * 根据检索条件取得资产模型信息列表(分页查询用)
	 * 
	 * @param cond 资产模型信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产模型信息列表
	 */
	public List<IG117Info> searchIG117Info(IG117SearchCond cond, int start, int count);

	/**
	 * 新增资产模型信息处理
	 * 
	 * @param ig117Info 资产模型信息
	 * @param pareid 上级资产模型ID（"0":代表上级资产模型为根结点）
	 * @return 资产模型信息
	 * @throws BLException
	 */
	public IG117Info registIG117Info(IG117Info ig117Info,int pareid) throws BLException;

	/**
	 * 删除资产模型信息处理
	 * 
	 * @param ig117Info 资产模型信息
	 * @return
	 * @throws BLException
	 */
	public void deleteIG117Info(IG117Info ig117Info) throws BLException;

	/**
	 * 根据资产模型信息主键删除资产模型信息处理
	 * 
	 * @param eid 删除资产模型信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG117InfoByKey(Integer eid) throws BLException;

	/**
	 * 变更资产模型信息处理
	 * 
	 * @param ig117Info 资产模型信息
	 * @return 资产模型信息
	 * @throws BLException
	 */
	public IG117Info updateIG117Info(IG117Info ig117Info) throws BLException;
	
	/**
	 * 根据资产模型ID获取其全部的上级资产模型信息
	 * 
	 * @param eid 资产模型ID
	 * @return 上级资产模型信息列表
	 * @throws BLException
	 */
	public List<IG117Info> getParentNodes(Integer eid) throws BLException;
	
	/**
	 * 根据资产模型信息层次码获取其全部的上级资产模型信息（平台保留）
	 * 
	 * @param esyscoding 资产模型信息层次码
	 * @return 上级资产模型信息列表
	 */
	public List<IG117Info> getParentNodes(String esyscoding);

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
	public List<IG117Info> searchIG117Info(IG117SearchCond cond, String orderType);
}
