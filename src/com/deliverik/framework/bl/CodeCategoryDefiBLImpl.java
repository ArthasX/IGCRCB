package com.deliverik.framework.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.condition.CodeCategoryDefSearchCond;
import com.deliverik.framework.model.dao.CodeCategoryDefTBDAO;
import com.deliverik.framework.utility.BLErrorType;

/**
 * 数据分类信息处理逻辑实现
 * 
 * @author 
 */
public class CodeCategoryDefiBLImpl extends BaseBLImpl implements CodeCategoryDefBL {
	
	/** CodeCategoryTB DAO */
	protected CodeCategoryDefTBDAO codeCategoryDefTBDAO;

	

	/**
	 * 主键检索处理
	 * 
	 * @param ccid 主键
	 * @return 检索结果
	 */
	public CodeCategoryDefInfo searchCodeCategoryDefByPK(String ccid) {
		return codeCategoryDefTBDAO.findByPK(ccid);
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(CodeCategoryDefSearchCond cond){

		return codeCategoryDefTBDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CodeCategoryDefInfo> searchCodeCategoryDef(CodeCategoryDefSearchCond cond){

		List<CodeCategoryDefInfo> ret = codeCategoryDefTBDAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CodeCategoryDefInfo> searchCodeCategoryDefDescCiid(CodeCategoryDefSearchCond cond, int start, int count){
		List<CodeCategoryDefInfo> ret = codeCategoryDefTBDAO.findByCondDescCiid(cond,0,1);
		return ret;
	}
	
	/**
	 * 条件检索分页处理
	 * 
	 * @param cond 检索条件
	 * @param start 起始数
	 * @param count 每页条数
	 * @return 检索结果列表
	 */
	public List<CodeCategoryDefInfo> searchCodeCategoryDefPaging(CodeCategoryDefSearchCond cond,int start,int count){

		List<CodeCategoryDefInfo> ret = codeCategoryDefTBDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 登录处理
	 * 
	 * @param codeCategory 登录数据
	 * @return 代码分类信息
	 */
	public CodeCategoryDefInfo registCodeCategoryDef(CodeCategoryDefInfo codeCategory) throws BLException{
		checkNotExistCodeCategory(codeCategory.getCcid());
		
		CodeCategoryDefInfo ret = codeCategoryDefTBDAO.save(codeCategory);
		return ret;
	}

	/**
	 * 删除处理
	 * 
	 * @param codeCategory 删除数据
	 * @return
	 */
	public void deleteCodeCategoryDef(CodeCategoryDefInfo codeCategory) throws BLException{
		checkExistCodeCategory(codeCategory.getCcid());
		
		codeCategoryDefTBDAO.delete(codeCategory);
	}

	/**
	 * 删除处理
	 * 
	 * @param ccid 删除对象代码分类信息主键
	 * @return
	 */
	public void deleteCodeCategoryDef(String ccid) throws BLException{
		CodeCategoryDefInfo info = checkExistCodeCategory(ccid);
		codeCategoryDefTBDAO.delete(info);
	}

	/**
	 * 变更处理
	 * 
	 * @param codeCategory 变更数据
	 * @return 代码分类信息
	 */
	public CodeCategoryDefInfo updateCodeCategoryDef(CodeCategoryDefInfo codeCategory) throws BLException{
		checkExistCodeCategory(codeCategory.getCcid());
		
		CodeCategoryDefInfo ret = codeCategoryDefTBDAO.save(codeCategory);
		return ret;
	}


	/**
	 * 代码分类信息不存在检查
	 * 
	 * @param ccid 代码分类信息主键
	 * @return
	 * @throws BLException 
	 */
	protected void checkNotExistCodeCategory(String ccid) throws BLException{

		CodeCategoryDefInfo info = this.codeCategoryDefTBDAO.findByPK(ccid);
		if( info != null ) {
			throw new BLException(BLErrorType.CODECATEGORY_ALREADY_EXISTS_ERROR,
					"IGCO10000.E003","数据分类");
		}
	}
	
	/**
	 * 代码分类信息存在检查
	 * 
	 * @param ccid 代码分类信息主键
	 * @return 代码分类信息
	 * @throws BLException 
	 */
	protected CodeCategoryDefInfo checkExistCodeCategory(String ccid) throws BLException{
		CodeCategoryDefInfo info = this.codeCategoryDefTBDAO.findByPK(ccid);
		if( info == null) {
			throw new BLException(BLErrorType.CODECATEGORY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","数据分类");
		}
		
		return info;
	}

	public void setCodeCategoryDefTBDAO(CodeCategoryDefTBDAO codeCategoryDefTBDAO) {
		this.codeCategoryDefTBDAO = codeCategoryDefTBDAO;
	}
	
}
