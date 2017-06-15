package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;

/**
 *  ������Դͳ�ƽ��	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR08031VO extends BaseVO implements Serializable{
	
	/**
	 * ������Դͳ�ƽ�������û���
	 */
	protected List<VIM03CountByOrgVWInfo> vim03oList;

	/**
	 * ������Դͳ�ƽ�������û���ȡ��
	 * @return vim03oList ������Դͳ�ƽ�������û���
	 */
	public List<VIM03CountByOrgVWInfo> getVim03oList() {
		return vim03oList;
	}

	/**
	 * ������Դͳ�ƽ�������û����趨
	 * @param vim03oList ������Դͳ�ƽ�������û���
	 */
	public void setVim03oList(List<VIM03CountByOrgVWInfo> vim03oList) {
		this.vim03oList = vim03oList;
	}

}


