/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.form;

import com.csebank.lom.model.condition.DeptEentertainmentSearchCond;
import com.deliverik.framework.base.BaseForm;
/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_���ŽӴ�ͳ��FormBean
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0509Form extends BaseForm implements DeptEentertainmentSearchCond {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ��ѯ����
	 */
	public String ewhere;
	
	public Integer rid;
	
	/**
	 * ʳ���д�����ͳ�ƿ�ʼʱ���ѯ
	 */
	public String etime_from;
	
	/**
	 * ʳ���д�����ͳ�ƽ���ʱ���ѯ
	 */
	public String etime_to;

	/**
	 * ʳ�óɱ���Ϣʱ���ѯȡ��
	 * @return ʳ�óɱ���Ϣ��ʼʱ���ѯ
	 */
	public String getEtime_from() {
		return etime_from;
	}

	/**
	 * ʳ���д�����ͳ�ƿ�ʼʱ���ѯ�趨
	 * @param etime_from ʳ���д�����ͳ�ƿ�ʼʱ���ѯ
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}

	/**
	 * ʳ���д�����ͳ�ƽ���ʱ���ѯȡ��
	 * @return ʳ���д�����ͳ�ƽ���ʱ���ѯ
	 */
	public String getEtime_to() {
		return etime_to;
	}

	/**
	 * ʳ���д�����ͳ�ƽ���ʱ���ѯ�趨
	 * @param etime_to ʳ���д�����ͳ�ƽ���ʱ���ѯ
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}
	
	/**
	 * ��ѯ����
	 * @return ��ѯ����
	 */
	public String getEwhere() {
		return ewhere;
	}
	
	/**
	 * ��ѯ����
	 * @param ewhere ��ѯ����
	 */
	public void setEwhere(String ewhere) {
		this.ewhere = ewhere;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}
}
