/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_����ˮƽͳ�Ʋ�ѯMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class SdlSummarySearchCondImpl implements SdlSummarySearchCond {

	/**���*/
	protected String year;

	/**����ʲ�ID*/
	protected Integer eiid;

	/**�ʲ����� */
	protected String einame;
	
	/**
	 * ��ȡ���
	 * @return ���
	 */
	public String getYear() {
		return year;
	}

	/**
	 * �������
	 * @param year ���
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * ��ȡ����ʲ�ID
	 * @return ����ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ��������ʲ�ID
	 * @param eiid ����ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��ȡ����ʲ�����
	 * @return ����ʲ�����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ��������ʲ�����
	 * @param einame ����ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	
}
