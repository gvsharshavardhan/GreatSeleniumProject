package com.rp.listeners;

import com.rp.constants.FrameWorkConstants;
import com.rp.utilities.ExcelUtil;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {
        List<Map<String, String>> testdata = ExcelUtil.getTestDetails(FrameWorkConstants.getRUNMANAGERSHEET());
        List<IMethodInstance> updatedMethods = new ArrayList<>();
        for (IMethodInstance method : methods) {
            System.out.println("::" + method.getMethod().getMethodName());
            for (Map<String, String> test : testdata) {
                if (method.getMethod().getMethodName().equalsIgnoreCase(test.get("testname")) &&
                        test.get("execute").equalsIgnoreCase("yes")) {
                    method.getMethod().setInvocationCount(Integer.parseInt(test.get("count")));
                    method.getMethod().setDescription(test.get("testdescription"));
//                    method.getMethod().setPriority(Integer.parseInt(test.get("priority")));
                    System.out.println(">> " + method.getMethod().getMethodName());
                    updatedMethods.add(method);
                    break;
                }
            }
        }
        return updatedMethods;
    }
}