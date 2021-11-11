package edu.neu.madcourse.forest_hunter;

public class Appearance {

    //TODO Step 1 setyo current index to 0 and then add drawable id into image id list

    public static int current_hair_index = 9;
    public static int current_head_index = 0;
    public static int current_eye_index = 0;
    public static int current_nose_index = 0;
    public static int current_mouth_index = 0;
    public static int current_l_eye_brow_index = 0;
    public static int current_r_eye_brow_index = 0;
    public static int current_ear_index = 0;
    public static int current_chest_wear_index = 0;
    public static int current_arm_wear_index = 0;
    public static int current_shoulder_wear_index = 0;
    public static int current_leg_wear_index = 8;
    public static int current_thigh_wear_index = 8;
    public static int current_bottom_wear_index = 0;
    public static int current_foot_wear_index = 11;
    public static int current_chest_index = 0;


    public int[] hair_image_id_list;
    public int[] head_image_id_list;
    public int[] eye_image_id_list;
    public int[] nose_image_id_list;
    public int[] mouth_image_id_list;
    public int[] l_eye_brow_image_id_list;
    public int[] r_eye_brow_image_id_list;
    public int[] ear_image_id_list;
    public int[] chest_wear_image_id_list;
    public int[][] arm_r_l_wear_image_id_list;
    public int[][] shoulder_r_l_wear_image_id_list;
    public int[][] leg_r_l_wear_image_id_list;
    public int[][] thigh_r_l_wear_image_id_list;
    public int[] bottom_wear_image_id_list;
    public int[][] foot_r_l_wear_image_id_list;
    public int[] chest_image_id_list;


