package com.deliverik.framework.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCond;
import com.deliverik.framework.model.entity.CodeDetailDefTBPK;


/**
 * 数据信息处理逻辑接口
 * 
 */
public interface CodeDetailDefBL extends BaseBL{

	/**
	 * 主键检索处理
	 * 
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CodeDetailDef searchCodeDetailDefByPK(CodeDetailDefTBPK pk);

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(CodeDetailDefSearchCond cond);

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CodeDetailDef> searchCodeDetailDef(CodeDetailDefSearchCond cond,int orderbyFlag);
	
	public List<CodeDetailDef> searchCodeDetailDef(CodeDetailDefSearchCond cond);

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CodeDetailDef> searchCodeDetailDef(CodeDetailDefSearchCond cond, 
			int start, int count, int orderbyFlag);

	/**
	 * 更新日期检索处理
	 * 
	 * @param ccid 代码分类ID
	 * @param pccid 父代码分类ID
	 * @param pcid 父代码ID
	 * @return 更新日期
	 */
	public String getLastUpdate(String ccid, String pccid, String pcid);
	
	/**
	 * 查询下级最大层次码
	 * @param syscoding 父级层次码
	 * @return 下级最大层次码
	 */
	
	public String getSyscoding(final String syscoding);
	
	/**
	 * 查询下级最大层次码
	 * @param ccid 根节点标识
	 * @return 下级最大层次码
	 */
	
	public String getSyscodingLevel1(String ccid);
	
	/**
	 * 查询本级最大cid
	 * @param ccid 层次id
	 * @return 本级最大cid
	 */
	
	public String getMaxcid(final String ccid);

	/**
	 * 登录处理
	 * 
	 * @param entity 登录数据
	 * @return 代码信息
	 */
	public CodeDetailDef registCodeDetailDef(CodeDetailDef codeDetail) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param entity 删除数据
	 * @return
	 */
	public void deleteCodeDetailDef(CodeDetailDef codeDetail) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param eid 删除对象代码信息主键
	 * @return
	 */
	public CodeDetailDef deleteCodeDetailDef(CodeDetailDefTBPK pk) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param ccid 删除对象分类CD
	 * @return
	 */
	public List<CodeDetailDef> deleteCodeDetailDef(String ccid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param entity 变更数据
	 * @return 代码信息
	 */
	public CodeDetailDef updateCodeDetailDef(CodeDetailDef codeDetail) throws BLException;
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CodeDetailDef> searchCodeDetailDefTree(CodeDetailDefSearchCond cond,int orderbyFlag);
	
	/**
	 * 获取代码信息
	 * @param ecategory 资产分类
	 * @param rccid 关系基础数据分类号
	 * @return 检索结果列表
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ecategory,String rccid);
	
	/**
	 * 根据层次码查询该分类下的所有最末级业务系统分类
	 * @param syscoding
	 * @return
	 */
	public List<CodeDetailDef> getFinalBusSys(String syscoding);

}
