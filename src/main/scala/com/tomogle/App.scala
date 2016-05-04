package com.tomogle

import com.tomogle.jobs._
import org.quartz.JobBuilder._
import org.quartz.SimpleScheduleBuilder
import org.quartz.TriggerBuilder._
import org.quartz.impl.StdSchedulerFactory





object App {
  def main(args: Array[String]) {
    val scheduler = StdSchedulerFactory.getDefaultScheduler()
    val job = newJob(classOf[MyJob])
      .withIdentity("My Print Job", "Group A")
      .usingJobData(MyJob.messageKey, "Hello World!")
      .build()

    val trigger = newTrigger()
      .withIdentity("My Trigger", "Group A")
      .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(100))
      .build()

    scheduler.start()
    scheduler.scheduleJob(job, trigger)
  }
}

