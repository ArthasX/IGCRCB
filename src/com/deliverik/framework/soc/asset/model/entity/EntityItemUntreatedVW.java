/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.soc.asset.model.EntityItemUntreatedVWInfo;



/**
 * ����:δ�ϼܻ��񡢿յ���ups��ͼʵ��
 * ��������: δ�ϼܻ��񡢿յ���ups��ͼʵ��
 * �����ˣ�����
 * ������¼: 2013/07/03
 * �޸ļ�¼: 
 */

@SuppressWarnings("serial")
@javax.persistence.Entity
public class EntityItemUntreatedVW implements Serializable, Cloneable, 
		EntityItemUntreatedVWInfo{
	
	/**�ʲ�id  */
	@Id
	protected Integer eiid;
	/**�ʲ�����  */
	protected String einame;
	/**�ʲ���� */
	protected String eilabel;
	/**�ʲ������  */
	protected String esyscoding;
	/**�߶�  */
	protected String u_total;
	/**���񡢻��ܱ�ʶ	0������	1������  */
	protected String containertype;
	/**�յ�����  */
	protected String eitype;
	
	
	
	/**�ʲ�id ȡ��*/
	public Integer getEiid() {
		return eiid;
	}

	/**�ʲ�����  ȡ��*/
	public String getEiname() {
		return einame;
	}

	/**�ʲ���� ȡ�� */
	public String getEilabel() {
		return eilabel;
	}

	/**�ʲ������  ȡ��*/
	public String getEsyscoding() {
		return esyscoding;
	}

	/**�߶�  ȡ��*/
	public String getU_total() {
		return u_total;
	}

	/**���񡢻��ܱ�ʶ ȡ��  */
	public String getContainertype() {
		return containertype;
	}

	/**�յ�����  ȡ��*/
	public String getEitype() {
		return eitype;
	}



	/**�ʲ�id �趨*/
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**�ʲ�����  �趨*/
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**�ʲ���� �趨 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**�ʲ������  �趨*/
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**�߶�  �趨*/
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}

	/**���񡢻��ܱ�ʶ �趨  */
	public void setContainertype(String containertype) {
		this.containertype = containertype;
	}

	/**�յ�����  �趨  */
	public void setEitype(String eitype) {
		this.eitype = eitype;
	}

	
	
	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return eiid;
	}
}
