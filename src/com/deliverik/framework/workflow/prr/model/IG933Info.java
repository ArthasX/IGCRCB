/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.asset.model.entity.IG688VW;
import com.deliverik.framework.base.BaseModel;

/**
 * 
 * ���񹤵�ʵ��ӿ�
 * 
 * 
 */

public interface IG933Info extends BaseModel {
	/**
	 * ���񹤵�IDȡ��
	 * 
	 * @return ���񹤵�ID
	 */
	public Integer getSfid();
	
	/**
	 * ���񹤵�����ȡ��
	 * 
	 * @return ���񹤵�����
	 */
	public String getSfcode();
	
	/**
	 * ���񹤵�������ȡ��
	 * 
	 * @return ���񹤵�������
	 */
	public String getSfreportname();
	
	/**
	 * ���񹤵������˵绰ȡ��
	 * 
	 * @return ���񹤵������˵绰
	 */
	public String getSfreportphone();
	
	/**
	 * ���񹤵������˲���ȡ��
	 * 
	 * @return ���񹤵������˲���
	 */
	public String getSfreportorgid();
	
	/**
	 * ���񹤵���Ŀȡ��
	 * 
	 * @return ���񹤵���Ŀ
	 */
	public String getSftitle();

	/**
	 * ���񹤵�����ȡ��
	 * 
	 * @return ���񹤵�����
	 */
	public String getSfdesc();
	
	/**
	 * ���񹤵�����ȡ��
	 * 
	 * @return ���񹤵�����
	 */
	public String getSfattkey();
	
	/**
	 * ���񹤵�״̬ȡ��
	 * 
	 * @return ���񹤵�״̬
	 */
	public String getSfstatus();

	/**
	 * ���񹤵�����IDȡ��
	 * 
	 * @return ���񹤵�����ID
	 */
	public String getSforgid();
	
	/**
	 * ���񹤵���¼��IDȡ��
	 * 
	 * @return ���񹤵���¼��ID
	 */
	public String getSfregisterid();

	/**
	 * ���񹤵���¼ʱ��ȡ��
	 * 
	 * @return ���񹤵���¼ʱ��
	 */
	public String getSfinstime();
	
	/** ���񹤵�ʱ���ȡ��
	 * 
	 * @return ���񹤵�ʱ���
	 */
	
	/** ���񹤵���¼����ȡ��
	 * 
	 * @return ���񹤵���¼����
	 */
	public String getSftype();
	

	/** ���񹤵�����ʲ�IDȡ��
	 * 
	 * @return ���񹤵�����ʲ�ID
	 */
	public Integer getSfeiid();
	
 
	/** ���񹤵�����ʲ�����ȡ��
	 * 
	 * @return ���񹤵�����ʲ�����
	 */
	public IG688VW getEntityItemVW();
	
	/** ���񹤵���Դȡ��
	 * 
	 * @return ���񹤵���Դ
	 */
	public String getSfsource();
	
	/** ���񹤵��칫�绰ȡ��
	 * 
	 * @return ���񹤵��칫�绰
	 */
	public String getSfworkphone();
	
	/** ����ȡ��
	 * 
	 * @return ����
	 */
	public String getSfemail();
}