/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.syslog.bl;

import java.util.ArrayList;
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
import com.deliverik.infogovernor.syslog.dto.IGLOG0041DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0041Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0042Form;
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.Mss00002Info;
import com.deliverik.infogovernor.syslog.model.Mss00003Info;
import com.deliverik.infogovernor.syslog.model.Mss00004Info;
import com.deliverik.infogovernor.syslog.model.Mss00004VWInfo;
import com.deliverik.infogovernor.syslog.model.condition.Mss00001SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00002SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00003SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00004SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.entity.Mss00003TB;
import com.deliverik.infogovernor.syslog.model.entity.Mss00004TB;
import com.deliverik.infogovernor.util.CodeDefine;
/**
 * 
 * ����ģ�����CTROLBL
 *
 * @author wangxing
 *
 */
public class IGLOG004BLImpl extends BaseBLImpl implements IGLOG004BL{
	static Log log = LogFactory.getLog(IGLOG004BLImpl.class);
	
	/** �豸taskBL */
	protected Mss00001BL mss00001BL;
	
	/** ����ģ��taskBL */
	protected Mss00004BL mss00004BL;
	
	/** ��������taskBL */
	protected Mss00003BL mss00003BL;
	
	/** �豸�����ϵ��taskBL */
	protected Mss00002BL mss00002BL;
	
	protected CodeDetailBL codeDetailBL;
	
	
	
	/**
	 * �豸taskBLע��
	 * @param mss00001BL
	 */
	public void setMss00001BL(Mss00001BL mss00001BL) {
		this.mss00001BL = mss00001BL;
	}

	/**
	 * ����ģ��taskBLע��
	 */
	public void setMss00004BL(Mss00004BL mss00004BL) {
		this.mss00004BL = mss00004BL;
	}

	/**
	 * ��������taskBL�趨
	 */
	public void setMss00003BL(Mss00003BL mss00003BL) {
		this.mss00003BL = mss00003BL;
	}


	/**
	 * �豸�����ϵ��taskBL�趨
	 */
	public void setMss00002BL(Mss00002BL mss00002BL) {
		this.mss00002BL = mss00002BL;
	}
	
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * ��ѯ����ģ��
	 */
	public IGLOG0041DTO searchMss00004(IGLOG0041DTO dto) {
		log.debug("========����ģ���ѯ��ʼ========");
		
		List<Integer> tempidList = null;
		//ҳ����ʾ����ģ��List
		List<Mss00004VWInfo> mss00004InfoList = new ArrayList<Mss00004VWInfo>();
		dto.setMss00004InfoList(mss00004InfoList);
		//��formȡ��
		IGLOG0041Form form = dto.getIgLog0041Form();
		
		//�����ѯ���������豸ip
		if(StringUtils.isNotEmpty(form.getDeviceip())){
			
			tempidList = new ArrayList<Integer>();
			
			//ͨ��ipȡ���豸
			Mss00001SearchCondImpl deviceCond = new Mss00001SearchCondImpl();
			deviceCond.setDeviceip_like(form.getDeviceip());
			List<Mss00001Info> devices = mss00001BL.searchMss00001(deviceCond);
			
			//�������û������豸���򷵻ؿ�
			if(devices == null || devices.size() == 0) return dto;
			
			for(Mss00001Info device:devices){
				Mss00002SearchCondImpl relationCond = new Mss00002SearchCondImpl();
				relationCond.setDeviceid(String.valueOf(device.getDeviceid()));
				//ͨ���豸�ҵ���ϵ
				List<Mss00002Info> relations = mss00002BL.searchMss00002(relationCond);
				
				for(Mss00002Info relation : relations){
					tempidList.add(relation.getRuletempid());
				}
			}
		}
		
		//��������cond
		Mss00004SearchCondImpl cond = new Mss00004SearchCondImpl();
		
		cond.setTempidList(tempidList);
		cond.setRuletempname(form.getRuletempname());//ģ������
		
		if(StringUtils.isNotEmpty(form.getTempstates())){
			cond.setTempstates(Integer.valueOf(form.getTempstates()));//��ѯ����ģ��״̬
		}
		
		if(StringUtils.isNotEmpty(form.getTypeid())){
			cond.setTypeid(form.getTypeid());
		}
		
		if(StringUtils.isNotEmpty(form.getSummary())){
			cond.setSummary(form.getSummary().trim());
		}
		
		//��������
		int totalCount = this.mss00004BL.getSearchCount(cond);
		//��ҳ��Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		//��ѯ����ģ�壨����ҳ��
		mss00004InfoList = mss00004BL.findByCondVW(cond,pDto.getFromCount(),pDto.getPageDispCount());
		//��������
		dto.setMss00004InfoList(mss00004InfoList);
		pDto.setTotalCount(totalCount);
		
		log.debug("========����ģ���ѯ����========");
		return dto;
	}


