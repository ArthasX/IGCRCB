/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.syslog.model.Mss00013Info;

/**
 * ��ʷ�豸��־��ʾ
 * @author ��ʡ
 *	
 */
@SuppressWarnings("serial")
public class IGLOG0114VO extends BaseVO implements Serializable {
	public List<Mss00013Info>li=null;
	protected List<CodeDetail>ruleli=null;
	public List<CodeDetail> getRuleli() {
		return ruleli;
	}

	public void setRuleli(List<CodeDetail> ruleli) {
		this.ruleli = ruleli;
	}

	public List<Mss00013Info> getLi() {
		return li;
	}

	public void setLi(List<Mss00013Info> li) {
		this.li = li;
	}

	
}
