/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.model;

import com.deliverik.framework.base.BaseModel;

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

public interface SdlInfo  extends BaseModel {

	/**
	 * ��ȡ����
	 * @return ����
	 */
	public abstract Integer getSiid();

	/**
	 * ��ȡ���
	 * @return ���
	 */
	public abstract String getSitype();

	/**
	 * ��ȡ˵��
	 * @return ˵��
	 */
	public abstract String getSidesc();

	/**
	 * ��ȡ��ʼʱ��
	 * @return ��ʼʱ��
	 */
	public abstract String getSibegin();

	/**
	 * ��ȡ����ʱ��
	 * @return ����ʱ��
	 */
	public abstract String getSiend();

	/**
	 * ��ȡ����
	 * @return ����
	 */
	public abstract Integer getSimark();

	/**
	 * ��ȡ����ʲ�ID
	 * @return ����ʲ�ID
	 */
	public abstract Integer getSieiid();

	/**
	 * ��ȡ����ʲ�����
	 * @return ����ʲ�����
	 */
	public abstract String getSieiname();

	/**
	 * ��ȡ�������ID
	 * @return �������ID
	 */
	public abstract Integer getSiprid();

	/**
	 * ��ȡ�����������
	 * @return �����������
	 */
	public abstract String getSiprtitle();
	
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public abstract String getSiattkey();
	
	/**
	 * ��ȡ�Ǽ�����
	 * @return �Ǽ�����
	 */
	public abstract String getSidate();
	
	/**
	 * ��ȡʵ��ʱ��
	 * @return ʵ��ʱ��
	 */
	public abstract Integer getSifacttime();

}