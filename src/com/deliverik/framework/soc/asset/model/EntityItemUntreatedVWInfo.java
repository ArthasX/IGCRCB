/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model;

/**
 * ����:δ�ϼܻ��񡢿յ���ups��ͼ�ӿ�
 * ��������: δ�ϼܻ��񡢿յ���ups��ͼ�ӿ�
 * �����ˣ�����
 * ������¼: 2013/07/03
 * �޸ļ�¼: 
 */

public interface EntityItemUntreatedVWInfo {
	
	/**�ʲ�id ȡ��*/
	public Integer getEiid();

	/**�ʲ�����  ȡ��*/
	public String getEiname();

	/**�ʲ���� ȡ�� */
	public String getEilabel();

	/**�ʲ������  ȡ��*/
	public String getEsyscoding();

	/**�߶�  ȡ��*/
	public String getU_total();

	/**���񡢻��ܱ�ʶ ȡ��  */
	public String getContainertype();

	/**�յ�����  ȡ��*/
	public String getEitype();
}
