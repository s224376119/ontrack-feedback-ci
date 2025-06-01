package ontrack_test;

import ontrack.FeedbackSummary;
import ontrack.FeedbackSummaryService;
import org.junit.Test;
import static org.junit.Assert.*;

public class FeedbackSummaryTest {

    @Test
    public void testGetFeedbackSummaryForExistingStudent() {
        FeedbackSummary summary = FeedbackSummaryService.getFeedbackSummary("S101");

        // ✅ Correct test: should match the database entry for S101
        assertEquals(3, summary.getTotalTasks());

        // ✅ Check positive mentions
        assertTrue(summary.getPositiveMentions().contains("well-structured"));
        assertTrue(summary.getPositiveMentions().contains("excellent analysis"));

        // ✅ Check areas to improve
        assertTrue(summary.getAreasToImprove().contains("poor referencing"));
    }

    @Test
    public void testGetFeedbackSummaryForUnknownStudent() {
        FeedbackSummary summary = FeedbackSummaryService.getFeedbackSummary("S999");

        // ✅ Should be empty summary
        assertEquals(0, summary.getTotalTasks());
        assertEquals(0, summary.getPositiveMentions().size());
        assertEquals(0, summary.getAreasToImprove().size());
    }
}
