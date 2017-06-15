package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG601Info;
import com.deliverik.framework.asset.model.condition.IG601SearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 机房信息业务逻辑
 * 
 */
public interface IG601BL extends BaseBL{

	/**
	 * 根据机房信息主键取得机房信息
	 * 
	 * @param eiid 机房信息主键
	 * @return 机房信息
	 */
	public IG601Info searchIG601InfoByKey(Integer eiid);

	/**
	 * 根据检索条件取得机房信息结果条数
	 * 
	 * @param cond 机房信息检索条件
	 * @return 机房信息结果条数
	 */
	public int getIG601InfoSearchCount(IG601SearchCond cond);

	/**
	 * 根据检索条件取得机房信息列表
	 * 
	 * @param cond 机房信息检索条件
	 * @return 机房信息检索结果列表
	 */
	public List<IG601Info> searchIG601Info(IG601SearchCond cond);
	
	/**
	 * 根据检索条件取得机房信息列表(分页查询用)
	 * 
	 * @param cond 机房信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 机房信息检索结果列表
	 */
	public List<IG601Info> searchIG601Info(IG601SearchCond cond, int start, int count);
	
	/**
	 * 新建机房信息处理
	 * 
	 * @param ig601Info 机房信息
	 * @return 机房ID
	 * @throws BLException
	 */
	public Integer registIG601Info(IG601Info ig601Info) throws BLException;

	/**
	 * 删除机房信息处理
	 * 
	 * @param ig601Info 删除的机房信息
	 * @return
	 * @throws BLException
	 */
	public void deleteIG601Info(IG601Info ig601Info) throws BLException;

	/**
	 * 根据机房主键删除机房信息处理
	 * 
	 * @param eiid 删除机房信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG601InfoByKey(Integer eiid) throws BLException;

	/**
	 * 变更机房信息处理
	 * 
	 * @param ig601Info 变更前的机房信息
	 * @throws BLException
	 */
	public void updateIG601Info(IG601Info ig601Info) throws BLException;


}
