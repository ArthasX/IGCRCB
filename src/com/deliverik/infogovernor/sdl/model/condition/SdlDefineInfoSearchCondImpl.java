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
 * Description: �������_����ˮƽ����_����ˮƽ��׼��ѯMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class SdlDefineInfoSearchCondImpl implements SdlDefineInfoSearchCond {

	/**���*/
	protected String sdiyear;

	/**����ʲ�ID*/
	protected Integer sdieiid;

	/**�ʲ����� */
	protected String sdieiname;
	
	/**
	 * ��ȡ���
	 * @return ���
	 */
	public String getSdiyear() {
		return sdiyear;
	}

	/**
	 * �������
	 * @param sdiyear ���
	 */
	public void setSdiyear(String sdiyear) {
		this.sdiyear = sdiyear;
	}

	/**
	 * ��ȡ����ʲ�ID
	 * @return ����ʲ�ID
	 */
	public Integer getSdieiid() {
		return sdieiid;
	}

	/**
	 * ��������ʲ�ID
	 * @param sdieiid ����ʲ�ID
	 */
	public void setSdieiid(Integer sdieiid) {
		this.sdieiid = sdieiid;
	}

	/**
	 * ��ȡ����ʲ�����
	 * @return ����ʲ�����
	 */
	public String getSdieiname() {
		return sdieiname;
	}

	/**
	 * ��������ʲ�����
	 * @param sdieiname ����ʲ�����
	 */
	public void setSdieiname(String sdieiname) {
		this.sdieiname = sdieiname;
	}
	
}
