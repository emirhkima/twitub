package main.java.com.ubo.tp.twitub.datamodel;

import main.java.com.ubo.tp.twitub.common.Constants;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe représentant les donénes chargées dans l'application.
 * 
 * @author S.Lucas
 */
public class DatabaseObserver implements IDatabaseObserver {
	@Override
	public void notifyTwitAdded(Twit addedTwit) {
		System.out.println("Twit added : " + addedTwit.getText());
	}

	@Override
	public void notifyTwitDeleted(Twit deletedTwit) {
		System.out.println("Twit deleted : " + deletedTwit.getText());
	}

	@Override
	public void notifyTwitModified(Twit modifiedTwit) {
		System.out.println("Twit modified : " + modifiedTwit.getText());
	}

	@Override
	public void notifyUserAdded(User addedUser) {
		System.out.println("User added : " + addedUser.getUserTag());
	}

	@Override
	public void notifyUserDeleted(User deletedUser) {
		System.out.println("User deleted : " + deletedUser.getUserTag());
	}

	@Override
	public void notifyUserModified(User modifiedUser) {
		System.out.println("User modified : " + modifiedUser.getUserTag());
	}
}
