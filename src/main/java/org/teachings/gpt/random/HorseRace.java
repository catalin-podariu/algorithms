package org.teachings.gpt.random;

import java.text.DecimalFormat;
import java.util.*;

public class HorseRace {

    /*
     * There are 25 mechanical horses and a single racetrack.
     * Each horse completes the track in a pre-programmed time, and the horses all have
     * different finishing times, unknown to you. You can race 5 horses at a time.
     * After a race is over, you get a printout with the order the horses finished,
     * but not the finishing times of the horses.
     *
     * What is the minimum number of races you need to identify the fastest 3 horses?
     */
    private static final String[] HORSE_NAMES = {
            "Garry", "Bolt", "Shadow", "Flash", "Storm",
            "Whirl", "Rocket", "Arrow", "Comet", "Blaze",
            "Kate", "Dart", "Zephyr", "Sonic", "Fury",
            "Porky", "Wraith", "Pacer", "Streak", "Dash",
            "Breeze", "Gale", "Jetson", "Bullet", "Stream"
    };

    public static void main(String[] args) {
        new HorseRace().start();
    }

    private void start() {
        List<List<Horse>> initialRaces = generateInitialRaceTimes();

        System.out.println("Initial race");
        // Step 1: Run initial races and sort horses in each race
        for (List<Horse> item : initialRaces) {
            sortHorsesByTime(item);
            System.out.println(Arrays.toString(item.toArray()));
        }

        // Step 2: Run the Race of Champions
        Set<Horse> uniqueChampions = new HashSet<>();
        for (List<Horse> race : initialRaces) {
            uniqueChampions.add(race.get(0));  // Get winners from each group
        }

        System.out.println("\nRace of the champions");
        List<Horse> champions = new ArrayList<>(uniqueChampions);
        sortHorsesByTime(champions);
        System.out.println(Arrays.toString(champions.toArray()));

        // Get top 3 champions
        Horse fastest = champions.get(0);
        List<Horse> candidatesForFinalRace = new ArrayList<>(
                getSecondAndThirdChampions(champions, initialRaces));

        // Step 4: Run the final race to determine 2nd and 3rd fastest horses
        sortHorsesByTime(candidatesForFinalRace);
        System.out.println(Arrays.toString(candidatesForFinalRace.toArray()));

        Horse secondFastest = candidatesForFinalRace.get(0);
        Horse thirdFastest = candidatesForFinalRace.get(1);

        // Results
        System.out.println("\n\n###### AND THE CHAMPIONS ARE ######");
        System.out.println("FIRST place:    " + fastest.name());
        System.out.println("SECOND place:   " + secondFastest.name());
        System.out.println("THIRD place:    " + thirdFastest.name());
    }

    private List<Horse> getSecondAndThirdChampions(List<Horse> champions,
                                                          List<List<Horse>> initialRaces) {
        HashSet<Horse> uniqueCandidates = new HashSet<>();

        for (List<Horse> race : initialRaces) {
            if (race.contains(champions.get(0))
                    || race.contains(champions.get(1))
                    || race.contains(champions.get(2))) {
                uniqueCandidates.add(race.get(1));
                uniqueCandidates.add(race.get(2));
            }
        }

        List<Horse> candidatesForFinalRace = new ArrayList<>(uniqueCandidates);
        candidatesForFinalRace.add(champions.get(1));
        candidatesForFinalRace.add(champions.get(2));

        candidatesForFinalRace.sort(Comparator.comparingDouble(Horse::time));

        // Trim the list to ensure only 5 horses participate in the final race
        while (candidatesForFinalRace.size() > 5) {
            candidatesForFinalRace.remove(candidatesForFinalRace.size() - 1);
        }

        return candidatesForFinalRace;
    }

    private void sortHorsesByTime(List<Horse> horses) {
        horses.sort(Comparator.comparingDouble(Horse::time));
    }

    private List<List<Horse>> generateInitialRaceTimes() {
        List<List<Horse>> races = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("####0.000");
//        Random rand = new Random(31); // use fixed seed for debugging

        int nameIndex = 0;
        for (int i = 0; i < 5; i++) {
            List<Horse> horses = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                horses.add(
                        new Horse(Double.parseDouble(df.format(new Random().nextDouble())),
                        HORSE_NAMES[nameIndex++]));
            }
            races.add(horses);
        }
        return races;
    }
}

record Horse(double time, String name) implements Comparable<Horse> {

    @Override
    public int compareTo(Horse other) {
        return Double.compare(this.time, other.time);
    }

    @Override
    public String toString() {
        return String.format("[%s],\t\ttime [%s]", name, time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Double.compare(time, horse.time) == 0 && Objects.equals(name, horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, name);
    }
}

/*
 * Initialization: Generate 25 horses with random but unique times and names.
 * Group them into 5 races with 5 horses each.
 * <\br>
 * Initial Races: Run the 5 initial races, each with 5 horses. After each race,
 * the horses are sorted by their times, though the times aren't disclosed.
 * <\br>
 * Race of Champions: Take the fastest horse from each of the initial 5 races and
 * race them together. Again, sort these "champions."
 * <\br>
 * Candidate Selection: Pick the top 3 from the Race of Champions. For each of these,
 * add the 2nd and 3rd fastest horses from their original races into a candidate pool.
 * This candidate pool is de-duplicated and trimmed down to only the 5 fastest horses.
 * <\br>
 * Final Race: Run a race with these 5 candidates to find the 2nd and 3rd fastest
 * horses overall. The fastest from the Race of Champions remains the fastest overall.
 * <\br>
 * Result: Announce the top 3 horses—fastest from the Race of Champions, and the
 * top 2 from the final candidate race.
 */
