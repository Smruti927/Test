package com.myapp.sm.MyApp.Controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Test { @SuppressWarnings("unchecked")
public static void main( String[] args )
{
    //First Employee
    JSONObject employeeDetails = new JSONObject();
    employeeDetails.put("firstName", "Lokesh");
    employeeDetails.put("lastName", "Gupta");
    employeeDetails.put("website", "howtodoinjava.com");
     
    JSONObject employeeObject = new JSONObject(); 
    employeeObject.put("employee", employeeDetails);
     
    //Second Employee
    JSONObject employeeDetails2 = new JSONObject();
    employeeDetails2.put("firstName", "Brian");
    employeeDetails2.put("lastName", "Schultz");
    employeeDetails2.put("website", "example.com");
     
    JSONObject employeeObject2 = new JSONObject(); 
    employeeObject2.put("employee", employeeDetails2);
     
    //Add employees to list
    JSONArray employeeList = new JSONArray();
    employeeList.add(employeeObject);
    employeeList.add(employeeObject2);
     
   System.out.println(employeeList.toJSONString());
   
   //JSONArray employeeList1 = (JSONArray) obj;
   //System.out.println(employeeList);
    
   //Iterate over employee array
   employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
   
   
}

private static void parseEmployeeObject(JSONObject employee) 
{
    //Get employee object within list
    JSONObject employeeObject = (JSONObject) employee.get("employee");
    System.out.println("employeeObject"+employeeObject);
     
    //Get employee first name
    String firstName = (String) employeeObject.get("firstName");    
    System.out.println(firstName);
     
    //Get employee last name
    String lastName = (String) employeeObject.get("lastName");  
    System.out.println(lastName);
     
    //Get employee website name
    String website = (String) employeeObject.get("website");    
    System.out.println(website);
}
}