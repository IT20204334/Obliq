package com.example.obliq;

public class Question {

    private String Qaname;
    private String Question;
    private String Qsid;


    public Question(){
    }

    public Question(String question,String qaname){
        Question = question;
        Qaname = qaname;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getQsid() {return Qsid;}

    public void setQsid(String qsid) {Qsid = qsid;}

    public String getQaname() {return Qaname;}

    public void setQaname(String qaname) {Qaname = qaname;}
}
