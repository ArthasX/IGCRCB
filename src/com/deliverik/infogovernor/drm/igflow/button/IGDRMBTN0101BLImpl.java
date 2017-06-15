package com.deliverik.infogovernor.drm.igflow.button;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.EntityItemInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG126TB;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
 * <p>
 * �������������ڵ㣨��һҳ���������һ������ť�¼�
 * ��������ʱ��������һ���������̶���
 * ��������ʱ������һ���������̶���
 * 
 * </p>
 */
public class IGDRMBTN0101BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGDRMBTN0101BLImpl.class);

	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
    /** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;
    /** ���̶��幦��BL */
    private WorkFlowDefinitionBL workFlowDefinitionBL;
    /** ����ʵ������BL */
    protected IG500BL ig500BL;
    /**���̲����߶���ҵ���߼�����BL*/
   	protected IG560BL ig560BL;
	/** �����鶨�幦��BL */
   	protected IG480BL ig480BL;
   	
	/**
	 * @param ig480bl the �����鶨�幦��BL to set
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}
	/**
	 * @param ig560bl the ig560BL to set
	 */
	public void setIg560BL(IG560BL ig560bl) {
		ig560BL = ig560bl;
	}
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	/**
	 * �������������ڵ㣨��һҳ���������һ������ť�¼�
	 * @param WorkFlowStatusEventBeanInfo bean
	 * @throws BLException
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========Ԥ����������𱣴水ť����ʼ========");
		log.info("========Ԥ����������𱣴水ť����ʼ========");
		//��һ������������ʵ����Ϣ
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
		//��������
		String prtitle = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
		//Ԥ������
		String pddesc = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
		//����Ӧ�����ò���
		String stepPdid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "����Ӧ�����ò���");
		//ԭ��������prid
		String oprid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "���峡������ID");
		//��������
		String scenetype = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
		if(StringUtils.isNotEmpty(scenetype)&&"��һ����".equals(scenetype)){
			//������������ >-����Ӧ�����ò���pdidΪ��
			if(StringUtils.isEmpty(stepPdid)){
				//���stepPdidΪ�� ��Ϊ�������̵ĵ�һ��
				// ��ѯ����ģ����Ϣ
				IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(22);
				// ��ȡ���̶���ID
				String pdid = workFlowDefinitionBL.getProcessDefinitionPK(pt.getFirstsite(),pt.getPdsequence());
				// �趨���̶��������Ϣ
				IG380TB ptTB = new IG380TB(); 
				ptTB.setPdid(pdid); // ���̶���ID
				ptTB.setPtid(22); // ģ��ID
				ptTB.setPdname(prtitle); // Ԥ������
				ptTB.setPddesc(pddesc); // Ԥ������
				ptTB.setPdcrtdate(IGStringUtils.getCurrentDate()); // ����ʱ��
				ptTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE); // ���̶���״̬��Ĭ��Ϊͣ��
				ptTB.setPermission("0");
				String newXml = "<WebFlow><BaseProperties flowId=\"0133301\" flowText=\"asdf\"/><Steps><Step><BaseProperties id=\"0133301001\" text=\"������\" stepType=\"BeginStep\"/><BasicInfo psdid=\"0133301001\" pdid=\"0133301\" psdname=\"������\" psddesc=\"����Ĭ�Ͽ�ʼ״̬\" psdcode=\"Z\" psdtype=\"0\" psdmode=\"1\" psdflag=\"0\" psdconfirm=\"0\" bysequence=\"01\"/><VMLProperties width=\"50\" height=\"80\" x=\"732px\" y=\"444px\"/></Step><Step><BaseProperties id=\"0133301002\" text=\"�ر�\" stepType=\"EndStep\"/><BasicInfo psdid=\"0133301002\" pdid=\"0133301\" psdname=\"�ر�\" psddesc=\"����Ĭ�Ͻ���״̬\" psdcode=\"C\" psdtype=\"0\" psdmode=\"1\" psdflag=\"0\" psdconfirm=\"0\"/><VMLProperties width=\"50\" height=\"80\" x=\"732px\" y=\"444px\"/></Step></Steps><Actions/></WebFlow>";
				ptTB.setPdxml(newXml);
				ptTB.setMessagegenerator("igDRMMESSAGE0001BL");
				// �ȼ����̶���
				workFlowDefinitionBL.registProcessDefinition(ptTB);
				// �趨���̱�������
				IG243TB ptdTB = new IG243TB();
				ptdTB.setPtdid(workFlowDefinitionBL.getProcessTitleDefPK(pdid)); // ����
				ptdTB.setPdid(pdid); // ���̶���ID
				ptdTB.setPtitlename("�¼�����"); // �������ʾ����
				ptdTB.setPtitleaccess("0"); // ������Ƿ�ɼ�
				ptdTB.setPdescname("�¼�����"); // ��������ʾ����
				ptdTB.setPdescaccess("0"); // �������Ƿ�ɼ�
				// �������̱�����Ϣ
				workFlowDefinitionBL.registProcessTitleDef(ptdTB);
				// �趨����Ĭ�Ͽ�ʼ�ڵ�
				IG333TB psdStartTB = new IG333TB();
				psdStartTB.setPsdid(workFlowDefinitionBL.getProcessStatusDefPK(pdid));//����
				psdStartTB.setPdid(pdid);//���̶���ID
				psdStartTB.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);//��ʼ״̬
				psdStartTB.setPsdtype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL);//��ͨ�ڵ�
				psdStartTB.setPsddesc(IGPRDCONSTANTS.PROCESS_START_STATUS_DESC);//˵��
				psdStartTB.setPsdname(IGPRDCONSTANTS.PROCESS_START_STATUS_LABEL);//��ʼ״̬��ʾ����
				psdStartTB.setPsdmode(IGPRDCONSTANTS.MODE_NORMAL);//��ͨģʽ
				psdStartTB.setPsdflag(IGPRDCONSTANTS.NOT_NEED_ASSIGN); //��ʼ״̬�Ƿ�ɷ�����"��"
				psdStartTB.setPsdconfirm(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_NO);//��ȷ��״̬
				psdStartTB.setBysequence("01");
				//����״̬������Ϣ�ǼǴ���
				workFlowDefinitionBL.registProcessStatus(psdStartTB);
				
				// �趨����Ĭ�Ϲرսڵ�
				IG333TB psdEndTB = new IG333TB();
				psdEndTB.setPsdid(workFlowDefinitionBL.getProcessStatusDefPK(pdid));//����
				psdEndTB.setPdid(pdid);//���̶���ID
				psdEndTB.setPsdcode(IGPRDCONSTANTS.PROCESS_END_STATUS);//����״̬
				psdEndTB.setPsdtype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL);//��ͨ�ڵ�
				psdEndTB.setPsddesc(IGPRDCONSTANTS.PROCESS_END_STATUS_DESC);//˵��
				psdEndTB.setPsdname(IGPRDCONSTANTS.PROCESS_END_STATUS_LABEL);//����״̬��ʾ����
				psdEndTB.setPsdmode(IGPRDCONSTANTS.MODE_NORMAL);
				psdEndTB.setPsdflag(IGPRDCONSTANTS.NOT_NEED_ASSIGN); //�Ƿ�ɷ�����"��"
				psdEndTB.setPsdconfirm(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_NO);//��ȷ��״̬
				// ����״̬������Ϣ�ǼǴ���
				workFlowDefinitionBL.registProcessStatus(psdEndTB);
				//�趨Ĭ�ϵı�->"��������"��"������"��"����"
				
				try{
					creatFormList(pdid);
				}catch(Exception e){
					throw new BLException("IGCO10000.E141","���ɱ���Ϣ����!");
				}
				
				// �����̶���ID�趨��������
				PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
				ppivInfo.setFormname("����Ӧ�����ò���");
				ppivInfo.setFormvalue(pdid);
				flowSetBL.setPublicProcessInfoValue(ppivInfo);
				// �趨�Զ��崦��ҳ
				IG126TB pjdTB = new IG126TB();
				pjdTB.setPjdid(workFlowDefinitionBL.getProcessJspDefPK(pdid));
				pjdTB.setPdid(pdid);
				pjdTB.setPjdtype("2");
				pjdTB.setPjdurl("/drm/IGDRM0110.jsp");
				workFlowDefinitionBL.registProcessJspDef(pjdTB);
			}else{
				//��������>����
				String newPdid = workFlowDefinitionBL.copyProcessDefVersion(stepPdid);
				// �����̶���ID�趨��������
				PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
				ppivInfo.setFormname("����Ӧ�����ò���");
				ppivInfo.setFormvalue(newPdid);
				flowSetBL.setPublicProcessInfoValue(ppivInfo);
				// �������̶���״̬Ϊ����-��������
		    	IG380Info pdInfo = workFlowDefinitionBL.searchProcessDefinitionByKey(newPdid);
		    	IG380TB pdTB = (IG380TB) SerializationUtils.clone(pdInfo);
		    	pdTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE);
		    	workFlowDefinitionBL.updateProcessDefinition(pdTB);
		    	//ԭӦ����Դ�ʲ�ID
				String oldEiid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "ԭӦ����Դ�ʲ�ID");
				//����ԭ �ʲ���-Ӧ����Դ��ig731����
				if(!"".equals(oldEiid)){
					flowSetBL.setProcessEntityRelation(bean.getLogInfo().getPrid(), "Ӧ����Դ", Integer.valueOf(oldEiid), null);
				}
				//ԭ����-Ӧ����Դ�ʲ�List
				List<ProcessInfoEntityInfo> piList = flowSearchBL.searchProcessEntityItem(Integer.valueOf(oprid), "Ӧ����Դ");
				//ԭӦ����Դ�ʲ�ID
				//String oldEiidStr = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "ԭӦ����Դ�ʲ�ID");
				//Eiversion(Eiid
				//String[] oldEiidArr = oldEiidStr.split("_");
				//����ԭ �ʲ���-Ӧ����Դ��ig731����
				if(null!=piList){
					for(ProcessInfoEntityInfo piInfo : piList){
						//Ӧ����Դ��Ϣ
						EntityItemInfo eiInfo = flowSearchBL.searchEntityItem(piInfo.getEiid());
						//�����������̺�Ӧ����Դ�ʲ�������ϵ
						flowSetBL.setProcessEntityRelation(bean.getLogInfo().getPrid(), "Ӧ����Դ", piInfo.getEiid(), eiInfo.getEiversion());
					}	
				}
				
			}
		}else if(StringUtils.isNotEmpty(scenetype)&&"��ϳ���".equals(scenetype)){
			if(StringUtils.isEmpty(stepPdid)){
				// ��ѯ����ģ����Ϣ
				IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(22);
				// ��ȡ���̶���ID
				String pgdid = workFlowDefinitionBL.getProcessDefinitionPK(pt.getFirstsite(),pt.getPdsequence());
				//�����鶨��id
				IG480TB ig480TB = new IG480TB();
				ig480TB.setPgdid(pgdid);
				ig480TB.setPgdname(prtitle);//��ϳ�������
				ig480TB.setPgddesc(pddesc);//��ϳ�������
				ig480TB.setPgdcrtime(IGStringUtils.getCurrentDate()); // ����ʱ��
				ig480TB.setPgdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE); // ���̶���״̬��Ĭ��Ϊͣ��
				ig480TB.setPtid(22);
				//xml��֯��ʽ
				//��ʼ��֯����
				StringBuffer jsonTemp = new StringBuffer("<GroupFlow ");
				jsonTemp.append(" contentHeight= \""+400+"\">");
				jsonTemp.append(" <BaseProperties pgdid= \""+pgdid+"\"");
				jsonTemp.append(" pgdname=  \""+prtitle+"\"/>");
				jsonTemp.append("<WebFlows>");
				//��֯��β����
				//��֯��β����
				jsonTemp.append("</" + "WebFlows>");
				jsonTemp.append("<FlowActions>");
				jsonTemp.append("</FlowActions>");
				jsonTemp.append("</GroupFlow>");
				ig480TB.setPgdxml(jsonTemp.toString());
				ig480BL.registIG480(ig480TB);
				// �����̶���ID�趨��������
				PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
				ppivInfo.setFormname("����Ӧ�����ò���");
				ppivInfo.setFormvalue(pgdid);
				flowSetBL.setPublicProcessInfoValue(ppivInfo);
			}else{
				//��ϳ�������>����
				String newPdid = workFlowDefinitionBL.copyGroupProcessDefVersion(stepPdid);
				// �����̶���ID�趨��������
				PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
				ppivInfo.setFormname("����Ӧ�����ò���");
				ppivInfo.setFormvalue(newPdid);
				flowSetBL.setPublicProcessInfoValue(ppivInfo);
				// �������̶���״̬Ϊ����-��������
		    	IG480Info pdInfo = workFlowDefinitionBL.searchGroupProcessDefinitionByKey(newPdid);
		    	IG480TB pdTB = (IG480TB) SerializationUtils.clone(pdInfo);
		    	pdTB.setPgdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE);
		    	workFlowDefinitionBL.updateGroupProcessDefinition(pdTB);
		    	//ԭӦ����Դ�ʲ�ID
				String oldEiid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "ԭӦ����Դ�ʲ�ID");
				//����ԭ �ʲ���-Ӧ����Դ��ig731����
				if(!"".equals(oldEiid)){
					flowSetBL.setProcessEntityRelation(bean.getLogInfo().getPrid(), "Ӧ����Դ", Integer.valueOf(oldEiid), null);
				}
				//ԭ����-Ӧ����Դ�ʲ�List
				List<ProcessInfoEntityInfo> piList = flowSearchBL.searchProcessEntityItem(Integer.valueOf(oprid), "Ӧ����Դ");
				//����ԭ �ʲ���-Ӧ����Դ��ig731����
				if(null!=piList){
					for(ProcessInfoEntityInfo piInfo : piList){
						//Ӧ����Դ��Ϣ
						EntityItemInfo eiInfo = flowSearchBL.searchEntityItem(piInfo.getEiid());
						//�����������̺�Ӧ����Դ�ʲ�������ϵ
						flowSetBL.setProcessEntityRelation(bean.getLogInfo().getPrid(), "Ӧ����Դ", piInfo.getEiid(), eiInfo.getEiversion());
					}	
				}
			}
		}else{
			//��������ûȡ��
		}
		//������������title����-ig500
		IG500TB prTB = (IG500TB)SerializationUtils.clone(ig500Info);
		prTB.setPrtitle(prtitle);
		ig500BL.updateIG500Info(prTB);
		
	}
	
	
	/**
	 * ����״̬��
	 * @param pdid
	 */
	@SuppressWarnings("unchecked")
	private void creatFormList(String pdid)throws Exception{
			log.info("==========��ȡ״̬����Ϣ��ʼ=============");
			try{
				File xml = new File(getAbsolutePathByClass()+"WEB-INF/prrxml/formDef.xml");
				SAXBuilder builder = new SAXBuilder();  
		          
		        org.jdom.Document doc = builder.build(xml);  
		        Element element = doc.getRootElement();
		        List<Element> elArr =  element.getChildren();
		        
				for (int i = 0; i < elArr.size(); i++) {
					Element el = elArr.get(i);
					// �趨Ĭ�ϱ�"����"
					IG007TB attTB = new IG007TB();
					attTB.setPidid(workFlowDefinitionBL.getProcessInfoDefPK(pdid));
					attTB.setPdid(pdid);
					el.getAttributeValue("pidname");
					attTB.setPidname(el.getAttributeValue("pidname"));
					attTB.setPidlabel(el.getAttributeValue("pidname"));
					attTB.setPidtype(el.getAttributeValue("pidtype"));
					attTB.setPiddefault("");
					attTB.setPidrequired("0");
					attTB.setPidsortid(StringUtils.leftPad(String.valueOf(i), 2, "0"));
					attTB.setPidmode("2");
					attTB.setHasattach("N");
					attTB.setRowwidth("0");
					attTB.setPidwidth(0);
					attTB.setPidrows(0);
					attTB.setShowrownum("Y");
					attTB.setShowline("1");
					attTB.setRemarks("0");
					attTB.setShowstyles("0");
					attTB.setTitledisplay("L");
					attTB.setNeedidea("N");
					attTB.setPidratio("3_5");
					attTB.setPidsize(0);
					attTB.setSelecedlast("N");
					attTB.setNumbertype("0");
//					if(el.getAttributeValue("optarr")!=null)
					attTB.setPidoption(el.getAttributeValue("optarr"));
					attTB.setPiduse(el.getAttributeValue("isuse"));
					workFlowDefinitionBL.registProcessInfoDef(attTB);
					
				}
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
			log.info("==========��ȡ״̬����Ϣ����=============");
	}

	/**
	 * ͨ����·����ȡ����·��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAbsolutePathByClass(){
		String webPath = this.getClass().getResource("").getPath().replaceAll("^\\/", "");
		webPath = webPath.substring(0,webPath.indexOf("/com/"));
		webPath = webPath.replaceAll("[\\\\\\/]WEB-INF[\\\\\\/]classes[\\\\\\/]?", "/");
		webPath = webPath.replaceAll("[\\\\\\/]+", "/");
		webPath = webPath.replaceAll("%20", " ");
		if (webPath.matches("^[a-zA-Z]:.*?$")) {

		} else {
			webPath = "/" + webPath;
		}
		webPath += "/";
		webPath = webPath.replaceAll("[\\\\\\/]+", "/");
		return webPath;
	}
	
	public static void main(String[] args) {
		IGDRMBTN0101BLImpl a = new IGDRMBTN0101BLImpl();
		System.out.println(a.getAbsolutePathByClass());
	}
}
