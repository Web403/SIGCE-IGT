package com.myserver.server;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

/**
 * main
 */
public class EmailInfo {

    public static String yearChecker(String yr){
        switch (yr) {
            case "2021":
                return "Third";
            case "2022":
                return "Second";
            case "2023":
                return "First";
            default:
                return "Not";
        }
    }

    public static String BranchChecker(String br){
        switch (br) {
            case "ci":
                return "CSE(IOT)";
            
            case "ca":
                return "CSE(AIML)";

            default:
                return "Not Valid";
        }
    }


    public static ResponseEntity<Object> emailInfo(String str){

        StringBuilder s = new StringBuilder(str);
        char[] yearHelper = new char[4];
        for (int i = 0; i < yearHelper.length; i++) {
            yearHelper[i] = s.charAt(i);
        }
        String year = new String(yearHelper);
        char[] branchhelper = new char[2];
        branchhelper[0] = s.charAt(4);
        branchhelper[1] = s.charAt(5);
        String Branch = new String(branchhelper);
        char[] StudentIdhelper = new char[9];
        for (int i = 0; i < StudentIdhelper.length; i++) {
            StudentIdhelper[i] = s.charAt(i);
        }
        String StudentId = new String(StudentIdhelper);
        char[] RollNohelper = new char[2];
        RollNohelper[0] = s.charAt(6);
        RollNohelper[1] = s.charAt(7);        
        String RollNo = new String(RollNohelper);
        Map<String, String> data = new HashMap<>();
        data.put("Year", yearChecker(year));
        data.put("Branch", BranchChecker(Branch));
        data.put("StudentId", StudentId);
        data.put("RollNo", RollNo);
        return ResponseEntity.ok(data);
        
    }
}