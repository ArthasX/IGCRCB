/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.VIM05Info;
import com.deliverik.infogovernor.soc.vir.model.VIM06Info;

/**
  * ����: vim05ʵ��
  * ��������: vim05ʵ��
  * ������¼: 2014/02/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="vim05")
public class VIM05TB extends BaseEntity implements Serializable,
		Cloneable, VIM05Info {

	/** id */
	@Id
	@TableGenerator(
		name="VIM05_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VIM05_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VIM05_TABLE_GENERATOR")
	protected Integer id;

	protected String name;
	
	protected String createtime;
	
	@Transient
	protected List<VIM06Info> configItemList;
	

	/**
	 * idȡ��
	 *
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * id�趨
	 *
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * nameȡ��
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * name�趨
	 *
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public List<VIM06Info> getConfigItemList() {
		return configItemList;
	}

	public void setConfigItemList(List<VIM06Info> configItemList) {
		this.configItemList = configItemList;
	}
	
}