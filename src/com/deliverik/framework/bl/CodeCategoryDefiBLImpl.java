package com.deliverik.framework.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.condition.CodeCategoryDefSearchCond;
import com.deliverik.framework.model.dao.CodeCategoryDefTBDAO;
import com.deliverik.framework.utility.BLErrorType;

/**
 * ���ݷ�����Ϣ�����߼�ʵ��
 * 
 * @author 
 */
public class CodeCategoryDefiBLImpl extends BaseBLImpl implements CodeCategoryDefBL {
	
	/** CodeCategoryTB DAO */
	protected CodeCategoryDefTBDAO codeCategoryDefTBDAO;

	

	/**
	 * ������������
	 * 
	 * @param ccid ����
	 * @return �������
	 */
	public CodeCategoryDefInfo searchCodeCategoryDefByPK(String ccid) {
		return codeCategoryDefTBDAO.findByPK(ccid);
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(CodeCategoryDefSearchCond cond){

		return codeCategoryDefTBDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeCategoryDefInfo> searchCodeCategoryDef(CodeCategoryDefSearchCond cond){

		List<CodeCategoryDefInfo> ret = codeCategoryDefTBDAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeCategoryDefInfo> searchCodeCategoryDefDescCiid(CodeCategoryDefSearchCond cond, int start, int count){
		List<CodeCategoryDefInfo> ret = codeCategoryDefTBDAO.findByCondDescCiid(cond,0,1);
		return ret;
	}
	
	/**
	 * ����������ҳ����
	 * 
	 * @param cond ��������
	 * @param start ��ʼ��
	 * @param count ÿҳ����
	 * @return ��������б�
	 */
	public List<CodeCategoryDefInfo> searchCodeCategoryDefPaging(CodeCategoryDefSearchCond cond,int start,int count){

		List<CodeCategoryDefInfo> ret = codeCategoryDefTBDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * ��¼����
	 * 
	 * @param codeCategory ��¼����
	 * @return ���������Ϣ
	 */
	public CodeCategoryDefInfo registCodeCategoryDef(CodeCategoryDefInfo codeCategory) throws BLException{
		checkNotExistCodeCategory(codeCategory.getCcid());
		
		CodeCategoryDefInfo ret = codeCategoryDefTBDAO.save(codeCategory);
		return ret;
	}

	/**
	 * ɾ������
	 * 
	 * @param codeCategory ɾ������
	 * @return
	 */
	public void deleteCodeCategoryDef(CodeCategoryDefInfo codeCategory) throws BLException{
		checkExistCodeCategory(codeCategory.getCcid());
		
		codeCategoryDefTBDAO.delete(codeCategory);
	}

	/**
	 * ɾ������
	 * 
	 * @param ccid ɾ��������������Ϣ����
	 * @return
	 */
	public void deleteCodeCategoryDef(String ccid) throws BLException{
		CodeCategoryDefInfo info = checkExistCodeCategory(ccid);
		codeCategoryDefTBDAO.delete(info);
	}

	/**
	 * �������
	 * 
	 * @param codeCategory �������
	 * @return ���������Ϣ
	 */
	public CodeCategoryDefInfo updateCodeCategoryDef(CodeCategoryDefInfo codeCategory) throws BLException{
		checkExistCodeCategory(codeCategory.getCcid());
		
		CodeCategoryDefInfo ret = codeCategoryDefTBDAO.save(codeCategory);
		return ret;
	}


	/**
	 * ���������Ϣ�����ڼ��
	 * 
	 * @param ccid ���������Ϣ����
	 * @return
	 * @throws BLException 
	 */
	protected void checkNotExistCodeCategory(String ccid) throws BLException{

		CodeCategoryDefInfo info = this.codeCategoryDefTBDAO.findByPK(ccid);
		if( info != null ) {
			throw new BLException(BLErrorType.CODECATEGORY_ALREADY_EXISTS_ERROR,
					"IGCO10000.E003","���ݷ���");
		}
	}
	
	/**
	 * ���������Ϣ���ڼ��
	 * 
	 * @param ccid ���������Ϣ����
	 * @return ���������Ϣ
	 * @throws BLException 
	 */
	protected CodeCategoryDefInfo checkExistCodeCategory(String ccid) throws BLException{
		CodeCategoryDefInfo info = this.codeCategoryDefTBDAO.findByPK(ccid);
		if( info == null) {
			throw new BLException(BLErrorType.CODECATEGORY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","���ݷ���");
		}
		
		return info;
	}

	public void setCodeCategoryDefTBDAO(CodeCategoryDefTBDAO codeCategoryDefTBDAO) {
		this.codeCategoryDefTBDAO = codeCategoryDefTBDAO;
	}
	
}
