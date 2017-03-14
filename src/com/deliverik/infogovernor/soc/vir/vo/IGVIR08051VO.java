package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;

/**
 * 虚拟资源统计结果	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR08051VO extends BaseVO implements Serializable{
	/**
	 * 虚拟资源统计结果（按用户）
	 */
	protected List<VIM03CountByProjVWInfo> vim03pList;

	/**
	 * 虚拟资源统计结果（按用户）取得
	 * @return vim03pList 虚拟资源统计结果（按用户）
	 */
	public List<VIM03CountByProjVWInfo> getVim03pList() {
		return vim03pList;
	}

	/**
	 * 虚拟资源统计结果（按用户）设定
	 * @param vim03pList 虚拟资源统计结果（按用户）
	 */
	public void setVim03pList(List<VIM03CountByProjVWInfo> vim03pList) {
		this.vim03pList = vim03pList;
	}
	
}