    public Appearance()
    {
        hair_image_id_list = new int[]{R.drawable.hair_1, R.drawable.hair_2, R.drawable.hair_3, R.drawable.hair_4,
                R.drawable.hair_5, R.drawable.hair_6, R.drawable.hair_7, R.drawable.hair_8, R.drawable.hair_9, R.drawable.hair_10, 0};

        head_image_id_list = new int[]{R.drawable.face_1, R.drawable.face_2, R.drawable.face_3, R.drawable.face_4,
                R.drawable.face_5, R.drawable.face_6, R.drawable.face_7, R.drawable.face_8, R.drawable.face_9,
                R.drawable.face_10, R.drawable.face_11, R.drawable.face_12};

        eye_image_id_list = new int[] {R.drawable.open_eyes_1, R.drawable.open_eyes_2, R.drawable.open_eyes_3,
                R.drawable.open_eyes_4, R.drawable.open_eyes_5, R.drawable.open_eyes_6, R.drawable.open_eyes_7,
                R.drawable.open_eyes_8, R.drawable.open_eyes_9, R.drawable.open_eyes_10, R.drawable.open_eyes_11,
                R.drawable.open_eyes_12, R.drawable.open_eyes_13, R.drawable.open_eyes_14, R.drawable.open_eyes_15,
                R.drawable.open_eyes_16, R.drawable.open_eyes_17, R.drawable.open_eyes_18, R.drawable.open_eyes_19,
                R.drawable.open_eyes_20, R.drawable.open_eyes_21, R.drawable.open_eyes_22, R.drawable.open_eyes_23,
                R.drawable.open_eyes_24, R.drawable.open_eyes_25, R.drawable.open_eyes_26, R.drawable.open_eyes_27,
                R.drawable.open_eyes_28, R.drawable.open_eyes_29};

        nose_image_id_list = new int[] {R.drawable.nose_1, R.drawable.nose_2, R.drawable.nose_3,
                R.drawable.nose_4, R.drawable.nose_5, R.drawable.nose_6, R.drawable.nose_7, R.drawable.nose_8,
                R.drawable.nose_9, R.drawable.nose_10, R.drawable.nose_11, R.drawable.nose_12, R.drawable.nose_13};

        mouth_image_id_list = new int[] {R.drawable.mouth_1, R.drawable.mouth_2, R.drawable.mouth_3,
                R.drawable.mouth_4, R.drawable.mouth_5, R.drawable.mouth_6, R.drawable.mouth_7,
                R.drawable.mouth_8, R.drawable.mouth_9, R.drawable.mouth_10, R.drawable.mouth_11,
                R.drawable.mouth_12, R.drawable.mouth_13, R.drawable.mouth_14, R.drawable.mouth_15,
                R.drawable.mouth_16, R.drawable.mouth_17, R.drawable.mouth_18, R.drawable.mouth_19,
                R.drawable.mouth_20, R.drawable.mouth_21, R.drawable.mouth_21, R.drawable.mouth_22,
                R.drawable.mouth_23, R.drawable.mouth_24, R.drawable.mouth_25, R.drawable.mouth_26, R.drawable.mouth_27,
                R.drawable.mouth_28};

        l_eye_brow_image_id_list = new int[] {R.drawable.l_eyebrow_1, R.drawable.l_eyebrow_2, R.drawable.l_eyebrow_3,
                R.drawable.l_eyebrow_4, R.drawable.l_eyebrow_5, R.drawable.l_eyebrow_6, R.drawable.l_eyebrow_7,
                R.drawable.l_eyebrow_8, R.drawable.l_eyebrow_9, R.drawable.l_eyebrow_10, R.drawable.l_eyebrow_11,
                R.drawable.l_eyebrow_12, R.drawable.l_eyebrow_13, R.drawable.l_eyebrow_14, R.drawable.l_eyebrow_15};

        r_eye_brow_image_id_list = new int[] {R.drawable.r_eyebrow_1, R.drawable.r_eyebrow_2, R.drawable.r_eyebrow_3,
                R.drawable.r_eyebrow_4, R.drawable.r_eyebrow_5, R.drawable.r_eyebrow_6, R.drawable.r_eyebrow_7,
                R.drawable.r_eyebrow_8, R.drawable.r_eyebrow_9, R.drawable.r_eyebrow_10, R.drawable.r_eyebrow_11,
                R.drawable.r_eyebrow_12, R.drawable.r_eyebrow_13, R.drawable.r_eyebrow_14, R.drawable.r_eyebrow_15};

        ear_image_id_list = new int[] {R.drawable.ear_1, R.drawable.ear_2, R.drawable.ear_3,
                R.drawable.ear_4, R.drawable.ear_5, R.drawable.ear_6, R.drawable.ear_7,
                R.drawable.ear_8, R.drawable.ear_9};

        chest_wear_image_id_list = new int[] {R.drawable.body_wear_1, R.drawable.body_wear_2,
                R.drawable.body_wear_3, R.drawable.body_wear_4, R.drawable.body_wear_5, R.drawable.body_wear_6,
                R.drawable.body_wear_7, R.drawable.body_wear_8, R.drawable.body_wear_9, R.drawable.body_wear_10,
                R.drawable.body_wear_11, R.drawable.body_wear_12, R.drawable.body_wear_13, R.drawable.body_wear_14,
                R.drawable.body_wear_15, R.drawable.body_wear_16, R.drawable.body_wear_17, R.drawable.transparent_pic};

        arm_r_l_wear_image_id_list = new int[][] {{R.drawable.r_arm_wear_1, R.drawable.l_arm_wear_1},
                {R.drawable.r_arm_wear_2, R.drawable.l_arm_wear_2},
                {R.drawable.r_arm_wear_3, R.drawable.l_arm_wear_3},
                {R.drawable.r_arm_wear_5, R.drawable.l_arm_wear_5},
                {R.drawable.r_arm_wear_6, R.drawable.l_arm_wear_6},
                {R.drawable.r_arm_wear_7, R.drawable.l_arm_wear_7},
                {R.drawable.r_arm_wear_8, R.drawable.l_arm_wear_8}, {R.drawable.r_arm_wear_9, R.drawable.l_arm_wear_9},
                {R.drawable.r_arm_wear_10, R.drawable.l_arm_wear_10}, {R.drawable.r_arm_wear_11, R.drawable.l_arm_wear_11},
                {R.drawable.r_arm_wear_12, R.drawable.l_arm_wear_12}, {R.drawable.r_arm_wear_13, R.drawable.l_arm_wear_13},
                {R.drawable.r_arm_wear_14, R.drawable.l_arm_wear_14},{0, 0}};

        shoulder_r_l_wear_image_id_list = new int[][] {{R.drawable.r_shoulder_wear_1, R.drawable.l_shoulder_wear_1},
                {R.drawable.r_shoulder_wear_2, R.drawable.l_shoulder_wear_2},
                {R.drawable.r_shoulder_wear_3, R.drawable.l_shoulder_wear_3},
                {R.drawable.r_shoulder_wear_4, R.drawable.l_shoulder_wear_4},
                {R.drawable.r_shoulder_wear_5, R.drawable.l_shoulder_wear_5},
                {R.drawable.r_shoulder_wear_6, R.drawable.l_shoulder_wear_6},
                {R.drawable.r_shoulder_wear_7, R.drawable.l_shoulder_wear_7},
                {R.drawable.r_shoulder_wear_8, R.drawable.l_shoulder_wear_8},
                {R.drawable.r_shoulder_wear_9, R.drawable.l_shoulder_wear_9},
                {R.drawable.r_shoulder_wear_10, R.drawable.l_shoulder_wear_10},
                {R.drawable.r_shoulder_wear_11, R.drawable.l_shoulder_wear_11},
                {R.drawable.r_shoulder_wear_12, R.drawable.l_shoulder_wear_12},
                {R.drawable.r_shoulder_wear_13, R.drawable.l_shoulder_wear_13},
                {R.drawable.r_shoulder_wear_14, R.drawable.l_shoulder_wear_14},
                {R.drawable.r_shoulder_wear_15, R.drawable.l_shoulder_wear_15}, {0, 0}};

        bottom_wear_image_id_list = new int[] {R.drawable.bottom_wear_1, R.drawable.bottom_wear_2,
                R.drawable.bottom_wear_3, R.drawable.bottom_wear_4, R.drawable.bottom_wear_5, R.drawable.bottom_wear_6, 0};

        leg_r_l_wear_image_id_list = new int[][] {{R.drawable.r_leg_wear_1, R.drawable.l_leg_wear_1},
            {R.drawable.r_leg_wear_2, R.drawable.r_leg_wear_2},
            {R.drawable.r_leg_wear_3, R.drawable.r_leg_wear_3},
            {R.drawable.r_leg_wear_4, R.drawable.r_leg_wear_4},
            {R.drawable.r_leg_wear_5, R.drawable.r_leg_wear_5},
            {R.drawable.r_leg_wear_7, R.drawable.r_leg_wear_7},
            {R.drawable.r_leg_wear_8, R.drawable.r_leg_wear_8},
            {R.drawable.r_leg_wear_10, R.drawable.r_leg_wear_10},
            {R.drawable.r_leg_wear_11, R.drawable.r_leg_wear_11},
            {R.drawable.r_leg_wear_13, R.drawable.r_leg_wear_13},
                {R.drawable.r_leg_wear_14, R.drawable.r_leg_wear_14},
                {R.drawable.r_leg_wear_15, R.drawable.r_leg_wear_15}, {0, 0}};

        thigh_r_l_wear_image_id_list = new int[][] {{R.drawable.r_thigh_wear_1, R.drawable.l_thigh_wear_1},
                {R.drawable.r_thigh_wear_2, R.drawable.l_thigh_wear_2},
                {R.drawable.r_thigh_wear_3, R.drawable.l_thigh_wear_3},
                {R.drawable.r_thigh_wear_4, R.drawable.r_thigh_wear_4},
                {R.drawable.r_thigh_wear_6, R.drawable.r_thigh_wear_6},
                {R.drawable.r_thigh_wear_7, R.drawable.r_thigh_wear_7},
                {R.drawable.r_thigh_wear_8, R.drawable.r_thigh_wear_8},
                {R.drawable.r_thigh_wear_10, R.drawable.r_thigh_wear_10},
                {R.drawable.r_thigh_wear_11, R.drawable.r_thigh_wear_11},
                {R.drawable.r_thigh_wear_13, R.drawable.r_thigh_wear_13},
                {R.drawable.r_thigh_wear_14, R.drawable.r_thigh_wear_14}, {0, 0}};

        foot_r_l_wear_image_id_list = new int[][] {{R.drawable.r_foot_wear_1, R.drawable.l_foot_wear_1},
                {R.drawable.r_foot_wear_2, R.drawable.l_foot_wear_2},
                {R.drawable.r_foot_wear_3, R.drawable.l_foot_wear_3},
                {R.drawable.r_foot_wear_4, R.drawable.l_foot_wear_4},
                {R.drawable.r_foot_wear_5, R.drawable.l_foot_wear_5},
                {R.drawable.r_foot_wear_6, R.drawable.l_foot_wear_6},
                {R.drawable.r_foot_wear_7, R.drawable.l_foot_wear_7},
                {R.drawable.r_foot_wear_8, R.drawable.l_foot_wear_8},
                {R.drawable.r_foot_wear_9, R.drawable.l_foot_wear_9},
                {R.drawable.r_foot_wear_10, R.drawable.l_foot_wear_10},
                {R.drawable.r_foot_wear_11, R.drawable.l_foot_wear_11}, {0, 0}};

        foot_r_l_wear_image_id_list = new int[][] {{R.drawable.r_foot_wear_1, R.drawable.l_foot_wear_1},
                {R.drawable.r_foot_wear_2, R.drawable.l_foot_wear_2},
                {R.drawable.r_foot_wear_3, R.drawable.l_foot_wear_3},
                {R.drawable.r_foot_wear_4, R.drawable.l_foot_wear_4},
                {R.drawable.r_foot_wear_5, R.drawable.l_foot_wear_5},
                {R.drawable.r_foot_wear_6, R.drawable.l_foot_wear_6},
                {R.drawable.r_foot_wear_7, R.drawable.l_foot_wear_7},
                {R.drawable.r_foot_wear_8, R.drawable.l_foot_wear_8},
                {R.drawable.r_foot_wear_9, R.drawable.l_foot_wear_9},
                {R.drawable.r_foot_wear_10, R.drawable.l_foot_wear_10},
                {R.drawable.r_foot_wear_11, R.drawable.l_foot_wear_11}, {0, 0}};

        chest_image_id_list = new int[] {R.drawable.chest_1, R.drawable.chest_2,
                R.drawable.chest_3, R.drawable.chest_4, R.drawable.chest_5, R.drawable.chest_6,
                R.drawable.chest_7, R.drawable.chest_8, R.drawable.chest_9};



    }

}


