/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1302VO extends BaseVO{

	/** �ĵ����ļ������ */
	protected List<IG500Info> ig500InfoList;

	/**
	 * �ĵ����ļ������ȡ��
	 * @return ig500InfoList �ĵ����ļ������
	 */
	public List<IG500Info> getIg500InfoList() {
		return ig500InfoList;
	}

	/**
	 * �ĵ����ļ�������趨
	 * @param ig500InfoList �ĵ����ļ������
	 */
	public void setIg500InfoList(List<IG500Info> ig500InfoList) {
		this.ig500InfoList = ig500InfoList;
	}
}
