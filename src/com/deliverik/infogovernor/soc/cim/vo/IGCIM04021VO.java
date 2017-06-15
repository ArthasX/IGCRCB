package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.soc.asset.model.SOC0117Info;

/**
 * 资产类型登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM04021VO extends BaseVO implements Serializable{
	
	/** 资产类型登录后信息 */
	protected SOC0117Info entityData;
	
	protected List<CodeDetail> types1;
	
	protected List<CodeDetail> types2;
	
	protected String stopFlag;
	
	protected String startFlag;
	
	public String getStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(String stopFlag) {
		this.stopFlag = stopFlag;
	}

	public String getStartFlag() {
		return startFlag;
	}

	public void setStartFlag(String startFlag) {
		this.startFlag = startFlag;
	}
	
	public List<CodeDetail> getTypes1() {
		return types1;
	}

	public void setTypes1(List<CodeDetail> types1) {
		this.types1 = types1;
	}

	public List<CodeDetail> getTypes2() {
		return types2;
	}

	public void setTypes2(List<CodeDetail> types2) {
		this.types2 = types2;
	}
	
	/**
	 * 构造函数
	 * @param entityData　资产类型登录后信息
	 */
	public IGCIM04021VO(SOC0117Info entityData) {
		this.entityData = entityData;
	}
	
	public IGCIM04021VO() {}
	
	/**
	 * 资产类型登录后信息取得
	 * @return 资产类型登录后信息
	 */
	public SOC0117Info getEntityData() {
		return entityData;
	}

}


