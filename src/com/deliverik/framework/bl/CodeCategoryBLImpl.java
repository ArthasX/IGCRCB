package com.deliverik.framework.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.condition.CodeCategorySearchCond;
import com.deliverik.framework.model.dao.CodeCategoryTBDAO;
import com.deliverik.framework.utility.BLErrorType;

/**
 * ���ݷ�����Ϣ�����߼�ʵ��
 * 
 * @author 
 */
public class CodeCategoryBLImpl extends BaseBLImpl implements CodeCategoryBL {

	/** CodeCategoryTB DAO */
	protected CodeCategoryTBDAO codeCategoryTBDAO;

	public void setCodeCategoryTBDAO(CodeCategoryTBDAO codeCategoryTBDAO) {
		this.codeCategoryTBDAO = codeCategoryTBDAO;
	}

	/**
	 * ������������
	 * 
	 * @param ccid ����
	 * @return �������
	 */
	public CodeCategoryInfo searchCodeCategoryByPK(String ccid) {
		return codeCategoryTBDAO.findByPK(ccid);
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(CodeCategorySearchCond cond){

		return codeCategoryTBDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeCategoryInfo> searchCodeCategory(CodeCategorySearchCond cond){

		List<CodeCategoryInfo> ret = codeCategoryTBDAO.findByCond(cond,0,0);
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
	public List<CodeCategoryInfo> searchCodeCategoryPaging(CodeCategorySearchCond cond,int start,int count){

		List<CodeCategoryInfo> ret = codeCategoryTBDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * ��¼����
	 * 
	 * @param codeCategory ��¼����
	 * @return ���������Ϣ
	 */
	public CodeCategoryInfo registCodeCategory(CodeCategoryInfo codeCategory) throws BLException{
		checkNotExistCodeCategory(codeCategory.getCcid());
		
		CodeCategoryInfo ret = codeCategoryTBDAO.save(codeCategory);
		return ret;
	}

	/**
	 * ɾ������
	 * 
	 * @param codeCategory ɾ������
	 * @return
	 */
	public void deleteCodeCategory(CodeCategoryInfo codeCategory) throws BLException{
		checkExistCodeCategory(codeCategory.getCcid());
		
		codeCategoryTBDAO.delete(codeCategory);
	}

	/**
	 * ɾ������
	 * 
	 * @param ccid ɾ��������������Ϣ����
	 * @return
	 */
	public void deleteCodeCategory(String ccid) throws BLException{
		CodeCategoryInfo info = checkExistCodeCategory(ccid);
		codeCategoryTBDAO.delete(info);
	}

	/**
	 * �������
	 * 
	 * @param codeCategory �������
	 * @return ���������Ϣ
	 */
	public CodeCategoryInfo updateCodeCategory(CodeCategoryInfo codeCategory) throws BLException{
		checkExistCodeCategory(codeCategory.getCcid());
		
		CodeCategoryInfo ret = codeCategoryTBDAO.save(codeCategory);
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

		CodeCategoryInfo info = this.codeCategoryTBDAO.findByPK(ccid);
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
	protected CodeCategoryInfo checkExistCodeCategory(String ccid) throws BLException{
		CodeCategoryInfo info = this.codeCategoryTBDAO.findByPK(ccid);
		if( info == null) {
			throw new BLException(BLErrorType.CODECATEGORY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","���ݷ���");
		}
		
		return info;
	}
}
