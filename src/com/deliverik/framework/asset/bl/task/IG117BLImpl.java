package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG117DAO;
import com.deliverik.framework.asset.model.entity.IG117TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;


/**
 * 资产模型业务逻辑实现
 * 
 */
public class IG117BLImpl extends BaseBLImpl implements IG117BL {

	/** Entity DAO */
	protected IG117DAO ig117DAO;

	public void setIg117DAO(IG117DAO ig117DAO) {
		this.ig117DAO = ig117DAO;
	}
	
	/**
	 * <p>
	 * 新的资产模型信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产模型信息对象实例取得
	 */

	public IG117TB getIG117TBInstance() {
		return new IG117TB();
	}

	/**
	 * 根据检索条件取得资产模型信息结果条数
	 * 
	 * @param cond 资产模型信息检索条件
	 * @return 资产模型信息结果条数
	 */
	public int getIG117InfoSearchCount(IG117SearchCond cond){

		return ig117DAO.getSearchCount(cond);
	}

	/**
	 * 根据资产模型信息主键取得资产模型信息
	 * 
	 * @param eid 资产模型信息主键
	 * @return 资产模型信息
	 * @throws BLException 
	 */
	public IG117Info searchIG117InfoByKey(Integer eid) throws BLException{

		return checkExistEntity(eid);
	}

