/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
  * ����: ��ͬ�ʲ���Ϣ��ͼʵ��
  * ��������: ��ͬ�ʲ���Ϣ��ͼʵ��
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "IG499")
public class IG499VW implements Serializable,Cloneable, IG499Info {
	@Id
	/** �ʲ�ID */
	protected Integer eiid;

	/** �ʲ�ģ��ID */
	protected String eid;

	/** �ʲ����� */
	protected String einame;

	/** �ʲ�˵�� */
	protected String eidesc;

	/** �ʲ���� */
	protected String eilabel;

	/** �ʲ����ʱ�� */
	protected String eiupdtime;

	/** �ʲ�״̬ */
	protected String eistatus;

	/** �ʲ�ģ������ */
	protected String ename;

	/** �ʲ�ģ�ͱ�� */
	protected String elabel;

	/** �ʲ�ģ��˵�� */
	protected String edesc;

	/** �ʲ�ģ��״̬ */
	protected String estatus;

	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;

	/** �ʲ�ģ��һ������ */
	protected String ekey1;

	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;

	/** �ʲ�ģ���������� */
	protected String ekey3;

	/** �ʲ��汾�� */
	protected Integer eiversion;

	/** �ʲ��Ǽ��� */
	protected String eiinsdate;

	/** �ʲ��������� */
	protected String eiorgsyscoding;

	/** �ʲ�ģ�� */
	protected String esyscoding;

	/** �ʲ������� */
	protected String eiuserid;

	/** �ʲ����������� */
	protected String eiusername;

	/** �ʲ�С�汾 */
	protected Integer eismallversion;

	/** �ʲ����������ڵ�ʵ���ʶ */
	protected Integer eirootmark;

	/** ������ */
	protected String facilitator;

	/** ǩ��ʱ�� */
	protected String condudetime;

	/** ������ */
	protected String operator;

	/** ��ͬ��� */
	protected String compacttype;

	/** ��ͬ�� */
	protected String contractpayment;

	/** �Ѹ��� */
	protected String countmoney;

	/** ��󸶿��� */
	protected String lastdatetime;
	
	/** ����Ԥ���� */
	protected String imprest;
	
	/** �ʲ�����������Ϣʵ�� */
	@Transient
	protected OrganizationTB organizationTB;

	/**
	 * �ʲ�IDȡ��
	 *
	 * @return �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 *
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
	 * �ʲ�����ȡ��
	 *
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
	 * �ʲ�˵��ȡ��
	 *
	 * @return �ʲ�˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * �ʲ�˵���趨
	 *
	 * @param eidesc �ʲ�˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * �ʲ����ȡ��
	 *
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
	 * �ʲ����ʱ��ȡ��
	 *
	 * @return �ʲ����ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * �ʲ����ʱ���趨
	 *
	 * @param eiupdtime �ʲ����ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * �ʲ�״̬ȡ��
	 *
	 * @return �ʲ�״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * �ʲ�״̬�趨
	 *
	 * @param eistatus �ʲ�״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * �ʲ�ģ������ȡ��
	 *
	 * @return �ʲ�ģ������
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param ename �ʲ�ģ������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * �ʲ�ģ�ͱ��ȡ��
	 *
	 * @return �ʲ�ģ�ͱ��
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * �ʲ�ģ�ͱ���趨
	 *
	 * @param elabel �ʲ�ģ�ͱ��
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * �ʲ�ģ��˵��ȡ��
	 *
	 * @return �ʲ�ģ��˵��
	 */
	public String getEdesc() {
		return edesc;
	}

