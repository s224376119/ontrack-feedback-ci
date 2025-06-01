package ontrack;

import java.util.*;

public class FeedbackSummaryService {

    // Simulated database of feedback comments by student ID
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

        Set<String> positiveMentions = new HashSet<>();
        Set<String> areasToImprove = new HashSet<>();

        // Predefined keywords
        List<String> positiveKeywords = Arrays.asList(
            "well-structured", "good analysis", "well-researched", "excellent analysis"
        );
        List<String> improvementKeywords = Arrays.asList(
            "poor referencing", "weak conclusion", "unclear argument"
        );

        // Analyze each feedback comment
        for (String feedback : feedbacks) {
            String lowerFeedback = feedback.toLowerCase();

            for (String keyword : positiveKeywords) {
                if (lowerFeedback.contains(keyword)) {
                    positiveMentions.add(keyword);
                }
            }

            for (String keyword : improvementKeywords) {
                if (lowerFeedback.contains(keyword)) {
                    areasToImprove.add(keyword);
                }
            }
        }

        // Return a summary object
        return new FeedbackSummary(
            feedbacks.size(),
            new ArrayList<>(positiveMentions),
            new ArrayList<>(areasToImprove)
        );
    }
}
