/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG900Info;

/**
  * ����: ���̰�ť�����ʵ��
  * ��������: ���̰�ť�����ʵ��
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG900")
public class IG900TB extends BaseEntity implements Serializable,
		Cloneable, IG900Info {

	/** ������01���£�02ȷ�ϣ�ȷ�ϣ�������1��ͷ */
	@Id
	protected String pbdid;

	/** ��ťĬ������ */
	protected String pbdname;

	/** �Ƿ�ϵͳ������ť��1��0�� */
	protected String pbdflag;

	/** ��ť��ʾͼƬ���� */
	protected String pbdimage;

	/**
	 * ������01���£�02ȷ�ϣ�ȷ�ϣ�������1��ͷȡ��
	 *
	 * @return ������01���£�02ȷ�ϣ�ȷ�ϣ�������1��ͷ
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * ������01���£�02ȷ�ϣ�ȷ�ϣ�������1��ͷ�趨
	 *
	 * @param pbdid ������01���£�02ȷ�ϣ�ȷ�ϣ�������1��ͷ
	 */
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
	}

	/**
	 * ��ťĬ������ȡ��
	 *
	 * @return ��ťĬ������
	 */
	public String getPbdname() {
		return pbdname;
	}

	/**
	 * ��ťĬ�������趨
	 *
	 * @param pbdname ��ťĬ������
	 */
	public void setPbdname(String pbdname) {
		this.pbdname = pbdname;
	}

	/**
	 * �Ƿ�ϵͳ������ť��1��0��ȡ��
	 *
	 * @return �Ƿ�ϵͳ������ť��1��0��
	 */
	public String getPbdflag() {
		return pbdflag;
	}

	/**
	 * �Ƿ�ϵͳ������ť��1��0���趨
	 *
	 * @param pbdflag �Ƿ�ϵͳ������ť��1��0��
	 */
	public void setPbdflag(String pbdflag) {
		this.pbdflag = pbdflag;
	}
	
	/**
	 * ��ť��ʾͼƬ����ȡ��
	 * 
	 * @return ��ť��ʾͼƬ����
	 */
	public String getPbdimage() {
		return pbdimage;
	}

	/**
	 * ��ť��ʾͼƬ�����趨
	 * 
	 * @param pbdimage ��ť��ʾͼƬ����
	 */
	public void setPbdimage(String pbdimage) {
		this.pbdimage = pbdimage;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pbdid;
	}

}