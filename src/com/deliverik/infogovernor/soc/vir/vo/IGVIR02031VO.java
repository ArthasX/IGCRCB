package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * 部署进度显示	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR02031VO extends BaseVO implements Serializable{
	
	/** 虚机信息 */
    protected List<VIM03Info> vim03List;
    
    /** pid */
    protected String pid;

	/**
	 * pid取得
	 * @return pid pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * pid设定
	 * @param pid pid
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * 虚机信息取得
	 * @return vim03List 虚机信息
	 */
	public List<VIM03Info> getVim03List() {
		return vim03List;
	}

	/**
	 * 虚机信息设定
	 * @param vim03List 虚机信息
	 */
	public void setVim03List(List<VIM03Info> vim03List) {
		this.vim03List = vim03List;
	}
}


