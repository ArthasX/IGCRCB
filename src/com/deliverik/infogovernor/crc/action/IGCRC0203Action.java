/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.crc.bl.IGCRC0203ExcelBL;
import com.deliverik.infogovernor.crc.bl.IGCRC02BL;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC02ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC0203Form;
import com.deliverik.infogovernor.crc.form.IGCRC0204Form;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;
import com.deliverik.infogovernor.crc.model.vo.IGCRC0203VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �澯��Ϣ��ѯAction
 * </p>
 * 
 * @author changhao@deliverik.com
 * @version 1.0
 */
public class IGCRC0203Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCRC0203Action.class);
	
	/**
	 * <p>
	 * Description: ҳ���ѯaction����
	 * </p>
	 * 
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("================�澯��Ϣ��ѯAction��ʼ=============");
		
		//��ȡBL�ӿ�ʵ��
		IGCRC02BL crcBL = (IGCRC02BL)getBean("igcrc02bl");
		//ʵ����DTO
		IGCRC02DTO dto = new IGCRC02DTO();
		//��ת
		String forward = "";
		//��ɫ��Ȩ��ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========�澯��Ϣ��ѯ����ʼ========");
			//ʵ����FORM
			IGCRC0203Form form = (IGCRC0203Form)actionForm;
			
			int maxCnt = getMaxDataCount("IGSVC0201");
			//��ȡ��ҳBean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC0203");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGCRC0203Form) request.getSession().getAttribute("IGCRC0203Form");
				if ( form == null){
					form = new IGCRC0203Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDTO.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDTO.getFromCount());
					}
				}
			} else {
					if (request.getParameter("PAGING") == null) {
						pDTO.setFromCount(0);
						form = (IGCRC0203Form) request.getSession()
								.getAttribute("IGCRC0203Form");
						if (form != null) {
							form.setFromCount(0);
						}
					}
			}
			// �Ƿ���ʾ��ʶ(0��ʾ��1����ʾ)
			form.setIsShow("0");
			dto.setForm(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDTO(pDTO);
			//����BL��ѯ 
			crcBL.serachIgalarmSortList(dto);
			//����VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			
			//��������״̬(ֻ������һ�� ����ͬʱ������������ֻ��һ����ֵ������û��ֵΪnull����"")
			vo.setAppnamestatus(dto.getForm().getAppnamestatus());
			vo.setLasttimestatus(dto.getForm().getLasttimestatus());
			vo.setIpaddrstatus(dto.getForm().getIpaddrstatus());
			vo.setRecoverytimestatus(dto.getForm().getRecoverytimestatus());
			super.<IGCRC0203VO>setVO(request, vo);
			forward = "DISP";
			log.debug("========�澯��Ϣ��ѯ��������========");
		}else if("EDIT".equals(mapping.getParameter())){
			//ʵ����FORM
			IGCRC0204Form igcrc0204Form = (IGCRC0204Form)actionForm;
			IGCRC02DTO editDto = new IGCRC02DTO();
			editDto.setIgcrc0204Form(igcrc0204Form);
			//��ѯ�澯��Ϣ
			editDto = crcBL.searchIgalarmByPK(editDto);
			//����vo
			IGCRC0203VO vo = new IGCRC0203VO();
			//������Ϣ
			vo.setIgalarmInfo(editDto.getIgalarmInfo());
			super.<IGCRC0203VO>setVO(request, vo);
			forward = "EDIT";
		}else if("UPDATE".equals(mapping.getParameter())){
			//ʵ����FORM
			IGCRC0204Form igcrc0204Form = (IGCRC0204Form)actionForm;
			IGCRC02DTO updateDto = new IGCRC02DTO();
			updateDto.setIgcrc0204Form(igcrc0204Form);
			//����
			updateDto = crcBL.updateIgalarmByForm(updateDto);
			
			//��ȡ��ҳBean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC0203");
			int maxCnt = getMaxDataCount("IGCRC0203");
			dto.setForm(new IGCRC0203Form());
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDTO(pDTO);
			//����BL��ѯ 
			crcBL.serachIgalarmList(dto);
			//����VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			super.<IGCRC0203VO>setVO(request, vo);
			
			forward = "DISP";
		}else if("UPDATE1".equals(mapping.getParameter())){
			//ʵ����FORM
			IGCRC0204Form igcrc0204Form = (IGCRC0204Form)actionForm;
			IGCRC02DTO updateDto = new IGCRC02DTO();
			updateDto.setIgcrc0204Form(igcrc0204Form);
			//����
			updateDto = crcBL.updateIgalarmByForm(updateDto);
			IGCRC0203Form form = new IGCRC0203Form();
			form.setPedeventid(igcrc0204Form.getPedeventid());
			dto.setForm(form);
			//����BL��ѯ 
			crcBL.serachIgalarmList(dto);
			request.setAttribute("IGCRC0203Form", form);
			//����VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			super.<IGCRC0203VO>setVO(request, vo);
			forward = "DISP";
		}else if("DELETE".equals(mapping.getParameter())){
			//ʵ����FORM
			IGCRC0204Form igcrc0204Form = (IGCRC0204Form)actionForm;
			dto.setIgcrc0204Form(igcrc0204Form);
			String pk = request.getParameter("pk");
			if(StringUtils.isNotEmpty(pk)){
				//ɾ��ָ��id�澯
				String[] id = pk.split(",");
				for(int i=0;i<id.length;i++){
					if(StringUtils.isNotEmpty(pk)){
						dto.getIgcrc0204Form().setPk(Integer.parseInt(id[i]));
						crcBL.deleteIgalarmByPK(dto);
					}
				}
			}
			//��ȡ��ҳBean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC0203");
			int maxCnt = getMaxDataCount("IGCRC0203");
			IGCRC0203Form form = new IGCRC0203Form();
			form.setIsShow("0");
			dto.setForm(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDTO(pDTO);
			//����BL��ѯ 
			crcBL.serachIgalarmList(dto);
			//����VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			super.<IGCRC0203VO>setVO(request, vo);
			
			forward = "DISP";
		}else if("DELETE1".equals(mapping.getParameter())){
			//����ɾ��
			//ʵ����FORM
			IGCRC0204Form igcrc0204Form = (IGCRC0204Form)actionForm;
			dto.setIgcrc0204Form(igcrc0204Form);
			//ɾ��ָ��id�澯
			crcBL.deleteIgalarmByPK(dto);
			
			//��ȡ��ҳBean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC0203");
			int maxCnt = getMaxDataCount("IGCRC0203");
			dto.setForm(new IGCRC0203Form());
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDTO(pDTO);
			//����BL��ѯ 
			crcBL.serachIgalarmList(dto);
			//����VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			super.<IGCRC0203VO>setVO(request, vo);
			
			forward = "DISP";
		}else if("RELEVANCE".equals(mapping.getParameter())){
			
			//ʵ����FORM
			IGCRC0204Form igcrc0204Form = (IGCRC0204Form)actionForm;
			dto.setIgcrc0204Form(igcrc0204Form);
			//��ѯָ��id�澯��Ϣ
			dto = crcBL.searchIgalarmByPK(dto);
			//��¡�澯����
			IgalarmTB igalarmTB = (IgalarmTB)SerializationUtils.clone(dto.getIgalarmInfo());
			//���ɹ���
			igalarmTB.setIsCreateOrder("1");
			//��������
			igalarmTB.setIsShow("1");
			//��������id
			igalarmTB.setPedeventid(igcrc0204Form.getPedeventid());
			//���±���
			dto.setIgalarmInfo(igalarmTB);
			//������id���µ��澯��Ϣ��
			dto = crcBL.updateIgalarmByIgalarm(dto);
			//��ȡ��ҳBean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC0203");
			int maxCnt = getMaxDataCount("IGCRC0203");
			IGCRC0203Form igcrc0203Form =  new IGCRC0203Form();
			// �Ƿ���ʾ��ʶ(0��ʾ��1����ʾ)
			igcrc0203Form.setIsShow("0");
			dto.setForm(igcrc0203Form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDTO(pDTO);
			//����BL��ѯ 
			crcBL.serachIgalarmList(dto);
			//����VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			super.<IGCRC0203VO>setVO(request, vo);
			
			forward = "DISP";
		}else if( "Alarm".equals(mapping.getParameter())){
			log.debug("========�澯��ϸ��Ϣ��ѯ����ʼ========");
			//ʵ����FORM
			IGCRC0203Form form = (IGCRC0203Form)actionForm;
//			form.setPedeventid(request.getParameter("prserialnum"));
			// ��ѯ�澯��ϸʱ��ѯȫ��״̬
			form.setStatus("C");
			dto.setForm(form);
			
			//����BL��ѯ 
			crcBL.serachIgalarmList(dto);
			//����VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			
			super.<IGCRC0203VO>setVO(request, vo);
			forward = "DISP";
			log.debug("========�澯��Ϣ��ѯ��������========");
		}else if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("=====================�澯ϵͳ������ʼ=======================");
			IGCRC0203Form form = (IGCRC0203Form)actionForm;
			// �Ƿ���ʾ��ʶ(0��ʾ��1����ʾ)
			form.setIsShow("0");
			// DTO�����趨
			dto.setForm(form);
			// ����BL��ѯ
			crcBL.serachIgalarmList(dto);
			// ȡ��Excel����BL
			IGCRC0203ExcelBL excelBL = (IGCRC0203ExcelBL) getBean("igcrc0203ExcelBL");
			// ����excelDTO
			IGCRC02ExcelDTO excelDTO = new IGCRC02ExcelDTO();
			// ���Ҫ�����Ľ��
			excelDTO.setIgalarmInfos(dto.getIgalarmInfos());
			// ���ģ����
			excelDTO.setFileid("CRC0203");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================�澯ϵͳ��������=======================");
			forward = null;
		}
		
		return mapping.findForward(forward);
	}
}
