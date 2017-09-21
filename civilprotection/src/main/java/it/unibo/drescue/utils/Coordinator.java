package it.unibo.drescue.utils;

import it.unibo.drescue.connection.RabbitMQ;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 */
public interface Coordinator {

    /**
     * Set connection to send replay message
     * @param rabbitMQ
     */
    void setConnection (RabbitMQ rabbitMQ);

    /**
     *
     * @return the connection
     */
    RabbitMQ getConnection();

    /**
     *
     * @param condition the process condition
     */
    void setCondition(CoordinatorCondition condition);

    /**
     *
     * @return the process condition
     */
    CoordinatorCondition getCondition();

    /**
     *
     * @param reqTimestamp the timestamp of critical section request
     */
    void setReqTimestamp(Timestamp reqTimestamp);

    /**
     *
     * @return the timestamp of critical section request
     */
    Timestamp getReqTimestamp();

    /**
     *
     * @param ID the precess ID
     */
    void setMyID(String ID);

    /**
     *
     * @return the precess ID
     */
    String  getMyID();

    /**
     *
     * @param csName the name of critical section in which the process wants to enter
     */
    void setCsName(String csName);

    /**
     *
     * @return the name of critical section in which the process wants to enter
     */
    String getCsName();

    /**
     *
     * @param civilProtectionIDs the ID of civil protection
     */
    void createPendingCivilProtectionReplayStructure(List<String> civilProtectionIDs);

    /**
     * Create a structure to persist the other civil protection replay in the face of process request
     * @param civilProtectionID the list ID of the civil protection  from which the process expect an replay message
     */
    void updatePendingCivilProtectionReplayStructure(String civilProtectionID);

    /**
     *
     * @param cpID the id of civil protection that are blocked until the precess came back from critical section
     */
    void addBlockedCP(String cpID);

    /**
     * Send a replay message for that critical section
     * @param csName the critical section name
     */
    void sendReplayMessage(String csName);

    /**
     *
     * @param csName he critical section name
     * @param to the process to which send a replay
     */
    void sendReplayMessageTo(String csName, String to, RescueTeamCondition rescueTeamCondition);

    /**
     *  The process came back to critical section
     */
    void backToCs(RescueTeamCondition rescueTeamCondition);

    void setExchange(String exchange);

}
