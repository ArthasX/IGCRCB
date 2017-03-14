/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * 概述: 影响分析图显示业务逻辑接口
  * 功能描述: 影响分析图显示业务逻辑接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SocImpactGraphBL extends BaseBL {

	/**
	 * 影响分析图显示初始化处理(默认检索default域)
	 * 
	 * @param ei 选中资产信息
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 创建时间
	 * @return 显示用XML
	 * @throws BLException 
	 * 
	 */
	public String initGraph(IG688Info ei, Integer domainid,
			Integer domainversion, String createtime) throws BLException;
	
	/**
	 * 影响CI检索处理(默认检索default域)
	 * 
	 * @param eiid 选择的资产ID
	 * @param domainid 域ID
	 * @param syscoding 影响CI模型层次码
	 * @return 影响CI资产ID集合
	 * @throws BLException
	 */
	public List<Integer> searchImpactCI(Integer eiid, Integer domainid, String syscoding) throws BLException;

}