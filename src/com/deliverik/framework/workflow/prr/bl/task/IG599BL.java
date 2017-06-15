/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;

/**
 * <p>
 * 流程变量信息业务逻辑
 * </p>
 */

public interface IG599BL extends BaseBL {


	/**
	 * 保存流程变量参数值
	 * @param 流程变量参数值集合
	 * @throws BLException
	 */
	public void registIG599Infos(List<IG599Info> ig599InfoList) throws BLException;
	
	/**
	 * 保存流程变量参数值
	 * @param 流程变量参数值
	 * @throws BLException
	 */
	public void updateIG599Info(IG599Info pi) throws BLException;
	
	/**
	 * 保存流程变量参数值
	 * @param 流程变量参数值集合
	 * @throws BLException
	 */
	public void updateIG599Infos(List<IG599Info> ig599InfoList) throws BLException;

	/**
	 * 根据流程记录ID获取流程变量参数值信息集合
	 * @param 流程变量参数值信息集合
	 * @throws BLException
	 */
	public List<IG599Info> searchIG599InfosByKey(Integer processId);
	
	/**
	 * 根据流程变量ID获取流程变量参数值信息集合
	 * @param piid 流程变量ID
	 * @throws BLException 
	 */
	public IG599Info searchIG599InfoByPiid(Integer piid) throws BLException;
	
	/**
	 * 获取附件实例
	 * 
	 * @return ProcessInfoTB
	 * @throws BLException
	 */
	
	public IG599TB getIG599TBInstance();
	
	/**
	 * 保存流程变量参数值（平台保留）
	 * @param 流程变量参数值集合
	 * @throws BLException
	 */
	public List<IG599Info> saveOrUpdIG599Infos(List<IG599Info> ig599InfoList) throws BLException;
	
	/**
	 * 保存流程变量参数值（平台保留）
	 * @param 流程变量参数值集合
	 * @throws BLException
	 */
	public IG599Info saveIG599Info(IG599Info ig599Info) throws BLException;
	
	/**
	 * 根据查询条件获取流程变量参数值信息集合
	 * @param 流程变量参数值信息集合
	 * @throws BLException
	 */
	public List<IG599Info> searchIG599InfosByCond(IG599SearchCond cond);
	
	/**
	 * 自定义流程关闭状态变量信息集合取得
	 * （缺省变量和定义变量并集，普通模式按角色过滤，OA模式按用户ID过滤）
	 * @param 流程ID
	 * @param 流程定义ID
	 * @param 用户ID
	 * @return 流程变量参数值信息集合
	 */
	public List<IG599Info> searchIG599InfoForClose(Integer prid, String pdid, String userid);
	
	/**
	 * 自定义流程关闭状态变量信息集合取得
	 * （缺省变量和定义变量并集，普通模式按角色过滤，OA模式按用户ID过滤）
	 * @param 流程ID
	 * @param 流程定义ID
	 * @param 用户ID
	 * @return 流程变量参数值信息集合
	 */
	public List<IG599Info> searchIG599InfoForSee(Integer prid, String pdid, String userid);
	
	/**
	 * 功能：查询当前最大流水号
	 * @param prserialnum 流水号
	 * @param label 名称
	 * @return 最大流水号
	 */
	public String searchMaxSerialnum(String serialnum, String label);
}
