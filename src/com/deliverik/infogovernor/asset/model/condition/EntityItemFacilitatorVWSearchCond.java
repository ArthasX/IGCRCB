/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.condition;
/**
 * ����:��������Ϣ��ͼ��ѯ�����ӿ�
 * ��������: ��������Ϣ��ͼ��ѯ�����ӿ�
 * �����ˣ�����
 * ������¼: 2013/05/13
 * �޸ļ�¼: 
 */
public interface EntityItemFacilitatorVWSearchCond {

	/**��˾����  ȡ�� */
	public String getEiname();
	/**������  ȡ�� */
	public String getEiorgsyscoding();
	/**ģ����  ȡ�� */
	public String getEsyscoding();
	/**�Ǽ�����ʼ  ȡ�� */
	public String getEiupdtime_from();
	/**�Ǽ��ս���  ȡ�� */
	public String getEiupdtime_to();
}
