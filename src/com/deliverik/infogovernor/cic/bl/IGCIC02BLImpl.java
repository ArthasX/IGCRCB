/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.cic.bl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.cic.bl.task.CompareobjectHistoryBL;
import com.deliverik.infogovernor.cic.bl.task.CompareprocessBL;
import com.deliverik.infogovernor.cic.bl.task.CompareresultBL;
import com.deliverik.infogovernor.cic.bl.task.CompareroleBL;
import com.deliverik.infogovernor.cic.dto.IGCIC02DTO;
import com.deliverik.infogovernor.cic.form.IGCIC0201Form;
import com.deliverik.infogovernor.cic.form.IGCIC0203Form;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectHistorySearchCondImpl;
import com.deliverik.infogovernor.cic.model.condition.CompareprocessSearchCondImpl;
import com.deliverik.infogovernor.cic.model.condition.CompareresultSearchCond;
import com.deliverik.infogovernor.cic.model.condition.CompareresultSearchCondImpl;
import com.deliverik.infogovernor.cic.model.condition.CompareroleSearchCondImpl;
import com.deliverik.infogovernor.cic.vo.IGCIC02022VO;
import com.deliverik.infogovernor.cic.vo.IGCIC02023VO;
import com.deliverik.infogovernor.cic.vo.IGCIC02032VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Ա�����ҵ���߼�ʵ��
 * </p>
 * 
 * @author 
 * @version 1.0
 */
public class IGCIC02BLImpl extends BaseBLImpl implements IGCIC02BL {

	static Log log = LogFactory.getLog(IGCIC02BLImpl.class);

	/** �Աȼ�¼ҵ���߼�BL */
	private CompareprocessBL compareprocessBL;
	
	/** �ȶԹ����BL */
	private CompareroleBL compareroleBL; 
	
	/** �ȶԶ�����ʷ�� */
	private CompareobjectHistoryBL compareobjectHistoryBL;
	
	/** �ȶԽ����BL */
	private CompareresultBL compareresultBL;
	
	private SOC0118BL soc0118BL;
	private SOC0117BL soc0117BL;
	
	
	
	
	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/** 
     * �Աȼ�¼ҵ���߼�BL �趨
     * @param compareprocessBL �Աȼ�¼ҵ���߼�BL 
     */
    public void setCompareprocessBL(CompareprocessBL compareprocessBL) {
        this.compareprocessBL = compareprocessBL;
    }

    /** 
     * �ȶԹ����BL �趨
     * @param compareroleBL �ȶԹ����BL 
     */
    public void setCompareroleBL(CompareroleBL compareroleBL) {
        this.compareroleBL = compareroleBL;
    }


    /** 
     * �ȶԶ�����ʷ�� �趨
     * @param compareobjectHistoryBL �ȶԶ�����ʷ�� 
     */
    public void setCompareobjectHistoryBL(CompareobjectHistoryBL compareobjectHistoryBL) {
        this.compareobjectHistoryBL = compareobjectHistoryBL;
    }

    /** 
     * �ȶԽ����BL �趨
     * @param compareresultBL �ȶԽ����BL 
     */
    public void setCompareresultBL(CompareresultBL compareresultBL) {
        this.compareresultBL = compareresultBL;
    }

