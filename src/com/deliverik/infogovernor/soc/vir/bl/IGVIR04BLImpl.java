/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.soc.vir.IGVIRCONSTANTS;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM02BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM07BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR04DTO;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.VIM07Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM07SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03TB;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM07TB;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟资源回收申请BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR04BLImpl extends BaseBLImpl implements IGVIR04BL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGVIR04BLImpl.class);
	
	/** 项目BL */
	protected VIM02BL vim02BL;
	
	/** VMBL */
	protected VIM03BL vim03BL;
	
	/** 虚机调整信息BL */
	protected VIM07BL vim07BL;

	/**
	 * 项目BL设定
	 * @param vim02BL 项目BL
	 */
	public void setVim02BL(VIM02BL vim02bl) {
		vim02BL = vim02bl;
	}

	/**
	 * VMBL设定
	 * @param vim03BL VMBL
	 */
	public void setVim03BL(VIM03BL vim03bl) {
		vim03BL = vim03bl;
	}

	/**
	 * 虚机调整信息BL设定
	 * @param vim07BL 虚机调整信息BL
	 */
	public void setVim07BL(VIM07BL vim07bl) {
		vim07BL = vim07bl;
	}

	/**
	 * 获取VM信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR04DTO getApplyVMInfAction(IGVIR04DTO dto) throws BLException {
		log.debug("==========获取VM信息操作开始=========");
		//dto参数取得
		User user = dto.getUser();
		Integer pid = dto.getPid();
		Vim03SearchCondImpl cond =  new Vim03SearchCondImpl();
		cond.setStatus(IGVIRCONSTANTS.VM_STATUS_C);
        cond.setPid_eq(pid);
        if (null != user) {
            cond.setUserid_eq(user.getUserid());
        }
        // 查询项目信息
        VIM02Info vim02info = vim02BL.searchVIM02ByPK(pid);
        // 查询虚机信息
        List<VIM03Info> searchVim03 = vim03BL.searchVim03(cond);
        Map<String, Object> infoMap = new HashMap<String, Object>();
        infoMap.put("ProjectInfo", vim02info);
        infoMap.put("VmInfo", searchVim03);
        Gson gson = new Gson();
        String vmInfo_json = gson.toJson(infoMap);
        dto.setJsonResult(vmInfo_json);
        gson = null;
		log.debug("==========获取VM信息操作结束=========");
		return dto;
	}
	
	/**
	 * 保存回收虚机信息操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR04DTO saveRecycleVMInfoAction(IGVIR04DTO dto) throws BLException{
		log.debug("=============保存回收虚机信息操作开始=============");
		//dto参数取得
		User user = dto.getUser();
		Integer[] vmids = dto.getVmids();
		Integer pid = dto.getPid();
		String currentDateTime = IGStringUtils.getCurrentDateTime();
		StringBuffer cids = new StringBuffer();
		if(vmids != null && vmids.length > 0){
			for(Integer vmid : vmids){
				VIM03TB vim03TB = (VIM03TB) vim03BL.searchVim03ByPK(vmid);
				vim03TB.setStatus(IGVIRCONSTANTS.VM_STATUS_E);
				vim03TB.setProgress(null);
				vim03BL.updateVim03(vim03TB);
				VIM07TB vim07TB = new VIM07TB();
				vim07TB.setCtime(currentDateTime);
				vim07TB.setCtype(IGVIRCONSTANTS.RESOURCE_CHANGE_R);
				vim07TB.setVmid(vmid);
				vim07TB.setPid(pid);
				vim07TB.setUserid(user.getUserid());
				VIM07Info vim07Info = vim07BL.registVim07(vim07TB);
				cids.append(vim07Info.getId()).append("#");
			}
		}
		String returnValue = cids.toString();
		dto.setJsonResult(returnValue.substring(0,returnValue.length() - 1));
		log.debug("=============保存回收虚机信息操作结束=============");
		return dto;
	}
	
	/**
	 * 查询待回收虚拟资源
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR04DTO getRecycleVMInfAction(IGVIR04DTO dto) throws BLException {
		log.debug("==========待回收虚拟资源查询操作开始===========");
		//dto参数取得
		Integer pid = dto.getPid();
		Integer prid = dto.getPrid();
		Map<Integer, VIM07Info> map = new HashMap<Integer, VIM07Info>();
		if(prid != null && prid > 0){
			VIM07SearchCondImpl cond = new VIM07SearchCondImpl();
			cond.setPrid(prid);
			cond.setPid(pid);
			List<VIM07Info> list = vim07BL.searchVim07(cond);
			for(VIM07Info info:list){
				map.put(info.getVmid(), info);
			}
		}
		// 查询项目信息
		VIM02Info vim02info = vim02BL.searchVIM02ByPK(pid);
		//查询vm信息
		Vim03SearchCondImpl vim03cond = new Vim03SearchCondImpl();
		vim03cond.setPid_eq(pid);
		vim03cond.setStatus(IGVIRCONSTANTS.VM_STATUS_E);
		List<VIM03Info> vim03List = vim03BL.searchVim03(vim03cond);
		List<VIM03Info> vmInfoList = new ArrayList<VIM03Info>();
		for(VIM03Info info:vim03List){
			if(map.get(info.getId()) != null){
				vmInfoList.add(info);
			}
		}
		Map<String, Object> infoMap = new HashMap<String, Object>();
        infoMap.put("ProjectInfo", vim02info);
        infoMap.put("VmInfo", vmInfoList);
        Gson gson = new Gson();
        String vmInfo_json = gson.toJson(infoMap);
        dto.setJsonResult(vmInfo_json);
        gson = null;
		log.debug("==========待回收虚拟资源查询操作结束===========");
		return dto;
	}
	
	/**
	 * 取得回收进度
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR04DTO getProgressAction(IGVIR04DTO dto) throws BLException {
		log.debug("=============取得回收进度操作开始==============");
		//dto参数取得
		Integer pid = dto.getPid();
		Integer prid = dto.getPrid();
		Map<Integer, VIM07Info> map = new HashMap<Integer, VIM07Info>();
		if(prid != null && prid > 0){
			VIM07SearchCondImpl cond = new VIM07SearchCondImpl();
			cond.setPrid(prid);
			cond.setPid(pid);
			List<VIM07Info> list = vim07BL.searchVim07(cond);
			for(VIM07Info info:list){
				map.put(info.getVmid(), info);
			}
		}
		//查询vm信息
		Vim03SearchCondImpl vim03cond = new Vim03SearchCondImpl();
		vim03cond.setPid_eq(pid);
		vim03cond.setStatus(IGVIRCONSTANTS.VM_STATUS_E);
		List<VIM03Info> vim03List = vim03BL.searchVim03(vim03cond);
		List<VIM03Info> vmInfoList = new ArrayList<VIM03Info>();
		for(VIM03Info info:vim03List){
			if(map.get(info.getId()) != null){
				vmInfoList.add(info);
			}
		}
        Gson gson = new Gson();
        String vmInfo_json = gson.toJson(vmInfoList);
        dto.setJsonResult(vmInfo_json);
        gson = null;
		log.debug("=============取得回收进度操作结束==============");
		return dto;
	}
}

