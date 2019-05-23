package com.zomato_demo.common;


/**
 * Created by asif on 13-02-2018.
 */

public class Const {

    public static final String BASE_URL="https://developers.zomato.com/api/v2.1/";


    public static final String SHARED_PREF = "one8crew_pref";


        public static final String STORE_LIST_URL = "stores/listing?page=1&limit=3";


        public static final String STORE_DETAILS_LIST_URL = "stores/info";



    public static class Pref {
        public static final String TEMP_DATA = "temp_data";
        public static final String USER_DATA = "user_data";
        public static final String PUSH_DATA = "push_data";
        public static final String COUNTRY_CODE = "country_code";
        public static final String TOKEN_DATA = "token_data";
        public static final String HOME_DATA = "home_data";
        public static final String SOCIAL_FEED_DATA = "social_feed_data";
        public static final String STORE_DATA = "store_data";
        public static final String LOGIN_TYPE = "login_type";
        public static final String STORE_DETAILS_DATA = "store_details_data";
        public static final String NEWS_FEED_DATA = "news_feed_data";
        public static final String LIVE_SCHEDULE_DATA = "live_schedule_data";
        public static final String DOWNLOAD_LIST_DATA = "download_list_data";
        public static final String GALLERY_FEED_DATA = "gallery_feed_data";
        public static final String WALKTHROUGH_STATUS = "walkthrough_status";
        public static final String CHALLENGE_DATA = "challenge_data";
        public static final String LIVE_COUNT_DOWN_DATA = "live_count_down_data";
        public static final String ONGOING_CHALLENGE_DATA = "ongoing_challenge_data";
        public static final String CHALLENGE_VIRAT_USER_DATA = "challenge_virat_user_data";
        public static final String CHALLENGE_USER_INNER_DATA = "challenge_user_inner_data";
    }

    public static class Fragments {
        public static final String HOME_FRAG = "home_fragment";
        public static final String JOURNEY_FRAG = "journey_fragment";
        public static final String QUIZ_FRAG = "quiz_fragment";
        public static final String STORE_FRAG = "store_fragment";
        public static final String MORE_FRAG = "more_fragment";
    }

    public static class Local {
        public static final String RESTAURANT = "restaurant";
        public static final String SEARCH = "search";
        public static final String ITEM_POSITION = "item_position";
        public static final String NO_OF_PEOPLES = "no_of_peoples";
        public static final String BANNER = "banner";
        public static final String CHALLENGE_ID = "challenge_id";
        public static final String PARTICIPANT_ID = "participant_id";
        public static final String COMPARE = "compare";
        public static final String RECOMMED = "recommend";
        public static final String NEWS = "news";
        public static final String PRODUCT = "product";
        public static final String RELOAD = "reload";
        public static final String RELOAD_TO_FIRST = "reload_to_first";
        public static final String ORIENTATION_LANDSCAPE = "orientation_landscape";
        public static final String ORIENTATION = "orientation";
        public static final String ORIENTATION_PORTRAIT = "orientation_portrait";
        public static final String FAN_RELOAD = "fan_reload";
        public static final String ID = "id";
        public static final String CHALLENGES_CHALLENGEVIRATUSERACTIVITY = "challenges.ChallengeViratUserActivity";
        public static final String CHALLENGES_CHALLENGESUSERINNERACTIVITY = "challenges.ChallengesUserInnerActivity";
        public static final String CATEGORY_TYPE = "category_type";
        public static final String CATEGORY_ID = "category_id";
        public static final int CHALLENGE_VIRAT_USERACTIVITY = 104;
        public static final int VIRAT_PARTICIPATED = 105;
        public static int RESULT_LOAD_IMAGE = 189;
        public static final int READ_EXTERNAL_STORAGE = 145;
    }

    public static class Params {
        public static final String ID = "id";
        public static final String EMAIL = "email";
        public static final String NAME = "fullname";
        public static final String USERNAME = "username";
        public static final String PHONE = "phone_number";
        public static final String COUNTRY_CODE = "country_code";
        public static final String PASSWORD = "password";
        public static final String OTP = "otp";
        public static final String TYPE = "type";
        public static final String OTP_TYPE = "otp_type";
        public static final String VALUE = "value";
        public static final String IS_LIKE = "is_like";
        public static final String IS_VIEW = "is_view";
        public static final String GRANT_TYPE = "grant_type";
        public static final String REFRESH_TOKEN = "refresh_token";
        public static final String LOGIN_TYPE = "login_type";
        public static final String SOCIAL_ID = "social_id";
        public static final String SOCIAL_ACCESS_TOKEN = "social_access_token";
        public static final String PROFILE_PIC_URL = "profile_pic_url";
        public static final String PROFILE_ID = "profile_id";
        public static final String VERSION_CODE = "version_code";
        public static final String NOTIFICATION_STATUS = "notification_status";
        public static final String AUTH_FAILED = "auth_failed";
        public static final String URL = "url";
        public static final String CHALLENGE_ID = "challenge_id";
        public static final String VIDEO_ID = "video_id";
        public static final String DESCRIPTION = "description";
        public static final String PARTICIPANT_ID = "participant_id";
        public static final String COMMENTS = "comments";
        public static final String COMMENT = "comment";
        public static final String COMMENTS_TYPE = "comment_type";
        public static final String COMMENT_ID = "comment_id";
        public static final String CHALLENGE_TITLE = "challenge_title";
        public static final String FILE_TYPE = "file_type";
        public static final String UPLOAD_FILE = "upload_file";
        public static final String FROM_DATE = "from_date";
        public static final String DATE = "date";
        public static final String TO_DATE = "to_date";
        public static final String TIME = "time";
        public static final String TITLE = "title";
        public static final String SCHEDULE_ID = "schedule_id";
        public static final String KEY_MESSAGE = "message";
        public static final String KEY_LOCAL_BROADCAST = "broadcast_id";