    /**
	 * ��ѯ�ȶ�ִ�����
	 * 
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIC02DTO searchCompareProcessAction(IGCIC02DTO dto) throws BLException {
	    log.debug("================= ��ѯ�ȶ�ִ���������ʼ ==============");
	    
	    IGCIC0201Form form = dto.getIgcic0201Form();
	    
	    CompareprocessSearchCondImpl cond = new CompareprocessSearchCondImpl();
	    
	    BeanUtils.copyProperties(form, cond);
	    
        int totalCount = compareprocessBL.getSearchCount(cond);
        
        if (totalCount == 0) {
            log.debug("========��ѯ���ݲ�����========");
            // ��ѯ���ݲ�����
            dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
            return dto;
        }
        if (totalCount > dto.getMaxSearchCount()) {
            log.debug("========��ѯ���ݼ�������========");
            // ��ѯ���ݼ�������
            dto.addMessage(new ActionMessage("IGCO00000.E005", dto
                    .getMaxSearchCount(), totalCount));
            return dto;
        }
        
        //��ȡ��ҳbean
        PagingDTO pDto = dto.getPagingDto();
        
        List<CompareprocessInfo> list = compareprocessBL.searchCompareprocess(cond, pDto.getFromCount(), pDto.getPageDispCount());
        
        pDto.setTotalCount(totalCount);
        
        dto.setCompareprocessList(list);
        
	    log.debug("================= ��ѯ�ȶ�ִ������������ ==============");
	    return dto;
	}
	
	/**
	 * �ȶ�����鿴ҳ�� 
	 * 
	 * @param dto
	 * @return
	 */
	public IGCIC02DTO compareResultViewAction(IGCIC02DTO dto) throws BLException {
	    log.debug("================= �ȶԽ���鿴ҳ�洦��ʼ ==================");
	    
	    CompareroleSearchCondImpl crcond = new CompareroleSearchCondImpl();
	    crcond.setCpid(dto.getCpid());
	    
	    // ���ݹ�ϵ���ѯ����
        List<CompareroleInfo> compareroleList = compareroleBL.searchCompareroleByRelation(crcond);
        
        
        Map<String, List<IGCIC02022VO>> resultVoMap = new LinkedHashMap<String, List<IGCIC02022VO>>();
        
        // ���������ѯ�����Ӧ�Ķ���
        for (CompareroleInfo compareroleInfo : compareroleList) {
            List<IGCIC02022VO> volist = resultVoMap.get(compareroleInfo.getCrsystemname());
            if (null == volist) {
                volist = new ArrayList<IGCIC02022VO>();
            }
            IGCIC02022VO vo01 = new IGCIC02022VO();
            vo01.setCrsystemname(compareroleInfo.getCrsystemname());
            vo01.setCrtype(compareroleInfo.getCrtype());
            
            // ���ݹ����������汾��ѯ����
            CompareobjectHistorySearchCondImpl cohcond = new CompareobjectHistorySearchCondImpl();
            cohcond.setFkCrid_eq(compareroleInfo.getCrid());
//            cohcond.setCrversion_eq(compareroleInfo.getCrversion());
            
            List<CompareobjectHistoryInfo> list = compareobjectHistoryBL.searchCompareobjectHistory(cohcond);
            
            Map<String, List<IGCIC02023VO>> map = new HashMap<String, List<IGCIC02023VO>>();
            
            // �����ȶԶ���ƴװҳ����ʾ����
            for (CompareobjectHistoryInfo coinfo : list) {
                
                List<IGCIC02023VO> sourcelist = map.get(coinfo.getSourceIP());
                if (sourcelist == null) {
                    sourcelist = new ArrayList<IGCIC02023VO>();
                }
                
                // �Ƚ϶���VO
                IGCIC02023VO vo = new IGCIC02023VO();
                vo.setCoid(coinfo.getCoid());
                vo.setHostname(coinfo.getTargetIP());
                CompareresultSearchCondImpl cscond = new CompareresultSearchCondImpl();
                cscond.setCoid_eq(coinfo.getCoid());
                
                // ��ѯ�ȽϵĶ����Ƿ���ڲ�ͬ
                int count = compareresultBL.getSearchCount(cscond);
                // �Ƚ϶���ͬ
                if (count > 0) {
                    vo.setIsDifferent(IGCIC02BLType.COMPARERESULT_DIFFERENT);
                } 
                // ��ͬ
                else {
                    vo.setIsDifferent(IGCIC02BLType.COMPARERESULT_SAME);
                }
                sourcelist.add(vo);
                map.put(coinfo.getSourceIP(), sourcelist);
            }
            vo01.setCotargetVOLi(map);
            volist.add(vo01);
            resultVoMap.put(compareroleInfo.getCrsystemname(), volist);
        }
        
        dto.setResultVoMap(resultVoMap);
        
	    log.debug("================= �ȶԽ���鿴ҳ�洦��ʼ ==================");
	    return dto;
	}
	
	
	/**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public IGCIC02DTO searchObjectCompareresult(IGCIC02DTO dto) throws BLException {
        log.debug("============== ��ѯ����ȶԽ������ʼ ============");

        IGCIC0203Form form = dto.getIgcic0203Form();
        
        // ҳ����ʾ��Map key��ҳ����ʾ���� value����ʾ����Map key��ģ������ value�������б�
        Map<String, Map<String, IGCIC02032VO>> showmap =  new LinkedHashMap<String, Map<String, IGCIC02032VO>>();

        // ��ѯ�ȶԽ��
        CompareresultSearchCondImpl cscond  = new CompareresultSearchCondImpl();
        cscond.setCoid_eq(form.getCoid());
        List<Object[]> list = compareresultBL.getEnameList(cscond);
        for (Object[] objects : list) {
            showmap.put(objects[1].toString(), null);
        }
        
        // ��ѯ��������
        cscond.setIsBase(IGCIC02BLType.ATTRIBUTETYPE_BASE);
        showmap = assemblyData(showmap, cscond);
        
        // ��ѯ��������
        cscond.setIsBase(IGCIC02BLType.ATTRIBUTETYPE_OTHER);
        showmap = assemblyData(showmap, cscond);
        
        dto.setCic0203ShowMap(showmap);
        
        log.debug("============== ��ѯ����ȶԽ��������� ============");
        return dto;
    }

    private Map<String, Map<String, IGCIC02032VO>> assemblyData(Map<String, Map<String, IGCIC02032VO>> map, CompareresultSearchCond cscond ) throws BLException {
        
        List<CompareresultVWInfo> cslist = compareresultBL.searchCompareresultVW(cscond);
        
        // �����������ԱȶԽ������װҳ����ʾ������
        for (CompareresultVWInfo crVWInfo : cslist) {
            
            String pename = crVWInfo.getPename();// ��ģ������
            String eid = crVWInfo.getEid(); // ģ��id
            String ename = crVWInfo.getEname(); // ģ������
            String einame = crVWInfo.getEiname();
            // ȡ����ʾ����list
            Map<String, IGCIC02032VO> callmap = map.get(pename);
            if (callmap == null) {
                callmap = new LinkedHashMap<String, IGCIC02032VO>();
                map.put(pename, callmap);
            }
            
            // ģ����ʾ����
            IGCIC02032VO vo =  callmap.get(ename);
            if (vo == null) {
                vo = new IGCIC02032VO();
                // ��������
                vo.setIsBase(cscond.getIsBase());
            }
            Map<String, List<CompareresultVWInfo>> crvwMap = vo.getCrvwLst();
            List<CompareresultVWInfo> crlist = crvwMap.get(einame);
            if (crlist == null) {
                crlist = new LinkedList<CompareresultVWInfo>();
            }
            crlist.add(crVWInfo);
            crvwMap.put(einame, crlist);
            vo.setCrvwLst(crvwMap);
            callmap.put(ename, vo);
            
        }
        
        return map;
    }
    
    /**
     * ȡ�ñȽ϶����ļ�·��
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO getCompareObjectFilepath(IGCIC02DTO dto) throws BLException {
        log.debug("================== ȡ�ñȽ϶����ļ�·������ʼ ==================");
        
        CompareresultInfo info = compareresultBL.searchCompareresultByPK(dto.getIgcic0204Form().getCrid());
        dto.setCompareresultInfo(info);
        
        log.debug("================== ȡ�ñȽ϶����ļ�·��������� ==================");
        return dto;
    }
 
    /**
     * ִ�бȶ�����
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO executeCompareTask(IGCIC02DTO dto) throws BLException {
        log.debug("========== ִ�бȶ�������ʼ =========");
        
        Properties properties = getProperties();
        String filepath = properties.getProperty("CI_IMPORT_BAT_NAME_CI03");
        String[] cmd = new String[6];
        cmd[0] = "cmd";
        cmd[1] = "/c";
        cmd[2] = "start";
        cmd[3] = " ";

        try {
            cmd[4] = filepath;
            cmd[5] = "1";
            
            //����bat�ļ�ִ��
            Runtime.getRuntime().exec(cmd);

        } catch (IOException e) {
            log.error("�ֶ�����Ӧ�ó�������ʧ��", e);
            throw new BLException("IGCIM0205.E001");
        } catch (Exception e) {
            log.error("�ֶ�����Ӧ�ó�������ʧ��", e);
            throw new BLException("IGCIM0205.E001");
        }

        
        log.debug("========== ִ�бȶ���������� =========");
        return dto;
    }
    
    private Properties getProperties() throws BLException {
        //CI����Ӧ����Դ�ļ�
        Properties properties = null;
        //������
        FileInputStream inputFile = null;
        //���������ļ�
        try {
            properties = new Properties();
            inputFile = new FileInputStream(ResourceUtility.getString("CI_IMPORT_FILE_PATH"));
            properties.load(inputFile);
        } catch (FileNotFoundException e) {
            log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
            throw new BLException("IGCIM0201.E001");
        } catch (IOException e) {
            log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
            throw new BLException("IGCIM0201.E001");
        } finally {
            if(inputFile != null) {
                try {
                    inputFile.close();
                } catch (IOException e) {
                    log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
                    throw new BLException("IGCIM0201.E001");
                }
            }
        }
        return properties;
    }
    
    /**
     * ��ת���ԱȽ���鿴ҳ��ĳ�ʼ���ݻ�ȡ����
     * ��ȡ����ͼ
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO getTreeView(IGCIC02DTO dto) throws BLException {
    	
    	
    	
    	
    	CompareobjectHistorySearchCondImpl cohsCond = new CompareobjectHistorySearchCondImpl();
    	
    	cohsCond.setCoid_eq(dto.getIgcic0205Form().getCoid());
    	
    	CompareobjectHistoryInfo co = compareobjectHistoryBL.searchCompareobjectHistory(cohsCond).get(0);
    	
    	
    	//װ�������ȶԶ���
    	SOC0118SearchCondImpl socCond =  new SOC0118SearchCondImpl();
    	socCond.setEiid(co.getCosource().toString());
    	Map<String,String> sourceMap = soc0118BL.searchHostList(socCond).get(0);
    	socCond.setEiid(co.getCotarget().toString());
    	Map<String,String> targetMap =soc0118BL.searchHostList(socCond).get(0);
    	
    	dto.setSourceMap(sourceMap);
    	
    	dto.setTargetMap(targetMap);
    	
    	
    	Map<String,TreeNode> treeMap = new LinkedHashMap<String, TreeNode>();
    	
    	CompareresultSearchCondImpl cond = new CompareresultSearchCondImpl();
    	
    	cond.setCoid_eq(dto.getIgcic0205Form().getCoid());
    	
    	cond.setCpid_eq(dto.getIgcic0205Form().getCpid());
    	//��ѯ�����еķ��������� �Ա�
    	List<CompareresultVWInfo> resultList = compareresultBL.searchCompareresultVW(cond);
    	
    	//�������ʱmapװ�����нڵ���Ϣ �������,ɸѡ
    	
    	Hashtable<String,TreeNode>  tempMap =  new  Hashtable<String, TreeNode>();
    	
    	//�������еĶԱȽ��
    	for (CompareresultVWInfo compareresultVWInfo : resultList) {
    		
    		//��������͵�����ģ����û��װ�ع��ڵ��� ���һ���½ڵ�
    		TreeNode treeNode = tempMap.get(compareresultVWInfo.getEsyscoding());
    		if(treeNode==null){
    			
    			TreeNode node = new TreeNode();
    			node.setId(compareresultVWInfo.getEid());
    			node.setName(compareresultVWInfo.getEname());
    			node.setRemark(compareresultVWInfo.getEsyscoding());
    			//������ҵ������Ľڵ���װ�ص������ڵ���  ����װ�ص����ĸ�Ŀ¼��
    			TreeNode parentNode = getParentNode(tempMap,node);
    			if(parentNode==null){
    				treeMap.put(node.getRemark(), node);
    			}else{
    				if("temp".equals(parentNode.getStatus())&&parentNode.getRemark().length()<=9){
    					treeMap.put(parentNode.getRemark(), parentNode);
    				}else{
    					parentNode.addChildTreeNode(node.getRemark(), node);
    				}
    			}
    			tempMap.put(compareresultVWInfo.getEsyscoding(), node);
    		}
		}
    	dto.setSoc0124Info(this.getHostEntityByCoid(dto.getIgcic0205Form().getCoid()));
    	dto.setTreeMap(treeMap);
    	return dto;
    }
    
    /**
     * �����нڵ����ҳ������ڵ�    ���һֱû�ҵ��򷵻�null
     * @param tempMap
     * @param esyscoding
     * @return
     */
    private TreeNode getParentNode(Hashtable<String,TreeNode> tempMap ,TreeNode tempNode){
    	
    	if(tempNode.getRemark().length()<=9){
    		return tempMap.get(tempNode.getRemark());
    	}else{
    		TreeNode parentNode = tempMap.get(tempNode.getRemark().substring(0, tempNode.getRemark().length()-3));
    		if(parentNode!= null){
    				parentNode.addChildTreeNode(tempNode.getRemark(), tempNode);
//    				parentNode.setStatus("");
    			return parentNode;
    		}else{
    				SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
    				cond.setEsyscoding(tempNode.getRemark().substring(0,tempNode.getRemark().length()-3));
    				SOC0117Info soc0117 = soc0117BL.searchEntity(cond).get(0);
    				TreeNode fakeNode = new TreeNode();
    				fakeNode.setId(soc0117.getEid());
    				fakeNode.setName(soc0117.getEname());
    				fakeNode.setRemark(soc0117.getEsyscoding());
    				fakeNode.setStatus("temp");
    				fakeNode.addChildTreeNode(tempNode.getRemark(), tempNode);
    				tempMap.put(fakeNode.getRemark(), fakeNode);
    			return getParentNode(tempMap,fakeNode);
    		}
    	}
    }
    
    /**
     * ��������ģ��id �ͶԱȹ���id ��ȡ�ԱȽ��
     * @param dto
     * @return
     * @throws BLException
     */
    public List<CompareresultVWInfo> getDetailByEentity(String eid,Integer cpid) throws BLException {
    	CompareresultSearchCondImpl cond = new CompareresultSearchCondImpl();
    	
    	cond.setEid(eid);
    	
    	cond.setCpid_eq(cpid);
    	
    	List<CompareresultVWInfo> resultList = compareresultBL.searchCompareresultVW(cond);
    	
    	return resultList;
    }
    
    /**
     * ��ȡ�Ա�Դ�������Ϣ
     * @param coid
     * @return
     * @throws BLException
     */
    private SOC0124Info getHostEntityByCoid(Integer coid)throws BLException{
    	CompareobjectHistorySearchCondImpl cond = new CompareobjectHistorySearchCondImpl();
    	cond.setCoid_eq(coid);
    	CompareobjectHistoryInfo  coInfo = compareobjectHistoryBL.searchCompareobjectHistory(cond).get(0);
    	SOC0124Info soc0124 = soc0118BL.searchEntityItemVWByKey(coInfo.getCosource());
    	return soc0124;
    }
    
}
