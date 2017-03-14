/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.infogovernor.drm.bl.task.SigninBL;
import com.deliverik.infogovernor.drm.dto.IGDRM11DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1101Form;
import com.deliverik.infogovernor.drm.form.IGDRM1102Form;
import com.deliverik.infogovernor.drm.model.SigninInfo;
import com.deliverik.infogovernor.drm.model.condition.SigninSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.SigninTB;
import com.deliverik.infogovernor.drm.push.MessagePushBL;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.google.gson.Gson;

/**
 * 演练方案BL
 * 
 *
 * 2015年3月13日10:25:43
 */
public class IGDRM11BLImpl extends BaseBLImpl implements IGDRM11BL {
	
	static Log log = LogFactory.getLog(IGDRM11BLImpl.class);
	/**推送消息到Dashboard*/
	private MessagePushBL messagePushBL; 
	/**流程BL*/
	private IG500BL ig500BL; 
	/**资产模型BL*/
	private SigninBL signinBL ;
	
	 public IG500BL getIg500BL() {
		return ig500BL;
	}
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}
	public SigninBL getSigninBL() {
		return signinBL;
	}
	public void setSigninBL(SigninBL signinBL) {
		this.signinBL = signinBL;
	}
	public MessagePushBL getMessagePushBL() {
		return messagePushBL;
	}
	public void setMessagePushBL(MessagePushBL messagePushBL) {
		this.messagePushBL = messagePushBL;
	}
	/**
     * @Description: 签到初始化显示
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM11DTO    
     * @throws
     */
	public IGDRM11DTO initIGDRM1101Action(IGDRM11DTO dto)throws BLException{
		String userid = dto.getUser().getUserid();
		IGDRM1101Form form = dto.getIgdrm1101Form();
//		form.setPrid(null);
		List<Map<String,Object>> signinMap = signinBL.searchSignInList(userid,form.getPrid(),form.getIsDrill());
		dto.setSigninMap(signinMap);
		return dto;
	}
	/**
	 * @Description: 签到操作
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public IGDRM11DTO updateIGDRM1101Action(IGDRM11DTO dto)throws BLException{
		IGDRM1101Form form = dto.getIgdrm1101Form();
		SigninSearchCondImpl sicond = new SigninSearchCondImpl();
		sicond.setSiuserid(dto.getUser().getUserid());
		if(form.getIsDrill()){
			sicond.setDrillprid(form.getSiPrid());
		}else{
			sicond.setEcprid(form.getSiPrid());
		}
		List<SigninInfo> diInfoList = signinBL.searchSignin(sicond);
		for(SigninInfo siInfo : diInfoList){
			SigninTB siTB = (SigninTB) SerializationUtils.clone((Serializable) siInfo);
			if(siInfo.getSignined()!=null&&!"".equals(siInfo.getSignined())&&siInfo.getSignined().intValue()==1){
				
				siTB.setSignined(null);
				siTB.setSitime(null);
			}else{
				Date nowDateTime = new Date();
				String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
				siTB.setSitime(datetime);
				siTB.setSignined(1);
			}
			signinBL.updateSignin(siTB);
		}
		List<Map<String,Object>> signinMap = signinBL.searchSignInList(dto.getUser().getUserid(),form.getSiPrid(),form.getIsDrill());
		dto.setSigninMap(signinMap);
		
		return dto;
	}
	/**
	 * @Description: 代签到初始化显示 
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public IGDRM11DTO initIGDRM1102Action(IGDRM11DTO dto)throws BLException{
		IGDRM1102Form form = dto.getIgdrm1102Form();
//		form.setPrid(null);
		List<Map<String,Object>> signinMap = signinBL.searchSignInList(form.getSiuserid(),form.getPrid(),form.getIsDrill());
		dto.setSigninMap(signinMap);
		return dto;
	}
	/**
	 * @Description: 代签到操作 
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public IGDRM11DTO updateIGDRM1102Action(IGDRM11DTO dto)throws BLException{
		IGDRM1102Form form = dto.getIgdrm1102Form();
		String userid = form.getSiuserid();
		Integer prid = form.getPrid();
		boolean drillflag = false;
		drillflag = form.getIsDrill();
		SigninSearchCondImpl sicond = new SigninSearchCondImpl();
		if(drillflag){
			
			sicond.setDrillprid(prid);
		}else{
			
			sicond.setEcprid(prid);
		}
		sicond.setSiuserid(userid);
		List<SigninInfo> diInfoList = signinBL.searchSignin(sicond);
		for(SigninInfo siInfo : diInfoList){
			SigninTB siTB = (SigninTB) SerializationUtils.clone((Serializable) siInfo);
			if(siInfo.getSignined()!=null&&!"".equals(siInfo.getSignined().toString())&&siInfo.getSignined().intValue()==1){
				siTB.setSitime(null);
				siTB.setSignined(null);
			}else{
				Date nowDateTime = new Date();
				String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
				siTB.setSitime(datetime);
				siTB.setSignined(1);
			}
			signinBL.updateSignin(siTB);
		}
//		Gson gson = new Gson();
//		if(!form.getIsDrill()){
//		messagePushBL.pushMessage(prid.toString(), gson.toJson(IGDRMEmergencyTools.getRestpreDecLayInPlaceList(prid)));
//		}
		return dto;
	}
	/**
	 * @Description: 代签到-可签到流程初始化显示 
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public IGDRM11DTO showSigninableProcess(IGDRM11DTO dto)throws BLException{
		
		
		return dto;
	}
	/**
	 * @Description: 签到-数据推送 
	 * @param dto
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public void pushSigninableMessage(IGDRM11DTO dto)throws BLException{
		IGDRM1101Form form = dto.getIgdrm1101Form();
		Gson gson = new Gson();
		//查询应急指挥的prid
		SigninSearchCondImpl cond = new SigninSearchCondImpl();
		cond.setDrillprid(form.getSiPrid());
		List<SigninInfo> signinList = signinBL.searchSignin(cond);
		//signinList存在，则为演练流程，则取出指挥的prid否则用form中的siprid
		if(signinList!=null && signinList.size()>0){
			if(signinList.get(0).getEcprid()!=null){
				messagePushBL.pushMessage(signinList.get(0).getEcprid().toString(), gson.toJson(IGDRMEmergencyTools.getRestpreDecLayInPlaceList(signinList.get(0).getEcprid())));
			}
		}else{
			messagePushBL.pushMessage(form.getSiPrid().toString(), gson.toJson(IGDRMEmergencyTools.getRestpreDecLayInPlaceList(form.getSiPrid())));
		}
	}
	/**
	 * @Description: 代签到-数据推送 
	 * @param dto
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public void pushSigninHelpMessage(IGDRM11DTO dto)throws BLException{
		IGDRM1102Form form = dto.getIgdrm1102Form();
		Gson gson = new Gson();
		//查询应急指挥的prid
		SigninSearchCondImpl cond = new SigninSearchCondImpl();
		cond.setDrillprid(form.getPrid());
		List<SigninInfo> signinList = signinBL.searchSignin(cond);
		//signinList存在，则为演练流程，则取出指挥的prid否则用form中的siprid
		if(signinList!=null && signinList.size()>0){
			if(signinList.get(0).getEcprid()!=null){
				messagePushBL.pushMessage(signinList.get(0).getEcprid().toString(), gson.toJson(IGDRMEmergencyTools.getRestpreDecLayInPlaceList(signinList.get(0).getEcprid())));
			}
		}else{
			messagePushBL.pushMessage(form.getPrid().toString(), gson.toJson(IGDRMEmergencyTools.getRestpreDecLayInPlaceList(form.getPrid())));
		}
	}

}
