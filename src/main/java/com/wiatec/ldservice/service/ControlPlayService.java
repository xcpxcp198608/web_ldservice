package com.wiatec.ldservice.service;

import com.wiatec.ldservice.common.result.EnumResult;
import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.common.result.ResultMaster;
import com.wiatec.ldservice.common.result.XException;
import com.wiatec.ldservice.listener.SessionListener;
import com.wiatec.ldservice.oxm.dao.ControlPlayDao;
import com.wiatec.ldservice.oxm.pojo.ControlPlayInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author patrick
 */
@Service
public class ControlPlayService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ControlPlayDao controlPlayDao;

    /**
     *  API use
     * @param request HttpServletRequest
     * @param mac  mac
     * @return ResultInfo
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo get(HttpServletRequest request, String mac){
        try{
            HttpSession session = SessionListener.getSession(mac);
            if(session == null){
                session = request.getSession();
                session.setAttribute("mac", mac);
            }
            ControlPlayInfo controlPlayInfo = controlPlayDao.selectOne(mac);
            if(controlPlayInfo == null){
                controlPlayDao.insertOne(mac);
            }else {
                controlPlayDao.updateToNoPlay(mac);
            }
            return ResultMaster.success(controlPlayInfo);
        }catch (XException e){
            logger.error("XException: ", e);
            throw new XException(e.getCode(), e.getMessage());
        }catch (Exception e){
            logger.error("Exception: ", e);
            throw new XException(EnumResult.ERROR_SERVER_EXCEPTION);
        }
    }

    public List<ControlPlayInfo> list(){
        List<ControlPlayInfo> controlPlayInfoList = controlPlayDao.selectAll();
        List<ControlPlayInfo> controlPlayInfoList1 = new ArrayList<>();
        Map<String, HttpSession> sessionMap = SessionListener.userSessionMap;
        for(ControlPlayInfo controlPlayInfo : controlPlayInfoList){
            if(sessionMap.containsKey(controlPlayInfo.getMac())){
                controlPlayInfoList1.add(controlPlayInfo);
            }
        }
        return controlPlayInfoList1;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultInfo update(ControlPlayInfo controlPlayInfo){
        try{
            if(controlPlayInfo.getMac() == null ){
                throw new XException(EnumResult.ERROR_MAC_FORMAT);
            }
            controlPlayDao.updateToPlay(controlPlayInfo);
            return ResultMaster.success();
        }catch (XException e){
            logger.error("XException: ", e);
            throw new XException(e.getCode(), e.getMessage());
        }catch (Exception e){
            logger.error("Exception: ", e);
            throw new XException(EnumResult.ERROR_SERVER_EXCEPTION);
        }
    }
}
