import objects.FarmVillage;

import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

final class VillageDownloaderClass {
    private static String link = "https://ru62.voyna-plemyon.ru/map/village.txt";
    private static ArrayList<FarmVillage> farmVillageList;

    public static ArrayList<FarmVillage> getFarmVillageList() {
        return farmVillageList;
    }

    static void getFile() throws IOException {
        URL website = new URL(link);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("village.txt");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        getList();
    }

    private static void getList() throws FileNotFoundException {
        File village = new File("village.txt");
        farmVillageList = new ArrayList<>();
        Scanner sc = new Scanner(village);
        while (sc.hasNext()) {
            String[] villageString = sc.nextLine().split(",");
            farmVillageList.add(new FarmVillage(
                    encode(villageString[1]), //name
                    Integer.parseInt(villageString[2]), //X
                    Integer.parseInt(villageString[3]), //Yё
                    villageString[4], //userID
                    Integer.parseInt(villageString[5]), //Points
                    villageString[6])); //Type
        }
    }

    private static String encode (String name) {
        return URLDecoder.decode(name, StandardCharsets.US_ASCII).toString();
    }
}
