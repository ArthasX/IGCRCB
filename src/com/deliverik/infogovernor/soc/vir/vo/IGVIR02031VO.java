package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * ���������ʾ	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR02031VO extends BaseVO implements Serializable{
	
	/** �����Ϣ */
    protected List<VIM03Info> vim03List;
    
    /** pid */
    protected String pid;

	/**
	 * pidȡ��
	 * @return pid pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * pid�趨
	 * @param pid pid
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * �����Ϣȡ��
	 * @return vim03List �����Ϣ
	 */
	public List<VIM03Info> getVim03List() {
		return vim03List;
	}

	/**
	 * �����Ϣ�趨
	 * @param vim03List �����Ϣ
	 */
	public void setVim03List(List<VIM03Info> vim03List) {
		this.vim03List = vim03List;
	}
}


