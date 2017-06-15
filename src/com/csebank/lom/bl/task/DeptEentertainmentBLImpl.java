/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.DeptEentertainment;
import com.csebank.lom.model.condition.DeptEentertainmentSearchCond;
import com.csebank.lom.model.dao.DeptEentertainmentDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ʳ�ýӴ�ͳ��ҵ���߼��ӿ�ʵ��
 */
public class DeptEentertainmentBLImpl extends BaseBLImpl implements DeptEentertainmentBL {
	
	/** DeptEentertainment DAO */
	protected DeptEentertainmentDAO deptEentertainmentDAO;
	
	public void setDeptEentertainmentDAO(
			DeptEentertainmentDAO deptEentertainmentDAO) {
		this.deptEentertainmentDAO = deptEentertainmentDAO;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DeptEentertainment> searchDeptEentertainment(DeptEentertainmentSearchCond cond, int start, int count){
		
		return deptEentertainmentDAO.findByCond(cond,start,count);
	}

}
