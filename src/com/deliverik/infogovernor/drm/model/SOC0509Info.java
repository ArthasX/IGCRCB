/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: Ԥ���½���Ϣ�ӿ�
  * ��������: Ԥ���½���Ϣ�ӿ�
  * ������¼: 2016/07/07
  * �޸ļ�¼: 
  */
public interface SOC0509Info extends BaseModel {

	/**
	 * cidȡ��
	 *
	 * @return cid
	 */
	public String getCid();

	/**
	 * eidȡ��
	 *
	 * @return eid
	 */
	public String getEid();

	/**
	 * pcidȡ��
	 *
	 * @return pcid
	 */
	public String getPcid();

	/**
	 * cnameȡ��
	 *
	 * @return cname
	 */
	public String getCname();

	/**
	 * clabelȡ��
	 *
	 * @return clabel
	 */
	public String getClabel();

	/**
	 * cdescȡ��
	 *
	 * @return cdesc
	 */
	public String getCdesc();

	/**
	 * cunitȡ��
	 *
	 * @return cunit
	 */
	public String getCunit();

	/**
	 * cstatusȡ��
	 *
	 * @return cstatus
	 */
	public String getCstatus();

	/**
	 * cseqȡ��
	 *
	 * @return cseq
	 */
	public Integer getCseq();

	/**
	 * ccategoryȡ��
	 *
	 * @return ccategory
	 */
	public String getCcategory();

	/**
	 * coptionȡ��
	 *
	 * @return coption
	 */
	public String getCoption();

	/**
	 * cattachȡ��
	 *
	 * @return cattach
	 */
	public String getCattach();

	/**
	 * esyscodingȡ��
	 *
	 * @return esyscoding
	 */
	public String getEsyscoding();
	
	/**
	 * corderȡ��
	 * @return corder
	 */
	public String getCorder();

}