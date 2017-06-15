/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.mtp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;


/**
 * <p>
 * Title : SOC
 * </p>
 * <p>
 * Description: �ճ���ά�ƻ���Ϣʵ��
 * </p>
 * 
 * @author duchong@deliverik.com
 */
@SuppressWarnings("serial")
@Entity
@Table(name="QuartzJobDetails")
public class QuartzJobDetailsTB extends BaseEntity implements Serializable, Cloneable, QuartzJobDetails {

	@Id
	@TableGenerator(
		    name="QUARTZJOBDETAILS_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="QUARTZJOBDETAILS_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="QUARTZJOBDETAILS_TABLE_GENERATOR")
	/**����*/
	protected Integer qjdid;
	
	/**QuartzJoss������*/
	protected Integer qjid;

	/**ִ��ʱ��*/
	protected String qjdtime;

	/**���ڼ� */
	protected String qjdweek;

	/**ִ��״̬��1��ִ�У�0δִ�У� */
	protected String qjdtype;

	/**����������*/
	protected String qjdtriname;
	
	/**�����������������*/
	protected String qjdtrigrpname;

	/**
	 * ��ȡ����
	 * @return 
	 */
	public Serializable getPK() {
		return qjdid;
	}
	
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Integer getQjdid() {
		return qjdid;
	}

	/**
	 * ��������
	 * @param qjdid ����
	 */
	public void setQjdid(Integer qjdid) {
		this.qjdid = qjdid;
	}

	/**
	 * ��ȡ��ά��������
	 * @return ����
	 */
	public Integer getQjid() {
		return qjid;
	}

	/**
	 * ������ά��������
	 * @param qjid ����
	 */
	public void setQjid(Integer qjid) {
		this.qjid = qjid;
	}

	/**
	 * ��ȡִ��ʱ��
	 * @return ִ��ʱ��
	 */
	public String getQjdtime() {
		return qjdtime;
	}

	/**
	 * ����ִ��ʱ��
	 * @param qjdtime ִ��ʱ��
	 */
	public void setQjdtime(String qjdtime) {
		this.qjdtime = qjdtime;
	}

	/**
	 * ��ȡ���ڼ�
	 * @return ���ڼ�
	 */
	public String getQjdweek() {
		return qjdweek;
	}

	/**
	 * �������ڼ�
	 * @param qjdweek ���ڼ�
	 */
	public void setQjdweek(String qjdweek) {
		this.qjdweek = qjdweek;
	}

	/**
	 * ��ȡִ��״̬
	 * @return ִ��״̬
	 */
	public String getQjdtype() {
		return qjdtype;
	}

	/**
	 * ����ִ��״̬
	 * @param qjdtype ִ��״̬
	 */
	public void setQjdtype(String qjdtype) {
		this.qjdtype = qjdtype;
	}

	/**
	 * ��ȡ����������
	 * @return ����������
	 */
	public String getQjdtriname() {
		return qjdtriname;
	}

	/**
	 * ���ô���������
	 * @param qjdtriname ����������
	 */
	public void setQjdtriname(String qjdtriname) {
		this.qjdtriname = qjdtriname;
	}

	/**
	 * ��ȡ�����������������
	 * @return �����������������
	 */
	public String getQjdtrigrpname() {
		return qjdtrigrpname;
	}

	/**
	 * ���ô����������������
	 * @param qjdtrigrpname �����������������
	 */
	public void setQjdtrigrpname(String qjdtrigrpname) {
		this.qjdtrigrpname = qjdtrigrpname;
	}

}
