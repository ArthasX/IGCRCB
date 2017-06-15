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
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * @Description: 流程定义_参与者Vo
 * @Author  
 * @History 2009-8-23     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01031VO extends BaseVO implements Serializable {
	
	/** 角色集合 */
	private List<Role> roleList;
	
	/** 可分派角色 */
	private List<IGPRR01032VO> lst_IGPRR01032VO;
	
	/** 主办部门 */
	protected List<LabelValueBean> labelList;
	
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
	public List<IGPRR01032VO> getLst_IGPRR01032VO() {
		return lst_IGPRR01032VO;
	}

	/**
	 * 可分派角色设定
	 * 
	 * @param lst_IGPRR01032VO 可分派角色
	 */
	public void setLst_IGPRR01032VO(Map<Role, List<UserRoleInfo>> map_ParticipantDefToBeAssign) {
		labelList = new ArrayList<LabelValueBean>();
		if(map_ParticipantDefToBeAssign != null) {
			Set<Map.Entry<Role, List<UserRoleInfo>>> set = map_ParticipantDefToBeAssign.entrySet();
			if(set.size() > 0) {
				this.lst_IGPRR01032VO = new ArrayList<IGPRR01032VO>();
				labelList.add(new LabelValueBean("", ""));
				Map.Entry<Role, List<UserRoleInfo>> entry = null;
				for(Iterator<Map.Entry<Role, List<UserRoleInfo>>> iter = set.iterator();iter.hasNext();){
					entry = iter.next();
					labelList.add(new LabelValueBean(entry.getKey().getRolename(),entry.getKey().getRoleid().toString()));
					this.lst_IGPRR01032VO.add(new IGPRR01032VO(entry.getKey(), entry.getValue()));
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

}
