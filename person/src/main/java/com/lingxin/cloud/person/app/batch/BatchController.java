package com.lingxin.cloud.person.app.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mr_Li on 2016/10/4.
 */
@RestController
@RequestMapping("batch")
public class BatchController {
    public JobParameters jobParameters;
    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    Job importJob;

    @RequestMapping("runMyBatch")
    public String runMyBatch(String fileName) throws Exception {
        jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).addString("input.file.path", fileName).toJobParameters();
        jobLauncher.run(importJob, jobParameters);
        return "OK";
    }
}
