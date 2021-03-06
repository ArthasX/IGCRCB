package com.deliverik.framework.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.condition.CodeCategoryDefSearchCond;


/**
 * 数据分类信息处理逻辑接口
 * 
 */
public interface CodeCategoryDefBL extends BaseBL{

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(CodeCategoryDefSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param ccid 主键
	 * @return 检索结果
	 */
	public CodeCategoryDefInfo searchCodeCategoryDefByPK(String ccid);

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CodeCategoryDefInfo> searchCodeCategoryDef(CodeCategoryDefSearchCond cond);

	/**
	 * 登录处理
	 * 
	 * @param entity 登录数据
	 * @return 代码分类信息
	 */
	public CodeCategoryDefInfo registCodeCategoryDef(CodeCategoryDefInfo codeCategory) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param entity 删除数据
	 * @return
	 */
	public void deleteCodeCategoryDef(CodeCategoryDefInfo codeCategory) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param eid 删除对象代码分类信息主键
	 * @return
	 */
	public void deleteCodeCategoryDef(String ccid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param entity 变更数据
	 * @return 代码分类信息
	 */
	public CodeCategoryDefInfo updateCodeCategoryDef(CodeCategoryDefInfo codeCategory) throws BLException;
	
	/**
	 * 条件检索分页处理
	 * 
	 * @param cond 检索条件
	 * @param start 起始数
	 * @param count 每页条数
	 * @return 检索结果列表
	 */
	public List<CodeCategoryDefInfo> searchCodeCategoryDefPaging(CodeCategoryDefSearchCond cond,int start,int count);
	
	public List<CodeCategoryDefInfo> searchCodeCategoryDefDescCiid(CodeCategoryDefSearchCond cond,int start, int count);

}
