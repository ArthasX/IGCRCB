package com.deliverik.framework.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCond;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.model.dao.CodeDetailDefTBDAO;
import com.deliverik.framework.model.entity.CodeDetailDefTBPK;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;

/**
 * 数据信息处理逻辑实现
 * 
 * @author 
 */
public class CodeDetailDefBLImpl extends BaseBLImpl implements CodeDetailDefBL {

	/** CodeDetailTB DAO */
	protected CodeDetailDefTBDAO codeDetailDefTBDAO;

	

	/**
	 * 主键检索处理
	 * 
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CodeDetailDef searchCodeDetailDefByPK(CodeDetailDefTBPK pk) {
		return codeDetailDefTBDAO.findByPK(pk);
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(CodeDetailDefSearchCond cond){

		return codeDetailDefTBDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CodeDetailDef> searchCodeDetailDef(CodeDetailDefSearchCond cond,int orderbyFlag){

		List<CodeDetailDef> ret = codeDetailDefTBDAO.findByCond(cond,0,0,orderbyFlag);
		return ret;
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CodeDetailDef> searchCodeDetailDef(CodeDetailDefSearchCond cond){

		List<CodeDetailDef> ret = codeDetailDefTBDAO.findByCond(cond);
		return ret;
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CodeDetailDef> searchCodeDetailDefTree(CodeDetailDefSearchCond cond,int orderbyFlag){
		List<CodeDetailDef> ret = codeDetailDefTBDAO.findByCond(cond,orderbyFlag);
		return ret;
	}
	
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CodeDetailDef> searchCodeDetailDef(CodeDetailDefSearchCond cond, 
			int start, int count ,int orderbyFlag){

		List<CodeDetailDef> ret = codeDetailDefTBDAO.findByCond(cond,start,count,orderbyFlag);
		return ret;
	}
	
	/**
	 * 更新日期检索处理
	 * 
	 * @param ccid 代码分类ID
	 * @param pccid 父代码分类ID
	 * @param pcid 父代码ID
	 * @return 更新日期
	 */
	public String getLastUpdate(String ccid, String pccid, String pcid){
		return this.codeDetailDefTBDAO.getLastUpdate(ccid, pccid, pcid);
	}
	
	/**
	 * 查询下级最大层次码
	 * @param syscoding 父级层次码
	 * @return 下级最大层次码
	 */
	
	public String getSyscoding(String syscoding){
		return this.codeDetailDefTBDAO.getSyscoding(syscoding);
	}
	
	/**
	 * 查询下级最大层次码
	 * @param ccid 根节点标识
	 * @return 下级最大层次码
	 */
	
	public String getSyscodingLevel1(String ccid){
		return this.codeDetailDefTBDAO.getSyscodingLevel1(ccid);
	}
	
	/**
	 * 查询本级最大cid
	 * @param ccid 层次id
	 * @return 本级最大cid
	 */
	
	public String getMaxcid(final String ccid){
		return this.codeDetailDefTBDAO.getMaxcid(ccid);
	}

	/**
	 * 登录处理
	 * 
	 * @param codeDetail 登录数据
	 * @return 代码信息
	 */
	public CodeDetailDef registCodeDetailDef(CodeDetailDef codeDetail) throws BLException{
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		pk.setCcid(codeDetail.getCcid());
		pk.setCid(codeDetail.getCid());

		checkNotExistCodeDetailDef(pk);
		
		CodeDetailDef ret = codeDetailDefTBDAO.save(codeDetail);
		return ret;
	}

	/**
	 * 删除处理
	 * 
	 * @param codeDetail 删除数据
	 * @return
	 */
	public void deleteCodeDetailDef(CodeDetailDef codeDetailDef) throws BLException{
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		pk.setCcid(codeDetailDef.getCcid());
		pk.setCid(codeDetailDef.getCid());

		checkExistCodeDetailDef(pk);
		
		codeDetailDefTBDAO.delete(codeDetailDef);
	}

