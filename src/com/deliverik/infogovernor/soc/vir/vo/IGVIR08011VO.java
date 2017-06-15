package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;

/**
 * 虚拟资源统计结果	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR08011VO extends BaseVO implements Serializable{
	
	/**
	 * 虚拟资源统计结果（按用户）
	 */
	protected List<VIM03CountByUserVWInfo> vim03uList;

	/**
	 * 虚拟资源统计结果（按用户）取得
	 * @return vim03uList 虚拟资源统计结果（按用户）
	 */
	public List<VIM03CountByUserVWInfo> getVim03uList() {
		return vim03uList;
	}

	/**
	 * 虚拟资源统计结果（按用户）设定
	 * @param vim03uList 虚拟资源统计结果（按用户）
	 */
	public void setVim03uList(List<VIM03CountByUserVWInfo> vim03uList) {
		this.vim03uList = vim03uList;
	}
	
}


