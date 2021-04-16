package web_gradle_member_mgn.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_gradle_member_mgn.dao.impl.MemberDaoImpl;
import web_gradle_member_mgn.ds.JdbcUtil;
import web_gradle_member_mgn.dto.Member;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDaoTest {
	private static Connection con;
	private MemberDaoImpl dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
//		MemberDaoImpl.java 가 수행되기 전 호출
		con= JdbcUtil.getConnection();
		
	}
	@Before
	public void setUp() throws Exception {
		//Test method가 호출되기 전에 호출
		dao = MemberDaoImpl.getInstance();
		dao.setCon(con);		
	}


	@Test
	public void test01SelectMemberByIdSuccess() {
		System.out.println("testSelectMemberById()  -succes");
		Member member = new Member("1", "1111");
		Member memberLogin = dao.selectMemberById(member);
		
		Assert.assertNotNull(memberLogin);		
		
	}
	
	@Test
	public void test02SelectMemberByIdFail() {
		System.out.println("testSelectMemberById()  - fail");
		Member member = new Member("1", "1112");
		Member memberLogin = dao.selectMemberById(member);		
		Assert.assertNull(memberLogin);			
		
	}
	@Test
	public void test03InsertMember() {		
		System.out.println("testInsertMember");
		Member member = new Member("222" ,"tt", "김미정", 26, "여자", "rkfkgj@naver.com");
		int res = dao.insertMember(member);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectMemberById(member));
	} 
	
	@Test
	public void test04SelectByAllCustomer() {
		System.out.println("testSelectByAllCustomer");
		List<Member> memberList = dao.SelectByAllCustomer();
		Assert.assertNotNull(memberList);
		for(Member m : memberList) {			
			System.out.println(m);
		}
	}
	@Test 
	public void test05GetCustomerInformation() {
		System.err.println("testGetCustomerInformation");
		Member member = new Member("admin");
		Member mem = dao.getCustomerInformation(member);
		Assert.assertNotNull(mem);
		System.out.println(mem);
		}
	
	@Test 	
	public void test06DeleteMember() {
		System.out.println("testDeleteMember");
		Member member = new Member("222");
		int res = dao.deleteMember(member);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectMemberById(member));
	}

}
