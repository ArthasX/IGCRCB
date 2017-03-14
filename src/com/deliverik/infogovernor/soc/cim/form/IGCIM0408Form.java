package com.deliverik.infogovernor.soc.cim.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * �ʲ���������ѡ����FORM
 * 
 */
public class IGCIM0408Form extends BaseForm implements IG545Info{

	private static final long serialVersionUID = 1L;
	
	/** �ʲ���������ID*/
	protected Integer ccdid;
	
	/** �ʲ��������ݱ�ʶ */
	protected String ccdcategory;
	
	/** �ʲ��������ݱ�ʶ����*/
	protected String ccdlabel;
	
	/** �ʲ���������ֵ*/
	protected String ccdvalue;
	
	/** �ʲ���������״̬*/
	protected String ccdstatus;
	
	/** �ʲ�������������Ӧ��*/
	protected String ccdtype;
	
	/** �ʲ���������Ԥ���ֶ�*/
	protected String ccdinfo;
	
	/** �ʲ���������ֵ����*/
	protected String[] ccdvalues;
	
	/** �ʲ�������ֵ����ֽ��� */
	private static final int MAX_BYTE = 32;
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	public String[] getCcdvalues() {
		return ccdvalues;
	}

	public void setCcdvalues(String[] ccdvalues) {
		this.ccdvalues = ccdvalues;
	}

	public Integer getCcdid() {
		return ccdid;
	}

	public void setCcdid(Integer ccdid) {
		this.ccdid = ccdid;
	}

	public String getCcdcategory() {
		return ccdcategory;
	}

	public void setCcdcategory(String ccdcategory) {
		this.ccdcategory = ccdcategory;
	}

	public String getCcdlabel() {
		return ccdlabel;
	}

	public void setCcdlabel(String ccdlabel) {
		this.ccdlabel = ccdlabel;
	}

	public String getCcdvalue() {
		return ccdvalue;
	}

	public void setCcdvalue(String ccdvalue) {
		this.ccdvalue = ccdvalue;
	}

	public String getCcdstatus() {
		return ccdstatus;
	}

	public void setCcdstatus(String ccdstatus) {
		this.ccdstatus = ccdstatus;
	}

	public String getCcdtype() {
		return ccdtype;
	}

	public void setCcdtype(String ccdtype) {
		this.ccdtype = ccdtype;
	}

	public String getCcdinfo() {
		return ccdinfo;
	}

	public void setCcdinfo(String ccdinfo) {
		this.ccdinfo = ccdinfo;
	}
	/**
	 * ����ֵ��󳤶ȼ��
	 *
	 * @param mapping
	 * @param request
	 * @return ��������Ϣ
	 */
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		errors = super.validate(mapping, request);
		if ( ccdvalues != null ) {
			for ( int i=0;i<ccdvalues.length;i++ ) {
				if (!IGStringUtils.isValidBytes(ccdvalues[i],MAX_BYTE)) {
					errors.add(Globals.ERROR_KEY, new ActionMessage("errors.maxbytes","(��ţ�" +ccdvalues[i]+")������ֵ", 
    					String.valueOf(MAX_BYTE / 3), String.valueOf(MAX_BYTE)));
				}
			}
		}
		
		request.getSession().setAttribute("IGCIM0408Form", this);
		return errors;
	}

}
