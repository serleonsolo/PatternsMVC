package com.patterns.usage.behavioral.iterator;

import com.patterns.usage.AbstractPatternUsage;
import com.patterns.utils.PatternHelper;

public class IteratorUsage extends AbstractPatternUsage {

    public IteratorUsage() {
        this.description = "Шаблон — это способ доступа к элементам объекта без раскрытия базового представления.\n";
        ;
    }

    @Override
    public void demonstrate() {

        StationList stationList = new StationList();
        stationList.add(new RadioStation(100.1f));
        stationList.add(new RadioStation(101.1f));
        stationList.add(new RadioStation(102.1f));
        stationList.remove();

        stationList.reset();

        PatternHelper.print("Print Frequencies");
        while(stationList.hasNext())
        {
            RadioStation radioStation = (RadioStation) stationList.next();
            if(radioStation == null)
                PatternHelper.print(" Empty Frequency");
            else
                PatternHelper.print(" Play Frequency " + radioStation.frequency);
        }
    }
}
