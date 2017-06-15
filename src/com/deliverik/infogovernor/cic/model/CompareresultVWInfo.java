/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �ȶԽ���ӿ�
  * ��������: �ȶԽ���ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareresultVWInfo extends BaseModel {

	/**
	 * cridȡ��
	 *
	 * @return crid
	 */
	public Integer getCrid();

	/**
	 * �Ƚ϶����idȡ��
	 *
	 * @return �Ƚ϶����id
	 */
	public Integer getFkCoid();

	/**
	 * �Ƚ�ִ�б�IDȡ��
	 *
	 * @return �Ƚ�ִ�б�ID
	 */
	public Integer getFkCpid();

	/**
	 * eidȡ��
	 *
	 * @return eid
	 */
	public String getEid();

	/**
	 * cidȡ��
	 *
	 * @return cid
	 */
	public String getCid();

	/**
	 * Ŀ��eiidȡ��
	 *
	 * @return Ŀ��eiid
	 */
	public Integer getTeiid();

	/**
	 * Ŀ��ciidȡ��
	 *
	 * @return Ŀ��ciid
	 */
	public String getTciid();

	/**
	 * Դeiidȡ��
	 *
	 * @return Դeiid
	 */
	public Integer getSeiid();

	/**
	 * Դciidȡ��
	 *
	 * @return Դciid
	 */
	public String getSciid();

	/**
	 * Դ����ֵȡ��
	 *
	 * @return Դ����ֵ
	 */
	public String getSvalue();

	/**
	 * Ŀ������ֵȡ��
	 *
	 * @return Ŀ������ֵ
	 */
	public String getTvalue();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getConfigtype();

	/**
	 * �Ƿ��ǻ�������ȡ��
	 *
	 * @return �Ƿ��ǻ�������
	 */
	public Integer getIsbase();

	/**
	 * ���ڵ�ģ��idȡ��
	 *
	 * @return ���ڵ�ģ��id
	 */
	public String getPeid();

    /** 
     * ���ڵ�ģ������ ȡ��
     * @return pename ���ڵ�ģ������ 
     */
    public String getPename() ;

    /** 
     * ģ������ ȡ��
     * @return ename ģ������ 
     */
    public String getEname();

    /** 
     * �������� ȡ��
     * @return cname �������� 
     */
    public String getCname();

    /** 
     * ʱ��� ȡ��
     * @return fingerPrint ʱ��� 
     */
    public String getFingerPrint();
    
    /** 
     * �������ƣ��ʲ����ƣ� ȡ��
     * @return einame �������ƣ��ʲ����ƣ� 
     */
    public String getEiname();
    /**
     * ��������(ȡ��)
     * @return
     */
    public String getEsyscoding();
}