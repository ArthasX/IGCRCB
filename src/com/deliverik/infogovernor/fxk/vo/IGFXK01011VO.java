package com.deliverik.infogovernor.fxk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;

@SuppressWarnings("serial")
public class IGFXK01011VO extends BaseVO implements Serializable{
	
	
	/**���ռƻ�����*/
	protected   List<IG500Info> prList;
	
	/**�����嵥*/
	protected List<RiskcaseVWInfo> qdList;
	
	/**��������*/
	protected List<IG500Info> qmList;
	
	/**��������*/
	protected List<IG500Info> pgList;

	/** ������ʾ�����Ϣ���� */
	protected List<IGFXK07012VO> voList;

	
    /**
	 * @return the voList
	 */
	public List<IGFXK07012VO> getVoList() {
		return voList;
	}

	/**
	 * @param voList the voList to set
	 */
	public void setVoList(List<IGFXK07012VO> voList) {
		this.voList = voList;
	}

	
	/**
	 * @return the pgList
	 */
	public List<IG500Info> getPgList() {
		return pgList;
	}

	/**
	 * @param pgList the pgList to set
	 */
	public void setPgList(List<IG500Info> pgList) {
		this.pgList = pgList;
	}

	/**
	 * @return the qmList
	 */
	public List<IG500Info> getQmList() {
		return qmList;
	}

	/**
	 * @param qmList the qmList to set
	 */
	public void setQmList(List<IG500Info> qmList) {
		this.qmList = qmList;
	}

	/**
	 * @return �����嵥 ȡ��
	 */
	public List<RiskcaseVWInfo> getQdList() {
		return qdList;
	}

	/**
	 * @param  �����嵥 �趨
	 */
	public void setQdList(List<RiskcaseVWInfo> qdList) {
		this.qdList = qdList;
	}

	/**
	 * ���ռƻ�����ȡ��
	 * @return prList ���ռƻ�����
	 */
	
	public List<IG500Info> getPrList() {
		return prList;
	}

	/**
	 * ���ռƻ������趨
	 * @param prList ���ռƻ�����
	 */
	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}
}
