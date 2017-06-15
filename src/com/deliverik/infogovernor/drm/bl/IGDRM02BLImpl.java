package com.deliverik.infogovernor.drm.bl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.EntityItemInfo;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG273BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.IG481BL;
import com.deliverik.framework.workflow.prd.bl.task.IG482BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.IG699BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;
import com.deliverik.framework.workflow.prd.model.entity.IG481TB;
import com.deliverik.framework.workflow.prd.model.entity.IG482TB;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.dto.IGDRM02DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0201Form;


/**
 * ��ϳ���ҵ���߼�ʵ��
 *
 */
public class IGDRM02BLImpl extends BaseBLImpl implements IGDRM02BL {

	static Log log = LogFactory.getLog(IGDRM02BLImpl.class);
	/**IG380BL����*/
	protected IG380BL ig380BL;
	/**SOC0118BL����*/
	protected SOC0118BL soc0118BL;
	/**SOC0107BL����*/
	protected SOC0107BL soc0107BL;
	/**WorkFlowDefinitionBL����*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	/**IG480BL�����鶨��BL*/
	protected IG480BL ig480BL ;
	/**IG480BL�����鶨��BL*/
	protected IG481BL ig481BL ;
	/**IG480BL�����鶨��BL*/
	protected IG482BL ig482BL ;
	/**IG333BL���̶���ڵ�BL*/
	protected IG333BL ig333BL ;
	/**IG500BL�����鶨��BL*/
	protected IG500BL ig500BL ;
	/**IG273BL�����鶨��BL*/
	protected IG273BL ig273BL;
	/**flowSearchBL*/
	protected FlowSearchBL flowSearchBL;
	/**IG560BL*/
	protected IG560BL ig560BL;
	/**AttachmentBL*/
	protected AttachmentBL attachmentBL;
	
	
	/**
	 * @param ig333bl the IG33BL���̶���ڵ�BL to set
	 */
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}
	/**
	 * @param ig481bl the IG480BL�����鶨��BL to set
	 */
	public void setIg481BL(IG481BL ig481bl) {
		ig481BL = ig481bl;
	}
	/**
	 * @param ig482bl the IG480BL�����鶨��BL to set
	 */
	public void setIg482BL(IG482BL ig482bl) {
		ig482BL = ig482bl;
	}
	/**
	 * @param AttachmentBL the attachmentBL to set
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	/**
	 * @param flowSearchBL the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	/**
	 * @param ig560bl the IG560BL to set
	 */
	public void setIg560BL(IG560BL ig560bl) {
		ig560BL = ig560bl;
	}
	/**
	 * @param ig480bl the IG480BL�����鶨��BL to set
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}
	/**
	 * @param ig500bl the IG500BL�����鶨��BL to set
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}
	/**
	 * @param ig380bl the IG380BL���� to set
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}
	/**
	 * @param soc0118bl the SOC0118BL���� to set
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}
	/**
	 * @param soc0107bl the SOC0107BL���� to set
	 */
	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}
	/**
	 * @param WorkFlowDefinitionBL���� the workFlowDefinitionBL to set
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	/**
	 * @param ig273bl the IG273BL�����鶨��BL to set
	 */
	public void setIg273BL(IG273BL ig273bl) {
		ig273BL = ig273bl;
	}
	/**
	 * ����ѡ��ĳ���jsonXml
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public String getSceneProcessXMLInfo(IGDRM02DTO dto) throws BLException {
		String[] addEiids = dto.getAddEiids();
		if(addEiids==null){
			addEiids = new String[]{};
		}
		//��ʼ��֯����
		StringBuffer jsonTemp = new StringBuffer("<GroupFlow ");
		jsonTemp.append(" contentHeight= \""+400+"\">");
		jsonTemp.append(" <BaseProperties pgdid= \""+""+"\"");
		jsonTemp.append(" pgdname=  \""+""+"\"/>");
		jsonTemp.append("<WebFlows>");
		for(String eiid : addEiids){
			if(StringUtils.isEmpty(eiid))continue;
			//�����ʲ�ʵ��
			SOC0118Info soc0118info = soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			SOC0107SearchCondImpl soc0107Cond = new SOC0107SearchCondImpl() ;
			soc0107Cond.setEiid(eiid);
			soc0107Cond.setCid(IGDRMCONSTANTS.SCENE_MODEL_CID);
			//���ְ汾ͳһ
			soc0107Cond.setCiversion(soc0118info.getEiversion().toString());
			soc0107Cond.setCismallversion(soc0118info.getEismallversion().toString());
			List<SOC0107Info> soc0107InfoList = soc0107BL.searchSOC0107(soc0107Cond);
			//�ʲ�����-����pdid
			String pdid = "";
			if(soc0107InfoList!=null&&soc0107InfoList.size()>0){
				pdid = soc0107InfoList.get(0).getCivalue();
			}
			if(!StringUtils.isEmpty(pdid)){
				String xml = initProcessDefinitionAction(pdid, eiid);
				jsonTemp.append(xml);
			}
		}
		//��֯��β����
		jsonTemp.append("</"
				+ "WebFlows>");
		jsonTemp.append("<FlowActions>");
		jsonTemp.append("</FlowActions>");
		jsonTemp.append("</GroupFlow>");
		return jsonTemp.toString();
	}
	/**
	 * ��ϳ�����ʼ��jsonXml(�޶�+����)
	 * @author ZYL
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public String getSceneInitXMLInfo(IGDRM02DTO dto) throws BLException {
		String jsonTemp = "";
		if(StringUtils.isNotEmpty(dto.getIsUpdate())){//�޶����
			//��ѯ��ϳ��������xml
			IG480Info Info = ig480BL.searchIG480ByPK(dto.getPgdid());
			//ȡ������xml
			jsonTemp = Info.getPgdxml();
			//�޶�������Ҫ�Ǳ�����Ͳ��ڸ���xml
			if(Info!=null&&"SAVED".equals(Info.getFingerPrint())){
				return jsonTemp;
			}
			try {
				//�¾�psdid,Map<old_psdid,new_psdid>
				Map<String,String> oldToNewMap= new HashMap<String, String>();
				Document doc = DocumentHelper.parseText(jsonTemp);
				//ȡ�ø��ڵ�
				Element root = doc.getRootElement();
				for(Iterator<Element> WebFlows = root.element("WebFlows").elementIterator("WebFlow");WebFlows.hasNext();){
					Element WebFlow = WebFlows.next();
					Element base = WebFlow.element("BaseProperties");
					if(base != null){
						String flowId = base.attributeValue("flowId");
						String eiid = base.attributeValue("eiid");
						if(StringUtils.isNotEmpty(flowId)){
							IG481SearchCondImpl ig481cond = new IG481SearchCondImpl();
							//ԭpgdid
							ig481cond.setPgdid(dto.getOldpdid());
							ig481cond.setPdid(flowId);
							List<IG481Info> ig481List= ig481BL.searchIG481(ig481cond);
							if(ig481List!=null&&ig481List.size()>0){
								//�����������������ʶ
								String flag = ig481List.get(0).getFingerPrint();
								if(StringUtils.isNotEmpty(flag)&&!flag.equals(flowId)){
									//���xml
									Map<String,Object> toolMap= new HashMap<String, Object>();
									Map<String,String> oldMap= new HashMap<String,String>();
									//δ�����xml
									for(Iterator<Element> Steps = WebFlow.element("Steps").elementIterator("Step");Steps.hasNext();){
										Element Step = Steps.next();
										String psdid = Step.element("BaseProperties").attributeValue("id");
										toolMap.put("psdid", psdid);
											if(StringUtils.isNotEmpty(psdid)){
												//����
												Element X_Y = Step.element("VMLProperties");
												toolMap.put(psdid.substring(7, 10), X_Y);
												//���psdid
												oldMap.put(psdid.substring(7, 10), psdid);
											}
									}
									//��ϳ����н���������³������Ƚϣ���ļ��ٵ�ɾ��
//									IG380SearchCondImpl ig380cond = new IG380SearchCondImpl();
//									ig380cond.setPdid_like(ig481List.get(0).getPdid().substring(0, 5));
//									ig380cond.setPdstatus("a");
//									ig380cond.setPtid(19);
									//�õ����³���������Ϣ
//									List<IG380Info> ig380List = ig380BL.searchIG380Info(ig380cond);
									IG380Info ig380Info = ig380BL.searchIG380InfoByKey(flag);
//									if(ig380List!=null&&ig380List.size()>0){
									if(ig380Info!=null){
//										IG380Info ig380Info = ig380List.get(0);
										//pdid�¾��滻
										oldToNewMap.put(ig481List.get(0).getPdid().substring(0, 7), ig380Info.getPdid());
										//�������̶���xml
										String newXml = initProcessDefinitionAction(ig380Info.getPdid(), eiid);
										Document neWdoc = DocumentHelper.parseText(newXml);
										Element newRoot = neWdoc.getRootElement();
										newRoot.asXML();
										
										//���°汾xml
										for(Iterator<Element> Steps = newRoot.element("Steps").elementIterator("Step");Steps.hasNext();){
											Element Step = Steps.next();
											String id = Step.element("BaseProperties").attributeValue("id");
											if(StringUtils.isNotEmpty(id)){
												//key���Ͻ�㣬value���½ڵ�
												oldToNewMap.put(oldMap.get(id.substring(7, 10)), id);
												//�滻����
												Element X_Y = Step.element("VMLProperties");
												if(null!=toolMap.get(id.substring(7, 10))&&""!=toolMap.get(id.substring(7, 10))){
													//ɾ���ϵ�����
													Step.remove(X_Y);
													//�滻�µ�����
													Element VMLProperties = DocumentHelper.createElement("VMLProperties");
													VMLProperties.appendAttributes((Element) toolMap.get(id.substring(7, 10)));
													Step.add(VMLProperties);
												}else{//�¼ӵĽ��
													//ɾ���ϵ�����
													Step.remove(X_Y);
													//�滻�µ�����
													Element VMLProperties = DocumentHelper.createElement("VMLProperties");
													VMLProperties.appendAttributes((Element) toolMap.get("001"));
													Step.add(VMLProperties);
												}
											}
										}
										//�滻�µĳ�������xml
										root.element("WebFlows").remove(WebFlow);
										root.element("WebFlows").add(newRoot);
									}
								}else{//û���棬���нڵ�psdid��Map
									oldToNewMap.put(ig481List.get(0).getPdid(), ig481List.get(0).getPdid());
									IG333SearchCondImpl ig333cond = new IG333SearchCondImpl();
									ig333cond.setPdid(ig481List.get(0).getPdid());
									List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333cond);
									if(ig333List!=null&&ig333List.size()>0)
									for(IG333Info info : ig333List){
										oldToNewMap.put(info.getPsdid(), info.getPsdid());
									}
									
								}
							}		
						}
					}
				}
				for(Iterator<Element> Actions = root.element("FlowActions").elementIterator("FlowAction");Actions.hasNext();){
					Element Action = Actions.next();
					//ɾ��ԭ��������
					root.element("FlowActions").remove(Action);
					Boolean flag = true;
					Element base = Action.element("BaseProperties");
					Element rules = Action.element("Rules");
					
					Element action = DocumentHelper.createElement("FlowAction");
					//��������
					Element actionBase = DocumentHelper.createElement("BaseProperties");
					String id =  base.attributeValue("id");//id
					if(StringUtils.isNotEmpty(id))
					actionBase.addAttribute("id", id);
					actionBase.addAttribute("actionType", "PolyLine");
					String from = base.attributeValue("from");//from
					String fromCopy = "";
					if(StringUtils.isNotEmpty(from)){
						if(StringUtils.isEmpty(oldToNewMap.get(from.substring(0, 7)))){
							//����ɾ�����
							flag  = false;
						}else{
							fromCopy = oldToNewMap.get(from.substring(0, 7)).toString();
						}
						actionBase.addAttribute("from", from.replace(from.substring(0, 7),fromCopy));
					}
					String to = base.attributeValue("to");//to
					String toCopy = "";
					if(StringUtils.isNotEmpty(to)){
						if(StringUtils.isEmpty(oldToNewMap.get(to.substring(0, 7)))){
							//����ɾ�����
							flag  = false;
						}else{
							toCopy = oldToNewMap.get(to.substring(0, 7)).toString();
						}
						actionBase.addAttribute("to", to.replace(to.substring(0, 7),toCopy));
					}
					action.add(actionBase);
					//����ԾǨ����
					Element actionrules = DocumentHelper.createElement("Rules");
					actionrules.addAttribute("pbname", "�ύ");
					actionrules.addAttribute("ptdtype", "3");
					actionrules.addAttribute("ptdcond","AAA!10#");
					String ptdid = rules.attributeValue("ptdid");//ptdid
					String ptdidStr = "";
					if(StringUtils.isNotEmpty(ptdid)){
						for(String str : ptdid.split("_")){
							if(StringUtils.isEmpty(str))continue;
							if(StringUtils.isEmpty(oldToNewMap.get(str))){
								flag = false; 
							}else{
								//����ƴptdid�ַ���
								ptdidStr=ptdidStr+oldToNewMap.get(str)+"_";
							}
						}
						actionrules.addAttribute("ptdid", ptdidStr);
					}
					action.add(actionrules);
					if(flag)//�ڵ�ɾ�����ж�
					root.element("FlowActions").add(action);
				}
				return root.asXML();
			}catch (Exception e) {
				
			}
			
		}else{//�����������
		//��ѯ��ϳ��������xml
		IG480Info Info = ig480BL.searchIG480ByPK(dto.getPgdid());
		//��������xml
		jsonTemp = Info.getPgdxml().toString();
		return jsonTemp;
		}
		return null;
	}
	/**
	 * ��ѯ������Ϣ
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public IGDRM02DTO searchSceneProcessInfo(IGDRM02DTO dto) throws BLException {
		log.debug("========������ѯ��������========");
		IGDRM0201Form form = dto.getIgdrm0201Form();
		//����������в�������eiid
		List<String> eiidstrs = new ArrayList<String>();
		SOC0124SearchCondImpl soc0124cond = new SOC0124SearchCondImpl();
		if(form!=null&&!StringUtils.isEmpty(form.getEiids())){
			for(String eiid : form.getEiids().split("_")){
				if(StringUtils.isNotEmpty(eiid))
					eiidstrs.add(eiid);
			}
			soc0124cond.setEiidNotInList(eiidstrs);
		}
		soc0124cond.setEsyscoding(IGDRMCONSTANTS.SCENE_ESYSCODING);
		soc0124cond.setModifyflag("999060");
		//��ѯ����--��������
		soc0124cond.setEiname(form.getEname());
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(soc0124cond);
		dto.setSoc0124List(entityItemVWInfoList);
		log.debug("========������ѯ��������========");
		return dto;
	}
	/**
	 * ������ϳ���������Ϣ
	 * @param String 
	 * @return
	 * @throws BLException
	 * @throws DocumentException 
	 */
	@SuppressWarnings("unchecked")
	public void saveSceneProcessAction(IGDRM02DTO dto) throws BLException, DocumentException {
		log.debug("========��ϳ������洦������========");
		try {
			Document doc = DocumentHelper.parseText(dto.getXmlValue());
			//ȡ�ø��ڵ�
			Element root = doc.getRootElement();
			String pgdid = root.element("BaseProperties").attributeValue("pgdid");
			//�������ٱ���
			ig480BL.deleteIG480ByPK(pgdid);
			//���浽IG480��
			IG480TB ig480TB = new IG480TB();
			ig480TB.setPgdid(pgdid);
			//����ʱ��
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_SECOND_FORMAT.format(nowDateTime);
			ig480TB.setPgdcrtime(datetime);
			//
			Integer prid = dto.getPrid();
			if(prid!=null&&prid>0){
				IG500Info ig500Info = ig500BL.searchIG500InfoByKey(prid);
				//��ϳ����������� 
				ig480TB.setPgddesc(ig500Info.getPrdesc());
				//��ϳ�������
				ig480TB.setPgdname(ig500Info.getPrtitle());
			}
			ig480TB.setPgdxml(dto.getXmlValue());
			ig480TB.setPtid(19);//�Զ���
			ig480TB.setPgdstatus("i");//ͣ�ã��ر�ǰ�����Ϊ״̬��a������
			if(StringUtils.isNotEmpty(dto.getPdidStr()))
				//�޶�����ҳ��flex��ʼ���ͱ����ĳ�ʼ���߼���ͬ�����⴦��
				if(IGDRMCONSTANTS.SCENE_DEFINE_FIVE.equals(dto.getPdidStr().substring(0, 5)))
				ig480TB.setFingerPrint("SAVED");
			ig480BL.registIG480(ig480TB);
			for(Iterator<Element> WebFlows = root.element("WebFlows").elementIterator("WebFlow");WebFlows.hasNext();){
				Element WebFlow = WebFlows.next();
				Element base = WebFlow.element("BaseProperties");
				if(base != null){
					//����481��
					String flowId = base.attributeValue("flowId");
					String createtype = base.attributeValue("createtype");
					IG481TB ig481TB = new IG481TB();
					ig481TB.setPgdid(pgdid);
					ig481TB.setPdid(flowId);
					if(StringUtils.isNotEmpty(createtype)){
						if("O".equals(createtype)||"0".equals(createtype)){
							ig481TB.setCreateType("0");
						}else if("I".equals(createtype)||"1".equals(createtype)){
							ig481TB.setCreateType("1");
						}else{
							ig481TB.setCreateType(createtype);
						}
					}else{
						ig481TB.setCreateType(createtype);
					}
					ig481TB.setPdversion("1");
					ig481TB.setFingerPrint(flowId);
					ig481BL.registIG481(ig481TB);
				}
			}
			//������ϵ
			for(Iterator<Element> Actions = root.element("FlowActions").elementIterator("FlowAction");Actions.hasNext();){
				Element Action = Actions.next();
				Element base = Action.element("BaseProperties");
				Element rules = Action.element("Rules");
				String ptdid = "";
				String id = "";
				String rpdid = "";
				String ipdid = "";
				String from = "";
				String to = "";
				ptdid = rules.attributeValue("ptdid");
				if(base != null&&rules != null){
					//����IG482��
					id = base.attributeValue("id");
					rpdid = base.attributeValue("rpdid");
					ipdid = base.attributeValue("ipdid");
					from = base.attributeValue("from");
					to = base.attributeValue("to");
					ptdid = rules.attributeValue("ptdid");
				}
				//���from-->���to,����from�Ƕ��֧,ԾǨ�����ж��
				if(StringUtils.isNotEmpty(ptdid)){
					for(String tpsdid : ptdid.split("_")){
						if(StringUtils.isEmpty(tpsdid))continue;
						IG482TB ig482TB = new IG482TB();
						ig482TB.setPgreid(id.replace("a", ""));//ȥ��xml��id��a
						ig482TB.setPgdid(pgdid);
						ig482TB.setRpdid(rpdid);
						ig482TB.setIpdid(ipdid);
						ig482TB.setPgrerule(tpsdid);
						ig482TB.setRpsdid(from);
						ig482TB.setIpsdid(to);
						ig482BL.registIG482(ig482TB);
					}
				}
			}
		}catch (Exception e) {
			
		}
		log.debug("========�������洦������========");
	}
	/**
	 * �������̶�����Ϣ
	 * @param String
	 * @return
	 * @throws BLException
	 */
	private String initProcessDefinitionAction(String pdid , String eiid) throws BLException {
		log.debug("=============�������̶�����Ϣ������ʼ=============");
		IG699BL ig699BL = (IG699BL) WebApplicationSupport.getBean("ig699BL");
		IG007BL ig007BL = (IG007BL) WebApplicationSupport.getBean("ig007BL");
		String jsonXml = "";
		if(StringUtils.isNotEmpty(pdid)){
			//ƴ��xml
			Document doc = DocumentHelper.createDocument();
			//��ʼ�����̶�����Ϣ
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
			Element rootElement = DocumentHelper.createElement("WebFlow");
			Element rootBase = DocumentHelper.createElement("BaseProperties");
			rootBase.addAttribute("flowId", pd.getPdid());
			rootBase.addAttribute("flowText", pd.getPdname());
			rootBase.addAttribute("eiid",eiid);
			rootElement.add(rootBase);
			//��ʼ�����ɽڵ�
			IG233SearchCondImpl assignCond = new IG233SearchCondImpl();
			assignCond.setPdid(pdid);
			List<IG233Info> assignList = workFlowDefinitionBL.searchAssignedDefInfo(assignCond);
			Map<String, List<IG233Info>> assignMap = new HashMap<String, List<IG233Info>>();
			for(IG233Info info:assignList){
				if(assignMap.get(info.getPsdid()) == null){
					assignMap.put(info.getPsdid(), new ArrayList<IG233Info>());
				}
				assignMap.get(info.getPsdid()).add(info);
			}
			//��ʼ����ť
			IG725SearchCondImpl psbCond = new IG725SearchCondImpl();
			//mark
			psbCond.setPdbdid_like(pdid);
			List<IG725Info> psbList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(psbCond);
			Map<String, Map<String, IG725Info>> psbMap = new HashMap<String,  Map<String, IG725Info>>();
			for(IG725Info info:psbList){
				if(psbMap.get(info.getPsdid()) == null){
					psbMap.put(info.getPsdid(), new HashMap<String, IG725Info>());
				}
				psbMap.get(info.getPsdid()).put(info.getPbdid(), info);
			}
			//��ʼ���ڵ㶨����Ϣ
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(pdid);
			List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			Element steps = DocumentHelper.createElement("Steps");
			for(IG333Info info:psdList){
				Element step = DocumentHelper.createElement("Step");
				Element stepBase = DocumentHelper.createElement("BaseProperties");
				stepBase.addAttribute("id", info.getPsdid());
				stepBase.addAttribute("text", info.getPsdname());
				if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(info.getPsdcode())){
					stepBase.addAttribute("stepType", "EndStep");
				}else if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(info.getPsdcode())){
					stepBase.addAttribute("stepType", "BeginStep");
				}else{
					stepBase.addAttribute("stepType", "NormalStep");
				}
				step.add(stepBase);
				Element baseInfo = DocumentHelper.createElement("BasicInfo");
				//����ԾǨ��
				IG699SearchCondImpl ig699Cond = new IG699SearchCondImpl();
				ig699Cond.setPsdid(info.getPsdid());
				List<IG699Info> ig699InfoList = ig699BL.searchIG699Info(ig699Cond);
				if(ig699InfoList!=null && ig699InfoList.size()>0){
					for(IG699Info ig699Info:ig699InfoList){
						IG007Info ig007Info = ig007BL.searchIG007InfoByKey(ig699Info.getPidid());
						if(ig007Info!=null &&ig007Info.getPidname().equals("ԾǨ����")){
							baseInfo.addAttribute("ig007Entity", "true");
						}
					}
				}
				addInfo(baseInfo,info);
				step.add(baseInfo);
				List<IG233Info> list = assignMap.get(info.getPsdid());
				if(list != null){
					Element psbs = DocumentHelper.createElement("AssignList");
					for(IG233Info psb:list){
						Element button = DocumentHelper.createElement("AssignInfo");
						addInfo(button,psb);
						psbs.add(button);
					}
					step.add(psbs);
				}
				
				//������
				IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
				ig222Cond.setPsdid(info.getPsdid());
				List<IG222Info> parList = workFlowDefinitionBL.searchParticipantDef(ig222Cond);
				if(parList != null){
					Element psbs = DocumentHelper.createElement("Participants");
					for(IG222Info psb:parList){
						Element roleInfo = DocumentHelper.createElement("role");
						addInfo(roleInfo,psb);
						psbs.add(roleInfo);
					}
					step.add(psbs);
				}
				
				steps.add(step);
			}
			
			rootElement.add(steps);
			IG273SearchCondImpl pstCond = new IG273SearchCondImpl();
			pstCond.setPtdid_like(pdid);
			List<IG273Info> pstList = workFlowDefinitionBL.searchProcessTransitionDef(pstCond);
			Element actions = DocumentHelper.createElement("Actions");
			for(IG273Info info:pstList){
				Element action = DocumentHelper.createElement("Action");
				Element actionBase = DocumentHelper.createElement("BaseProperties");
				actionBase.addAttribute("id", IGPRDCONSTANTS.IMG_ACTION_ID_BEGIN_WITH + info.getPtdid());
				actionBase.addAttribute("actionType", "PolyLine");
				actionBase.addAttribute("from", info.getFpsdid());
				actionBase.addAttribute("to", info.getTpsdid());
				actionBase.addAttribute("ppsdid", info.getFingerPrint());
				action.add(actionBase);
				Element rules = DocumentHelper.createElement("Rules");
				rules.addAttribute("ptdname", info.getPtdname());
				rules.addAttribute("ptddesc", info.getPtddesc());
				rules.addAttribute("ptdtype", info.getPtdtype());
				rules.addAttribute("ptdcond", info.getPtdcond());
				rules.addAttribute("ptdid", info.getPtdid());
				Map<String, IG725Info> map = psbMap.get(info.getFpsdid());
				if(map != null){
					if(StringUtils.isNotEmpty(info.getPtdcond())){
						String[] split = info.getPtdcond().split("!");
						if(split.length > 1){
							String pbid = split[1].split("#")[0];
							IG725Info pb = map.get(pbid);
							if(pb != null){
								rules.addAttribute("pbname", pb.getPdbdname());
							}
						}
					}
				}
				action.add(rules);
				actions.add(action);
			}
			rootElement.add(actions);
			doc.setRootElement(rootElement);
			addOtherInfo(doc,pd);
			jsonXml = doc.getRootElement().asXML();
		}
		log.debug("=============�������̶�����Ϣ��������=============");
		return jsonXml;
	}
	@SuppressWarnings("unchecked")
	private void addOtherInfo(Document doc, IG380Info pd) {
		if(StringUtils.isNotEmpty(pd.getPdxml())){
			try {
				Document flowXml = DocumentHelper.parseText(pd.getPdxml());
				Element root = flowXml.getRootElement();
				Map<String, Element> stepMap = new HashMap<String, Element>();
				Map<String, Element> actionMap = new HashMap<String, Element>();
				for(Iterator<Element> steps = root.element("Steps").elementIterator();steps.hasNext();){
					Element element = steps.next();
					String psdid = element.element("BaseProperties").attributeValue("id");
					stepMap.put(psdid, element);
				}
				for(Iterator<Element> actions = root.element("Actions").elementIterator();actions.hasNext();){
					Element element = actions.next();
					String ptdid = element.element("BaseProperties").attributeValue("id");
					actionMap.put(ptdid, element);
				}
				for(Iterator<Element> steps = doc.getRootElement().element("Steps").elementIterator();steps.hasNext();){
					Element element = steps.next();
					String psdid = element.element("BaseProperties").attributeValue("id");
					Element e = stepMap.get(psdid);
					Element vml = DocumentHelper.createElement("VMLProperties");
					vml.addAttribute("width", "50");
					vml.addAttribute("height", "80");
					if(e != null){
						Element rvml = e.element("VMLProperties");
						vml.addAttribute("x", rvml.attributeValue("x"));
						vml.addAttribute("y", rvml.attributeValue("y"));
					}
					element.add(vml);
				}
				for(Iterator<Element> actions = doc.getRootElement().element("Actions").elementIterator();actions.hasNext();){
					Element element = actions.next();
					String ptdid = element.element("BaseProperties").attributeValue("id");
					Element e = actionMap.get(ptdid);
					if(e != null){
						List<Element> list = e.elements("point");
						if(list != null){
							for(Element p:list){
								Element point = DocumentHelper.createElement("point");
								point.addAttribute("id", p.attributeValue("id"));
								point.addAttribute("x", p.attributeValue("x"));
								point.addAttribute("y", p.attributeValue("y"));
								element.add(point);
							}
						}
					}
				}
			} catch (DocumentException e) {
				log.error("",e);
			}
		}
	}


	private void addInfo(Element other, Object info) {
		Class<? extends Object> clz = info.getClass();
		Field[] fields = clz.getDeclaredFields();
		
		for(Field f:fields){
			f.setAccessible(true);
			try{
				Object o = f.get(info);
				if(o instanceof String || o instanceof Integer || o instanceof Double){
					other.addAttribute(f.getName(), o.toString());
				}else{
					other.addAttribute(f.getName(), "");
				}
			}catch (Exception e) {
				log.error("",e);
			}
		}
		//�����е����� - fingerprint
		Field[] superFields = clz.getSuperclass().getDeclaredFields();
		for(Field f:superFields){
			f.setAccessible(true);
			try{
				Object o = f.get(info);
				if(o instanceof String || o instanceof Integer || o instanceof Double){
					other.addAttribute(f.getName(), o.toString());
				}else{
					other.addAttribute(f.getName(), "");
				}
			}catch (Exception e) {
				log.error("",e);
			}
		}
	}
	
	/**
	 * ��ѯ����������״̬����XML
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getStateFormXML(IGDRM02DTO dto)throws BLException{
		// ��ʼ��֯����
		StringBuffer jsonTemp = new StringBuffer("<GroupStateForm> ");
		if(StringUtils.isNotEmpty(dto.getPdidStr())){
			//����³��������
			for(String pdid : dto.getPdidStr().split("_")){
				if(StringUtils.isNotEmpty(pdid))
				jsonTemp.append(getStateForm(pdid));
			}
			// ��֯��β����
			jsonTemp.append("</GroupStateForm>");
			return jsonTemp.toString();
		}
		//ҳ���ʼ�������
		if(StringUtils.isNotEmpty(dto.getPgdid())){
			//�鿴���̶����Ա��
			IG481SearchCondImpl cond = new IG481SearchCondImpl();
			cond.setPgdid(dto.getPgdid());
			List<IG481Info> ig481List = ig481BL.searchIG481(cond);
			if(ig481List!=null&&ig481List.size()>0)
			for(IG481Info info : ig481List){
				if(info!=null&&info.getPdid()!=null)
				jsonTemp.append(getStateForm(info.getPdid()));
			}
			// ��֯��β����
			jsonTemp.append("</GroupStateForm>");
			return jsonTemp.toString();
		}
		return null;
	}
	/**
	 * ��ѯ�������µ���״̬����XML
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	private String getStateForm(String pdid)throws BLException{
		List<ProcessStatusInfo> psList = flowSearchBL.searchProcessStatusList(pdid);
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);//����ID
		cond.setPidmode("2");//״̬����
		cond.setPiduse("1");
		List<IG007Info> formLst = workFlowDefinitionBL.searchProcessInfoDef(cond);
		//�������������нڵ�
		//״̬�ڵ㸽����Ϣ
		StringBuffer formListXml = new StringBuffer("<StateFormList pdid= \""+pdid+"\">");
		IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
		ig560Cond.setPsdid_l(pdid);
		ig560Cond.setUsedToAll("F");
		List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
		Map<String,IG560Info> ig560Map = new HashMap<String,IG560Info>();
		//���������µ�״̬��ֵ ��Ϣ��װ��map
		for(IG560Info ig560Info:ig560List){
			ig560Map.put(ig560Info.getPsdid()+"_"+ig560Info.getPidid(), ig560Info);
		}
		for(int i=0;i<psList.size();i++){
			ProcessStatusInfo psInfo = psList.get(i);
			formListXml.append("<StepForm psdid= \""+psInfo.getPsdid()+"\" >");
			String psdid = psInfo.getPsdid();
			for(int j=0;j<formLst.size();j++){
				IG007Info ig007Info = formLst.get(j);
				formListXml.append("<FormInfo ");
				formListXml.append(" psdid= \""+psInfo.getPsdid()+"\" ");
				formListXml.append(" pidid= \""+ig007Info.getPidid()+"\" ");
				formListXml.append(" pidname= \""+ig007Info.getPidname()+"\" ");
				formListXml.append(" pidtype= \""+ig007Info.getPidtype()+"\" ");
				String dfvalue = "";
				if(ig560Map.containsKey(psdid+"_"+ig007Info.getPidid())){
					dfvalue = ig560Map.get(psdid+"_"+ig007Info.getPidid()).getDfvalue();
				}
				if("F".equals(ig007Info.getPidtype())&&!"".equals(dfvalue)){
					List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(dfvalue);
					if(null!=attList&&attList.size()>0){
						dfvalue = attList.get(0).getAttname();
					}
				}
				if("4".equals(ig007Info.getPidtype())&&!StringUtils.isBlank(dfvalue)){
					EntityItemInfo itemInfo = flowSearchBL.searchEntityItem(Integer.valueOf(dfvalue));
					dfvalue = dfvalue+"_EIID_"+itemInfo.getEiname();   
				}
				formListXml.append(" dfvalue= \""+nullToEmpty(dfvalue)+"\"  />");
			}
			formListXml.append("</StepForm>");
		}
		formListXml.append(" </StateFormList>");
		
		return formListXml.toString();
	}
	/**
	 * null->""
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public String nullToEmpty(String str) throws BLException{
		if(null==str){
			str = "";
		}	
		return str;
	}
	
}
