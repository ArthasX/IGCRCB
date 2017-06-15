package com.deliverik.framework.workflow.prr.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
 * ���̱�����Ϣ
 *
 */
public interface IG599Info  extends BaseModel {

	/**
	 * �������Ͷ���IDȡ��
	 * @return �������Ͷ���ID
	 */
	public Integer getPiid();

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
	 * ���̱���ģʽȡ��
	 * @return ���̱���ģʽ
	 */
	public String getPidmode();
	
	/**
	 * ˽�б���Ȩ�޷�Χ�趨
	 * 
	 * @return ˽�б���Ȩ�޷�Χ
	 */
	public String getPrivatescope();
	
	/**
	 * �����߾��е����̱���Ȩ��ȡ��
	 * @return �����߾��е����̱���Ȩ��
	 */
	public String getPidaccess();
	
	/**
	 * ˽�б���ֵȡ��
	 * @return ˽�б���ֵ����
	 */
	public List<IG899TB> getProcessPrivateInfofList();
	
	/**
	 *��עȡ��
	 */
	public String getPidcomment();

}