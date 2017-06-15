/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefInfo;

/**
 * ����:��ضԷ�ֵ��ʾVO
 * ����������
 * ������¼�����    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT01051VO extends BaseVO implements Serializable {
	/**
	 * ��ض��󼯺�
	 */
	protected List<MonitorObjectDefInfo> monitorObjectDefList;

	/**
	 * ���캯��
	 * @param monitorObjectDefList
	 */
	public IGMNT01051VO(List<MonitorObjectDefInfo> monitorObjectDefList) {
		this.monitorObjectDefList=monitorObjectDefList;
	}

	/**
	 * ��ض��󼯺ϻ�ȡ
	 * @return
	 */
	public List<MonitorObjectDefInfo> getMonitorObjectDefList() {
		return monitorObjectDefList;
	}
	
}
