package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ExtentListenerClass implements ITestListener {
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configureReport()
    {
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//report.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        //add information to reports
        reports.setSystemInfo("browser","chrome");
        reports.setSystemInfo("user","Akshay");
        reports.setSystemInfo("OS","windows 11");

        //configuration to change look and feel of report
        htmlReporter.config().setDocumentTitle("MyStore Reports");
        htmlReporter.config().setReportName("This is my MysStore Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
    }
    public void onStart(ITestContext Result)
    {
        configureReport();
        System.out.println("On start method is invoked....");
    }
    public void onFinish(ITestContext Result)
    {
        System.out.println("On finish method is invoked....");
        reports.flush();
    }

    public void onTestFailure(ITestResult Result)
    {
        System.out.println("Name of the failed method:"+Result.getName());
        test = reports.createTest(Result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: "+Result.getName(), ExtentColor.RED));

        String screenShotPath = System.getProperty("user.dir")+"\\ScreenShots\\"+Result.getName()+".png";

        File screenShotFile = new File(screenShotPath);

        if(screenShotFile.exists())
        {
            try {
                test.fail("Captured Screenshot is below:"+test.addScreenCaptureFromPath(screenShotPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void onTestSkipped(ITestResult Result)
    {
        System.out.println("Name of test method skipped:" + Result.getName() );

        test = reports.createTest(Result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName() , ExtentColor.YELLOW));
    }
    public void onTestStart(ITestResult Result)
    {
        System.out.println("Name of test method started:" + Result.getName() );

    }
    public void onTestSuccess(ITestResult Result)
    {
        System.out.println("Name of test method sucessfully executed:" + Result.getName() );

        test = reports.createTest(Result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
    {

    }

}
