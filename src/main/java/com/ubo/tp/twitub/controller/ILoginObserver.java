package com.ubo.tp.twitub.controller;

import com.ubo.tp.twitub.datamodel.User;

public interface ILoginObserver {
	/**
	 * Notification lorsqu'un User se connecte
	 *
	 * @param user
	 */
	void notifyLoggedIn(User user);
}