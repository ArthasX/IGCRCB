package com.deliverik.infogovernor.soc.model.condition;



/**
 * �ʲ���Ϣ��ѯ�����ӿ�
 * 
 */
public interface SocRelationSearchCond {
	
	/**
	 * �ʲ�label
	 * @return �ʲ�label
	 */
	public String getSreilabel();

	
	/**
	 * �����ʲ�label
	 * @return �����ʲ�label
	 */
	public String getSrpareilabel();

	/**
	 * �����ʲ�coding
	 * @return �����ʲ�coding
	 */
	public String getSresycoding();

	/**
	 * �����ʲ���������
	 * @return �����ʲ���������
	 */
	public String getSrename();
	
	/**
	 * Ԥ��1(����汾��)
	 * @return Ԥ��1(����汾��)
	 */
	public String getSrkey1();
	
	/**
	 * �汾��
	 * @return �汾��
	 */
	public Integer getVersion();
	
}
