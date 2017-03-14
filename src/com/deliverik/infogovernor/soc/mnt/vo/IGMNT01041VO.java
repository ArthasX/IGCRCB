/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;

/**
 * ����:��ض�����ʾVO
 * ����������
 * ������¼�����    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT01041VO extends BaseVO implements Serializable {
	/**
	 * ��ض��󼯺�
	 */
	protected List<MonitorObjectInfo> monitorObjectList;

	/**
	 * ���캯��
	 * @param monitorObjectList
	 */
	public IGMNT01041VO(List<MonitorObjectInfo> monitorObjectList) {
		this.monitorObjectList=monitorObjectList;
	}

	/**
	 * ��ض��󼯺ϻ�ȡ
	 * @return
	 */
	public List<MonitorObjectInfo> getMonitorObjectList() {
		return monitorObjectList;
	}
	
}
