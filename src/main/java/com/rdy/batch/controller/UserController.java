package com.rdy.batch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/v1/load")
public class UserController {
    
    @Autowired
    JobLauncher jobLauncher;
    
    @Autowired
    Job job;
    
    @GetMapping
    public BatchStatus load() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        Map<String, JobParameter> params = new HashMap<>();
        params.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters param = new JobParameters(params);
        JobExecution jobExecution = jobLauncher.run(job,param);
        log.info("JobExcecution : {}",jobExecution);
        log.info("start time : {}",jobExecution.getStartTime());
        log.info("end time: {}",jobExecution.getEndTime());
        return jobExecution.getStatus();
    }
}
