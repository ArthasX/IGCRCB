/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����VO
 * </p>
 * 2014-6-19
 * @author zhangq@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK07012VO extends BaseVO{

	/** ������ʾ���� */
	protected RiskmanagerwaringInfo risk;
	
	/** �·���Ա���� */
	protected List<AcceptuserInfo> acceptuserList;

	/**
	 * ������ʾ����ȡ��
	 * @return risk ������ʾ����
	 */
	public RiskmanagerwaringInfo getRisk() {
		return risk;
	}

	/**
	 * ������ʾ�����趨
	 * @param risk ������ʾ����
	 */
	public void setRisk(RiskmanagerwaringInfo risk) {
		this.risk = risk;
	}

	/**
	 * �·���Ա����ȡ��
	 * @return acceptuserList �·���Ա����
	 */
	public List<AcceptuserInfo> getAcceptuserList() {
		return acceptuserList;
	}

	/**
	 * �·���Ա�����趨
	 * @param acceptuserList �·���Ա����
	 */
	public void setAcceptuserList(List<AcceptuserInfo> acceptuserList) {
		this.acceptuserList = acceptuserList;
	}
}
