package com.deliverik.framework.workflow.prr.model.condition;

/**
 * ���̱�����Ϣ��������ʵ��
 */
public class IG599SearchCondImpl implements IG599SearchCond {

	/**
	 * ���̼�¼ID
	 */
	protected Integer prid;
	
	/**
	 * ���̶���ID
	 */
	protected String pdid;
	
	/**
	 * ���̱�����ʶ
	 */
	protected String pivarname;
	
	/**
	 * ���̱�������
	 */
	protected String pivartype;
	
	/**
	 * ���̱�����ʶ
	 */
	protected String pivarlabel;
	
	/**
	 * ���̱���ֵ
	 */
	protected String pivarvalue;
	
	/**
	 * �û�ID
	 */
	protected String userid;
	
	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���̼�¼ID�趨
	 * @param prid ���̼�¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���̱�����ʶȡ��
	 * @return ���̱�����ʶ
	 */
	public String getPivarname() {
		return pivarname;
	}

	/**
	 * ���̱�����ʶ�趨
	 * @param pivarname ���̱�����ʶ
	 */
	public void setPivarname(String pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * ���̱�������ȡ��
	 * @return ���̱���
	 */
	public String getPivartype() {
		return pivartype;
	}

	/**
	 * ���̱����趨
	 * @param pivartype ���̱���
	 */
	public void setPivartype(String pivartype) {
		this.pivartype = pivartype;
	}

	/**
	 * ���̱�����ʶȡ��
	 * @return ���̱���
	 */
	public String getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * ���̱����趨
	 * @param pivarlabel ���̱���
	 */
	public void setPivarlabel(String pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * ���̱���ֵȡ��
	 * @return ���̱���ֵ
	 */
	public String getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * ���̱���ֵ�趨
	 * @param pivarvalue ���̱���ֵ
	 */
	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ���̶���IDȡ��
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
}
