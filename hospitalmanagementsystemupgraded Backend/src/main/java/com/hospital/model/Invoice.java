package com.hospital.model;
//import java.util.Date;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

//import org.hibernate.mapping.Set;
@Entity
@Table(name="invoice")
public class Invoice {
	@Id
	@GeneratedValue
	 @Column(name="invoice_id")
	 private int id;
	 @Column(name="p_id")
	 private int pId;
	 @Column(name="medicinecost")
	 private float medicineCost;
	 @Column(name="roomcharges")
	 private float roomCharges;
	 @Column(name="doctorcharges")
	 private float doctorCharges;
	 @Column(name="totalamount")
	 private float totalAmount;
	 public Invoice(int id,int pId,float medicineCost,float roomCharges,float doctorCharges,float totalAmount) {
		 this.id=id;
		 this.pId=pId;
		 this.medicineCost=medicineCost;
		 this.roomCharges=roomCharges;
		 this.doctorCharges=doctorCharges;
		 this.totalAmount=totalAmount;
	 }
	 public Invoice(){}
	public int getId() {
		return id;
	}
	 public void setId(int id) 
	 {
		 this.id=id;
	 }
	 public int getPId() {
		 return pId;
	 }
	 public void setPId(int pId)
	 {
		 this.pId=pId;
	 }
	 public float getMedicineCost() {
		 return medicineCost;
	 }
	 public void setMedicineCost(float medicineCost) {
		 this.medicineCost=medicineCost;
	 }
	 public float getRoomCharges() {
		 return roomCharges;
	 }
	 public void setRoomCharges(float roomCharges) {
		 this.roomCharges=roomCharges;
	 }
	 public float getDoctorCharges() {
		 return doctorCharges;
	 }
	 public void setDoctorCharges(float doctorCharges) {
		 this.doctorCharges=doctorCharges;
	 }
	 public float getTotalAmount() {
		 return totalAmount;
	 }
	 public void setTotalAmount(float totalAmount) {
		 this.totalAmount=totalAmount;
	 }
}
