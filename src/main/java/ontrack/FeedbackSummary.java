package ontrack;

import java.util.List;

public class FeedbackSummary {
    private int totalTasks;
    private List<String> positiveMentions;
    private List<String> areasToImprove;

    public FeedbackSummary(int totalTasks, List<String> positiveMentions, List<String> areasToImprove) {
        this.totalTasks = totalTasks;
        this.positiveMentions = positiveMentions;
        this.areasToImprove = areasToImprove;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public List<String> getPositiveMentions() {
        return positiveMentions;
    }

    public List<String> getAreasToImprove() {
        return areasToImprove;
    }
}
