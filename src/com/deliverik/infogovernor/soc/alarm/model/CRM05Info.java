/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: CRM05�ӿ�
  * ��������: CRM05�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM05Info extends BaseModel {

	/**
	 * fileidȡ��
	 *
	 * @return fileid
	 */
	public Integer getFileid();

	/**
	 * filenameȡ��
	 *
	 * @return filename
	 */
	public String getFilename();

	/**
	 * uploadtimeȡ��
	 *
	 * @return uploadtime
	 */
	public String getUploadtime();

	/**
	 * filepathȡ��
	 *
	 * @return filepath
	 */
	public String getFilepath();

}