package com.deliverik.framework.workflow.prd.model.condition;


/**
 * ���̲����߱���Ȩ����ͼ��������ʵ��
 * 
 */
public class IG893SearchCondImpl implements IG893SearchCond {
	
	/** ����״̬ID */
	protected String psdid;

	/** ���̲����߽�ɫID */
	protected Integer roleid;
	
	/** ��ȫ�ֿ��ƽڵ㼯��id */
    protected String formGlobalPsdids;

	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}
	
	/**
	 * ����״̬ID�趨
	 * @param psdid����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ���̲����߽�ɫIDȡ��
	 * @return ���̲����߽�ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}
	/**
	 * ���̲����߽�ɫID�趨
	 * @param roleid���̲����߽�ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * ��ȫ�ֿ��ƽڵ�id����ȡ��
	 * @return ��ȫ�ֿ��ƽڵ�id
	 */
	public String getFormGlobalPsdids() {
		return formGlobalPsdids;
	}

	/**
	 * ��ȫ�ֿ��ƽڵ�id�趨
	 * @param formGlobalPsdList ��ȫ�ֿ��ƽڵ�id
	 */
	public void setFormGlobalPsdids(String formGlobalPsdids) {
		this.formGlobalPsdids = formGlobalPsdids;
	}
	
}