	/**
	 * 删除处理
	 * 
	 * @param pk 删除对象代码信息主键
	 * @return
	 */
	public CodeDetailDef deleteCodeDetailDef(CodeDetailDefTBPK pk) throws BLException{
		CodeDetailDef info = checkExistCodeDetailDef(pk);
		codeDetailDefTBDAO.delete(info);
		
		return info;
	}

	/**
	 * 删除处理
	 * 
	 * @param ccid 删除对象分类CD
	 * @return
	 */
	public List<CodeDetailDef> deleteCodeDetailDef(String ccid) throws BLException {
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		cond.setCcid(ccid);
		List<CodeDetailDef> infoList = codeDetailDefTBDAO.findByCond(cond, 0, 0, 0);
		
		codeDetailDefTBDAO.delete(infoList);
		
		return infoList;
	}

	/**
	 * 变更处理
	 * 
	 * @param codeDetail 变更数据
	 * @return 代码信息
	 */
	public CodeDetailDef updateCodeDetailDef(CodeDetailDef codeDetail) throws BLException{
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		pk.setCcid(codeDetail.getCcid());
		pk.setCid(codeDetail.getCid());

		checkExistCodeDetailDef(pk);
		
		CodeDetailDef ret = codeDetailDefTBDAO.save(codeDetail);
		return ret;
	}


	/**
	 * 代码信息不存在检查
	 * 
	 * @param pk 代码信息主键
	 * @return
	 * @throws BLException 
	 */
	protected void checkNotExistCodeDetailDef(CodeDetailDefTBPK pk) throws BLException{

		CodeDetailDef info = this.codeDetailDefTBDAO.findByPK(pk);
		if( info != null ) {
			throw new BLException(BLErrorType.CODEDETAIL_ALREADY_EXISTS_ERROR,
					"IGCO10000.E003","数据");
		}
	}
	
	/**
	 * 代码信息存在检查
	 * 
	 * @param pk 代码信息主键
	 * @return 代码信息
	 * @throws BLException 
	 */
	protected CodeDetailDef checkExistCodeDetailDef(CodeDetailDefTBPK pk) throws BLException{
		CodeDetailDef info = this.codeDetailDefTBDAO.findByPK(pk);
		if( info == null) {
			throw new BLException(BLErrorType.CODEDETAIL_NOT_EXISTS_ERROR,
					"IGCO10000.E004","数据");
		}
		
		return info;
	}
	
	/**
	 * 获取代码信息
	 * @param ecategory 资产分类
	 * @param rccid 关系基础数据分类号
	 * @return 检索结果列表
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ecategory,String rccid){
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		cond.setCcid(rccid);
		cond.setBusinesscode_like(ecategory);
		List<CodeDetailDef> ret = this.searchCodeDetailDef(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//过滤设备与机柜的关系
		if(CommonDefineUtils.ENTIY_CATEGORY_DEVICE.equals(ecategory)){
			for(int i=0; i<ret.size(); i++){
				if(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION_CODE.equals(ret.get(i).getBusinesscode())){
					ret.remove(i);
				}
			}
		}
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		for(CodeDetailDef cd : ret){
			if(!ecategory.equals(CommonDefineUtils.ENTIY_CATEGORY_MODULE)){
				if(cd.getBusinesscode().indexOf(CommonDefineUtils.ENTIY_CATEGORY_MODULE)>-1){
					continue;
				}
			}
			list.add(new LabelValueBean(cd.getCvalue(), cd.getCid()+"#"+cd.getBusinesscode()));
		}
		return list;
	}

	public void setCodeDetailDefTBDAO(CodeDetailDefTBDAO codeDetailDefTBDAO) {
		this.codeDetailDefTBDAO = codeDetailDefTBDAO;
	}
	
	/**
	 * 根据层次码查询该分类下的所有最末级业务系统分类
	 * @param syscoding
	 * @return
	 */
	public List<CodeDetailDef> getFinalBusSys(String syscoding){
		return this.codeDetailDefTBDAO.getFinalBusSys(syscoding);
	}

}
