/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * ����: CRM05���������ӿ�
  * ��������: CRM05���������ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 2013/07/31 xudong wang
  */
public interface CRM05SearchCond {
	
	/**
	 * filename_likeȡ��
	 *
	 * @return filename_like filename_like
	 */
	public String getFilename_like();
	/**
	 * uploadtime_beginȡ��
	 *
	 * @return uploadtime_begin uploadtime_begin
	 */
	public String getUploadtime_begin();
	/**
	 * uploadtime_endȡ��
	 *
	 * @return uploadtime_end uploadtime_end
	 */
	public String getUploadtime_end();
}