/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0601SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0107DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0109DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0117DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0118DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0601DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;



/**
 * 机房信息业务逻辑实现
 * 
 */
public class SOC0601BLImpl extends BaseBLImpl implements SOC0601BL {

	/** ComputerRoomVW DAO */
	protected SOC0601DAO soc0601DAO;
	
	/** EntityItem DAO */
	protected SOC0118DAO soc0118DAO;
	
	/** SOC0109 DAO */
	protected SOC0109DAO soc0109DAO;
	
	/** ConfigItemDAO */
	protected SOC0107DAO soc0107DAO;
	
	/** Entity DAO */
	protected SOC0117DAO soc0117DAO;

	public void setSoc0601DAO(SOC0601DAO soc0601dao) {
		soc0601DAO = soc0601dao;
	}

	public void setSoc0118DAO(SOC0118DAO soc0118dao) {
		soc0118DAO = soc0118dao;
	}

	public void setSoc0109DAO(SOC0109DAO soc0109dao) {
		soc0109DAO = soc0109dao;
	}

	public void setSoc0107DAO(SOC0107DAO soc0107dao) {
		soc0107DAO = soc0107dao;
	}

	public void setSoc0117DAO(SOC0117DAO soc0117dao) {
		soc0117DAO = soc0117dao;
	}

	/**
	 * 根据机房信息主键取得机房信息
	 * 
	 * @param eiid 机房信息主键
	 * @return 机房信息
	 */
	public SOC0601Info searchSOC0601InfoByKey(String eiid){

		SOC0601Info ret = soc0601DAO.findByPK(Integer.parseInt(eiid));
		return ret;
	}
	
