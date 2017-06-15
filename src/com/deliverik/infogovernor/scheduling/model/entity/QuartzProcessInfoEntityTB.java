package com.deliverik.infogovernor.scheduling.model.entity;

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

import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;

/**
 * �������ʲ���ϵ��Ϣ
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="QuartzProcessInfoEntity")
public class QuartzProcessInfoEntityTB extends BaseEntity implements Serializable, Cloneable, QuartzProcessInfoEntity {

	/** �������������� */
	@Id
	@TableGenerator(
		    name="QUARTZPROCESSINFOENTITY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="QUARTZPROCESSINFOENTITY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="QUARTZPROCESSINFOENTITY_TABLE_GENERATOR")
	protected Integer qpieid;

	/** ����ID(QuartzProcessRecord��) */
	protected Integer qprid;

	/** ��̬��ID��QuartzProcessInfo��*/
	protected Integer qpiid;

	/** �ʲ�ID(EntityItem��) */
	protected Integer qeiid;

	/** �ʲ���Ϣ */
	@OneToOne
	@JoinColumn(name="qeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG013TB entityItemTB;
	
	/** �ʲ���Ϣ */
	@OneToOne
	@JoinColumn(name="qeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0118TB soc0118TB;
	
	/**
	 * ����ȡ��
	 * @return qpieid
	 */
	public Serializable getPK() {
		return qpieid;
	}

	/**
	 *��������������ȡ��
	 * @return ��������������
	 */
	public Integer getQpieid(){
		return qpieid;
	}
	
	/**
	 *���������������趨
	 * @param pieid��������������
	 */
	public void setQpieid(Integer qpieid){
		this.qpieid=qpieid;
	}
	
	/**
	 *����ID(QuartzProcessRecord��)ȡ��
	 * @return ����ID(QuartzProcessRecord��)
	 */
	public Integer getQprid(){
		return qprid;
	}

	/**
	 *����ID(QuartzProcessRecord��)�趨
	 * @param prid����ID(QuartzProcessRecord��)
 	 */
	public void setQprid(Integer qprid){
		this.qprid=qprid;
	}
	
	/**
	 *��̬��ID��QuartzProcessInfo��ȡ��
	 * @return ��̬��ID��QuartzProcessInfo��
	 */
	public Integer getQpiid(){
		return qpiid;
	}
	
	/**
	 *��̬��ID��QuartzProcessInfo���趨
	 * @param pidid��̬��ID��QuartzProcessInfo��
	 */
	public void setQpiid(Integer qpiid){
		this.qpiid=qpiid;
	}
	
	/**
	 *�ʲ�ID(EntityItem��)ȡ��
	 * @return �ʲ�ID(EntityItem��)
	 */
	public Integer getQeiid(){
		return qeiid;
	}
	
	/**
	 *�ʲ�ID(EntityItem��)�趨
	 * @param eiid�ʲ�ID(EntityItem��)
	 */
	public void setQeiid(Integer qeiid){
		this.qeiid=qeiid;
	}

	/**
	 * �ʲ���Ϣȡ��
	 * @return �ʲ���Ϣ
	 */
	public IG013TB getEntityItemTB() {
		return entityItemTB;
	}

	/**
	 * �ʲ���Ϣ�趨
	 * @param entityItemTB �ʲ���Ϣ
	 */
	public void setEntityItemTB(IG013TB entityItemTB) {
		this.entityItemTB = entityItemTB;
	}

	public SOC0118TB getSoc0118TB() {
		return soc0118TB;
	}

	public void setSoc0118TB(SOC0118TB soc0118TB) {
		this.soc0118TB = soc0118TB;
	}


}
