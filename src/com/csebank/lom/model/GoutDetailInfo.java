/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;
import com.deliverik.framework.base.BaseModel;

/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ����Ʒ������ϸʵ��ӿ�
 * ���ߣ�������
 */
public interface GoutDetailInfo extends BaseModel {
     public String getGoid();
	/** ʱ�� */
	public String getGotime();
	/** ������ */
	public String getGorequsername();
	/** ��Ʒ���� */
	public String getGoname();
	/** ��Ʒ��� */
	public String getGocode();
	/** �д����� */
	public String getRname();
	/** �������� */
	public String getRid();
	//��������
	public String getGoinnum();

}
