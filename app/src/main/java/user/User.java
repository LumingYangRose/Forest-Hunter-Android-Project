package user;

import java.util.ArrayList;

public class User {

    public String username;
    public String nickname;
    public String password;
    public String security_question;
    public String security_answer;
    public String CLIENT_REGISTRATION_TOKEN;
    public ArrayList<String> highest_score_list;
    public int num_of_gold;
    public ArrayList<Character_sets> Character_setting;
    public ArrayList<String> friend_list;

    public ArrayList<Integer> current_hair_index_list;
    public ArrayList<Integer> current_head_index_list;
    public ArrayList<Integer> current_eye_index_list;
    public ArrayList<Integer> current_nose_index_list;
    public ArrayList<Integer> current_mouth_index_list;
    public ArrayList<Integer> current_l_eye_brow_index_list;
    public ArrayList<Integer> current_r_eye_brow_index_list;
    public ArrayList<Integer> current_ear_index_list;
    public ArrayList<Integer> current_chest_wear_index_list;
    public ArrayList<Integer> current_arm_wear_index_list;
    public ArrayList<Integer> current_shoulder_wear_index_list;
    public ArrayList<Integer> current_leg_wear_index_list;
    public ArrayList<Integer> current_thigh_wear_index_list;
    public ArrayList<Integer> current_bottom_wear_list;
    public ArrayList<Integer> current_foot_wear_list;
    public ArrayList<Integer> current_chest_list;

    public User() {
        this.username = "";
        this.password = "";
        this.highest_score_list = new ArrayList<String>();
        this.num_of_gold = 0;
        this.CLIENT_REGISTRATION_TOKEN = CLIENT_REGISTRATION_TOKEN;
        this.Character_setting = new ArrayList<Character_sets>();
        Character_sets temp = new Character_sets();
        Character_setting.add(temp);
        this.friend_list = new ArrayList<String>();
        friend_list.add("");
        this.security_question = security_question;
        this.security_answer = security_answer;
        this.nickname = "";

        //setup owned character feature
        this.current_hair_index_list = new ArrayList<Integer>();
        this.current_head_index_list = new ArrayList<Integer>();
        this.current_eye_index_list = new ArrayList<Integer>();
        this.current_nose_index_list = new ArrayList<Integer>();
        this.current_mouth_index_list = new ArrayList<Integer>();
        this.current_l_eye_brow_index_list = new ArrayList<Integer>();
        this.current_r_eye_brow_index_list = new ArrayList<Integer>();
        this.current_ear_index_list = new ArrayList<Integer>();
        this.current_chest_wear_index_list = new ArrayList<Integer>();
        this.current_arm_wear_index_list = new ArrayList<Integer>();
        this.current_shoulder_wear_index_list = new ArrayList<Integer>();
        this.current_leg_wear_index_list = new ArrayList<Integer>();
        this.current_thigh_wear_index_list = new ArrayList<Integer>();
        this.current_bottom_wear_list = new ArrayList<Integer>();
        this.current_foot_wear_list = new ArrayList<Integer>();
        this.current_chest_list = new ArrayList<Integer>();

        current_hair_index_list.add(0);
        current_head_index_list.add(0);
        current_eye_index_list.add(0);
        current_nose_index_list.add(0);
        current_mouth_index_list.add(0);
        current_l_eye_brow_index_list.add(0);
        current_r_eye_brow_index_list.add(0);
        current_ear_index_list.add(0);
        current_chest_wear_index_list.add(0);
        current_arm_wear_index_list.add(0);
        current_shoulder_wear_index_list.add(0);
        current_leg_wear_index_list.add(8);
        current_thigh_wear_index_list.add(8);
        current_bottom_wear_list.add(0);
        current_foot_wear_list.add(11);
        current_chest_list.add(0);

    }

