package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.soc.asset.bl.task.SOC0117VWBL;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0117VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0117VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0117VWDAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VW;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;


/**
 * 资产模型业务逻辑实现
 * 
 */
public class SOC0117VWBLImpl extends BaseBLImpl implements SOC0117VWBL {

	/** Entity DAO */
	protected SOC0117VWDAO soc0117VWDAO;

	
	
	/**
	 * @param soc0117vwdao the soc0117VWDAO to set
	 */
	public void setSoc0117VWDAO(SOC0117VWDAO soc0117vwdao) {
		soc0117VWDAO = soc0117vwdao;
	}

	/**
	 * <p>
	 * 新的资产模型信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产模型信息对象实例取得
	 */

	public SOC0117VW getEntityTBInstance() {
		return new SOC0117VW();
	}

	/**
	 * 根据检索条件取得资产模型信息结果条数
	 * 
	 * @param cond 资产模型信息检索条件
	 * @return 资产模型信息结果条数
	 */
	public int getEntitySearchCount(SOC0117VWSearchCond cond){

		return soc0117VWDAO.getSearchCount(cond);
	}

	/**
	 * 根据资产模型信息主键取得资产模型信息
	 * 
	 * @param eid 资产模型信息主键
	 * @return 资产模型信息
	 * @throws BLException 
	 */
	public SOC0117VWInfo searchEntityByKey(SOC0117VWPK pk) throws BLException{

		return checkExistEntity(pk);
	}

