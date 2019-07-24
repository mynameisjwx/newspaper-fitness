package com.hand6.health.api.controller.v1;/**
 * Created by Administrator on 2019/7/14.
 */

import com.hand6.health.app.service.impl.ReportServiceImpl;
import com.hand6.health.domain.entity.MotionSummary;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author xxxx
 * @description
 * @date 2019/7/14
 */
@RestController
@RequestMapping("/v1/report")
public class ReportController {
    @Autowired
    private ReportServiceImpl reportService;
    @GetMapping(value = "/motionSummary")
    public void motionSummary(MotionSummary motionSummary, HttpServletResponse response){
        reportService.export(motionSummary,response);
    }
}