    public User(String username, String password, String security_question,String security_answer, String CLIENT_REGISTRATION_TOKEN, ArrayList<String> highest_score_list, int num_of_gold) {
        this.username = username;
        this.password = password;
        this.highest_score_list = highest_score_list;
        this.highest_score_list = new ArrayList<String>();
        this.num_of_gold = num_of_gold;
        this.CLIENT_REGISTRATION_TOKEN = CLIENT_REGISTRATION_TOKEN;
        this.Character_setting = new ArrayList<Character_sets>();
        Character_sets temp = new Character_sets();
        Character_setting.add(temp);
        this.friend_list = new ArrayList<String>();
        friend_list.add("");
        this.security_question = security_question;
        this.security_answer = security_answer;
        this.nickname = "";

        //setup owned character feature
        this.current_hair_index_list = new ArrayList<Integer>();
        this.current_head_index_list = new ArrayList<Integer>();
        this.current_eye_index_list = new ArrayList<Integer>();
        this.current_nose_index_list = new ArrayList<Integer>();
        this.current_mouth_index_list = new ArrayList<Integer>();
        this.current_l_eye_brow_index_list = new ArrayList<Integer>();
        this.current_r_eye_brow_index_list = new ArrayList<Integer>();
        this.current_ear_index_list = new ArrayList<Integer>();
        this.current_chest_wear_index_list = new ArrayList<Integer>();
        this.current_arm_wear_index_list = new ArrayList<Integer>();
        this.current_shoulder_wear_index_list = new ArrayList<Integer>();
        this.current_leg_wear_index_list = new ArrayList<Integer>();
        this.current_thigh_wear_index_list = new ArrayList<Integer>();
        this.current_bottom_wear_list = new ArrayList<Integer>();
        this.current_foot_wear_list = new ArrayList<Integer>();
        this.current_chest_list = new ArrayList<Integer>();

        current_hair_index_list.add(0);
        current_head_index_list.add(0);
        current_eye_index_list.add(0);
        current_nose_index_list.add(0);
        current_mouth_index_list.add(0);
        current_l_eye_brow_index_list.add(0);
        current_r_eye_brow_index_list.add(0);
        current_ear_index_list.add(0);
        current_chest_wear_index_list.add(0);
        current_arm_wear_index_list.add(0);
        current_shoulder_wear_index_list.add(0);
        current_leg_wear_index_list.add(8);
        current_thigh_wear_index_list.add(8);
        current_bottom_wear_list.add(0);
        current_foot_wear_list.add(11);
        current_chest_list.add(0);
    }

    public User(String username, String password,  String security_question,String security_answer, String CLIENT_REGISTRATION_TOKEN) {
        this.username = username;
        this.password = password;
        this.friend_list = new ArrayList<String>();
        this.highest_score_list = new ArrayList<String>();
        this.highest_score_list.add("");
        this.highest_score_list.add("");
        this.num_of_gold = 0;
        this.CLIENT_REGISTRATION_TOKEN = CLIENT_REGISTRATION_TOKEN;
        this.Character_setting = new ArrayList<Character_sets>();
        Character_sets temp = new Character_sets();
        Character_setting.add(temp);
        this.friend_list = new ArrayList<String>();
        friend_list.add("");
        this.security_question = security_question;
        this.security_answer = security_answer;
        this.nickname = "";

        //setup owned character feature
        this.current_hair_index_list = new ArrayList<Integer>();
        this.current_head_index_list = new ArrayList<Integer>();
        this.current_eye_index_list = new ArrayList<Integer>();
        this.current_nose_index_list = new ArrayList<Integer>();
        this.current_mouth_index_list = new ArrayList<Integer>();
        this.current_l_eye_brow_index_list = new ArrayList<Integer>();
        this.current_r_eye_brow_index_list = new ArrayList<Integer>();
        this.current_ear_index_list = new ArrayList<Integer>();
        this.current_chest_wear_index_list = new ArrayList<Integer>();
        this.current_arm_wear_index_list = new ArrayList<Integer>();
        this.current_shoulder_wear_index_list = new ArrayList<Integer>();
        this.current_leg_wear_index_list = new ArrayList<Integer>();
        this.current_thigh_wear_index_list = new ArrayList<Integer>();
        this.current_bottom_wear_list = new ArrayList<Integer>();
        this.current_foot_wear_list = new ArrayList<Integer>();
        this.current_chest_list = new ArrayList<Integer>();

        current_hair_index_list.add(0);
        current_head_index_list.add(0);
        current_eye_index_list.add(0);
        current_nose_index_list.add(0);
        current_mouth_index_list.add(0);
        current_l_eye_brow_index_list.add(0);
        current_r_eye_brow_index_list.add(0);
        current_ear_index_list.add(0);
        current_chest_wear_index_list.add(0);
        current_arm_wear_index_list.add(0);
        current_shoulder_wear_index_list.add(0);
        current_leg_wear_index_list.add(8);
        current_thigh_wear_index_list.add(8);
        current_bottom_wear_list.add(0);
        current_foot_wear_list.add(11);
        current_chest_list.add(0);
    }

}
