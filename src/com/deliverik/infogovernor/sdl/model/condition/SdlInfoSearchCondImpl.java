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
 * Description: �������_����ˮƽ����_����ˮƽ��Ϣ��ѯMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class SdlInfoSearchCondImpl implements SdlInfoSearchCond {

	/**���*/
	protected String sitype;

	/**��ʼʱ��*/
	protected String sibegin;
	
	/**����ʱ��*/
	protected String siend;

	/**����ʲ�ID*/
	protected Integer sieiid;

	/**�������ID*/
	protected Integer siprid;
	
	/**����*/
	protected String simark;

	/**
	 * ��ȡ���
	 * 
	 * @return ���
	 */
	public String getSitype() {
		return sitype;
	}

	/**
	 * �������
	 * @param sitype ���
	 */
	public void setSitype(String sitype) {
		this.sitype = sitype;
	}

	/**
	 * ��ȡ��ʼʱ��
	 * 
	 * @return ��ʼʱ��
	 */
	public String getSibegin() {
		return sibegin;
	}

	/**
	 * ���ÿ�ʼʱ��
	 * @param sibegin ��ʼʱ��
	 */
	public void setSibegin(String sibegin) {
		this.sibegin = sibegin;
	}

	/**
	 * ��ȡ����ʱ��
	 * 
	 * @return ����ʱ��
	 */
	public String getSiend() {
		return siend;
	}

	/**
	 * ���ý���ʱ��
	 * @param siend ����ʱ��
	 */
	public void setSiend(String siend) {
		this.siend = siend;
	}

	/**
	 * ��ȡ����ʲ�ID
	 * 
	 * @return ����ʲ�ID
	 */
	public Integer getSieiid() {
		return sieiid;
	}

	/**
	 * ��������ʲ�ID
	 * @param sieiid ����ʲ�ID
	 */
	public void setSieiid(Integer sieiid) {
		this.sieiid = sieiid;
	}

	/**
	 * ��ȡ�������ID
	 * 
	 * @return �������ID
	 */
	public Integer getSiprid() {
		return siprid;
	}

	/**
	 * �����������ID
	 * @param siprid �������ID
	 */
	public void setSiprid(Integer siprid) {
		this.siprid = siprid;
	}

	/**
	 * ��ȡ����
	 * 
	 * @return ����
	 */
	public String getSimark() {
		return simark;
	}

	/**
	 * ��������
	 * @param simark ����
	 */
	public void setSimark(String simark) {
		this.simark = simark;
	}
	
}
