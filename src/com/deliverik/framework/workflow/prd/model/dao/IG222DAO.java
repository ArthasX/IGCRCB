/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCond;

/**
 * 
 * 流程参与者定义DAO接口
 * @author maozhipeng@deliverik.com
 *
 */
public interface IG222DAO extends BaseHibernateDAO<IG222Info> {
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG222Info> findAll();

	/**
	 * 主键检索处理
	 * @param psdid 主键
	 * @return 检索结果
	 */
	public IG222Info findByPK(Serializable ppdid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG222SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG222Info> findByCond(final IG222SearchCond cond, final int start, final int count);
	
	/**
	 * 获取指定用户具有的发起流程的角色
	 * @param userid 用户ID
	 * @param pdid 流程定义ID
	 * @return 发起角色下拉列表
	 */
	
	public List<LabelValueBean> searchInitProcessParticipantRole(String userid, String pdid);
	
	/**
	 * 获取发起流程的角色(运维计划)
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
	public List<IG309Info> searchVisibleButton(final String psdid, final Integer roleid);
	
	/**
	 * 参与者缺省可视按钮查询
	 * 
	 * @param psdid 状态ID
	 * @return 缺省可视按钮列表
	 */
	public List<IG309Info> searchDefaultVisibleButton(final String psdid);
	
	/**
	 * 同角色所有人提交跃迁按钮查询（普通权限）
	 * 
	 * @param psdid 状态ID
	 * @return 按钮列表
	 */
	public Map<String, String> searchRoleCommitNormalAuth(final String psdid);
	
	/**
	 * 同角色所有人提交跃迁按钮查询（缺省权限）
	 * 
	 * @param psdid 状态ID
	 * @return 按钮列表
	 */
	public List<String> searchRoleCommitDefaultAuth(final String psdid);
	
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG222Info> findByCondRun(final IG222SearchCond cond);
	
}
