/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ�������OAģʽ��Ӧ��ɫȫ������Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0301Form extends BaseForm{
	
	/** ɾ����ʶ A �����ˣ�B ֵ���ˣ�C ִ���� */
	protected String deleteFlag;
	
	/** ������������Ϣ�������� */
	protected Integer[] proids_A;
	
	/** ֵ����������Ϣ���� */
	protected Integer[] proids_B;
	
	/** ִ����������Ϣ�������� */
	protected Integer[] proids_C;

	/**
	 * ɾ����ʶȡ��
	 * @return ɾ����ʶ
	 */
	public final String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * ɾ����ʶ�趨
	 * @param deleteFlag ɾ����ʶ
	 */
	public final void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * ������������Ϣ��������ȡ��
	 * @return ������������Ϣ��������
	 */
	public final Integer[] getProids_A() {
		return proids_A;
	}

	/**
	 * ������������Ϣ���������趨
	 * @param proids_A ������������Ϣ��������
	 */
	public final void setProids_A(Integer[] proids_A) {
		this.proids_A = proids_A;
	}

	/**
	 * ֵ����������Ϣ��������ȡ��
	 * @return ֵ����������Ϣ����
	 */
	public final Integer[] getProids_B() {
		return proids_B;
	}

	/**
	 * ֵ����������Ϣ���������趨
	 * @param proids_B ֵ����������Ϣ��������
	 */
	public final void setProids_B(Integer[] proids_B) {
		this.proids_B = proids_B;
	}

	/**
	 * ִ����������Ϣ��������ȡ��
	 * @return ִ����������Ϣ��������
	 */
	public final Integer[] getProids_C() {
		return proids_C;
	}

	/**
	 * ִ����������Ϣ���������趨
	 * @param proids_C ִ����������Ϣ��������
	 */
	public final void setProids_C(Integer[] proids_C) {
		this.proids_C = proids_C;
	}
	
}
