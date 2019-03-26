package com.boba.web;

public interface Navigation {

	String THEME = "/themes";

	String LOAD = "/load";
	String START_VOTING = "/start-voting";
	String CLOSE_VOTING = "/close-voting";
	String VOTE = "/vote";

	String ALL = "/all";
	String STATISTICS = "/statistics";

	String THEME_ID = "themeId";
	String LINK = "link";
	String VARIANT_ID = "variantId";
	String THEME_ID_PARAM = "/{" + THEME_ID + "}";
	String LINK_PARAM = "/{" + LINK + "}";
	String VARIANT_PARAM = "/{" + VARIANT_ID + "}";

	String LOAD_ALL = LOAD + ALL;
	String ADD = "/add";
	String START_VOTING_BY_ID = START_VOTING + THEME_ID_PARAM;
	String CLOSE_VOTING_BY_ID = CLOSE_VOTING + THEME_ID_PARAM;
	String LOAD_BY_LINK = LOAD + LINK_PARAM;
	String VOTE_BY_LINK_AND_VARIANT_ID = VOTE + LINK_PARAM + VARIANT_PARAM;
	String LOAD_STATISTICS_BY_LINK = STATISTICS + LOAD + LINK_PARAM;

	String IDENTITY_HEADER = "identity";
}