	/**
	 * �ʲ�ģ��˵���趨
	 *
	 * @param edesc �ʲ�ģ��˵��
	 */
	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}

	/**
	 * �ʲ�ģ��״̬ȡ��
	 *
	 * @return �ʲ�ģ��״̬
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * �ʲ�ģ��״̬�趨
	 *
	 * @param estatus �ʲ�ģ��״̬
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * �ʲ�ģ�ͷ���ȡ��
	 *
	 * @return �ʲ�ģ�ͷ���
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * �ʲ�ģ�ͷ����趨
	 *
	 * @param ecategory �ʲ�ģ�ͷ���
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	/**
	 * �ʲ�ģ��һ������ȡ��
	 *
	 * @return �ʲ�ģ��һ������
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * �ʲ�ģ��һ�������趨
	 *
	 * @param ekey1 �ʲ�ģ��һ������
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * �ʲ�ģ�Ͷ�������ȡ��
	 *
	 * @return �ʲ�ģ�Ͷ�������
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * �ʲ�ģ�Ͷ��������趨
	 *
	 * @param ekey2 �ʲ�ģ�Ͷ�������
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * �ʲ�ģ����������ȡ��
	 *
	 * @return �ʲ�ģ����������
	 */
	public String getEkey3() {
		return ekey3;
	}

	/**
	 * �ʲ�ģ�����������趨
	 *
	 * @param ekey3 �ʲ�ģ����������
	 */
	public void setEkey3(String ekey3) {
		this.ekey3 = ekey3;
	}

	/**
	 * �ʲ��汾��ȡ��
	 *
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
	 * �ʲ��Ǽ���ȡ��
	 *
	 * @return �ʲ��Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �ʲ��Ǽ����趨
	 *
	 * @param eiinsdate �ʲ��Ǽ���
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * �ʲ���������ȡ��
	 *
	 * @return �ʲ���������
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * �ʲ����������趨
	 *
	 * @param eiorgsyscoding �ʲ���������
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * �ʲ�ģ��ȡ��
	 *
	 * @return �ʲ�ģ��
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�ģ���趨
	 *
	 * @param esyscoding �ʲ�ģ��
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * �ʲ�������ȡ��
	 *
	 * @return �ʲ�������
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * �ʲ��������趨
	 *
	 * @param eiuserid �ʲ�������
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * �ʲ�����������ȡ��
	 *
	 * @return �ʲ�����������
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * �ʲ������������趨
	 *
	 * @param eiusername �ʲ�����������
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * �ʲ�С�汾ȡ��
	 *
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
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 *
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}

	/**
	 * �ʲ����������ڵ�ʵ���ʶ�趨
	 *
	 * @param eirootmark �ʲ����������ڵ�ʵ���ʶ
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getFacilitator() {
		return facilitator;
	}

	/**
	 * �������趨
	 *
	 * @param facilitator ������
	 */
	public void setFacilitator(String facilitator) {
		this.facilitator = facilitator;
	}

	/**
	 * ǩ��ʱ��ȡ��
	 *
	 * @return ǩ��ʱ��
	 */
	public String getCondudetime() {
		return condudetime;
	}

	/**
	 * ǩ��ʱ���趨
	 *
	 * @param condudetime ǩ��ʱ��
	 */
	public void setCondudetime(String condudetime) {
		this.condudetime = condudetime;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * �������趨
	 *
	 * @param operator ������
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * ��ͬ���ȡ��
	 *
	 * @return ��ͬ���
	 */
	public String getCompacttype() {
		return compacttype;
	}

	/**
	 * ��ͬ����趨
	 *
	 * @param compacttype ��ͬ���
	 */
	public void setCompacttype(String compacttype) {
		this.compacttype = compacttype;
	}

	/**
	 * ��ͬ��ȡ��
	 *
	 * @return ��ͬ��
	 */
	public String getContractpayment() {
		return contractpayment;
	}

	/**
	 * ��ͬ���趨
	 *
	 * @param contractpayment ��ͬ��
	 */
	public void setContractpayment(String contractpayment) {
		this.contractpayment = contractpayment;
	}

	/**
	 * �Ѹ���ȡ��
	 *
	 * @return �Ѹ���
	 */
	public String getCountmoney() {
		return countmoney;
	}

	/**
	 * �Ѹ����趨
	 *
	 * @param countmoney �Ѹ���
	 */
	public void setCountmoney(String countmoney) {
		this.countmoney = countmoney;
	}

	/**
	 * ��󸶿���ȡ��
	 *
	 * @return ��󸶿���
	 */
	public String getLastdatetime() {
		return lastdatetime;
	}

	/**
	 * ��󸶿����趨
	 *
	 * @param lastdatetime ��󸶿���
	 */
	public void setLastdatetime(String lastdatetime) {
		this.lastdatetime = lastdatetime;
	}

	/**
	 * ����Ԥ����ȡ��
	 * @return ����Ԥ����
	 */
	public String getImprest() {
		return imprest;
	}

	/**
	 * ����Ԥ�����趨
	 * @param imprest����Ԥ����
	 */
	public void setImprest(String imprest) {
		this.imprest = imprest;
	}
	
	/**
	 * �ʲ�����������Ϣʵ��ȡ��
	 * @return �ʲ�����������Ϣʵ��
	 */
	public OrganizationTB getOrganizationTB() {
		if(this.organizationTB == null){
			if(StringUtils.isNotEmpty(this.eiorgsyscoding)){
				OrganizationBL bl = (OrganizationBL) WebApplicationSupport.getBean("organizationBL");
				OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
				cond.setOrgsyscoding(this.eiorgsyscoding);
				List<Organization> list = bl.searchOrganization(cond);
				if(list.size() == 1){
					this.organizationTB = (OrganizationTB) list.get(0);
				}
			}
		}
		return organizationTB;
	}

	/**
	 * �ʲ�����������Ϣʵ���趨
	 *
	 * @param organizationTB �ʲ�����������Ϣʵ��
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}
}