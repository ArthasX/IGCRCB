package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.entity.OrganizationTB;


/**
 * �ʲ���Ϣʵ��
 *
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "IG688")
@SuppressWarnings("serial")
//public class EntityItemVW extends BaseEntity implements Serializable, Cloneable, EntityItemVWInfo {
public class IG688VW implements Serializable, Cloneable, IG688Info {

	/** �ʲ�ID */
	@Id
	protected Integer eiid;
	
	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ����� */
	protected String einame;
	
	/** �ʲ���� */
	protected String eilabel;
	
	/** �ʲ�˵�� */
	protected String eidesc;
	
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
	
	/** �ʲ���������*/
	protected String eiorgsyscoding;
	
	/** �ʲ�ģ��*/
	protected String esyscoding;
	
	/** �ʲ��ѽ�����ϵ���� */
	protected String eircount;
	
	/** �ʲ�������*/
	protected String eiuserid;
	
	/** �ʲ�����������*/
	protected String eiusername;
	
	/** �ʲ����*/
	protected String serial;
	
	/** �ʲ���������*/
	protected String buytime;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	/** �ʲ����������ڵ�ʵ���ʶ */
	protected Integer eirootmark;
	
	/** �ʲ�ģ�����0��һ���ʲ�ģ�� 1�������ʲ�ģ�ͣ� */
	protected String emodeltype;
	
	/** �ʲ�����������Ϣʵ�� */
	@Transient
	protected OrganizationTB organizationTB;
	
	
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getBuytime() {
		return buytime;
	}

	public void setBuytime(String buytime) {
		this.buytime = buytime;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return eiid;
	}

	/**
	 * �ʲ�IDȡ��
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
	 * �ʲ�����ʱ��ȡ��
	 * @return �ʲ�����ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * �ʲ�����ʱ���趨
	 *
	 * @param eiupdtime �ʲ�����ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * �ʲ�״̬ȡ��
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
	 * �ʲ�ģ������ȡ��
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
	 * �ʲ�ģ��˵���趨
	 *
	 * @param edesc �ʲ�ģ��˵��
	 */
	public String getEdesc() {
		return edesc;
	}


	/**
	 * �ʲ�ģ��״̬ȡ��
	 * @return �ʲ�ģ��״̬
	 */
	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}


	/**
	 * �ʲ�ģ��״̬ȡ��
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
	 * �ʲ�ģ�ͱ��ȡ��
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
	 * �ʲ��Ǽ���ȡ��
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
	 * �ʲ��ѽ�����ϵ����ȡ��
	 * @return �ʲ��ѽ�����ϵ����
	 */
	public String getEircount() {
		return eircount;
	}

	/**
	 * �ʲ��ѽ�����ϵ�����趨
	 *
	 * @param eircount �ʲ��ѽ�����ϵ����
	 */
	public void setEircount(String eircount) {
		this.eircount = eircount;
	}
	
	/**
	 * �ʲ�������ȡ��
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
	 * �ʲ����������ڵ�ʵ���ʶȡ��
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
	 * �ʲ�ģ�����ȡ��
	 * @return �ʲ�ģ�����
	 */
	public String getEmodeltype() {
		return emodeltype;
	}
	/**
	 * �ʲ�ģ������趨
	 *
	 * @param eparcoding �ʲ�ģ�����
	 */
	public void setEmodeltype(String emodeltype) {
		this.emodeltype = emodeltype;
	}
	
}
