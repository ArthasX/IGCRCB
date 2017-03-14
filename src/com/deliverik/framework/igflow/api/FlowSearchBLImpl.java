/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinition;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.igflow.resultset.ConfigItem;
import com.deliverik.framework.igflow.resultset.ConfigItemInfo;
import com.deliverik.framework.igflow.resultset.EntityItem;
import com.deliverik.framework.igflow.resultset.EntityItemInfo;
import com.deliverik.framework.igflow.resultset.Participant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.ParticipantStatusForm;
import com.deliverik.framework.igflow.resultset.ParticipantStatusFormInfo;
import com.deliverik.framework.igflow.resultset.PrivateProcessForm;
import com.deliverik.framework.igflow.resultset.PrivateProcessFormInfo;
import com.deliverik.framework.igflow.resultset.ProcessFormLog;
import com.deliverik.framework.igflow.resultset.ProcessFormLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntity;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.igflow.resultset.ProcessLog;
import com.deliverik.framework.igflow.resultset.ProcessLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessOverdue;
import com.deliverik.framework.igflow.resultset.ProcessOverdueInfo;
import com.deliverik.framework.igflow.resultset.ProcessRecord;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.igflow.resultset.ProcessStatus;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0107VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG256BL;
import com.deliverik.framework.workflow.prd.bl.task.IG893BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG893SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG898PK;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
 * ���̲�ѯ����API_ҵ�������� drm
 */
public class FlowSearchBLImpl extends BaseBLImpl implements FlowSearchBL {
	
    /** �Զ���������־*/
    private static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
    
    /** ���̶���BL */
    protected WorkFlowDefinitionBL workFlowDefinitionBL; 
    
    /** ���̴���BL */
    protected WorkFlowOperationBL workFlowOperationBL;

	/** �ʲ���ϢBL */
	protected SOC0118BL soc0118BL;

	/** ��������δ������Ϣ��BL */
	protected IG256BL ig256BL;
	
	/** �ʲ�����BL */
	protected SOC0107BL soc0107BL;
	
	/** ���̲����߱���Ȩ��BL */
	protected IG893BL ig893BL;
	/**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * ���̴���BL�趨
	 * @param workFlowOperationBL ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * �ʲ���ϢBL�趨
	 * @param soc0118BL �ʲ���ϢBL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	/**
	 * ����������ϢBLע������
	 * @param ig256BL
	 */
	public void setIg256BL(IG256BL ig256BL) {
		this.ig256BL = ig256BL;
	}

	/**
	 * �ʲ�����BL�趨
	 * 
	 * @param soc0107BL �ʲ�����BL
	 */
	public void setSoc0107BL(SOC0107BL soc0107BL) {
		this.soc0107BL = soc0107BL;
	}
	
	/**
	 * ���̲����߱���Ȩ��BL�趨
	 * 
	 * @param ig893BL ���̲����߱���Ȩ��BL
	 */
	public void setIg893BL(IG893BL ig893BL) {
		this.ig893BL = ig893BL;
	}
	
	/**
	 * ���̵�ǰ״̬�б��ѯ
	 * @param prid ����ID
	 * @return ���̵�ǰ״̬�б�
	 */
	public List<ProcessStatusInfo> searchCurrentStatus(Integer prid) throws BLException {
		List<IG224Info> lst_IG224Info = this.workFlowOperationBL.searchCurrentRecordStatusLog(prid, null);
		List<ProcessStatusInfo> lst_ProcessStatus = null;
		ProcessStatus instance = null;
		if(!lst_IG224Info.isEmpty()) {
			lst_ProcessStatus = new ArrayList<ProcessStatusInfo>();
			for(IG224Info bean : lst_IG224Info) {
				instance = new ProcessStatus();
				instance.setPsdid(bean.getPsdid());//����״̬ID
				instance.setPdid(bean.getPrpdid());//���̶���ID
				instance.setPsdcode(bean.getPrstatus());//����״̬��ʶ
				instance.setPpsdid(bean.getPpsdid()); //�ϼ�״̬ID
				instance.setOpentime(CommonDefineUtils.DATETIME_SECOND_FORMAT.format(bean.getRslOpenTime())); //״̬��ʼʱ��
				instance.setStatusnum(bean.getPsdnum()==null?"":bean.getPsdnum().toString()); //״̬��֧���
				lst_ProcessStatus.add(instance);
			}
		}
		return lst_ProcessStatus;
	}

