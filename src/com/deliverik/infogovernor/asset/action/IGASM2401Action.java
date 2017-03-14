package com.deliverik.infogovernor.asset.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.asset.EntityCategory;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM24BL;
import com.deliverik.infogovernor.asset.dto.IGASM24DTO;
import com.deliverik.infogovernor.asset.form.IGASM2401Form;
import com.deliverik.infogovernor.asset.vo.IGASM24011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * ��Ʊ��ѯ����Action����
 *
 */
public class IGASM2401Action extends BaseAction {

    static Log log = LogFactory.getLog(IGASM2401Action.class);

    /**
     * �¼�����
     *
     * @param mapping 
     * @param actionForm 
     * @param req 
     * @param res 
     * @return 
     * @throws Exception 
     */
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
        //FORMȡ��
        IGASM2401Form form = (IGASM2401Form)actionForm;
        
        //BLȡ��
        IGASM24BL ctlBL = (IGASM24BL) getBean("igasm24BL");
        if(form == null){
            form = new IGASM2401Form();
        }
        form.setEiorgsyscoding(DefineUtils.DEFAULT_ORGNO);//Ĭ�϶��������
        form.setEsyscoding("999014");//��Ʊ�ʲ������
        form.setQueryflag("0");
        //DTO����
        IGASM24DTO dto = new IGASM24DTO();
        req.getSession().setAttribute("DEFAULT_ORGNO", DefineUtils.DEFAULT_ORGNO);
        if( "DISP".equals(mapping.getParameter())){
            //��Ʊ��ѯ���������ʾ����
            log.debug("========��Ʊ��ѯ���������ʾ����ʼ========");
            
            //***************************************************************************
            //���ͷ���(��Ʊ)�趨
            form = new IGASM2401Form();
            form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_INVOICE);
            form.setQueryflag("0");
            req.setAttribute("IGASM2401Form", form);
            
            User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
            dto.setUser(user);
            dto = ctlBL.checkEntityItemDomain(dto);
            
