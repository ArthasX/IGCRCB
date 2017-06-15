/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2101Form;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2101Cond;
import com.deliverik.infogovernor.crc.vo.IGCRC2102VO;

/**	
 * ����:��Ա����ͳ�Ʋ�ѯ��DTO
 * ������¼��yukexin    2014-8-15 ����5:14:43	
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGCRC2101DTO extends BaseDTO implements Serializable{
	
	
	/** ��Ա����ͳ�Ʋ�ѯ����FORM */
	private IGCRC2101Form igcrc2101Form;
	
	/** ��Ա����ͳ����Ϣ�������� */
	protected IGCRC2101Cond entityItemVWSearchCond;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ��Ա����ͳ�Ƽ������ ���ϼ�*/
	protected List<IGCRC2102VO> igcrc2102voList;

	/** ��Ա����ͳ�Ʒ���ϼƽ�� */
	protected List<Integer> listSum;
	
	 /** ���������б�  */	
	protected List<IGCRC2102VWInfo> departmentBeanList;

	/**
	 * ��ҳ��DTOȡ��
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 *
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public IGCRC2101Form getIgcrc2101Form() {
		return igcrc2101Form;
	}

	public void setIgcrc2101Form(IGCRC2101Form igcrc2101Form) {
		this.igcrc2101Form = igcrc2101Form;
	}

	/**
	 * ��Ա����ͳ����Ϣ��������ȡ��
	 * @return ��Ա����ͳ����Ϣ��������
	 */
	public IGCRC2101Cond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * ��Ա����ͳ����Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond ��Ա����ͳ����Ϣ��������
	 */
	public void setEntityItemVWSearchCond(IGCRC2101Cond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	public List<Integer> getListSum() {
		return listSum;
	}

	public void setListSum(List<Integer> listSum) {
		this.listSum = listSum;
	}

	public List<IGCRC2102VO> getIgcrc2102voList() {
		return igcrc2102voList;
	}

	public void setIgcrc2102voList(List<IGCRC2102VO> igcrc2102voList) {
		this.igcrc2102voList = igcrc2102voList;
	}

	public List<IGCRC2102VWInfo> getDepartmentBeanList() {
		return departmentBeanList;
	}

	public void setDepartmentBeanList(List<IGCRC2102VWInfo> departmentBeanList) {
		this.departmentBeanList = departmentBeanList;
	}

}