	/**
	 * 根据检索条件取得机房信息结果条数
	 * 
	 * @param cond 机房信息检索条件
	 * @return 机房信息结果条数
	 */
	public int getSOC0601InfoSearchCount(SOC0601SearchCond cond){

		return soc0601DAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得机房信息列表
	 * 
	 * @param cond 机房信息检索条件
	 * @return 机房信息检索结果列表
	 */
	public List<SOC0601Info> searchSOC0601Info(SOC0601SearchCond cond){

		List<SOC0601Info> ret = soc0601DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * 根据检索条件取得机房信息列表
	 * 
	 * @param cond 机房信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 机房信息检索结果列表
	 */
	public List<SOC0601Info> searchSOC0601Info(SOC0601SearchCond cond, int start, int count){
		List<SOC0601Info> ret = soc0601DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 保存机房信息处理
	 * 
	 * @param SOC0601Info 机房信息
	 * @return 保存生成的机房ID
	 * @throws BLException
	 */
	public Integer registSOC0601Info(SOC0601Info SOC0601Info) throws BLException{
		//机房基本信息生成
		SOC0118TB entityItemTB = new SOC0118TB();
		
		//机房模型ID取得
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		
		//登记处理前的机房信息确认
		List<SOC0117Info> entityList = soc0117DAO.findByCond(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","机房模型基本");
		}
		
		SOC0117Info entity = entityList.get(0);
		entityItemTB.setEid(entity.getEid());
		entityItemTB.setEiname(SOC0601Info.getEiname());
		entityItemTB.setEilabel(SOC0601Info.getEilabel());
		entityItemTB.setEidesc(SOC0601Info.getEidesc());
		entityItemTB.setEiversion(1);
		entityItemTB.setEiinsdate(IGStringUtils.getCurrentDate());
		entityItemTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
		entityItemTB.setEsyscoding("999007");
		SOC0118Info entityItem = soc0118DAO.save(entityItemTB);
		//机房横向宽属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_TOTAL,
				SOC0601Info.getX_total(),"机房","机房横向宽",1);
		
		//机房纵向宽属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_TOTAL,
				SOC0601Info.getY_total(),"机房","机房纵向宽",1);
		
		//负责人属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MANANGER,
				SOC0601Info.getManager(),"机房","负责人",1);
		
		//联系电话属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_TEL,
				SOC0601Info.getTel(),"机房","联系电话",1);
		return entityItem.getEiid();
	}
	
	/**
	 * 属性信息添加处理
	 *
	 * @param entityItem EntityItem 资产
	 * @param clabel String 属性编号
	 * @param civalue String 属性值
	 * @param sErrParam0 String 错误信息参数0
	 * @param sErrParam1 String 错误信息参数1 
	 * @param civersion Integer 属性版本
	 * @return
	 */
	protected void insertConfigItem(SOC0118Info entityItem,
			String clabel,String civalue,String sErrParam0,String sErrParam1,
			Integer civersion) throws BLException {
		//1.查询条件生成
		SOC0109SearchCondImpl configCond = new SOC0109SearchCondImpl();
		configCond.setClabel(clabel);
		
		//2.属性查询
		List<SOC0109Info> configList = soc0109DAO.findByCond(configCond, 0, 0);
		
		if ( configList == null || configList.size()==0 ) {
			throw new BLException("IGCO10000.E013",sErrParam0,sErrParam1);
		}
		
		//2.属性内容生成
		SOC0107TB configItemTB = new SOC0107TB();
		
		//资产ID
		configItemTB.setEiid(entityItem.getEiid());
		//资产模型ID
		configItemTB.setEid(entityItem.getEid());
		//资产属性ID
		configItemTB.setCid(configList.get(0).getCid());
		//资产属性值
		configItemTB.setCivalue(civalue);
		
		//资产属性版本
		configItemTB.setCiversion(civersion);
		
		//资产属性更新时间
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		configItemTB.setCiupdtime(datetime);
		
		//3.属性信息登记
		soc0107DAO.save(configItemTB);
		
	}

	/**
	 * 删除机房信息处理
	 * 
	 * @param SOC0601Info 删除的机房信息
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0601Info(SOC0601Info SOC0601Info) throws BLException{
		SOC0118Info ret = checkExistComputerRoom(SOC0601Info.getEiid());
		soc0118DAO.delete(ret);
	}

	/**
	 * 根据机房主键删除机房信息处理
	 * 
	 * @param eiid 删除机房信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0601InfoByKey(Integer eiid) throws BLException{
		SOC0118Info ret = checkExistComputerRoom(eiid);
		soc0118DAO.delete(ret);
	}

	/**
	 * 变更机房信息处理
	 * 
	 * @param SOC0601Info 变更前的机房信息
	 * @throws BLException
	 */
	public void updateSOC0601Info(SOC0601Info SOC0601Info) throws BLException{
		SOC0118Info entityItem = checkExistComputerRoom(SOC0601Info.getEiid());
		
		//机房基本信息生成
		SOC0118TB entityItemTB = (SOC0118TB)SerializationUtils.clone(entityItem);
		int cur_version = entityItem.getEiversion() + 1;
		entityItemTB.setEiname(SOC0601Info.getEiname());
		entityItemTB.setEilabel(SOC0601Info.getEilabel());
		entityItemTB.setEidesc(SOC0601Info.getEidesc());
		entityItemTB.setEiversion(cur_version);
		entityItemTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
		soc0118DAO.save(entityItemTB);
		//机房横向宽配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_TOTAL,
				SOC0601Info.getX_total(),"机房","机房横向宽",cur_version);
		
		//机房纵向宽配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_TOTAL,
				SOC0601Info.getY_total(),"机房","机房纵向宽",cur_version);
		
		//负责人配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MANANGER,
				SOC0601Info.getManager(),"机房","负责人",cur_version);
		
		//联系电话配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_TEL,
				SOC0601Info.getTel(),"机房","联系电话",cur_version);
		
	}
	
	/**
	 * 机房信息存在检查
	 * 
	 * @param eiid 机房ID
	 * @return 机房基本信息
	 * @throws BLException 
	 */
	protected  SOC0118Info checkExistComputerRoom(Integer eiid) throws BLException{
		SOC0118Info info = soc0118DAO.findByPK(eiid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","机房");
		}
		
		return info;
	}

}
