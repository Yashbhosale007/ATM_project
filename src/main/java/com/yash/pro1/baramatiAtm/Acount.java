package com.yash.pro1.baramatiAtm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Acount {
	
		@Id
		private int acount_id;
		
		private int acount_no;
		
		private int ac_pin;
		
		private int balance;
		
		@OneToOne
		private empinfo emp_id;

		public int getAcount_id() {
			return acount_id;
		}

		public void setAcount_id(int acount_id) {
			this.acount_id = acount_id;
		}

		public int getAcount_no() {
			return acount_no;
		}

		public void setAcount_no(int acount_no) {
			this.acount_no = acount_no;
		}

		public int getAc_pin() {
			return ac_pin;
		}

		public void setAc_pin(int ac_pin) {
			this.ac_pin = ac_pin;
		}

		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}

		public empinfo getEmp_id() {
			return emp_id;
		}

		public void setEmp_id(empinfo emp_id) {
			this.emp_id = emp_id;
		}

		@Override
		public String toString() {
			return "Acount [acount_id=" + acount_id + ", acount_no=" + acount_no + ", ac_pin=" + ac_pin + ", balance="
					+ balance + ", emp_id=" + emp_id + "]";
		}
		
		
		
		

}
