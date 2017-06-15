/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.prr.dto.IGPRR0702DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0702Form;
import com.google.gson.Gson;

/**
 * @Description: 流程驱动业务逻辑实现
 * @Author
 * @History 2010-9-13 新建 2012-3-20 新增 120320： 创意流程时，可以删除“提交”和“提交人确认”的附件
 *          2012-3-30 新增 120330： 自定义流程根据配置控制主题、描述的显示 2012-4-06 新增
 *          增加对私有变量的值保存到Ig007TB中 2013-01-08 新增 =20130108 按钮添加参与者 2013-02-25 新增
 *          130225 流程机构相关修改
 * @Version V1.0
 */
public class IGPRR07BLImpl extends BaseBLImpl implements IGPRR07BL {
	static Log log = LogFactory.getLog(IGPRR07BLImpl.class);
	protected SOC0118BL soc0118BL;
	protected SOC0117BL soc0117BL;
    protected SOC0109BL soc0109BL;
    protected SOC0107BL soc0107BL;
	/** ConfigItemDAO */
	//protected SOC0107DAO soc0107DAO;
//	
//	public SOC0107DAO getSoc0107DAO() {
//		return soc0107DAO;
//	}
//
//	public void setSoc0107DAO(SOC0107DAO soc0107dao) {
//		soc0107DAO = soc0107dao;
//	}

	public SOC0118BL getSoc0118BL() {
		return soc0118BL;
	}

	public SOC0107BL getSoc0107BL() {
		return soc0107BL;
	}

	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}

	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	
	public SOC0117BL getSoc0117BL() {
		return soc0117BL;
	}

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	public SOC0109BL getSoc0109BL() {
		return soc0109BL;
	}

	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
	}

	public IGPRR0702DTO insertEntityItemAction(IGPRR0702DTO dto)
			throws BLException {
		for (int i = 0; i < Integer.parseInt(dto.getTn()); i++) {
			
	
		IGPRR0702Form form = dto.getIgprr0702Form();
		// 小版本设定（固定设为0）
		form.setEismallversion(0);
		//大版本设定（固定设为0）
		form.setEiversion(0);
		form.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_NEW);
		// 更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		//更新时间
		form.setEiupdtime(datetime);
		// form.setEilabel(eilabel);
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		// 模型名称
		cond.setEname(form.getEname());
		List<SOC0117Info> einfo = this.soc0117BL.searchEntity(cond, 0,0);
		
		// SOC0117TB soc0117tb = (SOC0117TB) SerializationUtils.clone(einfo);
		// 获取模型的Eid 之后一起带入SOC0118Info
		form.setEid(einfo.get(0).getEid());
		// 获取设备编号
		SOC0118SearchCondImpl con = new SOC0118SearchCondImpl();
		if(einfo.get(0).getEsyscoding().startsWith("999001")){
			con.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_KEY
					+ IGStringUtils.getCurrentYear().substring(2));
		}else{
			con.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_SOFTWARE_KEY
					+ IGStringUtils.getCurrentYear().substring(2));
		}
		String eilabel = this.soc0118BL.searchNextEntityItemLable(con);
		form.setEilabel(eilabel);
		//资产模型层次码
		form.setEsyscoding(einfo.get(0).getEsyscoding());		
		SOC0118TB soc0118tb = new SOC0118TB();
		soc0118tb.setEid(form.getEid());
		soc0118tb.setEidesc(form.getEidesc());
		soc0118tb.setEiinsdate(form.getEiinsdate());
		soc0118tb.setEilabel(form.getEilabel());// 设备编号
		// soc0118tb.setEiorgname(form.getEiorgname());所属机构名称
		soc0118tb.setEiorgsyscoding(form.getEiorgsyscoding());
		//soc0118tb.setEiname(form.getEiname());//设备名称
		soc0118tb.setEiname(form.getEilabel());//设备名称
		soc0118tb.setEsyscoding(form.getEsyscoding());
		soc0118tb.setEiuserid(form.getEiuserid());
		soc0118tb.setEiusername(form.getEiusername());
		soc0118tb.setEiupdtime(form.getEiupdtime());
		soc0118tb.setEiversion(form.getEiversion());
		soc0118tb.setEismallversion(form.getEismallversion());
		// 设备信息登录
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(soc0118tb);

		/**
		 * 添加设备属性
		 */
		//资产基本信息查询
	
		SOC0117Info entity = this.soc0117BL.searchEntityByKey(entityItem.getEid());		
		if (entity == null) {
			//资产基本内容信息不存在
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E001");
		}
		// 登记资产信息设定 
		 dto.setEntity(entity);
		//资产配置信息查询件数取得 
		
		List<SOC0117Info> list = this.soc0117BL.getParentNodes(entity.getEid());
		//资产模型属性信息检索条件实现
		SOC0109SearchCondImpl cond2 = new SOC0109SearchCondImpl();
	
		
			
			
		//资产模型属性是否显示标识设定
		cond2.setCseq(1);
	    	//资产配置信息分层次查询
		 List<SOC0107Info> soc0107InfoList = new ArrayList<SOC0107Info>();
				for(SOC0117Info e : list){
					cond2.setEid(e.getEid().toString());
					//根据检索条件取得资产模型属性信息列表(分页查询用)
					List<SOC0109Info> configurationList = this.soc0109BL.searchConfiguration(cond2, 0, 0);									 
					for(SOC0109Info configuration : configurationList) {
						SOC0107TB configItem = new SOC0107TB();//资产属性信息实体						
						if(configuration.getCname().equals("采购日期")){
							configItem.setCivalue(dto.getPvltime());
						}else if(configuration.getCname().equals("设备生命周期")){
							configItem.setCivalue("已入库");
						}else if(configuration.getCname().equals("设备到保日期")){
							configItem.setCivalue(dto.getPvltimets());
						}								   
						//设备ID
						configItem.setEiid(entityItem.getEiid());
						//模型属性ID
						configItem.setCid(configuration.getCid());
						//模型ID
						configItem.setEid(entityItem.getEid());
						//模型层次码
						configItem.setEsyscoding(entityItem.getEsyscoding());
						
						//默认属性：设备状态
						if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(configuration.getClabel())){
							configItem.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_NEW);
						}
