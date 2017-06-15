package com.deliverik.infogovernor.cic.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.infogovernor.cic.bl.task.CompareobjectBL;
import com.deliverik.infogovernor.cic.bl.task.CompareroleBL;
import com.deliverik.infogovernor.cic.dto.IGCIC01DTO;
import com.deliverik.infogovernor.cic.form.IGCIC0101Form;
import com.deliverik.infogovernor.cic.form.IGCIC0102Form;
import com.deliverik.infogovernor.cic.model.CompareobjectInfo;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectSearchCondImpl;
import com.deliverik.infogovernor.cic.model.condition.CompareroleSearchCondImpl;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectTB;
import com.deliverik.infogovernor.cic.model.entity.CompareroleTB;
import com.google.gson.Gson;


/**
 * 对比规则业务逻辑实现
 *
 */
public class IGCIC01BLImpl extends BaseBLImpl implements IGCIC01BL {

	static Log log = LogFactory.getLog(IGCIC01BLImpl.class);

	private CompareroleBL compareroleBL;
	private CompareobjectBL compareobjectBL;
	private SOC0118BL soc0118BL;
	

	public void setCompareobjectBL(CompareobjectBL compareobjectBL) {
		this.compareobjectBL = compareobjectBL;
	}



	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}



	public void setCompareroleBL(CompareroleBL compareroleBL) {
		this.compareroleBL = compareroleBL;
	}



	/**
	 * 查询比较规则
	 */
	public IGCIC01DTO searchCompareRoleList(IGCIC01DTO dto) throws BLException{
		
		IGCIC0101Form from = dto.getIgcic0101Form();
		
		CompareroleSearchCondImpl cond = new CompareroleSearchCondImpl();
		
		BeanUtils.copyProperties(from, cond);
		
		List<CompareroleInfo> crList = compareroleBL.searchComparerole(cond);
		
		dto.setCrList(crList);
		
		return  dto;
	}
	/**
	 * 查询业务系统
	 */
	public IGCIC01DTO getSystemList(IGCIC01DTO dto)throws BLException{
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEid("CM03010001");
		
		List<SOC0118Info> systemList = soc0118BL.searchEntityItem(cond);
		
		dto.setSystemList(systemList);
		
		return dto;
	}
	
	/**
	 * 根据业务系统id和环境类型查询主机
	 * @param systemId
	 * @return
	 */
	public List<Map<String,String>> searchHostList(Integer systemId,String crtype)throws BLException{
		
		List<Map<String,String>> result  = new ArrayList<Map<String,String>>();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setSystemId(systemId);
		//crtype 如果只有三位则只是根据环境进行查询 如果是4位 则表示查询指定环境的集群中
		if(StringUtils.isNotEmpty(crtype)){
			String environmentType = crtype.substring(0, 3);
			cond.setEnvironmentType(environmentType);
			if(crtype.length()>3){
				cond.setClumped(true);
			}
		}else{
			cond.setEnvironmentType("146");
		}
		
		result = soc0118BL.searchHostList(cond);
		
		return result;
	}
	
	/**
	 * 检查对比规则是否存在,如果不存在返回null 否则查询出该规则的信息
	 * @param systemId
	 * @param crtype
	 * @return
	 * @throws BLException
	 */
	public Map<String,Object> checkCompareRole(Integer systemId,String crtype)throws BLException{
		Map<String,Object> result =null;
		
		CompareroleSearchCondImpl cond = new CompareroleSearchCondImpl();
		cond.setCrsystemid(systemId);
		if(crtype==null){
			return null;
		}
		cond.setCrtype(crtype);
		List<CompareroleInfo> crList = compareroleBL.searchComparerole(cond);
		result = new HashMap<String, Object>();
		List<Map<String,String>> sourceHostList = null;
		//根据对比规则获取对比源主机列表
		//如果对比类型大于两位 则是比较集群内的主机 目标主机安装对比类型中的环境选择 
		//否则目标主机位生产环境中的主机
		if(crtype.length()>3){
			sourceHostList= this.searchHostList(systemId, crtype);
		}else{
			sourceHostList= this.searchHostList(systemId, null);
		}
		List<Map<String,String>> targetHostList = this.searchHostList(systemId, crtype);
		result.put("sourceHostList", sourceHostList);
		result.put("targetHostList", targetHostList);
		//根据对比规则获取对比目标主机列表
		if(crList.size()>0){
			CompareroleInfo crInfo = crList.get(0);
			//获取对比对象信息
			CompareobjectSearchCondImpl coCond = new CompareobjectSearchCondImpl();
			coCond.setFkCrid_eq(crInfo.getCrid());
			List<CompareobjectInfo> coList = compareobjectBL.searchCompareobject(coCond);
			result.put("crInfo", crInfo);
			result.put("coList", coList);
		}
		return result;
		
	}
	
	/**
	 * 保存对比规则的方法
	 */
	public IGCIC01DTO insertIgcic0102Action(IGCIC01DTO dto)throws BLException{
		IGCIC0102Form form = dto.getIgcic0102Form();
		CompareroleInfo crInfo = null;
		//如果是新插入
		if(form.getCrid()==null||form.getCrid()==0){
			CompareroleTB crTb = new CompareroleTB();
			crTb.setCrname(form.getCrname());
			crTb.setCrsystemid(form.getCrsystemid());
			crTb.setCrsystemname(form.getCrsystemname());
			crTb.setCrtype(form.getCrtype());
			crTb.setCrversion(0);
			if(form.getCsid()==null||form.getCsid()==0){
				crTb.setFkCsid(1);
			}else{
				crTb.setFkCsid(form.getCsid());
			}
			crInfo = compareroleBL.save(crTb);
			form.setCrid(crInfo.getCrid());
		}
		
		//把与本对比规则关联的对比对象转移到历史表中
		CompareroleTB crTb = (CompareroleTB)compareroleBL.searchCompareroleByPK(form.getCrid());
		crTb.setCrversion(crTb.getCrversion()+1);
		crInfo = crTb;
		
		//保存对比对象
		String[] obNameArr = form.getCompareObjectName();
		List<CompareobjectInfo>  coList = new ArrayList<CompareobjectInfo>();
		for (int i=0;i< obNameArr.length;i++) {
			CompareobjectTB coTb = new CompareobjectTB();
			String[] parArr =  obNameArr[i].split("#");
			coTb.setConame("");
			coTb.setFkCrid(crInfo.getCrid());
			coTb.setCrversion(crInfo.getCrversion());
			coTb.setCosource(Integer.valueOf(parArr[1]));
			coTb.setCotarget(Integer.valueOf(parArr[3]));
			coTb.setSourceIP(parArr[2].split("_")[0]);
			coTb.setTargetIP(parArr[4].split("_")[0]);
			coList.add(coTb);
		}
		compareobjectBL.save(coList);
		
		compareroleBL.updateComparerole(crInfo);
		compareobjectBL.toHistory(crInfo.getCrid());
		
		return dto;
	}
	/**
	 * 查看时 加载对比规则详细信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIC01DTO loadCompareRoleInfo(IGCIC01DTO dto)throws BLException{
		
		IGCIC0102Form form = dto.getIgcic0102Form();
		//获取对比规则信息
		CompareroleInfo crInfo = compareroleBL.searchCompareroleByPK(form.getCrid());
		dto.setCompareRoleInfo(crInfo);
		form.setCrsystemid(crInfo.getCrsystemid());
		form.setCrtype(crInfo.getCrtype());
		//根据对比规则获取对比源主机列表
		List<Map<String,String>> sourceHostList = this.searchHostList(crInfo.getCrsystemid(), null);
		dto.setSourceHostList(sourceHostList);
		//根据对比规则获取对比目标主机列表
		List<Map<String,String>> targetHostList = this.searchHostList(crInfo.getCrsystemid(), crInfo.getCrtype());
		dto.setTargetHostList(targetHostList);
		//获取对比对象信息
		CompareobjectSearchCondImpl cond = new CompareobjectSearchCondImpl();
		cond.setFkCrid_eq(crInfo.getCrid());
		List<CompareobjectInfo> coList = compareobjectBL.searchCompareobject(cond);
		Gson gson = new Gson();
		dto.setCompareObjectListJson(gson.toJson(coList));
		
		return dto;
	}
	
	public IGCIC01DTO delCompareRole(IGCIC01DTO dto)throws BLException{
		IGCIC0101Form form = dto.getIgcic0101Form();
		compareroleBL.deleteCompareroleByPK(form.getCrid());
		compareobjectBL.delByCrid(form.getCrid());
		return dto;
	}

}
