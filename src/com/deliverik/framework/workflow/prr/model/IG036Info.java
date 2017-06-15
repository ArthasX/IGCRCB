package com.deliverik.framework.workflow.prr.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.model.Attachment;

/**
 * <p>
 * ��־��Ϣ
 * </p>
 */

public interface IG036Info  extends BaseModel,Comparable<IG036Info> {

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
	 * ��־��¼ʱ��ȡ��
	 * @return ��־��¼ʱ��
	 */
	public String getRltime();

	/**
	 * ��־�����˽�ɫIDȡ��
	 * @return ��־�����˽�ɫID
	 */
	public Integer getRoleid();

	/**
	 * ��־�����˽�ɫ����ȡ��
	 * @return ��־�����˽�ɫ����
	 */
	public String getRlrolename();

	/**
	 * ��־������IDȡ��
	 * @return ��־������ID
	 */
	public String getRluserid();

	/**
	 * ��־����������ȡ��
	 * @return ����ID
	 */
	public String getRlusername();

	/**
	 * ��־����ȡ��
	 * @return ��־����
	 */
	public String getRldesc();

	/**
	 * ��־��������д����Ϣȡ��
	 * @return  ��־��������д����Ϣ
	 */
	public String getRlcomment();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getRlattkey();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getRltype();
	
	/**
	 * ��־�����˻��������ȡ��
	 * @return ����ID
	 */
	public String getRlorgid();
	
	/**
	 * ��־�����˻�������ȡ��
	 * @return ��־�����˻�������
	 */
	public String getRlorgname();
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public List<Attachment> getAttachmentList();
	
	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsname();
	
	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsdcode();
	
	/**
	 * ��ɫ�����˱�ʶȡ��
	 * @return ��ɫ�����˱�ʶ
	 */
	public String getRolemanger();
	
	/**
	 * ��ťID�趨
	 * 
	 * @return ��ťID
	 */
	public String getPbdid();

	/**
	 * ����״̬����IDȡ��
	 * @return ����״̬����ID
	 */
	public String getPsdid();

	/**
	 * ��̬��֧���ȡ��
	 * @return ��̬��֧���
	 */
	public Integer getPsdnum();

}