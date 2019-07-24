package com.hand6.health.app.service.impl;/**
 * Created by Administrator on 2019/7/6.
 */

import com.alibaba.fastjson.JSONObject;
import com.hand6.health.app.service.MotionRecordsService;
import com.hand6.health.common.ConstantUtil;
import com.hand6.health.domain.entity.MotionIndicators;
import com.hand6.health.domain.entity.MotionRecords;
import com.hand6.health.domain.entity.MotionSummary;
import com.hand6.health.infra.mapper.MotionIndicatorsMapper;
import com.hand6.health.infra.mapper.MotionRecordsMapper;
import com.hand6.health.infra.mapper.MotionSummaryMapper;
import com.hand6.health.util.DateUtil;
import com.hand6.health.util.ExcelUtil;
import com.hand6.health.util.FileUtil;
import com.hand6.health.util.SysBeanUtil;
import io.choerodon.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author xxxx
 * @description
 * @date 2019/7/6
 */
@Service
public class ReportServiceImpl {

    @Autowired
    private MotionSummaryMapper motionSummaryMapper;

    public void export(MotionSummary motionSummary, HttpServletResponse response) {
       List<MotionSummary> dataList = motionSummaryMapper.findAll(motionSummary);
       setMotionSummaryDesc(dataList);
       if (!CollectionUtils.isEmpty(dataList)){
           ExcelUtil.writeExcel(response,dataList,MotionSummary.class);
       }
    }

    private void setMotionSummaryDesc(List<MotionSummary> dataList) {
        for (MotionSummary motionSummary : dataList) {
            motionSummary.setStatusDesc(ConstantUtil.ACHIEVE.equals(motionSummary.getStatus())?"达标":"不达标");
        }
    }
}

