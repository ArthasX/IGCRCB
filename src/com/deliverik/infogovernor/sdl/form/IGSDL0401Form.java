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
 * Description: �������_����ˮƽ����_��Ϣ��ѯɾ��Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0401Form extends BaseForm implements SdlInfoSearchCond{
	
	/**��Ϣɾ������*/
	protected String[] deleteSdlInfoid;
	
	/**���*/
	protected String sitype;

	/**��ʼʱ��*/
	protected String sibegin;
	
	/**����ʱ��*/
	protected String siend;

	/**����ʲ�ID*/
	protected Integer sieiid;
	
	/**����ʲ�����*/
	protected String sieiname;
	
	/**�������ID*/
	protected Integer siprid;
	
	/**����¼���������*/
	protected String siprtitle;
	
	/**����*/
	protected String simark;
	
	/**��ϢID*/
	protected Integer siid;

	public Integer getSiid() {
		return siid;
	}

	public void setSiid(Integer siid) {
		this.siid = siid;
	}

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
		if(sieiid != null && sieiid != 0){
			return sieiid;
		}else{
			return null;
		}
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
		if(siprid != null && siprid != 0){
			return siprid;
		}else{
			return null;
		}
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
	
	/**
	 * ��ȡ��Ϣɾ������
	 * @return String[]
	 */
	
	public String[] getDeleteSdlInfoid() {
		return deleteSdlInfoid;
	}

	/**
	 * ������Ϣɾ������
	 * @param deleteSdlInfoid String[]
	 */
	
	public void setDeleteSdlInfoid(String[] deleteSdlInfoid) {
		this.deleteSdlInfoid = deleteSdlInfoid;
	}
	
	/**
	 * ��ȡ����ʲ�����
	 * @return ����ʲ�����
	 */
	public String getSieiname() {
		return sieiname;
	}

	/**
	 * ��������ʲ�����
	 * @param sieiname ����ʲ�����
	 */
	public void setSieiname(String sieiname) {
		this.sieiname = sieiname;
	}
	
	/**
	 * ��ȡ�����������
	 * @return �����������
	 */
	public String getSiprtitle() {
		return siprtitle;
	}

	/**
	 * ���������������
	 * @param siprtitle �����������
	 */
	public void setSiprtitle(String siprtitle) {
		this.siprtitle = siprtitle;
	}
	
}
