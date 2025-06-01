package ontrack;

import java.util.*;

public class FeedbackSummaryService {

    private static final Map<String, List<String>> feedbackDatabase = new HashMap<>();

    static {
        feedbackDatabase.put("S101", Arrays.asList(
                "Well-structured report, but poor referencing.",
                "Excellent analysis. Poor referencing again.",
                "Well-structured and well-researched work."
        ));
    }

    public static FeedbackSummary getFeedbackSummary(String studentId) {
        List<String> feedbacks = feedbackDatabase.getOrDefault(studentId, new ArrayList<>());

        Set<String> positives = new HashSet<>();
        Set<String> improvements = new HashSet<>();

        List<String> positiveKeywords = Arrays.asList(
                "well-structured", "good analysis", "well-researched", "excellent analysis");
        List<String> improvementKeywords = Arrays.asList(
                "poor referencing", "weak conclusion", "unclear argument");

        for (String feedback : feedbacks) {
            String lower = feedback.toLowerCase();

            for (String keyword : positiveKeywords) {
                if (lower.contains(keyword)) positives.add(keyword);
            }

            for (String keyword : improvementKeywords) {
                if (lower.contains(keyword)) improvements.add(keyword);
            }
        }

        return new FeedbackSummary(feedbacks.size(),
                new ArrayList<>(positives),
                new ArrayList<>(improvements));
    }
}
