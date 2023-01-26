package com.example.fmversion2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ShowClass 
{
	String time="";
	String course="";
	String teacher="";
	String roomNo="";
	
	int inputHour;
	int inputMinute;
	int inputSecond;
	
	String day;
	
	int dayStartIndex;
	int dayEndIndex;
	
	int nextIndex=0;
	
	String[] classes = new String[100];
	String[] ct = new String[5];
	
   public ShowClass(String day)
   {
		Calendar calendar = new GregorianCalendar();
		
		inputHour = calendar.get(Calendar.HOUR_OF_DAY);
		inputMinute = calendar.get(Calendar.MINUTE);
		inputSecond = calendar.get(Calendar.SECOND);
		
		this.day = day;					 //1	   //2       //3
							   //01234567890123456789012345678901234
		classes[0] = new String("A 0801 0850   EE 403   SA  Room 103"); 
		classes[1] = new String("A 0851 0940  MATH 407  MBH Room 103");
		classes[2] = new String("A 0941 1030  CSE 401   BP  Room 103");
		classes[3] = new String("A 1031 1050   Break    --     --   ");
		classes[4] = new String("A 1431 1700  EE 404 A  SA  Lab-HW  ");

		classes[5] = new String("B 0801 0850  CSE 407   JR  Room 102");
		classes[6] = new String("B 0851 0940  CSE 401   BP  Seminar ");
		classes[7] = new String("B 0941 1030  CSE 405   BA  Seminar ");
		classes[8] = new String("B 1031 1050   Break    --     --   ");
		classes[9] = new String("B 1051 1320  CSE 406 A BA  Lab-NW  ");

	   classes[10] = new String("C 0801 1030  CSE 408   MA  Lab-HW  ");
	   classes[11] = new String("C 1031 1050   Break    --     --   ");
	   classes[12] = new String("C 1051 1140  CSE 407   JR  Room 102");
	   classes[13] = new String("C 1141 1230  CSE 405   BA  Room 102");
	   classes[14] = new String("C 1231 1320   EE 403   SA  Room 102");

	   classes[15] = new String("D 0801 1030  CSE 402 A BP  Lab-SW2 ");
	   classes[16] = new String("D 1031 1050   Break    --     --   ");
	   classes[17] = new String("D 1051 1140  CSE 405   BA  Room 104");
	   classes[18] = new String("D 1141 1230  MATH 407  MHU Room 104");
	   classes[19] = new String("D 1231 1320  CSE 407   JR  Room 104");

	   classes[20] = new String("E 0801 0850  MATH 407  MHU Room 103");
	   classes[21] = new String("E 0851 0940  CSE 401   BP  Room 103");
	   classes[22] = new String("E 0941 1030   EE 403   SA  Room 103");
	   classes[23] = new String("E 1031 1050   Break    --     --   ");
	   
	   ct[0] = new String("A 0851 0940  MATH 407  MBH Room 103");
	   ct[1] = new String("C 1231 1320   EE 403   SA  Room 102");
	   ct[2] = new String("E 0851 0940  CSE 401   BP  Room 103");
	   ct[3] = new String("B 0941 1030  CSE 405   BA  Seminar ");
	   ct[4] = new String("D 1231 1320  CSE 407   JR  Room 104");
	   
	   dayIndex();
   }
   
   private void dayIndex()
   {
	   int flag=0;
	   
	   for(int i=0; i<24; i++)
		{
		   if(day.equals(classes[i].substring(0, 1)))
			{
			   if(flag==0)
					dayStartIndex=i;
				
				if(i==23)
					dayEndIndex=i;
				
				flag=1;	
			}
			else
			{
				if(flag==1)
				{
					dayEndIndex=i-1;
					break;	
				}			
			}
		}
   }
   
   public ArrayList<String> wholeDayClassCalculation()
   {
	   ArrayList<String> one = new ArrayList<String>();
	   
	   for(int i=dayStartIndex; i<=dayEndIndex; i++)
	   {
		   one.add(stringCalculation(classes, i));
		} 
	   return one;	   
   }
   
   public ArrayList<String> allDayClassCalculation()
   {
	   ArrayList<String> one = new ArrayList<String>();
	   
	   for(int i=dayStartIndex; i<=23; i++)
	   {					
			one.add(stringCalculation(classes, i));
		} 
	   
	   if(dayStartIndex!=0)
	   {
		   for(int i=0; i<dayStartIndex; i++)
		   {
				one.add(stringCalculation(classes, i));
		   }
		   
	   }
	   
	   return one;	
   }
   
   public ArrayList<String> teacherClassCalculation(String teacherName)
   {
	   ArrayList<String> one = new ArrayList<String>();
	   int hour1 , hour2, min1 , min2;
	   
	   for(int i=0; i<24; i++)
		{
		   if(teacherName.equals(classes[i].substring(13, 22)))
		   {
			    hour1 = Integer.parseInt(classes[i].substring(2,4));
				hour2 = Integer.parseInt(classes[i].substring(7,9));
					
				min1 = Integer.parseInt(classes[i].substring(4,6));
				min2 = Integer.parseInt(classes[i].substring(9,11));
						
				String day = classes[i].substring(0,1);	
				String roomNo = classes[i].substring(27,35);				
						
				String time = hourString(hour1 , hour2, min1 , min2);
						
				String newString = day+"\n"
								+ time +"\n"
								+ roomNo;
						
				one.add(newString);
		   }
		}	   
	   return one;
   }
   
   public ArrayList<String> ctRoutine(int cycle)
   {
	   ArrayList<String> one = new ArrayList<String>();
	   
	   if(cycle%2==0)
	   {
		   for(int i=3; i<=4; i++)
		   {
			   one.add(stringCalculation(ct, i));
		   } 
	   }
	   else
	   {
		   for(int i=0; i<=2; i++)
		   {		
			   one.add(stringCalculation(ct, i));
		   }
	   }
	   
	   return one;
   }
   
   private String stringCalculation(String[] classes, int i)
   {
	   int hour1 , hour2, min1 , min2;
	   
	   hour1 = Integer.parseInt(classes[i].substring(2,4));
	   hour2 = Integer.parseInt(classes[i].substring(7,9));
			
	   min1 = Integer.parseInt(classes[i].substring(4,6));
	   min2 = Integer.parseInt(classes[i].substring(9,11));
				
	   String day = classes[i].substring(0,1);		
	   String course = classes[i].substring(12,22);
	   String teacher = classes[i].substring(23,26);
	   String roomNo = classes[i].substring(27,35);				
				
	   String time = hourString(hour1 , hour2, min1 , min2);
				
	   String newString = day+"\n"
						+ time +"\n"
						+ course + "\n"
						+ teacher + "\n"
						+ roomNo;
	   return newString;
	   
   }
   
   public String nowClassCalulation()
   {
	   int hour1 , hour2, min1 , min2;
	   
	   int flag=0;
	   for(int i=dayStartIndex; i<=dayEndIndex; i++)
		{
			
			hour1 = Integer.parseInt(classes[i].substring(2,4));
			hour2 = Integer.parseInt(classes[i].substring(7,9));
			
			
			min1 = Integer.parseInt(classes[i].substring(4,6));
			min2 = Integer.parseInt(classes[i].substring(9,11));
			
			//System.out.println(hour1+" "+min1+"-"+hour2+" "+min2);

						
			if((hour1==hour2) && (hour1==inputHour))
			{
				if((min1<=inputMinute)&&(min2>=inputMinute))
				{
					flag=1;
				}
				
			}
			else if((hour1<=inputHour)&&(inputHour<=hour2))
			{
				if(hour1==inputHour)
				{
					if(inputMinute>=min1)
					{
						flag=1;
					}
				}
				else if(hour2==inputHour)
				{
					if(inputMinute<=min2)
					{
						flag=1;
					}
				}
				else if(((hour1+1)<=inputHour)&&(inputHour<=(hour2-1)))
				{
					flag=1;
				}
			}
				
			if(flag==1)
			{
				time = hourString(hour1, hour2, min1, min2);
				course = classes[i].substring(12,22);
				teacher = classes[i].substring(23,26);
				roomNo = classes[i].substring(27,35);
				nextIndex=i+1;
				break;
			}		
		}

	   
	  if(flag==1)
	   {		
		   String newString = day+"\n"
			+ time +"\n"
			+ course + "\n"
			+ teacher + "\n"
			+ roomNo;
		   
		   return newString;
	   }
	   else
	   {
		   nextIndex=-1;
		   time = "00.00-00.00";
		   return "No Class";
	   }
	}
   
   private String hourString(int hour1 , int hour2, int  min1 , int min2)
   {
	   String time;
		
		String time1=hourAdjust(hour1)+"."+minAdjust(min1);
		String time2=hourAdjust(hour2)+"."+minAdjust(min2);
		
		time=time1+"-"+time2;
		
		return time;
   }
   
   private String hourAdjust(int hour) 
   {
	   String hourString;
	   
	   if(hour>12)
		{
			hour=hour-12;
			hourString = "0"+hour;
		}
		else if(hour<=9)
		{
			hourString = "0"+hour;
		}
		else
			hourString= ""+hour;
	   
	   return hourString;
	   
   }
   
   private String minAdjust(int min)
   {
	   String minString;
	   
	   if(min<10)
		   minString = "0"+min;
	   else
		   minString = ""+min;
	   
	   return minString;
		   
   }
   
   public int[] nowClassTimeSender()
   {
	   int[] input = new int[2];
	   
	   String hour = time.substring(6,8);
	   int intHour=Integer.parseInt(hour);
	   
	   input[0]=(intHour>0)&&(intHour<=6)?(12+intHour):intHour;
		   
	   String min = time.substring(9,11);
	   input[1] = Integer.parseInt(min);
	   
	   return input;
   }
   
   public String timeRemaining()
   {
	   int[] input = nowClassTimeSender(); 
	   
	   int tempHour = input[0]-inputHour;

	   if(tempHour>=0)
		{	
		
			double totalMinInput = inputMinute+((double)inputSecond/(double)60);
			double finalMinute = ((tempHour*60 + input[1]) - totalMinInput);
			
			if(finalMinute>=0)
			{
				int resultHour = (int)finalMinute/60;
				int resultMinute =(int)finalMinute%60;
				
				
				double temp = (finalMinute - (int)finalMinute)*60;
				int resultSecond = (int)Math.round(temp);
				
				String hourString = (resultHour<10)?("0"+resultHour):(""+resultHour);
				String minuteString = (resultMinute<10)?("0"+resultMinute):(""+resultMinute);
				String secondString = (resultSecond<10)?("0"+resultSecond):(""+resultSecond);
				
				return (hourString+"."+minuteString+"."+secondString);
				
			}
			else
				return "00.00.00";
		}
		else
			return "00.00.00";
   	}
}