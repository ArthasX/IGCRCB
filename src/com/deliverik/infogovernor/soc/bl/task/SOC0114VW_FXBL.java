/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.model.SOC0114VWInfo;
import com.deliverik.infogovernor.soc.model.condition.SOC0114VW_FXSearchCond;
import com.deliverik.infogovernor.soc.model.condition.SOC0114VW_FXSearchCondImpl;

/**
 * SOC0114VW_FXҵ���߼��ӿ�
 */
public interface SOC0114VW_FXBL extends BaseBL{

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public String searchSOC0114VW_FXByCond(SOC0114VW_FXSearchCond cond);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public String searchSOC0114VW_BJByCond(SOC0114VW_FXSearchCond cond);

	public List<SOC0114VWInfo> findByCondForBJ(
			SOC0114VW_FXSearchCondImpl soc0114Cond);

	/**
	 * Ӧ��ά�����˲�ѯ
	 * @param cond
	 * @return
	 */
	public String searchSOC0114VW_FXAPPByCond(SOC0114VW_FXSearchCond cond,String FLEXID);
}
