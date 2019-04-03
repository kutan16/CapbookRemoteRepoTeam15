 package com.cg.capbook.beans;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.SequenceGenerator;

 @Entity
 public class Relationship {
 	@Id
 	@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
 	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
 	private Integer relationId;
 	private String senderEmailId;
 	private String receiverEmailId;
 	private String status;
 	
 	public Relationship() {}

 	public Relationship(Integer relationId, String senderEmailId, String receiverEmailId, String status) {
 		super();
 		this.relationId = relationId;
 		this.senderEmailId = senderEmailId;
 		this.receiverEmailId = receiverEmailId;
 		this.status = status;
 	}
 	public Integer getrelationId() {
 		return relationId;
 	}
 	public void setrelationId(Integer relationId) {
 		this.relationId = relationId;
 	}
 	public String getSenderEmailId() {
 		return senderEmailId;
 	}
 	public void setSenderEmailId(String senderEmailId) {
 		this.senderEmailId = senderEmailId;
 	}
 	public String getReceiverEmailId() {
 		return receiverEmailId;
 	}
 	public void setReceiverEmailId(String receiverEmailId) {
 		this.receiverEmailId = receiverEmailId;
 	}
 	public String getStatus() {
 		return status;
 	}
 	public void setStatus(String status) {
 		this.status = status;
 	}
 	@Override
 	public String toString() {
 		return "Relationship [relationId=" + relationId + ", senderEmailId=" + senderEmailId + ", receiverEmailId="
 				+ receiverEmailId + ", status=" + status + "]";
 	}
 	@Override
 	public int hashCode() {
 		final int prime = 31;
 		int result = 1;
 		result = prime * result + ((receiverEmailId == null) ? 0 : receiverEmailId.hashCode());
 		result = prime * result + ((relationId == null) ? 0 : relationId.hashCode());
 		result = prime * result + ((senderEmailId == null) ? 0 : senderEmailId.hashCode());
 		result = prime * result + ((status == null) ? 0 : status.hashCode());
 		return result;
 	}
 	@Override
 	public boolean equals(Object obj) {
 		if (this == obj)
 			return true;
 		if (obj == null)
 			return false;
 		if (getClass() != obj.getClass())
 			return false;
 		Relationship other = (Relationship) obj;
 		if (receiverEmailId == null) {
 			if (other.receiverEmailId != null)
 				return false;
 		} else if (!receiverEmailId.equals(other.receiverEmailId))
 			return false;
 		if (relationId == null) {
 			if (other.relationId != null)
 				return false;
 		} else if (!relationId.equals(other.relationId))
 			return false;
 		if (senderEmailId == null) {
 			if (other.senderEmailId != null)
 				return false;
 		} else if (!senderEmailId.equals(other.senderEmailId))
 			return false;
 		if (status == null) {
 			if (other.status != null)
 				return false;
 		} else if (!status.equals(other.status))
 			return false;
 		return true;
 	}
 }