	/**
	 * �ʲ���Ϣ��ѯ
	 * <BR>
	 * ���Ϊ���°���Ϣ������������Ϣ
	 * @param eiid �ʲ�ID
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	public EntityItemInfo searchEntityItem(Integer eiid) throws BLException {
	    igflowlog.debug(">>>�ʲ���Ϣ��ѯ��ʼ");
		//��ѯ�ʲ�������Ϣ
	    SOC0118Info soc0118Info = this.soc0118BL.searchEntityItemByKey(eiid);
		EntityItem entityItem = new EntityItem(); 
		entityItem.setEiid(eiid);//�ʲ�ID
		entityItem.setEiname(soc0118Info.getEiname());//�ʲ�����
		entityItem.setEilabel(soc0118Info.getEilabel());//�ʲ����
		entityItem.setEiorgsyscoding(soc0118Info.getEiorgsyscoding());//�ʲ��������������
		entityItem.setEsyscoding(soc0118Info.getEsyscoding());//�ʲ�����ģ�Ͳ����
		entityItem.setEiuserid(soc0118Info.getEiuserid());//�ʲ�����������Ϣ
		entityItem.setEiusername(soc0118Info.getEiusername());//�ʲ�����������
		entityItem.setEiversion(soc0118Info.getEiversion());//�ʲ��汾
		entityItem.setEismallversion(soc0118Info.getEismallversion());//�ʲ�С�汾
		//��ѯ���°�������Ϣ
		List<SOC0107Info> lst_SOC0107Info = this.soc0107BL.searchSOC0107HistoryByEiid(eiid, -1, 0, null);
		List<ConfigItemInfo> lst_ConfigItemInfo = new ArrayList<ConfigItemInfo>();
		ConfigItem instance = null;
		for(SOC0107Info bean : lst_SOC0107Info) {
			instance = new ConfigItem();
			instance.setCiid(bean.getCiid());//����ֵID
			instance.setCid(bean.getCid());//���Զ���ID
			instance.setName(bean.getConfiguration().getCname());//��������
			instance.setValue(bean.getCivalue());//����ֵ
			lst_ConfigItemInfo.add(instance);
		}
		entityItem.setConfigItems(lst_ConfigItemInfo);
	    igflowlog.debug(">>>�ʲ���Ϣ��ѯ����");
		return entityItem;
	}
	/**
	 * �ʲ���Ϣ��ѯ(Ӧ����Դר��)
	 * <BR>
	 * ���Ϊ���°���Ϣ������������Ϣ
	 * @param id ���ݿ�ID
	 * @param eiid �ʲ�ID
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	public EntityItemInfo searchEntityItem(Integer id , Integer eiid) throws BLException {
		igflowlog.debug(">>>�ʲ���Ϣ��ѯ��ʼ");
		SOC0118VWBL soc0118VWBL = (SOC0118VWBL) WebApplicationSupport.getBean("soc0118VWBL");
		SOC0107VWBL soc0107VWBL = (SOC0107VWBL) WebApplicationSupport.getBean("soc0107VWBL");
		//��ѯ�ʲ�������Ϣ
		SOC0118VWInfo soc0118VW = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(id, eiid));
		EntityItem entityItem = new EntityItem(); 
		entityItem.setEiid(eiid);//�ʲ�ID
		entityItem.setEiname(soc0118VW.getEiname());//�ʲ�����
		entityItem.setEilabel(soc0118VW.getEilabel());//�ʲ����
		entityItem.setEiorgsyscoding(soc0118VW.getEiorgsyscoding());//�ʲ��������������
		entityItem.setEsyscoding(soc0118VW.getEsyscoding());//�ʲ�����ģ�Ͳ����
		entityItem.setEiuserid(soc0118VW.getEiuserid());//�ʲ�����������Ϣ
		entityItem.setEiusername(soc0118VW.getEiusername());//�ʲ�����������
		entityItem.setEiversion(soc0118VW.getEiversion()!=null?Integer.parseInt(soc0118VW.getEiversion()):null);//�ʲ��汾
		entityItem.setEismallversion(soc0118VW.getEismallversion());//�ʲ�С�汾
		//��ѯ���°�������Ϣ
		List<SOC0107VWInfo> lst_SOC0107Info = soc0107VWBL.searchSOC0107VWHistoryByEiid(id ,eiid, -1, 0, null);
		List<ConfigItemInfo> lst_ConfigItemInfo = new ArrayList<ConfigItemInfo>();
		ConfigItem instance = null;
		for(SOC0107VWInfo bean : lst_SOC0107Info) {
			instance = new ConfigItem();
			instance.setCiid(bean.getCiid());//����ֵID
			instance.setCid(bean.getCid());//���Զ���ID
			instance.setName(bean.getConfiguration().getCname());//��������
			instance.setValue(bean.getCivalue());//����ֵ
			lst_ConfigItemInfo.add(instance);
		}
		entityItem.setConfigItems(lst_ConfigItemInfo);
		igflowlog.debug(">>>�ʲ���Ϣ��ѯ����");
		return entityItem;
	}

	/**
	 * �ʲ���Ϣ��ѯ
	 * <BR>
	 * ģ�Ͳ�������ǰ��һ��ģ��ƥ��
	 * <BR>
	 * ���Ϊ���°���Ϣ��������������Ϣ
	 * @param esyscoding ģ�Ͳ����
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	public List<EntityItemInfo> searchEntityItem(String esyscoding) throws BLException {
	    igflowlog.debug(">>>�ʲ���Ϣ��ѯ��ʼ");
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		cond.setEsyscoding(esyscoding);
		List<SOC0124Info> lst_SOC0124Info = this.soc0118BL.searchEntityItemVW(cond);
		List<EntityItemInfo> lst_EntityItemInfo = new ArrayList<EntityItemInfo>();
		EntityItem entityItem = null;
		for(SOC0124Info bean : lst_SOC0124Info) {
			entityItem = new EntityItem();
			entityItem.setEiid(bean.getEiid());//�ʲ�ID
			entityItem.setEiname(bean.getEiname());//�ʲ�����
			entityItem.setEilabel(bean.getEilabel());//�ʲ����
			entityItem.setEiorgsyscoding(bean.getEiorgsyscoding());//�ʲ��������������
			entityItem.setEsyscoding(bean.getEsyscoding());//�ʲ�����ģ�Ͳ����
			entityItem.setEiuserid(bean.getEiuserid());//�ʲ�����������Ϣ
			entityItem.setEiusername(bean.getEiusername());//�ʲ�����������
			entityItem.setEiversion(bean.getEiversion());//�ʲ��汾
			entityItem.setEismallversion(bean.getEismallversion());//�ʲ�С�汾
			lst_EntityItemInfo.add(entityItem);
		}
	    igflowlog.debug(">>>�ʲ���Ϣ��ѯ����");
		return lst_EntityItemInfo;
	}

	/**
	 * �ʲ���Ϣ��ѯ
	 * <BR>
	 * ���Լ��Ͽ�Ϊ�գ�����key���������ƣ�value������ֵ
	 * <BR>
	 * Ĭ�ϲ�ѯ��������=key������ֵ=value�ļ�¼
	 * <BR>
	 * ��value=nullʱ��ѯ��������=key�ļ�¼
	 * <BR>
	 * ��value=""ʱ��ѯ��������=key������ֵ=""�ļ�¼
	 * @param value ���Լ���
	 * @return �ʲ�ID�б�
	 * @throws BLException 
	 */
	public List<Integer> searchEntityItem(Map<String, String> value) throws BLException {
		return this.soc0107BL.searchEiByCname(value);
	}

