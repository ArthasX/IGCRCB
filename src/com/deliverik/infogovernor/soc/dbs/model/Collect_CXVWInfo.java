/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.dbs.model;

import java.math.BigDecimal;
/**
 * 
 * @Description:�洢ʵʱ��Ϣ��ͼʵ��TB��
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_CXVWInfo {

	/** ��ȡ�豸 */
	public String getObject_Name();

	/** ��ȡʹ���� */
	public BigDecimal getSysBusy();

	/** ��ȡʱ�� */
	public String getSymtime();

	/** ��ȡ�豸���к� */
	public String getDataid();

}
