/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2001Form;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2001Cond;
import com.deliverik.infogovernor.crc.vo.IGCRC2002VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ͳ�Ʋ�ѯ��DTO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC2001DTO extends BaseDTO implements Serializable{
	
	/**��ȹ���ͳ���кϼƵļ���*/
	private List<Integer> sumList;
	
	/**��ȹ���ͳ�����ݺ��кϼƵļ���*/
	private List<IGCRC2002VO> igcrc2002voList;

	/**��Ȳ�ѯForm*/
	private IGCRC2001Form igcrc2001Form;
	
	/**��Ȳ�ѯ����*/
	private IGCRC2001Cond cond;
	
	
	public List<Integer> getSumList() {
		return sumList;
	}

	public void setSumList(List<Integer> sumList) {
		this.sumList = sumList;
	}

	public List<IGCRC2002VO> getIgcrc2002voList() {
		return igcrc2002voList;
	}

	public void setIgcrc2002voList(List<IGCRC2002VO> igcrc2002voList) {
		this.igcrc2002voList = igcrc2002voList;
	}

	public IGCRC2001Cond getCond() {
		return cond;
	}

	public void setCond(IGCRC2001Cond cond) {
		this.cond = cond;
	}

	
	public IGCRC2001Form getIgcrc2001Form() {
		return igcrc2001Form;
	}

	public void setIgcrc2001Form(IGCRC2001Form igcrc2001Form) {
		this.igcrc2001Form = igcrc2001Form;
	}

}
