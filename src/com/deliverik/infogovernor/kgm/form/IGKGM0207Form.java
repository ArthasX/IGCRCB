/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeGradeSearchCond;


/**
 * ����: ֪ʶ���ֲ�ѯ�ӿ�
 * ����������֪ʶ���ֲ�ѯ�ӿ�
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGKGM0207Form extends BaseForm implements KnowledgeGradeSearchCond,KnowledgeGrade{
	/**
	 *֪ʶ��key
	 */
	protected Integer knid;

	/**
	 *֪ʶ��keyȡ��
	 * 
	 * @return ֪ʶ��key
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *֪ʶ��key�趨
	 * 
	 * @param kgknid֪ʶ��key
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *����
	 */
	protected Integer kggrade;

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getKggrade() {
		return kggrade;
	}

	/**
	 *�����趨
	 * 
	 * @param kggrade����
	 */
	public void setKggrade(Integer kggrade) {
		this.kggrade = kggrade;
	}

	/**
	 *֪ʶ������
	 */
	protected String kgappraise;

	/**
	 *֪ʶ������ȡ��
	 * 
	 * @return ֪ʶ������
	 */
	public String getKgappraise() {
		return kgappraise;
	}

	/**
	 *֪ʶ�������趨
	 * 
	 * @param kgappraise֪ʶ������
	 */
	public void setKgappraise(String kgappraise) {
		this.kgappraise = kgappraise;
	}

	/**
	 *������
	 */
	protected String kguserid;

	/**
	 *������ȡ��
	 * 
	 * @return ������
	 */
	public String getKguserid() {
		return kguserid;
	}

	/**
	 *�������趨
	 * 
	 * @param kguseid������
	 */
	public void setKguserid(String kguserid) {
		this.kguserid = kguserid;
	}

	/**
	 *����ʱ��
	 */
	protected String kgtime;

	/**
	 *����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getKgtime() {
		return kgtime;
	}

	/**
	 *����ʱ���趨
	 * 
	 * @param kgtime����ʱ��
	 */
	public void setKgtime(String kgtime) {
		this.kgtime = kgtime;
	}

	protected String fingerPrint;
	public Integer getKgid() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

}
