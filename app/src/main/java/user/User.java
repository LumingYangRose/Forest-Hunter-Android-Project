package user;

import java.util.ArrayList;

public class User {

    public String username;
    public String password;
    public String security_question;
    public String security_answer;
    public String CLIENT_REGISTRATION_TOKEN;
    public int highest_score;
    public int num_of_gold;
    public ArrayList<Character_sets> Character_setting;
    public ArrayList<String> friend_list;

    public User() {

    }

    public User(String username, String password, String security_question,String security_answer, String CLIENT_REGISTRATION_TOKEN, int highest_score, int num_of_gold) {
        this.username = username;
        this.password = password;
        this.highest_score = highest_score;
        this.num_of_gold = num_of_gold;
        this.CLIENT_REGISTRATION_TOKEN = CLIENT_REGISTRATION_TOKEN;
        this.Character_setting = new ArrayList<Character_sets>();
        Character_sets temp = new Character_sets();
        Character_setting.add(temp);
        this.friend_list = new ArrayList<String>();
        friend_list.add("");//TODO
    }

    public User(String username, String password,  String security_question,String security_answer, String CLIENT_REGISTRATION_TOKEN) {
        this.username = username;
        this.password = password;
        this.highest_score = 0;
        this.num_of_gold = 0;
        this.CLIENT_REGISTRATION_TOKEN = CLIENT_REGISTRATION_TOKEN;
        this.Character_setting = new ArrayList<Character_sets>();
        Character_sets temp = new Character_sets();
        Character_setting.add(temp);
        this.friend_list = new ArrayList<String>();
        friend_list.add(""); //TODO
    }

}
