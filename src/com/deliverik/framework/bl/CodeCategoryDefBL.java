package com.deliverik.framework.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.condition.CodeCategoryDefSearchCond;


/**
 * ���ݷ�����Ϣ�����߼��ӿ�
 * 
 */
public interface CodeCategoryDefBL extends BaseBL{

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(CodeCategoryDefSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param ccid ����
	 * @return �������
	 */
	public CodeCategoryDefInfo searchCodeCategoryDefByPK(String ccid);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeCategoryDefInfo> searchCodeCategoryDef(CodeCategoryDefSearchCond cond);

	/**
	 * ��¼����
	 * 
	 * @param entity ��¼����
	 * @return ���������Ϣ
	 */
	public CodeCategoryDefInfo registCodeCategoryDef(CodeCategoryDefInfo codeCategory) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param entity ɾ������
	 * @return
	 */
	public void deleteCodeCategoryDef(CodeCategoryDefInfo codeCategory) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param eid ɾ��������������Ϣ����
	 * @return
	 */
	public void deleteCodeCategoryDef(String ccid) throws BLException;

	/**
	 * �������
	 * 
	 * @param entity �������
	 * @return ���������Ϣ
	 */
	public CodeCategoryDefInfo updateCodeCategoryDef(CodeCategoryDefInfo codeCategory) throws BLException;
	
	/**
	 * ����������ҳ����
	 * 
	 * @param cond ��������
	 * @param start ��ʼ��
	 * @param count ÿҳ����
	 * @return ��������б�
	 */
	public List<CodeCategoryDefInfo> searchCodeCategoryDefPaging(CodeCategoryDefSearchCond cond,int start,int count);
	
	public List<CodeCategoryDefInfo> searchCodeCategoryDefDescCiid(CodeCategoryDefSearchCond cond,int start, int count);

}
