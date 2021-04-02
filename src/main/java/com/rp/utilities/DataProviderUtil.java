package com.rp.utilities;

import com.rp.constants.FrameWorkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtil {
    private static List<Map<String, String>> fullList = new ArrayList<>();

    private DataProviderUtil() {

    }

    @DataProvider(parallel = true)
    public static Object[] getData(Method method) {
        String testname = method.getName();
        if (fullList.isEmpty()) {
            fullList = ExcelUtil.getTestDetails(FrameWorkConstants.getITERATIONDATASHEET());
        }
        List<Map<String, String>> smallList = new ArrayList<>();
        for (Map<String, String> test : fullList) {
            if (test.get("testname").equalsIgnoreCase(testname)
                    && test.get("execute").equalsIgnoreCase("yes")) {
                smallList.add(test);
            }
        }
        fullList.removeAll(smallList);
        return smallList.toArray();
    }
}