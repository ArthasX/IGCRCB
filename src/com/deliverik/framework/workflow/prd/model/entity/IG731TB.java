package com.deliverik.framework.workflow.prd.model.entity;

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
import com.deliverik.framework.asset.model.entity.IG688VW;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG731Info;

/**
 * �������ʲ���ϵ��Ϣ
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG731")
public class IG731TB extends BaseEntity implements Serializable, Cloneable, IG731Info {

	/** �������������� */
	@Id
	@TableGenerator(
		    name="IG731_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG731_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG731_TABLE_GENERATOR")
	protected Integer pieid;

	/** ����ID(Ig500��) */
	protected Integer prid;

	/** ��̬��ID��Ig599��*/
	protected Integer piid;

	/** �ʲ�ID(EntityItem��) */
	protected Integer eiid;
	
	/** �ʲ��汾�� */
	protected Integer eiversion;

	/** �ʲ���Ϣ */
	@OneToOne
	@JoinColumn(name="eiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG013TB entityItemTB;
	
	/** �ʲ���Ϣ��ͼ */
	@OneToOne
	@JoinColumn(name="eiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG688VW entityItemVWTB;
	
	/**
	 * �ʲ���Ϣ��ͼȡ��
	 *
	 * @return entityItemVWTB �ʲ���Ϣ��ͼ
	 */
	public IG688VW getEntityItemVWTB() {
		return entityItemVWTB;
	}

	/**
	 * �ʲ���Ϣ��ͼ�趨
	 *
	 * @param entityItemVWTB �ʲ���Ϣ��ͼ
	 */
	public void setEntityItemVWTB(IG688VW entityItemVWTB) {
		this.entityItemVWTB = entityItemVWTB;
	}

	/**
	 * ����ȡ��
	 * @return pieid
	 */
	public Serializable getPK() {
		return pieid;
	}

	/**
	 *��������������ȡ��
	 * @return ��������������
	 */
	public Integer getPieid(){
		return pieid;
	}
	
	/**
	 *���������������趨
	 * @param pieid��������������
	 */
	public void setPieid(Integer pieid){
		this.pieid=pieid;
	}
	
	/**
	 *����ID(Ig500��)ȡ��
	 * @return ����ID(Ig500��)
	 */
	public Integer getPrid(){
		return prid;
	}

	/**
	 *����ID(Ig500��)�趨
	 * @param prid����ID(Ig500��)
 	 */
	public void setPrid(Integer prid){
		this.prid=prid;
	}
	
	/**
	 *��̬��ID��Ig599��ȡ��
	 * @return ��̬��ID��Ig599��
	 */
	public Integer getPiid(){
		return piid;
	}
	
	/**
	 *��̬��ID��Ig599���趨
	 * @param pidid��̬��ID��Ig599��
	 */
	public void setPiid(Integer piid){
		this.piid=piid;
	}
	
	/**
	 *�ʲ�ID(EntityItem��)ȡ��
	 * @return �ʲ�ID(EntityItem��)
	 */
	public Integer getEiid(){
		return eiid;
	}
	
	/**
	 *�ʲ�ID(EntityItem��)�趨
	 * @param eiid�ʲ�ID(EntityItem��)
	 */
	public void setEiid(Integer eiid){
		this.eiid=eiid;
	}
	
	/**
	 * �ʲ��汾��ȡ��
	 * @return eiversion �ʲ��汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �ʲ��汾���趨
	 * @param eiversion �ʲ��汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
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

}
