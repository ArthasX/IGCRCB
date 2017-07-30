/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.condition.SdlYearSummarySearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_ͳ�Ʋ�ѯForm
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0504Form extends BaseForm implements SdlYearSummarySearchCond{

	/**���*/
	protected String year;

	/**����ʲ�ID*/
	protected Integer eiid;

	/**�ʲ����� */
	protected String einame;
	
	/**
	 * ��ȡ���
	 * @return ���
	 */
	public String getYear() {
		return year;
	}

	/**
	 * �������
	 * @param year ���
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * ��ȡ����ʲ�ID
	 * @return ����ʲ�ID
	 */
	public Integer getEiid() {
		if(eiid != null && eiid != 0){
			return eiid;
		}else{
			return null;
		}
	}

	/**
	 * ��������ʲ�ID
	 * @param eiid ����ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��ȡ����ʲ�����
	 * @return ����ʲ�����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ��������ʲ�����
	 * @param einame ����ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	
}