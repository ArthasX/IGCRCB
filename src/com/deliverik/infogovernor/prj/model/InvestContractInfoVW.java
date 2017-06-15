/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model;

/**
 * ����: 
 * ����������
 * �����ˣ���͢־
 * ������¼�� 2012-5-25
 * �޸ļ�¼��
 */
public interface InvestContractInfoVW {
	/**
	 * ��ĿIDȡ��
	 * @return pid ��ĿID
	 */
	public Integer getPid();
	/**
	 * ��Ŀ����ȡ��
	 * @return pname ��Ŀ����
	 */
	public String getPname();
	/**
	 * ��Ŀ���ȡ��
	 * @return pcode ��Ŀ���
	 */
	public String getPcode() ;
	/**
	 * Ԥ����ȡ��
	 * @return pstorecode Ԥ����
	 */
	public String getPstorecode() ;
	/**
	 * Ԥ������ȡ��
	 * @return btitle Ԥ������
	 */
	public String getBtitle() ;
	/**
	 * ��Ӳ��ȡ��
	 * @return pcut ��Ӳ��
	 */
	public String getPcut();
	/**
	 * ��ͬ���ȡ��
	 * @return plcnumber ��ͬ���
	 */
	public String getPlcnumber() ;
	/**
	 * ��ͬ���ȡ��
	 * @return plcsum ��ͬ���
	 */
	public Double getPlcsum() ;
	/**
	 * �Ѹ���ȡ��
	 * @return plbplcsum �Ѹ���
	 */
	public Double getPlbsum() ;
	/**
	 * ���ȡ��
	 * @return subnum ���
	 */
	public Double getSubnum() ;
	/**
	 * ��ͬ����ȡ��
	 * @return lcount ��ͬ����
	 */
	public Integer getLcount() ;
	/**
	 * ��������ȡ��
	 * @return bcount ��������
	 */
	public Integer getBcount();
	/**
	 * ������ȡ��
	 * @return username ������
	 */
	public String getUsername();
}
