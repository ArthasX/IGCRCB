/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * �Ӵ�����ʵ��ӿ�
 *
 */
public interface ItemsCodesSt extends BaseModel {

	public Integer getIcid();
	public String getSelectid();
	public String getSelectname();
	public String getTypecode();
	public String getTypename();
	public String getType();
	public String getDesc();
	public String getStatus();

}
