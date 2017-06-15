/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import java.util.List;

import com.deliverik.framework.model.entity.AttachmentTB;


/**
  * ����: ��ѵ��¼�ӿ�
  * ��������: ��ѵ��¼�ӿ�
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public interface TrainrecordInfo{

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getTrid();

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String getTrname();

	/**
	 * ��ѵ�ƻ�idȡ��
	 *
	 * @return ��ѵ�ƻ�id
	 */
	public Integer getTpid();

	/**
	 * ��ѵ�ƻ�����ȡ��
	 *
	 * @return ��ѵ�ƻ�����
	 */
	public String getTpname();

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String getTpcontent();

	/**
	 * ��ѵ��ʼʱ��ȡ��
	 *
	 * @return ��ѵ��ʼʱ��
	 */
	public String getTrstime();

	/**
	 * ��ѵ����ʱ��ȡ��
	 *
	 * @return ��ѵ����ʱ��
	 */
	public String getTretime();

	/**
	 * ��ѵ�ص�ȡ��
	 *
	 * @return ��ѵ�ص�
	 */
	public String getTrside();

	/**
	 * ��ʦȡ��
	 *
	 * @return ��ʦ
	 */
	public String getTrlecturer();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getTratt();
	
	/**  
	 * ��ȡ����  
	 * @return attachmentList ����  
	 */
	public List<AttachmentTB> getAttachmentList();

}