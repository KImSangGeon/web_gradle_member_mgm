package web_gradle_member_mgn.dao;

import java.util.List;

import web_gradle_member_mgn.dto.Member;

public interface MemberDao {
		Member selectMemberById(Member member);
	
		
		List<Member> SelectByAllCustomer();
		Member getCustomerInformation(Member member);
		
		int insertMember(Member member);
		int deleteMember(Member member);
}
