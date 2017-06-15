/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 * @Description:知识业务系统关联实体TB类
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
	 * *主键ID
	 */
	protected Integer kaiid;

	/**
	 *主键ID取得
	 * 
	 * @return 主键ID
	 */
	public Integer getKaiid() {
		return kaiid;
	}

	/**
	 *主键ID设定
	 * 
	 * @param kaiid主键ID
	 */
	public void setKaiid(Integer kaiid) {
		this.kaiid = kaiid;
	}

	/**
	 *知识ID
	 */
	protected Integer knid;

	/**
	 *知识ID取得
	 * 
	 * @return 知识ID
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *知识ID设定
	 * 
	 * @param knid知识ID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *业务系统Code
	 */
	protected String kaicode;

	/**
	 *业务系统Code取得
	 * 
	 * @return 业务系统Code
	 */
	public String getKaicode() {
		return kaicode;
	}

	/**
	 *业务系统Code设定
	 * 
	 * @param kaicode业务系统Code
	 */
	public void setKaicode(String kaicode) {
		this.kaicode = kaicode;
	}
	
	/**
	 * 知识版本
	 */
	protected Integer knversion;

	/**
	 * 知识版本取得
	 * @return 知识版本
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * 知识版本设定
	 * @param knversion 知识版本
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}

	public Serializable getPK() {
		return kaiid;
	}
}
