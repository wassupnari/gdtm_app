package com.gdtm.app.intro;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;

/**
 * 
 * @author Nari Kim (wassupnari@gmail.com)
 * 
 */

public class UserInfo {

	private static UserInfo _instance;

	private GraphUser mGraphUser;

	private String mID;
	private String mName;
	private String mEmail;

	private UserInfo() {

		// Constructor hidden
	}

	public static UserInfo getInstance() {

		if (_instance == null) {
			_instance = new UserInfo();
		}
		return _instance;
	}

	public void makeSessionRequest(final Session session) {

		Request request = Request.newMeRequest(session, new Request.GraphUserCallback() {

			@Override
			public void onCompleted(GraphUser user, Response response) {

				if (session == Session.getActiveSession()) {
					if (user != null) {

					}
				}

				if (response.getError() != null) {

				}
			}
		});
		request.executeAsync();
	}

	public void setID(String id) {

		mID = id;
	}

	public void setName(String name) {

		mName = name;
	}

	public void setEmail(String email) {

		mEmail = email;
	}

	public void setWithGraphUser(GraphUser user) {

		mID = user.getId();
		mName = user.getName();
		mGraphUser = user;
	}

	public String getID() {

		return mID;
	}

	public String getName() {

		return mName;
	}

	public String getEmail() {

		return mEmail;
	}

	public boolean isActive() {

		return false;
	}
}
