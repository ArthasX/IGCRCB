package com.deliverik.framework.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.condition.CodeCategorySearchCond;
import com.deliverik.framework.model.dao.CodeCategoryTBDAO;
import com.deliverik.framework.utility.BLErrorType;

/**
 * 数据分类信息处理逻辑实现
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
	 * 主键检索处理
	 * 
	 * @param ccid 主键
	 * @return 检索结果
	 */
	public CodeCategoryInfo searchCodeCategoryByPK(String ccid) {
		return codeCategoryTBDAO.findByPK(ccid);
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(CodeCategorySearchCond cond){

		return codeCategoryTBDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CodeCategoryInfo> searchCodeCategory(CodeCategorySearchCond cond){

		List<CodeCategoryInfo> ret = codeCategoryTBDAO.findByCond(cond,0,0);
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
	public List<CodeCategoryInfo> searchCodeCategoryPaging(CodeCategorySearchCond cond,int start,int count){

		List<CodeCategoryInfo> ret = codeCategoryTBDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 登录处理
	 * 
	 * @param codeCategory 登录数据
	 * @return 代码分类信息
	 */
	public CodeCategoryInfo registCodeCategory(CodeCategoryInfo codeCategory) throws BLException{
		checkNotExistCodeCategory(codeCategory.getCcid());
		
		CodeCategoryInfo ret = codeCategoryTBDAO.save(codeCategory);
		return ret;
	}

	/**
	 * 删除处理
	 * 
	 * @param codeCategory 删除数据
	 * @return
	 */
	public void deleteCodeCategory(CodeCategoryInfo codeCategory) throws BLException{
		checkExistCodeCategory(codeCategory.getCcid());
		
		codeCategoryTBDAO.delete(codeCategory);
	}

	/**
	 * 删除处理
	 * 
	 * @param ccid 删除对象代码分类信息主键
	 * @return
	 */
	public void deleteCodeCategory(String ccid) throws BLException{
		CodeCategoryInfo info = checkExistCodeCategory(ccid);
		codeCategoryTBDAO.delete(info);
	}

	/**
	 * 变更处理
	 * 
	 * @param codeCategory 变更数据
	 * @return 代码分类信息
	 */
	public CodeCategoryInfo updateCodeCategory(CodeCategoryInfo codeCategory) throws BLException{
		checkExistCodeCategory(codeCategory.getCcid());
		
		CodeCategoryInfo ret = codeCategoryTBDAO.save(codeCategory);
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

		CodeCategoryInfo info = this.codeCategoryTBDAO.findByPK(ccid);
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
	protected CodeCategoryInfo checkExistCodeCategory(String ccid) throws BLException{
		CodeCategoryInfo info = this.codeCategoryTBDAO.findByPK(ccid);
		if( info == null) {
			throw new BLException(BLErrorType.CODECATEGORY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","数据分类");
		}
		
		return info;
	}
}
