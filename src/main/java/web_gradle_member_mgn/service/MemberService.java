package web_gradle_member_mgn.service;

import java.util.List;

import web_gradle_member_mgn.dao.impl.MemberDaoImpl;
import web_gradle_member_mgn.ds.jndiDS;
import web_gradle_member_mgn.dto.Member;

public class MemberService {
	private MemberDaoImpl dao;
	
	public MemberService() {
		dao = MemberDaoImpl.getInstance();
		dao.setCon(jndiDS.getConnection());		
	}	
	public Member loginMember(Member member) {
		return dao.selectMemberById(member);
	}
	
	public void InsertCustomer(Member member) {
		dao.insertMember(member);
	}
	
	public List<Member> SelectByAllCustomer(){
		return dao.SelectByAllCustomer();
	}
	public Member GetCustomerInformation(Member member) {
		return dao.getCustomerInformation(member);
	}
	public void deleteCustomer(Member member) {
		dao.deleteMember(member);
	}
	

}
