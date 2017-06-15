package com.deliverik.infogovernor.syslog.bl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.syslog.bl.task.Mss00001BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00002BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00003BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00004BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00011BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0021DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0021Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0022Form;
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.Mss00002Info;
import com.deliverik.infogovernor.syslog.model.Mss00004Info;
import com.deliverik.infogovernor.syslog.model.Mss00011Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00001SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00002SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00004SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.entity.Mss00001TB;
import com.deliverik.infogovernor.syslog.model.entity.Mss00002TB;
import com.deliverik.infogovernor.syslog.model.entity.Mss00003TB;
import com.deliverik.infogovernor.syslog.model.entity.Mss00004TB;
import com.deliverik.infogovernor.util.CodeDefine;

public class IGLOG002BLImpl extends BaseBLImpl implements IGLOG002BL{
	
	static Log log = LogFactory.getLog(IGLOG002BLImpl.class);
	
	/** �澯����taskBL */
	protected Mss00002BL mss00002BL;
	
	/** ��������taskBL */
	protected Mss00003BL mss00003BL;
	
	/** �澯����ģ��taskBL */
	protected Mss00004BL mss00004BL;
	
	protected Mss00001BL mss00001BL;
	
	protected CodeDetailBL codeDetailBL;
	
	protected Mss00011BL mss00011BL;
	
	/**
	 * �澯����taskBLע��
	 */
	public void setMss00002BL(Mss00002BL mss00002BL) {
		this.mss00002BL = mss00002BL;
	}
	
	/**
	 * ��������taskBL�趨
	 */
	public void setMss00003BL(Mss00003BL mss00003BL) {
		this.mss00003BL = mss00003BL;
	}

	/**
	 * �澯����ģ��taskBL�趨
	 */
	public void setMss00004BL(Mss00004BL mss00004BL) {
		this.mss00004BL = mss00004BL;
	}

	
	public void setMss00001BL(Mss00001BL mss00001BL) {
		this.mss00001BL = mss00001BL;
	}
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	public void setMss00011BL(Mss00011BL mss00011BL) {
		this.mss00011BL = mss00011BL;
	}

