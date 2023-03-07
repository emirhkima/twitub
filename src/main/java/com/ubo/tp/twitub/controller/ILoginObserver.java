package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.datamodel.User;

public interface ILoginObserver {
	/**
	 * Notification lorsqu'un User se connecte
	 *
	 * @param user
	 */
	void notifyLoggedIn(User user);
}