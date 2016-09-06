package com.maptag.location;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Location;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapTagUtil {
    private final File database;
    private static DatabaseReader reader;

    public MapTagUtil() throws IOException {
        database = new File(getClass().getResource("/GeoLite2-City.mmdb").toString());
        reader = new DatabaseReader.Builder(database).build();
    }



    public ServerCoordinates getCoordinatesOfIP(String adress) throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(adress);
        CityResponse response = reader.city(ipAddress);
        Location location = response.getLocation();

        return new ServerCoordinates(location.getLatitude(), location.getLongitude());
    }

    public ArrayList<ServerCoordinates> getCoordinatesFromFolder(String addressesFolder) throws IOException, GeoIp2Exception {
        ArrayList<ServerCoordinates> resultCoordinates = new ArrayList<>();
        List<Path> a = new ArrayList<>();

        List<File> adddressesFiles = Files.walk(Paths.get(addressesFolder))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());

        for (File file : adddressesFiles) {

            List<String> lines = Files.readAllLines(file.toPath(), Charset.forName("UTF-8"));

            for (String line : lines) {
                resultCoordinates.add(getCoordinatesOfIP(line));
            }
        }
        return resultCoordinates;
    }
}
