package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.deliverik.framework.asset.model.IG445Info;

/**
 * �豸�ֲ�ʽͳ�Ʒ�����Ϣ��ƽ̨������
 * 
 */
@SuppressWarnings("serial")
@Entity
public class IG445VW implements Serializable,
	Cloneable, IG445Info {
	
	/** ���������*/
	@Id
	protected String orgsyscoding;
	
	/** ��������*/
	protected String orgname;
	
	/** ����*/
	protected Integer count;
	
	/** ��ռ�ٷ���*/
	@Transient
	protected String proportion;

	/**
	 * ȡ�û��������ȡ��
	 * @return ȡ�û��������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * ȡ�û���������趨
	 *
	 * @param orgsyscoding ȡ�û��������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * ȡ�û��������ȡ��
	 * @return ȡ�û��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ȡ�û��������趨
	 *
	 * @param orgname ȡ�û�������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * ȡ�ø���ȡ��
	 * @return ȡ�ø���
	 */
	public Integer getCount() {
		if(count==null){
			return 0;
		}else{
			return count;
		}
	}

	/**
	 * ȡ�ø����趨
	 *
	 * @param count ȡ�ø���
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * ȡ����ռ�ٷ���ȡ��
	 * @return ȡ����ռ�ٷ���
	 */
	public String getProportion() {
		return proportion;
	}

	/**
	 * ȡ����ռ�ٷ����趨
	 *
	 * @param proportion ȡ����ռ�ٷ���
	 */
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}

}
