/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: vim05�ӿ�
  * ��������: vim05�ӿ�
  * ������¼: 2014/02/21
  * �޸ļ�¼: 
  */
public interface VIM05Info extends BaseModel {

	/**
	 * idȡ��
	 *
	 * @return id
	 */
	public Integer getId();

	/**
	 * nameȡ��
	 *
	 * @return name
	 */
	public String getName();
	
	
	public String getCreatetime();
	
	public List<VIM06Info> getConfigItemList();

}