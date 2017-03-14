package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;

/**
 * <p>
 * ����־��Ϣ
 * </p>
 */

public interface IG113Info  extends BaseModel {

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getRlvid();

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getPiid();

	

	/**
	 * ��־IDȡ��
	 * @return ��־ID
	 */
	public Integer getRlid();

	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid();

	
	/**
	 * ���̱�����ʶȡ��
	 * @return ���̱�����ʶ
	 */
	public String getPivarname();

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPivartype();

	/**
	 * ���̱���ֵȡ��
	 * @return ���̱���ֵ
	 */
	public String getPivarvalue();

	/**
	 * ���̸���KEYȡ��
	 * @return ���̸���KEY
	 */
	public String getPiattkey();

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPivarlabel();

	/**
	 * �����Զ���ǰ�����ʶȡ��
	 * @return �����Զ���ǰ�����ʶ
	 */
	public String getPidid();
	
	/**
	 * ���̶������ͱ�����ʾ����ȡ��
	 * @return ���̶������ͱ�����ʾ����
	 */
	public String getPishowvarname();
	
	/**
	 * ������־ʵ��ȡ��
	 * @return recordLog ������־ʵ��
	 */
	public IG036TB getRecordLog();
	
	/**
	 * ��ʾ����ȡ��
	 * @return showValue ��ʾ����
	 */
	public String getShowValue();

}