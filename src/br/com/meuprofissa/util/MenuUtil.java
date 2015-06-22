package br.com.meuprofissa.util;

import java.util.Arrays;
import java.util.List;

import br.com.meuprofissa.dto.Menu;
import br.com.meuprofissa.model.entity.User;

public class MenuUtil {

	public static List<Menu> getMenu(String token, User user) throws Exception {
		if(token != null && token.equalsIgnoreCase(user.getLoginToken())) {
			if(user.getProfile().getId() == Constants.ADMINISTRATOR) {
				return Arrays.asList(new Menu("homeMenu", "#/admin/home"), new Menu("categoryMenu", "#/admin/category"), new Menu("partnerMenu", "#/admin/partner"));
			}else {
				if(user.getProfile().getId() == Constants.PARTNER) {
					return Arrays.asList(new Menu[]{});
				}else {
					return null;
				}
			}
		}else {
			throw new Exception("NOT_LOG_IN");
		}
	}
}
