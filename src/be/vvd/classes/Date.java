package be.vvd.classes;

import be.vvd.classes.*;;

public class Date{
	private int day;
	private int month;
	private int year;
	private boolean isBissextile;
	private int [] dayPerMonth= {31,0,31,30,31,30,31,31,30,31,30,31};
	
	public Date(int d,int m,int y){
		//Si divisible par 4 => Vérifier si divisible par 100 Sinon => Non Bissextile
		this.isBissextile=isBissextile(y);
		//On déclare le nombre de jour par rapport au booléen
		if(this.isBissextile) {
			this.dayPerMonth[1]=29;
		}else{
			this.dayPerMonth[1]=28;
		}
		
		if((m>=1 && m<=12) || (y<=0 && y>=9999)) {
			if(d>=1 && d<=this.dayPerMonth[m-1]) {
				this.day=d;
				this.month=m;
				this.year=y;
			}
		}
	}
	
	public int getDay() {
		return this.day;
	}
	public int getMonth() {
		return this.month;
	}
	public int getYear() {
		return this.year;
	}
	public int[] getDayPerMonth() {
		return this.dayPerMonth;
	}
	
	
	public void add1Day() {
		this.day++;
	}
	public void add1Month() {
		this.month++;
	}
	public void add1Year() {
		this.year++;
	}
	
	
	public void setDay(int value) {
		this.day=value;
	}
	
	public void setMonth(int value) {
		this.month=value;
	}
	public void setDayPerMonth(int index, int value) {
		this.dayPerMonth[index]=value;
	}
	
	
	public static boolean isBissextile(int y) {
		if(y%4==0) {
			//Si divisible par 100 => Vérifier si divisibles par 400 => Sinon => Bissextile
			if(y%100==0) {
				//Si divisible par 400 => Bissextile sinon => Non Bissextile
				if(y%400==0) {
					return true;
				}else {
					return false;
				}
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	public static Date addDays(Date d,int dayToAdd) {
		for(int i=0;i<dayToAdd;i++) {
			if(d.day<d.dayPerMonth[d.month-1]) {				
				d.day++;
			}else {
				d.day=1;
				if(d.month<d.dayPerMonth.length) {
					d.month++;
				}else {
					d.month=1;
					d.year++;
					d.isBissextile=isBissextile(d.year);
					if(d.isBissextile==true) {
						d.dayPerMonth[1]=29;
					}else {
						d.dayPerMonth[1]=28;
					}
				}
			}
		}
		return d;
	}
	
	public static int betweenTwoDate(Date d1, Date d2) {
		int i=0;
		int temp;
		if(d1.year>d2.year) {
			temp=d1.year;
			d1.year=d2.year;
			d2.year=temp;
			temp=d1.month;
			d1.month=d2.month;
			d2.month=temp;
			temp=d1.day;
			d1.day=d2.day;
			d2.day=temp;
		}
		if(d1.year==d2.year && d1.month>d2.month) {
			temp=d1.month;
			d1.month=d2.month;
			d2.month=temp;
			temp=d1.day;
			d1.day=d2.day;
			d2.day=temp;
		}
		if(d1.month==d2.month && d1.day>d2.day) {
			temp=d1.day;
			d1.day=d2.day;
			d2.day=temp;
		}
		if((d1.year<d2.year) || (d1.month<d2.month) || (d1.day<d2.day)) {
			Date CopyDate = new Date(d1.day,d1.month,d1.year);
			while((CopyDate.day<d2.day) || (CopyDate.month<d2.month) || (CopyDate.year<d2.year)) {
				CopyDate=Date.addDays(CopyDate,1);
				i++;
			}
		}
		return i;
	}
	
	public String toString() {
		return ""+this.day+'/'+this.month+'/'+this.year;
	}
}
