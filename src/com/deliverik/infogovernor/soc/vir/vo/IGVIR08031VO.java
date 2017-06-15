package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;

/**
 *  虚拟资源统计结果	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR08031VO extends BaseVO implements Serializable{
	
	/**
	 * 虚拟资源统计结果（按用户）
	 */
	protected List<VIM03CountByOrgVWInfo> vim03oList;

	/**
	 * 虚拟资源统计结果（按用户）取得
	 * @return vim03oList 虚拟资源统计结果（按用户）
	 */
	public List<VIM03CountByOrgVWInfo> getVim03oList() {
		return vim03oList;
	}

	/**
	 * 虚拟资源统计结果（按用户）设定
	 * @param vim03oList 虚拟资源统计结果（按用户）
	 */
	public void setVim03oList(List<VIM03CountByOrgVWInfo> vim03oList) {
		this.vim03oList = vim03oList;
	}

}


