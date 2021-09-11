package com.amazon.uistore;

import org.openqa.selenium.By;

public class LoginPageUI {
	 
   public static By clicksign=By.cssSelector("a[id='nav-link-accountList']");
	
   public static By username=By.cssSelector("input[id='ap_email']");
    
   public static By con=(By.cssSelector("input[id='continue']"));
    
   public static By password=By.cssSelector("input[id='ap_password']");
     
   public static By submit=By.cssSelector("input[id='signInSubmit']");
}
