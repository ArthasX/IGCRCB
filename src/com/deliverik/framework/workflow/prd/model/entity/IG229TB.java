/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.framework.workflow.prd.model.entity;

 import java.io.Serializable;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.Table;
 import javax.persistence.TableGenerator;
 import com.deliverik.framework.base.BaseEntity;
 import com.deliverik.framework.workflow.prd.model.IG229Info;


 /**
  * ����:����������ϸ��¼��TB��
  *  ��������������������ϸ��¼��TB��
  * 
  * ������¼��wangxiaoqiang 2010/11/29
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG229")
public class IG229TB extends BaseEntity implements
		Serializable, Cloneable, IG229Info {
	@Id
	@TableGenerator(name = "IG229_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", 
					pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", 
					pkColumnValue = "IG229_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "IG229_TABLE_GENERATOR")
	/*
	 * *����
	 */
	protected Integer padid;

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getPadid() {
		return padid;
	}

	/**
	 *�����趨
	 * 
	 * @param padid����
	 */
	public void setPadid(Integer padid) {
		this.padid = padid;
	}

	/**
	 *����ID
	 */
	protected Integer padprid;

	/**
	 *����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPadprid() {
		return padprid;
	}

	/**
	 *����ID�趨
	 * 
	 * @param padprid����ID
	 */
	public void setPadprid(Integer padprid) {
		this.padprid = padprid;
	}

	/**
	 *Ӱ��ϵͳ
	 */
	protected String padaffectsystem;

	/**
	 *Ӱ��ϵͳȡ��
	 * 
	 * @return Ӱ��ϵͳ
	 */
	public String getPadaffectsystem() {
		return padaffectsystem;
	}

	/**
	 *Ӱ��ϵͳ�趨
	 * 
	 * @param padaffectsystemӰ��ϵͳ
	 */
	public void setPadaffectsystem(String padaffectsystem) {
		this.padaffectsystem = padaffectsystem;
	}

	/**
	 *Ӱ�쿪ʼʱ��
	 */
	protected String padstart;

	/**
	 *Ӱ�쿪ʼʱ��ȡ��
	 * 
	 * @return Ӱ�쿪ʼʱ��
	 */
	public String getPadstart() {
		return padstart;
	}

	/**
	 *Ӱ�쿪ʼʱ���趨
	 * 
	 * @param padstartӰ�쿪ʼʱ��
	 */
	public void setPadstart(String padstart) {
		this.padstart = padstart;
	}

	/**
	 *Ӱ�����ʱ��
	 */
	protected String padend;

	/**
	 *Ӱ�����ʱ��ȡ��
	 * 
	 * @return Ӱ�����ʱ��
	 */
	public String getPadend() {
		return padend;
	}

	/**
	 *Ӱ�����ʱ���趨
	 * 
	 * @param padendӰ�����ʱ��
	 */
	public void setPadend(String padend) {
		this.padend = padend;
	}

	public Serializable getPK() {
		return padid;
	}
}

