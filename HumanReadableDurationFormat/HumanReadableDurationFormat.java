package com.company;

public class HumanReadableDurationFormat {
    public static String formatDuration(int seconds){
        //Скучные вычисления (был бы способ их сделать короче)
        int[] counts = new int[5];
        counts[0] = seconds / (60 * 60 * 24 * 365); // years
        seconds -= counts[0] * 60 * 60 * 24 * 365;
        counts[1] = seconds / (60 * 60 * 24); // days
        seconds -= counts[1] * 60 * 60 * 24;
        counts[2] = seconds / (60 * 60); // hours
        seconds -= counts[2] * 60 * 60;
        counts[3] = seconds / 60; // minutes
        counts[4] = seconds - counts[3] * 60; // seconds
        int parts = 0;
        for (int count : counts) {
            parts += count > 0 ? 1 : 0; //люблю тернарники:3
        }
        if(parts == 0){
            return "now";
        }
        else{
            StringBuilder result = new StringBuilder();
            for(int i = 0; i<counts.length; i++){
                if(counts[i] > 0){
                    result.append(counts[i]);
                    //как это блин криво но сейчас голова не варит сделать иначе
                    switch(i){
                        case 0:
                            result.append(" year");
                            break;
                        case 1:
                            result.append(" day");
                            break;
                        case 2:
                            result.append(" hour");
                            break;
                        case 3:
                            result.append(" minute");
                            break;
                        case 4:
                            result.append(" second");
                            break;
                    }
                    if(counts[i] > 1) result.append("s");
                    parts--;
                    if(parts == 0){
                        break;
                    }
                    else if(parts > 1){
                        result.append(", ");
                    }
                    else if(parts == 1){
                        result.append(" and ");
                    }
                }
            }
            return result.toString();
        }
    }
}
