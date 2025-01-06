package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportsUtil implements ConcurrentEventListener {


    public static ExtentReports extent = new ExtentReports();
    public static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();
    public static String testResultPath;
    public static String application = "SWAGLABS";

    public void onTestRunStarted(TestRunStarted event){
        testResultPath = "D:\\Learning\\Reports\\";
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
        String timestamp = dtf.format(localDateTime);
        String reportPath = testResultPath+application+timestamp+".html";

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setReportName("Automation Report");
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setTheme(Theme.STANDARD);

        extent.attachReporter(spark);
        extent.setSystemInfo("Application",application);
        extent.setSystemInfo("OS","Windows");
    }

    public void onTestRunFinished(TestRunFinished event){
        extent.flush();
    }

    public static void addLog(String log){
        extent.addTestRunnerOutput(log);
    }

    public void onTestCaseStarted(TestCaseStarted event){
        ExtentTest test = extent.createTest(event.getTestCase().getName());
        scenarioTest.set(test);

    }


    public void onTestStepFinished(TestStepFinished event){
        String step = event.getTestStep().getCodeLocation().substring(16);
        String result = event.getResult().toString();
//        String screenShotPath = takeScreenshot(step);
        String base = takess();
        try {
            if (event.getResult().getStatus().is(Status.PASSED)) {
                //scenarioTest.get().createNode(step).addScreenCaptureFromPath(screenShotPath).pass("Step Passed: "+step+"\n"+"Result :"+result);
                scenarioTest.get().createNode(step).addScreenCaptureFromBase64String(base).pass("Step Passed: "+step);
            } else if (event.getResult().getStatus().is(Status.FAILED)){
               // scenarioTest.get().createNode(step).addScreenCaptureFromPath(screenShotPath).fail("Step Failed :"+step+"\n"+"Result :"+result);
                scenarioTest.get().createNode(step).addScreenCaptureFromBase64String(base).fail("Step Failed :"+step+"\n"+"Result :"+result);

            } else {
                //scenarioTest.get().createNode(step).addScreenCaptureFromPath(screenShotPath).info(step+"\n"+"Result :"+result);
                scenarioTest.get().createNode(step).addScreenCaptureFromBase64String(base).info(step+"\n"+"Result :"+result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String takess(){
        if (DriverManager.getDriver()==null){
            return null;
        }
        return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

//    public static String takeScreenshot(String path){
//
//        if (DriverManager.getDriver()==null){
//            return null;
//        }
//
//        File srcFile = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
//        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"));
//        String screenshotpath = "D:\\Learning\\Reports\\ScreenShot\\"+path+"_"+time+".png";
//
//        try{
//            FileUtils.copyFile(srcFile, new File(screenshotpath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return screenshotpath;
//    }

    public void onTestCaseFinished(TestCaseFinished event){
        if (event.getResult().getStatus().is(Status.PASSED)){
            scenarioTest.get().pass(Status.PASSED.toString());
        }else{
            scenarioTest.get().fail(Status.FAILED.toString());
        }
    }

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, this::onTestRunStarted);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
        eventPublisher.registerHandlerFor(TestStepFinished.class, this::onTestStepFinished);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);

    }
}
