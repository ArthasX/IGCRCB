/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;

/**
 * ����: ֪ʶ���ѯ��ϢTBʵ��
 * ����������֪ʶ���ѯ��ϢTBʵ��
 * ������¼��wangxiaoqiang    2010/12/07
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
@Entity
public class KnowLedgeInfoVW implements Serializable, Cloneable, KnowLedgeInfo {
	@Id
	/**����*/
	protected Integer knid;

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *�����趨
	 * 
	 * @param knid����
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *֪ʶ�����
	 */
	protected String knclass;

	/**
	 *֪ʶ�����ȡ��
	 * 
	 * @return ֪ʶ�����
	 */
	public String getKnclass() {
		return knclass;
	}

	/**
	 *֪ʶ������趨
	 * 
	 * @param knclass֪ʶ�����
	 */
	public void setKnclass(String knclass) {
		this.knclass = knclass;
	}

	/**
	 *֪ʶ���������
	 */
	protected String knclassname;

	/**
	 *֪ʶ���������ȡ��
	 * 
	 * @return ֪ʶ���������
	 */
	public String getKnclassname() {
		return knclassname;
	}

	/**
	 *֪ʶ����������趨
	 * 
	 * @param knclassname ֪ʶ���������
	 */
	public void setKnclassname(String knclassname) {
		this.knclassname = knclassname;
	}
	
	/**
	 *������
	 */
	protected String knproffername;

	/**
	 *������ȡ��
	 * 
	 * @return ������
	 */
	public String getKnproffername() {
		return knproffername;
	}

	/**
	 *�������趨
	 * 
	 * @param knproffername������
	 */
	public void setKnproffername(String knproffername) {
		this.knproffername = knproffername;
	}

	/**
	 *֪ʶ����
	 */
	protected String kntitle;

	/**
	 *֪ʶ����ȡ��
	 * 
	 * @return ֪ʶ����
	 */
	public String getKntitle() {
		return kntitle;
	}

	/**
	 *֪ʶ�����趨
	 * 
	 * @param kntitle֪ʶ����
	 */
	public void setKntitle(String kntitle) {
		this.kntitle = kntitle;
	}

	/**
	 *�¼�
	 */
	protected String knapprovetime;

	/**
	 *�¼�ȡ��
	 * 
	 * @return �¼�
	 */
	public String getKnapprovetime() {
		return knapprovetime;
	}

	/**
	 *�¼��趨
	 * 
	 * @param knapprovetime�¼�
	 */
	public void setKnapprovetime(String knapprovetime) {
		this.knapprovetime = knapprovetime;
	}

	/**
	 *������
	 */
	protected String grade;

	/**
	 *������ȡ��
	 * 
	 * @return ������
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 *�������趨
	 * 
	 * @param grade������
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	/**
	 * ��������
	 */
	protected Integer processnum;

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getProcessnum() {
		return processnum;
	}

	/**
	 * ���������趨
	 * @param processnum ��������
	 */
	public void setProcessnum(Integer processnum) {
		this.processnum = processnum;
	}
	
	/**
	 * ֪ʶ�汾
	 */
	protected Integer knversion;

	/**
	 * ֪ʶ�汾ȡ��
	 * @return ֪ʶ�汾
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * ֪ʶ�汾�趨
	 * @param knversion ֪ʶ�汾
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}
	
	/**��� */
	protected String knserial;
	
	/**
	 *���ȡ��
	 * 
	 * @return ���
	 */
	public String getKnserial() {
		return knserial;
	}

	/**
	 *����趨
	 * 
	 * @param knserial���
	 */
	public void setKnserial(String knserial) {
		this.knserial = knserial;
	}

	
}
