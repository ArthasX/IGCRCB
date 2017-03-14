/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.smr.model.FillInQualityAssessInfo;

/**
 * ����:��������� 
 * �������������������
 * �����ˣ�����͢
 * ������¼�� 2012-12-21
 * �޸ļ�¼��
 */
@Entity
public class FillInQualityAssessVW implements FillInQualityAssessInfo{

	@Id
	protected Integer id;
	
	/** ���Ż����� */
	protected String pporgid;
	
	/** ���Ż����� */
	protected String pporgname;
	
	/** �û�id */
	protected String ppuserid;
	
	/** �û��� */
	protected String username;
	
	/** �걨���id�������id */
	protected String ppuserid1;
	
	/** �������id�������id */
	protected String ppuserid2;
	
	/** �����ڱ����id�������id */
	protected String ppuserid3;
	
	/** �걨�Ƿ�ʱ */
	protected String timely1;
	
	/** �����Ƿ�ʱ */
	protected String timely2;
	
	/** �����ڱ��Ƿ�ʱ */
	protected String timely3;
	
	/** �걨��Ƿ�׼ȷ */
	protected String truely1;
	
	/** ��������Ƿ�׼ȷ */
	protected String truely2;
	
	/** �����ڱ�����Ƿ�׼ȷ */
	protected String truely3;
	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * �����趨
	 *
	 * @param prid ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * �û�id���߲��Ż����� ȡ��
	 *
	 * @return �û�id���߲��Ż�����
	 */
	public String getPpuserid() {
		return ppuserid;
	}
	
	/**
	 * �û�id���߲��Ż����� �趨
	 *
	 * @param ppuserid �û�id���߲��Ż����� 
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}
	/**
	 * �û������߲����� ȡ��
	 *
	 * @return �û������߲�����
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * �û������߲����� �趨
	 *
	 * @param username �û������߲�����
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * �걨���id�������idȡ��
	 *
	 * @return �걨���id�������id
	 */
	public String getPpuserid1() {
		return ppuserid1;
	}
	/**
	 * �걨���id�������id �趨
	 *
	 * @param ppuserid1 �걨���id�������id
	 */
	public void setPpuserid1(String ppuserid1) {
		this.ppuserid1 = ppuserid1;
	}
	/**
	 * �������id�������id ȡ��
	 *
	 * @return �������id�������id 
	 */
	public String getPpuserid2() {
		return ppuserid2;
	}
	/**
	 * �������id�������id  �趨
	 *
	 * @param ppuserid2 �������id�������id 
	 */
	public void setPpuserid2(String ppuserid2) {
		this.ppuserid2 = ppuserid2;
	}
	/**
	 *�����ڱ����id�������id ȡ��
	 *
	 * @return �����ڱ����id�������id
	 */
	public String getPpuserid3() {
		return ppuserid3;
	}
	/**
	 * �����ڱ����id�������id  �趨
	 *
	 * @param ppuserid3 �����ڱ����id�������id
	 */
	public void setPpuserid3(String ppuserid3) {
		this.ppuserid3 = ppuserid3;
	}
	/**
	 *�걨�Ƿ�ʱ ȡ��
	 *
	 * @return �걨�Ƿ�ʱ
	 */
	public String getTimely1() {
		return timely1;
	}
	/**
	 * �걨�Ƿ�ʱ  �趨
	 *
	 * @param timely1 �걨�Ƿ�ʱ
	 */
	public void setTimely1(String timely1) {
		this.timely1 = timely1;
	}
	/**
	 *�����Ƿ�ʱ ȡ��
	 *
	 * @return �����Ƿ�ʱ
	 */
	public String getTimely2() {
		return timely2;
	}
	/**
	 * �����Ƿ�ʱ  �趨
	 *
	 * @param timely2 �����Ƿ�ʱ
	 */
	public void setTimely2(String timely2) {
		this.timely2 = timely2;
	}
	/**
	 *�����ڱ��Ƿ�ʱ ȡ��
	 *
	 * @return �����ڱ��Ƿ�ʱ
	 */
	public String getTimely3() {
		return timely3;
	}
	/**
	 * �����ڱ��Ƿ�ʱ  �趨
	 *
	 * @param timely3�����ڱ��Ƿ�ʱ
	 */
	public void setTimely3(String timely3) {
		this.timely3 = timely3;
	}
	public String getPporgid() {
		return pporgid;
	}
	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}
	public String getPporgname() {
		return pporgname;
	}
	public void setPporgname(String pporgname) {
		this.pporgname = pporgname;
	}
	public String getTruely1() {
		return truely1;
	}
	public void setTruely1(String truely1) {
		this.truely1 = truely1;
	}
	public String getTruely2() {
		return truely2;
	}
	public void setTruely2(String truely2) {
		this.truely2 = truely2;
	}
	public String getTruely3() {
		return truely3;
	}
	public void setTruely3(String truely3) {
		this.truely3 = truely3;
	}
	
	
}