	/**
	 * �ʲ�����ֵ��ѯ
	 * <BR>
	 * ���������Ʋ�����ʱ�׳��쳣
	 * @param eiid �ʲ�ID
	 * @param name �ʲ���������
	 * @return �ʲ�����ֵ
	 * @throws BLException 
	 */
	public String searchEntityItemConfigValue(Integer eiid, String name) throws BLException {
	    igflowlog.debug(">>>�ʲ�����ֵ��ѯ��ʼ");
		if(eiid == null || eiid <= 0) {
			throw new BLException("IGCO10000.E004","�ʲ�ID");
		}
		if(StringUtils.isEmpty(name)) {
			throw new BLException("IGCO10000.E004","�ʲ���������");
		}
		List<SOC0107Info> lst_ConfigItem = soc0107BL.searchSOC0107HistoryByEiid(eiid, -1, null, name);
		if(lst_ConfigItem.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "���ԣ�" + name + "��");
		} else if(lst_ConfigItem.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "���ԣ�" + name + "��");
		} else {
			String value = lst_ConfigItem.get(0).getCivalue(); 
			igflowlog.debug(">>>�ʲ�����ֵ��ѯ�����������ʲ�����ֵ��"+value);
			return value == null ? "" : value;
		}
	}
	
	/**
	 * ���ݹ�����ʶ��ѯ��ǰ��󹤵���
	 * <BR>
	 * ������ʶ����ǰ��һ��ģ��ƥ��
	 * @param serialnum ������ʶ
	 * @return ��󹤵���
	 */
	public String searchMaxSerialnum(String serialnum) throws BLException {
	    igflowlog.debug(">>>������󹤵��Ų�ѯ��ʼ");
		if(StringUtils.isEmpty(serialnum)) {
			throw new BLException("IGCO10000.E004","�����ű�ʶ");
		}
		String strSerialnum = workFlowOperationBL.searchMaxPrserialnum(serialnum);
		igflowlog.debug(">>>������󹤵��Ų�ѯ������������󹤵��ţ�" + strSerialnum);
		return strSerialnum;
	}
	
	/**
	 * ������״̬����Ϣ
	 * @param pdid ���̶���ID
	 * @param statusname ״̬����
	 * @param roleid �����ɫID
	 * @return ������״̬����Ϣ
	 */
	public List<ParticipantStatusFormInfo> searchParticipantStatusFormInfo(String pdid, String statusname, Integer roleid)
			throws BLException {
	    igflowlog.debug(">>>������״̬����Ϣ��ѯ��ʼ");
		if(StringUtils.isEmpty(pdid)) {
			throw new BLException("IGCO10000.E004","���̶���ID");
		}
		if(StringUtils.isEmpty(statusname)) {
			throw new BLException("IGCO10000.E004","״̬����");
		}
		if(roleid == null || roleid <=0) {
			throw new BLException("IGCO10000.E004","�����ɫID");
		}
		IG333SearchCondImpl cond_IG333 = new IG333SearchCondImpl();
		cond_IG333.setPdid(pdid);
		cond_IG333.setPsdname(statusname);
		List<IG333Info> lst_IG333Info = workFlowDefinitionBL.searchProcessStatusDef(cond_IG333);
		IG893SearchCondImpl cond_IG893 = new IG893SearchCondImpl();
		cond_IG893.setPsdid(lst_IG333Info.get(0).getPsdid());
		cond_IG893.setRoleid(roleid);
		List<IG893Info> lst_IG893Info = ig893BL.searchIG893Info(cond_IG893);
		List<ParticipantStatusFormInfo> lst_ParticipantStatusFormInfo = new ArrayList<ParticipantStatusFormInfo>();
		ParticipantStatusForm form = null;
		for(IG893Info info : lst_IG893Info) {
			form = new ParticipantStatusForm();
			form.setPidid(info.getPidid());
			form.setPidlabel(info.getPidlabel());
			form.setPidaccess(info.getPidaccess());
			lst_ParticipantStatusFormInfo.add(form);
		}
	    igflowlog.debug(">>>������״̬����Ϣ����");
		return lst_ParticipantStatusFormInfo;
	}
	
	/**
	 * ����˽�б�ֵ��ѯ
	 * <BR>
	 * �������Ʋ�����ʱ�׳��쳣
	 * @param prid ����ID
	 * @param pidname ������
	 * @return ��ֵ�б�
	 * @throws BLException 
	 */
	public List<PrivateProcessFormInfo> searchPrivateProcessInfo(Integer prid, String pidname) throws BLException {
	    igflowlog.debug(">>>����˽�б�ֵ��ѯ��ʼ");
		if(prid == 0 || prid <= 0) {
			throw new BLException("IGCO10000.E004","���̶���ID");
		}
		if(StringUtils.isEmpty(pidname)) {
			throw new BLException("IGCO10000.E004","������");
		}
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(prid);//����ID
		cond.setPivarlabel(pidname);//������
		List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
		if(lst_ProcessInfo.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "����" + pidname + "��");
		} else if(lst_ProcessInfo.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "����" + pidname + "��");
		} else {
			//IG899SearchCondImpl ncond = new IG899SearchCondImpl();
			//ncond.setPiid(lst_ProcessInfo.get(0).getPiid());
			//��ȡ˽�б�
		//	List<IG899Info> lst_ProcessPrivateInfo = workFlowOperationBL.searchProcessPrivateInfo(ncond);//Ӧ���ϰ棿����
			//��ȡ˽�б�
			List<IG899TB> lst_ProcessPrivateInfo = lst_ProcessInfo.get(0).getProcessPrivateInfofList();
			//˽�б�����
			List<PrivateProcessFormInfo> lst_PrivateProcessForm = null;
			//˽�б�ʵ��
			PrivateProcessForm instance = null;
			if(lst_ProcessPrivateInfo != null && !lst_ProcessPrivateInfo.isEmpty()) {
				lst_PrivateProcessForm = new ArrayList<PrivateProcessFormInfo>();
				//��伯��
				for(IG899TB bean : lst_ProcessPrivateInfo) {
					instance = new PrivateProcessForm();
					instance.setRoleid(bean.getRoleid());//��ɫID
					instance.setUserid(bean.getUserid());//�û�ID
					instance.setValue(bean.getPpivalue());//��ֵ
					instance.setComment(bean.getPpicommect());
					lst_PrivateProcessForm.add(instance);
				}
			}
			
			if (igflowlog.isDebugEnabled()) {
	            StringBuffer sbPpivalue = new StringBuffer();
	            for(IG899TB bean : lst_ProcessPrivateInfo) {
	                if (sbPpivalue.toString().equals("")) {
	                    sbPpivalue.append(bean.getPpivalue());
	                } else {
	                    sbPpivalue.append(",").append(bean.getPpivalue());
	                }
	            }
	            igflowlog.debug(">>>����˽�б�ֵ��" + sbPpivalue.toString());
	        }
			igflowlog.debug(">>>����˽�б�ֵ��ѯ����");
			return lst_PrivateProcessForm;
		}
	}
	
	/**
	 * ��������ʲ���ѯ
	 * <BR>
	 * ��pinameΪ��ʱ���ظ�����ID���е�����ʲ�������ѯ�޽��ʱ����null
	 * @param prid ����ID
	 * @param pidname �����ƣ���Ϊ�գ�
	 * @return ����ʲ��б�
	 * @throws BLException 
	 */
	public List<ProcessInfoEntityInfo> searchProcessEntityItem(Integer prid, String pidname) throws BLException {
	    igflowlog.debug(">>>��������ʲ���ѯ��ʼ");
	    if(prid == 0 || prid <= 0) {
			throw new BLException("IGCO10000.E004","���̶���ID");
		}
		Integer piid = null;
		//��ѯ���̱�����
		if(StringUtils.isNotEmpty(pidname)){
			IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
			cond599.setPrid(prid);
			cond599.setPivarname(pidname);
			List<IG599Info> piList = workFlowOperationBL.searchProcessInfoByCond(cond599);
			if(piList != null && piList.size() > 0){
				piid = piList.get(0).getPiid();
			}
		}
		//��ѯ���̵�����ʲ�
		IG731SearchCondImpl cond731 = new IG731SearchCondImpl();
		cond731.setPrid(prid);
		cond731.setPiid(piid);
		List<IG731Info> lst_IG731 = workFlowOperationBL.searchProcessInfoEntityByCond(cond731);
		
		//��������ʲ�ID����
		List<ProcessInfoEntityInfo> list = null;
		//�������ʲ�ID����
		if(lst_IG731 != null && !lst_IG731.isEmpty()) {
			list = new ArrayList<ProcessInfoEntityInfo>();
			for(IG731Info ig731 : lst_IG731) {
				ProcessInfoEntity entity = new ProcessInfoEntity();
				entity.setEiid(ig731.getEiid());
				entity.setEiversion(ig731.getEiversion());
				entity.setFingerPrint(ig731.getFingerPrint());
//				entity.setEiname(ig731.getEntityItemVWTB().getEiname());
				entity.setEiname(ig731.getEntityItemVWTB() == null?"":ig731.getEntityItemVWTB().getEiname());
				list.add(entity);
			}
		}
		
		if (igflowlog.isDebugEnabled()) {
            StringBuffer sbEiid = new StringBuffer();
            for(IG731Info ig731 : lst_IG731) {
                if (sbEiid.toString().equals("")) {
                    sbEiid.append(ig731.getEiid());
                } else {
                    sbEiid.append(",").append(ig731.getEiid());
                }
            }
            igflowlog.debug(">>>��������ʲ���ѯ��������������ʲ�ID��" + sbEiid.toString());
        }
		return list;
	}
	
	/**
	 * ���̻�����Ϣ��ѯ
	 * @param prid ����ID����Ϊ�գ�
	 * @param serialnum ���̹����ţ���Ϊ�գ�
	 * @return ���̻�����Ϣ
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(Integer prid, String serialnum) throws BLException {
	    igflowlog.debug(">>>�������̻�����Ϣ��ѯ��ʼ");
	    IG500SearchCondImpl cond = new IG500SearchCondImpl();
	    cond.setPrid(prid);
	    cond.setPrserialnum(serialnum);
	    List<IG500Info> IG500InfoList = workFlowOperationBL.searchProcessRecord(cond);
	    List<ProcessRecordInfo> retProcessRecordInfoList = new ArrayList<ProcessRecordInfo>();
	    for (IG500Info ig500info : IG500InfoList) {
	        ProcessRecord processRecord = new ProcessRecord();
	        processRecord.setPrclosetime(ig500info.getPrclosetime());
	        processRecord.setPrid(ig500info.getPrid());
	        processRecord.setPrpdname(ig500info.getPrpdname());
	        processRecord.setPrdesc(ig500info.getPrdesc());
	        processRecord.setPrtitle(ig500info.getPrtitle());
	        processRecord.setPrstatus(ig500info.getPrstatus());
	        processRecord.setPropentime(ig500info.getPropentime());
	        processRecord.setPrserialnum(ig500info.getPrserialnum());
	        processRecord.setPrPriority(ig500info.getPrPriority());
	        processRecord.setPrpdid(ig500info.getPrpdid());
	        processRecord.setPrtype(ig500info.getPrtype());
	        processRecord.setPrroleid(ig500info.getPrroleid());
	        processRecord.setPruserid(ig500info.getPruserid());
	        retProcessRecordInfoList.add(processRecord);
	    }
	    igflowlog.debug(">>>�������̻�����Ϣ��ѯ�������������̻�����Ϣ�б�������"+retProcessRecordInfoList.size());
	    return retProcessRecordInfoList;
	}
	
	/**
	 * ���̻�����Ϣ��ѯ
	 * @param status ����״̬��ʶ
	 * @return ���̻�����Ϣ�б�
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(String status) throws BLException {
		igflowlog.debug(">>>�������̻�����Ϣ��ѯ��ʼ");
	    if(StringUtils.isEmpty(status)) {
			throw new BLException("IGCO10000.E004","����״̬");
		}
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrstatus(status);
		List<IG500Info> IG500InfoList = workFlowOperationBL.searchProcessRecord(cond);
		List<ProcessRecordInfo> retProcessRecordInfoList = new ArrayList<ProcessRecordInfo>();
		for (IG500Info ig500info : IG500InfoList) {
			ProcessRecord processRecord = new ProcessRecord();
			processRecord.setPrclosetime(ig500info.getPrclosetime());
	        processRecord.setPrid(ig500info.getPrid());
	        processRecord.setPrpdname(ig500info.getPrpdname());
			processRecord.setPrdesc(ig500info.getPrdesc());
			processRecord.setPrtitle(ig500info.getPrtitle());
			processRecord.setPrstatus(ig500info.getPrstatus());
			processRecord.setPropentime(ig500info.getPropentime());
			processRecord.setPrserialnum(ig500info.getPrserialnum());
			processRecord.setPrPriority(ig500info.getPrPriority());
	        processRecord.setPrpdid(ig500info.getPrpdid());
	        processRecord.setPrtype(ig500info.getPrtype());
	        processRecord.setPrroleid(ig500info.getPrroleid());
	        processRecord.setPruserid(ig500info.getPruserid());
			retProcessRecordInfoList.add(processRecord);
		}
		igflowlog.debug(">>>�������̻�����Ϣ��ѯ�������������̻�����Ϣ�б�������"+retProcessRecordInfoList.size());
		return retProcessRecordInfoList;
	}

	/**
	 * ���̻�����Ϣ��ѯ
	 * @param startTime ���̷���ʱ�俪ʼ����Ϊ�գ�
	 * @param endTime ���̷���ʱ���������Ϊ�գ�
	 * @return ���̻�����Ϣ�б�
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(String startTime, String endTime) throws BLException {
		igflowlog.debug(">>>�������̻�����Ϣ��ѯ��ʼ");
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPropentime(startTime);
		cond.setPrclosetime(endTime);
		List<IG500Info> IG500InfoList = workFlowOperationBL.searchProcessRecord(cond);
		List<ProcessRecordInfo> retProcessRecordInfoList = new ArrayList<ProcessRecordInfo>();
		for (IG500Info ig500info : IG500InfoList) {
			ProcessRecord processRecord = new ProcessRecord();
			processRecord.setPrclosetime(ig500info.getPrclosetime());
	        processRecord.setPrid(ig500info.getPrid());
	        processRecord.setPrpdname(ig500info.getPrpdname());
			processRecord.setPrdesc(ig500info.getPrdesc());
			processRecord.setPrtitle(ig500info.getPrtitle());
			processRecord.setPrstatus(ig500info.getPrstatus());
			processRecord.setPropentime(ig500info.getPropentime());
			processRecord.setPrserialnum(ig500info.getPrserialnum());
	        processRecord.setPrpdid(ig500info.getPrpdid());
	        processRecord.setPrtype(ig500info.getPrtype());
	        processRecord.setPrroleid(ig500info.getPrroleid());
	        processRecord.setPruserid(ig500info.getPruserid());
			retProcessRecordInfoList.add(processRecord);
		}
		igflowlog.debug(">>>�������̻�����Ϣ��ѯ�������������̻�����Ϣ�б�������"+retProcessRecordInfoList.size());
		return retProcessRecordInfoList;
	}
	
	/**
	 * ���̻�����Ϣ��ѯ
	 * @param pdid ���̶���ID
	 * @param beginTime ���̷���ʱ�俪ʼ����Ϊ�գ�
	 * @param endTime ���̷���ʱ���������Ϊ�գ�
	 * @return ���̻�����Ϣ�б�
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(String pdid, String beginTime, String endTime) throws BLException {
	    igflowlog.debug(">>>�������̻�����Ϣ��ѯ��ʼ");
	    if(StringUtils.isEmpty(pdid)) {
			throw new BLException("IGCO10000.E004","���̶���ID");
		}
	    List<IG500Info> IG500InfoList;
	    IG500SearchCondImpl cond = new IG500SearchCondImpl();
        cond.setPrpdid(pdid);
        cond.setPropentime(beginTime);
        cond.setPrclosetime(endTime);
        IG500InfoList = workFlowOperationBL.searchProcessRecord(cond);
	    List<ProcessRecordInfo> retProcessRecordInfoList = new ArrayList<ProcessRecordInfo>();
	    for (IG500Info ig500info : IG500InfoList) {
	        ProcessRecord processRecord = new ProcessRecord();
	        processRecord.setPrclosetime(ig500info.getPrclosetime());
	        processRecord.setPrid(ig500info.getPrid());
	        processRecord.setPrpdname(ig500info.getPrpdname());
	        processRecord.setPrdesc(ig500info.getPrdesc());
	        processRecord.setPrtitle(ig500info.getPrtitle());
	        processRecord.setPrstatus(ig500info.getPrstatus());
	        processRecord.setPropentime(ig500info.getPropentime());
	        processRecord.setPrserialnum(ig500info.getPrserialnum());
	        processRecord.setPrpdid(ig500info.getPrpdid());
	        processRecord.setPrtype(ig500info.getPrtype());
	        processRecord.setPrroleid(ig500info.getPrroleid());
	        processRecord.setPruserid(ig500info.getPruserid());
	        retProcessRecordInfoList.add(processRecord);
	    }
	    igflowlog.debug(">>>�������̻�����Ϣ��ѯ�������������̻�����Ϣ�б�������"+retProcessRecordInfoList.size());
	    return retProcessRecordInfoList;
	}
	
	/**
	 * ���̱�������Ϣ��ѯ
	 * <BR>
	 * �������Ʋ�����ʱ�׳��쳣
	 * @param pdid ���̶���ID
	 * @param name ������
	 * @return ��������Ϣ
	 * @throws BLException
	 */
	public String searchProcessInfoDefDescByName(String pdid, String name) throws BLException {
	    igflowlog.debug(">>>���̱�������Ϣ��ѯ��ʼ");
	    if(StringUtils.isEmpty(pdid)) {
			throw new BLException("IGCO10000.E004","���̶���ID");
		}
		if(StringUtils.isEmpty(name)) {
			throw new BLException("IGCO10000.E004","������");
		}
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);//����ID
		cond.setPidname(name);//������
		List<IG007Info> lst_ProcessInfoDef = workFlowDefinitionBL.searchProcessInfoDef(cond);
		
		if(lst_ProcessInfoDef.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "����" + name + "��");
		} else if(lst_ProcessInfoDef.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "����" + name + "��");
		} else {
			String value = lst_ProcessInfoDef.get(0).getPiddesc(); 
			igflowlog.debug(">>>���̱�������Ϣ��ѯ����������ֵ��" + value);
			return value == null ? "" : value;
		}
	}

	/**
	 * ���̴����¼��ѯ
	 * @param prid ����ID
	 * @param psdid ����״̬ID
	 * @param psdnum ����״̬��֧���
	 * @param userid �����û�ID
	 * @return ���̴����¼�б�
	 * @throws BLException
	 */
	public List<ProcessLogInfo> searchProcesslog(Integer prid, String psdid, Integer psdnum, String userid)
			throws BLException {
		IG036SearchCondImpl cond = new IG036SearchCondImpl();
		cond.setPrid(prid);
		cond.setRlType(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);//������־
		cond.setPsdid(psdid);
		cond.setPsdnum(psdnum);
		cond.setRluserid(userid);
		List<IG036Info> lst_IG036Info = workFlowOperationBL.searchUserRoleRecondLog(cond);
		List<ProcessLogInfo> lst_ProcessLogInfo = null;
		ProcessLog instance = null;
		int size = lst_IG036Info.size();
		if(size > 0) {
			lst_ProcessLogInfo = new ArrayList<ProcessLogInfo>();
			for(int i=0;i<size;i++) {
				IG036Info bean = lst_IG036Info.get(i);
				instance = new ProcessLog();
				instance.setPlid(bean.getRlid());//��־ID
				instance.setPsdid(bean.getPsdid());//����״̬ID
				instance.setRecord(bean.getRlcomment());//�����¼
				instance.setRoleid(bean.getRoleid());//�����ɫID
				instance.setRolename(bean.getRlrolename());//�����ɫ����
				instance.setUserid(bean.getRluserid());//������ID
				instance.setUsername(bean.getRlusername()); //����������
				instance.setCommittime(bean.getRltime()); //�ύʱ��
				lst_ProcessLogInfo.add(instance);
			}
		}
		return lst_ProcessLogInfo;
	}
	
	/**
	 * ���̱���־��ѯ
	 * @param prid ����ID
	 * @param psdid ����״̬ID
	 * @param psdnum ����״̬��֧���
	 * @param userid �����û�ID
	 * @return ���̱���־�б�
	 */
	public List<ProcessFormLogInfo> searchProcessFormlog(Integer prid, String psdid, Integer psdnum, String userid)
			throws BLException {
		IG036SearchCondImpl cond = new IG036SearchCondImpl();
		cond.setPrid(prid);
		cond.setRlType(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);//������־
		cond.setPsdid(psdid);
		cond.setPsdnum(psdnum);
		cond.setRluserid(userid);
		List<IG036Info> lst_IG036Info = workFlowOperationBL.searchUserRoleRecondLog(cond);
		List<ProcessFormLogInfo> lst_ProcessFormLogInfo = null;
		for(int i= lst_IG036Info.size() - 1;i>=0; i--){
			IG036Info info = lst_IG036Info.get(i);
		//for(IG036Info info : lst_IG036Info) {//ǰ����Ӧ���ϰ棬�˴�ԭ�߼�
			//���Ҵ�������־�У�Rldesc������"������"�ļ�¼��ȡ��һ����Ϊ�ύ�����¼
			if(info.getRldesc().indexOf("������") == -1) {
				List<IG113Info> lst_IG113Info = this.workFlowOperationBL.searchRecordLogVarInfoByRecordId(info.getRlid());
				ProcessFormLog instance = null;
				if(!lst_IG113Info.isEmpty()) {
					lst_ProcessFormLogInfo = new ArrayList<ProcessFormLogInfo>();
					for(IG113Info bean : lst_IG113Info) {
						instance = new ProcessFormLog();
						instance.setPidid(bean.getPidid());//������ID
						instance.setName(bean.getPivarname());//������
						if(bean.getPivarname().equals("�¼��ϱ���")){
							instance.setValue(bean.getPishowvarname());//��ֵ
						}else{
							instance.setValue(bean.getPivarvalue());//��ֵ
						}
						lst_ProcessFormLogInfo.add(instance);
					}
				}
				break;
			}
		}
		return lst_ProcessFormLogInfo;
	}

	/**
	 * ָ������״̬����δ��������߲�ѯ
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return ����δ�����������Ϣ
	 * @throws BLException
	 */
	public List<ProcessOverdueInfo> searchProcessOverdueInfo(Integer prid, String status)
			throws BLException {
		IG256SearchCondImpl ig256Cond = new IG256SearchCondImpl();
		ig256Cond.setPrid(prid);
//		ig256Cond.setPrstatus(status);
		ig256Cond.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);//ֻ�г�ʱ����ʾͼ�� ���Ѳ���ʾ
		List<IG256Info> lst_IG256Info = ig256BL.searchIG256(ig256Cond);
		List<ProcessOverdueInfo> lst_ProcessOverdueInfo = new ArrayList<ProcessOverdueInfo>();
		ProcessOverdue bean = null; 
		for(IG256Info info : lst_IG256Info) {
			bean = new ProcessOverdue();
			bean.setUserid(info.getPpuserid());
			bean.setUsername(info.getPpusername());
			lst_ProcessOverdueInfo.add(bean);
		}
		return lst_ProcessOverdueInfo;
	}

	/**
	 * ���̹�ϵ��ѯ
	 * ����������ID��ѯ������ID
	 * 
	 * @param parprid ������ID
	 * @return ������ID�б�
	 * @throws BLException
	 */
	public List<Integer> searchProcessRelationForCld(Integer parprid) throws BLException {
		IG512SearchCondImpl cond = new IG512SearchCondImpl();
		cond.setParprid(parprid);
		List<IG512Info> lst_IG512Info = workFlowOperationBL.searchProcessRecordRelation(cond);
		List<Integer> lst_Prid = new ArrayList<Integer>();
		for(IG512Info bean : lst_IG512Info) {
			lst_Prid.add(bean.getCldprid());
		}
		return lst_Prid;
	}
	
	/**
	 * ���̹�ϵ��ѯ
	 * ����������ID��ѯ������ID
	 * 
	 * @param cldprid ������ID
	 * @return ������ID
	 * @throws BLException
	 */
	public Integer searchProcessRelationForPar(Integer cldprid) throws BLException {
		IG512SearchCondImpl cond = new IG512SearchCondImpl();
		cond.setCldprid(cldprid);
		List<IG512Info> lst_IG512Info = workFlowOperationBL.searchProcessRecordRelation(cond);
		if(lst_IG512Info.isEmpty()) {
			return null;
		} else {
			return lst_IG512Info.get(0).getParprid();
		}
		
	}

	/**
	 * ���̱��ʽ�������ѯ
	 * <BR>
	 * �÷����ķ��ؽ������Ϊ���ʽ������ֵ�Ĳ�ѯ���趨
	 * <BR>
	 * ������Ϣ������ʱ���쳣
	 * @param prid ����ID
	 * @return ���ʽ��������Ϣ
	 * @throws BLException
	 */
	public Map<String, ProcessInfoDefinitionInfo> searchProcessTableColumnDef(Integer prid) throws BLException {
		igflowlog.debug(">>>���̱��ʽ�������ѯ��ʼ��");
	    if(prid == null || prid <= 0) {
			throw new BLException("IGCO10000.E004","����ID");
		}
		//��ѯ������Ϣ
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
		//��ѯ��������Ϣ
		IG007SearchCondImpl pidcond = new IG007SearchCondImpl();
		pidcond.setPdid(process.getPrpdid());
		List<IG007Info> pidList = workFlowDefinitionBL.searchProcessInfoDef(pidcond);
		if(pidList == null){
			throw new BLException("IGFLOW0000.E001","��������Ϣ");
		}
		Map<String, IG007Info> pidMap = new HashMap<String, IG007Info>();
		for(IG007Info pid:pidList){
			pidMap.put(pid.getPidid(), pid);
		}
		Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap = new HashMap<String, ProcessInfoDefinitionInfo>();
		for(IG007Info pid:pidList){
			IG007Info cpid = pid;
			String fullName = cpid.getPidname();
			while(StringUtils.isNotEmpty(cpid.getPpidid())){
				cpid = pidMap.get(cpid.getPpidid());
				fullName = cpid.getPidname() + "#" + fullName;
			}
			ProcessInfoDefinition pidInfo = new ProcessInfoDefinition();
			pidInfo.setPidid(pid.getPidid());
			pidInfo.setPidname(pid.getPidname());
			pidInfo.setPpidid(pid.getPpidid());
			tableColumnDefMap.put(fullName, pidInfo);
		}
		igflowlog.debug(">>>���̱��ʽ�������ѯ������");
		return tableColumnDefMap;
	}
	
	/**
	 * ��ѯ���ʽ���㼶������Ϣ
	 * ������Ϣ������ʱ���쳣
	 * @param prid ��������
	 * @return ���ʽ���㼶������Ϣ
	 * @throws BLException
	 */
	private Map<String, List<IG007Info>> searchProcessTableColumnTierDef(Integer prid) throws BLException{
		igflowlog.debug(">>>���̱��ʽ�������ѯ��ʼ��");
		//��ѯ������Ϣ
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
		//��ѯ��������Ϣ
		IG007SearchCondImpl pidcond = new IG007SearchCondImpl();
		pidcond.setPdid(process.getPrpdid());
		List<IG007Info> pidList = workFlowDefinitionBL.searchProcessInfoDef(pidcond);
		if(pidList == null){
			throw new BLException("IGFLOW0000.E001","��������Ϣ");
		}
		//�㼶��ϵmap
		Map<String, List<IG007Info>> processTableColumnTierDefMap = new HashMap<String, List<IG007Info>>();
		for(IG007Info info:pidList){
			if(StringUtils.isNotEmpty(info.getPpidid())){
				if(processTableColumnTierDefMap.get(info.getPpidid()) == null){
					List<IG007Info> temp = new ArrayList<IG007Info>();
					temp.add(info);
					processTableColumnTierDefMap.put(info.getPpidid(), temp);
				}else{
					processTableColumnTierDefMap.get(info.getPpidid()).add(info);
				}
			}
		}
		igflowlog.debug(">>>���̱��ʽ�������ѯ������");
		return processTableColumnTierDefMap;
	}
	
	/**
	 * ������Ա����Ϣ��ѯ
	 * ������Ϣ�����ڻ����Ϣ������ʱ���쳣
	 * @param prid ����ID
	 * @param name ������
	 * @return ��Ա��Ϣ����
	 * @throws BLException
	 */
	public List<ParticipantInfo> searchPublicParticipantFormValue(Integer prid,String name) throws BLException{
		igflowlog.debug(">>>������Ա����Ϣ��ѯ������ʼ");
		//ȡ�ñ�ֵ
		String value = searchPublicProcessInfo(prid, name);
		//ʵ��������ֵ
		List<ParticipantInfo> participants = new ArrayList<ParticipantInfo>();
		if(StringUtils.isNotEmpty(value)){
			//��ѯ��ǰ��������Ա����Ϣ
			List<IG506Info> list = workFlowOperationBL.searchIG506InfoByprid(prid);
			if(list != null){
				//��װ��Ա��Ϣ
				Map<String, IG506Info> map = new HashMap<String, IG506Info>();
				for(IG506Info pv:list){
					String key = pv.getPiuid() + "";
					map.put(key, pv);
				}
				String[] infos = value.split(",");
				if(infos != null && infos.length > 0){
					for(String key:infos){
						IG506Info pv = map.get(key);
						if(pv != null){
							Participant entry = new Participant();
							entry.setOrgid(pv.getPiorgid());
							entry.setOrgname(pv.getPiorgname());
							entry.setUserid(pv.getPiuserid());
							entry.setUsername(pv.getPiusername());
							entry.setRoleid(pv.getPiroleid());
							entry.setRolename(pv.getPirolename());
							entry.setPhone(pv.getPiphone());
							participants.add(entry);
						}
					}
				}
			}
		}
		igflowlog.debug(">>>������Ա����Ϣ��ѯ��������");
		return participants;
	}

	/**
	 * ���̹��б�ֵ��ѯ
	 * <BR>
	 * �������Ʋ�����ʱ�׳��쳣
	 * @param prid ����ID
	 * @param name ������
	 * @return ��ֵ
	 * @throws BLException
	 */
	public String searchPublicProcessInfo(Integer prid, String name) throws BLException {
	    igflowlog.debug(">>>���̹��б�ֵ��ѯ��ʼ");
	    if(prid == null || prid <= 0) {
			throw new BLException("IGCO10000.E004","����ID");
		}
		if(StringUtils.isEmpty(name)) {
			throw new BLException("IGCO10000.E004","������");
		}
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(prid);//����ID
		cond.setPivarlabel(name);//������
		List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
		if(lst_ProcessInfo.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "����" + name + "��");
		} else if(lst_ProcessInfo.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "����" + name + "��");
		}
		igflowlog.debug(">>>���̹��б�ֵ��ѯ����");
		return lst_ProcessInfo.get(0).getPivarvalue() == null ? "" : lst_ProcessInfo.get(0).getPivarvalue();
	}

	/**
	 * ���ʽ������ֵ��ѯ(���㼶�����м��� "#" ����)
	 * <BR>
	 * ��ȫ·��������ʱ���쳣
	 * @param tableColumnDefMap ���ʽ���ж���
	 * @param tableColumnFullName ���ʽ����ȫ·������
	 * @param prid ����ID
	 * @param rownumber �к�
	 * @return ���ʽ��ֵ
	 * @throws BLException
	 */
	public String searchPublicTableColumnValue(Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap,
			String tableColumnFullName, Integer prid,String rownumber) throws BLException {
		igflowlog.debug(">>>���ʽ��������ֵ��ѯ������ʼ��");
		String returnValue = null;
		if(prid == null || prid == 0){
			throw new BLException("IGFLOW0000.E001","��������");
		}
		if(StringUtils.isEmpty(rownumber)){
			throw new BLException("IGFLOW0000.E001","�к�");
		}
		try{
			//ȡ�ñ�������Ϣ
			ProcessInfoDefinitionInfo pid = tableColumnDefMap.get(tableColumnFullName);
			IG898PK pk = new IG898PK();
			pk.setPidid(pid.getPpidid());
			pk.setPrid(prid);
			pk.setPvcolpidid(pid.getPidid());
			pk.setPvrownumber(rownumber);
			IG898Info tableColumn = workFlowOperationBL.searchTableFormValueByKey(pk);
			if(tableColumn != null){
				returnValue = tableColumn.getPvalue();
			}
		}catch (Exception e) {
			throw new BLException("IGFLOW0000.E001","��������Ϣ");
		}
		igflowlog.debug(">>>���ʽ��������ֵ��ѯ�������������ر�ֵ��" + returnValue);
		return returnValue;
	}
	
	/**
	 * ������ֵ��ѯ
	 * <BR>
	 * ��ȫ·��������ʱ���쳣
	 * @param tableFullName ���ʽ��ȫ��
	 * @param prid ����ID
	 * @param rownumber �к�(����Ƕ��������ַ���)
	 * @return ���ʽ��ֵ��ArrayList��
	 * @throws BLException
	 */
	public Object searchPublicTableValue(String tableFullName, Integer prid,String rownumber) throws BLException{
		igflowlog.debug(">>>���ʽ������ֵ��ѯ������ʼ��");
		Object returnValue = null;
		if(prid == null || prid == 0){
			throw new BLException("IGFLOW0000.E001","��������");
		}
		//��ѯ�������Ϣ
		Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap = searchProcessTableColumnDef(prid);
		if(tableColumnDefMap != null){
			ProcessInfoDefinitionInfo tabledef = tableColumnDefMap.get(tableFullName);
			if(tabledef != null){
				//ȡ�ñ��㼶����
				Map<String, List<IG007Info>> tableColumnTierDef = searchProcessTableColumnTierDef(prid);
				//��ѯ�������µı��ʽ����ֵ
				IG898SearchCondImpl cond = new IG898SearchCondImpl();
				cond.setPrid(prid);
				List<IG898Info> tableColumnValueList = workFlowOperationBL.searchTableFormValue(cond);
				Map<String, Map<String, Map<String, String>>> tableColumnValueMap = new HashMap<String, Map<String,Map<String,String>>>();
				for(IG898Info columnValue:tableColumnValueList){
					if(tableColumnValueMap.get(columnValue.getPidid()) == null){
						Map<String, Map<String, String>> one = new LinkedHashMap<String, Map<String,String>>();
						Map<String, String> two = new LinkedHashMap<String, String>();
						two.put(columnValue.getPvcolpidid(), columnValue.getPvalue());
						one.put(columnValue.getPvrownumber(), two);
						tableColumnValueMap.put(columnValue.getPidid(), one);
					}else{
						if(tableColumnValueMap.get(columnValue.getPidid()).get(columnValue.getPvrownumber()) == null){
							Map<String, String> temp = new LinkedHashMap<String, String>();
							temp.put(columnValue.getPvcolpidid(), columnValue.getPvalue());
							tableColumnValueMap.get(columnValue.getPidid()).put(columnValue.getPvrownumber(), temp);
						}else{
							tableColumnValueMap.get(columnValue.getPidid()).get(columnValue.getPvrownumber()).put(columnValue.getPvcolpidid(), columnValue.getPvalue());
						}
					}
				}
				returnValue = getTableColumnValue(tableColumnTierDef,tableColumnValueMap,tabledef.getPidid(),rownumber);
			}else{
				throw new BLException("IGFLOW0000.E001","��������Ϣ");
			}
		}else{
			throw new BLException("IGFLOW0000.E001","��������Ϣ");
		}
		igflowlog.debug(">>>���ʽ������ֵ��ѯ����������");
		return returnValue;
	}

	/**
	 * ���㼶��ϵ��װ���ʽ��ֵ
	 * @param tableColumnTierDef ���ʽ��ֵ����
	 * @param tableColumnValueMap ���ʽ��ֵ
	 * @param pidid ����������
	 * @param rownumber �к�
	 * @return ���в㼶��ϵ�ı��ʽ��ֵ
	 */
	private Object getTableColumnValue(Map<String, List<IG007Info>> tableColumnTierDef,Map<String, Map<String, Map<String, String>>> tableColumnValueMap,String pidid, String rownumber) {
		List<Object> valueList = null;
		if(tableColumnTierDef != null && tableColumnValueMap != null){
			List<IG007Info> list = tableColumnTierDef.get(pidid);
			Map<String, Map<String, String>> map = tableColumnValueMap.get(pidid);
			if(list != null){
				valueList = new ArrayList<Object>();
				int index = 1;
				if(map != null){
					Set<Entry<String, Map<String, String>>> set = map.entrySet();
					for(Iterator<Entry<String, Map<String, String>>> iter = set.iterator();iter.hasNext();){
						iter.next();
						String crownum = StringUtils.isNotEmpty(rownumber) ? rownumber + "_" + index : index + "";
						Map<String, String> columnValueMap = map.get(crownum);
						if(columnValueMap == null){
							continue;
						}
						Map<String, Object> valueMap = new LinkedHashMap<String, Object>();
						for(IG007Info pid:list){
							if("8".equals(pid.getPidtype())){
								valueMap.put(pid.getPidname(), getTableColumnValue(tableColumnTierDef, tableColumnValueMap, pid.getPidid(), crownum));
							}else{
								valueMap.put(pid.getPidname(), columnValueMap.get(pid.getPidid()));
							}
						}
						valueList.add(valueMap);
						index ++;
					}
				//�����ǰ�㼶����һ���Ǳ��ʽ����map�в�����ֵ
				}else{
					int rows = 1;
					if(tableColumnValueMap != null){
						for(IG007Info pid:list){
							Map<String, Map<String, String>> value = tableColumnValueMap.get(pid.getPidid());
							if(value != null){
								for(Iterator<String> iter = value.keySet().iterator();iter.hasNext();){
									String next = iter.next();
									if(StringUtils.isNotEmpty(next)){
										String[] split = next.split("_");
										if(split.length > 1){
											if(Integer.valueOf(split[split.length - 2]) > rows){
												rows = Integer.valueOf(split[split.length - 2]);
											}
										}
									}
								}
							}
						}
					}
					for(int i=0;i<rows;i++){
						boolean flag = false;
						Map<String, Object> valueMap = new LinkedHashMap<String, Object>();
						String crownum = StringUtils.isNotEmpty(rownumber) ? rownumber + "_" + index : index + "";
						for(IG007Info pid:list){
							if("8".equals(pid.getPidtype())){
								flag = true;
								valueMap.put(pid.getPidname(), getTableColumnValue(tableColumnTierDef, tableColumnValueMap, pid.getPidid(), crownum));
							}else{
								valueMap.put(pid.getPidname(), "");
							}
						}
						if(flag){
							valueList.add(valueMap);
						}
						index ++;
					}
				}
			}
		}
		return valueList;
	}

	/**
	 * ��ܱ�����Ϣ��ѯ
	 * <BR>
	 * �����������ں���ֹ����
	 * @param type ��������
	 * @param pdid ���̶���ID
	 * @param key �걨��ʽ��2012,������ʽ��2012_һ����
	 * @param isClose true����ѯ�ѹرգ�false����ѯδ�رգ�null����ѯȫ������������ֹ
	 * @return ��ܱ���ID�б�
	 * @throws BLException
	 */
	public List<Integer> searchRegulatoryReportInfo(String type, String pdid, String key, Boolean isClose)
			throws BLException {
	    igflowlog.debug(">>>���ü�ܱ��������Ϣ��ѯ��ʼ");
	    List<Integer> lst_Prid= workFlowOperationBL.searchRegulatoryReportDetailByKey(type, pdid, key, isClose);
	    igflowlog.debug(">>>���ü�ܱ��������Ϣ��ѯ�������������̻�����Ϣ�б�������"+lst_Prid.size());
	    return lst_Prid;
	}
	
	/**
	 * ����״̬�б��ѯ
	 * <BR>
	 * ֻ���ض�����Ϣ��ʱ����ϢΪ��
	 * @param pdid ���̶���ID
	 * @return ����״̬�б�
	 * @throws BLException 
	 */
	public List<ProcessStatusInfo> searchProcessStatusList(String pdid) throws BLException {
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(pdid);
		List<IG333Info> lst_IG333Info = this.workFlowDefinitionBL.searchProcessStatusDef(cond);
		List<ProcessStatusInfo> lst_ProcessStatus = null;
		ProcessStatus instance = null;
		if(!lst_IG333Info.isEmpty()) {
			lst_ProcessStatus = new ArrayList<ProcessStatusInfo>();
			for(IG333Info bean : lst_IG333Info) {
				instance = new ProcessStatus();
				instance.setPsdid(bean.getPsdid());//����״̬ID
				instance.setPdid(bean.getPdid());//���̶���ID
				instance.setPsdname(bean.getPsdname());//����״̬����
				instance.setPsdcode(bean.getPsdcode());//����״̬��ʶ
				instance.setBysequence(bean.getBysequence());//����
				instance.setPpsdid(bean.getPpsdid()); //�ϼ�״̬ID
				instance.setFingerPrint(bean.getFingerPrint()); //ʱ���,Ӧ���ϰ�
				lst_ProcessStatus.add(instance);
			}
		}
		return lst_ProcessStatus;
	}
	
	/**
	 * ����״̬��ѯ
	 * <BR>
	 * ֻ���ض�����Ϣ��ʱ����ϢΪ��
	 * @param psdid ����״̬ID
	 * @return ����״̬
	 * @throws BLException 
	 */
	public ProcessStatusInfo searchProcessStatus(String psdid) throws BLException {
		IG333Info ig333Info = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		ProcessStatus instance = new ProcessStatus();
		instance.setPsdid(ig333Info.getPsdid());//����״̬ID
		instance.setPdid(ig333Info.getPdid());//���̶���ID
		instance.setPsdname(ig333Info.getPsdname());//����״̬����
		instance.setPsdcode(ig333Info.getPsdcode());//����״̬��ʶ
		instance.setBysequence(ig333Info.getBysequence());//����
		instance.setPpsdid(ig333Info.getPpsdid()); //�ϼ�״̬ID
		return instance;
	}
	
	/**
	 * ����״̬��־�б��ѯ
	 * @param pdid ���̶���ID
	 * @return ����״̬��־�б�
	 * @throws BLException 
	 */
	public List<ProcessStatusInfo> searchProcessStatusLog(Integer prid) throws BLException {
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		List<IG224Info> lst_IG224Info = this.workFlowOperationBL.searchProcessStatusLog(cond);
		List<ProcessStatusInfo> lst_ProcessStatus = null;
		ProcessStatus instance = null;
		if(!lst_IG224Info.isEmpty()) {
			lst_ProcessStatus = new ArrayList<ProcessStatusInfo>();
			for(IG224Info bean : lst_IG224Info) {
				instance = new ProcessStatus();
				instance.setPsdid(bean.getPsdid());//����״̬ID
				instance.setPdid(bean.getPrpdid());//���̶���ID
				instance.setPsdcode(bean.getPrstatus());//����״̬��ʶ
				instance.setPpsdid(bean.getPpsdid()); //�ϼ�״̬ID
				instance.setOpentime(CommonDefineUtils.DATETIME_SECOND_FORMAT.format(bean.getRslOpenTime())); //״̬��ʼʱ��
				if(bean.getRslCloseTime() != null) {
					instance.setClosetime(CommonDefineUtils.DATETIME_SECOND_FORMAT.format(bean.getRslCloseTime())); //״̬����ʱ��
				}
				instance.setStatusnum(bean.getPsdnum()==null?"":bean.getPsdnum().toString()); //״̬��֧���
				lst_ProcessStatus.add(instance);
			}
		}
		return lst_ProcessStatus;
	}

	/**
	 * ״̬�����߲�ѯ
	 * <BR>
	 * ��״̬���Ʋ�����ʱ�׳��쳣
	 * @param prid ����ID
	 * @param name ״̬����
	 * @return �������б�
	 * @throws BLException 
	 */
	public List<ParticipantInfo> searchStatusParticipant(Integer prid, String name) throws BLException {
	    igflowlog.debug(">>>״̬�����߲�ѯ��ʼ");
	    if(prid == null || prid <= 0) {
			throw new BLException("IGCO10000.E004","����ID");
		}
		if(StringUtils.isEmpty(name)) {
			throw new BLException("IGCO10000.E004","״̬����");
		}
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
		IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
		psdCond.setPdid(process.getPrpdid());
		psdCond.setPsdname(name);
		List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
		if(lst_ProcessStatusDef.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "״̬��" + name + "��");
		} else if(lst_ProcessStatusDef.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "״̬��" + name + "��");
		}
		igflowlog.debug(">>>״̬�����߲�ѯ����");
