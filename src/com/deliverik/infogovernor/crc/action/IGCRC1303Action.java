/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC13BL;
import com.deliverik.infogovernor.crc.dto.IGCRC1301DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1303DTO;
import com.deliverik.infogovernor.crc.form.IGCRC1301Form;
import com.deliverik.infogovernor.crc.form.IGCRC1303Form;
import com.deliverik.infogovernor.crc.vo.IGCRC1301VO;
import com.deliverik.infogovernor.crc.vo.IGCRC1303VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ĵ���Ϣ��ѯAction
 * </p>
 * 
 * @author ʷ����@deliverik.com
 * @version 1.0
 */
public class IGCRC1303Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC1303Action.class);
	
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

		log.debug("================�ĵ�����ͳ��Action��ʼ=============");
		IGCRC1303Form form = (IGCRC1303Form)actionForm;
		
		IGCRC13BL igcrc13bl = (IGCRC13BL)getBean("igcrc13bl");
		
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		IGCRC1303DTO dto = new IGCRC1303DTO();
		
		dto.setUser(user);
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("=================�ĵ�����ͳ�ƴ���ʼ===============");
			PagingDTO pDto = getPaginDTO(request, "IGCRC1303");
			
			int maxCnt = getMaxDataCount("IGCRC1303");
			
			dto.setIgcrc1303Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = igcrc13bl.searchEntitySumAction(dto);

			//����VO
			IGCRC1303VO vo = new IGCRC1303VO();
			vo.setIgcrc1303VWList(dto.getEntityItemVWInfoList());
			vo.setListVM(dto.getListVM());
			//ͳ���ĵ�����
			int sum1 = 0 ;
			int sum2 = 0 ; 
			int sum3 = 0;
			for(int i =0;i<dto.getListVM().size();i++){
//				sum1 += dto.getListVM().get(i).getReadSum();
//				sum2 += dto.getListVM().get(i).getDowSum();
				sum3 += dto.getListVM().get(i).getWordSum();	
			}
//			vo.getListSum().add(sum3);
	//		vo.getListSum().add(sum2);
			vo.getListSum().add(sum3);
			
			request.getSession().setAttribute("isManager", dto.getIsManeger()==null?"0":dto.getIsManeger());
			super.<IGCRC1303VO>setVO(request, vo);
			
			log.debug("=================�ĵ�����ͳ�ƴ������===============");
		}else if("SEARCH".equals(mapping.getParameter())){
			
			IGCRC1301Form form1301 = new IGCRC1301Form();
			IGCRC1301DTO dto1301 = new IGCRC1301DTO();
			dto1301.setUser(user);
			String type = request.getParameter("type");
			
			PagingDTO pDTO = getPaginDTO(request,"IGCRC1301");
			
			int maxCnt = getMaxDataCount("IGCRC1301");
			
			dto1301.setIgcrc1301Form(form1301);
			
			dto1301.setMaxSearchCount(maxCnt);
			
			dto1301.setPagingDto(pDTO);
			
			dto1301.setType(type);
			//����BL��ѯ 
			dto1301 = igcrc13bl.searchItemAction(dto1301);
			//����VO
			IGCRC1301VO vo = new IGCRC1301VO();
			vo.setIgcrc1301VWList(dto1301.getEntityItemVWInfoList());
			super.<IGCRC1301VO>setVO(request, vo);
			log.debug("========�ĵ���Ϣ��ѯ��������========");
		}
		log.debug("================�ĵ�����ͳ��Action����=============");
		return mapping.findForward("DISP");
	}
}