	/**
	 * 根据检索条件取得资产模型信息列表
	 * 
	 * @param cond 资产模型信息检索条件
	 * @return 资产模型信息检索结果列表
	 */
	public List<IG117Info> searchIG117Info(IG117SearchCond cond){

		List<IG117Info> ret = ig117DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * 根据检索条件取得资产模型信息列表
	 * 
	 * @param cond 资产模型信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产模型信息检索结果列表
	 */
	public List<IG117Info> searchIG117Info(IG117SearchCond cond, int start, int count){

		List<IG117Info> ret = ig117DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 保存资产模型信息处理
	 * 
	 * @param ig117Info 保存的资产模型信息数据
	 * @param pareid 上级资产模型ID（0代表上级资产模型为根结点）
	 * @return 资产模型信息
	 * @throws BLException
	 */
	public IG117Info registIG117Info(IG117Info ig117Info,int pareid) throws BLException{
		if(StringUtils.isNotEmpty(ig117Info.getElabel())) {
			checkNotExistEntity(ig117Info.getElabel());
		}
		
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		
		IG117TB etb = getIG117TBInstance();
		this.copyProperties(etb,ig117Info);
		//EntityTB etb = (EntityTB)SerializationUtils.clone(entity);//取得EntityTB
		if(pareid<=0){
			//上级为根结点
			cond.setEparcoding("999");
			etb.setEparcoding("999");
		}else{
			checkExistEntity(pareid);
			IG117Info ent = ig117DAO.findByPK(pareid);
			cond.setEparcoding(ent.getEsyscoding());
		}
		List<IG117Info> list = getMaxCodingEntitys(cond);
		String esyscoding = "";
		String entitynum = ResourceUtility.getString("ENTITY_NUM");//资产模型编码的级数
		if(StringUtils.isEmpty(entitynum)){
			throw new BLException("IGCO10000.E004","资产模型级数");
		}
		int entity_num = Integer.valueOf(entitynum);
		if(CommonDefineUtils.ESYSCODING_MAX_LEVEL < entity_num){
			throw new BLException("IGASM0101.E005","模型基本信息");
		}
		if(list.size()>0){//存在下级机构
			IG117Info entity1 = list.get(0);
			esyscoding = entity1.getEsyscoding();
			String temp = esyscoding.substring(esyscoding.length() - CommonDefineUtils.ESYSCODING_NODE_LENGTH);
			if(temp.equals(CommonDefineUtils.ESYSCODING_NODE_MAX_NUM)){
				throw new BLException("IGSYM1101.E002","数据");
			}
			etb.setEsyscoding(esyscoding.substring(0, esyscoding.length() - CommonDefineUtils.ESYSCODING_NODE_LENGTH)
					+ StringUtils.leftPad((Integer.valueOf(temp) + 1) + "", CommonDefineUtils.ESYSCODING_NODE_LENGTH , "0"));
		}else{
			String syscode = etb.getEparcoding();
			//判断是否已经达到规定的层次数
			if(syscode != null && (syscode.length()/CommonDefineUtils.ESYSCODING_NODE_LENGTH >= CommonDefineUtils.ESYSCODING_MAX_LEVEL)){
				throw new BLException("IGASM0101.E005","模型基本信息");
			}
			etb.setEsyscoding(etb.getEparcoding() + StringUtils.leftPad("1", CommonDefineUtils.ESYSCODING_NODE_LENGTH, "0"));
		}
		etb.setEstatus("1");
		//资产信息登记处理
		IG117Info ret = ig117DAO.save(etb);
		return ret;
	}

	/**
	 * 删除资产模型信息处理
	 * 
	 * @param ig117Info 删除的资产模型信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteIG117Info(IG117Info ig117Info) throws BLException{
		checkExistEntity(ig117Info.getEid());
		ig117DAO.delete(ig117Info);
	}

	/**
	 * 根据资产模型信息主键删除资产模型信息处理
	 * 
	 * @param eid 删除资产模型信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG117InfoByKey(Integer eid) throws BLException{
		IG117Info entity = checkExistEntity(eid);
		ig117DAO.delete(entity);
	}

	/**
	 * 变更资产模型信息处理
	 * 
	 * @param ig117Info 变更的资产模型信息数据
	 * @return 资产模型信息
	 * @throws BLException
	 */
	public IG117Info updateIG117Info(IG117Info ig117Info) throws BLException{
		checkExistEntity(ig117Info.getEid());
		IG117Info ret = ig117DAO.save(ig117Info);
		return ret;
	}

	/**
	 * 资产模型信息不存在检查
	 * 
	 * @param elabel 资产编号
	 * @return
	 * @throws BLException 
	 */
	protected void checkNotExistEntity(String elabel) throws BLException{
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		
		cond.setElabel(elabel);
		
		List<IG117Info> infoList = ig117DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException(BLErrorType.ENTITY_ALREADY_EXISTS,
					"IGCO10000.E003","资产模型基本");
		}
	}
	
	/**
	 * 资产模型信息存在检查
	 * 
	 * @param eid 资产ID
	 * @return 资产模型信息
	 * @throws BLException 
	 */
	protected IG117Info checkExistEntity(Integer eid) throws BLException{
		IG117Info info = ig117DAO.findByPK(eid);
		if( info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产模型基本");
		}
		
		return info;
	}
	
	/**
	 * 根据资产模型ID获取其全部的上级资产模型信息
	 * 
	 * @param eid 资产模型ID
	 * @return 上级资产模型信息结果列表
	 * @throws BLException
	 */
	public List<IG117Info> getParentNodes(Integer eid) throws BLException{
		checkExistEntity(eid);
		IG117Info entity = ig117DAO.findByPK(eid);
		String esyscoding = entity.getEsyscoding();
		int level = CommonDefineUtils.TREE_LEVEL_CODE;
		int ccid = CommonDefineUtils.CCID_LENGTH + level;
		List<String> list = new ArrayList<String>();
		list.add(esyscoding.substring(0,ccid));
		while(esyscoding.length()>ccid){
			ccid=ccid+CommonDefineUtils.CCID_LENGTH;
			list.add(esyscoding.substring(0,ccid));
		}
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		cond.setEsyscodingList(list);
		return ig117DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 根据资产模型信息层次码获取其全部的上级资产模型信息
	 * 
	 * @param esyscoding 资产模型信息层次码
	 * @return 上级资产模型信息结果列表
	 * @throws BLException
	 */
	public List<IG117Info> getParentNodes(String esyscoding){
		
		int level = CommonDefineUtils.TREE_LEVEL_CODE;
		int ccid = CommonDefineUtils.CCID_LENGTH + level;
		List<String> list = new ArrayList<String>();
		list.add(esyscoding.substring(0,ccid));
		while(esyscoding.length()>ccid){
			ccid=ccid+CommonDefineUtils.CCID_LENGTH;
			list.add(esyscoding.substring(0,ccid));
		}
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		cond.setEsyscodingList(list);
		if("999007".equals(esyscoding)){
			cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		}
		return ig117DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 根据检索条件取得资产模型信息列表
	 *  (按照资产模型信息层次码排序)
	 * 
	 * @param cond 资产模型信息检索条件
	 * @param orderType 检索结果列表排序方式
	 * 		  "assetdomain" : 按照资产模型信息层次码升序排序
	 * 
	 * @return 资产模型信息列表
	 */
	public List<IG117Info> searchIG117Info(IG117SearchCond cond, String orderType) {
		List<IG117Info> ret = ig117DAO.findByCond(cond, orderType);
		return ret;
	}
	
	/**
	 * 根据检索条件按照资产模型信息层次码倒序排序方式取得资产模型信息列表
	 * 
	 * @param cond 资产模型信息检索条件
	 * @return 资产模型信息列表
	 */
	private List<IG117Info> getMaxCodingEntitys(IG117SearchCond cond)
	{
		List<IG117Info> ret = ig117DAO.findByCondCoding(cond);
		return ret;
	}
}
