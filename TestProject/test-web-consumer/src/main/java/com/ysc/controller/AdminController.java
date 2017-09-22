package com.ysc.controller;

import com.ysc.model.Admin;
import com.ysc.service.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("AdminController")
public class AdminController {

	@Autowired
	private AdminServiceInterface adminServiceInterface;

	@RequestMapping("addAdmin.do")
	public String addAdmin(Admin admin){
		adminServiceInterface.addAdmin(admin);
		return "../admin/success.jsp";
	}
	
	@RequestMapping("selectAdmin.do")
	//获取所有类别，并传到listType.jsp
	public ModelAndView selectAllType(Admin admin){
		List<Admin> list = adminServiceInterface.selectAdmin(admin);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("../admin/listAdmin.jsp");
		andView.addObject("list",list);
		return andView;
	}
	@RequestMapping("editAdmin.do")
	//在listType页面点击修改后进入这里,根据id找到相应的type，传给editType.jsp
	public ModelAndView editType(HttpServletRequest request){
		System.out.println("edit---------------------");
		String id=request.getParameter("id");
		System.out.println("id---------------"+id);
		Admin admin=new Admin();
		admin.setId(Integer.parseInt(id));
		//根据id获取整个type的信息
		List<Admin> list=adminServiceInterface.selectAdmin(admin);
		ModelAndView andView = new ModelAndView();
		andView.addObject("admin",list.get(0));
		andView.setViewName("../admin/editAdmin.jsp");
		return andView;
	}
	@RequestMapping("updateAdmin.do")
	//修改商品类别，执行完后跳向selectAdmin.do，显示修改后的结果
	public String updateAdmin(Admin admin){
		adminServiceInterface.updateAdmin(admin);
		return "redirect:selectAdmin.do";
	}
	@RequestMapping("deleteAdmin.do")
	public String deleteType(HttpServletRequest request){
		String id=request.getParameter("id");
		Admin admin = new Admin();
		admin.setId(Integer.parseInt(id));
		//删除
		adminServiceInterface.deleteAdmin(admin);
		return "redirect:selectAdmin.do";
	}
}