        public static final String KEY_FAN_ID = "fan_id";
        public static final String KEY_VALUE = "value";
        public static final String KEY_IS_LIKE = "is_like";
        public static final String KEY_IS_VIEW = "is_view";
        public static final String CALENDAR_TIME = "calendar_time";
        public static final String POSITION = "pager_position";
    }

    public interface HTTPConstants {
        String TYPE = "type";
        String FROM_DATE = "from_date";
        String TO_DATE = "to_date";
        String VIRAT = "virat";
        String TEAM = "team";
        String BOWLER = "bowler";
        String STADIUM = "stadium";
    }

    public static class Status {
        public static final int OPERATION_SUCCESS = 200;
        public static final int EMPTY_DATA = 200;
        public static final int SESSION_EXPIRY = 1001;
        public static final int INVALID_ACCESS_TOKEN_EXPIRED = 1005;

    }

    public static class WowzaLive {
        public static final String API_LICENSE_KEY = "GOSK-D744-0103-A8C2-680A-C488";
        public static final String HOST_ADDRESS = "5523f7.entrypoint.cloud.wowza.com";
        public static final int PORT_NUMBER = 1935;
        public static final String APPLICATION_NAME = "app-2bdd";
        public static final String STREAM_NAME = "d4915ba8";
    }

    public static class DialogArgs {
        public static final int DIALOG_DATE_PICKER = 0;
        public static final int DIALOG_TIME_PICKER = 1;
        public static final String KEY_WHICH_DIALOG = "which";
    }

    public static class Actions {
        public static String ACTION_GET_RESPONSE_VK_CONNECT = "ACTION_GET_RESPONSE_VK_CONNECT";
    }

    public static class Analytics {
        public static final String login = "Login";
        public static final String phone_number = "PhoneNumber";
        public static final String status = "Status";
        public static final String login_type = "LoginType";
        public static final String create_type = "CreateType";
        public static final String success = "Success";
        public static final String fail = "Fail";
        public static final String facebook = "Facebook";
        public static final String google = "Google";
        public static final String normal = "Normal";
        public static final String email = "Email";
        public static final String name = "Name";
        public static final String registration = "Registration";
        public static final String news = "News";
        public static final String store = "Store";
        public static final String store_name = "StoreName";
        public static final String product = "Product";
        public static final String product_name = "ProductName";
        public static final String product_id = "ProductID";
        public static final String price = "Price";
        public static final String article_name = "ArticleName";
        public static final String challenge_finished = "ChallengeFinished";
        public static final String challenge_name = "ChallengeName";
        public static final String downloads = "Downloads";
        public static final String type = "Type";
        public static final String id = "ID";
        public static final String post_text = "PostText";
        public static final String take_the_challenge = "TakeTheChallenge";
        public static final String challenge_title = "ChallengeTitle";
        public static final String create_challenge = "CreateChallenge";
        public static final String exclusive_video = "Exclusive_video";
        public static final String video_title = "VideoTitle";
        public static final String home = "Home";
        public static final String banner_click = "BannerClick";
        public static final String category_click = "CategoryClick";
        public static final String quiz_name = "QuizName";
        public static final String quiz = "Quiz";
        public static final String journey = "Journey";
        public static final String journey_stats = "Journey - stats";
        public static final String offer_claimed = "OfferClaimed";
        public static final String redeem_name = "RedeemName";
        public static final String stadium_name = "StadiumName";
        public static final String team_name = "TeamName";
        public static final String date = "Date";
        public static final String coupons = "Coupons";
        public static final String friend = "Friend";
        public static final String global = "Global";
        public static final String click = "Click";
        public static final String compare_to_date = "CompareToDate";
        public static final String viral_quiz_leaderboard = "ViralQuizLeaderboard";
        public static final String action = "Action";
        public static final String label = "Label";

    }


}
