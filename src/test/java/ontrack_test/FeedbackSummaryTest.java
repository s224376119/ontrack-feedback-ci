package ontrack_test;

import ontrack.FeedbackSummary;
import ontrack.FeedbackSummaryService;
import org.junit.Test;
import static org.junit.Assert.*;

public class FeedbackSummaryTest {

    @Test
    public void testGetFeedbackSummaryForExistingStudent() {
        FeedbackSummary summary = FeedbackSummaryService.getFeedbackSummary("S101");

        // ✅ Matches the actual size of feedback entries in the database
        assertEquals(3, summary.getTotalTasks());

        // ✅ Positive feedback keywords expected in the feedback database
        assertTrue(summary.getPositiveMentions().contains("well-structured"));
        assertTrue(summary.getPositiveMentions().contains("excellent analysis"));
        assertTrue(summary.getPositiveMentions().contains("well-researched"));

        // ✅ Improvement keywords expected in the feedback database
        assertTrue(summary.getAreasToImprove().contains("poor referencing"));
    }

    @Test
    public void testGetFeedbackSummaryForUnknownStudent() {
        FeedbackSummary summary = FeedbackSummaryService.getFeedbackSummary("S999");

        assertEquals(0, summary.getTotalTasks());
        assertEquals(0, summary.getPositiveMentions().size());
        assertEquals(0, summary.getAreasToImprove().size());
    }
}
