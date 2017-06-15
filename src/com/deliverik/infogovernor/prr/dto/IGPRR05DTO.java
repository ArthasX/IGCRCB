/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG483SearchCond;

/**
 * ����: ������DTO
 * ��������: ������DTO
 * ������¼: 2015/02/03
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRR05DTO extends BaseDTO {
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/**��ҳBean*/
	protected PagingDTO pagingDto;

	/** �������ѯ���� */
	protected IG483SearchCond ig483SearchCond;
	
	/** �������б� */
	protected List<IG483Info> lst_IG483Info;

	/** �������Ա�б� */
	protected List<IG500Info> lst_IG500Info;
	
	/** ������ID */
	protected Integer pgrid;

	/**
	 * ��ȡ�����ѯ������¼��
	 * @return �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ���������ѯ������¼��
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ȡ��ҳBean
	 * @return ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ���÷�ҳBean
	 * @param pagingDto ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	/**
	 * �������ѯ����ȡ��
	 * @return �������ѯ����
	 */
	public IG483SearchCond getIg483SearchCond() {
		return ig483SearchCond;
	}

	/**
	 * �������ѯ�����趨
	 * @param ig483SearchCond �������ѯ����
	 */
	public void setIg483SearchCond(IG483SearchCond ig483SearchCond) {
		this.ig483SearchCond = ig483SearchCond;
	}

	/**
	 * �������б�ȡ��
	 * @return �������б�
	 */
	public List<IG483Info> getLst_IG483Info() {
		return lst_IG483Info;
	}

	/**
	 * �������б��趨
	 * @param lst_IG483Info �������б�
	 */
	public void setLst_IG483Info(List<IG483Info> lst_IG483Info) {
		this.lst_IG483Info = lst_IG483Info;
	}

	/**
	 * �������Ա�б�ȡ��
	 * @return �������Ա�б�
	 */
	public List<IG500Info> getLst_IG500Info() {
		return lst_IG500Info;
	}

	/**
	 * �������Ա�б��趨
	 * @param lst_IG500Info �������Ա�б�
	 */
	public void setLst_IG500Info(List<IG500Info> lst_IG500Info) {
		this.lst_IG500Info = lst_IG500Info;
	}

	/**
	 * ������IDȡ��
	 * @return ������ID
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 * ������ID�趨
	 * @param pgrid ������ID
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}
	
}
