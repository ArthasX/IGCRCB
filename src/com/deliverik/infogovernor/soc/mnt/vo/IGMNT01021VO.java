/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;

/**
 * ����:������ͷ�ֵ��ʾVO
 * ����������
 * ������¼�����    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT01021VO extends BaseVO implements Serializable {
	/**
	 * ������ͷ�ֵ��Ϣ����
	 */
	protected List<MonitorTypeDefInfo> monitorTypeDefInfoList;
	
	/**
	 * ������ͷ�ֵ��Ϣ���ϻ�ȡ
	 * @return
	 */
	public List<MonitorTypeDefInfo> getMonitorTypeDefInfoList() {
		return monitorTypeDefInfoList;
	}

	/**
	 * ���캯��
	 * @param monitorTypeDefInfoList
	 */
	public IGMNT01021VO(List<MonitorTypeDefInfo> monitorTypeDefInfoList){
		this.monitorTypeDefInfoList=monitorTypeDefInfoList;
	}

	
}