//		return searchStatusParticipantByCode(prid, lst_ProcessStatusDef.get(0).getPsdcode());
		//�Զ������̸��죬�����˱��е�code�뽫������ʵ�����壬����״̬��ѯ�����˽���״̬����id����   wangtingzhi 20140513
		return searchStatusParticipantByCode(prid, lst_ProcessStatusDef.get(0).getPsdid());
	}

	/**
	 * ״̬�����߲�ѯ
	 * @param prid ����ID
	 * @param status ״̬��ʶ
	 * @return �������б�
	 * @throws BLException 
	 */
	public List<ParticipantInfo> searchStatusParticipantByCode(Integer prid, String status) throws BLException {
		///�Զ������̸��죬״̬code�뽫������ʵ�����壬����״̬��ѯ�����˽���״̬����ID����
		///status ԭΪ״̬code������Ϊ״̬����ID
		///wangtingzhi 20140513
	    igflowlog.debug(">>>״̬�����߲�ѯ��ʼ");
	    if(prid == null || prid <= 0) {
			throw new BLException("IGCO10000.E004","����ID");
		}
		if(StringUtils.isEmpty(status)) {
			throw new BLException("IGCO10000.E004","״̬��ʶ");
		}
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPsdid(status);
//		cond.setPpstatus(status); ԭ������code���ѯ����   wangtingzhi  20140513
		//��ѯ������
		List<IG337Info> lst_ProcessParticipant = workFlowOperationBL.searchProcessParticipants(cond);
		//�����߼���
		List<ParticipantInfo> lst_Participant = new ArrayList<ParticipantInfo>();;
		//������ʵ��
		Participant instance = null;
		if(lst_ProcessParticipant != null && !lst_ProcessParticipant.isEmpty()) {
			for(IG337Info bean : lst_ProcessParticipant) {
				instance = new  Participant();
				instance.setRoleid(bean.getPproleid());//��ɫID
				instance.setRolename(bean.getPprolename());//��ɫ����
				instance.setUserid(bean.getPpuserid());//�û�ID
				instance.setUsername(bean.getPpusername());//�û�����
				instance.setOrgid(bean.getPporgid()); //�û�������
				instance.setOrgname(bean.getPporgname()); //�û���������
				instance.setPpinittime(bean.getPpinittime()); //����ʼʱ��
				instance.setPpproctime(bean.getPpproctime()); //�������ʱ��
				lst_Participant.add(instance);
			}
		}
		if (igflowlog.isDebugEnabled()) {
		    StringBuffer sbParticipant = new StringBuffer();
	        for(IG337Info bean : lst_ProcessParticipant) {
	            if (sbParticipant.toString().equals("")) {
	                sbParticipant.append(bean.getPpuserid());
	            } else {
	                sbParticipant.append(",").append(bean.getPpuserid());
	            }
	        }
	        igflowlog.debug(">>>����״̬�����ߣ�" + sbParticipant.toString());
	    }
		igflowlog.debug(">>>״̬�����߲�ѯ����");
		return lst_Participant;
	}
	
	/**
	 * ��Ա��ֵ��ѯ
	 * @param prid ����ID
	 * @param pidname ������
	 * @return ��Ա��Ϣ����
	 * @throws ������IDΪ��ʱ���쳣
	 */
	public List<ParticipantInfo> searchProcessParticipantForm(Integer prid,String pidname) throws BLException {
	    if(prid == null || prid == 0){
	        throw new BLException("IGCO10000.E004","����ID");
	    }
	    List<ParticipantInfo> list = new ArrayList<ParticipantInfo>();
	    //��ѯ��Ա����Ϣ
	    List<IG506Info> pfList = workFlowOperationBL.searchIG506InfoByprid(prid);
	    Map<String, IG506Info> map = new HashMap<String, IG506Info>();
	    if(pfList != null){
	        for(IG506Info info:pfList){
	            map.put(info.getPiuid() + "", info);
	        }
	    }
	    //��ѯ��ֵ
	    if(StringUtils.isNotEmpty(pidname)){
	        String value = searchPublicProcessInfo(prid, pidname);
	        if(StringUtils.isNotEmpty(value)){
	            for(String s:value.split(",")){
	                IG506Info info = map.get(s);
	                if(info != null){
	                    Participant p = new Participant();
	                    p.setOrgid(info.getPiorgid());
	                    p.setOrgname(info.getPiorgname());
	                    p.setPhone(info.getPiphone());
	                    p.setRoleid(info.getPiroleid());
	                    p.setRolename(info.getPirolename());
	                    p.setUserid(info.getPiuserid());
	                    p.setUsername(info.getPiusername());
	                    list.add(p);
	                }
	            }
	        }
	    }
	    return list;
	}
}
