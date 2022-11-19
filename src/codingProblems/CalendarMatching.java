package codingProblems;

import java.util.ArrayList;
import java.util.List;

class CalendarMatching {
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {


        List<IntMeeting> convertedCal1 = convertCal(calendar1, dailyBounds1);
        List<IntMeeting> convertedCal2 = convertCal(calendar2, dailyBounds2);
        List<IntMeeting> combinedCals = combineCals(convertedCal1, convertedCal2);
        List<IntMeeting> mergedMeetings = mergeMeetings(combinedCals);

        List<StringMeeting> result = new ArrayList<>();
        for(int i = 0; i < mergedMeetings.size()-1; i++){
            int start = mergedMeetings.get(i+1).start;
            int end = mergedMeetings.get(i).end;

            if(start - end >= meetingDuration){
                result.add(new StringMeeting(minsToTime(end), minsToTime(start)));
            };
        }
        return result;
    }


    public static List<IntMeeting> mergeMeetings(List<IntMeeting> meetings){
        List<IntMeeting> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(meetings.get(0));

        for(int i = 1; i < meetings.size(); i++){
            IntMeeting meeting = meetings.get(i);
            IntMeeting currMergedMeeting = mergedMeetings.get(mergedMeetings.size() -1);

            if(meeting.start <= currMergedMeeting.end){
                currMergedMeeting.start = Math.min(currMergedMeeting.start, meeting.start);
                currMergedMeeting.end = Math.max(currMergedMeeting.end, meeting.end);
            }
            else mergedMeetings.add(meeting);
        }

        return mergedMeetings;
    }

    public static List<IntMeeting> combineCals(List<IntMeeting> cal1, List<IntMeeting> cal2){
        List<IntMeeting> mergedIntMeetings = new ArrayList<>();
        int i = 0, j = 0;

        while(i < cal1.size() || j < cal2.size()){
            if(i >= cal1.size()){ mergedIntMeetings.add(cal2.get(j)); j++; continue;}
            if(j >= cal2.size()){ mergedIntMeetings.add(cal1.get(i)); i++; continue;}

            if(cal1.get(i).start < cal2.get(j).start){ mergedIntMeetings.add(cal1.get(i)); i++;}
            else { mergedIntMeetings.add(cal2.get(j)); j++;}
        }
        return mergedIntMeetings;
    }

    public static int timeToMins(String time){
        int delimiterPos = time.indexOf(":");
        int hours = Integer.parseInt(time.substring(0, delimiterPos));
        int mins = Integer.parseInt(time.substring(delimiterPos +1, time.length()));
        return hours * 60 + mins;
    }

    public static String minsToTime(int minutes){
        int hours = minutes / 60;
        int mins = minutes % 60;

        String hoursString = Integer.toString(hours);
        String minutesString = mins < 10 ? "0" + Integer.toString(mins) : Integer.toString(mins);
        return hoursString + ":" + minutesString;
    }

    public static List<IntMeeting> convertCal(List<StringMeeting> cal, StringMeeting bounds){
        IntMeeting firstEntry = new IntMeeting(timeToMins("0:00"), timeToMins(bounds.start));
        List<IntMeeting> convertedCal = new ArrayList<>();
        convertedCal.add(firstEntry);

        cal.forEach((meeting) -> {
            IntMeeting intMeeting = new IntMeeting(timeToMins(meeting.start), timeToMins(meeting.end));
            convertedCal.add(intMeeting);
        });

        IntMeeting lastEntry = new IntMeeting(timeToMins(bounds.end), timeToMins("23:59"));
        convertedCal.add(lastEntry);

        return convertedCal;
    }


    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }

    static class IntMeeting {
        public int start;
        public int end;

        public IntMeeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
