/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.dbs.model;

/**
 * 
 * @Description:�洢������Ϣʵ��ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_Info {
	/**
	 *����ID
	 */
	public Integer getId();

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
	 *�洢����
	 */
	public String getSymm_type();

}
