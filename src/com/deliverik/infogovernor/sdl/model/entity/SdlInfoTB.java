/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sdl.model.SdlInfo;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_����ˮƽ��ϢMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SdlInfo")
public class SdlInfoTB extends BaseEntity implements Serializable, Cloneable, SdlInfo {

	@Id
	@TableGenerator(
		    name="SDLINFO_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="SDLINFO_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SDLINFO_TABLE_GENERATOR")
	/**����*/
	protected Integer siid;
	/**���*/
	protected String sitype;
	/**˵��*/
	protected String sidesc;
	/**��ʼʱ��*/
	protected String sibegin;
	/**����ʱ��*/
	protected String siend;
	/**����*/
	protected Integer simark;
	/**����ʲ�ID*/
	protected Integer sieiid;
	/**����ʲ�����*/
	protected String sieiname;
	/**����¼�����ID*/
	protected Integer siprid;
	/**����¼���������*/
	protected String siprtitle;
	/**����*/
	protected String siattkey;
	/**�Ǽ�����*/
	protected String sidate;
	/**ʵ��ʱ��*/
	protected Integer sifacttime;

	/**
	 * ��ȡ����
	 * @return 
	 */
	public Serializable getPK() {
		return siid;
	}

	/**
	 * �Ƚ�
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof SdlInfoTB))
			return false;
		SdlInfo target = (SdlInfo) obj;
		if (!(getSiid()==target.getSiid()))
			return false;

		return true;
	}

	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Integer getSiid() {
		return siid;
	}

	/**
	 * ��������
	 * @param siid ����
	 */
	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	/**
	 * ��ȡ���
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
	 * ��ȡ˵��
	 * @return ˵��
	 */
	public String getSidesc() {
		return sidesc;
	}

	/**
	 * ����˵��
	 * @param sidesc ˵��
	 */
	public void setSidesc(String sidesc) {
		this.sidesc = sidesc;
	}

	/**
	 * ��ȡ��ʼʱ��
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
	 * ��ȡ����
	 * @return ����
	 */
	public Integer getSimark() {
		return simark;
	}

	/**
	 * ��������
	 * @param simark ����
	 */
	public void setSimark(Integer simark) {
		this.simark = simark;
	}

	/**
	 * ��ȡ����ʲ�ID
	 * @return ����ʲ�ID
	 */
	public Integer getSieiid() {
		return sieiid;
	}

	/**
	 * ��������ʲ�ID
	 * @param sieiid ����ʲ�ID
	 */
	public void setSieiid(Integer sieiid) {
		this.sieiid = sieiid;
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
	 * ��ȡ�������ID
	 * @return �������ID
	 */
	public Integer getSiprid() {
		return siprid;
	}

	/**
	 * �����������ID
	 * @param siprid �������ID
	 */
	public void setSiprid(Integer siprid) {
		this.siprid = siprid;
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
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public String getSiattkey() {
		return siattkey;
	}

	/**
	 * ���ø���
	 * @param siattkey ����
	 */
	public void setSiattkey(String siattkey) {
		this.siattkey = siattkey;
	}
	/**
	 * ��ȡ�Ǽ�����
	 * @return �Ǽ�����
	 */
	public String getSidate() {
		return sidate;
	}

	/**
	 * ���õǼ�����
	 * @param sidate �Ǽ�����
	 */
	public void setSidate(String sidate) {
		this.sidate = sidate;
	}
	/**
	 * ��ȡʵ��ʱ��
	 * @return ʵ��ʱ��
	 */
	public Integer getSifacttime() {
		return sifacttime;
	}

	/**
	 * ����ʵ��ʱ��
	 * @param sidate ʵ��ʱ��
	 */
	public void setSifacttime(Integer sifacttime) {
		this.sifacttime = sifacttime;
	}
	
}
