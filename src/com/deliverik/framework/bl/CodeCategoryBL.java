package com.deliverik.framework.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.condition.CodeCategorySearchCond;


/**
 * ���ݷ�����Ϣ�����߼��ӿ�
 * 
 */
public interface CodeCategoryBL extends BaseBL{

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(CodeCategorySearchCond cond);

	/**
	 * ������������
	 * 
	 * @param ccid ����
	 * @return �������
	 */
	public CodeCategoryInfo searchCodeCategoryByPK(String ccid);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeCategoryInfo> searchCodeCategory(CodeCategorySearchCond cond);

	/**
	 * ��¼����
	 * 
	 * @param entity ��¼����
	 * @return ���������Ϣ
	 */
	public CodeCategoryInfo registCodeCategory(CodeCategoryInfo codeCategory) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param entity ɾ������
	 * @return
	 */
	public void deleteCodeCategory(CodeCategoryInfo codeCategory) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param eid ɾ��������������Ϣ����
	 * @return
	 */
	public void deleteCodeCategory(String ccid) throws BLException;

	/**
	 * �������
	 * 
	 * @param entity �������
	 * @return ���������Ϣ
	 */
	public CodeCategoryInfo updateCodeCategory(CodeCategoryInfo codeCategory) throws BLException;
	
	/**
	 * ����������ҳ����
	 * 
	 * @param cond ��������
	 * @param start ��ʼ��
	 * @param count ÿҳ����
	 * @return ��������б�
	 */
	public List<CodeCategoryInfo> searchCodeCategoryPaging(CodeCategorySearchCond cond,int start,int count);

}
