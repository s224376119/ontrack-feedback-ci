package ontrack_test;



import ontrack.FeedbackSummary;
import ontrack.FeedbackSummaryService;
import org.junit.Test;
import static org.junit.Assert.*;

public class FeedbackSummaryTest {

    @Test
    public void testGetFeedbackSummaryForExistingStudent() {
        FeedbackSummary summary = FeedbackSummaryService.getFeedbackSummary("S101");

        // ✅ These are correct values, but we'll make one fail intentionally
        // Original (correct): assertEquals(3, summary.getTotalTasks());
        // Force failure:
        assertEquals(999, summary.getTotalTasks());  // ❌ Intentionally wrong

        assertTrue(summary.getPositiveMentions().contains("well-structured"));
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