	/**
	 * ��ѯ�澯�����б�
	 * @throws Exception 
	 */
	public IGLOG0021DTO searchDeviceTemps(IGLOG0021DTO dto) throws Exception {
		log.debug("========��ѯ�豸�����б���ʼ========");
		//��ѯ�б�
		IGLOG0021Form form = dto.getIgLog0021Form();
		int totalCount = mss00011BL.getSearchCount(form);
		if(totalCount == 0){
			log.debug("========��ѯ�豸�������ݲ�����========");
			return dto;
		}
		if(totalCount > dto.getMaxSearchCount()){
			log.debug("========������ѯ����¼��========");
			return dto;
		}
		PagingDTO pDto = dto.getPagingDto();
		List<Mss00011Info> deviceTempList = mss00011BL.searchMss00011(form,pDto.getFromCount(),pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setDeviceTempList(deviceTempList);
		log.debug("========��ѯ�豸�����б������========");
		
		return dto;
	}

	/**
	 * ��ѯ���й���ģ��
	 */
	public IGLOG0021DTO searchAllTemp(IGLOG0021DTO dto) throws BLException {
		log.debug("========��ѯ��������ģ�崦��ʼ========");
		
		//��������ģ��cond
		Mss00004SearchCondImpl cond = new Mss00004SearchCondImpl();
		
		cond.setTempstate(1);//��Ч
		
		//��������ģ���б�
		List<Mss00004Info> info04List = mss00004BL.searchMss00004(cond);
		
		dto.setTempList(info04List);
		
		log.debug("========��ѯ��������ģ�崦�����========");
		
		return dto;
	}
	
	/**
	 * ¼���豸�͸澯����
	 */
	public IGLOG0021DTO insertDeviceAndRules(IGLOG0021DTO dto) throws BLException {
		log.debug("========�澯����¼�봦��ʼ========");
		
		//��¼���豸��Ϣ
		IGLOG0022Form form = dto.getIgLog0022Form();
		Mss00001TB device = new Mss00001TB();
		device.setDeviceip(form.getDeviceip().trim());
		device.setDeviceip2(form.getDeviceip2().trim());
		device.setDevicename(form.getDevicename().trim());
		device.setTypeid(form.getTypeid());
		device.setDevicestate(1);
		Mss00001Info deviceInfo = mss00001BL.registMss00001(device);
		
		//��¼���豸������Ϣ
		String[] ruleTempids = form.getRuletempids();
		if(ruleTempids != null && ruleTempids.length != 0){
			for(String tempid:ruleTempids){
				Mss00002TB mss00002TB = new Mss00002TB();
				mss00002TB.setDeviceid(deviceInfo.getDeviceid());
				mss00002TB.setRuletempid(Integer.parseInt(tempid));
				mss00002TB.setMaxalarmnum(form.getMaxalarmnum()==null?0:form.getMaxalarmnum());//���澯����
				mss00002TB.setMaxalarmtime(form.getMaxalarmtime()==null?0:form.getMaxalarmtime());//���澯���ʱ��
				mss00002TB.setCreatetime(IGStringUtils.getCurrentDate());//����ʱ��
				mss00002BL.registMss00002(mss00002TB);
			
			}
		}
		log.debug("========�澯����¼�봦�����========");
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�澯����") );
		return dto;
	}

	public IGLOG0021DTO updateDeviceAndRules(IGLOG0021DTO dto) throws BLException {
		log.debug("========�澯�����޸Ĵ���ʼ========");
		
		//��¼���豸��Ϣ
		IGLOG0021Form form = dto.getIgLog0021Form();
		
		Mss00001Info info = mss00001BL.searchMss00001ByPK(Integer.valueOf(form.getDeviceid()));
		Mss00001TB device = (Mss00001TB) SerializationUtils.clone(info);
		
		device.setDeviceip(form.getDeviceip().trim());
		device.setDeviceip2(form.getDeviceip2().trim());
		device.setDevicename(form.getDevicename().trim());
		device.setTypeid(form.getTypeid());
		Mss00001Info deviceInfo = mss00001BL.updateMss00001(device);
		
		//��¼���豸������Ϣ
		String[] ruleTempids = form.getRuletempids();
		Mss00002SearchCondImpl cond = new Mss00002SearchCondImpl();
		cond.setDeviceid(String.valueOf(deviceInfo.getDeviceid()));
		
		List<Mss00002Info> allRalitions = mss00002BL.searchMss00002(cond);
		for(Mss00002Info ralition:allRalitions){//¼��ǰ�ȰѸ��豸�����й���ɾ��
			Mss00002TB tb=(Mss00002TB) SerializationUtils.clone(ralition);
			mss00002BL.deleteMss00002(tb);
			
		}
		if(ruleTempids != null && ruleTempids.length != 0){
		for(String tempid:ruleTempids){
			Mss00002TB mss00002TB = new Mss00002TB();
			mss00002TB.setDeviceid(deviceInfo.getDeviceid());
			mss00002TB.setRuletempid(Integer.parseInt(tempid));
				
		    String maxnum = form.getMaxalarmnum();
			if(StringUtils.isEmpty(maxnum)) maxnum = "0";
			mss00002TB.setMaxalarmnum(Integer.parseInt(maxnum));//���澯����
				
			String maxtime = form.getMaxalarmtime();
			if(StringUtils.isEmpty(maxtime)) maxtime = "0";
			mss00002TB.setMaxalarmtime(Integer.parseInt(maxtime));//���澯���ʱ��
			mss00002TB.setCreatetime(IGStringUtils.getCurrentDate());//����ʱ��
			mss00002BL.registMss00002(mss00002TB);
		}
		}
		log.debug("========�澯�����޸Ĵ������========");
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "�澯����") );
		return dto;
	}	
	public IGLOG0021DTO changeTempstate(IGLOG0021DTO dto) throws BLException {
		log.debug("========���Ĺ���״̬����ʼ========");
		
		//ȡ��form
		IGLOG0021Form form = dto.getIgLog0021Form();
		
		//�����������ģ��ʵ��
		Mss00001Info info = mss00001BL.searchMss00001ByPK(Integer.valueOf(form.getDeviceid()));
		Mss00001TB mss00001TB = (Mss00001TB) SerializationUtils.clone(info);
		
		//�ж�ģ��֮ǰ��״̬
		if("0".equals(form.getDevicestate())){
			mss00001TB.setDevicestate(1);
		}else if("1".equals(form.getDevicestate())){
			mss00001TB.setDevicestate(0);
		}
		
		//�޸�ģ��״̬
		mss00001BL.updateMss00001(mss00001TB);
		
		log.debug("========���Ĺ���״̬�������========");
		return dto;
	}

	public IGLOG0021DTO getAlarmRule(IGLOG0021DTO dto) throws BLException {
		log.debug("========��������ģ���ʼ������ʼ========");
		//formȡ��
		IGLOG0021Form form = dto.getIgLog0021Form();
		
		//����������ѯ������ģ��
		Mss00002TB mss00002TB = (Mss00002TB) mss00002BL.searchMss00002ByPK(Integer.parseInt(form.getRuleid()));
		
		dto.setMss00002TB(mss00002TB);
		
		log.debug("========��������ģ���ʼ���������========");
		
		return dto;
	}
	
	public IGLOG0021DTO deleteAlarmRule(IGLOG0021DTO dto) throws BLException {
		log.debug("========ɾ���澯������ʼ========");
		
		IGLOG0021Form form = dto.getIgLog0021Form();
		String[] deleteIds = form.getDeleteId();
		if(deleteIds != null && deleteIds.length != 0){
			for(String id:deleteIds){

				//ɾ���豸�µ����й���
				Mss00002SearchCondImpl cond = new Mss00002SearchCondImpl();
				cond.setDeviceid(String.valueOf(id));
				
				List<Mss00002Info> allRalitions = mss00002BL.searchMss00002(cond);
				for(Mss00002Info ralition:allRalitions){
					mss00002BL.deleteMss00002ByPK(ralition.getRelationid());
				}
				
				//ɾ���豸
				this.mss00001BL.deleteMss00001ByPK(Integer.parseInt(id));
			}
		}
		log.debug("========ɾ���澯����������========");
		return dto;
	}

	public IGLOG0021DTO getDevicesByTypeid(IGLOG0021DTO dto) throws BLException {
		IGLOG0021Form form = dto.getIgLog0021Form();
		String id = form.getTypeid();
		List<Mss00001Info> devices = null;
		Mss00001SearchCondImpl cond = new Mss00001SearchCondImpl();
		cond.setTypeid(id);
		devices = this.mss00001BL.searchMss00001(cond);
		for (int i = 0; i < devices.size(); i++) {
			Mss00001Info device = devices.get(i);
			if(String.valueOf(device.getDeviceid()).equals(form.getDeviceid())){
				devices.remove(i);
				break;
			}
		}
		dto.setDeviceList(devices);
		return dto;
	}
	
	public IGLOG0021DTO getRuleTempsByTypeid(IGLOG0021DTO dto) throws BLException{
		IGLOG0021Form form = dto.getIgLog0021Form();
		String id = form.getTypeid();
		List<Mss00004Info> ruleTempsFromDevice = dto.getTempListFromDevice();
		List<Mss00004Info> buff = null;
		Mss00004SearchCondImpl cond = new Mss00004SearchCondImpl();
		cond.setTypeid(id);
		cond.setTempstates(1);
		buff = this.mss00004BL.searchMss00004(cond);//���ڸ��豸���͵Ĺ����б�
		List<Mss00004Info> ruleTemps = new ArrayList<Mss00004Info>();	
		
		//��������б��е�ĳ�������Ѿ������ڸ��豸�У�������ʾ�������͹����б��У������ظ�
		index:
		for (int i = 0; i < buff.size(); i++) {
			Mss00004Info info = buff.get(i);
			for (int j = 0; j < ruleTempsFromDevice.size(); j++) {
				if(info.getRuletempid().equals(ruleTempsFromDevice.get(j).getRuletempid())) 
					continue index;
			}
			ruleTemps.add(info);
		}
		dto.setTempList(ruleTemps);
		return dto;
 	}
	
	public IGLOG0021DTO getRuleTempsByDeviceid(IGLOG0021DTO dto) throws Exception{
		IGLOG0021Form form = dto.getIgLog0021Form();
		String id = form.getDeviceid();
		List<Mss00004Info> ruleTemps = new ArrayList<Mss00004Info>();
		Mss00002SearchCondImpl ms00002cond = new Mss00002SearchCondImpl();
		ms00002cond.setDeviceid(id);
		List<Mss00002Info> relations = mss00002BL.searchMss00002(ms00002cond);
		for(Mss00002Info info:relations){
			Integer tempid = info.getRuletempid();
			Mss00004Info ruletemp = this.mss00004BL.searchMss00004ByPK(tempid);
			ruleTemps.add(ruletemp);
		}
		dto.setTempListFromDevice(ruleTemps);
		return dto;
	}

	public IGLOG0021DTO getDevice(IGLOG0021DTO dto) throws Exception {
		IGLOG0021Form form = dto.getIgLog0021Form();
		String id = form.getDeviceid();
		Mss00001TB info = (Mss00001TB) this.mss00001BL.searchMss00001ByPK(Integer.parseInt(id));
		dto.setMss00001TB(info);
		return dto;
	}

	public IGLOG0021DTO getRelationEntityByDeviceid(IGLOG0021DTO dto)
			throws Exception {
		IGLOG0021Form form = dto.getIgLog0021Form();
		Mss00002SearchCondImpl ms00002cond = new Mss00002SearchCondImpl();
		ms00002cond.setDeviceid(form.getDeviceid());
		List<Mss00002Info> relations = mss00002BL.searchMss00002(ms00002cond);
		if(relations == null||relations.size() == 0) return dto;
		dto.setMss00002TB((Mss00002TB)relations.get(0));
		return dto;
	}

	public IGLOG0021DTO getDeviceByIp(IGLOG0021DTO dto) throws Exception {
		IGLOG0022Form form = dto.getIgLog0022Form();
		String ip = form.getDeviceip();
		Mss00001SearchCondImpl cond = new Mss00001SearchCondImpl();
		cond.setIp_like(ip);
		List<Mss00001Info> devices = this.mss00001BL.searchMss00001(cond);
		Mss00001Info device = null;
		Mss00001TB deviceBean = null;
		if(devices != null && devices.size() !=0) {
			device = devices.get(0);
			dto.setMss00001TB(device);
		}else{
			deviceBean = new Mss00001TB();
			deviceBean.setDevicename(ip);
			deviceBean.setDeviceip(ip);
			deviceBean.setTypeid("novalue");
			dto.setMss00001TB(deviceBean);
		}
		return dto;
	}

	public IGLOG0021DTO fastConfigAlarmRule(IGLOG0021DTO dto) throws Exception {
		
		IGLOG0022Form form = dto.getIgLog0022Form();
		
		/**
		 * 1:û�и��豸��Ǽ�,�����޸�
		 */
		String deviceid = form.getDeviceid();

		if(StringUtils.isEmpty(deviceid)){
			Mss00001TB device = new Mss00001TB();
			device.setDevicedesc("���豸Ϊ���ٵǼ�");
			device.setDeviceip(form.getDeviceip());
			device.setDeviceip2(form.getDeviceip2());
			device.setDevicename(form.getDevicename());
			device.setDevicestate(1);
			device.setTypeid(form.getTypeid());
			Mss00001Info info = mss00001BL.registMss00001(device);
			deviceid = String.valueOf(info.getDeviceid());
		}else{
			Mss00001Info info = mss00001BL.searchMss00001ByPK(Integer.parseInt(deviceid));
			Mss00001TB device = (Mss00001TB) SerializationUtils.clone(info);
			device.setDeviceip(form.getDeviceip());
			device.setDeviceip2(form.getDeviceip2());
			device.setDevicename(form.getDevicename());
			device.setDevicestate(1);
			device.setTypeid(form.getTypeid());
			mss00001BL.updateMss00001(device);
		}
		
		
		/**
		 * 2:���һ�����򣬴�������
		 */
		Mss00004TB rule = new Mss00004TB();
		rule.setCreatetime(IGStringUtils.getCurrentDate());
		rule.setRulecondition(0);
		rule.setRuletempname(form.getTempName());
		rule.setTempdesc("��ģ��Ϊ��������ģ��");
		rule.setTempstate(1);
		rule.setTypeid(form.getTypeid());
		Mss00004Info info= mss00004BL.registMss00004(rule);
		
		/**
		 * 3:���һ���������������������ڸù����£�
		 */
		Mss00003TB mss00003TB = new Mss00003TB();
		mss00003TB.setRuletempid(info.getRuletempid());
		mss00003TB.setAlarmcondition(Integer.valueOf(form.getAlarmconditions()[0]));
		mss00003TB.setAlarmmsg(form.getAlarmmsgs()[0]);
		int priority;
		if(StringUtils.isEmpty(form.getPriority())) priority = 100;
		else priority = Integer.parseInt(form.getPriority());
		mss00003TB.setAlarmlevel(priority);
		mss00003TB.setCreatetime(IGStringUtils.getCurrentDate());
		mss00003BL.registMss00003(mss00003TB);
		
		/**
		 * 4:Ϊ���򲹳����
		 */
		StringBuilder summary = new StringBuilder();
		String[] conditionStr = {"����","����"};
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
	    condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
	    List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		
		//����
		if(priority != 100){//����м���
			String level = "";
			for(CodeDetail cbean : cds){
				if(Integer.parseInt(cbean.getCid()) == priority){
					level = cbean.getCvalue();
					break;
				}
			}
			summary.append("[����").append(level);
		}else summary.append("[");
		
		//���������ĳ�ַ���
		Integer alarmCondition = Integer.valueOf(form.getAlarmconditions()[0]);
		if(alarmCondition != 0){//���������
			if(priority != 100) summary.append("��");
			summary.append(conditionStr[alarmCondition-1]).append("\""+form.getAlarmmsgs()[0]+"\"]");
		}else summary.append("]");
		
		Mss00004TB bean = (Mss00004TB) SerializationUtils.clone(info);
		bean.setSummary(summary.toString());
		mss00004BL.updateMss00004(bean);
		
		
		/**
		 * 5:��������ڸ��豸�£������豸�����ϵ��
		 */
		Mss00002TB mss00002TB = new Mss00002TB();
		mss00002TB.setDeviceid(Integer.parseInt(deviceid));
		mss00002TB.setRuletempid(info.getRuletempid());
		mss00002TB.setMaxalarmnum(form.getMaxalarmnum()==null?0:form.getMaxalarmnum());//���澯����
		mss00002TB.setMaxalarmtime(form.getMaxalarmtime()==null?0:form.getMaxalarmtime());//���澯���ʱ��
		mss00002TB.setCreatetime(IGStringUtils.getCurrentDate());//����ʱ��
		mss00002BL.registMss00002(mss00002TB);
			
		return dto;
	}

}
