package com.example.mountains.cmd;

import com.example.mountains.peak.dto.PutPeakRequest;
import com.example.mountains.range.controller.api.RangeController;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.example.mountains.peak.controller.api.PeakController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommand implements CommandLineRunner {
    private final PeakController peakController;
    private final RangeController rangeController;
    private final ObjectWriter writer;

    @Autowired
    public ApplicationCommand(PeakController peakController, RangeController rangeController, ObjectWriter writer){
        this.peakController = peakController;
        this.rangeController = rangeController;
        this.writer = writer;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while(true){
            command = scanner.next();
            switch (command){
                case "get_peaks" ->
                    System.out.println(writer.writeValueAsString(peakController.getPeaks()));
                case "get_range_peaks" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    try{
                        System.out.println(writer.writeValueAsString(peakController.getRangePeaks(uuid)));
                    }
                    catch(NoSuchElementException ex){
                        System.out.println("NOT_FOUND");
                    }
                }
                case "get_range_peak" -> {
                    UUID rangeId = UUID.fromString(scanner.next());
                    UUID peakId = UUID.fromString(scanner.next());
                    try{
                        System.out.println(writer.writeValueAsString(peakController.getRangePeak(rangeId, peakId)));
                    }catch (NoSuchElementException ex){
                        System.out.println("NOT_FOUND");
                    }
                }
                case "get_peak" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    try{
                        System.out.println(writer.writeValueAsString(peakController.getPeak(uuid)));
                    }catch (NoSuchElementException ex){
                        System.out.println("NOT_FOUND");
                    }
                }
                case "delete_peak" -> {
                    try{
                        UUID uuid = UUID.fromString(scanner.next());
                        peakController.deletePeak(uuid);
                    }catch (NoSuchElementException ex){
                        System.out.println("NOT_FOUND");
                    }
                }
                case "put_peak" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    PutPeakRequest request = PutPeakRequest.builder()
                            .name(scanner.next())
                            .height(scanner.nextDouble())
                            .build();
                    try{
                        peakController.putPeak(uuid, request);
                    }
                    catch (IllegalArgumentException ex){
                        System.out.println("BAD_REQUEST");
                    }
                }
                case "put_range_peak" -> {
                    UUID rangeId = UUID.fromString(scanner.next());
                    UUID peakId = UUID.fromString(scanner.next());
                    PutPeakRequest request = PutPeakRequest.builder()
                            .name(scanner.next())
                            .height(scanner.nextDouble())
                            .build();
                    try{
                        peakController.putRangePeak(rangeId, peakId, request);
                    }catch (NoSuchElementException ex){
                        System.out.println(ex.getMessage());
                    }
                }
                case "get_ranges" -> System.out.println(writer.writeValueAsString(rangeController.getRanges()));
                case "get_range_by_name" -> {
                    String name = scanner.next();
                    System.out.println(writer.writeValueAsString(rangeController.getRange(name)));
                }
                case "quit" -> {
                    break main_loop;
                }
            }
        }
    }
}
