package com.example.obliq;

public class Marks {

    private String StudentID;
    private Double Physics;
    private Double Chemistry;
    private Double BioMaths;
    //private Double Average;

    public Marks() {
    }

    public Marks(String studentID, Double physics, Double chemistry, Double bioMaths) {
        StudentID = studentID;
        Physics = physics;
        Chemistry = chemistry;
        BioMaths = bioMaths;
        /*Average = average;*/
    }

    //setters
    public void setStudentID(String studentID) {

        StudentID = studentID;
    }

    public void setPhysics(Double physics) {

        Physics = physics;
    }

    public void setChemistry(Double chemistry) {

        Chemistry = chemistry;
    }

    public void setBioMaths(Double biomaths) {

        BioMaths = biomaths;
    }

    /*public void setAverage(Double physics, Double chemistry, Double bioMaths){
        Average = ((physics+chemistry+bioMaths)/3);
    }*/


    //getters
    public String getStudentID(){

        return StudentID;
    }

    public Double getPhysics() {

        return Physics;
    }

    public Double getChemistry() {

        return Chemistry;
    }

    public Double getBioMaths() {

        return BioMaths;
    }

    /*public Double getAverage() {

        return Average;
    }*/
}
