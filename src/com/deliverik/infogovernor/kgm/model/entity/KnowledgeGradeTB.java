/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;

/**
 * 
 * @Description:知识评分实体TB类
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KnowledgeGrade")
public class KnowledgeGradeTB extends BaseEntity implements Serializable,
		Cloneable, KnowledgeGrade {
	@Id
	@TableGenerator(name = "KNOWLEDGEGRADE_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", 
					pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", 
					pkColumnValue = "KNOWLEDGEGRADE_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "KNOWLEDGEGRADE_TABLE_GENERATOR")
	/*
	 * *主键
	 */
	protected Integer kgid;

	/**
	 *主键取得
	 * 
	 * @return 主键
	 */
	public Integer getKgid() {
		return kgid;
	}

	/**
	 *主键设定
	 * 
	 * @param kgid主键
	 */
	public void setKgid(Integer kgid) {
		this.kgid = kgid;
	}

	/**
	 *知识表key
	 */
	protected Integer knid;

	/**
	 *知识表key取得
	 * 
	 * @return 知识表key
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *知识表key设定
	 * 
	 * @param kgknid知识表key
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *评分
	 */
	protected Integer kggrade;

	/**
	 *评分取得
	 * 
	 * @return 评分
	 */
	public Integer getKggrade() {
		return kggrade;
	}

	/**
	 *评分设定
	 * 
	 * @param kggrade评分
	 */
	public void setKggrade(Integer kggrade) {
		this.kggrade = kggrade;
	}

	/**
	 *知识的评价
	 */
	protected String kgappraise;

	/**
	 *知识的评价取得
	 * 
	 * @return 知识的评价
	 */
	public String getKgappraise() {
		return kgappraise;
	}

	/**
	 *知识的评价设定
	 * 
	 * @param kgappraise知识的评价
	 */
	public void setKgappraise(String kgappraise) {
		this.kgappraise = kgappraise;
	}

	/**
	 *评分人
	 */
	protected String kguserid;

	/**
	 *评分人取得
	 * 
	 * @return 评分人
	 */
	public String getKguserid() {
		return kguserid;
	}

	/**
	 *评分人设定
	 * 
	 * @param kguseid评分人
	 */
	public void setKguserid(String kguserid) {
		this.kguserid = kguserid;
	}

	/**
	 *评分时间
	 */
	protected String kgtime;

	/**
	 *评分时间取得
	 * 
	 * @return 评分时间
	 */
	public String getKgtime() {
		return kgtime;
	}

	/**
	 *评分时间设定
	 * 
	 * @param kgtime评分时间
	 */
	public void setKgtime(String kgtime) {
		this.kgtime = kgtime;
	}

	/**UserTB 实体*/
	@OneToOne
	@JoinColumn(name="kguserid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB user;
	
	/**
	 * User实体取得
	 * @return User实体
	 */
	public UserTB getUser() {
		return user;
	}

	/**
	 * User实体设定
	 * @param user User实体
	 */
	public void setUser(UserTB user) {
		this.user = user;
	}
	
	public Serializable getPK() {
		return kgid;
	}
}
