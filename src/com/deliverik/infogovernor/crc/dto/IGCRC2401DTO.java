/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2401Form;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2401Cond;
import com.deliverik.infogovernor.crc.vo.IGCRC2402VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �¼�ƽ�����ʱ��DTO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC2401DTO extends BaseDTO implements Serializable{
	
	/**�¼�ƽ�����ʱ��Form*/
	private IGCRC2401Form igcrc2401Form;

	/**�¼�ƽ�����ʱ���ѯ����*/
	private IGCRC2401Cond cond;
	
	/**�¼�ƽ�����ʱ�伯��*/
	private List<IGCRC2402VO> igcrc2402voList;
	

	/***/
//	private List<String> deptList;
//
//	public List<String> getDeptList() {
//		return deptList;
//	}
//
//	public void setDeptList(List<String> deptList) {
//		this.deptList = deptList;
//	}

	public IGCRC2401Form getIgcrc2401Form() {
		return igcrc2401Form;
	}

	public void setIgcrc2401Form(IGCRC2401Form igcrc2401Form) {
		this.igcrc2401Form = igcrc2401Form;
	}

	public IGCRC2401Cond getCond() {
		return cond;
	}

	public void setCond(IGCRC2401Cond cond) {
		this.cond = cond;
	}

	/**
	 * �¼�ƽ�����ʱ�伯��ȡ��
	 * @return igcrc2402voList  �¼�ƽ�����ʱ�伯��
	 */
	public List<IGCRC2402VO> getIgcrc2402voList() {
		return igcrc2402voList;
	}

	/**
	 * �¼�ƽ�����ʱ�伯���趨
	 * @param igcrc2402voList  �¼�ƽ�����ʱ�伯��
	 */
	public void setIgcrc2402voList(List<IGCRC2402VO> igcrc2402voList) {
		this.igcrc2402voList = igcrc2402voList;
	}



}
