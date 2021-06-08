package constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Resources {

	public static final String ACCEPT_COOKIES_XPATH = "//*[@id=\"cf-root\"]/div/div/div/div[2]/div[2]/div[1]/button/span";
	public static final String QUIT_BOT_XPATH = "//*[@id=\"intercom-container\"]/div/div/div[1]/div/div/span";
	public static final String QUIT_ANNOUNCEMENT_XPATH = "//*[@id=\"tcp-modal\"]/div/div/div[1]/button";

	public static final String HOME_URL = "https://www.humanity.com/";
	public static final String ABOUT_US_URL = "https://www.humanity.com/about";
	public static final String ABOUT_US_MENU_XPATH = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a";
	public static final String ABOUT_US_XPATH = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[1]/a/p[1]";
	public static final String LOGIN_XPATH = "//*[@id=\"navbarSupportedContent\"]/div/a[2]/p";

	public static final String SHIFT_PLAN_XPATH = "//*[@id=\"sn_schedule\"]/span";

	static DateFormat dayF = new SimpleDateFormat("d");
	static Date dateDay = new Date();
	static String day = dayF.format(dateDay);

	static DateFormat monthF = new SimpleDateFormat("M");
	static Date dateMonth = new Date();
	static String month = monthF.format(dateMonth);
	static int m = Integer.parseInt(month);

	static DateFormat yearF = new SimpleDateFormat("yyyy");
	static Date dateYear = new Date();
	static String year = yearF.format(dateYear);

	public static final String DATE_PtOfLINK = day + "%2c" + (m - 1) + "%2c" + year;
	public static final String SHIFT_PLAN_URL = "https://johncage.humanity.com/app/schedule/employee/week/overview/overview/"
			+ DATE_PtOfLINK + "/";

	public static final String TIME_CLOCK_XPATH = "//*[@id=\"sn_timeclock\"]/span";
	public static final String TIME_CLOCK_URL = "https://johncage.humanity.com/app/timeclock/";

	public static final String LEAVE_XPATH = "//*[@id=\"sn_requests\"]/span";
	public static final String LEAVE_URL = "https://johncage.humanity.com/app/requests/vacation/";

	public static final String TRAINING_XPATH = "//*[@id=\"sn_training\"]/span/p";
	public static final String TRAINING_URL = "https://johncage.humanity.com/app/training/";

	public static final String STAFF_XPATH = "//*[@id=\"sn_staff\"]/span";
	public static final String STAFF_URL = "https://johncage.humanity.com/app/staff/list/load/true/";

	public static final String AVAILABILITY_XPATH = "//*[@id=\"sn_availability\"]/span";
	public static final String AVAILABILITY_URL = "https://johncage.humanity.com/fe/availability/#/requests/week";
	
	public static final String PAYROLL_XPATH = "//*[@id=\"root\"]/div[2]/div/div/div[1]/div/div/div[2]/div[8]/a";
	public static final String PAYROLL_URL = "https://johncage.humanity.com/app/payroll/scheduled-hours/";
	
	public static final String REPORTS_XPATH = "//*[@id=\"sn_reports\"]/span";
	public static final String REPORTS_URL = "https://johncage.humanity.com/app/reports/dashboard/";
	
	public static final String EMP1_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/table/tbody/tr/td[2]/div[2]/div/table/tbody/tr[5]/td[1]";
	
	public static final String firstNameEmp1 = "Zoran";
	public static final String lastNameEmp1 = "Jovanovic";
	public static final String emailEmp1 = "zokaJov@sator.com";
	
	public static final String LIST_EMPLOYEE1_XPATH = "//*[@id=\"7\"]/a";
	
	public static final String EDIT_DETAILS_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]";
	
	public static final String LIST_EMPLOYEE_FIRST_XPATH = "//*[@id=\"7\"]";
	
	public static final String SETTINGS_XPATH = "//*[@id=\"sn_admin\"]/span/i";
	
	public static final String SELECT_LNG_XPATH = "//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[2]/select";
	public static final String PROFILE_SETTINGS_XPATH = "//*[@id=\"userm\"]/div/a[2]";
	

}
