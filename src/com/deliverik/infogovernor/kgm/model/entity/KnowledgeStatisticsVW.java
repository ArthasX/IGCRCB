/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.kgm.model.KnowledgeStatisticsInfo;

/**
 * ����: ֪ʶ��ͳ��ʵ��
 * ����������֪ʶ��ͳ��
 * ������¼��wanglei 2014/3/13
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
@Entity
public class KnowledgeStatisticsVW implements Serializable, Cloneable, KnowledgeStatisticsInfo{
	@Id
	/**���� */
	protected Integer klsid;
	
	/**ͳ������ */
	protected Integer klscount;
	
	/**֪ʶ������id */
	protected String knproffer;
	
	/**֪ʶ����������*/
	protected String knproffername;

	/**֪ʶ���� */
	protected String knclass;
	
	/**֪ʶ�������� */
	protected String knclassname;
	
	/**
	 *֪ʶ����������ȡ��
	 * 
	 * @return ֪ʶ����������
	 */
	public String getKnproffername() {
		return knproffername;
	}

	/**
	 * ֪ʶ�����������趨
	 * @param knproffername ֪ʶ����������
	 */
	public void setKnproffername(String knproffername) {
		this.knproffername = knproffername;
	}

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getKlsid() {
		return klsid;
	}
	
	/**
	 *�����趨
	 * 
	 * @param knid����
	 */
	public void setKlsid(Integer klsid) {
		this.klsid = klsid;
	}
	
	/**
	 *ͳ������ȡ��
	 * 
	 * @return ͳ������
	 */
	public Integer getKlscount() {
		return klscount;
	}

	/**
	 *ͳ�������趨
	 * 
	 * @param klscountͳ������
	 */
	public void setKlscount(Integer klscount) {
		this.klscount = klscount;
	}

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getKnclass() {
		return knclass;
	}

	/**
	 *�����趨
	 * 
	 * @param knclass����
	 */
	public void setKnclass(String knclass) {
		this.knclass = knclass;
	}

	/**
	 *֪ʶ������ȡ��
	 * 
	 * @return ֪ʶ������
	 */
	public String getKnproffer() {
		return knproffer;
	}

	/**
	 *֪ʶ�������趨
	 * 
	 * @param knproffer֪ʶ������
	 */
	public void setKnproffer(String knproffer) {
		this.knproffer = knproffer;
	}

	/**
	 *�������ȡ��
	 * 
	 * @return �������
	 */
	public String getKnclassname() {
		return knclassname;
	}
	
	/**
	 *��������趨
	 * 
	 * @param knclassname �������
	 */
	public void setKnclassname(String knclassname) {
		this.knclassname = knclassname;
	}

}
