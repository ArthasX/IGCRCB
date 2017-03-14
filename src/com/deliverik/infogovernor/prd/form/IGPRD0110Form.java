/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;

/**
 * ����Ϣ��ѯ����Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0110Form extends BaseForm implements IG007SearchCond {
	
	/** ����Ϣ�Ƿ���ϵͳĬ�� */
	protected String isDefault;
	
	/** ����Ϣ��ID */
	protected String pidid;

	/** ����Ϣ����ʾ���� */
	protected String pidlabel;

	/** ����Ϣ�ĺ�̨��ʾ���� */
	protected String pidname;

	/** ����Ϣ�ĺ�̨��ʾ����like��ѯ���� */
	protected String pidname_like;
	
	/** ����Ϣ�Ƿ������ */
	protected String pidrequired;

	/** ����Ϣ������ */
	protected String pidtype;
	
	/** ���̶����ID */
	protected String pdid;
	
	protected Integer pidgid;
	
	/** ����Ϣ��ģʽ */
	protected String pidmode;
	
	protected String pidid_notlike;
	
	/** ������������ */
    protected String ppidid;
    
    protected String tableColumn;
    
    /** ��������ʾģʽ */
    protected String piddisplay;
    
    /** ���ص�ַ */
    protected String backURL;
	
	public String getPidid_notlike() {
		return pidid_notlike;
	}

	public void setPidid_notlike(String pidid_notlike) {
		this.pidid_notlike = pidid_notlike;
	}

	public Integer getPidgid() {
		return pidgid;
	}

	public void setPidgid(Integer pidgid) {
		this.pidgid = pidgid;
	}
	/**
	 * ����Ϣ�Ƿ���ϵͳĬ��ȡ��
	 * 
	 * @return ����Ϣ�Ƿ���ϵͳĬ��
	 */
	public String getIsDefault() {
		return isDefault;
	}

	/**
	 * ����Ϣ�Ƿ���ϵͳĬ���趨
	 *
	 * @param isDefault ����Ϣ�Ƿ���ϵͳĬ��
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * ����Ϣ��IDȡ��
	 * 
	 * @return ����Ϣ��ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ����Ϣ��ID�趨
	 *
	 * @param pidid ����Ϣ��ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ����Ϣ����ʾ����ȡ��
	 * 
	 * @return ����Ϣ����ʾ����
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * ����Ϣ����ʾ�����趨
	 *
	 * @param pidlabel ����Ϣ����ʾ����
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * ����Ϣ�ĺ�̨��ʾ����ȡ��
	 * 
	 * @return ����Ϣ�ĺ�̨��ʾ����
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ����Ϣ�ĺ�̨��ʾ�����趨
	 *
	 * @param pidname ����Ϣ�ĺ�̨��ʾ����
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ����Ϣ�ĺ�̨��ʾ����like��ѯ����ȡ��
	 * 
	 * @return ����Ϣ�ĺ�̨��ʾ����like��ѯ����
	 */
	public String getPidname_like() {
		return pidname_like;
	}

	/**
	 * ����Ϣ�ĺ�̨��ʾ����like��ѯ�����趨
	 *
	 * @param pidname_like ����Ϣ�ĺ�̨��ʾ����like��ѯ����
	 */
	public void setPidname_like(String pidname_like) {
		this.pidname_like = pidname_like;
	}

	/**
	 * ����Ϣ�Ƿ������ȡ��
	 * 
	 * @return ����Ϣ�Ƿ������
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * ����Ϣ�Ƿ�������趨
	 *
	 * @param pidname_like ����Ϣ�Ƿ������
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

	/**
	 * ����Ϣ������ȡ��
	 * 
	 * @return ����Ϣ������
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * ����Ϣ�������趨
	 *
	 * @param pidtype ����Ϣ������
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * ���̶����IDȡ��
	 * 
	 * @return ���̶����ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶����ID�趨
	 *
	 * @param pdid ���̶����ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����Ϣ��ģʽȡ��
	 *
	 * @return ����Ϣ��ģʽ
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * ����Ϣ��ģʽ�趨
	 *
	 * @param pidmode ����Ϣ��ģʽ
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.pidmode = null;
	}
	
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;

	/**
	 * �鿴ģʽ
	 *
	 * @return �鿴ģʽ
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * �鿴ģʽ
	 *
	 * @param viewHistory  0�����£�1��ʷ
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}

	public String getPpdid_like() {
		return null;
	}

	public String getPsdid_like() {
		return null;
	}
	
	public String getPsdcode_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPidid_like() {
		// TODO Auto-generated method stub
		return null;
	}

    public String[] getPidtypes() {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
	 * ������������ȡ��
	 * @return ppidid ������������
	 */
	public String getPpidid() {
		return ppidid;
	}

	/**
	 * �������������趨
	 * @param ppidid ������������
	 */
	public void setPpidid(String ppidid) {
		this.ppidid = ppidid;
	}

	public String getTableColumn() {
		return tableColumn;
	}

	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}
	
	/**
	 * ��������ʾģʽȡ��
	 * @return ��������ʾģʽ
	 */
	public String getPiddisplay() {
		return piddisplay;
	}

	/**
	 * ��������ʾģʽ�趨
	 * @param piddisplay ��������ʾģʽ
	 */
	public void setPiddisplay(String piddisplay) {
		this.piddisplay = piddisplay;
	}

	public String getIsExport() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ���ص�ַȡ��
	 * @return backURL ���ص�ַ
	 */
	public String getBackURL() {
		return backURL;
	}

	/**
	 * ���ص�ַ�趨
	 * @param backURL ���ص�ַ
	 */
	public void setBackURL(String backURL) {
		this.backURL = backURL;
	}

	public String getPiduse() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
