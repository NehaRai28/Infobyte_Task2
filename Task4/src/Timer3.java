

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Timer3")
public class Timer3 extends HttpServlet {
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		// TODO Auto-generated method stub
		//instance of the Timer class  
		Timer timer = new Timer();  
		TimerTask task = new TimerTask()  
		{  
		//represent the time after which the task will begin to execute  
		int i = 5;  
		@Override  
		public void run()  
		{  
		if(i>0)  
		{  
		out.println(i);  
		i--;  
		}  
		else  
		{  
		out.println("<Script>window.alert('Time out')</script?");  
		//cancel the task once it is completed  
		timer.cancel();  
		}  
		}  
		};  
		//creating an instance of the Calendar class  
		Calendar date = Calendar.getInstance();  
		//setting the date and time on which timer will begin   
		date.set(2022, Calendar.MARCH, 30,23, 59, 54);  
		//enables the counter to count at a rate of 1 second  
		timer.scheduleAtFixedRate(task, date.getTime(), 1000);  

	}

}
