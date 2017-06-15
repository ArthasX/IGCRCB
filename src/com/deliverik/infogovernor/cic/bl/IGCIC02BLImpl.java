/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 对比任务业务逻辑实现
 * </p>
 * 
 * @author 
 * @version 1.0
 */
public class IGCIC02BLImpl extends BaseBLImpl implements IGCIC02BL {

	static Log log = LogFactory.getLog(IGCIC02BLImpl.class);

	/** 对比记录业务逻辑BL */
	private CompareprocessBL compareprocessBL;
	
	/** 比对规则表BL */
	private CompareroleBL compareroleBL; 
	
	/** 比对对象历史表 */
	private CompareobjectHistoryBL compareobjectHistoryBL;
	
	/** 比对结果表BL */
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
     * 对比记录业务逻辑BL 设定
     * @param compareprocessBL 对比记录业务逻辑BL 
     */
    public void setCompareprocessBL(CompareprocessBL compareprocessBL) {
        this.compareprocessBL = compareprocessBL;
    }

    /** 
     * 比对规则表BL 设定
     * @param compareroleBL 比对规则表BL 
     */
    public void setCompareroleBL(CompareroleBL compareroleBL) {
        this.compareroleBL = compareroleBL;
    }


    /** 
     * 比对对象历史表 设定
     * @param compareobjectHistoryBL 比对对象历史表 
     */
    public void setCompareobjectHistoryBL(CompareobjectHistoryBL compareobjectHistoryBL) {
        this.compareobjectHistoryBL = compareobjectHistoryBL;
    }

    /** 
     * 比对结果表BL 设定
     * @param compareresultBL 比对结果表BL 
     */
    public void setCompareresultBL(CompareresultBL compareresultBL) {
        this.compareresultBL = compareresultBL;
    }

