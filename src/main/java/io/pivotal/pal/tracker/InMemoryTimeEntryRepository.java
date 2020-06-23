package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> map = new HashMap<Long, TimeEntry>();
    private long counter = 1;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(counter);
        counter++;
        map.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return map.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(map.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry te = map.get(id);
        if ( te != null ) {
            timeEntry.setId(id);
            map.replace(id, timeEntry);
            return timeEntry;
        }
        return null;
    }

    @Override
    public void delete(long id) {
        map.remove(id);
    }
}
