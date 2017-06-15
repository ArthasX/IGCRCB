package com.deliverik.infogovernor.fxk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;

@SuppressWarnings("serial")
public class IGFXK01011VO extends BaseVO implements Serializable{
	
	
	/**风险计划集合*/
	protected   List<IG500Info> prList;
	
	/**风险清单*/
	protected List<RiskcaseVWInfo> qdList;
	
	/**问题整改*/
	protected List<IG500Info> qmList;
	
	/**风险评估*/
	protected List<IG500Info> pgList;

	/** 风险提示相关信息集合 */
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
	 * @return 风险清单 取得
	 */
	public List<RiskcaseVWInfo> getQdList() {
		return qdList;
	}

	/**
	 * @param  风险清单 设定
	 */
	public void setQdList(List<RiskcaseVWInfo> qdList) {
		this.qdList = qdList;
	}

	/**
	 * 风险计划集合取得
	 * @return prList 风险计划集合
	 */
	
	public List<IG500Info> getPrList() {
		return prList;
	}

	/**
	 * 风险计划集合设定
	 * @param prList 风险计划集合
	 */
	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}
}
