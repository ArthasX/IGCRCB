/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckTB;

/**
 * ���ռ����ʵ��ӿ�
 * 
 * @author lipeng@deliverik.com
 */
public interface RiskCheckResult  extends BaseModel {
	/**
	 * ���ռ����IDȡ��
	 * @return ���ռ����ID
	 */
	public Integer getRcrid();

	/**
	 * ���ռ��IDȡ��
	 * @return ���ռ��ID
	 */
	public Integer getRcid();

	/**
	 * ���ռ��ƻ����ʱ��ȡ��
	 * @return ���ռ��ƻ����ʱ��
	 */
	public String getRcrplandate();

	/**
	 * ���ռ��ʵ�ʼ��ʱ��ȡ��
	 * @return ���ռ��ʵ�ʼ��ʱ��
	 */
	public String getRcrrealtime();

	/**
	 * ���ռ�����ύ��IDȡ��
	 * @return ���ռ�����ύ��ID
	 */
	public String getRcruserid();

	/**
	 * ���ռ�����ύ������ȡ��
	 * @return ���ռ�����ύ������
	 */
	public String getRcrusername();

	/**
	 * ���ռ����ȡ��
	 * @return ���ռ����
	 */
	public String getRcrresult();

	/**
	 * ���ռ����˵��ȡ��
	 * @return ���ռ����˵��
	 */
	public String getRcrcomment();
	
	/**
	 * ���ռ�����ȡ��
	 * @return ���ռ�����
	 */
	public RiskCheckTB getRiskCheck();
	
	/**
	 * ���ռ��������ȡ��
	 * @return ���ռ��������
	 */
	public String getRcrattch();
	
	/**
	 * ���ռ����Ҫ�̶�ȡ��
	 * @return ���ռ����Ҫ�̶�
	 */
	public String getRctype();
	
	/**
	 * �´�ִ�м��ʱ��ȡ��
	 * @return �´�ִ�м��ʱ��
	 */
	public String getRcrnextdate();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getPrid();
	
	/**
	 * ����ָ�ɹ�������id
	 * @return
	 */
	public Integer getAssignprid();
	
	/**
	 * ������ȡ��
	 * @return
	 */
	public String getRcrtestmode();
	
	/**
	 * ���������ȡ��
	 * @return the rcname
	 */
	public String getRcname();

	/**
	 * ���������ȡ��
	 * @return the rcrclass
	 */
	public String getRcrclass();

	/**
	 * ���������ȡ��
	 * @return the rcdesc
	 */
	public String getRcdesc();

	/**
	 * �����˵��ȡ��
	 * @return the rccommon
	 */
	public String getRccommon();

	
}