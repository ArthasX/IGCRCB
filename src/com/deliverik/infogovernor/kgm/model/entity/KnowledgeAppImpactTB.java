/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;

/**
 * 
 * @Description:֪ʶҵ��ϵͳ����ʵ��TB��
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KnowledgeAppImpact")
public class KnowledgeAppImpactTB extends BaseEntity implements Serializable,
		Cloneable, KnowledgeAppImpact {
	@Id
	@TableGenerator(name = "KNOWLEDGEAPPIMPACT_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", 
					pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", 
					pkColumnValue = "KNOWLEDGEAPPIMPACT_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "KNOWLEDGEAPPIMPACT_TABLE_GENERATOR")
	/*
	 * *����ID
	 */
	protected Integer kaiid;

	/**
	 *����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getKaiid() {
		return kaiid;
	}

	/**
	 *����ID�趨
	 * 
	 * @param kaiid����ID
	 */
	public void setKaiid(Integer kaiid) {
		this.kaiid = kaiid;
	}

	/**
	 *֪ʶID
	 */
	protected Integer knid;

	/**
	 *֪ʶIDȡ��
	 * 
	 * @return ֪ʶID
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *֪ʶID�趨
	 * 
	 * @param knid֪ʶID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *ҵ��ϵͳCode
	 */
	protected String kaicode;

	/**
	 *ҵ��ϵͳCodeȡ��
	 * 
	 * @return ҵ��ϵͳCode
	 */
	public String getKaicode() {
		return kaicode;
	}

	/**
	 *ҵ��ϵͳCode�趨
	 * 
	 * @param kaicodeҵ��ϵͳCode
	 */
	public void setKaicode(String kaicode) {
		this.kaicode = kaicode;
	}
	
	/**
	 * ֪ʶ�汾
	 */
	protected Integer knversion;

	/**
	 * ֪ʶ�汾ȡ��
	 * @return ֪ʶ�汾
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * ֪ʶ�汾�趨
	 * @param knversion ֪ʶ�汾
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}

	public Serializable getPK() {
		return kaiid;
	}
}
