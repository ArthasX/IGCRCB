package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;

/**
 * vCenter�������	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR07011VO extends BaseVO implements Serializable{
	
	/** vCenter������� */
	protected List<VIM01Info> vim01InfoList;

	/**
	 * vCenter�������ȡ��
	 * @return vim01InfoList vCenter�������
	 */
	public List<VIM01Info> getVim01InfoList() {
		return vim01InfoList;
	}

	/**
	 * vCenter��������趨
	 * @param vim01InfoList vCenter�������
	 */
	public void setVim01InfoList(List<VIM01Info> vim01InfoList) {
		this.vim01InfoList = vim01InfoList;
	}

}