            if(EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE))) {
                req.getSession().setAttribute("ADmode", EntityCategory.ENTITYITEM_PERMISSION_MODE_A);
            } else {
                req.getSession().setAttribute("ADmode", EntityCategory.ENTITYITEM_PERMISSION_MODE_B);
            }
            //�����ģʽA���Ǹ����ˣ���Ȩ�����
            if(dto.getFlag() && EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE))) {
                req.setAttribute("deforgsys", dto.getOrgsyscoding());
                req.setAttribute("deforgname", dto.getOrgname());
                req.setAttribute("defassetsys", "_" + dto.getEsyscoding());
                req.setAttribute("defassetname", dto.getEname());
                req.getSession().setAttribute("ADrolemanager", "true");
                
            }else {
                //���ó�ʼȨ����
                IGSYM03DTO sym03dto = new IGSYM03DTO();
                IGSYM03BL treeBL = (IGSYM03BL) getBean("igsym03BL");
                String roletype = req.getParameter("roletype")==null?"IGAC10":req.getParameter("roletype");
                sym03dto = treeBL.getRoleDomainTree(sym03dto, roletype, user);
                Map<String,TreeNode> treeNodeMap = sym03dto.getTreeNodeMap();
                if(treeNodeMap!=null&&!treeNodeMap.isEmpty()){          
                    if(treeNodeMap.keySet()!=null&&!treeNodeMap.keySet().isEmpty()){
                            Iterator<String> it=treeNodeMap.keySet().iterator();
                            while(it.hasNext()){
                                Object obj = it.next();
                                String key=(String)obj; 
                                TreeNode treeNode=(TreeNode)treeNodeMap.get(key);
                                req.setAttribute("deforgsys", treeNode.getId());
                                req.setAttribute("deforgname", treeNode.getName());
                                break;
                            }
                            
                    }
                }
                
                
                //���ó�ʼ�ʲ�����������
                IGSYM03DTO sym03dto1 = new IGSYM03DTO();
                IGSYM03BL treeBL1 = (IGSYM03BL) getBean("igsym03BL");
                sym03dto1.setSubtype(CommonDefineUtils.ENTIY_CATEGORY_INVOICE_SYSCODING);
                String roletype1 = req.getParameter("roletype")==null?"IGAC10":req.getParameter("roletype");
                sym03dto1 = treeBL1.getAssetDomainTree(sym03dto1, roletype1, user);
                Map<String,TreeNode> treeNodeMap1 = sym03dto1.getTreeNodeMap();
                if(treeNodeMap1!=null&&!treeNodeMap1.isEmpty()){            
                    if(treeNodeMap1.keySet()!=null&&!treeNodeMap1.keySet().isEmpty()){
                            Iterator<String> it=treeNodeMap1.keySet().iterator();
                            while(it.hasNext()){
                                Object obj = it.next();
                                String key=(String)obj; 
                                TreeNode treeNode=(TreeNode)treeNodeMap1.get(key);
                                req.setAttribute("defassetsys", treeNode.getId());
                                req.setAttribute("defassetname", treeNode.getName());
                                break;
                            }
                            
                    }
                }
            }
            //***************************************************************************
            
            addMessage(req, new ActionMessage("IGCO10000.I003"));
            log.debug("========��Ʊ��ѯ���������ʾ��������========");
            return mapping.findForward("DISP");
        } else if("REDISP".equals(mapping.getParameter())){
            //��Ʊ��ѯ��������ʾ����
            log.debug("========��Ʊ��ѯ��������ʾ����ʼ========");
            addMessage(req, new ActionMessage("IGCO10000.I003"));
            log.debug("========��Ʊ��ѯ��������ʾ��������========");
            return mapping.findForward("DISP");
        }   

        if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
            //��ҳ��DTOȡ��
            getPaginDTO(req,"IGASM2401");
            
            PagingDTO pDto;
            
            pDto = (PagingDTO)req.getAttribute("PagingDTO");
            //��Ʊ��ѯ����
            log.debug("========��Ʊ��ѯ����ʼ========");
            if ("SEARCH1".equals(mapping.getParameter())){
                //����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
                form = (IGASM2401Form) req.getSession().getAttribute("IGASM2401Form");
                if ( form== null){
                    form = new IGASM2401Form();
                    form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_INVOICE);
                    form.setQueryflag("0");
                }else {
                    if (req.getParameter("PAGING") == null) {
                        pDto.setFromCount(form.getFromCount());
                    } else {
                        form.setFromCount(pDto.getFromCount());
                    }
                }
            } else {
                if (req.getParameter("PAGING") == null) {
                    pDto.setFromCount(0);
                    form = (IGASM2401Form) req.getSession().getAttribute("IGASM2401Form");
                    form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_INVOICE);
                    if (form !=null) {
                        form.setFromCount(0);
                    }
                }
            }
            //��ѯ��¼������ȡ��
            int maxCnt = getMaxDataCount("IGASM2401");
            
            //DTO��������趨
            dto.setEntityItemVWSearchCond(form);
            
            dto.setMaxSearchCount(maxCnt);
            
            dto.setPagingDto(pDto);
            
            //��Ʊ�����߼�����
            dto = ctlBL.searchEntityItemAction(dto);
            
            //����Ʊ��Ϣ��������趨��VO��
            IGASM24011VO vo = new IGASM24011VO(dto.getEntityItemVWInfoList());
            
            super.<IGASM24011VO>setVO(req, vo);
            
            log.debug("========��Ʊ��ѯ��������========");
        }
        if ("DELETE".equals(mapping.getParameter())){
            //��Ʊɾ������
            log.debug("========��Ʊɾ������ʼ========");
            
            //DTO��������趨
            dto.setDeleteEntityItem(form.getDeleteEiid());
            
            //��Ʊ��Ϣɾ���߼�����
            ctlBL.deleteEntityItemAction(dto);
            
            log.debug("========��Ʊɾ����������========");
        }
        
        //�߼���������е���Ϣ��ʾ
        List<ActionMessage> messageList = dto.getMessageList();
        
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(req, message);
            }
            
        }

        return mapping.findForward("DISP");
    }
}
