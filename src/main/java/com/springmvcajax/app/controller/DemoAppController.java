package com.springmvcajax.app.controller;

import com.springmvcajax.app.modal.UserModal;
import com.springmvcajax.app.util.DataSetLookUpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DemoAppController {
	/**
	 * LOADING PAGE REQUEST
	 * @return HOME JSP PAGE
	 */
	@RequestMapping(value = "/welcomeProcess.html", method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView mav = new ModelAndView("welcome");
		UserModal userModal = new UserModal();
		userModal.setProvincesList(DataSetLookUpUtil.lookUpProvinces());
		mav.addObject("userReg", userModal);
		return mav;
	}

	@RequestMapping(value = "/registerProcess.html", method = RequestMethod.POST)
	public ModelAndView RegistrationProcess(@ModelAttribute("userReg") UserModal userModal) {

		ModelAndView mav = new ModelAndView("redirect");
		mav.addObject("userReg", userModal);
		userModal = new UserModal();
		userModal.setProvincesList(DataSetLookUpUtil.lookUpProvinces());
		return mav;
	}

	/**
	 * AJAX METHOD USED FOR USER NAME EXSITS
	 * 
	 * @param userName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkUserName.spr", method = RequestMethod.POST)
	public String checkUserName(@RequestParam String userName) {
		if (DataSetLookUpUtil.allUsersList().contains(userName)) {
			return "UserName Is Exsists";
		} else if (userName.isEmpty() || userName == null) {
			return "";
		}
		return "Congrats!";
	}

	/**
	 * Ajax Function Look UP CapitalRegion
	 * 
	 * @param model
	 * @param province
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "lookUpCapitalRegion.spr", method = RequestMethod.POST)
	public String lookUpDistrict(Model model, @RequestParam String province) {
		List<String> list = DataSetLookUpUtil.lookUpCapitalRegion(province);
		String respoceString = list.toString();
		return respoceString.substring(1, respoceString.length() - 2);
	}

	/**
	 * //Ajax Function Look UP MajorCities
	 * 
	 * @param capitalRegion
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "lookUpMajorCities.spr", method = RequestMethod.POST)
	public String jsonValue(@RequestParam String capitalRegion) {
		return DataSetLookUpUtil.generateJsonObject(capitalRegion);
	}
}