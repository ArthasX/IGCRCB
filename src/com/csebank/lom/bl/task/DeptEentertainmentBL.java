/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.DeptEentertainment;
import com.csebank.lom.model.condition.DeptEentertainmentSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * ���ŽӴ�ͳ��ҵ���߼��ӿ�
 */
public interface DeptEentertainmentBL extends BaseBL {
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DeptEentertainment> searchDeptEentertainment(DeptEentertainmentSearchCond cond, int start, int count);

}
