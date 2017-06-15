/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCond;

/**
 * 流程参与者定义业务逻辑
 *
 */
public interface IG222BL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getIG222InfoSearchCount(IG222SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param ppdid 流程参与者ID
	 * @return 流程参与者信息
	 */
	public IG222Info searchIG222InfoByKey(String ppdid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部流程参与者信息
	 */
	public List<IG222Info> searchIG222InfoAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG222Info> searchIG222Info(IG222SearchCond cond);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG222Info> searchIG222Info(IG222SearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param IG222 登录数据
	 * @return 流程参与者信息
	 */
	public IG222Info registIG222Info(IG222Info processParticipantDef) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param ppdid 流程参与者ID
	 * @return 流程参与者定义信息
	 */
	public IG222Info deleteIG222Info(String ppdid) throws BLException;
	
	/**
	 * 删除处理
	 * 
	 * @param IG222 流程参与者
	 * @return
	 */
	public void deleteIG222Info(IG222Info processParticipantDef) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param IG222 变更数据
	 * @return 流程参与者信息
	 */
	public IG222Info updateIG222Info(IG222Info processParticipantDef) throws BLException;
	
	/**
	 * 获取指定用户具有的发起流程的角色
	 * @param userid 用户ID
	 * @param pdid 流程定义ID
	 * @return 发起角色下拉列表
	 */
	public List<LabelValueBean> searchInitProcessParticipantRole(String userid, String pdid);
	
	/**
	 * 获取发起流程的角色(运维计划用)
	 * @param pdid 流程定义ID
	 * @return 发起角色下拉列表
	 */
	public List<LabelValueBean> searchInitProcessParticipantRoleAll(String pdid);
	
		/**
	 * PPDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PPDID主键值
	 */
	public String getPpdidSequenceNextValue(String psdid);
	
	/**
	 * 参与者可视按钮查询
	 * 
	 * @param psdid 状态ID
	 * @param roleid 角色ID
	 * @return 可视按钮列表
	 */
	public List<IG309Info> searchVisibleButton(String psdid, Integer roleid);
	
	/**
	 * 同角色所有人提交跃迁按钮查询（普通权限）
	 * 
	 * @param psdid 状态ID
	 * @return 按钮列表
	 */
	public Map<String, String> searchRoleCommitNormalAuth(String psdid);
	
	/**
	 * 同角色所有人提交跃迁按钮查询（缺省权限）
	 * 
	 * @param psdid 状态ID
	 * @return 按钮列表
	 */
	public List<String> searchRoleCommitDefaultAuth(String psdid);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG222Info> searchIG222InfoRun(IG222SearchCond cond);
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 * @throws BLException
	 */
	public StringBuffer exportXML(String pdid) throws BLException;
	
	/**
	 * XML脚本导入处理
	 *
	 * @param element Element
	 * @throws BLException
	 */
	public void importXML(Element element) throws BLException;

}
