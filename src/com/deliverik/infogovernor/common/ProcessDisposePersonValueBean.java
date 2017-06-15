package com.deliverik.infogovernor.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG337Info;

public class ProcessDisposePersonValueBean {
	/** ��¼��־ */
	private static Log log = LogFactory.getLog(ProcessDisposePersonValueBean.class);
	
	/**
	 * <p>
	 * Description:���캯��
	 * </p>
	 */
	private ProcessDisposePersonValueBean() {

	}

	/**
	 * <p>
	 * Discription:��ʼ������
	 * </p>
	 * 
	 * @update byf
	 */
	private static String getProcessParticipants(List<IG337Info> pplist) {
	
		// δִ�����б�
		List<IG337Info> l2 = new ArrayList<IG337Info>();
		// δִ����Ա����
		Map<String, List<IG337Info>> m2 = new LinkedHashMap<String, List<IG337Info>>();
		// ������Ա�ַ���
		StringBuffer comment = new StringBuffer();
		appendLogTitleCssBegin(comment);
		// ��ִ�����ͷ���
		for (IG337Info pp : pplist) {
			// δִ�����б��ʼ��
			if (StringUtils.isEmpty(pp.getPpproctime())) {
				l2.add(pp);
			}
		}
		// ��δִ����Ա�����ŷ���
		for (IG337Info pp : l2) {
			if (m2.get(pp.getPprolename()) == null) {
				// �ò��Ų�����ʱ�Ĳ���
				List<IG337Info> l = new ArrayList<IG337Info>();
				l.add(pp);
				m2.put(pp.getPprolename(), l);
			} else {
				// �ò����Ѵ���ʱ�Ĳ���
				m2.get(pp.getPprolename()).add(pp);
			}
		}

		// ��δִ����Ա�����ַ���ƴ��
		if (null != m2 && m2.size() > 0) {
			// δִ�д����˲�Ϊ��ʱ�Ĵ���
			int idx = 0;
			for (String org : m2.keySet()) {
				if(idx > 0){
					comment.append(",");
				}
				idx ++;
				comment.append(org);
				comment.append("(");
				List<IG337Info> list = m2.get(org);
				for(int i=0;i<list.size();i++){
					IG337Info pp = list.get(i);
					if(i>0){
						comment.append("��");
					}
					String name = StringUtils.isEmpty(pp.getPpusername()) ? "δָ��":pp.getPpusername();
					comment.append(name);
				}
				// ��ƴ��ʱ����ı�㶪������
				comment.append(")");
			}
		}
		
		return comment.toString().replace("(null)", "(δָ��)").replaceAll(",", "<br/>");
//		return comment.toString().replace("(null)", "(δָ��)").replaceAll(",", "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	}
	
	/**
	 * <p>
	 * ��¼��־����ʽ��ƴ�ӿ�ʼ����ʱ�Ǽ�¼��Ա��Ϣʱ����
	 * </p>
	 * 
	 * @param massage ��־������Ϣ
	 * @return ����HTML��ǩ����־������Ϣ
	 */

	private static void appendLogTitleCssBegin(StringBuffer massage) {
		massage.append("<span>");
	}

	/**
	 * <p>
	 * Description: ��ȡ���̴�������Ϣ
	 * </p>
	 * 
	 * @param key
	 * @return String
	 * @update byf
	 */
	public static String getDisposePersonInfo(String prid,String prstatus) {
		log.debug("��������id������״̬��ѯ��ǰ״̬�����˿�ʼ");
		
		WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");
		
		List<IG337Info> pplist;
		
		String disposePerson="";
		try {
			List<String> statuses = workFlowOperationBL.searchCurrentRecordStatus(Integer.parseInt(prid));
			pplist = new ArrayList<IG337Info>();
			if(statuses != null){
				for(String str:statuses){
					prstatus = str.indexOf("_") >= 0 ? str.split("_")[0] : str;
					List<IG337Info> list = workFlowOperationBL.searchProcessParticipant(Integer.parseInt(prid), prstatus);
					if(!list.isEmpty()){
						pplist.addAll(list);
					}
				}
			}
			if(pplist.isEmpty() && !"C".equals(prstatus)){
				disposePerson="";
			} else {
				//״̬�����ߴ���
				disposePerson=getProcessParticipants(pplist);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			log.debug(e);
		} catch (BLException e) {
			e.printStackTrace();
			log.debug(e);
		}
		
		log.debug("��������id������״̬��ѯ��ǰ״̬�����˽���");
		
		return disposePerson;
	}

}
