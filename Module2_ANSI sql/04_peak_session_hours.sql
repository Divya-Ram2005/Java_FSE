SELECT event_id, COUNT(*) AS peak_sessions
FROM Sessions
WHERE TIME(start_time) BETWEEN '10:00:00' AND '11:59:59'
GROUP BY event_id;