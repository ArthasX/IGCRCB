/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.condition;


/**
 * ����:��������Ϣ��ͼ��ѯ����ʵ��
 * ��������: ��������Ϣ��ͼ��ѯ����ʵ��
 * �����ˣ�����
 * ������¼: 2013/05/13
 * �޸ļ�¼: 
 */
public class EntityItemFacilitatorVWSearchCondImpl implements
		EntityItemFacilitatorVWSearchCond {

	/**��˾����  */
	protected String einame;
	/**������  */
	protected String eiorgsyscoding;
	/**ģ����  */
	protected String esyscoding;
	/**�Ǽ���  ��ʼ*/
	protected String eiupdtime_from;
	/**�Ǽ��� ����*/
	protected String eiupdtime_to;
	
	
	/**��˾����  ȡ�� */
	public String getEiname() {
		return einame;
	}
	/**������  ȡ�� */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	/**ģ����  ȡ�� */
	public String getEsyscoding() {
		return esyscoding;
	}
	/**�Ǽ�����ʼ  ȡ�� */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}
	/**�Ǽ��ս���  ȡ�� */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}
	
	
	/**��˾����  �趨 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	/**������  �趨 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	/**ģ����  �趨 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**�Ǽ�����ʼ  �趨 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}
	/**�Ǽ��ս���   �趨 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}
	
}
