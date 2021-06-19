package lmm.intern.qrioustech.uwu.Model;

public class FeedbackModel {
    String fname;
    int pimage;
    String feedback;

    public FeedbackModel(String fname, int pimage, String feedback) {
        this.fname = fname;
        this.pimage = pimage;
        this.feedback = feedback;
    }

    public FeedbackModel(int pimage) {
        this.pimage = pimage;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getPimage() {
        return pimage;
    }

    public void setPimage(int pimage) {
        this.pimage = pimage;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
