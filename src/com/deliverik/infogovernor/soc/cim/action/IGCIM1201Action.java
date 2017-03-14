/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.cim.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM12BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM12DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1202Form;
import com.deliverik.infogovernor.sym.vo.IGSYM12011VO;

/**
 * @Description: ������Ϣ����CODEDETAIL�����Ϣ��ɵ�����Action
 * @Author  
 * @History 2009-8-18     �½� 
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 * @Version V2.0
 */
public class IGCIM1201Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM1201Action.class);
	
	/**
	 * <p>
	 * Description: ������Ϣ����CODEDETAIL�����Ϣ��ɵ�����Action
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @History 2010-5-07     0000428: ���ӻ������Թ���
	 */

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡBL�ӿ�ʵ��
		IGCIM12BL ctlBL = (IGCIM12BL) getBean("igcim12BL");
		//ʵ����DTO
		IGCIM12DTO dto = new IGCIM12DTO();
	
		if("ENTITYTREE03".equals(mapping.getParameter())){
			IGCIM1202Form form = new IGCIM1202Form();
			if(request.getParameter("levelnode")!=null){
				if("999".equals(request.getParameter("levelnode"))){
					form.setEparcoding(request.getParameter("levelnode"));
				}
				form.setEsyscoding_tree(request.getParameter("levelnode"));

			}
			form.setEkey1(EntityItemKeyWords.ENTITY_EKEY1_0);//����ģ�����ʲ�������ʾ�����أ�ʹ��entity����Ԥ���ֶ�EKEY1��0������ʾ��1��������
			//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			dto.setIgcim1202form(form);
			String treetype = request.getParameter("treetype");
			String attribute_name="ENTITYTREE03_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM12011VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchEntityTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM12011VO>setVO(request, vo);
			}
		}
		
		return mapping.findForward("DISP");
	}
	
}
