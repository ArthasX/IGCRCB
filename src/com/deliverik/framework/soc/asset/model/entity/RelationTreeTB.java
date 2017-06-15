	/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;


/**
  * ����: ��ϵ��������
  * ��������: ��ϵ��������
  * ������¼: ����ȫ 2013/05/28
  * �޸ļ�¼: 
  */
public class RelationTreeTB {
	
	/**����ID*/
	protected Integer eiid;
	
	/**��������*/
	protected String einame;
	
	/**���󶥼�ID*/
	protected Integer eirootmark;
	
	/**ģ������*/
	protected String ename;
	
	/**ģ������*/
	protected String eid;
	
	/**����汾*/
	protected Integer eiversion;
	
	/**����С�汾*/
	protected Integer eismallversion;
	
	/**���󸸽��*/
	protected Integer fatherEiid;
	
	protected Integer grandpaEiid;
	
	/**��ϵ��*/
	protected String rlnCode;
	
	protected Integer sourceEiid;
	
	/**�Ƿ���Ҷ�ӽ�� trueΪ����㣬falseΪҶ��*/
	protected String isLeaf;

	protected String esyscoding;

	private String eparcoding;

	/**
	 * ���췽��
	 */
	public RelationTreeTB() {
		super();
	}
	
	/**
	 * @param eiid
	 * @param einame
	 * @param eirootmark
	 * @param ename
	 * @param eid
	 * @param eiversion
	 * @param eismallversion
	 */
	public RelationTreeTB(Integer eiid, String einame, Integer eirootmark,
			String ename, String eid, Integer eiversion, Integer eismallversion,
			Integer fatherEiid,String isLeaf,Integer sourceEiid) {
		super();
		this.eiid = eiid;
		this.einame = einame;
		this.eirootmark = eirootmark;
		this.ename = ename;
		this.eid = eid;
		this.eiversion = eiversion;
		this.eismallversion = eismallversion;
		this.fatherEiid=fatherEiid;
		this.isLeaf=isLeaf;
		this.sourceEiid=sourceEiid;
	}

	/**
	 * @param eiid
	 * @param einame
	 * @param eirootmark
	 * @param ename
	 * @param eid
	 * @param eiversion
	 * @param eismallversion
	 */
	public RelationTreeTB(Integer eiid, String einame, Integer eirootmark,
			String ename, String eid, Integer eiversion, Integer eismallversion,
			Integer fatherEiid,String isLeaf,Integer sourceEiid, 
			String esyscoding, String eparcoding) {
		super();
		this.eiid = eiid;
		this.einame = einame;
		this.eirootmark = eirootmark;
		this.ename = ename;
		this.eid = eid;
		this.eiversion = eiversion;
		this.eismallversion = eismallversion;
		this.fatherEiid=fatherEiid;
		this.isLeaf=isLeaf;
		this.sourceEiid=sourceEiid;
		this.esyscoding = esyscoding;
		this.eparcoding = eparcoding;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return eiid ����ID
	 */
	
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param eiid ����ID
	 */
	
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return einame ��������
	 */
	
	public String getEiname() {
		return einame;
	}

	/**
	 * ���������趨
	 *
	 * @param einame ��������
	 */
	
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ���󶥼�IDȡ��
	 *
	 * @return eirootmark ���󶥼�ID
	 */
	
	public Integer getEirootmark() {
		return eirootmark;
	}

	/**
	 * ���󶥼�ID�趨
	 *
	 * @param eirootmark ���󶥼�ID
	 */
	
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * ģ������ȡ��
	 *
	 * @return ename ģ������
	 */
	
	public String getEname() {
		return ename;
	}

	/**
	 * ģ�������趨
	 *
	 * @param ename ģ������
	 */
	
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * ģ������ȡ��
	 *
	 * @return eid ģ������
	 */
	
	public String getEid() {
		return eid;
	}

	/**
	 * ģ�������趨
	 *
	 * @param eid ģ������
	 */
	
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * ����汾ȡ��
	 *
	 * @return eiversion ����汾
	 */
	
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * ����汾�趨
	 *
	 * @param eiversion ����汾
	 */
	
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * ����С�汾ȡ��
	 *
	 * @return eismallversion ����С�汾
	 */
	
	public Integer getEismallversion() {
		return eismallversion;
	}

	/**
	 * ����С�汾�趨
	 *
	 * @param eismallversion ����С�汾
	 */
	
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	/**
	 * ���󸸽��ȡ��
	 *
	 * @return fatherEiid ���󸸽��
	 */
	
	public Integer getFatherEiid() {
		return fatherEiid;
	}

	/**
	 * ���󸸽���趨
	 *
	 * @param fatherEiid ���󸸽��
	 */
	
	public void setFatherEiid(Integer fatherEiid) {
		this.fatherEiid = fatherEiid;
	}

	/**
	 * ��ϵ��ȡ��
	 *
	 * @return rlnCode ��ϵ��
	 */
	
	public String getRlnCode() {
		return rlnCode;
	}

	/**
	 * ��ϵ���趨
	 *
	 * @param rlnCode ��ϵ��
	 */
	
	public void setRlnCode(String rlnCode) {
		this.rlnCode = rlnCode;
	}

	/**
	 * �Ƿ���Ҷ�ӽ��ȡ��
	 *
	 * @return isLeaf �Ƿ���Ҷ�ӽ��
	 */
	
	public String getIsLeaf() {
		return isLeaf;
	}

	/**
	 * �Ƿ���Ҷ�ӽ���趨
	 *
	 * @param isLeaf �Ƿ���Ҷ�ӽ��
	 */
	
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Integer getSourceEiid() {
		return sourceEiid;
	}

	public void setSourceEiid(Integer sourceEiid) {
		this.sourceEiid = sourceEiid;
	}

	public Integer getGrandpaEiid() {
		return grandpaEiid;
	}

	public void setGrandpaEiid(Integer grandpaEiid) {
		this.grandpaEiid = grandpaEiid;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEparcoding() {
		return eparcoding;
	}

	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}
	
}