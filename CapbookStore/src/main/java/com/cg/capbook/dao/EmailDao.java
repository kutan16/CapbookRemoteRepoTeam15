//package com.cg.capbook.daoservices;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.cg.capbook.beans.Email;
////abcd
//public interface EmailDao extends JpaRepository<Email, Integer>{
//	@Query("select e from Email e where e.toEmail =:emailId")
//	public List<Email> getAllEmailsOfUser(@Param("emailId") String emailId);
//	
//	@Query("select e from Email e where e.fromEmail =:emailId")
//	public List<Email> getAllSentEmailsOfUser(@Param("emailId") String  emailId);
//	
//	@Query("from Email where TO_EMAIL =:emailId and EM_ID=:Id")
//	public Email getEmailRecieved(@Param("emailId") String emailId,@Param("Id") int Id);
//	
//	@Query("from Email where FROM_EMAIL =:emailId and EM_ID=:Id")
//	public Email getEmailSent(@Param("emailId") String emailId,@Param("Id") int Id);
//}