	/**
	 * ����ģ��״̬
	 */
	public IGLOG0041DTO changeTempstate(IGLOG0041DTO dto) throws  BLException {
		log.debug("========����ģ��״̬����ʼ========");
		
		//ȡ��form
		IGLOG0041Form form = dto.getIgLog0041Form();
		
		//�����������ģ��ʵ��
		Mss00004Info info = mss00004BL.searchMss00004ByPK(Integer.valueOf(form.getRuletempid()));
		
		Mss00004TB mss00004TB = (Mss00004TB) SerializationUtils.clone(info);
		
		//�ж�ģ��֮ǰ��״̬
		if(0==mss00004TB.getTempstate()){
			mss00004TB.setTempstate(1);
		}else if(1==mss00004TB.getTempstate()){
			mss00004TB.setTempstate(0);
		}
		
		//�޸�ģ��״̬
		mss00004BL.updateMss00004(mss00004TB);
		
		log.debug("========����ģ��״̬�������========");
		return dto;
	}


	/**
	 * ¼���������ģ��
	 * @throws BLException 
	 */
	public IGLOG0041DTO insertMss0004(IGLOG0041DTO dto) throws BLException {
		log.debug("========¼�����ģ�崦��ʼ========");
		
		//formȡ��
		IGLOG0042Form form = dto.getIgLog0042Form();
		
		//ʵ����ģ����
		Mss00004TB mss00004TB = new Mss00004TB();
		
		mss00004TB.setRuletempname(form.getRuletempname());//ģ������
		mss00004TB.setRulecondition(form.getRulecondition());//�������� 0���� ,1�ǻ�
		mss00004TB.setTypeid(form.getTypeid());//�豸����
		mss00004TB.setTempdesc(form.getTempdesc());//����
		mss00004TB.setTempstate(form.getTempstate());//ģ��״̬
		mss00004TB.setCreatetime(IGStringUtils.getCurrentDate());//����ʱ�䣬��ȷ������
		
		//����taskBLִ��¼�����ģ��
		Mss00004Info info= mss00004BL.registMss00004(mss00004TB);
		
		StringBuilder summary = new StringBuilder();
		String[] conditionStr = {"����","����"};

		//��ʼ¼���Զ����������
		if(form.getAlarmconditions()!=null && form.getAlarmconditions().length>0){
			
			CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
		    condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
		    List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			
			for(int i=0;i<form.getAlarmconditions().length;i++){
				
				if(i > 0){//���ǵ�һ������
					if(form.getRulecondition() == 0) summary.append("����");
					else if(form.getRulecondition() == 1) summary.append("����");
				}
				
				//����
				String priority = form.getPriority()[i];
				if(!priority.equals("100")){//����м���
					String level = "";
					for(CodeDetail cbean : cds){
						if(cbean.getCid().equals(priority)){
							level = cbean.getCvalue();
							break;
						}
					}
					summary.append("[����").append(level);
				}else summary.append("[");
				
				//���������ĳ�ַ���
				Integer alarmCondition = Integer.valueOf(form.getAlarmconditions()[i]);
				if(alarmCondition != 0){//���������
					if(!priority.equals("100")) summary.append("��");
					summary.append(conditionStr[alarmCondition-1])
					.append("\""+form.getAlarmmsgs()[i]+"\"]");
				}else summary.append("]");
					
					
				Mss00003TB mss00003TB = new Mss00003TB();
				mss00003TB.setRuletempid(info.getRuletempid());
				mss00003TB.setAlarmcondition(alarmCondition);
				mss00003TB.setAlarmmsg(form.getAlarmmsgs()[i]);
				mss00003TB.setAlarmlevel(Integer.parseInt(priority));
				mss00003TB.setCreatetime(IGStringUtils.getCurrentDate());
				 //����taskBL¼������
				mss00003BL.registMss00003(mss00003TB);
			}
		}
		
		Mss00004TB bean = (Mss00004TB) SerializationUtils.clone(info);
		bean.setSummary(summary.toString());
		mss00004BL.updateMss00004(bean);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "����ģ��") );
		
		log.debug("========¼�����ģ�崦�����========");
		
		return dto;
	}


	/**
	 * �޸Ĺ�������ģ��
	 */
	public IGLOG0041DTO updateMss0004(IGLOG0041DTO dto) throws BLException {
		log.debug("========�޸Ĺ�������ģ�崦��ʼ========");
		//formȡ��
		IGLOG0042Form form = dto.getIgLog0042Form();
		
		//����������ѯ������ģ��
		Mss00004TB mss00004TB = (Mss00004TB) mss00004BL.searchMss00004ByPK(form.getRuletempid());
		
		mss00004TB.setRuletempname(form.getRuletempname());//ģ������
		mss00004TB.setRulecondition(form.getRulecondition());//��������0��1��
		mss00004TB.setTempdesc(form.getTempdesc());//ģ������
		mss00004TB.setTempstate(form.getTempstate());//ģ��״̬
		mss00004TB.setTypeid(form.getTypeid());//�豸����
		
		//��������Line206-229
		Mss00003SearchCondImpl cond = new Mss00003SearchCondImpl();
		
		cond.setRuletempid(form.getRuletempid());
		
		//��ѯ���ù���������б�
		List<Mss00003Info> mss00003InfoList = mss00003BL.searchMss00003(cond);
		
		for(Mss00003Info info :mss00003InfoList){
			//ɾ��ԭ�е�����
			this.mss00003BL.deleteMss00003ByPK(info.getRuleconditionid());
		}
		
		StringBuilder summary = new StringBuilder();
		String[] conditionStr = {"����","����"};
		
		//��ʼ¼���Զ����������
		if(form.getAlarmconditions()!=null && form.getAlarmconditions().length>0){
			
			CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
		    condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
		    List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			
			
			for(int i=0;i<form.getAlarmconditions().length;i++){
				
				if(i > 0){//���ǵ�һ������
					if(form.getRulecondition() == 0) summary.append("����");
					else if(form.getRulecondition() == 1) summary.append("����");
				}
				
				//����
				String priority = form.getPriority()[i];
				if(!priority.equals("100")){//����м���
					String level = "";
					for(CodeDetail cbean : cds){
						if(cbean.getCid().equals(priority)){
							level = cbean.getCvalue();
							break;
						}
					}
					summary.append("[����").append(level);
				}else summary.append("[");
				
				//���������ĳ�ַ���
				Integer alarmCondition = Integer.valueOf(form.getAlarmconditions()[i]);
				if(alarmCondition != 0){//���������
					if(!priority.equals("100")) summary.append("��");
					summary.append(conditionStr[alarmCondition-1])
					.append("\""+form.getAlarmmsgs()[i]+"\"]");
				}else summary.append("]");
				
				Mss00003TB mss00003TB = new Mss00003TB();
				mss00003TB.setRuletempid(form.getRuletempid());
				mss00003TB.setAlarmcondition(Integer.valueOf(form.getAlarmconditions()[i]));
				mss00003TB.setAlarmmsg(form.getAlarmmsgs()[i]);
				mss00003TB.setAlarmlevel(Integer.parseInt(form.getPriority()[i]));
				mss00003TB.setCreatetime(IGStringUtils.getCurrentDate());
				 //����taskBL¼������
				mss00003BL.registMss00003(mss00003TB);
			}
		}
		
		mss00004TB.setSummary(summary.toString());
		this.mss00004BL.updateMss00004(mss00004TB);
		
		//�����ʾ��Ϣ
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "��������ģ��") );
		
		log.debug("========�޸Ĺ�������ģ�崦�����========");
		
		return dto;
	}


	/**
	 * ��õ�ǰ��������
	 */
	public IGLOG0041DTO getMss0004(IGLOG0041DTO dto) throws BLException {
		log.debug("========��������ģ���ʼ������ʼ========");
		//formȡ��
		IGLOG0042Form form = dto.getIgLog0042Form();
		
		//����������ѯ������ģ��
		Mss00004TB mss00004TB = (Mss00004TB) mss00004BL.searchMss00004ByPK(form.getRuletempid());
		
		Mss00003SearchCondImpl cond = new Mss00003SearchCondImpl();
		
		cond.setRuletempid(form.getRuletempid());
		
		//��ѯ���ù���������б�
		List<Mss00003Info> mss00003InfoList = mss00003BL.searchMss00003(cond);
		
		dto.setMss00004TB(mss00004TB);
		
		dto.setMss00003InfoList(mss00003InfoList);
		
		log.debug("========��������ģ���ʼ���������========");
		
		return dto;
	}
	/**
	 * ɾ��ѡ�еĹ���ģ��
	 */
	public void deleteTemp(IGLOG0041DTO dto) throws BLException {
		log.debug("========����ģ��ɾ������ʼ========");
		
		//ȡ��form
		IGLOG0041Form form = dto.getIgLog0041Form();
		
		//����form��deleteId������id����ɾ������ģ��
		for( String ruletempid:form.getDeleteId()){
			Mss00003SearchCondImpl cond = new Mss00003SearchCondImpl();
			cond.setRuletempid(Integer.valueOf(ruletempid));
			List<Mss00003Info> infoList = mss00003BL.searchMss00003(cond);
			for( Mss00003Info info :infoList){
				//ɾ����ģ���µ�����
				mss00003BL.deleteMss00003(info);
			}
			//ɾ������ģ��
			mss00004BL.deleteMss00004ByPK(Integer.valueOf(ruletempid));
			//ɾ���豸�����ϵ���еĹ���ģ���¼
			Mss00002SearchCondImpl searchCond = new Mss00002SearchCondImpl();
			
			searchCond.setRuletempid(Integer.valueOf(ruletempid));
			List<Mss00002Info> minfoList = mss00002BL.searchMss00002(searchCond);
			for( Mss00002Info infos :minfoList){
				//ɾ���豸�µĸù���ģ��
				mss00002BL.deleteMss00002(infos);
			}
		}
		
		log.debug("========����ģ��ɾ���������========");
	}
	
	
	public IGLOG0041DTO getAlarmPriority(IGLOG0041DTO dto) throws Exception {
		String alarmPrioritiesStr = "";
        CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
        List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        dto.setAlarmPrioritiesList(cds);
        for(CodeDetail cd:cds){
        	alarmPrioritiesStr = alarmPrioritiesStr + cd.getCid()+"&"+cd.getCvalue()+",";
        }
        dto.setAlarmPriorities(alarmPrioritiesStr);
        return dto;
	}

	
	/**
	 * ��ȡĳ��ģ����豸�б��ַ�����ʽ��
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0041DTO getDeviceListString(IGLOG0041DTO dto) throws Exception {
		
		StringBuilder builder = new StringBuilder();
		
		IGLOG0042Form form = dto.getIgLog0042Form();
		Integer ruletempid = form.getRuletempid();
		
		Mss00002SearchCondImpl cond = new Mss00002SearchCondImpl();
		cond.setRuletempid(ruletempid);
		List<Mss00002Info> relations = mss00002BL.searchMss00002(cond);
		
		for(Mss00002Info relation : relations){
			Mss00001Info device = mss00001BL.searchMss00001ByPK(relation.getDeviceid());
			builder.append(device.getDevicename());
			if(StringUtils.isEmpty(device.getDeviceip2())){
				builder.append("��IP��"+device.getDeviceip()+"��");
			}else{
				builder.append("��IP1��" + device.getDeviceip() + " IP2��"+device.getDeviceip2()+"��");
			}
			builder.append("\n");
		}
		
		dto.setDeviceListString(builder.toString());
		return dto;
	}
}
