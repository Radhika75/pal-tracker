package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry);
    TimeEntry find(long id);
    List<TimeEntry> list();
    TimeEntry update(long id, TimeEntry timeEntry);
    void delete(long id);
}
