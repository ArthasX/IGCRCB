package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.soc.asset.model.SOC0117Info;

/**
 * �ʲ����͵�¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM04021VO extends BaseVO implements Serializable{
	
	/** �ʲ����͵�¼����Ϣ */
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
	 * ���캯��
	 * @param entityData���ʲ����͵�¼����Ϣ
	 */
	public IGCIM04021VO(SOC0117Info entityData) {
		this.entityData = entityData;
	}
	
	public IGCIM04021VO() {}
	
	/**
	 * �ʲ����͵�¼����Ϣȡ��
	 * @return �ʲ����͵�¼����Ϣ
	 */
	public SOC0117Info getEntityData() {
		return entityData;
	}

}


