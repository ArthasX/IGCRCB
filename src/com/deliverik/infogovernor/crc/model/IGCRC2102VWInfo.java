/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model;

import com.deliverik.framework.base.BaseModel;

/**	
 * ����:����������ֵ�ӿ�
 * ������¼��yukexin    2014-8-15 ����3:29:28	
 * �޸ļ�¼��null
 */	
public interface IGCRC2102VWInfo extends BaseModel{
	/**
	 * ����ȡ��
	 * @return id  ����
	 */
	public String getId();
	/**
	 * �����趨
	 * @param label  ����
	 */
	public String getLabel();
	/**
	 * ֵȡ��
	 * @return value  ֵ
	 */
	public String getValue();
}
