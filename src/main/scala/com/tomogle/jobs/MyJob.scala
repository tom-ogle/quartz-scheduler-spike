package com.tomogle.jobs

import org.quartz.{Job, JobExecutionContext}

class MyJob() extends Job {

  override def execute(context: JobExecutionContext): Unit = {
    val dataMap = context.getJobDetail.getJobDataMap
    val message = dataMap.getString(MyJob.messageKey)
    println(message)
  }
}

object MyJob {
  val messageKey = "message"
}
