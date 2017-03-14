package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;

/**
 * ������Դͳ�ƽ��	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR08011VO extends BaseVO implements Serializable{
	
	/**
	 * ������Դͳ�ƽ�������û���
	 */
	protected List<VIM03CountByUserVWInfo> vim03uList;

	/**
	 * ������Դͳ�ƽ�������û���ȡ��
	 * @return vim03uList ������Դͳ�ƽ�������û���
	 */
	public List<VIM03CountByUserVWInfo> getVim03uList() {
		return vim03uList;
	}

	/**
	 * ������Դͳ�ƽ�������û����趨
	 * @param vim03uList ������Դͳ�ƽ�������û���
	 */
	public void setVim03uList(List<VIM03CountByUserVWInfo> vim03uList) {
		this.vim03uList = vim03uList;
	}
	
}


