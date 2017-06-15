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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG933TB;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;

/**
 * ����: ֪ʶ���̹�����Ϣʵ��
 * ����������֪ʶ���̹�����Ϣʵ��
 * ������¼������ 2010/12/07
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KnowledgeProcess")
public class KnowledgeProcessTB extends BaseEntity implements Serializable,
		Cloneable, KnowledgeProcess {
	@Id
	@TableGenerator(name = "KNOWLEDGEPROCESS_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", 
					pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", 
					pkColumnValue = "KNOWLEDGEPROCESS_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "KNOWLEDGEPROCESS_TABLE_GENERATOR")
	/* * ���� */
	protected Integer kpid;

	/** ֪ʶID */
	protected Integer knid;

	/** ����ID */
	protected Integer prid;
	
	/** ����ID */
	protected Integer sfid;

	/** �������ͣ�0-���̹���֪ʶ��1-֪ʶ��������*/
	protected String connecttype;
	
	/** �Ƿ���Ч��ʶ��0-��Ч��1-��Ч*/
	protected String kpEffect;
	
	/** ֪ʶ�汾*/
	protected Integer knversion;
	
	/** ֪ʶ��Ϣ */
	@ManyToOne
	//@JoinColumns
	  @JoinColumns({
		  @JoinColumn(name="knid", referencedColumnName="knid" ,updatable=false, insertable= false),
		  @JoinColumn(name="knversion", referencedColumnName="knversion",updatable=false, insertable= false)
		      })
    @Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected KnowledgeTB knowledge;
	
	/** ������Ϣ */
	@ManyToOne
	@JoinColumn(name="prid", referencedColumnName="prid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG500TB processRecord;

	/** ������Ϣ */
	@ManyToOne
	@JoinColumn(name="sfid", referencedColumnName="sfid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG933TB serviceForm;
	
	
	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getKpid() {
		return kpid;
	}

	/**
	 * �����趨
	 * 
	 * @param kpid����
	 */
	public void setKpid(Integer kpid) {
		this.kpid = kpid;
	}

	/**
	 * ֪ʶIDȡ��
	 * 
	 * @return ֪ʶID
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 * ֪ʶID�趨
	 * 
	 * @param knid֪ʶID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * 
	 * @param prid����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	/**
	 * ����ID�趨
	 * 
	 * @param sfid����ID
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getConnecttype() {
		return connecttype;
	}

	/**
	 * ���������趨
	 * 
	 * @param connecttype��������
	 */
	public void setConnecttype(String connecttype) {
		this.connecttype = connecttype;
	}
	
	/**
	 * �Ƿ���Ч��ʶȡ��
	 * 
	 * @return �Ƿ���Ч��ʶ
	 */
	public String getKpEffect() {
		return kpEffect;
	}

	/**
	 * �Ƿ���Ч��ʶ�趨
	 * 
	 * @param kpEffect�Ƿ���Ч��ʶ
	 */
	public void setKpEffect(String kpEffect) {
		this.kpEffect = kpEffect;
	}

	/**
	 * ֪ʶ��Ϣȡ��
	 * @return ֪ʶ��Ϣ
	 */
	public KnowledgeTB getKnowledge() {
		return knowledge;
	}

	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public IG500TB getProcessRecord() {
		return processRecord;
	}

	/**
	 * ���񹤵�ȡ��
	 * @return ���񹤵�
	 */
	public IG933TB getServiceForm() {
		return serviceForm;
	}


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
	
	
	
	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Serializable getPK() {
		return kpid;
	}

}
