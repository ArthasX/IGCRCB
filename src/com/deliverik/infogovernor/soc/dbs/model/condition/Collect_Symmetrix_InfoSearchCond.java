/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.dbs.model.condition;


/**
 * 
 * @Description:�洢������ϢCond�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_InfoSearchCond{
	/**
	 *���к�
	 */
	public String getSymm_id();

	/**
	 *�ͺ�
	 */
	public String getSymm_model();

	/**
	 *΢��汾
	 */
	public String getSymm_version();

	/**
	 *����
	 */
	public String getSymm_cachesize();

	/**
	 * �洢����ȡ��
	 * 
	 * @return �洢����
	 */
	public String getSymm_id_like();
	
	/**
	 * �洢����ȡ��
	 * @return �洢����
	 */
	public String getSymm_type();
	
	/**
	 * �洢��������ȡ��
	 * @return �洢��������
	 */
	public String[] getSymm_typeStr();

}

