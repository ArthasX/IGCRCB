/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.room.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: compareTemplate�ӿ�
  * ��������: compareTemplate�ӿ�
  * ������¼: 2011/05/24
  * �޸ļ�¼: 2013-05-30 XuDongWang
  */
public interface CompareTemplateInfo extends BaseModel {
	/**
	 * ctpidȡ��
	 *
	 * @return ctpid ctpid
	 */
	public Integer getCtpid();

	/**
	 * ctcategoryȡ��
	 *
	 * @return ctcategory ctcategory
	 */
	public String getCtcategory();

	/**
	 * cttypeȡ��
	 *
	 * @return cttype cttype
	 */
	public String getCttype();

	/**
	 * cteiidȡ��
	 *
	 * @return cteiid cteiid
	 */
	public String getCteiid();

	/**
	 * ctxȡ��
	 *
	 * @return ctx ctx
	 */
	public String getCtx();

	/**
	 * ctyȡ��
	 *
	 * @return cty cty
	 */
	public String getCty();

	/**
	 * ctfloorxȡ��
	 *
	 * @return ctfloorx ctfloorx
	 */
	public String getCtfloorx();

	/**
	 * ctflooryȡ��
	 *
	 * @return ctfloory ctfloory
	 */
	public String getCtfloory();
	
	/**
	 * ctindexȡ��
	 *
	 * @return ctindex ctindex
	 */
	public String getCtindex();
	
	/**
	 * ctNameȡ��
	 *
	 * @return ctName ctName
	 */
	public String getCtName();
	
	/**
	 * ctInfoȡ��
	 *
	 * @return ctInfo ctInfo
	 */
	public String getCtInfo() ;

	/**
	 * ctZoneIdȡ��
	 *
	 * @return ctZoneId ctZoneId
	 */
	public String getCtZoneId();
}