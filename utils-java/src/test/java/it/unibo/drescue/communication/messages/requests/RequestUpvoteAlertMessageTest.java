package it.unibo.drescue.communication.messages.requests;

import it.unibo.drescue.communication.messages.MessageType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RequestUpvoteAlertMessageTest {

    private static final int USER_ID = 12345;
    private static final int ALERT_ID = 67890;

    private RequestUpvoteAlertMessageImpl requestUpvoteAlertMessage;

    @Before
    public void init() {
        this.requestUpvoteAlertMessage = new RequestUpvoteAlertMessageImpl(USER_ID, ALERT_ID);
    }

    @Test
    public void checkCorrectUser() {
        assertTrue(this.requestUpvoteAlertMessage.getUserID() == USER_ID);
    }

    @Test
    public void checkCorrectAlert() {
        assertTrue(this.requestUpvoteAlertMessage.getAlertID() == ALERT_ID);
    }

    @Test
    public void checkCorrectType() {
        assertEquals(MessageType.REQUEST_UPVOTE_MESSAGE.getMessageType(), this.requestUpvoteAlertMessage.getMessageType());
    }
}
