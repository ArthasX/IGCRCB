package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;

/**
 * ������Դͳ�ƽ��	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR08051VO extends BaseVO implements Serializable{
	/**
	 * ������Դͳ�ƽ�������û���
	 */
	protected List<VIM03CountByProjVWInfo> vim03pList;

	/**
	 * ������Դͳ�ƽ�������û���ȡ��
	 * @return vim03pList ������Դͳ�ƽ�������û���
	 */
	public List<VIM03CountByProjVWInfo> getVim03pList() {
		return vim03pList;
	}

	/**
	 * ������Դͳ�ƽ�������û����趨
	 * @param vim03pList ������Դͳ�ƽ�������û���
	 */
	public void setVim03pList(List<VIM03CountByProjVWInfo> vim03pList) {
		this.vim03pList = vim03pList;
	}
	
}


