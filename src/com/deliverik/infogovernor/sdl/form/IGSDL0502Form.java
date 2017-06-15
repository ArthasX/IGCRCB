/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_ͳ�Ʋ�ѯ����Ϣ��ѯ��Form
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0502Form extends BaseForm implements SdlInfoSearchCond{

	/**���*/
	protected String year;

	/**����ʲ�ID*/
	protected Integer sieiid;

	/**�ʲ����� */
	protected String einame;
	
	/**�·�*/
	protected String month;
	
	/**���*/
	protected String sitype;
	
	/**��ʼʱ��*/
	protected String sibegin;
	
	/**����ʱ��*/
	protected String siend;
	
	/**��ϢID*/
	protected Integer siid;
	
	public Integer getSiid() {
		return siid;
	}

	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getSitype() {
		return sitype;
	}

	public void setSitype(String sitype) {
		this.sitype = sitype;
	}

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

	public Integer getSieiid() {
		return sieiid;
	}

	public void setSieiid(Integer sieiid) {
		this.sieiid = sieiid;
	}

	public String getSibegin() {
		return sibegin;
	}

	public void setSibegin(String sibegin) {
		this.sibegin = sibegin;
	}

	public String getSiend() {
		return siend;
	}

	public void setSiend(String siend) {
		this.siend = siend;
	}

	public String getSimark() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getSiprid() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
