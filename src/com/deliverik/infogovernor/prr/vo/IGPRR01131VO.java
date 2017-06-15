/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prr.model.IG602Info;

/**
 * @Description: 流程定义_参与者Vo
 * @Author  
 * @History 2009-8-23     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01131VO extends BaseVO implements Serializable {
	
	/** 角色集合 */
	private List<Role> roleList;
	
	/** 可分派角色 */
	private List<IGPRR01132VO> lst_IGPRR01132VO;
	
	/** 主办部门 */
	protected List<LabelValueBean> labelList;
	
	/** 可分派机构 */
	protected List<Organization> org_List;
	
	/**
	 * 角色集合取得
	 * @return 角色集合
	 */
	public List<Role> getRoleList() {
		return roleList;
	}
	
	/**
	 * 角色集合设定
	 * @param roleList角色集合
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * 可分派角色取得
	 * 
	 * @return 可分派角色
	 */
	public List<IGPRR01132VO> getLst_IGPRR01132VO() {
		return lst_IGPRR01132VO;
	}

	/**
	 * 可分派角色设定
	 * 
	 * @param lst_IGPRR01132VO 可分派角色
	 */
	public void setLst_IGPRR01132VO(Map<Role, List<IG602Info>> map_ParticipantToBeAssign) {
		labelList = new ArrayList<LabelValueBean>();
		if(map_ParticipantToBeAssign != null) {
			Set<Map.Entry<Role, List<IG602Info>>> set = map_ParticipantToBeAssign.entrySet();
			if(set.size() > 0) {
				this.lst_IGPRR01132VO = new ArrayList<IGPRR01132VO>();
				labelList.add(new LabelValueBean("", ""));
				Map.Entry<Role, List<IG602Info>> entry = null;
				for(Iterator<Map.Entry<Role, List<IG602Info>>> iter = set.iterator();iter.hasNext();){
					entry = iter.next();
					labelList.add(new LabelValueBean(entry.getKey().getRolename(),entry.getKey().getRoleid().toString()));
					this.lst_IGPRR01132VO.add(new IGPRR01132VO(entry.getKey(), entry.getValue()));
				}
			}
		}
	}
	
	/**
	 * 主办部门取得
	 * 
	 * @return 主办部门
	 */
	public List<LabelValueBean> getLabelList() {
		return labelList;
	}
	
	/**
	 * 主办部门设定
	 *
	 * @param labelList 主办部门
	 */
	public void setLabelList(List<LabelValueBean> labelList) {
		this.labelList = labelList;
	}
	
	/**
	 * 可分派机构取得
	 * @return 可分派机构
	 */
	public List<Organization> getOrg_List() {
		return org_List;
	}

	/**
	 * 可分派机构设定
	 * @param org_List 可分派机构
	 */
	public void setOrg_List(List<Organization> org_List) {
		this.org_List = org_List;
	}

}
