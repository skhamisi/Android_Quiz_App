package com.example.quizapproadsigns;

public class Questions {

    private String images [] = {
            "stop_sign",
            "divided_highway",
            "exit_only",
            "warning_sign",
            "yield_sign",
            "do_not_enter_sign",
            "no_u_turn_sign",
            "road_curves_ahead",
            "freeway_expressway",
            "railroad_crossing"
    };

    protected String questions[] = {
            "When you see this sign, you must: ",
            "This sign means?",
            "If you see this sign above your lane: ",
            "The yellow and black diamond shaped sign does what?",
            "This is the shape and color of a _______ sign.",
            "This sign means:",
            "This sign means:",
            "This sign is used to warn drivers about:",
            "Freeway and expressway guide signs are:",
            "If there are no signals at a railroad crossing, you should:"
    };

    private String choices[][] = {

            {
                "Stop completely, check for pedestrians, and cross traffic",
                "Slow down without coming to a complete stop",
                "Stop completely and wait for a green light",
                "Slow down and check for traffic"},
            {
                "You must turn left or right",
                "You're approaching a T intersection",
                "The road that you are on intersects with a divided highway",
                "Designates an overpass above a divided highway"},
            {
                "You may not exit the freeway in this lane",
                "You may continue through the interchange or exit the freeway",
                "You may stay in this lane and continue through the interchange",
                "You must exit this freeway if you stay in this lane"},
            {
                "Warns you about conditions on or near the road",
                "Helps direct you to cities and towns ahead",
                "Tells you about traffic laws and regulations",
                "Tells you about road conditions ahead"},
            {
                "Stop",
                "Wrong way",
                "Yield",
                "Do not enter"},
            {
                "Stop",
                "No U-Turn",
                "Yield",
                "Do Not Enter"},
            {
                "No U-Turn",
                "No Turning",
                "No Left turn",
                "No right turn"
            },
            {
                "Upcoming intersections",
                "Road construction",
                "Road curves ahead",
                "Changes in traffic lanes"
            },
            {
                "Orange with black letters",
                "Green with white letters",
                "Yellow with black letters",
                "Red with white letters"
            },
            {
                "Slow down and prepare to stop if you see or hear a train approaching",
                "Proceed as quickly as possible over the tracks",
                "Proceed through the crossing at a normal rate",
                "Proceed slowly over the tracks"
            }
    };
    private String correctAnswers[] = {
            "Stop completely, check for pedestrians, and cross traffic",
            "The road that you are on intersects with a divided highway",
            "You must exit this freeway if you stay in this lane",
            "Warns you about conditions on or near the road",
            "Yield",
            "Do Not Enter",
            "No U-Turn",
            "Road curves ahead",
            "Green with white letters",
            "Slow down and prepare to stop if you see or hear a train approaching"


    };

    public String getImage(int a) {
        String image = images[a];
        return image;
    }
    public String getQuestion(int a) {
        String question = questions[a];
        return question;
    }
    public String getChoice1(int a) {
        String choice0 = choices[a][0];
        return choice0;
    }
    public String getChoice2(int a) {
        String choice1 = choices[a][1];
        return choice1;
    }
    public String getChoice3(int a) {
        String choice2 = choices[a][2];
        return choice2;
    }
    public String getChoice4(int a) {
        String choice3 = choices[a][3];
        return choice3;
    }
    public String getCorrectAnswer(int a) {
        String answer = correctAnswers[a];
        return answer;
    }
}
