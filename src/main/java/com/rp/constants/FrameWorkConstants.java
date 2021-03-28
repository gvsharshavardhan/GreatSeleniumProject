package com.rp.constants;

import com.rp.enums.ConfigProperties;
import com.rp.utilities.PropertiesUtil;

/*
I declared this class as final because, I don't want other classes to inherit this class
only way is to access through object or using class name for static members.
 */
public final class FrameWorkConstants {

    private final static String PROPERTYFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    private final static String JSONFILEPATH = System.getProperty("user.dir") + "/src/test/resources/jsons/myJson.json";
    private final static String CHROMEDRIVERPATH = System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver.exe";
    private final static String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private final static String EXCELPATH = System.getProperty("user.dir") + "/src/test/resources/excel/datatest.xls";
    private final static int EXPLICITWAIT = 10;
    private final static int IMPLICTWAIT = 10;
    private static String EXTENTREPORTPATH = "";
    private final static String RUNMANAGERSHEET = "Sheet1";
    private final static String ITERATIONDATASHEET = "data";

    /*
    I don't want others to create an object from this class.
    because all the methods in this class are going to be static . So, other should access members
    in this class only through class name.
     */
    private FrameWorkConstants() {

    }

    public static String getEXCELPATH() {
        return EXCELPATH;
    }

    public static String getExtentReportPath() throws Exception {
        if (EXTENTREPORTPATH.isBlank()) {
            EXTENTREPORTPATH = getExtentReportFileName();
        }
        return EXTENTREPORTPATH;
    }

    private static String getExtentReportFileName() throws Exception {
        if (PropertiesUtil.get(ConfigProperties.OVERRIDEREPORT).equalsIgnoreCase("yes")) {
            return EXTENTREPORTFOLDERPATH + "index.html";
        } else {
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/" + "index.html";
        }
    }

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getPROPERTYFILEPATH() {
        return PROPERTYFILEPATH;
    }

    public static int getExplicitwait() {
        return EXPLICITWAIT;
    }

    public static int getImplictWait() {
        return IMPLICTWAIT;
    }

    public static String getJSONFILEPATH() {
        return JSONFILEPATH;
    }

    public static String getRUNMANAGERSHEET() {
        return RUNMANAGERSHEET;
    }

    public static String getITERATIONDATASHEET() {
        return ITERATIONDATASHEET;
    }
}