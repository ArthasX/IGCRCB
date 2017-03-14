/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;

/**
  * ����: SOC0118VW���������ӿ�
  * ��������: SOC0118VW���������ӿ�
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
public interface SOC0118VWSearchCond {
	
	/**
	 * @return the ���ݿ�id
	 */
	public Integer getId();
	
	/**
	 * @return the ��������pKs
	 */
	public List<SOC0118VWPK> getPKs();
	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */
	public String getEilabel();
	
	/**
	 * �ʲ�����ȡ��
	 * @return �ʲ�����
	 */
	public String getEiname();
	
	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding();
	
	/**
	 * �ʲ�IDȡ�ã�ƽ̨������
	 * @return �ʲ�ID
	 */
	public String getEiid();
	
	/**
	 * �ʲ��汾��ȡ��
	 * @return �ʲ��汾��
	 */
	public Integer getEiversion();
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion() ;
	
	public List<String> getEilabel_list();
	
	/**
	 * �ʲ����ƣ���ȫƥ�� ��ȡ��
	 * @return �ʲ����ƣ���ȫƥ�� ��
	 */
	public String getEiname_equal();
	
	/**
	 * �ʲ�����ʵ��ID����ȫƥ�� ��ȡ��
	 * @return �ʲ�����ʵ�壨��ȫƥ�� ��
	 */
	public Integer getEirootmark();
	
	/**
	 * �ʲ�eiidȡ��
	 *
	 * @return eiids �ʲ�eiid
	 */
	
	public List<Integer> getEiids();
	
	/**
	 * �ʲ�ģ��IDȡ��
	 *
	 * @return eids �ʲ�ģ��ID
	 */
	
	public String[] getEids();
	
	/**
	 * �洢����eqȡ��
	 *
	 * @return esyscoding_eq �洢����eq
	 */
	public String getEsyscoding_eq();
	/**
	 * �洢����likeȡ��
	 *
	 * @return esyscoding_like �洢����like
	 */
	public String getEsyscoding_like();
	
	public String getCcid() ;


	public String getPcid() ;


	public String getCdstatus();
	/**
	 * eid_arrȡ��
	 *
	 * @return eid_arr eid_arr
	 */
	public String[] getEid_arr();
	
	public String getMagName();
	
	public List<String> getEiname_in() ;
	
	public String getEilabel_like();
	
	public String getEidesc_falg();
	
	public String getEiupdtime_from();
	
	public String getEiupdtime_to();

	public Integer getSystemId();
	
	public String getEnvironmentType();
	public boolean isClumped();
	public String getEitype();
	/**
	 * @return the �ʲ�״̬
	 */
	public String getEistatus();
	/**
	 * @return the eiinsdate_like
	 */
	public String getEiinsdate_like();
	/**
	 * @return the ������
	 */
	public String getEiusername();
	/**
	 * �Ƿ�����
	 * @return
	 */
	public boolean isUpgrade();
	
	public String getEiinsdate_gt() ;


	public String getEiinsdate_lt() ;
	/**  
	 * ��ȡ����ʱ��  
	 * @return prclosetime ����ʱ��  
	 */
	
	public String getPrclosetime();
	/**  
	 * ��ȡ��ʼʱ��  
	 * @return propentime ��ʼʱ��  
	 */
	
	public String getPropentime();
	/**
	 * ��Ҫ���˵���eiid(Ӧ����Դר��)
	 * @return the eiidNotIn
	 */
	public String getEiidNotIn();
	
	public String getEiid_cld_ywxt();
	
	public String getEiid_cld_cj();
	
	public String getEiid_cld_yjzy();
	
	public String getEiname_q();
}