//						//大版本号
//						configItem.setCiversion(0);
//						//小版本号
//						configItem.setCismallversion(0);
						
						//更新时间
						configItem.setCiupdtime(entityItem.getEiupdtime());
					    soc0107InfoList.add(configItem);
						
					}				
				
				}
				soc0107BL.saveSOC0107(entityItem.getEiid(), 0, soc0107InfoList);
			
		}
		return dto;
	}

	/**
	 * 资产联动菜单,查询资产属性信息和资产模型属性信息
	 * 
	 * @param dto
	 * @return IGPRR0601DTO
	 */
	public IGPRR0702DTO getJsonString(IGPRR0702DTO dto) {
		if (dto.getSoc0107SearchCond() instanceof SOC0107SearchCondImpl) {
			SOC0107SearchCondImpl soc0107SearchCond = (SOC0107SearchCondImpl) dto.getSoc0107SearchCond();
			if (null != soc0107SearchCond && StringUtils.isNotEmpty(soc0107SearchCond.getEiid())) {
				try {
					SOC0118Info soc118 = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(soc0107SearchCond.getEiid()));
					soc0107SearchCond.setCiversion(soc118.getEiversion().toString());
					soc0107SearchCond.setEid("");
					List<SOC0107Info> soc0107Infos = this.soc0107BL.searchSOC0107(soc0107SearchCond);
					// 获取表单需要信息
					Map<String, String> map = new LinkedHashMap<String, String>();
					for (int j = 0; j < soc0107Infos.size(); j++) {
						SOC0107Info arg1 = soc0107Infos.get(j);
						if (soc0107SearchCond.getEiid().equals(arg1.getEiid().toString())) {
							map.put("CI"+arg1.getCid(), arg1.getCivalue());
						} // end if 
					} // end for 
					Gson gson = new Gson();
					dto.setJson(gson.toJson(map));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (BLException e) {
					e.printStackTrace();
				} // end try/catch block 
			} // end if 
		} // end if 
		return dto;
	}


}
