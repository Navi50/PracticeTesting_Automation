package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ExtentReports1 {
    ExtentReports extent ;

    public void extentreportStart() throws IOException {

        System.out.println(System.getProperty("user.dir")+"ExtentReportResults.html");
        String path = System.getProperty("user.dir")+"\\target\\test\\";
        System.out.println(path);
        ExtentSparkReporter spark = new ExtentSparkReporter(path);


        spark.config().setDocumentTitle("Test");
        spark.config().setReportName("Spark");
        spark.config().setCss("css-string");
        spark.config().setTimelineEnabled(true);
        spark.config().setEncoding("utf-8");
        spark.config().setJs("js-string");
        spark.config().setProtocol(Protocol.HTTPS);
        spark.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(spark);

    }

    public void extentReportStop(){
    }

}
