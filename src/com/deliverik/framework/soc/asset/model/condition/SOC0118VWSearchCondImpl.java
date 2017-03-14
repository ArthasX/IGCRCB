/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;

/**
  * ����: SOC0118VW��������ʵ��
  * ��������: SOC0118VW��������ʵ��
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
public class SOC0118VWSearchCondImpl implements
		SOC0118VWSearchCond {
	
	/** ���ݿ�ID */
	protected Integer id;
	
	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ���� */
	protected String eilabel;
	
	/** �ʲ����� */
	protected String einame;
	
	protected String einame_q;
	
	/** �ʲ��汾�� */
	protected Integer eiversion;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	/** �ʲ�������������� */
	protected String eiorgsyscoding;
	
	/** �ʲ�ID��ƽ̨������ */
	protected String eiid;
	
	protected List<String> eilabel_list;
	
	/** �ʲ����ƣ���ȫƥ�� ��*/
	protected String einame_equal;
	
	/** �ʲ�����ʵ��ID */
	protected Integer eirootmark;
	
	/** �ʲ�eiid */
	protected List<Integer> eiids;
	
	/** �ʲ�ģ��ID */
	protected String[] eids;
	
	/** �洢����eq */
	protected String esyscoding_eq;
	/** �洢����like*/
	protected String esyscoding_like;
	
	/** ����CD */
	protected String ccid ;
	
	/** ����CD(��) */
	protected String pcid;
	
	/** ����CD״̬ */
	protected String cdstatus;
	
	protected String tableName;
	
	protected String numRows;
	
	protected String tableSpaceName;
	
	protected String instanceName;
	
	protected String businessName;
	protected String[] eid_arr;
	/**ҵ��ϵͳ�Ĺ�����Ա*/
	protected String magName;
	
	/**��Ҫ���˵���eiid(Ӧ����Դר��)*/
	protected String eiidNotIn;
	
	/** ��ҵ��ϵͳid */
	protected String eiid_cld_ywxt;
	/** �ӳ���id */
	protected String eiid_cld_cj;
	/** ��Ӧ����Դid */
	protected String eiid_cld_yjzy;

	/**
	 * @return the eiidNotIn
	 */
	public String getEiidNotIn() {
		return eiidNotIn;
	}

	/**
	 * @param eiidNotIn the eiidNotIn to set
	 */
	public void setEiidNotIn(String eiidNotIn) {
		this.eiidNotIn = eiidNotIn;
	}

	/**
	 * @return the ���ݿ�id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**einame����*/
	protected List<String> einame_in;
	
	
	protected String eilabel_like;
	
	/**ip�����ʶ*/
	protected String eidesc_falg;
	
	protected String eiupdtime_from;
	
	protected String eiupdtime_to;
	/**�Ƿ����ڼ�Ⱥ*/
	protected boolean isClumped;
	/** �ʲ�״̬ */
	protected String eistatus;
	
	/** �ʲ��Ǽ�ʱ�� */
	protected String eiinsdate_like;
	/** ������ */
	protected String eiusername;
	
	/**
	 * ҵ��ϵͳID
	 * ����ҵ��ϵͳ��ѯ�����������ʱʹ��
	 * */
	protected Integer systemId;
	
	protected String environmentType;
	/**�Ƿ�����*/
	protected boolean upgrade;
	/**�������ڴ���*/
	protected String eiinsdate_gt;
	/**��������С��*/
	protected String eiinsdate_lt;
	/**��ʼʱ��*/
	protected String propentime;
	
	/**����ʱ��*/
	protected String prclosetime;

	/**��������*/
	protected List<SOC0118VWPK> PKs;
	
	/**
	 * @return the ��������pKs
	 */
	public List<SOC0118VWPK> getPKs() {
		return PKs;
	}

	/**
	 * @param pKs the pKs to set
	 */
	public void setPKs(List<SOC0118VWPK> pKs) {
		PKs = pKs;
	}

	public String getEiinsdate_gt() {
		return eiinsdate_gt;
	}

	public void setEiinsdate_gt(String eiinsdate_gt) {
		this.eiinsdate_gt = eiinsdate_gt;
	}

	public String getEiinsdate_lt() {
		return eiinsdate_lt;
	}

	public void setEiinsdate_lt(String eiinsdate_lt) {
		this.eiinsdate_lt = eiinsdate_lt;
	}

	public boolean isUpgrade() {
		return upgrade;
	}

	public void setUpgrade(boolean upgrade) {
		this.upgrade = upgrade;
	}

	public String getEidesc_falg() {
		return eidesc_falg;
	}

	public void setEidesc_falg(String eidesc_falg) {
		this.eidesc_falg = eidesc_falg;
	}

	public String getEilabel_like() {
		return eilabel_like;
	}

	public void setEilabel_like(String eilabel_like) {
		this.eilabel_like = eilabel_like;
	}

	public List<String> getEiname_in() {
		return einame_in;
	}

	public void setEiname_in(List<String> einame_in) {
		this.einame_in = einame_in;
	}

	public String getMagName() {
		return magName;
	}

	public void setMagName(String magName) {
		this.magName = magName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getNumRows() {
		return numRows;
	}

	public void setNumRows(String numRows) {
		this.numRows = numRows;
	}

	public String getTableSpaceName() {
		return tableSpaceName;
	}

	public void setTableSpaceName(String tableSpaceName) {
		this.tableSpaceName = tableSpaceName;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	/**
	 * �ʲ�ģ��IDȡ��
	 *
	 * @return eids �ʲ�ģ��ID
	 */
	
	public String[] getEids() {
		return eids;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eids �ʲ�ģ��ID
	 */
	
	public void setEids(String[] eids) {
		this.eids = eids;
	}

	/**
	 * �ʲ�eiidȡ��
	 *
	 * @return eiids �ʲ�eiid
	 */
	
	public List<Integer> getEiids() {
		return eiids;
	}

	/**
	 * �ʲ�eiid�趨
	 *
	 * @param eiids �ʲ�eiid
	 */
	
	public void setEiids(List<Integer> eiids) {
		this.eiids = eiids;
	}

	/**
	 * �ʲ����ƣ���ȫƥ�� ��ȡ��
	 * @return �ʲ����ƣ���ȫƥ�� ��
	 */
	public String getEiname_equal() {
		return einame_equal;
	}

	/**
	 * �ʲ����ƣ���ȫƥ�� ���趨
	 *
	 * @param einame_equal �ʲ����ƣ���ȫƥ�� ��
	 */
	public void setEiname_equal(String einame_equal) {
		this.einame_equal = einame_equal;
	}

	public List<String> getEilabel_list() {
		return eilabel_list;
	}

	public void setEilabel_list(List<String> eilabel_list) {
		this.eilabel_list = eilabel_list;
	}

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	/**
	 * �ʲ���������������趨
	 *
	 * @param eiorgsyscoding �ʲ��������������
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ʲ�����趨
	 *
	 * @param eilabel �ʲ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ʲ�����ȡ��
	 * @return �ʲ�����
	 */
	public String getEiname() {
		return einame;
	}


	/**
	 * �ʲ������趨
	 *
	 * @param einame �ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �ʲ��汾��ȡ��
	 * @return �ʲ��汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �ʲ��汾���趨
	 *
	 * @param eiversion �ʲ��汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	
	/**
	 * �ʲ�С�汾�趨
	 *
	 * @param eismallversion �ʲ�С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	/**
	 * �ʲ�����ʵ��IDȡ��
	 * @return �ʲ�����ID
	 */
	public Integer getEirootmark()
	{
		return eirootmark;
	}
	/**
	 * �ʲ�����ʵ��ID�趨
	 *
	 * @param eirootmark �ʲ�����ʵ��ID
	 */
	public void setEirootmark(Integer eirootmark)
	{
		this.eirootmark = eirootmark;
	}

	/**
	 * �洢����eqȡ��
	 *
	 * @return esyscoding_eq �洢����eq
	 */
	public String getEsyscoding_eq() {
		return esyscoding_eq;
	}

	/**
	 * �洢����eq�趨
	 *
	 * @param esyscoding_eq �洢����eq
	 */
	public void setEsyscoding_eq(String esyscoding_eq) {
		this.esyscoding_eq = esyscoding_eq;
	}

	/**
	 * �洢����likeȡ��
	 *
	 * @return esyscoding_like �洢����like
	 */
	public String getEsyscoding_like() {
		return esyscoding_like;
	}

	/**
	 * �洢����like�趨
	 *
	 * @param esyscoding_like �洢����like
	 */
	public void setEsyscoding_like(String esyscoding_like) {
		this.esyscoding_like = esyscoding_like;
	}

	public String getCcid() {
		return ccid;
	}

	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	public String getPcid() {
		return pcid;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	public String getCdstatus() {
		return cdstatus;
	}

	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}
	public String[] getEid_arr() {
		return eid_arr;
	}
	public void setEid_arr(String[] eid_arr) {
		this.eid_arr = eid_arr;
	}

	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}

	public Integer getSystemId() {
		return systemId;
	}
	/**
	 * ����ҵ��ϵͳ��ѯ�����������������Ϣʱʹ��
	 * @param systemId
	 */
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	/**
	 * 
	 */
	public String getEnvironmentType() {
		return environmentType;
	}

	/**
	 * ���û������� (����,ͬ��,��� ��Ӧ soc0151��010 ��ֵ)
	 * @param environmentType
	 */
	public void setEnvironmentType(String environmentType) {
		this.environmentType = environmentType;
	}

	public boolean isClumped() {
		return isClumped;
	}
	/**
	 * �Ƿ����ڼ�Ⱥ
	 * @param isClumped
	 */
	public void setClumped(boolean isClumped) {
		this.isClumped = isClumped;
	}
	
	protected String eitype;
	
	
	public String getEitype() {
		return eitype;
	}

	public void setEitype(String eitype) {
		this.eitype = eitype;
	}

	/**
	 * @return the �ʲ�״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * @param �ʲ�״̬ the eistatus to set
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * @return the eiinsdate_like
	 */
	public String getEiinsdate_like() {
		return eiinsdate_like;
	}

	/**
	 * @param eiinsdate_like the eiinsdate_like to set
	 */
	public void setEiinsdate_like(String eiinsdate_like) {
		this.eiinsdate_like = eiinsdate_like;
	}

	/**
	 * @return the ������
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * @param ������ the eiusername to set
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**  
	 * ��ȡ��ʼʱ��  
	 * @return propentime ��ʼʱ��  
	 */
	
	public String getPropentime() {
		return propentime;
	}

	/**  
	 * ���ÿ�ʼʱ��  
	 * @param propentime ��ʼʱ��  
	 */
	
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**  
	 * ��ȡ����ʱ��  
	 * @return prclosetime ����ʱ��  
	 */
	
	public String getPrclosetime() {
		return prclosetime;
	}

	/**  
	 * ���ý���ʱ��  
	 * @param prclosetime ����ʱ��  
	 */
	
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public String getEiname_q() {
		return einame_q;
	}

	public void setEiname_q(String einame_q) {
		this.einame_q = einame_q;
	}

	public String getEiid_cld_ywxt() {
		return eiid_cld_ywxt;
	}

	public void setEiid_cld_ywxt(String eiid_cld_ywxt) {
		this.eiid_cld_ywxt = eiid_cld_ywxt;
	}

	public String getEiid_cld_cj() {
		return eiid_cld_cj;
	}

	public void setEiid_cld_cj(String eiid_cld_cj) {
		this.eiid_cld_cj = eiid_cld_cj;
	}

	public String getEiid_cld_yjzy() {
		return eiid_cld_yjzy;
	}

	public void setEiid_cld_yjzy(String eiid_cld_yjzy) {
		this.eiid_cld_yjzy = eiid_cld_yjzy;
	}
	
}