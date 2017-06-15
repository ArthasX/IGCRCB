package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;

/**
 * <p>
 * 资产关系业务逻辑
 * </p>
 */

public interface SOC0119BL extends BaseBL{
	
	/**
	 * <p>
	 * 资产关系信息对象实例取得
	 * <p>
	 * 
	 * @return 资产关系信息对象实例
	 */
	public SOC0119TB getEntityItemRelationTBInstance();

	/**
	 * 根据检索条件取得资产关系信息条数
	 * 
	 * @param cond 资产关系信息检索条件
	 * @return 资产关系信息条数
	 */
	public int getEntityItemRelationSearchCount(SOC0119SearchCond cond);

	/**
	 * 根据资产关系信息主键取得资产关系信息
	 * 
	 * @param eid 资产关系信息主键
	 * @return 资产关系信息
	 */
	public SOC0119Info searchEntityItemRelationByKey(Integer eirid) throws BLException;
	
	/**
	 * 根据检索条件取得资产关系信息列表
	 * 
	 * @param cond 资产关系信息检索条件
	 * @return 资产关系信息列表
	 */
	public List<SOC0119Info> searchEntityItemRelation(SOC0119SearchCond cond);//必须有
	
	/**
	 * 根据检索条件取得资产关系信息列表(分页查询用)
	 * 
	 * @param cond 资产关系信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产关系信息列表
	 */
	public List<SOC0119Info> searchEntityItemRelation(SOC0119SearchCond cond, int start, int count);
	
	/**
	 * 新增资产关系信息处理
	 * 
	 * @param entityItemRelation 资产关系信息
	 * @return 资产关系信息
	 * @throws BLException
	 */
	public SOC0119Info registEntityItemRelation(SOC0119Info entityItemRelation) throws BLException;
	
	/**
	 * 删除资产关系信息处理
	 * 
	 * @param entityItemRelation 资产关系信息
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityItemRelation(SOC0119Info entityItemRelation) throws BLException;
	
	/**
	 * 根据资产关系信息主键删除资产模型信息处理
	 * 
	 * @param eid 资产关系信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityItemRelationByKey(Integer eid) throws BLException;//必须有


	/**
	 * 变更资产关系信息处理（平台保留）
	 * 
	 * @param entityItemRelation 资产关系信息
	 * @return 资产关系信息
	 * @throws BLException
	 */
	public SOC0119Info updateEntityItemRelation(SOC0119Info entityItemRelation) throws BLException;
	
	/**
	 * 资产关系信息版本升级处理
	 * 
	 * @param eiid 变更资产ID
	 * @param eiversion 关系表中资产最新大版本
	 * @param eismallversion 关闭表中资产最新小版本
	 * @param neweiversion 资产最新大版本
	 * @param neweismallversion 资产最新小版本
	 * @throws BLException 
	 */
	public void upgradeEntityItemRelation(Integer eiid, Integer eiversion, Integer eismallversion,
			Integer neweiversion, Integer neweismallversion) throws BLException;
	
	/**
	 * 资产关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0119Info> searchMaxEntityItemRelation(SOC0119SearchCond cond);
	
	public List<SOC0119Info> searchMaxEntityItemRelation(SOC0119SearchCond cond,int start,int count);
	
	/**
	 * 根据eiid删除关系数据
	 * @param eiid
	 */
	public void delByEiid(Integer eiid)throws BLException;
	/**
	 * 根据eiid删除关系数据
	 * @param eiid
	 */
	public void delByEiid(Integer eiid,String eirrelationcode)throws BLException;
	
	/**
	 * 根据eiid 查询与其相关的eiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchRelationByEiid(SOC0119SearchCond cond) throws BLException;
	
	
	/**
	 * 密码关联关系查询
	 * @param cond
	 * @return
	 */
	public List<Integer> searchCldeiidByPareiid(final SOC0119SearchCond cond)throws BLException;

	/**
	 * 合同-服务关系更新
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeEntityItemRelationOne(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion, String[] cldeiids)
			throws BLException ;

	/**
	 * 更新无模式关系
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeEntityItemRelationByJiFang(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion)
			throws BLException;
	
	/**
     * 根据检索条件取得资产关系信息列表
     * 
     * @param cond 资产关系信息检索条件
     * @return 资产关系信息检索结果列表
     */
    public List<SOC0119Info> searchEntityItemRelationBySql(SOC0119SearchCond cond,int start, int count);
    
    /**
   	 * 根据eiid_in 查询与其相关的eiid
   	 * @param eiid
   	 * @return
   	 */
   	public List<Integer> searchRelationByEiid_in(final SOC0119SearchCond cond);
}
