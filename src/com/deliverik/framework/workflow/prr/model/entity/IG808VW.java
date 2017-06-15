/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG808Info;

/**
 * <p>概述:首页上按部门统计工作数量视图实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：宋海洋 2010/11/13</p>
 */
@SuppressWarnings("serial")
@Entity
public class IG808VW implements Serializable,
	Cloneable, IG808Info {
	@Id
	/** 机构名*/
	protected String orgname;
	/** 工作数量*/
	protected String workCount;
	
	/**
	 * 功能：工作数量取得
	 * @return workCount 工作数量
	 */
	public String getWorkCount() {
		return workCount;
	}

	/**
	 * 功能：工作数量设定
	 * @param workCount 工作数量
	 */
	public void setWorkCount(String workCount) {
		this.workCount = workCount;
	}

	/**
	 * 功能：机构名称取得
	 * @return orgname 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 功能：机构名称设定
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}


	public boolean equals(Object obj) {
		if (!(obj instanceof IG808VW))
			return false;

		return true;
	}

}
