/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset;


import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * ����: ��ƶԱȽ����Ϣ��ʵ��ӿ�
 * ��������: ��ƶԱȽ����Ϣ��ʵ��ӿ�
 * ������¼: 2012/03/05
 * �޸ļ�¼: 
 */
public interface SOC0137Info{
	
	/**
	 * �������IDȡ��
	 *
	 * @return �������ID
	 */
	public Integer getAutid();

	/**
	 * �ԱȽ������ȡ��
	 *
	 * @return �ԱȽ������
	 */
	public String getAucmptype();

	/**
	 * �ʲ�IDȡ��
	 *
	 * @return �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * ��汾ȡ��
	 *
	 * @return ��汾
	 */
	public Integer getEiversion();
	
	/**
	 * С�汾ȡ��
	 *
	 * @return С�汾
	 */
	public Integer getEismallversion();

	/**
	 * �ʲ�����ȡ��
	 *
	 * @return �ʲ�����
	 */
	public String getEiname();

	/**
	 * �����ʶȡ��
	 *
	 * @return �����ʶ
	 */
	public String getAuflag() ;

	/**
	 * �ʲ������ȡ��
	 * @return �ʲ������
	 */
	public String getEsyscoding();

	/**
	 * ģ��ʵ��ȡ��
	 * @return ģ��ʵ��
	 */
	public SOC0117TB getEntityTB();
	
	/**
	 * ���ʱ���ȡ��
	 *
	 * @return ���ʱ���
	 */
	public String getAutime();
}
