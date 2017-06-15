/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>����:���̱���������Ϣ��������ʵ��</p>
 * <p>��������:</p>
 * <p>������¼��</p>
 */
public class IG007SearchCondImpl implements IG007SearchCond{
	
	/** ���̱�������ID */
	protected String pidid;

	/** ��������ID */
	protected String pdid;

	/** ���̱�����ʾ���� */
	protected String pidlabel;
	
	/** ���̱������� */
	protected String pidname;

	/** ���̱������� */
	protected String pidtype;

	/** ���̱����Ƿ���� */
	protected String pidrequired;
	
	/** ���̱�������(ģ��ƥ��) */
	protected String pidname_like;
	
	/** ���̱��������Ƿ��жϱ���Ϊȱʡ������ʶ��IGWFBaseBLType.YES�жϣ�IGWFBaseBLType.NO���жϣ� */
	protected String isDefault;
	
	/** ����Ϣ��ģʽ */
	protected String pidmode;
	
	protected String pidid_notlike;
	
	protected String ppdid_like;
	
	protected String psdid_like;
	
	protected String[] pidtypes;
	
	/** ������������ */
    protected String ppidid;
	
	/** �������б�ʶ */
	protected String tableColumn;
	
	/** �Ƿ񵼳����� */
	protected String isExport;
	
	/** ���ʹ��ģʽ */
	protected String piduse;
	
	public String getPiduse() {
		return piduse;
	}

	public void setPiduse(String piduse) {
		this.piduse = piduse;
	}

	public String[] getPidtypes() {
		return pidtypes;
	}

	public void setPidtypes(String[] pidtypes) {
		this.pidtypes = pidtypes;
	}

	/** ���̶���ID */
	protected String pidid_like;

	public String getPidid_notlike() {
		return pidid_notlike;
	}

	public void setPidid_notlike(String pidid_notlike) {
		this.pidid_notlike = pidid_notlike;
	}

	/**
	 * ��ͨ����ID
	 */
	protected Integer pidgid;

	/**
	 * ���̹�ͨ����IDȡ��
	 * @return ���̹�ͨ����ID
	 */
	public Integer getPidgid() {
		return pidgid;
	}
	
	/**
	 * ���ܣ����̹�ͨ����ID�趨
	  * @param pidgid ���̹�ͨ����ID
	 */
	public void setPidgid(Integer pidgid) {
		this.pidgid = pidgid;
	}
	
	/**
	 * ���ܣ����̱�������IDȡ��
	 * @return ���̱�������ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ���ܣ����̱�������ID�趨
	  * @param pidid ���̱�������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ���ܣ���������IDȡ��
	 * @return ��������ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���ܣ���������ID�趨
	  * @param pdid ��������ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ���ܣ����̱�����ʾ����ȡ��
	 * @return ���̱�����ʾ����
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * ���ܣ����̱�����ʾ�����趨
	  * @param pidlabel ���̱�����ʾ����
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * ���ܣ����̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * ���ܣ����̱��������趨
	  * @param pidtype ���̱�������
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * ���ܣ����̱����Ƿ����ȡ��
	 * @return ���̱����Ƿ����
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * ���ܣ����̱����Ƿ�����趨
	  * @param pidrequired ���̱����Ƿ����
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

	/**
	 * ���ܣ����̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ���ܣ����̱��������趨
	  * @param pidname ���̱�������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ���ܣ����̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidname_like() {
		return pidname_like;
	}

	/**
	 * ���ܣ����̱��������趨
	 * @param pidname_like ���̱�������
	 */
	public void setPidname_like(String pidname_like) {
		this.pidname_like = pidname_like;
	}

	/**
	 * ���ܣ����̱��������Ƿ��жϱ���Ϊȱʡ������ʶȡ��
	 * @return ���̱��������Ƿ��жϱ���Ϊȱʡ������ʶ
	 */
	public String getIsDefault() {
		return isDefault;
	}

	/**
	 * ���ܣ����̱��������Ƿ��жϱ���Ϊȱʡ������ʶ�趨
	  * @param isDefault ���̱��������Ƿ��жϱ���Ϊȱʡ������ʶ
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * ����Ϣ��ģʽȡ��
	 *
	 * @return pidmode ����Ϣ��ģʽ
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

	public String getPpdid_like() {
		return ppdid_like;
	}

	public void setPpdid_like(String ppdid_like) {
		this.ppdid_like = ppdid_like;
	}

	public String getPsdid_like() {
		return psdid_like;
	}

	public void setPsdid_like(String psdid_like) {
		this.psdid_like = psdid_like;
	}
	
	protected String psdcode_like;

	public String getPsdcode_like() {
		return psdcode_like;
	}

	public void setPsdcode_like(String psdcode_like) {
		this.psdcode_like = psdcode_like;
	}

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPidid_like() {
		return pidid_like;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param pidid_like ���̶���ID
	 */
	public void setPidid_like(String pidid_like) {
		this.pidid_like = pidid_like;
	}

	/**
	 * �������б�ʶȡ��
	 * @return tableColumn �������б�ʶ
	 */
	public String getTableColumn() {
		return tableColumn;
	}

	/**
	 * �������б�ʶ�趨
	 * @param tableColumn �������б�ʶ
	 */
	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
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

	/**
	 *�Ƿ񵼳�����ȡ��
	 */
	public String getIsExport() {
		return isExport;
	}

	/**
	 *�Ƿ񵼳������趨
	 */
	public void setIsExport(String isExport) {
		this.isExport = isExport;
	}
	
}
