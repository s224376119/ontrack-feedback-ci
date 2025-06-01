package ontrack_test;

import org.junit.Test;

import ontrack.FeedbackSummary;
import ontrack.FeedbackSummaryService;

import static org.junit.Assert.*;
import java.util.List;

public class FeedbackSummaryTest {

    @Test
    public void testGetFeedbackSummaryForExistingStudent() {
        FeedbackSummary summary = FeedbackSummaryService.getFeedbackSummary("S101");

        assertEquals(3, summary.getTotalTasks());
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