    /**
	 * 查询比对执行情况
	 * 
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIC02DTO searchCompareProcessAction(IGCIC02DTO dto) throws BLException {
	    log.debug("================= 查询比对执行情况处理开始 ==============");
	    
	    IGCIC0201Form form = dto.getIgcic0201Form();
	    
	    CompareprocessSearchCondImpl cond = new CompareprocessSearchCondImpl();
	    
	    BeanUtils.copyProperties(form, cond);
	    
        int totalCount = compareprocessBL.getSearchCount(cond);
        
        if (totalCount == 0) {
            log.debug("========查询数据不存在========");
            // 查询数据不存在
            dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
            return dto;
        }
        if (totalCount > dto.getMaxSearchCount()) {
            log.debug("========查询数据件数过多========");
            // 查询数据件数过多
            dto.addMessage(new ActionMessage("IGCO00000.E005", dto
                    .getMaxSearchCount(), totalCount));
            return dto;
        }
        
        //获取分页bean
        PagingDTO pDto = dto.getPagingDto();
        
        List<CompareprocessInfo> list = compareprocessBL.searchCompareprocess(cond, pDto.getFromCount(), pDto.getPageDispCount());
        
        pDto.setTotalCount(totalCount);
        
        dto.setCompareprocessList(list);
        
	    log.debug("================= 查询比对执行情况处理结束 ==============");
	    return dto;
	}
	
	/**
	 * 比对任务查看页面 
	 * 
	 * @param dto
	 * @return
	 */
	public IGCIC02DTO compareResultViewAction(IGCIC02DTO dto) throws BLException {
	    log.debug("================= 比对结果查看页面处理开始 ==================");
	    
	    CompareroleSearchCondImpl crcond = new CompareroleSearchCondImpl();
	    crcond.setCpid(dto.getCpid());
	    
	    // 根据关系表查询规则
        List<CompareroleInfo> compareroleList = compareroleBL.searchCompareroleByRelation(crcond);
        
        
        Map<String, List<IGCIC02022VO>> resultVoMap = new LinkedHashMap<String, List<IGCIC02022VO>>();
        
        // 遍历规则查询规则对应的对象
        for (CompareroleInfo compareroleInfo : compareroleList) {
            List<IGCIC02022VO> volist = resultVoMap.get(compareroleInfo.getCrsystemname());
            if (null == volist) {
                volist = new ArrayList<IGCIC02022VO>();
            }
            IGCIC02022VO vo01 = new IGCIC02022VO();
            vo01.setCrsystemname(compareroleInfo.getCrsystemname());
            vo01.setCrtype(compareroleInfo.getCrtype());
            
            // 根据规则主键及版本查询对象
            CompareobjectHistorySearchCondImpl cohcond = new CompareobjectHistorySearchCondImpl();
            cohcond.setFkCrid_eq(compareroleInfo.getCrid());
//            cohcond.setCrversion_eq(compareroleInfo.getCrversion());
            
            List<CompareobjectHistoryInfo> list = compareobjectHistoryBL.searchCompareobjectHistory(cohcond);
            
            Map<String, List<IGCIC02023VO>> map = new HashMap<String, List<IGCIC02023VO>>();
            
            // 遍历比对对象，拼装页面显示对象
            for (CompareobjectHistoryInfo coinfo : list) {
                
                List<IGCIC02023VO> sourcelist = map.get(coinfo.getSourceIP());
                if (sourcelist == null) {
                    sourcelist = new ArrayList<IGCIC02023VO>();
                }
                
                // 比较对象VO
                IGCIC02023VO vo = new IGCIC02023VO();
                vo.setCoid(coinfo.getCoid());
                vo.setHostname(coinfo.getTargetIP());
                CompareresultSearchCondImpl cscond = new CompareresultSearchCondImpl();
                cscond.setCoid_eq(coinfo.getCoid());
                
                // 查询比较的对象是否存在不同
                int count = compareresultBL.getSearchCount(cscond);
                // 比较对象不同
                if (count > 0) {
                    vo.setIsDifferent(IGCIC02BLType.COMPARERESULT_DIFFERENT);
                } 
                // 相同
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
        
	    log.debug("================= 比对结果查看页面处理开始 ==================");
	    return dto;
	}
	
	
	/**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public IGCIC02DTO searchObjectCompareresult(IGCIC02DTO dto) throws BLException {
        log.debug("============== 查询对象比对结果处理开始 ============");

        IGCIC0203Form form = dto.getIgcic0203Form();
        
        // 页面显示用Map key：页面显示组名 value：显示对象Map key：模型名称 value：属性列表
        Map<String, Map<String, IGCIC02032VO>> showmap =  new LinkedHashMap<String, Map<String, IGCIC02032VO>>();

        // 查询比对结果
        CompareresultSearchCondImpl cscond  = new CompareresultSearchCondImpl();
        cscond.setCoid_eq(form.getCoid());
        List<Object[]> list = compareresultBL.getEnameList(cscond);
        for (Object[] objects : list) {
            showmap.put(objects[1].toString(), null);
        }
        
        // 查询基本属性
        cscond.setIsBase(IGCIC02BLType.ATTRIBUTETYPE_BASE);
        showmap = assemblyData(showmap, cscond);
        
        // 查询其他属性
        cscond.setIsBase(IGCIC02BLType.ATTRIBUTETYPE_OTHER);
        showmap = assemblyData(showmap, cscond);
        
        dto.setCic0203ShowMap(showmap);
        
        log.debug("============== 查询对象比对结果处理结束 ============");
        return dto;
    }

    private Map<String, Map<String, IGCIC02032VO>> assemblyData(Map<String, Map<String, IGCIC02032VO>> map, CompareresultSearchCond cscond ) throws BLException {
        
        List<CompareresultVWInfo> cslist = compareresultBL.searchCompareresultVW(cscond);
        
        // 遍历基本属性比对结果，组装页面显示用数据
        for (CompareresultVWInfo crVWInfo : cslist) {
            
            String pename = crVWInfo.getPename();// 父模型名称
            String eid = crVWInfo.getEid(); // 模型id
            String ename = crVWInfo.getEname(); // 模型名称
            String einame = crVWInfo.getEiname();
            // 取得显示行用list
            Map<String, IGCIC02032VO> callmap = map.get(pename);
            if (callmap == null) {
                callmap = new LinkedHashMap<String, IGCIC02032VO>();
                map.put(pename, callmap);
            }
            
            // 模块显示对象
            IGCIC02032VO vo =  callmap.get(ename);
            if (vo == null) {
                vo = new IGCIC02032VO();
                // 基本属性
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
     * 取得比较对象文件路径
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO getCompareObjectFilepath(IGCIC02DTO dto) throws BLException {
        log.debug("================== 取得比较对象文件路径处理开始 ==================");
        
        CompareresultInfo info = compareresultBL.searchCompareresultByPK(dto.getIgcic0204Form().getCrid());
        dto.setCompareresultInfo(info);
        
        log.debug("================== 取得比较对象文件路径处理结束 ==================");
        return dto;
    }
 
    /**
     * 执行比对任务
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO executeCompareTask(IGCIC02DTO dto) throws BLException {
        log.debug("========== 执行比对任务处理开始 =========");
        
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
            
            //调用bat文件执行
            Runtime.getRuntime().exec(cmd);

        } catch (IOException e) {
            log.error("手动快照应用程序启动失败", e);
            throw new BLException("IGCIM0205.E001");
        } catch (Exception e) {
            log.error("手动快照应用程序启动失败", e);
            throw new BLException("IGCIM0205.E001");
        }

        
        log.debug("========== 执行比对任务处理结束 =========");
        return dto;
    }
    
    private Properties getProperties() throws BLException {
        //CI导入应用资源文件
        Properties properties = null;
        //输入流
        FileInputStream inputFile = null;
        //加载属性文件
        try {
            properties = new Properties();
            inputFile = new FileInputStream(ResourceUtility.getString("CI_IMPORT_FILE_PATH"));
            properties.load(inputFile);
        } catch (FileNotFoundException e) {
            log.error("CI导入应用资源文件读取错误", e);
            throw new BLException("IGCIM0201.E001");
        } catch (IOException e) {
            log.error("CI导入应用资源文件读取错误", e);
            throw new BLException("IGCIM0201.E001");
        } finally {
            if(inputFile != null) {
                try {
                    inputFile.close();
                } catch (IOException e) {
                    log.error("CI导入应用资源文件读取错误", e);
                    throw new BLException("IGCIM0201.E001");
                }
            }
        }
        return properties;
    }
    
    /**
     * 跳转到对比结果查看页面的初始数据获取方法
     * 获取树视图
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO getTreeView(IGCIC02DTO dto) throws BLException {
    	
    	
    	
    	
    	CompareobjectHistorySearchCondImpl cohsCond = new CompareobjectHistorySearchCondImpl();
    	
    	cohsCond.setCoid_eq(dto.getIgcic0205Form().getCoid());
    	
    	CompareobjectHistoryInfo co = compareobjectHistoryBL.searchCompareobjectHistory(cohsCond).get(0);
    	
    	
    	//装载两个比对对象
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
    	//查询出所有的符合条件的 对比
    	List<CompareresultVWInfo> resultList = compareresultBL.searchCompareresultVW(cond);
    	
    	//定义个临时map装载所有节点信息 方便查找,筛选
    	
    	Hashtable<String,TreeNode>  tempMap =  new  Hashtable<String, TreeNode>();
    	
    	//遍历所有的对比结果
    	for (CompareresultVWInfo compareresultVWInfo : resultList) {
    		
    		//如果该类型的配置模型码没有装载过节点则 添加一个新节点
    		TreeNode treeNode = tempMap.get(compareresultVWInfo.getEsyscoding());
    		if(treeNode==null){
    			
    			TreeNode node = new TreeNode();
    			node.setId(compareresultVWInfo.getEid());
    			node.setName(compareresultVWInfo.getEname());
    			node.setRemark(compareresultVWInfo.getEsyscoding());
    			//如果能找到父级的节点则装载到父级节点中  否则装载到树的根目录下
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
     * 在所有节点中找出父级节点    如果一直没找到则返回null
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
     * 根据配置模型id 和对比过程id 获取对比结果
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
     * 获取对比源对象的信息
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
