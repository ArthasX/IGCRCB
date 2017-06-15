package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;

/**
 * ��Դռ�����	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR12011VO extends BaseVO implements Serializable{
	
	/** vCenter��Ϣ*/
	protected VIM01Info vim01Info;

	/** host����*/
	protected List<Host> hostList;

	/**
	 * vCenter��Ϣȡ��
	 * @return vim01Info vCenter��Ϣ
	 */
	public VIM01Info getVim01Info() {
		return vim01Info;
	}

	/**
	 * vCenter��Ϣ�趨
	 * @param vim01Info vCenter��Ϣ
	 */
	public void setVim01Info(VIM01Info vim01Info) {
		this.vim01Info = vim01Info;
	}

	/**
	 * host����ȡ��
	 * @return hostList host����
	 */
	public List<Host> getHostList() {
		return hostList;
	}

	/**
	 * host�����趨
	 * @param hostList host����
	 */
	public void setHostList(List<Host> hostList) {
		this.hostList = hostList;
	}
	
}


