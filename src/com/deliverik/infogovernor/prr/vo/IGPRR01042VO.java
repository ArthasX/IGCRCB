/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG602Info;

/**
 * @Description: 流程定义_参与者Vo
 * @Author  
 * @History 2009-8-23     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01042VO extends BaseVO implements Serializable {
	
	/** 用户角色ID */
	private Integer roleid;

	/** 用户角色名称 */
	private String rolename;
	
	/** 用户列表 */
	private List<IG602Info> lst_ProcessExecutorVW;
	
	/**
	 * 构造函数
	 * 
	 * @param roleid 用户角色ID
	 * @param rolename 用户角色名称
	 * @param lst_ProcessExecutorVW 用户列表
	 */
	public IGPRR01042VO(Integer roleid, String rolename) {
		this.roleid = roleid;
		this.rolename = rolename;
	}

	/**
	 * 用户角色ID取得
	 * @return 用户角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 用户角色名称取得
	 * @return 用户角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 用户列表取得
	 * 
	 * @return 用户列表
	 */
	public List<IG602Info> getLst_ProcessExecutorVW() {
		return lst_ProcessExecutorVW;
	}
	
	/**
	 * 添加执行人
	 * @param processExecutorVWInfo
	 */
	public void add(IG602Info processExecutorVWInfo) {
		if(lst_ProcessExecutorVW == null) {
			lst_ProcessExecutorVW = new ArrayList<IG602Info>();
		}
		lst_ProcessExecutorVW.add(processExecutorVWInfo);
	}

}
