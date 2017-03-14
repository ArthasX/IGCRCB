package com.deliverik.infogovernor.rdp.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.infogovernor.rdp.bl.IGRDP01BL;
import com.deliverik.infogovernor.rdp.dto.IGRDP01DTO;
import com.deliverik.infogovernor.rdp.form.IGRDP0101Form;
import com.deliverik.infogovernor.rdp.vo.IGRDP01011VO;

/**
 * ����IGCamԶ�̲���Demo
 * @author Wang.xing
 * 2014.04.16
 */
public class IGRDP0101Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGRDP0101Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IGRDP01BL ctlBL = (IGRDP01BL) getBean("igrdp01BL");
		IGRDP01DTO dto = new IGRDP01DTO();
		IGRDP0101Form igrdp0101Form = (IGRDP0101Form)form;
		
		String forward = "DISP";
		
		//��ȡҵ��ϵͳ�б�
		dto = ctlBL.getBusinessSystems(dto);
		List<SOC0124Info> businessSystems = dto.getBsms();
		request.getSession().setAttribute("bsms", businessSystems);
		
		//��������Ǽǻ���
		if("DISP".equals(mapping.getParameter())){
			log.debug("=================��������Ǽǻ��濪ʼ=================");
			
			IGRDP01011VO vo = new IGRDP01011VO();
			if(businessSystems != null && businessSystems.size() != 0){
				SOC0124Info bsm = businessSystems.get(0);
				dto.setBsmid(bsm.getEiid());
				dto = ctlBL.getHostsBySystemID(dto);
				vo.setHosts(dto.getHosts());
			}

			super.<IGRDP01011VO>setVO(request, vo);
			
			log.debug("=================��������Ǽǻ������=================");
		}else if("RDP".equals(mapping.getParameter())){
			log.debug("========Զ�̲�����ʼ========");
			
			String taskid = request.getParameter("taskid");
			dto.setTaskID(Integer.parseInt(taskid));
			dto = ctlBL.remoteDeploy(dto);
			
			request.setAttribute("taskid", taskid);
			log.debug("========Զ�̲��������========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========��������ǼǴ���ʼ========");
			
			dto.setIgrdp0101Form(igrdp0101Form);
			
			dto = ctlBL.insertTaskAndResults(dto);
			
			log.debug("========��������ǼǴ������========");
		}else if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){

			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGRDP0101");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//Ӧ�ò�ѯ����
			log.debug("========���������ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				igrdp0101Form = (IGRDP0101Form) request.getSession().getAttribute("IGRDP0101Form");
				if ( igrdp0101Form == null){
					igrdp0101Form = new IGRDP0101Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(igrdp0101Form.getFromCount());
					} else {
						igrdp0101Form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					igrdp0101Form = (IGRDP0101Form) request.getSession().getAttribute("IGRDP0101Form");
					if (igrdp0101Form !=null) {
						igrdp0101Form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGRDP0101");
			
			dto.setIgrdp0101Form(igrdp0101Form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto.setBsms((List<SOC0124Info>)request.getSession().getAttribute("bsms"));
			
			//Ӧ�ü����߼�����
			dto = ctlBL.searchTasks(dto);
			
			//��Ӧ����Ϣ��������趨��VO��
			IGRDP01011VO vo = new IGRDP01011VO();
			vo.setTasks(dto.getTasks());
			
			super.<IGRDP01011VO>setVO(request, vo);
			
			log.debug("========���������ѯ��������========");
		
		} else if("getHostByAjax".equals(mapping.getParameter())){
			PrintWriter out = null;
			try {
				String bsmid = request.getParameter("bsmid");
				if(StringUtils.isNotEmpty(bsmid)){
					dto.setBsmid(Integer.parseInt(bsmid));
					dto = ctlBL.getHostByAjax(dto);
				}
				out = new PrintWriter( new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				out.print(dto.getResultsStr());
			} catch(Exception e){
				e.printStackTrace();
			} finally{
				out.flush();
				out.close();
			}
			
			log.debug("========ajax���������ѯ�������========");
			return null;
		}
		
		return mapping.findForward(forward);
	}

}
