package utils.ExtentReports;

import com.relevantcodes.extentreports.*;

import java.io.*;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportsResults.html",true);
            extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
        }
        return extent;
    }
}