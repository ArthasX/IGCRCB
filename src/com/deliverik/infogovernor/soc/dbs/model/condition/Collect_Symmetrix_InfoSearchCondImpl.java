/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.dbs.model.condition;


/**
 * 
 * @Description:�洢������ϢCond��
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_InfoSearchCondImpl implements Collect_Symmetrix_InfoSearchCond{
	/**
	 *���к�
	 */
	protected String symm_id;

	/**
	 *���к�ȡ��
	 * 
	 * @return ���к�
	 */
	public String getSymm_id() {
		return symm_id;
	}

	/**
	 *���к��趨
	 * 
	 * @param symm_id���к�
	 */
	public void setSymm_id(String symm_id) {
		this.symm_id = symm_id;
	}

	/**
	 *�ͺ�
	 */
	protected String symm_model;

	/**
	 *�ͺ�ȡ��
	 * 
	 * @return �ͺ�
	 */
	public String getSymm_model() {
		return symm_model;
	}

	/**
	 *�ͺ��趨
	 * 
	 * @param symm_model�ͺ�
	 */
	public void setSymm_model(String symm_model) {
		this.symm_model = symm_model;
	}

	/**
	 *΢��汾
	 */
	protected String symm_version;

	/**
	 *΢��汾ȡ��
	 * 
	 * @return ΢��汾
	 */
	public String getSymm_version() {
		return symm_version;
	}

	/**
	 *΢��汾�趨
	 * 
	 * @param symm_version΢��汾
	 */
	public void setSymm_version(String symm_version) {
		this.symm_version = symm_version;
	}

	/**
	 *����
	 */
	protected String symm_cachesize;

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getSymm_cachesize() {
		return symm_cachesize;
	}

	/**
	 *�����趨
	 * 
	 * @param symm_cachesize����
	 */
	public void setSymm_cachesize(String symm_cachesize) {
		this.symm_cachesize = symm_cachesize;
	}
	
	/** �洢���� */
	protected String symm_id_like;
	
	/**
	 * �洢����ȡ��
	 * @return �洢����
	 */
	public String getSymm_id_like() {
		return symm_id_like;
	}

	/**
	 * �洢�����趨
	 * @param symm_id_like�洢����
	 */
	public void setSymm_id_like(String symm_id_like) {
		this.symm_id_like = symm_id_like;
	}
	
	/** �洢���� */
	protected String symm_type;
	
	/** �洢�������� */
	protected String[] symm_typeStr;
	
	/**
	 * �洢��������ȡ��
	 * @return �洢��������
	 */
	public String[] getSymm_typeStr() {
		return symm_typeStr;
	}

	/**
	 * �洢���������趨
	 * @param symm_typeStr�洢��������
	 */
	public void setSymm_typeStr(String[] symm_typeStr) {
		this.symm_typeStr = symm_typeStr;
	}

	/**
	 * �洢����ȡ��
	 * @return �洢����
	 */
	public String getSymm_type() {
		return symm_type;
	}

	/**
	 * �洢�����趨
	 * @param symm_type�洢����
	 */
	public void setSymm_type(String symm_type) {
		this.symm_type = symm_type;
	}
}