	/**
	 * 根据检索条件取得资产模型信息列表
	 * 
	 * @param cond 资产模型信息检索条件
	 * @return 资产模型信息检索结果列表
	 */
	public List<SOC0117VWInfo> searchEntity(SOC0117VWSearchCond cond){

		List<SOC0117VWInfo> ret = soc0117VWDAO.findByCond(cond,0,0);
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
	public List<SOC0117VWInfo> searchEntity(SOC0117VWSearchCond cond, int start, int count){

		List<SOC0117VWInfo> ret = soc0117VWDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 保存资产模型信息处理
	 * 
	 * @param entity 保存的资产模型信息数据
	 * @param pareid 上级资产模型ID（0代表上级资产模型为根结点）
	 * @return 资产模型信息
	 * @throws BLException
	 */
	public SOC0117VWInfo registEntity(SOC0117VWInfo entity,String pareid) throws BLException{
		if(StringUtils.isNotEmpty(entity.getElabel())) {
			checkNotExistEntity(entity.getElabel());
		}
		
		SOC0117VWSearchCondImpl cond = new SOC0117VWSearchCondImpl();
		
		SOC0117VW etb = getEntityTBInstance();
		this.copyProperties(etb,entity);
		//EntityTB etb = (EntityTB)SerializationUtils.clone(entity);//取得EntityTB
//		if("root".equals(pareid)){ //**********************
//			//上级为根结点
//			cond.setEparcoding("999");
//			etb.setEparcoding("999");
//			etb.setEid(getNextEid(pareid));
//		}else{
//			checkExistEntity(pareid);
//			SOC0117VWInfo ent = soc0117VWDAO.findByPK(pareid);
//			cond.setEparcoding(ent.getEsyscoding());
//		}
//		
//		// 设定资产模型ID
//		String eid = getNextEid(pareid);
		String eid="";
		if("root".equals(pareid)){ //**********************
			//上级为根结点
			cond.setEparcoding("999");
			etb.setEparcoding("999");
			
			
			if(pareid.contains("CM")){
				// 设定资产模型ID
				eid = getNextEid(pareid);
				}else {
					Integer a = soc0117VWDAO.findMaxEidByCondNotLikeCM();
						eid=(a+1)+"";
				}
			
			etb.setEid(eid);
		}else{
//			checkExistEntity(pareid);
			SOC0117VWInfo ent = soc0117VWDAO.findByPK(pareid);
			cond.setEparcoding(ent.getEsyscoding());
		}
		if(pareid.contains("CM")){
		// 设定资产模型ID
		eid = getNextEid(pareid);
		}else {
			Integer a = soc0117VWDAO.findMaxEidByCondNotLikeCM();
				eid=(a+1)+"";
		}
		if (eid == null) {
			throw new BLException("IGASM0101.E008","模型基本信息");
		} else {
			etb.setEid(eid);
		}
		
		List<SOC0117VWInfo> list = getMaxCodingEntitys(cond);
		String esyscoding = "";
		
		String entitynum = ResourceUtility.getString("ENTITY_NUM");//资产模型编码的级数
		if(entitynum == null || "".equals(entitynum)){
			entitynum = "6";
		}
		int entity_num = Integer.valueOf(entitynum);
		int entity_sys_len = 18;//资产模型编码的默认长度
		if(entity_num>1 && entity_num<10){
			entity_sys_len = 3+3*(entity_num-1);
		}
		if(list.size()>0){//存在下级机构
			SOC0117VWInfo entity1 = list.get(0);
			esyscoding = entity1.getEsyscoding();
			String temp = esyscoding.substring(esyscoding.length()-3);
			if("999".equals(etb.getEparcoding())){
				String ecategory = entity1.getEcategory();
				ecategory = StringUtils.leftPad(Integer.parseInt(ecategory)+1+"", 3, "0");
				if(ecategory.equals("999")){
					throw new BLException("IGASM0101.E003","模型基本信息");
				}
				etb.setEcategory(ecategory);
			}
			if(temp.substring(temp.length()-3).equals("999")){
				throw new BLException("IGASM0101.E004","模型基本信息");
			}
			if("0".equals(temp.substring(0, 1))){//0**
				String tmp = String.valueOf(Integer.valueOf(temp)+1);
				if(tmp.length()==1){
					temp = "00"+tmp;
				}else if(tmp.length()==2){
					temp = "0"+tmp;
				}else{
					temp = tmp;
				}
				esyscoding = esyscoding.substring(0,esyscoding.length()-3)+temp;
			}else{//***
				esyscoding = esyscoding.substring(0,esyscoding.length()-3)+String.valueOf(Integer.valueOf(temp)+1);
			}
			etb.setEsyscoding(esyscoding);
		}else{
			
			String syscode = etb.getEparcoding();
			
			//判断是否已经达到规定的层次数
			if(syscode!=null && syscode.length()>=entity_sys_len){
				throw new BLException("IGASM0101.E005","模型基本信息");
			}
			
			etb.setEsyscoding(etb.getEparcoding()+"001");
		}
		etb.setEstatus("1");

		//资产信息登记处理
		SOC0117VWInfo ret = soc0117VWDAO.save(etb);
		return ret;
	}

	/**
	 * 获取主键
	 * @param pareid
	 */
	private String getNextEid(String pareid) {

		String eidstr = "";
		
		// 若上级EID不存在
		if ("root".equals(pareid)) {
			// 查询模型信息
			List<SOC0117VWInfo> eList = soc0117VWDAO.findMaxEidByCond(new SOC0117VWSearchCondImpl());
			
			// 若存在获取最大EID，将大分类+1
			if (eList != null && eList.size() > 0) {
				String lastEid = eList.get(0).getEid();
				String serinum = lastEid.substring(2, 4);
				if (serinum.equals("99")) {
					return null;
				}
				String nextnum = String.valueOf(Integer.parseInt(serinum) + 1);
				eidstr = "CM" + StringUtils.leftPad(nextnum, 2, "0") + "001000";
			} 
			// 不存在
			else {
				eidstr = "CM01001000";
			}
		} 
		// 若存在
		else {
			// 获取模型大分类
			String headstr = pareid.substring(0, 3);//动测合版
			//String headstr = pareid.substring(0, 4);
			SOC0117VWSearchCondImpl cond = new SOC0117VWSearchCondImpl();
			cond.setEidStr_like(headstr + "001");
			List<SOC0117VWInfo> eList = soc0117VWDAO.findMaxEidByCond(cond);
			
			// 若存在将序列号+1
			if (eList != null && eList.size() > 0) {
				String lastEid = eList.get(0).getEid();
				String serinum = lastEid.substring(7);
				if (serinum.equals("999")) {
					return null;
				}
				String nextnum = String.valueOf(Integer.parseInt(serinum) + 1);
				eidstr = headstr + "001" + StringUtils.leftPad(nextnum, 3, "0");
			} 
			// 不存在序列号设为001
			else {
				eidstr = headstr + "001" + "001";
			}
		}
		
		return eidstr;
	}

	/**
	 * 删除资产模型信息处理
	 * 
	 * @param entity 删除的资产模型信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteEntity(SOC0117VWInfo entity) throws BLException{
//		checkExistEntity(entity.getEid());
//		soc0117VWDAO.delete(entity);
	}

	/**
	 * 根据资产模型信息主键删除资产模型信息处理
	 * 
	 * @param eid 删除资产模型信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityByKey(String eid) throws BLException{
//		SOC0117VWInfo entity = checkExistEntity(eid);
//		soc0117VWDAO.delete(entity);
	}

	/**
	 * 变更资产模型信息处理
	 * 
	 * @param entity 变更的资产模型信息数据
	 * @return 资产模型信息
	 * @throws BLException
	 */
	public SOC0117VWInfo updateEntity(SOC0117VWInfo entity) throws BLException{
//		checkExistEntity(entity.getEid());
//		SOC0117VWInfo ret = soc0117VWDAO.save(entity);
		return null;
	}

	/**
	 * 资产模型信息不存在检查
	 * 
	 * @param elabel 资产编号
	 * @return
	 * @throws BLException 
	 */
	protected void checkNotExistEntity(String elabel) throws BLException{
		SOC0117VWSearchCondImpl cond = new SOC0117VWSearchCondImpl();
		
		cond.setElabel(elabel);
		
		List<SOC0117VWInfo> infoList = soc0117VWDAO.findByCond(cond, 0, 0);
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
	protected SOC0117VWInfo checkExistEntity(SOC0117VWPK pk) throws BLException{
		SOC0117VWInfo info = soc0117VWDAO.findByPK(pk);
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
	public List<SOC0117VWInfo> getParentNodes(String eid) throws BLException{
//		checkExistEntity(eid);
//		SOC0117VWInfo entity = soc0117VWDAO.findByPK(eid);
//		String esyscoding = entity.getEsyscoding();
//		int level = CommonDefineUtils.TREE_LEVEL_CODE;
//		int ccid = CommonDefineUtils.CCID_LENGTH + level;
//		List<String> list = new ArrayList<String>();
//		list.add(esyscoding.substring(0,ccid));
//		while(esyscoding.length()>ccid){
//			ccid=ccid+CommonDefineUtils.CCID_LENGTH;
//			list.add(esyscoding.substring(0,ccid));
//		}
//		SOC0117VWSearchCondImpl cond = new SOC0117VWSearchCondImpl();
//		cond.setEsyscodingList(list);
//		return soc0117VWDAO.findByCond(cond, 0, 0);
		return null;
	}
	
	/**
	 * 根据资产模型信息层次码获取其全部的上级资产模型信息
	 * 
	 * @param esyscoding 资产模型信息层次码
	 * @return 上级资产模型信息结果列表
	 * @throws BLException
	 */
	public List<SOC0117VWInfo> getParentNodesByEsyscoding(String esyscoding){
		
		int level = CommonDefineUtils.TREE_LEVEL_CODE;
		int ccid = CommonDefineUtils.CCID_LENGTH + level;
		List<String> list = new ArrayList<String>();
		list.add(esyscoding.substring(0,ccid));
		while(esyscoding.length()>ccid){
			ccid=ccid+CommonDefineUtils.CCID_LENGTH;
			list.add(esyscoding.substring(0,ccid));
		}
		SOC0117VWSearchCondImpl cond = new SOC0117VWSearchCondImpl();
		cond.setEsyscodingList(list);
		if("999007".equals(esyscoding)){
			cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		}
		return soc0117VWDAO.findByCond(cond, 0, 0);
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
	public List<SOC0117VWInfo> searchEntity(SOC0117VWSearchCond cond, String orderType) {
		List<SOC0117VWInfo> ret = soc0117VWDAO.findByCond(cond, orderType);
		return ret;
	}
	
	/**
	 * 根据检索条件按照资产模型信息层次码倒序排序方式取得资产模型信息列表
	 * 
	 * @param cond 资产模型信息检索条件
	 * @return 资产模型信息列表
	 */
	private List<SOC0117VWInfo> getMaxCodingEntitys(SOC0117VWSearchCond cond)
	{
		List<SOC0117VWInfo> ret = soc0117VWDAO.findByCondCoding(cond);
		return ret;
	}
	
	/**
	 * 查询模型下资产数量（专项预案、应急资源专用）
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNum(String rootEsyscoding){
		return soc0117VWDAO.getEntityNum(rootEsyscoding);
	}
	
	/**
	 * 查询模型下资产数量（新版应急资源专用）
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNumNEW(String rootErcode){
		return soc0117VWDAO.getEntityNumNEW(rootErcode);
	}
	
	/**
	 *  获取可导出一级资产列表
	 *
	 * @param cond 查询条件
	 */
	public List<SOC0117VWInfo> searchEntityForExport(SOC0117VWSearchCond cond) {
		return soc0117VWDAO.searchEntityForExport(cond);
	}
}
