package main.java.com.ubo.tp.twitub.core;

import java.io.File;

import main.java.com.ubo.tp.twitub.controller.ILoginObserver;
import main.java.com.ubo.tp.twitub.controller.LoginController;
import main.java.com.ubo.tp.twitub.controller.TwitsController;
import main.java.com.ubo.tp.twitub.ihm.TwitsView;
import main.java.com.ubo.tp.twitub.listener.LoginListener;
import main.java.com.ubo.tp.twitub.datamodel.*;
import main.java.com.ubo.tp.twitub.events.file.IWatchableDirectory;
import main.java.com.ubo.tp.twitub.events.file.WatchableDirectory;
import main.java.com.ubo.tp.twitub.ihm.AuthenticationView;
import main.java.com.ubo.tp.twitub.ihm.DirectoryPicker;
import main.java.com.ubo.tp.twitub.ihm.TwitubMock;

/**
 * Classe principale l'application.
 * 
 * @author S.Lucas
 */
public class Twitub implements ILoginObserver {
	/**
	 * Base de données.
	 */
	protected IDatabase mDatabase;

	/**
	 * Gestionnaire des entités contenu de la base de données.
	 */
	protected EntityManager mEntityManager;

	/**
	 * Vue principale de l'application.
	 */
	protected DirectoryPicker mMainView;

	/**
	 * Classe de surveillance de répertoire
	 */
	protected IWatchableDirectory mWatchableDirectory;

	/**
	 * Répertoire d'échange de l'application.
	 */
	protected String mExchangeDirectoryPath;

	/**
	 * Idnique si le mode bouchoné est activé.
	 */
	protected boolean mIsMockEnabled = true;

	/**
	 * Nom de la classe de l'UI.
	 */
	protected String mUiClassName;

	protected User user;

	/**
	 * Constructeur.
	 */
	public Twitub() {
		// Init du look and feel de l'application
		this.initLookAndFeel();

		// Initialisation de la base de données
		this.initDatabase();

		if (this.mIsMockEnabled) {
			// Initialisation du bouchon de travail
			this.initMock();
		}

		// Initialisation de l'IHM
		this.initGui();

		// Initialisation du répertoire d'échange
		this.initDirectory();
	}

	/**
	 * Initialisation du look and feel de l'application.
	 */
	protected void initLookAndFeel() {
	}

	/**
	 * Initialisation de l'interface graphique.
	 */
	protected void initGui() {
		DatabaseObserver databaseObserver = new DatabaseObserver();
		this.mDatabase.addObserver(databaseObserver);

		this.mMainView = new DirectoryPicker();

		try {
			AuthenticationView frame = new AuthenticationView();
			LoginController controller = new LoginController(frame, this.mDatabase, this);

			controller.addObserver(this);

			frame.addLoginListener(new LoginListener(controller, frame, mDatabase));
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialisation de l'interface graphique.
	 */
	public void initMainView() {
		DatabaseObserver databaseObserver = new DatabaseObserver();
		this.mDatabase.addObserver(databaseObserver);

		try {
			System.out.println(this.mDatabase.getUserTwits(user).size());
			TwitsView frame = new TwitsView(this.mDatabase.getUserTwits(this.user));
			TwitsController controller = new TwitsController(frame, this.mDatabase, this.user);

			controller.addObserver(this);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialisation du répertoire d'échange (depuis la conf ou depuis un file
	 * chooser). <br/>
	 * <b>Le chemin doit obligatoirement avoir été saisi et être valide avant de
	 * pouvoir utiliser l'application</b>
	 */
	protected void initDirectory() {
		this.initDirectory(this.mMainView.getSelectedDirectory());
	}

	/**
	 * Indique si le fichier donné est valide pour servire de répertoire
	 * d'échange
	 * 
	 * @param directory
	 *            , Répertoire à tester.
	 */
	protected boolean isValideExchangeDirectory(File directory) {
		// Valide si répertoire disponible en lecture et écriture
		return directory != null && directory.exists() && directory.isDirectory() && directory.canRead()
				&& directory.canWrite();
	}

	/**
	 * Initialisation du mode bouchoné de l'application
	 */
	protected void initMock() {
		TwitubMock mock = new TwitubMock(this.mDatabase, this.mEntityManager);
		mock.showGUI();
	}

	/**
	 * Initialisation de la base de données
	 */
	protected void initDatabase() {
		mDatabase = new Database();
		mEntityManager = new EntityManager(mDatabase);
	}

	/**
	 * Initialisation du répertoire d'échange.
	 * 
	 * @param directoryPath
	 */
	public void initDirectory(String directoryPath) {
		mExchangeDirectoryPath = directoryPath;
		mWatchableDirectory = new WatchableDirectory(directoryPath);
		mEntityManager.setExchangeDirectory(directoryPath);

		mWatchableDirectory.initWatching();
		mWatchableDirectory.addObserver(mEntityManager);
	}

	public void show() {

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void notifyLoggedIn(User user) {
		System.out.println("User logged in : " + user.getUserTag());
		this.initMainView();
	}
}
