 // src/main/java/model/Question.java
package model;

public class Question {
    private int id;
    private String title;
    private String questionText;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private int correctChoice;
    private int createdBy;

    public Question(int id, String title, String questionText, String choice1, String choice2,
                    String choice3, String choice4, int correctChoice, int createdBy) {
        this.id = id;
        this.title = title;
        this.questionText = questionText;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.correctChoice = correctChoice;
        this.createdBy = createdBy;
    }

    // getter/setter...
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getQuestionText() { return questionText; }
    public String getChoice1() { return choice1; }
    public String getChoice2() { return choice2; }
    public String getChoice3() { return choice3; }
    public String getChoice4() { return choice4; }
    public int getCorrectChoice() { return correctChoice; }
    public int getCreatedBy() { return createdBy; }
}
