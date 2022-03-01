package com.hospital.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="appointments")
public class Appointment {
	@Id
	@GeneratedValue
	@Column(name="AP_ID ")
	private int ap_id ;
	@Column(name="P_ID ")
	private int p_id;
	@Column(name="ADDRESS  ")
	private String address;
	@Column(name=" D_ID")
	private int d_id;
	@Column(name="AP_DATE ")
	//@Temporal(TemporalType. DATE)
	private String ap_date  ;
	@Column(name="AP_TIME ")
	//@Temporal(TemporalType.TIMESTAMP)
	private String ap_time ;
	@Column(name="AP_STATUS ")
	private String ap_status ;
	@Column(name="Disease ")
	private String disease ;
	public Appointment(int ap_id,int p_id,String disease,String address,int d_id, String ap_date,String ap_time,String ap_status ) {
		super();
		this.ap_id = ap_id;
		this.p_id = p_id;
		this.disease=disease;
		this.address = address;
		this.d_id = d_id;
		this.ap_date=ap_date ;
		this.ap_time = ap_time;
		this.ap_status = ap_status;	
	}
	
	public Appointment()
	{
		
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}


	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public int getAp_id() {
		return ap_id;
	}

	public void setAp_id(int ap_id) {
		this.ap_id = ap_id;
	}
	
	public String getAp_date() {
		return ap_date;
	}

	public void setAp_date(String ap_date ) {
		this.ap_date =ap_date ;
	}	
	public String getAp_time() {
		return ap_time;
	}

	public void setAp_time(String ap_time) {
		this.ap_time = ap_time;
	}	
	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public String getAp_status() {
		return ap_status;
	}

	public void setAp_status(String ap_status) {
		this.ap_status = ap_status;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}
}
