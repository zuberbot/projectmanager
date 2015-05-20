/**
 * IProject
 */
package com.myprojects.web.utility;

/**
 * @author Chuck
 *
 */
public interface IProject {

	String ROOT = "/";
	String LOGIN_PATH = "/login";
	String LOGGED_OUT_PATH = "/loggedout";
	String NEW_ACCOUNT_PATH = "/newaccount";
	String CREATE_ACCOUNT = "/createaccount";
	String CREATE_PROJECT_PATH = "/createproject";
	String EDIT_PROJECT_PATH = "/editproject";
	String VIEW_PROJECT_PATH = "/viewmyprojects";
	String DELETE_PROJECT_PATH = "/deleteproject";
	String SEARCH_PROJECTS_PATH = "/searchprojects";
	String DO_SEARCH_PROJECTS_PATH = "/dosearchprojects";
	String SEND_MESSAGE_REPLY_PATH = "/sendmessagereply";
	String SEND_MESSAGE_PATH = "/sendmessage";
	String DO_SEND_MESSAGE = "/dosendmessage";
	String HELP_PATH = "/help";
	String HELP = "help";
	String TEST_DB_CONNECTIVITY = "/testdbconnectivity";

	String HOME = "home";
	String USER_MESSAGES = "userMessages";
	String TEST_DB = "testdb";
	String LOGIN = "login";
	String LOGGED_OUT = "loggedout";
	String USER = "user";
	String USER_NAME = "userName";
	String USER_NAME_LOWER = "username";
	String NEW_ACCOUNT = "newaccount";
	String CAPTCHA_CHALLENGE = "recaptcha_challenge_field";
	String CAPTCHA_RESPONSE = "recaptcha_response_field";
	String CAPTCHA_INVALID = "invalidRecaptcha";
	String ACCOUNT_CREATED = "accountcreated";
	String PROJECT = "project";
	String PROJECT_ID = "projectId";
	String PROJECT_ID_LOWER = "projectid";
	String PROJECT_DETAILS = "projectDetails";
	String PROJECT_ORGANIZATION = "projectOrganization";
	String PROJECT_DELETED = "projectdeleted";
	String PROJECT_SEARCH = "projectSearch";
	String SEARCH_PROJECTS = "searchprojects";
	String SEARCH_STRING = "searchString";
	String SUCCESS = "success";
	String SEARCH_RESULTS = "searchResults";
	String RECEIVER = "receiver";
	String SUBJECT = "subject";
	String USER_MESSAGE = "userMessage";
	String LOGGED_ON_USER = "loggedOnUser";
	String REPLY_SUBJECT = "replySubject";
	String NAME_OF_USER = "nameOfUser";
	String SEND_MESSAGE = "sendMessage";
	String MESSAGE_SENT = "messageSent";
	String REQUEST_MAPPER_CONTROLLER = "requestMapperController";
	String ERROR = "error";
	String MY_PROJECTS_BLOG_DAO = "myProjectBlogsDao";
	String MY_PROJECTS_DAO = "myProjectsDao";
	String ACTIVE = "active";
	String CREATED_DATE = "createdDate";
	String PROJECT_OWNER = "projectOwner";
	String ENABLED = "enabled";
	String PROJECTS_DAO = "projectsDao";
	String PROJECT_SEARCH_DAO = "projectSearchDao";
	String PROJECT_NAME = "projectName";
	String PROJECT_SUMMARY = "projectShortDescription";
	String USER_MESSAGES_DAO = "userMessagesDao";
	String SENDEE = "sendee";
	String USERS_DAO = "usersDao";
	String MY_PROJECT_BLOG_SERVICE = "myProjectBlogsService";
	String MY_PROJECTS_SERVICE = "myProjectsService";
	String USER_MESSAGES_SERVICE = "userMessagesService";
	String USERS_SERVICE = "usersService";
	String YES = "Y";
	String NO = "N";
	String ID = "id";
	
	String PROJECTS_TABLE = "projects";
	String PROJECT_BLOG_TABLE = "project_blog";
	String PROJECT_DETAILS_TABLE = "project_details";
	String PROJECT_ORGANIZATION_TABLE = "project_organization";
	String PROJECT_SEARCH_TABLE = "project_search";
	String USERS_TABLE = "users";
	String USER_MESSAGES_TABLE = "messages";

	String LOGGED_OUT_MSG = "You have logged out.";
	String USER_ALREADY_EXISTS = "User already exists!";
	String VIEWING_USERS_PROJECTS = "> Viewing users projects.";
	String VIEWING_SEARCH_RESULTS = "> Viewing search results.";

	String DUP_KEY_USER_NAME = "DuplicateKey.user.username";
	String INVALID_CAPTCHA = "Invalid.captcha";

	String ROLE_USER = "ROLE_USER";

	String EMPTY_STRING = "";
	String DOUBLE_QUOTE = "\"";
	String HQL_WILDCARD = "%";
	String PERIOD = ".";
	
	String APPLICATION_JSON = "application/json";
	
	String UNCHECKED = "unchecked";
	
	String SELECT_ID_QUERY = "select id from Project where active = :active and projectOwner = :userName";
	String USER_QUERY = "from User where userName = :userName";
	
	String POINTCUT_SHOW_HOME = "execution(* com.myprojects.web.controllers.HomeController.showHome(..))";	
	String POINTCUT_SHOW_HOME_METHOD = "pointcutShowHome()";
	String POINTCUT_VIEW_MY_PROJECTS = "execution(* com.myprojects.web.controllers.MyProjectsController.viewMyProjects(..))";
	String POINTCUT_VIEW_MY_PROJECTS_METHOD = "pointcutViewMyProjects()";
	String POINTCUT_PROJECT_SEARCH_RESULTS_SERVICE = "execution(* com.myprojects.web.service.MyProjectsService.getProjectSearchResult(..))";
	String POINTCUT_PROJECT_SEARCH_RESULTS_SERVICE_METHOD = "pointcutProjectSearchResultsService()";
	
	String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
