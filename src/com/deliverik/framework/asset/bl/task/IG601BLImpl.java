package com.deliverik.framework.asset.bl.task;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.model.IG601Info;
import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.condition.IG601SearchCond;
import com.deliverik.framework.asset.model.condition.IG225SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG601DAO;
import com.deliverik.framework.asset.model.dao.IG800DAO;
import com.deliverik.framework.asset.model.dao.IG225DAO;
import com.deliverik.framework.asset.model.dao.IG117DAO;
import com.deliverik.framework.asset.model.dao.IG013DAO;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;



/**
 * 机房信息业务逻辑实现
 * 
 */
public class IG601BLImpl extends BaseBLImpl implements IG601BL {

	/** ComputerRoomVW DAO */
	protected IG601DAO ig601DAO;
	
	/** EntityItem DAO */
	protected IG013DAO ig013DAO;
	
	/** Ig225 DAO */
	protected IG225DAO ig225DAO;
	
	/** ConfigItemDAO */
	protected IG800DAO ig800DAO;
	
	/** Entity DAO */
	protected IG117DAO ig117DAO;

	public void setIg601DAO(IG601DAO ig601DAO) {
		this.ig601DAO = ig601DAO;
	}
	
	public void setIg013DAO(IG013DAO ig013DAO) {
		this.ig013DAO = ig013DAO;
	}
	
	public void setIg225DAO(IG225DAO ig225DAO) {
		this.ig225DAO = ig225DAO;
	}
	
	public void setIg800DAO(IG800DAO ig800DAO) {
		this.ig800DAO = ig800DAO;
	}
	
	public void setIg117DAO(IG117DAO ig117DAO) {
		this.ig117DAO = ig117DAO;
	}

	/**
	 * 根据机房信息主键取得机房信息
	 * 
	 * @param eiid 机房信息主键
	 * @return 机房信息
	 */
	public IG601Info searchIG601InfoByKey(Integer eiid){

		IG601Info ret = ig601DAO.findByPK(eiid);
		return ret;
	}
	
	/**
	 * 根据检索条件取得机房信息结果条数
	 * 
	 * @param cond 机房信息检索条件
	 * @return 机房信息结果条数
	 */
	public int getIG601InfoSearchCount(IG601SearchCond cond){

		return ig601DAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得机房信息列表
	 * 
	 * @param cond 机房信息检索条件
	 * @return 机房信息检索结果列表
	 */
	public List<IG601Info> searchIG601Info(IG601SearchCond cond){

		List<IG601Info> ret = ig601DAO.findByCond(cond,0,0);
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
	public List<IG601Info> searchIG601Info(IG601SearchCond cond, int start, int count){
		List<IG601Info> ret = ig601DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 保存机房信息处理
	 * 
	 * @param ig601Info 机房信息
	 * @return 保存生成的机房ID
	 * @throws BLException
	 */
	public Integer registIG601Info(IG601Info ig601Info) throws BLException{
		//机房基本信息生成
		IG013TB entityItemTB = new IG013TB();
		
		//机房模型ID取得
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		
		//登记处理前的机房信息确认
		List<IG117Info> entityList = ig117DAO.findByCond(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","机房模型基本");
		}
		
		IG117Info entity = entityList.get(0);
		entityItemTB.setEid(entity.getEid());
		entityItemTB.setEiname(ig601Info.getEiname());
		entityItemTB.setEilabel(ig601Info.getEilabel());
		entityItemTB.setEidesc(ig601Info.getEidesc());
		entityItemTB.setEiversion(1);
		entityItemTB.setEiinsdate(IGStringUtils.getCurrentDate());
		entityItemTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
		entityItemTB.setEsyscoding("999007");
		IG013Info entityItem = ig013DAO.save(entityItemTB);
		//机房横向宽属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_TOTAL,
				ig601Info.getX_total(),"机房","机房横向宽",1);
		
		//机房纵向宽属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_TOTAL,
				ig601Info.getY_total(),"机房","机房纵向宽",1);
		
		//负责人属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MANANGER,
				ig601Info.getManager(),"机房","负责人",1);
		
		//联系电话属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_TEL,
				ig601Info.getTel(),"机房","联系电话",1);
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
	protected void insertConfigItem(IG013Info entityItem,
			String clabel,String civalue,String sErrParam0,String sErrParam1,
			Integer civersion) throws BLException {
		//1.查询条件生成
		IG225SearchCondImpl configCond = new IG225SearchCondImpl();
		configCond.setClabel(clabel);
		
		//2.属性查询
		List<IG225Info> configList = ig225DAO.findByCond(configCond, 0, 0);
		
		if ( configList == null || configList.size()==0 ) {
			throw new BLException("IGCO10000.E013",sErrParam0,sErrParam1);
		}
		
		//2.属性内容生成
		IG800TB configItemTB = new IG800TB();
		
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
		ig800DAO.save(configItemTB);
		
	}

	/**
	 * 删除机房信息处理
	 * 
	 * @param ig601Info 删除的机房信息
	 * @return
	 * @throws BLException
	 */
	public void deleteIG601Info(IG601Info ig601Info) throws BLException{
		IG013Info ret = checkExistComputerRoom(ig601Info.getEiid());
		ig013DAO.delete(ret);
	}

	/**
	 * 根据机房主键删除机房信息处理
	 * 
	 * @param eiid 删除机房信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG601InfoByKey(Integer eiid) throws BLException{
		IG013Info ret = checkExistComputerRoom(eiid);
		ig013DAO.delete(ret);
	}

	/**
	 * 变更机房信息处理
	 * 
	 * @param ig601Info 变更前的机房信息
	 * @throws BLException
	 */
	public void updateIG601Info(IG601Info ig601Info) throws BLException{
		IG013Info entityItem = checkExistComputerRoom(ig601Info.getEiid());
		
		//机房基本信息生成
		IG013TB entityItemTB = (IG013TB)SerializationUtils.clone(entityItem);
		int cur_version = entityItem.getEiversion() + 1;
		entityItemTB.setEiname(ig601Info.getEiname());
		entityItemTB.setEilabel(ig601Info.getEilabel());
		entityItemTB.setEidesc(ig601Info.getEidesc());
		entityItemTB.setEiversion(cur_version);
		entityItemTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
		ig013DAO.save(entityItemTB);
		//机房横向宽配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_TOTAL,
				ig601Info.getX_total(),"机房","机房横向宽",cur_version);
		
		//机房纵向宽配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_TOTAL,
				ig601Info.getY_total(),"机房","机房纵向宽",cur_version);
		
		//负责人配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MANANGER,
				ig601Info.getManager(),"机房","负责人",cur_version);
		
		//联系电话配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_TEL,
				ig601Info.getTel(),"机房","联系电话",cur_version);
		
	}
	
	/**
	 * 机房信息存在检查
	 * 
	 * @param eiid 机房ID
	 * @return 机房基本信息
	 * @throws BLException 
	 */
	protected  IG013Info checkExistComputerRoom(Integer eiid) throws BLException{
		IG013Info info = ig013DAO.findByPK(eiid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","机房");
		}
		
		return info;
	}



}
