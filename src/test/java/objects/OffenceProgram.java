package objects;

import java.util.ArrayList;

public final class OffenceProgram {
    public static ArrayList<OffenceProgram> program;

    private String nextBuilding;
    private int level;
    private String buildingName;

    public String getNextBuilding() {
        return nextBuilding;
    }
    public int getLevel() {
        return level;
    }
    public String getBuildingName() { return buildingName; }


    private OffenceProgram(String nextBuilding, int level, String buildingName) {
        this.nextBuilding = nextBuilding;
        this.level = level;
        this.buildingName = buildingName;
    }

    static {
        program = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            program.add(new OffenceProgram("main_buildlink_wood_" + i, i, "wood"));
            program.add(new OffenceProgram("main_buildlink_stone_" + i, i, "stone"));
            program.add(new OffenceProgram("main_buildlink_iron_" + i, i, "iron"));
        }

            program.add(new OffenceProgram("main_buildlink_farm_1", 1, "farm"));
            program.add(new OffenceProgram("main_buildlink_farm_2", 2, "farm"));
            program.add(new OffenceProgram("main_buildlink_farm_3", 3, "farm"));

        for (int i = 0; i < 7; i++) {
            program.add(new OffenceProgram("main_buildlink_storage_" + i, i, "storage"));
        }

        for (int i = 0; i < 10; i++) {
            program.add(new OffenceProgram("main_buildlink_wood_" + i, i, "wood"));
            program.add(new OffenceProgram("main_buildlink_stone_" + i, i, "stone"));
            program.add(new OffenceProgram("main_buildlink_iron_" + i, i, "iron"));
        }

        for (int i = 7; i < 14; i++) {
            program.add(new OffenceProgram("main_buildlink_storage_" + i, i, "storage"));
        }

        program.add(new OffenceProgram("main_buildlink_main_2",2, "main"));
        program.add(new OffenceProgram("main_buildlink_main_3",3, "main"));
        program.add(new OffenceProgram("main_buildlink_main_4",4, "main"));
        program.add(new OffenceProgram("main_buildlink_main_5",5, "main"));

        program.add(new OffenceProgram("main_buildlink_barracks_1",1, "barracks"));
        program.add(new OffenceProgram("main_buildlink_barracks_2",2, "barracks"));
        program.add(new OffenceProgram("main_buildlink_barracks_3",3, "barracks"));
        program.add(new OffenceProgram("main_buildlink_barracks_4",4, "barracks"));
        program.add(new OffenceProgram("main_buildlink_barracks_5",5, "barracks"));

        program.add(new OffenceProgram("main_buildlink_smith_1",1, "smith"));
        program.add(new OffenceProgram("main_buildlink_smith_2",2, "smith"));
        program.add(new OffenceProgram("main_buildlink_smith_3",3, "smith"));
        program.add(new OffenceProgram("main_buildlink_smith_4",4, "smith"));
        program.add(new OffenceProgram("main_buildlink_smith_5",5, "smith"));

        program.add(new OffenceProgram("main_buildlink_main_6",6, "main"));
        program.add(new OffenceProgram("main_buildlink_main_7",7, "main"));
        program.add(new OffenceProgram("main_buildlink_main_8",8, "main"));
        program.add(new OffenceProgram("main_buildlink_main_9",9, "main"));
        program.add(new OffenceProgram("main_buildlink_main_10",10, "main"));

        program.add(new OffenceProgram("main_buildlink_stable_1",1, "stable"));
    }
}
