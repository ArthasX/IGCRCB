/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * @Description:֪ʶ����ʵ��TB��
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
	 * *����
	 */
	protected Integer kgid;

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getKgid() {
		return kgid;
	}

	/**
	 *�����趨
	 * 
	 * @param kgid����
	 */
	public void setKgid(Integer kgid) {
		this.kgid = kgid;
	}

	/**
	 *֪ʶ��key
	 */
	protected Integer knid;

	/**
	 *֪ʶ��keyȡ��
	 * 
	 * @return ֪ʶ��key
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *֪ʶ��key�趨
	 * 
	 * @param kgknid֪ʶ��key
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *����
	 */
	protected Integer kggrade;

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getKggrade() {
		return kggrade;
	}

	/**
	 *�����趨
	 * 
	 * @param kggrade����
	 */
	public void setKggrade(Integer kggrade) {
		this.kggrade = kggrade;
	}

	/**
	 *֪ʶ������
	 */
	protected String kgappraise;

	/**
	 *֪ʶ������ȡ��
	 * 
	 * @return ֪ʶ������
	 */
	public String getKgappraise() {
		return kgappraise;
	}

	/**
	 *֪ʶ�������趨
	 * 
	 * @param kgappraise֪ʶ������
	 */
	public void setKgappraise(String kgappraise) {
		this.kgappraise = kgappraise;
	}

	/**
	 *������
	 */
	protected String kguserid;

	/**
	 *������ȡ��
	 * 
	 * @return ������
	 */
	public String getKguserid() {
		return kguserid;
	}

	/**
	 *�������趨
	 * 
	 * @param kguseid������
	 */
	public void setKguserid(String kguserid) {
		this.kguserid = kguserid;
	}

	/**
	 *����ʱ��
	 */
	protected String kgtime;

	/**
	 *����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getKgtime() {
		return kgtime;
	}

	/**
	 *����ʱ���趨
	 * 
	 * @param kgtime����ʱ��
	 */
	public void setKgtime(String kgtime) {
		this.kgtime = kgtime;
	}

	/**UserTB ʵ��*/
	@OneToOne
	@JoinColumn(name="kguserid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB user;
	
	/**
	 * Userʵ��ȡ��
	 * @return Userʵ��
	 */
	public UserTB getUser() {
		return user;
	}

	/**
	 * Userʵ���趨
	 * @param user Userʵ��
	 */
	public void setUser(UserTB user) {
		this.user = user;
	}
	
	public Serializable getPK() {
		return kgid;
	}
}
