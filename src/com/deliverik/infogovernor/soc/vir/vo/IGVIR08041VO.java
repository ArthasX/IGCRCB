package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * 虚拟资源统计结果	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR08041VO extends BaseVO implements Serializable{
	
	/**
	 * 虚拟资源统计结果（某一用户）
	 */
	protected List<VIM03Info> oneVim03oList;
	/**
	 * 机构信息
	 */
	protected Organization orgbean;
	
	/**
	 * 虚拟资源统计结果（某一用户）取得
	 * @return oneVim03oList 虚拟资源统计结果（某一用户）
	 */
	public List<VIM03Info> getOneVim03oList() {
		return oneVim03oList;
	}
	/**
	 * 虚拟资源统计结果（某一用户）设定
	 * @param oneVim03oList 虚拟资源统计结果（某一用户）
	 */
	public void setOneVim03oList(List<VIM03Info> oneVim03oList) {
		this.oneVim03oList = oneVim03oList;
	}
	/**
	 * 机构信息取得
	 * @return orgbean 机构信息
	 */
	public Organization getOrgbean() {
		return orgbean;
	}
	/**
	 * 机构信息设定
	 * @param orgbean 机构信息
	 */
	public void setOrgbean(Organization orgbean) {
		this.orgbean = orgbean;
	}
	
}


