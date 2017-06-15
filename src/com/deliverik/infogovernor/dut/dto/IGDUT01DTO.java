/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.dut.form.IGDUT0101Form;
import com.deliverik.infogovernor.dut.form.IGDUT0102Form;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditDefSearchCond;

import com.deliverik.framework.user.model.User;

/**
 * ֵ�������DTO
 *
 */
@SuppressWarnings("serial")
public class IGDUT01DTO extends BaseDTO implements Serializable {
	
	//-----------------------------------------------------------ֵ��������ѯ�б�----------------------------------------------------------------------

	/** ֵ�����ѯ���� */
	protected DutyAuditDefSearchCond dutyAuditDefSearchCond;
	
	/** ֵ������ϢForm */
	protected IGDUT0102Form igDUT0102Form;
	
	/** ֵ�������趨Form */
	protected IGDUT0101Form igDUT0101Form;
	
	/**ֵ������Ϣ����*/
	protected DutyAuditDef dutyAuditDef;

	/** ֵ������Ϣ��������� */
	protected List<DutyAuditDef> dutyAuditList;
	
	/** ֵ�����趨��������� */
	protected List<DutyAuditTime> dutyAudit2List;
	
	/** ��ǰ��¼�û� */
	protected User user;
	
	
	
	/**
	 * ��ǰ��¼�û�ȡ��
	 * @return ֵ�����趨Form
	 */
	public User getUser() {
		return user;
	}

	/**
	 * ��ǰ��¼�û��趨
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ֵ�����趨Formȡ��
	 * @return ֵ�����趨Form
	 */
	public IGDUT0101Form getIgDUT0101Form() {
		return igDUT0101Form;
	}
    
	/**
	 * ֵ������Ϣȡ��
	 * @return ֵ������Ϣ
	 */
	public DutyAuditDef getDutyAuditDef() {
		return dutyAuditDef;
	}
    /**
     * ֵ������Ϣ����
     * @param dutyAuditDef
     */
	public void setDutyAuditDef(DutyAuditDef dutyAuditDef) {
		this.dutyAuditDef = dutyAuditDef;
	}

	/**
	 * ֵ�����趨Form�趨
	 * @param igDUT0101Form ֵ�����趨Form
	 */
	public void setIgDUT0101Form(IGDUT0101Form igDUT0101Form) {
		this.igDUT0101Form = igDUT0101Form;
	}
    
	/**
	 * ֵ�����趨���������ȡ��
	 * @return ֵ�����趨���������
	 */
	public List<DutyAuditTime> getDutyAudit2List() {
		return dutyAudit2List;
	}
    
	/**
	 * ֵ�����趨����������趨
	 * @param dutyAuditList ֵ�����趨���������
	 */
	public void setDutyAudit2List(List<DutyAuditTime> dutyAudit2List) {
		this.dutyAudit2List = dutyAudit2List;
	}

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ֵ������Ϣ���������� */
	protected int maxSearchCount;

	
	/**
	 * ֵ�����ѯ����ȡ��
	 * @return ֵ�����ѯ����
	 */
	public DutyAuditDefSearchCond getDutyAuditDefSearchCond() {
		return dutyAuditDefSearchCond;
	}

	/**
	 * ֵ�����ѯ�����趨
	 * @param dutyAuditDefSearchCond ֵ�����ѯ����
	 */
	public void setDutyAuditDefSearchCond(
			DutyAuditDefSearchCond dutyAuditDefSearchCond) {
		this.dutyAuditDefSearchCond = dutyAuditDefSearchCond;
	}

	/**
	 * ֵ������ϢFormȡ��
	 * @return ֵ������ϢForm
	 */
	public IGDUT0102Form getIgDUT0102Form() {
		return igDUT0102Form;
	}

	/**
	 * ֵ������ϢForm�趨
	 * @param igDUT0102Form ֵ������ϢForm
	 */
	public void setIgDUT0102Form(IGDUT0102Form igDUT0102Form) {
		this.igDUT0102Form = igDUT0102Form;
	}

	/**
	 * ֵ������Ϣ���������ȡ��
	 * @return ֵ������Ϣ���������
	 */
	public List<DutyAuditDef> getDutyAuditList() {
		return dutyAuditList;
	}

	/**
	 * ֵ������Ϣ����������趨
	 * @param dutyAuditList ֵ������Ϣ���������
	 */
	public void setDutyAuditList(List<DutyAuditDef> dutyAuditList) {
		this.dutyAuditList = dutyAuditList;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ֵ������Ϣ����������ȡ��
	 * @return ֵ������Ϣ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ֵ������Ϣ�����������趨
	 * @param maxSearchCount ֵ������Ϣ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

}
