package com.hospital.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
@Entity
@Table(name="dischargedpatient")
public class DischargedPatient {
	@Id
	@GeneratedValue
	 @Column(name="dp_id")
	 private int dpId;
	 @Column(name="p_id")
	 private int p_Id;
	 @Column(name="disease")
	 private String disease;
	 @Column(name="discharge_date")
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date dischargeDate;
	 @Column(name="amountpaid")
	 private float amountPaid;
	 
	 public DischargedPatient(int dpId,int p_Id,String disease,Date dischargeDate,float amountPaid) {
		 this.dpId=dpId;
		 this.p_Id=p_Id;
		 this.disease=disease;
		 this.dischargeDate=dischargeDate;
		 this.amountPaid=amountPaid;
	 } 
    public DischargedPatient() {
    	
    }
    public int getDpId() {
   	 return dpId;
    }
    public void setDpId(int dpId) {
   	 this.dpId=dpId;
    }
    public int getP_Id(){
   	 return p_Id;
   }
   public void setP_Id(int p_Id) {
   	this.p_Id=p_Id;
   }
   public String getDisease() {
   	return disease;
   }
    public void setDisease(String disease) {
   	 this.disease=disease;
   }
    public Date getDischargeDate() {
   	 return dischargeDate;
   }
   public void setDischargeDate(Date dischargeDate) {
   	this.dischargeDate=dischargeDate;
   } 
   public float getAmountPaid() {
   	return amountPaid;
   }
   public void setAmountPaid(float amountPaid) {
   	this.amountPaid=amountPaid;
   }
}
