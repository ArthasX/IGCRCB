/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.dbs.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;

/**
 * 
 * @Description:�洢������Ϣʵ��TB��
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Collect_Symmetrix_Info", schema="cst")
public class Collect_Symmetrix_InfoTB extends BaseEntity implements
		Serializable, Cloneable, Collect_Symmetrix_Info {
	@Id
	@TableGenerator(name = "COLLECT_SYMMETRIX_INFO_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "COLLECT_SYMMETRIX_INFO_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "COLLECT_SYMMETRIX_INFO_TABLE_GENERATOR")
	/*
	 * *����ID
	 */
	protected Integer id;

	/**
	 *����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *����ID�趨
	 * 
	 * @param id����ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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

	public Serializable getPK() {
		return id;
	}
	
	/**
	 *�洢����
	 */
	protected String symm_type;

	/**
	 * @return �洢����
	 */
	public String getSymm_type() {
		return symm_type;
	}

	/**
	 * @param �洢����
	 */
	public void setSymm_type(String symm_Type) {
		symm_type = symm_Type;
	}
}
